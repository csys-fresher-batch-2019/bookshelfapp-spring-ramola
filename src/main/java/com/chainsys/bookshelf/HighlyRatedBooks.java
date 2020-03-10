package com.chainsys.bookshelf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.model.Books;

@WebServlet("/HighlyRatedBooks")
public class HighlyRatedBooks extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BooksDAOImpl bl = new BooksDAOImpl();
		// PrintWriter out=response.getWriter();
		List<Books> l = new ArrayList<Books>();
		try {
			l = bl.extractHighlyRatedBooks();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
