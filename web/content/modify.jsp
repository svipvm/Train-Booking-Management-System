<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/9
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/modify.css">
  <script type="text/javascript" src="../js/check.js"></script>
  <title>Modify</title>
</head>
<body>
  <div id="user-modify">
    <h3>&emsp;请填写待修改信息</h3>
    <hr>
    <form action="UserModifyServlet" method="post" onsubmit="return modifyCheck()">
      <table id="user-modify-table">
        <tr>
          <td>用户名：</td>
          <td><input class="input-text" type="text" id="uname" name="uname"></td>
        </tr>
        <tr>
          <td>性别：</td>
          <td>
            <input type="radio" name="usex" value="男" checked>男
            <input type="radio" name="usex" value="女">女
          </td>
        </tr>
        <tr>
          <td>身份证号：</td>
          <td><input class="input-text" type="text" id="uidcard" name="uidcard"></td>
        </tr>
        <tr>
          <td>手机号：</td>
          <td><input class="input-text" type="text" id="uphone" name="uphone"></td>
        </tr>
        <tr>
          <td>原始密码：</td>
          <td><input class="input-text" type="password" id="password" name="password"></td>
        </tr>
        <tr>
          <td>修改密码：</td>
          <td><input class="input-text" type="password" id="modifypwd" name="modifypwd"></td>
        </tr>
        <tr>
          <% String message = (String) request.getAttribute("user-message"); %>
          <% message = (message == null ? "" : message); %>
          <div id="user-message"><%=message%></div>
          <td colspan="2"><button type="submit" id="user-button">确认修改</button></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
