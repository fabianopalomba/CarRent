<%@ page import="com.rentfegh.model.User" %><%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/10/2020
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User user = (User)request.getSession().getAttribute("user");
%>

<head>
    <title>Title</title>
</head>
<body>
<form action="EditServlet" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" required value="<%= user.getFirstName() %>"></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName"  required value="<%= user.getLastName() %>"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="int" pattern="[3][0-9]{9}" name="phone"  required value="<%= user.getPhone() %>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" required value="<%= user.getEmail() %>"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password"  name="password" required value="<%= user.getPassword() %>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>

</body>
</html>
