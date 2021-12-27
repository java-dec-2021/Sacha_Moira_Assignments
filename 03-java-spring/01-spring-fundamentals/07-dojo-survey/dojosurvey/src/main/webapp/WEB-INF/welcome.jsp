<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css" />
		<title>Dojo Survey - Welcome</title>
	</head>
		<body>
			<div class="container">
				<div class="column">
					<h2>Submitted Info: </h2>
					<div class="wrapper">
						<h3>Name:</h3>
						<h4><c:out value="${firstName}"/></h4>
					</div>
					<div class="wrapper">
						<h3>Dojo Location: </h3>
						<h4><c:out value="${location}"/></h4>
					</div>
					<div class="wrapper">
						<h3>Favorite Language: </h3>
						<h4><c:out value="${language}"/></h4>
					</div>
					<div class="wrapper">
						<h3>Comment: </h3>
						<h4><c:out value="${comment}"/></h4>
					</div>
					<div class="wrapper, back">
						<a class="btn" href="/">Back</a>
					</div>
				</div>
			</div>
		</body>
</html>