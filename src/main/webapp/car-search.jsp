<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
