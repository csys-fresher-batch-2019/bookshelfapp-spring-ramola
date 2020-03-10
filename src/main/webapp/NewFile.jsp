<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body bgcolor="#181818">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<style>
.navbar-inverse {
	background-color: black;
}

.navbar-inverse .navbar-fnt {
	color: #FFFFFF;
}

.left {
	float: left;
	padding-left: 40px;
	padding-right: 30px;
	padding-top: 20px;
	padding-bottom: 20px;
}
</style>
<nav
	class="navbar navbar-inverse navbar-fnt navbar-expand-lg   lighten-5 mb-4">

<!-- Navbar brand --> <font face="Ink Free" size="20" color="white">
	<b><a class="navbar-brand" href="#">My Bookshelf</a></b>
</font> <!-- Collapse button -->
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarSupportedContent"
	aria-controls="navbarSupportedContent" aria-expanded="false"
	aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
</button>

<!-- Collapsible content -->
<div class="collapse navbar-collapse" id="navbarSupportedContent">

	<!-- Links -->
	<ul class="navbar-nav mr-auto">

		<li class="nav-item"><a class="nav-link" href="AdminLogin.jsp">Admin</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="login.jsp">User</a>
		</li>



	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="Registration.jsp"><span
				class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		<li><a href="login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> &nbsp;&nbsp;&nbsp; Login</a></li>
	</ul>

</div>
<!-- Collapsible content --> </nav>
<body style="background-color: white;">
	<font face='Fixedsys' color="black"><h4 style="color: black;">
			<b>&nbsp;&nbsp;&nbsp; Movies</b>
		</h4></font>
	</br>
	</br>
	<div class='row'>

		<%
			BooksDAOImpl bl = new BooksDAOImpl();
			List<Books> l = new ArrayList<Books>();

			l = bl.viewAllBooks();

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
					</div>
				</div>
			</div>
		</div>
		<%
			}
		%>
	
</body>


</html>

