<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Servlet, JSP and Hibernate CRUD Operations</title>

    <style type="text/css" href="css/style.css" rel="stylesheet">

    </style>
</head>
<body>
<h1>Servlet, JSP and Hibernate CRUD Operations</h1>
<a href="login.jsp">LOGIN</a>
<form action="RegisterUser" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" required></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName"  required></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="int" pattern="[3][0-9]{9}" name="phone"  required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password"  name="password" required></td>
        </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
    </table>
</form>
</body>
</html>