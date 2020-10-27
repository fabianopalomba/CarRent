<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View your data</title>
</head>
<body>
<table>
    <div id="wrapper">
        <div id = "header">
            <h2>University</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>phone</th>
                    <th>email</th>
                    <th>password</th>
                    <th>Update</th>
                    <th>Delete</th>

                </tr>
                <tr>
                    <td> ${sessionScope.user.firstName} </td>
                    <td> ${sessionScope.user.lastName} </td>
                    <td> ${sessionScope.user.phone} </td>
                    <td> ${sessionScope.user.email} </td>
                    <td> ${sessionScope.user.password} </td>

                    <td> <a href="edit-user-data.jsp">update</a></td>
                    <td> <a href="DeleteUser" onclick="if(!(confirm('Are you sure you wanna delete?')))return false">delete</a></td>
                </tr>

            </table>
        </div>
    </div>

</table>
</body>
</html>
