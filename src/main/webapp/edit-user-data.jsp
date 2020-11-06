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
    <h1>Register Form:</h1>
    <div class="card">
        <div class="card-body">
            <form action=EditServlet method="post">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">First
                        Name</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="firstName"
                               value="${sessionScope.user.firstName}" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Last
                        Name</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="lastName"
                               value="${sessionScope.user.lastName}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Phone </label>
                    <div class="col-sm-7">
                        <input type="int" pattern="[3][0-9]{9}" name="phone"  required class="form-control"
                               value="${sessionScope.user.phone}">
                    </div>
                </div>

                <div class=" form-group row">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-7">
                        <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required class="form-control" name="email"
                               value="${sessionScope.user.email}" readonly  >
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="password"
                               value="${sessionScope.user.password}" required>
                    </div>
                </div>
                <input class="btn btn-primary" type="submit" value="Submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
