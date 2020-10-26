<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/10/2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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