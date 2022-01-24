<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1>New Category</h1>
	<form:form action="/create" method="post" modelAttribute="newCategory">
	    <p>
	        <form:label path="categoryName">Category:</form:label>
	        <form:errors path="categoryName"/>
	        <form:input path="categoryName"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>  
	<a href="/"><button>Back</button></a>
</body>
</html>