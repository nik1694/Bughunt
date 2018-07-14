package com.algo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BugBean;
import com.dataset.bean.BugMaster;
import com.db.DBcon;
import com.utils.SVMQueryUtil;

public class SVMQDQ {
	// WHERE `version` LIKE 'v1' AND `status` =1 AND `os` LIKE 'ubantu'
	// * AND `priority` =1 LIMIT 0 , 30";
	Connection con = DBcon.getConnecation();
	SVMQueryUtil svmQueryUtil = new SVMQueryUtil();

	public ArrayList<BugBean> classfiyAndGetResult(int distance, BugBean bean) {
		String query = svmQueryUtil.getBugQuery(distance);
		System.out.println("Query : " + query);
		System.out.println("distance : " + distance);
		// PreparedStatement ps;
		ArrayList<BugBean> result = new ArrayList<>();
		try {

			if (distance == 2) {
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, bean.getVsersion());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					BugBean bugMaster = new BugBean();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setSolution((rs.getString(10)));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					result.add(bugMaster);
				}
			} else if (distance == 3) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, bean.getVsersion());
				ps.setInt(2, bean.getStatus());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					BugBean bugMaster = new BugBean();
					bugMaster.setSolution((rs.getString(10)));
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
					result.add(bugMaster);
				}
			} else if (distance == 4) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, bean.getVsersion());
				ps.setInt(2, bean.getStatus());
				ps.setString(3, bean.getPname());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					BugBean bugMaster = new BugBean();
					bugMaster.setId(rs.getInt(1));
					bugMaster.setSolution((rs.getString(10)));
					bugMaster.setBugDisc(rs.getString(2));
					bugMaster.setDev(rs.getString(3));
					bugMaster.setPname(rs.getString(4));
					bugMaster.setVsersion(rs.getString(5));
					bugMaster.setStatus(rs.getInt(6));
					bugMaster.setOs(rs.getString(7));
					bugMaster.setPriority(rs.getInt(8));
					bugMaster.setResion(rs.getString(9));
					bugMaster.setSolution((rs.getString(10)));
					bugMaster.setRid(Long.parseLong(rs.getString(11)));
					result.add(bugMaster);
				}
			} else if (distance == 5) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, bean.getVsersion());
				ps.setInt(2, bean.getStatus());
				ps.setString(3, bean.getPname());
				ps.setInt(4, bean.getPriority());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					BugBean bugMaster = new BugBean();
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
					result.add(bugMaster);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
