<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Benvenuto ${sessionScope.email}</h1>
<a href="UserServlet">Visualizza i tuoi dati</a>
<br/>
<a href="car-search.jsp">Effettua un noleggio</a>
</body>
</html>
