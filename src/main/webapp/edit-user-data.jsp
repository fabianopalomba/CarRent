<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="EditServlet" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" required value="${sessionScope.user.firstName}"></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName"  required value="${sessionScope.user.lastName}"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="int" pattern="[3][0-9]{9}" name="phone"  required value="${sessionScope.user.phone}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" required value="${sessionScope.user.email}"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password"  name="password" required value="${sessionScope.user.password}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>

</body>
</html>
