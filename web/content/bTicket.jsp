<%@ page import="com.demo.ov.User" %>
<%@ page import="com.demo.ov.Train" %>
<%@ page import="com.demo.ov.Book" %>
<%@ page import="com.demo.ov.Coach" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/7
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/buyying.css">
  <title>return</title>
</head>
<body>
<%--  <jsp:include page="LoadTrainServlet"/>--%>
  <% Train train = (Train) session.getAttribute("return-train"); %>
  <% User user = (User) session.getAttribute("user"); %>
  <div id="buy-box">
    <% Coach coach = (Coach) session.getAttribute("return-coach"); %>
    请确认退票信息<hr/>
    <form action="ReturnTicketServlet" method="post">
      <table id="buy-table">
        <tr>
          <td>退票者姓名：</td>
          <td><%=user.getName()%></td>
        </tr>
        <tr>
          <td>退票者身份证：</td>
          <td><%=user.getID_card()%></td>
        </tr>
        <tr>
          <td>退票者手机号：</td>
          <td><%=user.getPhone_number()%></td>
        </tr>
        <tr>
          <td>退订车次：</td>
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
          <td colspan="2"><input type="submit" value="退票"><%=request.getAttribute("rtn-message")%></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
