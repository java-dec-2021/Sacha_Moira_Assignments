<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1>New Product</h1>
 	<form:form action="/product/create" method="Post" modelAttribute="newProduct">
	    <p>
	        <form:label path="productName">Product:</form:label>
	        <form:errors path="productName"/>
	        <form:input path="productName"/>
	    </p>
	    <p>
	        <form:label path="productDesc">Description:</form:label>
	        <form:errors path="productDesc"/>
	        <form:input path="productDesc"/>
	    </p>
	    <p>
	        <form:label path="productPrice">Price:</form:label>
	        <form:errors path="productPrice"/>
	        <form:input path="productPrice"/>
	    </p>

	    <input type="submit" value="Submit"/>
	</form:form> 
	<a href="/categories/"><button>Add Category</button></a>
</body>
</html>