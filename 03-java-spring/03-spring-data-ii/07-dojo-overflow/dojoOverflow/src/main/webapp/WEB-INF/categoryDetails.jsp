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
		<h3><c:out value="${category.categoryName}"/></h3>
	
		<h4>Products:</h4>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li><c:out value="${product.productName}"/></li>
			</c:forEach>
		</ul>
	
		<form action="/category/addProduct" method="Get" id="addProd">
			<select form="addProd" name="prodId">
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.productName}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add"/>
		</form>
		<a href="/"><button>Back</button></a>
	</body>
</html>