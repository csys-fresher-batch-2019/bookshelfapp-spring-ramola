<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<style>
.container {
	position: relative;
	font-family: Arial;
}

.text-block {
	position: absolute;
	top: 20px;
	right: 20px;
	margin-top: 60px;
	background-color: white;
	opacity: 0.7;
	color: black;
	padding-left: 20px;
	padding-right: 20px;
}

img {
	opacity: 1.0;
}

.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #000000;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 15px;
	padding: 20px;
	width: 150px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 3px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

.left {
	float: right;
}
</style>
<body>
	<div class="container-fluid"
		style="display: inline; position: absolute; width: 100%; height: 60%">
		<img src="assets/images/shelf.jpg" style="padding-top: 0" alt="Book"
			width=100%>

		<form action="login">
			<div class="text-block">
				<h2>Sign In</h2>
				Enter E-mail : <input type="email"
					pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" name="e1"
					placeholder="Enter E-mail" required autofocus /></br>
				</br> Enter the password : <input type="password" name="p1"
					placeholder="Enter your password" required /></br>
				</br>

				<button class="button" style="vertical-align: middle">
					<span> Login</span>
				</button>
				</br>
				<div class="left">
					<a href="Registration.jsp">New User?</a>
					</center>
					</br>
					</br>
				</div>
			</div>
	</div>
	</form>
</body>
</html>