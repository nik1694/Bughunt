package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.DBconSql;
import com.bean.UserBean;
import com.db.DBcon;
import com.utils.Constant;
import com.utils.DBConstant;

public class UserOperations implements DBconSql{
	Connection con = DBcon.getConnecation();
	public boolean validateUser(UserBean bean, String userType) {
		
		boolean status = false;
		String userName = bean.getUserName();
		String passWord = bean.getPassWord();
		System.out.println(userName);
		System.out.println(passWord);
		System.out.println(userType);
		//Dont remove bellow code it is for testing purpose 
		
		/*String userName = "1";
		 String passWord = "1";
		*//*try {
			Class.forName(drv);
			System.out.println("Driver Loading....!");
			con = DriverManager.getConnection(con1 + db, un, ps);
			System.out.println("Connecting to DataBase");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		switch (userType) {
		case "admin":
			if (userName.equals("admin") && passWord.equals("admin")) {
				System.out.println("You are Admin");
				status = true;
			}
			break;

		case "2":
			try {
				System.out.println("Inside Developer initilize data");
				PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `developer_master` WHERE `email` = ? and `pass` = ?;");
				System.out.println("Adding params..");
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, passWord);
				System.out.println("Excecuting Query.."); 
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					status = true;
					System.out.println("$ "+userName+" user login sucessfuly");
				}
				System.out.println("Login Operation Done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "3":
			try {
				System.out.println("Inside Tester initilize data");
				PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `tester_master` WHERE `email` = ? and `col` = ?;");
				System.out.println("Adding params..");
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, passWord);
				System.out.println("Excecuting Query.."); 
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					status = true;
					System.out.println("$ "+userName+" user login sucessfuly");
				}
				System.out.println("Login Operation Done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		default:
			break;
		}

		return status;

	}

	public int addNewUser(UserBean bean) {
		PreparedStatement ps;
		int status =0;
		try {
			//public static String QUERY_INSERT_USR = "INSERT INTO `user`(`id`, `username`, 
			//`password`, `fname`, `lname`, `email`, `mobilenumber`, `pictureurl`, 
			//	`sq`, `sa`, `uuid`, `city`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			ps =  con.prepareStatement(Constant.QUERY_INSERT_USR);
			ps.setString(1, bean.getUserName());
			ps.setString(2, bean.getPassWord());
			ps.setString(3, bean.getFname());
			ps.setString(4, bean.getLname());
			ps.setString(5, bean.getEmail());
			ps.setString(6, bean.getMobileNumber());
			ps.setString(7, bean.getPictureUrl());
			ps.setString(8, bean.getSecurityQuestion());
			ps.setString(9, bean.getAnsware());
			ps.setString(10, bean.getUuid());
			ps.setString(11, bean.getCity());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public void activateUser() {

	}

	public void deacticvateUser() {

	}

	public void removeUser() {

	}
}
