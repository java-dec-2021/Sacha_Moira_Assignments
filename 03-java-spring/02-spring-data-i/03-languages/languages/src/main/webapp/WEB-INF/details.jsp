<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="/">Dashboard</a>
		<p>Language: <c:out value="${language.languageName}"/></p>
		<p>Creator: <c:out value="${language.creatorName}"/></p>
		<p>Version: <c:out value="${language.version}"/></p>
		<a href="/languages/edit/${language.id}"><button>Edit</button></a>
		<form action="/delete/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</body>
</html>