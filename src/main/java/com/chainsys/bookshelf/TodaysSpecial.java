package com.chainsys.bookshelf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.model.Books;

@WebServlet("/TodaysSpecial")

public class TodaysSpecial extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();
		PrintWriter out = response.getWriter();

		try {
			l = bl.extractTodaysSpecial();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
