package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.DeveloperBeaN;
import com.db.DBcon;

import com.utils.Constant;

public class DeveloperDao {
	Connection con = DBcon.getConnecation();

	public boolean insertProduct(DeveloperBeaN bean) {
		boolean isInsert = false;
		String name = bean.getName();
		String tech = bean.getTech();
		String team = bean.getTeam();
		String email = bean.getEmail();
		// int pc = bean.getPc();
		int exp = bean.getExp();
		// int rannk = bean.getRank();
		// int status = bean.getStatus();
		try {
			PreparedStatement ps = con.prepareStatement(Constant.QUERY_INSERT_DEVELOPER);
			ps.setString(1, name);
			ps.setString(2, tech);
			ps.setString(3, team);
			ps.setInt(4, 0);
			ps.setInt(5, exp);
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			ps.setString(8, email);
			ps.setString(9, bean.getPassword());
			int a = ps.executeUpdate();
			if (a > 0) {
				isInsert = true;
				System.out.println("Develeoper inserteed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}
	
	public boolean syncDeveloper(DeveloperBeaN bean) {
		boolean isInsert = false;
		String name = bean.getName();
		String tech = bean.getTech();
		String team = bean.getTeam();
		String email = bean.getEmail();
		// int pc = bean.getPc();
		int exp = bean.getExp();
		// int rannk = bean.getRank();
		// int status = bean.getStatus();
		try {
			PreparedStatement ps = con.prepareStatement(Constant.QUERY_SYNC_DEVELOPER);
			ps.setString(1, name);
			ps.setString(2, tech);
			ps.setString(3, team);
			ps.setInt(4, 0);
			ps.setInt(5, exp);
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			ps.setString(8, email);
			int a = ps.executeUpdate();
			if (a > 0) {
				isInsert = true;
				System.out.println("Develeoper inserteed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}

	 
}
