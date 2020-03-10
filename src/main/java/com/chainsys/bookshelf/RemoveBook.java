package com.chainsys.bookshelf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.model.Books;

@WebServlet("/RemoveBook")

public class RemoveBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Books b1 = new Books();
		BooksDAOImpl bi = new BooksDAOImpl();
		b1.setBookId(Integer.parseInt(request.getParameter("bookId")));

		try {
			System.out.println(b1);
			bi.deleteBook(b1);
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}

}
