<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>Login Form:</h1>
        <div class="card">
            <div class="card-body">
                <form action=LoginServlet method="post">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" name="username"
                                   placeholder="Enter user name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input type="password" class="form-control" name="password"
                                   placeholder="Enter Password">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>