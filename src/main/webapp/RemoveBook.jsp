<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Books"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Book</title>
<jsp:include page="head.jsp" />

</head>
<body>
	<center>
		<h2>
			<u>Remove a Book</u>
		</h2>
		<form action="RemoveBook">
			Enter a Specific BookID :<input type="number" name="bookId" required /><br>
			<br> <input type="submit" name="submit" value="search" />
	</center>
	</form>
</body>
</html>