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
    <title>火车订票管理系统</title>
    <style>
      body {
        height: 95%;
        width: 99%;
        background-color: blue;
      }
    </style>
  </head>
  <body>
    <div id="index-head">
      <h1>火车订票管理系统</h1>
    </div>
    <div id="index-box">
      <div class="menu home">
        <a href="content/home.jsp" target="frame-content"><h2>首页</h2></a>
      </div>
      <div class="menu train">
        <a href="content/booking.jsp" target="frame-content"><h2>车票</h2></a>
      </div>
      <div class="menu inform">
        <a href="content/message.jsp" target="frame-content"><h2>信息</h2></a>
      </div>
      <div id="index-content">
        <iframe name="frame-content" src="content/home.jsp"></iframe>
      </div>
    </div>
    <div id="index-foot">
      @2021
    </div>
  </body>
</html>
