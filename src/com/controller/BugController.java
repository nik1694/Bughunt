package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BugController
 */
@WebServlet("/BugController")
public class BugController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BugController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nextJSP ="/jsp/NewBugByDeveloper.jsp";
		String b = request.getParameter("uname");
		String type = request.getParameter("type");
		//request.setAttribute("uname", b);
		request.getSession().setAttribute("uname", b);
		request.getSession().setAttribute("type", type);
		System.out.print(b);
		System.out.print(type);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		//dispatcher.forward(request,response);
		response.sendRedirect(request.getContextPath()+nextJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


