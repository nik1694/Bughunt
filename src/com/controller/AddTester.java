package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DeveloperBeaN;
import com.bean.TesterBean;
import com.dao.DeveloperDao;
import com.dao.TesterDao;
import com.utils.EmailUtil;

/**
 * Servlet implementation class AddTester
 */
@WebServlet("/AddTester")
public class AddTester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TesterBean bean = new TesterBean();
		System.out.println("txtName : "+request.getParameter("txtName"));
		System.out.println("txtEmail: "+request.getParameter("txtEmail"));
		System.out.println("txtTeam : "+request.getParameter("txtTeam"));
		System.out.println("txtTech : "+request.getParameter("txtTech"));
		System.out.println("txtPass : "+request.getParameter("txtPass"));
		System.out.println("txtExp : "+request.getParameter("txtExp"));
		
		System.out.println(""+request.getParameter("txtName"));
		System.out.println("add tester controller");
		bean.setName(request.getParameter("txtName"));
		bean.setEmail(request.getParameter("txtEmail"));
		bean.setTeam(request.getParameter("txtTeam"));
		bean.setTech(request.getParameter("txtTech"));
		bean.setPassword(""+request.getParameter("txtPass"));
		bean.setExp(Integer.parseInt(request.getParameter("txtExp")));
		//EmailUtil.sendEmail("your password is "+request.getParameter("txtPass"), "Wecome to bughunt", request.getParameter("txtEmail"));
		TesterDao dao = new TesterDao();
		boolean a = dao.AddTester(bean);
		if (a) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Tester Added ');");
			out.println("location=' jsp/AddTester.jsp';");
			out.println("</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Tester Not Added');");
			out.println("location=' jsp/AddTester.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
