package com.chainsys.bookshelf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.LoginDAOImpl;
import com.chainsys.bookshelf.model.Login;

@WebServlet("/registration")

public class registration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Login l1 = new Login();

		l1.setUserName(request.getParameter("t1"));
		PrintWriter out = response.getWriter();
		l1.seteMail(request.getParameter("t2"));
		l1.setPhoneNo(Long.parseLong(request.getParameter("t3")));
		l1.setPreferenceType(request.getParameter("ptype"));
		l1.setPassword(request.getParameter("t4"));

		LoginDAOImpl li = new LoginDAOImpl();

		try {
			li.newLogin(l1);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
