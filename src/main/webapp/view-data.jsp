<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>View your data</title>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <div class="col-12">
                    <h1>Your data</h1>
                    <table  class="table">
                <thead>
                    <tr class="table-light">
                        <th scope="col">first name</th>
                        <th scope="col">last name</th>
                        <th scope="col">phone</th>
                        <th scope="col">email</th>
                        <th scope="col">password</th>
                    </tr>
                </thead>
                    <tbody>
                    <tr  class="table-info">
                        <td> ${sessionScope.user.firstName} </td>
                        <td> ${sessionScope.user.lastName} </td>
                        <td> ${sessionScope.user.phone} </td>
                        <td> ${sessionScope.user.email} </td>
                        <td> ${sessionScope.user.password} </td>
                        <td> <a class="btn btn-primary" data-toggle="collapse" href="edit-user-data.jsp" role="button" aria-expanded="false" aria-controls="collapseExample">update</a></td>
                        <td> <a class="btn btn-danger" data-toggle="collapse" href="DeleteUser" onclick="if(!(confirm('Are you sure you wanna delete?')))return false" role="button" aria-expanded="false" aria-controls="collapseExample">delete</a></td>
                    </tr>
                </tbody>
            </table>
                <h1>Your rents</h1>
                <table class="table">
                <thead>
                <tr class="table-light">
                    <th scope="col">brand</th>
                    <th scope="col">model</th>
                    <th scope="col">init Date</th>
                    <th scope="col">finish Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.rents}" var="rents">
                <tr class="table-info">
                    <td> ${rents.car.brand} </td>
                    <td> ${rents.car.model} </td>
                    <td> <fmt:formatDate type = "date" value = "${rents.initDate}" /></td>
                    <td> <fmt:formatDate type = "date" value = "${rents.finDate}" /></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            </div>
        </div>
    </div>
</body>
</html>
