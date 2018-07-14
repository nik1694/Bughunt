package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.SwingConstants;

import com.bean.UserBean;
import com.dao.UserOperations;
import com.utils.Constant;

@WebServlet("/login")
public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	boolean status;

	public login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("inside do get " + Constant.appName);
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String userType = request.getParameter("userType");
		System.out.println("userType 1 " + userType);
		System.out.println("uname " + uname);
		System.out.println("pass " + Constant.appName);
		UserBean bean = new UserBean();
		bean.setUserName(uname);
		bean.setPassWord(pass);
		UserOperations operations = new UserOperations();
		status = operations.validateUser(bean, userType);
		session.setAttribute("uname", uname);
		//redirectUser(userType, status, session,request,response);
		if (status) {
			System.out.println("user type : "+userType);
			if (Constant.userTypeAdmin.equals(userType)) {
		      // RequestDispatcher rq =   request.getRequestDispatcher("/jsp/ManagerHome.jsp");
		       response.sendRedirect(request.getContextPath()+"/jsp/ManagerHome.jsp");
				System.out.println("Welcome Admin ");
			} else if (Constant.userTypeAgent.equals(userType)) {
				request.getRequestDispatcher("/jsp/DeveloperHome.jsp").forward(request, response);
				System.out.println("Welcome Developer");
			} else if (Constant.userTypeUser.equals(userType)) {
				request.getRequestDispatcher("/jsp/TesterHome.jsp").forward(request, response);
				System.out.println("Welcome Tester ");
			} else {
				System.out.println("Select proeper user type and then login....!!!!");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='/bughunt/Login.jsp';");
			   out.println("</script>");
			System.out.println("may be username or password is wrong...as.!!!!");
			//request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside post");
		doGet(request, response);
	}

	public void redirectUser(String userType, boolean status, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (status) {
			System.out.println("user type : "+userType);
			if (Constant.userTypeAdmin.equals(userType)) {
		        request.getRequestDispatcher("../jsp/AdminHome.jsp").forward(request, response);  
				System.out.println("Welcome Admin ");
			} else if (Constant.userTypeAgent.equals(userType)) {
				request.getRequestDispatcher("../jsp/AgentHome.jsp").forward(request, response);
				System.out.println("Welcome Agnt ");
			} else if (Constant.userTypeUser.equals(userType)) {
				request.getRequestDispatcher("../jsp/UserHome.jsp").forward(request, response);
				System.out.println("Welcome user ");
			} else {
				System.out.println("Select proeper user type and then login....!!!!");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='../jsp/home.jsp';");
			   out.println("</script>");
			System.out.println("may be username or password is wrong...as.!!!!");
			request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
		}

	}

}
