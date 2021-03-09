<%@ page import="com.demo.ov.City" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2021/3/3
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/home.css">
  <title>Home</title>
  <script>
      window.onload = function(){
          var images = document.getElementsByTagName('img');
          var pos = 0, len = 3;
          setInterval(function(){
              images[pos].style.display = 'none';
              pos = (pos + 1) % len;
              images[pos].style.display = 'inline';
          }, 3000);
      };
  </script>
</head>
<body>
  <div id="banner">
    <img src="../images/home-bg1.jpg"/>
    <img src="../images/home-bg2.jpg"/>
    <img src="../images/home-bg3.jpg"/>
  </div>
  <div id="main-box">
    <h3>&emsp;单程票查询</h3>
    <hr/>
    <form action="QueryTrainServlet" method="post">
      <table>
        <% City citySet = new City(); %>
        <tr>
          <td>出发地：</td>
          <td><select class="home-sel begin-sel" name="begin-pos">
            <% for(String city : citySet.cities) { %>
              <option value="<%=city%>"><%=city%></option>
            <% } %>
          </select></td>
        </tr>
        <tr>
          <td>到达地：</td>
          <td><select class="home-sel end-sel" name="end-pos">
            <% for(String city : citySet.cities) { %>
            <option value="<%=city%>"><%=city%></option>
            <% } %>
          </select></td>
        </tr>
        <tr>
          <td>出发日期：</td>
          <%
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String dateStr = format.format(date);
          %>
          <td><input type="date" class="home-sel date-sel" name="date-sel" value="<%=dateStr%>"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" id="fun-submit" value="查询"></td>
        </tr>
      </table>
    </form>
  </div>
  <div id="icon-set">
    <div id="home-foot-message">线&ensp;<br/>下&ensp;<br/>服&ensp;<br/>务&ensp;</div>
    <div class="home-foot-icon icon1"><img src="../images/subscribe.png"></div>
    <div class="home-foot-icon icon2"><img src="../images/goods.png"></div>
    <div class="home-foot-icon icon3"><img src="../images/car.png"></div>
    <div class="home-foot-icon icon4"><img src="../images/check.png"></div>
    <div class="home-foot-icon icon5"><img src="../images/goods.png"></div>
    <div class="home-foot-icon icon6"><img src="../images/build.png"></div>
    <div class="home-foot-icon icon7"><img src="../images/feedback.png"></div>
  </div>
</body>
</html>
