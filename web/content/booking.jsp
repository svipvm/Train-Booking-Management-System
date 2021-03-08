<%@ page import="com.demo.ov.City" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.ov.Train" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.demo.ov.Coach" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/3
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/booking.css">
  <title>Booking</title>
  <script language="JavaScript">
    function choiced(value) {
      // var myFrame = parent.document.getElementsByName("frame-content")[0];
      // myFrame.src = "content/buyying.jsp?choice=" + value;
      <%--alert(<% request.setAttribute("choice", value); %>)--%>
<%--        <% request.setAttribute("choice", value); %>--%>
    }
  </script>
</head>
<body>
  <div id="select-box">
    <form action="QueryTrainServlet" method="post">
      <% City citySet = new City(); %>
      <% boolean flag = false; %>
      <% String beginPos = new String(""); %>
      <% String endPos = new String(""); %>
      <% String dateStr = new String(""); %>

      <% try {
          flag = (boolean) request.getAttribute("isSearch");
          beginPos = (String) request.getAttribute("begin-pos");
          endPos = (String) request.getAttribute("end-pos");
          dateStr = (String) request.getAttribute("date-sel");
      } catch (Exception e) {
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          Date date = new Date(System.currentTimeMillis());
          dateStr = format.format(date);
          flag = false;
      } %>

      <ul id="select-ui">
        <li>
          出发地
          <select class="book-sel begin-sel" name="begin-pos">
            <% for(String city : citySet.cities) { %>
              <% if(flag && city.equals(beginPos)) { %>
                <option value="<%=city%>" selected="selected"><%=city%></option>
              <% } else { %>
                <option value="<%=city%>"><%=city%></option>
              <% } %>
            <% } %>
          </select>
        </li>
        <li>
          到达地
          <select class="book-sel end-sel" name="end-pos">
            <% for(String city : citySet.cities) { %>
              <% if(flag && city.equals(endPos)) { %>
                <option value="<%=city%>" selected="selected"><%=city%></option>
              <% } else { %>
               <option value="<%=city%>"><%=city%></option>
              <% } %>
            <% } %>
          </select>
        </li>
        <li>
          出发日期
          <input type="date" class="book-sel date-sel" name="date-sel" value="<%=dateStr%>">
        </li>
        <li>
          <input type="submit" id="fun-submit">
        </li>
      </ul>
    </form>
  </div>
  <hr/>
  <div id="result-box">
    <% List<Train> trains = (List<Train>) session.getAttribute("trains"); %>
    <% List<List<Coach>> coaches = (List<List<Coach>>) session.getAttribute("coaches"); %>
    <form action="UpdateTicketServlet" method="post">
      <table id="result-table">
        <tr>
          <th>车次</th>
          <th>类型</th>
          <th>出发站</th>
          <th>出发时间</th>
          <th>到达时间</th>
          <th>到达站</th>
          <th>坐席一</th>
          <th>坐席二</th>
          <th>坐席三</th>
          <th>操作</th>
        </tr>
        <% if (trains != null) { %>
          <% for(int i = 0; i < trains.size(); i++) { %>
            <% Train train = trains.get(i); %>
            <% List<Coach> coach = coaches.get(i); %>
            <tr>
              <td><%=train.getID()%></td>
              <td><%=train.getKind()%></td>
              <td><%=train.getBegin_pos()%></td>
              <td>
    <%--            <%=train.getBegin_time()%>--%>
                <% SimpleDateFormat begin_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
                <%=begin_time.format(train.getBegin_time())%>
              </td>
              <td>
    <%--            <%=train.getEnd_time()%>--%>
                <% SimpleDateFormat end_time = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
                <%=end_time.format(train.getEnd_time())%>
              </td>
              <td><%=train.getEnd_pos()%></td>
              <% for(int j = 0; j < coach.size(); j++) { %>
                <% Coach value = coach.get(j); %>
                <td><label>
                  <input type="radio" name="sit" value="<%=i%>-<%=j%>">
                  <%=value.getSit_name()%> 余 <%=value.getSit_total()%> 位
                  <br/>每位 <%=value.getSit_price()%> RMB
                </label></td>
              <% } %>
              <td><input type="submit" value="预定"></td>
            </tr>
          <% } %>
        <% } %>
      </table>
    </form>
  </div>
</body>
</html>
