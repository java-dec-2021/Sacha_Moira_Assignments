<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo and Ninjas</title>
</head>
<body>
	<h1>Dojos</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Dojo</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${dojos}" var="dojo">
	        <tr>
	            <td><a href="/details/${dojo.id}"><c:out value="${dojo.dojoName}"/></a></td>
	            <td>
	        <form action="/delete/${dojo.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
			<td><a href="/dojo/edit/${dojo.id}"><button>Edit</button></a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<h1>New Dojo</h1>
	<form:form action="/create" method="post" modelAttribute="newDojo">
	    <p>
	        <form:label path="dojoName">Dojo:</form:label>
	        <form:errors path="dojoName"/>
	        <form:input path="dojoName"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>  
	<a href="/ninjas/"><button>Add Ninja</button></a>
</body>
</html>