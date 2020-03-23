
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<jsp:include page="head.jsp" />

</head>
<style>
.left {
		padding-left: 60px;
	padding-right: 80px;
	padding-top: 20px;
	padding-bottom: 20px;
}
</style>
<body>


	<h4></br>

		<ul>
			
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
			l1.add("Technical");
			l1.add("Autobiographies");
			l1.add("Literature");

			HttpSession sess = request.getSession(false);
			String prefer = (String) sess.getAttribute("preference");
%><font face="DejaVu Sans">
<h1>&nbsp;&nbsp;&nbsp;<%=prefer %></h1>
<% 
			BooksDAOImpl bl = new BooksDAOImpl();
			List<Book> l = new ArrayList<Book>();

			l = bl.findByBookType(prefer);
			for (Book b : l) {
				
		%>
		
		<div class='left'>
		</br></br>
			<div class="card-desk">
				<div class="card bg-white"
					style="width: 16rem; height: 36rem; color: black;">
					<img src="assets/images/<%=b.getImgLink()%>" height="320"
						width="255"></img>
					<div class='container'>
						<h5>
							<strong> <%=b.getBookName()%>
							</strong>
						</h5>
						<p>
							Author :
							<%=b.getBookAuthor()%><br>Version :
							<%=b.getBookVersion()%>
							<br> Language :<%=b.getBookLanguage()%><br> Publisher :<%=b.getBookPublisher()%><br>
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
	
		<%
			for (String pre : l1) {
				
				if (!pre.equals(prefer)) {
					%>
					
					</br><h1>&nbsp;&nbsp;&nbsp;<%=pre %></h1></br>
					<div class='row'><% 
					l = bl.findByBookType(pre);
					for (Book b : l) {
		%>
		</br></br>
		<div class="left">
			<div class="card-desk">
				<div class="card bg-white"
					style="width: 16rem; height: 36rem; color: black;">
					<img src="assets/images/<%=b.getImgLink()%>" height="320"
						width="255"></img>
					<div class='container'>
						<h5>
							<strong> <%=b.getBookName()%>
							</strong>
						</h5>
						<p>
							Author :
							<%=b.getBookAuthor()%><br>Version :
							<%=b.getBookVersion()%>
							<br> Language :<%=b.getBookLanguage()%><br> Publisher :<%=b.getBookPublisher()%><br>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="assets/books/<%=b.getBookLink()%>">Read</a>
						</p>
					</div>
				</div>
			</div></div>


		<%
			}
			 %></div><%
					
				}
				%><%
				
			}
		%>
	
</body>
</html>