package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProjectBean;
import com.dataset.bean.BugMaster;
import com.db.DBcon;
import com.db.QueryContants;
import com.utils.Log;

public class ProjectDao {
	Connection con = DBcon.getConnecation();
	public int insertNewProject(ProjectBean bean) {
		int status = 0;
		try {
			

			if (con != null) {
				Log.d("PROJECT NAME " + bean.getName());
				Log.d("PROJECT CATEGORY " + bean.getCatgory());
				Log.d("PROJECT BUG COUNT " + bean.getBc());
				Log.d("PROJECT DEVELOPER COUNT " + bean.getDc());
				Log.d("PROJECT TESTER COUNT " + bean.getTc());
				Log.d("PROJECT STATUS COUNT " + bean.getStatus());
			} else {
				Log.d("con null ");
			}

			Log.d("Load bean ");
			Log.d("Load Statement ");
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `project_master`(`name`, `category`, `bc`, `dc`, `tc`, `status`) VALUES (?,?,?,?,?,?)");
			Log.d("setting valuse ");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getCatgory());
			ps.setInt(3, bean.getBc());
			ps.setInt(4, bean.getDc());
			ps.setInt(5, bean.getTc());
			ps.setInt(6, bean.getStatus());

			Log.d("PROJECT NAME " + bean.getName());
			Log.d("PROJECT CATEGORY " + bean.getCatgory());
			Log.d("PROJECT BUG COUNT " + bean.getBc());
			Log.d("PROJECT DEVELOPER COUNT " + bean.getDc());
			Log.d("PROJECT TESTER COUNT " + bean.getTc());
			Log.d("PROJECT STATUS COUNT " + bean.getStatus());

			status = ps.executeUpdate();

			System.out.println(status);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public int getBugTotalCount() {
		//SELECT COUNT (*) FROM `ds_assign_to`
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM `bug_master_advance` WHERE 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int getSolvedBugCount() {
		//"SELECT COUNT(*) FROM `bug_master_advance` WHERE status = 4"
				int count = 0;
				try {
					PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM `bug_master_advance` WHERE status = 4");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						count = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
	}

	public int getNotSolvedBugCount() {
		//SELECT COUNT(*) FROM bug_master_advance WHERE id NOT IN ( SELECT id FROM `bug_master_advance` WHERE status = 4)
		int count = 0;
				try {
					PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM bug_master_advance WHERE id NOT IN ( SELECT id FROM `bug_master_advance` WHERE status = 4)");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						count = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
	}
	
	public ArrayList<String> getDeveloperList() {
		//SELECT distinct `dev` FROM `bug_master_advance` WHERE 1
		ArrayList<String> count = new ArrayList<>();
				try {
					PreparedStatement ps = con.prepareStatement("SELECT distinct `dev` FROM `bug_master_advance` WHERE 1");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						count.add(rs.getString(1));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
	}
	
	public ArrayList<BugMaster> getAllBuges(String devId){
		 ArrayList<BugMaster> allBuges = new ArrayList<>();
		 try {
			 //bug_master_advance`(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, 
			 //`priority`, `reasion`, `solution`, `rid`
				PreparedStatement ps = con.prepareStatement("SELECT * FROM `bug_master_advance` WHERE `dev` = ?");
				ps.setString(1, devId);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					BugMaster bugMaster = new BugMaster();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					allBuges.add(bugMaster);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 System.out.println("Number of buges found "+allBuges.size());
		 return allBuges;
	}
	public ArrayList<BugMaster> getAllTopBuges(String devId){
		 ArrayList<BugMaster> allBuges = new ArrayList<>();
		 try {
			 //bug_master_advance`(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, 
			 //`priority`, `reasion`, `solution`, `rid`
				PreparedStatement ps = con.prepareStatement("SELECT * FROM `bug_master_advance` WHERE `dev` = ?");
				ps.setString(1, devId);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					BugMaster bugMaster = new BugMaster();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					allBuges.add(bugMaster);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 System.out.println("Number of buges found "+allBuges.size());
		 return allBuges;
	}
	
	public ArrayList<BugMaster> getAllUnSolvedBuges(String devId){
		 ArrayList<BugMaster> allBuges = new ArrayList<>();
		 try {
			 //bug_master_advance`(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, 
			 //`priority`, `reasion`, `solution`, `rid`
				PreparedStatement ps = con.prepareStatement("SELECT * FROM bug_master_advance WHERE dev = ? and id NOT IN ( SELECT id FROM `bug_master_advance` WHERE status = 4)");
				ps.setString(1, devId);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					BugMaster bugMaster = new BugMaster();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					allBuges.add(bugMaster);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 System.out.println("Number of buges found "+allBuges.size());
		 return allBuges;
	}
	public ArrayList<BugMaster> getAllSolvedBuges(String devId){
		 ArrayList<BugMaster> allBuges = new ArrayList<>();
		 try {
			 //bug_master_advance`(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, 
			 //`priority`, `reasion`, `solution`, `rid`
				PreparedStatement ps = con.prepareStatement("SELECT * FROM `bug_master_advance` WHERE status = 4 and dev = ?");
				ps.setString(1, devId);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					BugMaster bugMaster = new BugMaster();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					allBuges.add(bugMaster);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 System.out.println("Number of buges found "+allBuges.size());
		 return allBuges;
	}
	/*
	public int getBugCount() {
		int count = 0;
		return count;
	}*/
}
