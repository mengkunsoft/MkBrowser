# 一个简易的 Android 网页浏览器

![LOGO](https://user-images.githubusercontent.com/16880885/43814276-1c7b3584-9afc-11e8-97c8-1fb71b683930.png)

瞎倒腾着玩的。仅仅是对 WebView 进行了一个简易的封装……有多简易呢？简易到整个工程文件只有一个 Activity，实际的代码不足 400 行~

里边的代码都附上了详细的注释，初学者感兴趣可以参考一下。

无图无真相
----

下面来看看几张实测图……

| 逛B站   | 上淘宝    | 看知乎 |
| ----------- | ----------- | ----------- |
| ![逛B站](https://user-images.githubusercontent.com/16880885/44021643-e45d4992-9f17-11e8-8a14-ae431a90b4b4.png) | ![上淘宝](https://user-images.githubusercontent.com/16880885/44021676-f8189b62-9f17-11e8-8ecf-bb91cc48647f.png) | ![看知乎](https://user-images.githubusercontent.com/16880885/44021699-0a6cf768-9f18-11e8-8be6-eca3574f01b6.png) |

哇塞！居然真的可以用来看网页唉！是不是很牛逼？

目前已有的功能
----
- 浏览网页
- 前进后退，返回首页
- 没了……

目前存在的问题
----
- 播放视频无法全屏
- 无法进行文件上传
- 以及其它 WebView 自带的坑

TODO
----
- 多标签
- 功能设置
- 历史记录
- 隐身模式
- 收藏夹
- 插件
- 云同步
- 广告过滤
- 夜间模式
- 二维码扫描
- 以上纯属瞎编，别指望真会实现……

更新日志
----
#### 2018/8/13 v0.2.0
- 经过一年的学习，技术有点长进了。遂把之前的代码改得稍微规范了些
- 将底部导航栏进行了美容
- 地址栏支持智能识别网址与搜索词（好啦，就是加个正则表达式而已~）
- 换了个有逼格的 LOGO

#### 2017/5/24 v0.1.0
- 刚开始学安卓开发，即兴写了这个练练手，代码凌乱的一批

# License

````
MIT License

Copyright (c) 2018 mengkun

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
````