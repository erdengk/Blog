

<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<html>
<head>	
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="../res/css/main.css">
</head>
<body>
  <div class="header">
    <div class="menu-btn">
      <div class="menu"></div>
    </div>
    <h1 class="logo">
      <a href="index.html">
        <span>MYBLOG</span>
        <img src="../res/img/logo.png">
      </a>
    </h1>
    <div class="nav">
      <a href="index.html">文章</a>
      <a href="whisper.html">微语</a>
      <a href="leacots.html">留言</a>
      <a href="album.html">相册</a>
      <a href="about.html"  class="active">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
      <li class="layui-nav-item"><a href="index.html" class="active">文章</a></li>
      <li class="layui-nav-item"><a href="whisper.html">未予</a></li>
      <li class="layui-nav-item"><a href="leacots.html">留言</a></li>
      <li class="layui-nav-item"><a href="album.html">相册</a></li>
      <li class="layui-nav-item"><a href="about.html"  class="active">关于</a></li>
    </ul>
    <p class="welcome-text">
      欢迎来到<span class="name">小明</span>的博客
    </p>
  </div>
  <div class="content whisper-content leacots-content details-content">
    <div class="cont w1000">
      <div class="whisper-list">
        <div class="item-box">
          <div class="review-version">
              <div class="form-box">
                <div class="article-cont">
                  <div class="title">
            
                  </div>
                <center><div width="10px" height="30px"><img src="../img/success.png">
					<a href="../../index.jsp"><h1>登录成功,点击返回主页</h1></div></href>
				</center>		  
                </div>
              </div>
          </div>
        </div>
      </div>
      <div id="demo" style="text-align: center;"></div>
    </div>
  </div>
  <div class="footer-wrap">
    <div class="footer w1000">
      <div class="qrcode">
        <img src="../res/img/erweima.jpg">
      </div>
      <div class="practice-mode">
        <img src="../res/img/down_img.jpg">
        <div class="text">
          <h4 class="title">我的联系方式</h4>
          <p>微信<span class="WeChat">1234567890</span></p>
          <p>手机<span class="iphone">1234567890</span></p>
          <p>邮箱<span class="email">1234567890@qq.com</span></p>
        </div>
      </div>
    </div>
  </div>


</body>
</html>