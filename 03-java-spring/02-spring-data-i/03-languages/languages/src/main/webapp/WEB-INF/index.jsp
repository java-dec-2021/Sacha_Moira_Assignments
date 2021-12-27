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
		<h1>Languages</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Language</th>
		            <th>Creator</th>
		            <th>Version</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><a href="/details/${language.id}"><c:out value="${language.languageName}"/></a></td>
		            <td><c:out value="${language.creatorName}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td>
		        <form action="/delete/${language.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
				</td>
				<td><a href="/languages/edit/${language.id}"><button>Edit</button></a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<h1>New Language</h1>
		<form:form action="/create" method="post" modelAttribute="newLanguages">
		    <p>
		        <form:label path="languageName">Language</form:label>
		        <form:errors path="languageName"/>
		        <form:input path="languageName"/>
		    </p>
		    <p>
		        <form:label path="creatorName">Creator</form:label>
		        <form:errors path="creatorName"/>
		        <form:input path="creatorName"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>  
	</body>
</html>