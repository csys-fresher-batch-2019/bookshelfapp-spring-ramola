package com.chainsys.bookshelf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.model.Book;

@WebServlet("/RemoveBook")

public class RemoveBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book b1 = new Book();
		PrintWriter out = response.getWriter();
		BooksDAOImpl bi = new BooksDAOImpl();
		b1.setBookId(Integer.parseInt(request.getParameter("bookId")));
		int msg = 0;
		try {
			System.out.println(msg);
			System.out.println(b1);
			msg = bi.deleteBook(b1);
			if (msg == 1) {
				out.print("Book Successfully Deleted");
			} else {
				out.print("Book Not Found");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
