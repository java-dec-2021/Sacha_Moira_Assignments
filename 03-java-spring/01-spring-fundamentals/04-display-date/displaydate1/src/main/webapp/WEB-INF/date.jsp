<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css" />
		<title>Date Template</title>
	</head>
	<body>
		<div class="centCol">
			<h1 class="date"><c:out value="${date}" /></h1>
			<p><a class="date" href="/">Back</a></p>
		</div>
		<script type="text/javascript" src="js/appDate.js"></script>
	</body>
</html>