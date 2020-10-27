<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>

<div>
    <h1>Login Form</h1>
    <form action="LoginServlet" method="post">
        <div>
            <label>User Name:</label> <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label>Password:</label> <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>