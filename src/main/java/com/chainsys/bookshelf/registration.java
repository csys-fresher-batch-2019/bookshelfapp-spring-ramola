package com.chainsys.bookshelf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookshelf.implementations.LoginDAOImpl;
import com.chainsys.bookshelf.model.User;

@WebServlet("/registration")

public class registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User l1 = new User();

		l1.setUserName(request.getParameter("t1"));
		// PrintWriter out = response.getWriter();
		l1.seteMail(request.getParameter("t2"));
		l1.setPhoneNo(Long.parseLong(request.getParameter("t3")));
		l1.setPreferenceType(request.getParameter("ptype"));
		l1.setPassword(request.getParameter("t4"));

		LoginDAOImpl li = new LoginDAOImpl();

		try {
			li.saveUser(l1);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
