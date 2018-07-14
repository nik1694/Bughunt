package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BugBean;
import com.dao.BugDao;

/**
 * Servlet implementation class AddNewBugSlave
 */
@WebServlet("/AddNewBugSlave")
public class AddNewBugSlave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewBugSlave() {
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
		BugBean bean = new BugBean();
		System.out.println(request.getParameter("txtDesc"));
		System.out.println(request.getParameter("ver"));
		System.out.println(request.getParameter("team"));
		System.out.println(request.getParameter("status"));
		System.out.println(request.getParameter("os"));
		System.out.println(request.getParameter("pro"));
		System.out.println(request.getParameter("txtRes"));

		bean.setBugDisc((request.getParameter("txtDesc")));
		bean.setVsersion(((request.getParameter("ver"))));
		bean.setTeam(request.getParameter("team"));
		bean.setStatus(Integer.parseInt(request.getParameter("status")));
		bean.setOs(request.getParameter("os"));
		bean.setPriority(Integer.parseInt(request.getParameter("pro")));
		bean.setResion(request.getParameter("txtRes"));
		bean.setPname("firefox");

		BugDao bugDao = new BugDao();
		boolean status = bugDao.insertSlaveProduct(bean);
		
		if(status){
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('bug Added ');");
			   out.println("location=' jsp/AddNewBug.jsp';");
			   out.println("</script>");
			System.out.println("AddNewBug.jsp!!!!");
			//request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
		
			response.sendRedirect(request.getContextPath()+"/jsp/AddNewBug.jsp");
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
