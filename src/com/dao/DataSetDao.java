package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BugBean;
import com.bean.DeveloperBeaN;
import com.dataset.DataSetUtil;
import com.dataset.bean.BugMaster;
import com.dataset.bean.DataSetBean;
import com.db.DBcon;
import com.utils.Comman;
import com.utils.Constant;

public class DataSetDao {
	Connection con = DBcon.getConnecation();

	public boolean insertAssignTo() {
		String sql = "INSERT INTO `ds_assign_to` VALUES (?,?,?);";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getAssingedList();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_assign_to Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugDisp() {
		String sql = "INSERT INTO `ds_bug_disp` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getShortDesc();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We  are breakinging transctions  ds_bug_disp");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_bug_disp Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugStatus() {
		String sql = "INSERT INTO `ds_bug_status` VALUES (?,?,?);";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getBugStatusList();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_bug_status Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugCC() {
		String sql = "INSERT INTO `ds_cc` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getCCList();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_cc Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertComponant() {
		String sql = "INSERT INTO `ds_componant` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getComponentList();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_componant Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugOS() {
		String sql = "INSERT INTO `ds_os` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getopSys();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_os Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugProarity() {
		String sql = "INSERT INTO `ds_proarity` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getProarity();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_proarity Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertBugProduct() {
		String sql = "INSERT INTO `ds_product`  VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getProduct();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_product Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertResolution() {
		String sql = "INSERT INTO `ds_resolution` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getResolution();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				/*
				 * if(i>Constant.RECORD_LIMIT){
				 * System.out.println("We are breakinging transctions"); break;
				 * }
				 */
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_resolution Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertSeverity() {
		String sql = "INSERT INTO `ds_sevirity` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getSeverity();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_sevirity Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean insertVer() {
		String sql = "INSERT INTO `ds_version` VALUES (?,?,?)";
		boolean status = false;
		ArrayList<DataSetBean> reportList = DataSetUtil.getVer();
		try {
			for (int i = 0; i < reportList.size(); i++) {
				if (i > Constant.RECORD_LIMIT) {
					System.out.println("We are breakinging transctions");
					break;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, reportList.get(i).getId());
				ps.setString(2, reportList.get(i).getWhat());
				ps.setLong(3, reportList.get(i).getWhen());
				ps.executeUpdate();
				System.out.println("ds_version Record " + i + " is inserted ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public ArrayList<BugMaster> getBasicData(){
		ArrayList<BugMaster> dList = new ArrayList<>();
		{
			try {
			PreparedStatement ps = con.prepareStatement(Constant.QUERY_LL);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				BugMaster bugMaster = new BugMaster();
				bugMaster.setRid(resultSet.getLong(1));
				bugMaster.setDev(resultSet.getString(2));
				bugMaster.setBugDisc(resultSet.getString(3));
				System.out.println("rid : "+resultSet.getLong(1));
				dList.add(bugMaster);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dList;
		}
		}
	
	public ArrayList<BugMaster> getAdvanceData(){
		ArrayList<BugMaster> dList = getBasicData();
		for(int i = 0;i < dList.size();i++){
			dList.get(i).setStatus(Comman.getStatus(1, 4));
			dList.get(i).setPriority(Comman.getPriority(1, 3));
			dList.get(i).setPname("FireFox");
			dList.get(i).setVsersion(Comman.getVersion());
			dList.get(i).setResion(Comman.getReasion());
			dList.get(i).setOs(Comman.getOS());
			dList.get(i).setSolution(Comman.getSolution());
		}
		return dList;
	}
	public int insertIntoBugMaster(){
		ArrayList<BugMaster> dList = getAdvanceData();
		int count = 0;
		try {
			for(int i = 0;i < dList.size();i++){
				BugMaster master = dList.get(i);
				//(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, `priority`, `reasion`, `solution`)
			PreparedStatement ps = con.prepareStatement(Constant.insertAdvanceData);
			ps.setString(1, master.getBugDisc());
			ps.setString(2, master.getDev());
			ps.setString(3, master.getPname());
			ps.setString(4, master.getVsersion());
			ps.setInt(5, master.getStatus());
			ps.setString(6, master.getOs());
			ps.setInt(7, master.getPriority());
			ps.setString(8, master.getResion());
			ps.setString(9, master.getSolution());
			ps.setString(10, ""+master.getRid());
			int a = ps.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean insertIntoBugMaster( BugMaster master){
		
		ArrayList<BugMaster> dList = getAdvanceData();
		int count = 0;
		boolean s = false;
		String developerId = "Bug is not assinged to developer";
		try {
			//(`id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, `priority`, `reasion`, `solution`)
			PreparedStatement ps = con.prepareStatement(Constant.insertAdvanceData);
			ps.setString(1, master.getBugDisc());
			ps.setString(2, master.getDev());
			ps.setString(3, master.getPname());
			ps.setString(4, master.getVsersion());
			ps.setInt(5, master.getStatus());
			ps.setString(6, master.getOs());
			ps.setInt(7, master.getPriority());
			ps.setString(8, master.getResion());
			ps.setString(9, master.getSolution());
			ps.setString(10, ""+master.getRid());
			int a = ps.executeUpdate();
			if(a>0){
				s = true;
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				developerId = "Bug is assinged to developer : "+ master.getDev();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				BugDao bugDao = new BugDao();
				bugDao.removeFromTemp(master.getRid());
			}else{
				s = false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(developerId);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		return s;
	}
	
   public ArrayList<DeveloperBeaN> getSysncBean(){
	   //INSERT INTO `developer_master`(`name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status` , `email`)
	   //+VALUES (?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE `email` = '?';
	   ArrayList<DeveloperBeaN> arrayList = new ArrayList<>();
	   ArrayList<String> emails = new ProjectDao().getDeveloperList();
	   for(int i=0;i<emails.size();i++){
		   DeveloperBeaN bean = new DeveloperBeaN();
			bean.setName(emails.get(i).substring(0,emails.get(i).lastIndexOf('@')-1));
			bean.setEmail(emails.get(i));
			bean.setTeam(""+Comman.getStatus(1, 10));
			bean.setTech(Comman.getTech());
			bean.setExp(Comman.getStatus(1, 4));   
			arrayList.add(bean);
	   }
	   return arrayList;
		
	}
}
