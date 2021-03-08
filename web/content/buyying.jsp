<%@ page import="java.util.Enumeration" %>
<%@ page import="com.demo.ov.Train" %>
<%@ page import="com.demo.ov.User" %>
<%@ page import="com.demo.ov.Coach" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/6
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/buyying.css">
  <title>Buyying</title>
</head>
<body>
  <% Train train = (Train) session.getAttribute("buy-train"); %>
  <% User user = (User) session.getAttribute("user"); %>
  <% Coach coach = (Coach) session.getAttribute("buy-coach"); %>
  <div id="buy-box">
    请确认购买信息<hr/>
    <form action="BuyTicketServlet" method="post">
      <table id="buy-table">
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
          <td>预约车次：</td>
          <td><%=train.getID()%></td>
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
          <td colspan="2"><input type="submit" value="购买"><%=request.getAttribute("buy-message")%></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
