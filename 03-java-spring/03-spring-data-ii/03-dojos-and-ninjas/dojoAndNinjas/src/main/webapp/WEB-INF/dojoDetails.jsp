<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${dojo.dojoName}"/> Dojo</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Ninja</th>
	            <th>Email</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach items="${ninjas}" var="ninja">
		        <tr>
		        		<c:if test="${ninja.dojo.id == dojo.id}">
	
			        		<td><a href="/ninja/details/${ninja.id}"><c:out value="${ninja.lastName}"/>, <c:out value="${ninja.firstName}"/></a></td>
				            <td><c:out value="${ninja.email}"/></td>
				            <td>
						        <form action="/ninja/delete/${ninja.id}" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete">
								</form>
							</td>
							<td><a href="/ninja/edit/${ninja.id}"><button>Edit</button></a></td>
		        	</c:if>
		        </tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/"><button>Back</button></a>
</body>
</html>