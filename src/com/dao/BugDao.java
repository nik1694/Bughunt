package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BugBean;
import com.bean.DeveloperBeaN;
import com.dataset.bean.BugMaster;
import com.db.DBcon;
import com.utils.Constant;

public class BugDao {

	Connection con = DBcon.getConnecation();

	public boolean insertSlaveProduct(BugBean master) {
		boolean isInsert = false;
		// `bugDisc`, `dev`, `pname`, `version`, `status`,
		// `os`, `priority`, `reasion`, `solution`, `rid`
		try {
			PreparedStatement ps = con.prepareStatement(Constant.QUERY_INSERT_BUG_SLAVE);
			ps.setString(1, master.getBugDisc());
			ps.setString(2, master.getPname());
			ps.setString(3, master.getVsersion());
			ps.setInt(4, master.getStatus());
			ps.setString(5, master.getOs());
			ps.setInt(6, master.getPriority());
			ps.setString(7, master.getResion());
			int a = ps.executeUpdate();
			if (a > 0) {
				isInsert = true;
				System.out.println("Develeoper inserteed");
				// removeFromTemp();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}

	public ArrayList<BugBean> getNewBuges() {
		ArrayList<BugBean> result = new ArrayList<>();
		try {
			String query = "SELECT `id`, `bugDisc`, `dev`, `pname`, "
					+ "`version`, `status`, `os`, `priority`, `reasion`, "
					+ "`solution`, `rid` FROM `bug_init` WHERE 1";
			PreparedStatement ps = con.prepareStatement(query);
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
				result.add(bugMaster);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean removeFromTemp(long fid) {
		boolean s = false;
		try {
			String query = "DELETE FROM `bug_init` WHERE `id` = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, fid);
			int d = ps.executeUpdate();
			if (d > 0) {
				s = true;
			} else {
				s = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public boolean insertbugReoprt(BugMaster master) {
		boolean isInsert = false;
		// (`bugDisc`, `dev`, `pname`, `version`, `status`, `os`,
		// `priority`, `reasion`, `solution`, `rid`, `report`)
		try {
			PreparedStatement ps = con.prepareStatement(Constant.QUERY_INSERT_BUG_REPORT);
			ps.setString(1, master.getBugDisc());
			ps.setString(2, master.getDev());
			ps.setString(3, master.getPname());
			ps.setString(4, master.getVsersion());
			ps.setInt(5,3);
			ps.setString(6, master.getOs());
			ps.setInt(7, master.getPriority());
			ps.setString(8, master.getResion());
			ps.setString(9, master.getSolution());
			ps.setString(10, "" + master.getRid());
			ps.setString(11, master.getReport());

			// convert String into InputStream
			InputStream is = new ByteArrayInputStream(master.getReport().getBytes());

			// read it with BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			br.close();
			//ps.setBlob(8, is);
			int a = ps.executeUpdate();
			if (a > 0) {
				isInsert = true;
				System.out.println("Develeoper inserteed");
				// removeFromTemp();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}

}
