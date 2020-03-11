
package com.chainsys.bookshelf;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.model.Book;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Book b1 = new Book();
		PrintWriter out = response.getWriter();
		BooksDAOImpl bi = new BooksDAOImpl();
		b1.setBookName(request.getParameter("BooksName"));
		b1.setBookVersion(Integer.parseInt(request.getParameter("BooksVersion")));
		b1.setBookAuthor(request.getParameter("BooksAuthor"));
		b1.setBookLanguage(request.getParameter("BooksLanguage"));
		b1.setBookType(request.getParameter("BooksType"));
		b1.setBookPublisher(request.getParameter("BooksPublisher"));
		b1.setBookPublishedDate(LocalDate.parse(request.getParameter("BooksPublishedDate")));
		String link = splitUrl(request.getParameter("BooksLink"));
		b1.setBookLink(link);
		String link1 = splitUrl(request.getParameter("imgLink"));
		b1.setImgLink(link1);
		int msg = 0;

		try {
			msg = bi.addBook(b1);
			if (msg == 1) {
				out.print("Books Successfully Added");
			} else {
				out.print("Books Not Added");

			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("Books Not Added");

		}
	}

	String splitUrl(String url) {

		String words[] = url.split("\\\\");
		int l = words.length;
		return (words[l - 1]);
	}

}
