<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Ricerca Auto</title>
</head>
<body>
<form action="SearchServlet" method="post">
    Data Inizio Noleggio
    <input type="date" name="dataini" required><br/>
    Data Fine Noleggio
    <input type="date" name="datafine" required>
    <input type="submit" value="controlla disponibilitÓ">
</form>
</body>
</html>
