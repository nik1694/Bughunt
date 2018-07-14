package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.bean.DBconSql;

public class DBcon implements DBconSql {
	public static Connection con = null;
	static {
		try {
			Class.forName(drv);
			System.out.println("Driver Loading....!");
			con = DriverManager.getConnection(con1 + db, un, ps);
			System.out.println("Connecting to DataBase");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnecation() {
		
		System.out.println("inside connection ");
		System.out.println("inside conn"+con1);
		System.out.println("inside pw "+un);
		
		return con;
	}
}
