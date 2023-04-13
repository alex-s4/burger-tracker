<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
    <div class="table-container">
        <h1>Burger Tracker</h1>
        <div class="main-table">
            <table class="burger-table">
                <thead>
                    <tr>
                        <th>Burger Name</th>
                        <th>Restaurant Name</th>
                        <th>Rating (out of 5)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="oneBurger" items="${burgers}">
                        <tr>
                            <td>${oneBurger.getBurgerName()}</td>
                            <td>${oneBurger.getRestaurantName()}</td>
                            <td>${oneBurger.getRating()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>


    <div class="forms-container">
        <h2>Add a Burger:</h2>
        <form:form action="/" method="post" modelAttribute="burger">
            
            <p id="error">
                <form:errors path="burgerName"/>
                <form:errors path="restaurantName"/>
                <form:errors path="rating"/>
                <form:errors path="notes"/>
            </p>
            
            <div class="main-form">
                
                <p>
                    <form:label path="burgerName">Burger Name</form:label>
                    <form:input path="burgerName"/>
                </p>
                <p>
                    <form:label path="restaurantName">Restaurant Name</form:label>
                    <form:input path="restaurantName"/>
                </p>
                <p>
                    <form:label path="rating">Rating</form:label>
                    <form:input type="number" path="rating"/>
                </p>
                <p>
                    <form:label path="notes" class="textarea-label">Notes</form:label>
                    <form:textarea path="notes"/>
                </p>
            </div>
            
            <input type="submit" value="Submit">
        </form:form>
    </div>
</body>

</html>