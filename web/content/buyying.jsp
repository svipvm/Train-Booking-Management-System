<%@ page import="java.util.Enumeration" %>
<%@ page import="com.demo.ov.Train" %><%--
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
  <title>Buyying</title>
</head>
<body>
  <% Train train = (Train) request.getAttribute("buy-train"); %>
  <%=train.getBegin_time()%>
</body>
</html>
