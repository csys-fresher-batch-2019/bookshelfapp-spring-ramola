<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
<jsp:include page="head.jsp" />

</head>
<body>
	<h1>
		<center>
			<u>Add Book</u>
		</center>
	</h1>
	<br />
	<center>
		<form action="AddBook">
			Enter the Book Name : <input type="text" name="bookName"
				placeholder="Enter Book Name" required autofocus /><br />
			<br /> Enter the Book Version : <input type="number"
				name="bookVersion" placeholder="Enter Book Version" required /></br>
			</br> Enter the Book Author : <input type="text" name="bookAuthor"
				placeholder="Enter Book Author" required /></br>
			</br> Enter the Book Language : <input type="text" name="bookLanguage"
				placeholder="Enter Book Language" required /><br />
			<br /> Enter the Book Type : <input type="text" name="bookType"
				placeholder="Enter Book Type" required /><br />
			<br /> Enter the Book Publisher :<input type="text"
				name="bookPublisher" placeholder="Enter Book Publisher" required /><br />
			<br /> Enter the Book Published Date :<input type="date"
				name="bookPublishedDate" placeholder="Enter Book Published Date"
				required /><br />
			<br /> Enter the Book File :<input type="file" name="bookLink"
				required /><br />
			<br /> Enter the Book Image :<input type="file" name="imgLink"
				required /><br />
			<br />

			<button type="submit">Submit</button>
			</br>
			</br>

		</form>

	</center>
</body>
</html>