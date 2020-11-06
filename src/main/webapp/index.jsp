<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Homepage</h1>
    <div class="card">
        <div class="card-body">
            <div class="alert alert-primary" role="alert">
                Benvenuto ${sessionScope.email}
            </div>
            <ul class="list-group list-group-horizontal">
                <a href="UserServlet" class="list-group-item list-group-item-action">Visualizza i tuoi dati</a>
                <a href="car-search.jsp" class="list-group-item list-group-item-action">Effettua un noleggio</a>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
