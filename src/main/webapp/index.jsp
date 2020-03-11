<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<html>

<head>
<title>All Books</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">My Bookshelf</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active">
			<li><a href="AdminLogin.jsp">Admin</a></li>
			<li><a href="login.jsp">User</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Registration.jsp"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login.jsp"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
</nav>
</br>
<style>
body {
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<body style="background-image: url('assets/images/bg.jpg')">


</body>
</html>
