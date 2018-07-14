package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.AttributeFilter;
import com.bean.BugBean;
import com.bean.FilterResultBean;
import com.dao.BugDao;
import com.dao.DataSetDao;
import com.dataset.bean.BugMaster;
import com.sun.mail.util.MailSSLSocketFactory;

/**
 * Servlet implementation class AssignBugToDeveloper
 */
@WebServlet("/AssignBugToDeveloper")
public class AssignBugToDeveloper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignBugToDeveloper() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession httpSession = request.getSession();
		BugBean bean = (BugBean) httpSession.getAttribute("bugbean");
		
		System.out.println("decs : " + bean.getBugDisc());
		System.out.println("developer: " + bean.getDev());
		System.out.println("os: " + bean.getOs());
		System.out.println("pname : " + bean.getPname());
		System.out.println("proarity: " + bean.getPriority());
		System.out.println("rid: " + bean.getRid());
		System.out.println("soln : " + bean.getSolution());
		System.out.println("Status " + bean.getStatus());
		System.out.println("team: " + bean.getTeam());
		System.out.println("version : " + bean.getVsersion());
		

		AttributeFilter as = new AttributeFilter();

		ArrayList<FilterResultBean> d = as.filterDeveloperDataGetMostMatchDeveloperList(bean);
		for (int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i).getWeight());
		}
		d = sort(d, 0, d.size() - 1);
		for (int i = 0; i < d.size(); i++) {
			System.out.println("After : " + d.get(i).getWeight());
		}
		BugMaster master = new BugMaster();
		master.setBugDisc(bean.getBugDisc());
		master.setRid(bean.getId());
		master.setOs(bean.getOs());
		master.setPname(bean.getPname());
		master.setPriority(bean.getPriority());
		master.setResion(bean.getResion());
		master.setSolution(d.get(d.size() - 1).getSoln());
		master.setStatus(bean.getStatus());
		master.setDev(d.get(1).getDeveloperId());
		String repo = "";
		String head = "The selecet developer is " + d.get(1).getDeveloperId();
		String ir1 = "****************************Result of it1 *****************************************\n\n\n\n\n\n\n "
				+ getDataFromArrayList(d.get(1).getRound1());
		String ir2 = "****************************Result of it2 *****************************************\n\n\n\n\n\n\n "
				+ getDataFromArrayList(d.get(1).getRound2());
		String ir3 = "****************************Result of it3 ***************************************** \n\n\n\n\n\n\n"
				+ getDataFromArrayList(d.get(1).getRound3());
		String ir4 = "****************************Result of it4 ***************************************** \n\n\n\n\n\n\n"
				+ getDataFromArrayList(d.get(1).getRound4());
		repo = head + ir1 + ir2 + ir3 + ir4;
		master.setReport(repo);
		master.setVsersion(bean.getVsersion());

		System.out.println("decs : " + master.getBugDisc());
		System.out.println("developer: " + master.getDev());
		System.out.println("os: " + master.getOs());
		System.out.println("pname : " + master.getPname());
		System.out.println("proarity: " + master.getPriority());
		System.out.println("rid: " + master.getRid());
		System.out.println("soln : " + master.getSolution());
		System.out.println("Status " + master.getStatus());
		System.out.println("version : " + master.getVsersion());
		System.out.println("version : " + bean.getVsersion());
		DataSetDao dao = new DataSetDao();
		boolean s = false;

	    s = dao.insertIntoBugMaster(master);
		BugDao bugDao = new BugDao();

		 bugDao.insertbugReoprt(master);

		if (s) {
			response.getWriter().append("Bug Assinged to deleloer :  " + master.getDev())
					.append(request.getContextPath());
		} else {
			response.getWriter().append("Bug not Assinged").append(request.getContextPath());
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

	public String getDataFromArrayList(ArrayList<BugBean> ar1) {
		String str = "";
		for (int i = 0; i < ar1.size(); i++) {
			String def = "\n______________________________________________________________________________________\n";
			str = def + str + " || " + ar1.get(i).getId() + " || " + ar1.get(i).getDev() + " || "
					+ ar1.get(i).getReport() + " || " + ar1.get(i).getSolution() + "\n";
		}
		return str;
	}

	public static ArrayList<FilterResultBean> sort(ArrayList<FilterResultBean> contacts, int low, int high) {
		int numbers[] = new int[contacts.size()];
		// System.out.println(contacts.size());
		for (int i = 0; i < contacts.size(); i++) {
			numbers[i] = contacts.get(i).getWeight();
		}
		// System.out.println(numbers.length);
		// for(int i=0;i<numbers.length;i++)
		// System.out.println(numbers[i]);

		int n = numbers.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (numbers[j - 1] > numbers[j]) {
					// swap elements
					temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
					Collections.swap(contacts, j, j - 1);
				}

			}
		}
		// for(int i=0; i<contacts.size();i++)
		// {
		// System.out.println(contacts.get(i).getValue());
		// }
		// for(int i=0;i<numbers.length;i++)
		// System.out.println(numbers[i]);
		//
		return contacts;
	}
}
