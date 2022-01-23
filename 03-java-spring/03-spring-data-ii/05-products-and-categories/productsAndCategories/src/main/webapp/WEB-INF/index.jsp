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
	<h1>Products</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Product</th>
	            <th>Price</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${products}" var="product">
	        <tr>
	            <td><a href="/product/details/${product.id}"><c:out value="${product.productName}"/></a></td>
	            <td><c:out value="${product.productPrice}"/></td>
	            <td>
			        <form action="/deleteProduct/${product.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
			<td><a href="/product/edit/${product.id}"><button disabled>Edit</button></a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/product/create"><button>Add Product</button></a>
	<a href="/categories"><button>Add Category</button></a>
</body>
</html>