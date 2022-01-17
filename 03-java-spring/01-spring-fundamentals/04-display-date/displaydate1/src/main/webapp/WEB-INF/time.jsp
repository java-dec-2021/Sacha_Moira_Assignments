<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css" />
		<title>Time Template</title>
	</head>
	<body>
		<div class="centCol">
			<h1 class="time"><c:out value="${time}" /></h1>
			<p><a class="time" href="/">Back</a></p>
		</div>
		<script type="text/javascript" src="js/appTime.js"></script>
	</body>
</html>