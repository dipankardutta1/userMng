<%@page import="com.example.demo.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<jsp:include page="common.jsp"></jsp:include>


<style type="text/css">

#container {
	padding: 25px;
}

</style>


</head>
<body>


<jsp:include page="menu.jsp"></jsp:include>







<div id="container">

<h1> Welcome ${sessionScope.name} (${sessionScope.phoneNo}) </h1>

<div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  	<div class="panel-body">
  	
  		<form action="processUser" method="post">
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" name="name" class="form-control" id="name">
		  </div>
		  
		  <div class="form-group">
		    <label for="phoneNo">Phone No:</label>
		    <input type="text" name="phoneNo" class="form-control" id="phoneNo">
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="dob">DOB:</label>
		    <input type="text" name="dob" class="form-control" id="dob">
		  </div>
		  
		  <div class="form-group">
		    <label for="username">Username:</label>
		    <input type="text" name="username" class="form-control" id="username">
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="text" name="password" class="form-control" id="password">
		  </div>
		  
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
  	
  	
  	
  	</div>
  </div>






<div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  	<div class="panel-body">
		
		<table class="table">
			<thead>
				<tr>
					<th>NAME</th>
					<th>PHONE NO</th>
					<th>DOB</th>
					<th>USERNAME</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				
				<c:forEach items="${requestScope.userList}" var="user">
				
					<tr>
						<td>  <c:out value="${user.name }"></c:out>  </td>
						<td> <c:out value="${user.phoneNo}"></c:out></td>
  						<td>  <f:formatDate value="${user.dob}" pattern="MM/dd/yyyy"/>   </td>
						<td> <c:out value="${user.username}"></c:out></td>
						<td> <a href="">Edit</a> / <a href="deleteUser?id=${user.id}">Delete</a> </td>
					</tr>
				
				
				</c:forEach>
				
			</tbody>
			
		</table>



	</div>
</div>


</div>


</body>
</html>