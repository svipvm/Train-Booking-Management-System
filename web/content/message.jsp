<%@ page import="com.demo.service.UserService" %>
<%@ page import="com.demo.ov.User" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/4
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/message.css">
  <title>Message</title>
</head>
<body>
  <div id="user-box">
    <% User user = (User) session.getAttribute("user"); %>
    <div id="user-image"><img src="../images/image.png"></div>
    <div id="user-inform">
      <table>
        <tr>
          <td>姓名：</td>
          <td><%=user.getName()%></td>
        </tr>
        <tr>
          <td>性别：</td>
          <td><%=user.getSex()%></td>
        </tr>
        <tr>
          <td>手机号：</td>
          <td><%=user.getPhone_number()%></td>
        </tr>
        <tr>
          <% SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>
          <td>上次登录：</td>
          <td><%=dateTime.format(user.getLast_login())%></td>
        </tr>
        <tr>
          <td><button>修改信息</button></td>
          <td><button>登出账号</button></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="user-train-now">
    <p>未来行程</p><hr>
    <table>
      <tr>
        <th>车次</th>
        <th>出发站</th>
        <th>出发时间</th>
        <th>到达时间</th>
        <th>到达站</th>
      </tr>
    </table>
  </div>
  <div id="user-train-last">
    <p>历史行程</p><hr>
    <table>
      <tr>
        <th>车次</th>
        <th>出发站</th>
        <th>出发时间</th>
        <th>到达时间</th>
        <th>到达站</th>
      </tr>
    </table>
  </div>
</body>
</html>
