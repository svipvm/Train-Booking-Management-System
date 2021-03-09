<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/4
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/login.css">
  <script type="text/javascript" src="../js/check.js"></script>
  <title>Login</title>
</head>
<body>
  <div id="user-login">
    <h3>&emsp;请登录账号</h3>
    <hr>
    <form action="UserLoginServlet" method="post" onsubmit="return loginCheck()">
      <table id="user-login-table">
        <tr>
          <td>账号：</td>
          <td><input class="input-text" type="text" id="account" name="account"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input class="input-text" type="password" id="password" name="password"></td>
        </tr>
        <tr>
          <% String message = (String) request.getAttribute("user-message"); %>
          <% message = (message == null ? "" : message); %>
          <div id="user-message"><%=message%></div>
          <td colspan="2"><button type="submit" id="user-button">登录</button></td>
          <div id="register"><a href="register.jsp">注册账号</a></div>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
