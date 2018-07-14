package com.db;

public class QueryContants {
	
	// Table constants.
	public static String TABLE_PROJECT_MASTER = "project_master";
	
	
	
	// Query Constants Project.
	public static String QUERY_INSERT_PROJECT = "INSERT INTO `"+TABLE_PROJECT_MASTER+"`(`name`, `category`, `bc`, `dc`, `tc`, `status`) VALUES (?,?,?,?,?,?)";
	
	public static String QUERY_INSERT_DEVELOPER="INSERT INTO `developer_master`( `name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status`) VALUES (?,?,?,?,?,?,?);";
}
