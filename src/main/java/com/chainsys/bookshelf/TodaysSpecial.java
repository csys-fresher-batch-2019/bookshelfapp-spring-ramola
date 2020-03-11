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
import com.chainsys.bookshelf.model.Book;

@WebServlet("/TodaysSpecial")

public class TodaysSpecial extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();
		// PrintWriter out = response.getWriter();

		try {
			l = bl.findTodaysSpecial();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
