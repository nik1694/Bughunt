package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DeveloperBeaN;
import com.dao.DeveloperDao;

/**
 * Servlet implementation class AddDeveloper
 */
@WebServlet("/AddDeveloper")
public class AddDeveloper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDeveloper() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside servlet");
		DeveloperBeaN bean = new DeveloperBeaN();
		bean.setName(request.getParameter("txtName"));
		bean.setEmail(request.getParameter("txtEmail"));
		bean.setTeam(request.getParameter("txtTeam"));
		bean.setTech(request.getParameter("txtTech"));
		bean.setPassword(request.getParameter("txtPass"));
		bean.setExp(Integer.parseInt(request.getParameter("txtExp")));
		DeveloperDao dao = new DeveloperDao();
		boolean a = dao.insertProduct(bean);
		if (a) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Developer Addde ');");
			out.println("location=' jsp/AddDeveloper.jsp';");
			out.println("</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Developer Not Addde ');");
			out.println("location=' jsp/AddDeveloper.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
