package com.chainsys.bookshelf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bookshelf.implementations.LoginDAOImpl;
import com.chainsys.bookshelf.model.Login;

@WebServlet("/login")

public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Login l1 = new Login();
		l1.seteMail(request.getParameter("e1"));
		l1.setPassword(request.getParameter("p1"));

		PrintWriter out = response.getWriter();

		LoginDAOImpl li = new LoginDAOImpl();
		HttpSession session = request.getSession();

		String loginMessage = "false";

		try {
			loginMessage = li.userLoginValidation(l1.geteMail(), l1.getPassword());
			System.out.println(loginMessage);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (loginMessage.equals("success")) {
			session.setAttribute("semail", l1.geteMail());
			LoginDAOImpl ld = new LoginDAOImpl();
			Login l = new Login();
			try {
				l = ld.getUserDetails(l1.geteMail());
				session.setAttribute("preference", l.getPreferenceType());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("alert('welcome;')");
			response.sendRedirect("User.jsp");
		} else if (loginMessage.equals("admin")) {
			session.setAttribute("semail", l1.geteMail());
			response.sendRedirect("Admin.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Name or password incorrect');");
			out.println("location='index.jsp';");
			out.println("</script>");
			response.sendRedirect("index.jsp");
		}

	}

}
