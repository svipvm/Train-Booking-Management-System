<%@ page import="com.demo.service.UserService" %>
<%@ page import="com.demo.ov.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.demo.ov.Train" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.ov.Book" %><%--
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
  <script type="text/javascript" src="../js/bt_jump.js"></script>
  <script type="text/javascript" src="../js/fun.js"></script>
  <title>Message</title>
  <script type="text/javascript">
      window.onload=function(){
          altRows('book-table-1');
          altRows('book-table-2');
      }
  </script>
</head>
<body>
  <jsp:include page="/content/LoadInformServlet"></jsp:include>
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
          <td><button type="button" onclick="">修改信息</button></td>
          <td><button type="button" onclick="reUserLogin()">登出账号</button></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="user-train-now">
    <h3>&emsp;未来行程</h3><hr>
    <table class="book-table" id="book-table-1">
      <% List<Train> trainsNow = (List<Train>) request.getAttribute("ticket-now"); %>
      <% List<Book> booksNow = (List<Book>) request.getAttribute("book-now"); %>
      <tr>
        <th>车次</th>
        <th>出发站</th>
        <th>出发时间</th>
        <th>到达时间</th>
        <th>到达站</th>
        <th>坐席</th>
        <th>操作</th>
      </tr>
      <% if (trainsNow != null) { %>
        <% for(int i = 0; i < trainsNow.size(); i++) { %>
          <% Train train = trainsNow.get(i); %>
          <% Book book = booksNow.get(i); %>
          <tr>
            <td><%=train.getID()%></td>
            <td><%=train.getBegin_pos()%></td>
            <td>
              <% SimpleDateFormat begin_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
              <%=begin_time.format(train.getBegin_time())%>
            </td>
            <td>
              <% SimpleDateFormat end_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
              <%=end_time.format(train.getEnd_time())%>
            </td>
            <td><%=train.getEnd_pos()%></td>
            <td><%=book.getSit_name()%></td>
            <td><button type="button" class="book-button" onclick="returnTicket('<%=book.getID()%>')">退票</button></td>
          </tr>
        <% } %>
      <% } %>
    </table>
  </div>
  <div id="user-train-last">
    <% List<Train> trainsLast = (List<Train>) request.getAttribute("ticket-last"); %>
    <% List<Book> booksLast = (List<Book>) request.getAttribute("book-last"); %>
    <h3>&emsp;历史行程</h3><hr>
    <table class="book-table" id="book-table-2">
      <tr>
        <th>车次</th>
        <th>出发站</th>
        <th>出发时间</th>
        <th>到达时间</th>
        <th>到达站</th>
        <th>坐席</th>
        <th>操作</th>
      </tr>
      <% if (trainsLast != null) { %>
        <% for(int i = 0; i < trainsLast.size(); i++) { %>
          <% Train train = trainsLast.get(i); %>
          <% Book book = booksLast.get(i); %>
          <tr>
            <td><%=train.getID()%></td>
            <td><%=train.getBegin_pos()%></td>
            <td>
              <% SimpleDateFormat begin_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
              <%=begin_time.format(train.getBegin_time())%>
            </td>
            <td>
              <% SimpleDateFormat end_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
              <%=end_time.format(train.getEnd_time())%>
            </td>
            <td><%=train.getEnd_pos()%></td>
            <td><%=book.getSit_name()%></td>
            <td><button type="button" class="book-button" onclick="deleteTicket('<%=book.getID()%>')">删除</button></td>
          </tr>
        <% } %>
      <% } %>
    </table>
  </div>
</body>
</html>
