<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>Select Car</title>
</head>
<body>
<form action="RentServlet" method="post">
<label for="selected">Choose a car:</label>
<select id="selected" name="selected">
    <c:forEach items="${sessionScope.cars}" var="car">
        <option value="${car.carsId}">${car.brand} ${car.model}</option>
    </c:forEach>
    </select>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>
