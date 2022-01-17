<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Languages Core Assignment</title>
	</head>
	<body>
		<h1>Edit Language</h1>
		<a href="/">Dashboard</a>
		<form:form action="/languages/edit/${updateLanguage.id}" method="put" modelAttribute="updateLanguage">

		    <p>
		        <form:label path="languageName">Language</form:label>
		        <form:errors path="languageName"/>
		        <form:input path="languageName" value="${language.languageName }" />
		    </p>
		    <p>
		        <form:label path="creatorName">Creator</form:label>
		        <form:errors path="creatorName"/>
		        <form:input path="creatorName" />
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version" />
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>  
	</body>
</html>