<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css" />
		<title>Dojo Survey - Index</title>
	</head>
	<body>
		<div class="container">
			<form class="column" action= "/welcome" method="POST">
				<div class="wrapper">
					<label for="name">Your Name:</label>
					<input type="text" name="firstName">
				</div>
				<div class="wrapper">
					<label for="location">Dojo Location:</label>
					<select name="location">
						<option value="Boston">Boston</option>
						<option value="Chicago">Chicago</option>
						<option value="San Jose">San Jose</option>
						<option value="Seattle">Seattle</option>
						<option value="Portland">Portland</option>
						<option value="New York">New York</option>
						<option value="OLnline">Online</option>
					</select>
				</div>
				<div class="wrapper">
					<label for="language">Favorite Language:</label>
					<select name="language">
						<c:forEach var="language" items="${languages}">
							<option value="${language}"><c:out value="${language}"></c:out></option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label for="comment">Comment (Optional):</label>
					<textarea name="comment"></textarea>
				</div>
				<button class="btn">Submit</button>
			</form>
		</div>
	</body>
</html>