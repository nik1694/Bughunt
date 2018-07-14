package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataSetDao;
import com.dataset.DataSetOperation;

/**
 * Servlet implementation class AddBugFromDataSet
 */
@WebServlet("/AddBugFromDataSet")
public class AddBugFromDataSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBugFromDataSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*DataSetDao dao = new DataSetDao();
		response.getWriter().append("Starting trancation");
		response.getWriter().append("Starting Generating Assign table..");
		dao.insertAssignTo();
		response.getWriter().append("Starting Generating BugCC tabkle, Assign Table Done");
		dao.insertBugCC();
		response.getWriter().append("Starting Generating Bug Discription Table. BugCC tabkle Done");
		dao.insertBugDisp();
		response.getWriter().append("Starting Generating  Bug Os ,Bug Discription Table Done");
		dao.insertBugOS();
		response.getWriter().append("Starting Generating Bug Proarity Table,Bug Os Table Done");
		dao.insertBugProarity();
		response.getWriter().append("Starting Generating Bug Product Table, Bug Proarity Table Done");
		dao.insertBugProduct();
		response.getWriter().append("Starting Generating Bug Status Table, Bug Product Table Done");
		dao.insertBugStatus();
		response.getWriter().append("Starting Generating Bug Componat Table Bug Status Table Done");
		dao.insertComponant();
		response.getWriter().append("Starting Generating Bug Resoluation Table Bug Componat Table Done");
		dao.insertResolution();
		response.getWriter().append("Starting Generating Version Table, Resoluation Table Done");
		dao.insertVer();
		response.getWriter().append("Starting Generating Severity Table,Assign Version Done");
		dao.insertSeverity();
		response.getWriter().append("Starting Generating Severity Table Done");*/
		DataSetOperation dao = new DataSetOperation();
		dao.insetDataSetInToSlaveTables();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
