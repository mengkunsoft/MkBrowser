package cn.mkblog.www.mkbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private ProgressBar progressBar;
    private EditText textUrl;
    private ImageView webIcon, goBack, goForward, goHome;
    private Button btnStart;

    private long exitTime = 0;  // 上次按下返回键的时间

    private Context webContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 防止底部按钮上移
        getWindow().setSoftInputMode
                (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                        WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        setContentView(R.layout.activity_web);

        webContext = WebActivity.this;

        // 绑定个各个元素
        bindObj();

        // 执行程序初始化操作
        init();
    }

    // 绑定
    private void bindObj() {
        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textUrl = (EditText) findViewById(R.id.textUrl);
        webIcon = (ImageView) findViewById(R.id.webIcon);
        btnStart = (Button) findViewById(R.id.btnStart);
        goBack = (ImageView) findViewById(R.id.goBack);
        goForward = (ImageView) findViewById(R.id.goForward);
        goHome = (ImageView) findViewById(R.id.goHome);

        textUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // 跳转网址
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(webContext, "加载中...", Toast.LENGTH_SHORT).show();
                    webView.loadUrl(textUrl.getText().toString());
                }
                return false;
            }
        });

        // 跳转|刷新
        btnStart.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
        goHome.setOnClickListener(this);
    }

    // 初始化 WebView
    private void init() {

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 网页开始加载，显示进度条
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);

                // 更新url显示
                textUrl.setText(url);

                // 切换默认网页图标
                webIcon.setImageResource(R.mipmap.ic_launcher);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 网页加载完毕，隐藏进度条
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // 加载进度变动，刷新进度条
                progressBar.setProgress(newProgress);

            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);

                // 改变图标
                webIcon.setImageBitmap(icon);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });

        WebSettings settings = webView.getSettings();
        // 启用 js 功能
        settings.setJavaScriptEnabled(true);

        // 设置浏览器 UserAgent
        settings.setUserAgentString(settings.getUserAgentString() + " mkBrowser/0.1.0");

        // 加载首页
        webView.loadUrl(getResources().getString(R.string.home_url));
    }



    // 返回按钮处理
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {  // 能够返回则返回上一页
            webView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnStart: // 跳转
                webView.loadUrl(textUrl.getText().toString());
                break;

            case R.id.goBack:   // 后退
                webView.goBack();
                break;

            case R.id.goForward:    // 前进
                webView.goForward();
                break;

            case R.id.goHome:   // 主页
                webView.loadUrl(getResources().getString(R.string.home_url));
                break;
        }

    }
}
