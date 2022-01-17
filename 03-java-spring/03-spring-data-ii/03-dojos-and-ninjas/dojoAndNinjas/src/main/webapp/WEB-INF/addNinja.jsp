<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>

	<table>
	    <thead>
	        <tr>
	            <th>Ninja</th>
	            <th>Email</th>
	            <th>Dojo</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${ninjas}" var="ninja">
	        <tr>
	            <td><a href="/ninja/details/${ninja.id}"><c:out value="${ninja.lastName}"/>, <c:out value="${ninja.firstName}"/></a></td>
	            <td><c:out value="${ninja.email}"/></td>
	            <td><c:out value="${ninja.dojo.dojoName}"/></td>
	            <td>
	        <form action="/ninja/delete/${ninja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
			<td><a href="/ninja/edit/${ninja.id}"><button>Edit</button></a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<h1>Add Ninja</h1>
	<form:form action="/ninja/create" method="post" modelAttribute="newNinja">
		<form:errors path="dojo"/>
		<form:select path="dojo">
			<c:forEach items="${allDojos}" var="dojo">
				<option value="${dojo.id}">${dojo.dojoName}</option>
			</c:forEach>
		</form:select>
	    <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    <p>
	        <form:label path="email">Email:</form:label>
	        <form:errors path="email"/>
	        <form:input path="email"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
	<a href="/"><button>Back</button></a>
</body>
</html>