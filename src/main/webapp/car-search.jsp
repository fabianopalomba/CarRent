<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 23/10/2020
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca Auto</title>
</head>
<body>
<form action="SearchServlet" method="post">
    Data Inizio Noleggio
    <input type="date" name="dataini" required><br/>
    Data Fine Noleggio
    <input type="date" name="datafine" required>
    <input type="submit" value="controlla disponibilità">
</form>
</body>
</html>
