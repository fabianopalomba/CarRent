<%@ page import="com.rentfegh.model.User" %><%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/10/2020
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.rentfegh.model.User"
%>
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
<%
    User user = (User)request.getSession().getAttribute("user");
%>
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
                    <td> <%= user.getFirstName() %> </td>
                    <td> <%= user.getLastName() %> </td>
                    <td> <%= user.getPhone() %> </td>
                    <td> <%= user.getEmail() %> </td>
                    <td> <%= user.getPassword() %> </td>

                    <td> <a href="edit-data.jsp">update</a></td>
                    <td> <a href="DeleteUser" onclick="if(!(confirm('Are you sure you wanna delete?')))return false">delete</a></td>
                </tr>

            </table>
        </div>
    </div>

</table>
</body>
</html>
