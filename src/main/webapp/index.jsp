<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/10/2020
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Object obj = request.getSession().getAttribute("email");
    out.print("Benvenuto " + obj);
%>
<a href="UserServlet">Visualizza i tuoi dati</a>
<br/>
<a href="car-search.jsp">Effettua un noleggio</a>
</body>
</html>
