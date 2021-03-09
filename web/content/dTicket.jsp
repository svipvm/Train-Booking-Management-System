<%@ page import="com.demo.ov.Train" %>
<%@ page import="com.demo.ov.User" %>
<%@ page import="com.demo.ov.Coach" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/8
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/coach.css">
  <script type="text/javascript" src="../js/fun.js"></script>
  <title>Delete</title>
  <script type="text/javascript">
      window.onload=function(){
          altRows('alt-table');
      }
  </script>
</head>
<body>
  <% User user = (User) session.getAttribute("user"); %>
  <div id="coach-box">
    <% Coach coach = (Coach) session.getAttribute("delete-coach"); %>
    <h3>&emsp;请确认删除信息</h3><hr/>
    <form action="DeleteTrainServlet" method="post">
      <table id="alt-table">
        <tr>
          <td>购票者姓名：</td>
          <td><%=user.getName()%></td>
        </tr>
        <tr>
          <td>购票者身份证：</td>
          <td><%=user.getID_card()%></td>
        </tr>
        <tr>
          <td>购票者手机号：</td>
          <td><%=user.getPhone_number()%></td>
        </tr>
        <tr>
          <td>删除车次：</td>
          <td><%=coach.getID()%></td>
        </tr>
        <tr>
          <td>列车坐席：</td>
          <td><%=coach.getSit_name()%></td>
        </tr>
        <tr>
          <td>列车价格：</td>
          <td><%=coach.getSit_price()%> RMB</td>
        </tr>
        <tr>
          <td>剩余坐席：</td>
          <td><%=coach.getSit_total()%></td>
        </tr>
        <tr>
          <td colspan="2">
            <% String message = (String) request.getAttribute("dlt-message"); %>
            <% message = (message == null ? "" : message); %>
            <div id="coach-message"><%=message%></div>
            <button type="submit" id="coach-button">删除</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
