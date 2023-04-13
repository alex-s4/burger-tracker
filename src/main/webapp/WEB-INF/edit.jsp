<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>Edit Burger</h1>
	<a href="/">Go back</a>
	
	<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
		<input type="hidden" name="_method" value="put">
		
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
	
	
	
	
		<input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>