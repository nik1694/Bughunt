package com.utils;

public class Constant {
	public static boolean printLogFlag = true;
	public static boolean printTestLog = true;
	public static String appName = "shekar";
	public static String userTypeUser = "3";
	public static String userTypeAdmin = "admin";
	public static String userTypeAgent = "2";
	
	public static String QUERY_INSERT_NEW_PARKING = "insert into parking_master (pname, city, totalslots, avaslotes, parkingtype, lat, lng) values(?,?,?,?,?,?,?);";
	public static String QUERY_INSERT_NEW_AGENT = "insert into agent_master (aname, uname, acity, anum, aemail, aparking) values(?,?,?,?,?,?);";
	public static String QUERY_SEARCH_ALL_AGENT = "select * from agent_master;";
	public static String QUERY_SEARCH_ALL_AGENT_BY_ID = "select * from agent_master where id= ?;";
	public static String QUERY_SEARCH_DELET_AGENT_PID = "delete from agent_master where id = ?;";
	public static String QUERY_UPDATE_AGENT = "UPDATE agent_master SET aname = ?,uname = ?,acity = ?, anum = ?, aemail = ? WHERE id = ?";

	// i keep inverted commas as it is.
	public static String QUERY_UPDATE_PARKING = "UPDATE `parking_master` SET `pname`= ?,`city`= ?,`totalslots`= ?,`avaslotes`= ?,`parkingtype`= ?,`lat`= ?,`lng`= ? WHERE  pid = ?";
	public static String QUERY_SEARCH_ALL_PARKINGS = "SELECT * FROM `parking_master` WHERE 1";
	public static String QUERY_SEARCH_DELET_PARKING_PID = "delete from parking_master  where id = ?;";

	// user sql operation

	public static String QUERY_INSERT_USR = "INSERT INTO `user`( `username`, `password`, `fname`, `lname`, `email`, `mobilenumber`, `pictureurl`, `sq`, `sa`, `uuid`, `city`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	// Insert develeoper
	
	//ddd
	public static String QUERY_LL = "SELECT ds_assign_to.rid,devid,bugdisc FROM ds_assign_to INNER JOIN ds_bug_disp ON ds_assign_to.rid = ds_bug_disp.rid;";

	public static String QUERY_INSERT_DEVELOPER = "INSERT INTO `developer_master`(`name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status` , `email`, `pass`) VALUES (?,?,?,?,?,?,?,?,?)";
	public static String QUERY_INSERT_BUG_SLAVE = "INSERT INTO `bug_init`( `bugDisc`, `pname`, `version`, `status`, `os`, `priority`, `reasion`) VALUES (?,?,?,?,?,?,?)";
	public static String QUERY_INSERT_BUG_REPORT = "INSERT INTO `bug_report`(`bugDisc`, `dev`, `pname`, `version`, `status`, `os`, `priority`, `reasion`, `solution`, `rid`, `report`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	public static String QUERY_SYNC_DEVELOPER = "INSERT INTO `developer_master`(`name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status` , `email`) VALUES (?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE `email` = '?';";
	
	public static String QUERY_SYNC_TESTER = "INSERT INTO `tester_master`(`name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status` , `email`,`col`) VALUES (?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE `email` = '?';";
	public static int RECORD_LIMIT  = 0;
	public static String insertAdvanceData  =  "INSERT INTO `bug_master_advance`( `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, `priority`, `reasion`, `solution`,`rid`) VALUES (?,?,?,?,?,?,?,?,?,?)";	
	
	public static String join_demo ="select dsa.rid,dsa.delevloperId,dbd.bug_disp  from ds_assign_to dsa INNER JOIN ds_bug_disp dbd ON dsa.rid=dbd.rid;";
	
	public static String[] version = {"v1","v2","v3","v4"};
	public static int[] team = {1,2,3,4,5,6,7,8,9,10}; 
	public static int[] status = {1,2,3,4}; 
	public static String[] os = {"ubantu","Lion X","Windows NT","Windos Server 2008"};
	public static String[] tech = {"java",".net","mysql","javascript"};
	
	public static String[] reasion = {
		    "Miscommunication of requirements introduces error in code",
		    "Unrealistic time schedule for development",
		    "Lack of designing experience",
		    "Lack of coding practices experience",
		    "Human factors introduces errors in code",
		    "Lack of version control",
		    "Buggy third-party tools",
		    "Last minute changes in the requirement introduce error",
		    "Poor Software testing skill"};

	public static String[] solution = {
		    " No no-argument constructor. Java provides a no-argument constructor to each class by default (a.k.a. the default constructor). However, as soon as you add your own constructor, the compiler no longer includes the default/no-argument constructor in your class. Compilers detect direct calls to use a non-existent no-argument constructor. However, a nasty bug comes to life when you use popular frameworks like Spring or Hibernate that rely on the existence of a no-argument constructor to create instances of your classes and you forget to provide one in the class. Since these frameworks often rely on reflection rather than a direct call to the no-argument constructor, compilers are not able to detect the potential issue. Instead, you encounter a runtime exception when executing code that involves the class without the no-argument constructor and the framework (as shown in this example with Spring below).",
		    "== versus equals( ). In Java, there are two forms of equal with objects. The == operator checks to see if two object references point to the same object in memory (in heap). The equals( ) method, can and often does operate differently than the == operator. For example, when using equals( ) with String objects, Java is checking that the objects contain the same sequence of characters. Using the wrong form of ‘equal’ in conditionals can result in a bug that does not manifest itself in any immediate exception. Usually, this type of bug is detected only after carefully stepping through the code when getting unexpected application result",
		    "JDBC is 1-based. When you learn Java, you quickly commit to memory the fact that Java is a zero-based indexing language. For example, to get the first element from an array or collection, you ask to ‘get’ the item at the index of zero (0). The JDBC API, however, is one-based. Setting statement parameters, getting column data by index in result sets, etc. all start at index one (1). Depending on the situation, code that uses the wrong index may throw an SQL Exception at runtime or create a hidden data issue caught only by closely exploring the data (which may now be corrupted) in the database.",
		    "NullPointerExceptions. Unfortunately, Java compilers can sometimes warn us but not protect us from uninitialized variables, instance variables and the like. Trying to perform operations on a property, for example, that has not been initialized and points to null results in the most infamous and common runtime exception: NullPointerException.  Java provides many ways to initialize vairables (explicit initialization, init block, constructors, etc.).  Use one of them to provide default values or references for variables.",
		    "Empty Catch Blocks. Bugs are tough enough to track down without hiding exceptions that are occasionally thrown by code. Developers can be lazy and when roughing out a piece of code, some leave the catch block of try/catch code empty. An ‘I’ll-get-that-later’ mentality can end up masking a bug for a very long time. At the very least",
		    "Shadowing Attributes. Local variables can have the same name as instance or class variables. Often, this is done to help highlight how a method parameter is going to be used to set the value of an instance or class variabl",
		    "Same Name, Different Package. At the airport baggage claim, you’ll often find a sign that reads, ‘Many bags look alike.’ The connotation is that you should check the bag you pick out to make sure it is really yours before you leave the baggage claim area. The same can be said of classes and interfaces. Many classes/interfaces have the same name.",
		    " Memory Leaks. Yes, you can have memory leaks in Java even though Java has automatic garbage collection. In order for the garbage collection to work, it must be able to identify an object as garbage. If you create a long-standing reference to an object,",
		    "Concurrent Access to Shared Data. Developers often test their code by running their code and acting as a single user. It is tough, but absolutely critical, to simulate multiple, simultaneous users when testing code. Data comes in many forms"};
}
