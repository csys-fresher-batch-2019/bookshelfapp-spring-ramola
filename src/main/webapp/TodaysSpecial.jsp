<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.bookshelf.implementations.BooksDAOImpl"%>
<%@page import="com.chainsys.bookshelf.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today's Special</title>
<jsp:include page="head.jsp" />

</head>
<body>
	<h2>
		<u><center>Today's Special Books</center></u>
	</h2>
	</br>
	<%!public String toUpp(String word) {
		String words[] = word.split("\\s\\.");
		String res = "";
		for (String s : words) {
			String first = s.substring(0, 1);
			String f_after = s.substring(1);
			res += first.toUpperCase() + f_after + " ";
		}

		return (res);
	}%>

	<form action="TodaysSpecial">
		<%
			BooksDAOImpl bd = new BooksDAOImpl();
			List<Book> l = new ArrayList<Book>();
			l = bd.findTodaysSpecial();
			if (l.size() != 0) {
				out.print("<center><table border='1'><tr><th>Books</th><th>Book Details</th><tr>");

				for (Book b : l) {
					out.print("<tr><td><img src=assets/images/" + b.getImgLink()
							+ " height='210' width='190'></td><td>Book Name  : " + toUpp(b.getBookName())
							+ " </br> Book Version  :" + b.getBookVersion() + "</br>Book Author  : "
							+ toUpp(b.getBookAuthor()) + " </br>Book Language  : " + b.getBookLanguage() + "</tr>");

				}

				out.print("</table></center>");
			} else {
		%><center>
			</br>
			</br>
			</br>
			<h1>
				<font face="Ink Free">
					<%
						out.print(" Books Not Found  !!");
					%>
				
			</h1>
			</font>
		</center>
		<%
			}
		%>

	</form>
</body>
</html>