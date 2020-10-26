<%@ page import="java.util.List" %>
<%@ page import="com.rentfegh.model.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 23/10/2020
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        List<Car> car= (List<Car>) request.getSession().getAttribute("cars");
    %>
    <title>Select Car</title>
</head>
<body>
<form action="RentServlet" method="post">
<label for="selected">Choose a car:</label>
<select id="selected" name="selected">
<%
    for (Car c : car){
%>        <option value="<%=c.getCars_id()%>"><%= c.getBrand() + " " + c.getModel()%></option><%}%>
    </select>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>
