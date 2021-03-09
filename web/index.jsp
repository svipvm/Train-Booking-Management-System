<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/2/7
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/index.css">
    <title>新创铁路</title>
  </head>
  <body>
    <div id="index-head">
      <span id="index-head-image"><img id="index-logo" src="images/index-logo.png"></span>
      <span id="index-head-text"> 新创铁路 12138<br/>Innovate Railway</span>
      <span id="index-head-hello">欢迎使用，您可以乘坐驶向远方的列车！</span>
      <span id="index-head-call"><img id="index-call" src="images/index-call.png"></span>
      <span id="index-head-num">560xxx12138</span>
    </div>
    <div id="index-box">
      <div class="menu home">
        <a href="content/home.jsp" target="frame-content"><img src="images/home.png"></a>
      </div>
      <div class="menu train">
        <a href="content/booking.jsp" target="frame-content"><img src="images/find.png"></a>
      </div>
      <div class="menu inform">
        <a href="content/StateChangeServlet" target="frame-content"><img src="images/inform.png"></a>
      </div>
      <div id="index-content">
        <iframe name="frame-content" src="content/home.jsp"></iframe>
      </div>
    </div>
    <div id="index-foot">
      @2021，新创铁路 12138 版权所有，热线电话：560xxx12138
    </div>
  </body>
</html>
