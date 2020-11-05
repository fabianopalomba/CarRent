<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>View your data</title>
</head>
<body>
<c:forEach items="${sessionScope.rents}" var="rents">
    <c:out value="${rents.toString()}"></c:out>
</c:forEach>
    <div id="container">
        <div id="content">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">first name</th>
                        <th scope="col">last name</th>
                        <th scope="col">phone</th>
                        <th scope="col">email</th>
                        <th scope="col">password</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> ${sessionScope.user.firstName} </td>
                        <td> ${sessionScope.user.lastName} </td>
                        <td> ${sessionScope.user.phone} </td>
                        <td> ${sessionScope.user.email} </td>
                        <td> ${sessionScope.user.password} </td>
                        <td> <a href="edit-user-data.jsp">update</a></td>
                        <td> <a href="DeleteUser" onclick="if(!(confirm('Are you sure you wanna delete?')))return false">delete</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
