<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<title>User</title>
<jsp:include page="head.jsp" />

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


	<h4>

		<ul class="nav navbar-nav">
			<li class="active">
			<li><a href="AuthorSpecificBooks.jsp">View Author Specific
					Books</a></li>
			<li><a href="LanguageSpecificBooks.jsp">View Language
					Specific Books</a></li>
			<li><a href="TypeSpecificBooks.jsp">View Type Specific Books</a>
			</li>

			<li><a href="TodaysSpecial.jsp">View Today's Special Books</a></li>

			<li><a href="HighlyRatedBooks.jsp">Highly Rated Books</a></li>
			<li><a href="RelatedBooks.jsp">Related Books</a></li>
		</ul>

	</h4>
<body style="background-color: white;">
	<div class='row'>


		<%
			List<String> l1 = new ArrayList<String>();
			l1.add("Fiction");
			l1.add("Fantacy");
			l1.add("Mythology");
			l1.add("Poetry");

			HttpSession sess = request.getSession(false);
			String prefer = (String) sess.getAttribute("preference");

			BooksDAOImpl bl = new BooksDAOImpl();
			List<Books> l = new ArrayList<Books>();

			l = bl.extractTypeSpecificBooks(prefer);
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
		%>
	</div>
	<div class='row'>
		<%
			for (String pre : l1) {
				if (!pre.equals(prefer)) {
					l = bl.extractTypeSpecificBooks(pre);
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
				}
			}
		%>
	
</body>
</html>