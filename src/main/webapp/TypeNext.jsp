<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Type Specific</title>
<jsp:include page="head.jsp" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
.left {
	float: left;
	padding-left: 60px;
	padding-right: 80px;
	padding-top: 20px;
	padding-bottom: 20px;
}
</style>
<body>
<body style="background-color: white;">
	<div class='row'>


		<%
			BooksDAOImpl bl = new BooksDAOImpl();
			List<Books> l = new ArrayList<Books>();
			String bookType = request.getParameter("bookType");

			l = bl.extractTypeSpecificBooks(bookType);
			if (l.size() != 0) {
				for (Books b : l) {
		%>
		<div class='left'>
			<div class="card-desk">
				<div class="card bg-white"
					style="width: 16rem; height: 33rem; color: black;">
					<img src="assets/images/<%=b.getImgLink()%>" height="320"
						width="255"></img>
					<div class='container'>
						<h5>
							<b> <%=b.getBookName()%>
							</b>
						</h5>
						<p>
							Author :
							<%=b.getBookAuthor()%><br>Version :
							<%=b.getBookVersion()%>
							<br> Language :<%=b.getBookLanguage()%><br> Publisher
							:<%=b.getBookPublisher()%><br>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="assets/books/<%=b.getBookLink()%>">Read</a>
						</p>
					</div>
				</div>
			</div>
		</div>


		<%
			}
			} else {
		%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</br>
		</br>
		</br>
		<div class="center">
			<h1>
				<font face="Ink Free">
					<%
						out.print(" Books Not Found  !!");
					%>
				
		</div>
		</h1>
		</font>
		<%
			}
		%>

	</div>

</body>
</html>


