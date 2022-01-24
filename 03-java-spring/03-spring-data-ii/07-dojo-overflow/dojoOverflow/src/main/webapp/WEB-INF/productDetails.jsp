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
		<h3><c:out value="${product.productName}"/></h3>
		<h4><c:out value="${product.productPrice}"/></h4>
		<p><c:out value="${product.productDesc}"/></p>
		<h4>Categories:</h4>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li><a href="/category/details/${category.id}"><c:out value="${category.categoryName}"/></a></li>
			</c:forEach>
		</ul>
	
		<form action="/product/addCategory" method="Get" id="addCat">
			<select form="addCat" name="catId">
				<c:forEach items="${allCategories}" var="category">
					<option value="${category.id}">${category.categoryName}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add"/>
		</form>
		<a href="/"><button>Back</button></a>
	</body>
</html>