<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Select Car</title>
</head>
<body>
<form action="RentServlet" method="post">
<label for="selected">Choose a car:</label>
<select id="selected" name="selected">
    <c:forEach items="${sessionScope.cars}" var="car">
        <option value="${car.carsid}">${car.brand} ${car.model}</option>
    </c:forEach>
    </select>
<input type="submit" value="submit">
</form>
</body>
</html>
