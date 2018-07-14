package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProjectBean;
import com.dao.ProjectDao;
import com.utils.Log;

/**
 * Servlet implementation class AddProject
 */
@WebServlet("/AddProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pname = request.getParameter("txtPName");
		String pcategory = request.getParameter("txtPCategory");
		Log.s("pane "+pname);
		Log.s("pcategory "+pcategory);
		ProjectBean bean = new ProjectBean();
		bean.setName(pname);
		bean.setCatgory(pcategory);
		bean.setBc(0);
		bean.setDc(0);
		bean.setTc(0);
		bean.setStatus(0);
		
		ProjectDao dao = new ProjectDao();
		
		int status = dao.insertNewProject(bean);
		
		Log.c("status "+status);
		
		if(status>0){
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Product Added ');");
			   out.println("location=' jsp/AddProject.jsp';");
			   out.println("</script>");
			System.out.println("AddProject.jsp!!!!");
			//request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
		
			//response.sendRedirect(request.getContextPath()+"/jsp/AddProject.jsp");
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
