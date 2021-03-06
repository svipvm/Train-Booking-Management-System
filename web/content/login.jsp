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
  <title>Login</title>
</head>
<body>
  <div id="user-login">
    <h3>登录</h3>
    <hr>
    <form action="UserLoginServlet" method="post">
      <table id="user-login-table">
        <tr>
          <td>账号：</td>
          <td><input type="text" name="account"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
      </table>
    </form>
    <p><%=request.getAttribute("user-message")%></p>
  </div>
</body>
</html>
