<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Ricerca Auto</title>
</head>
<body>
<div class="container">
    <h1>Choose the date:</h1>
    <div class="card">
        <div class="card-body">
            <form action=SearchServlet method="post">
                <div class="form-group row">
                    <label for="example-date-input" class="col-2 col-form-label">Data Inizio Noleggio</label>
                    <div class="col-4">
                        <input class="form-control" type="date" id="example-date-input" name="dataini" required>
                    </div>
                    <label for="example-date-input1" class="col-2 col-form-label">Data Fine Noleggio</label>
                    <div class="col-4">
                        <input class="form-control" type="date" id="example-date-input1" name="datafine" required>
                    </div>
                    <input class="btn btn-primary" type="submit" value="controlla disponibilità">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
