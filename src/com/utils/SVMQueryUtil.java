package com.utils;

public class SVMQueryUtil {
	// `id`, `bugDisc`, `dev`, `pname`, `version`, `status`, `os`, `priority`,
	// `reasion`

	/**
	 * 
	 * @return WHERE `version` LIKE 'v1' AND `status` =1 AND `os` LIKE 'ubantu'
	 *         AND `priority` =1 LIMIT 0 , 30";
	 */
	public  String getBugQuery(int insdex) {
		String query = "SELECT * FROM `bug_master_advance`;";
		switch(insdex){
		case 1:
			query = "SELECT * FROM `bug_master_advance`;";
			break;
		case 2:
			query = "SELECT * FROM `bug_master_advance` WHERE `version` LIKE ?;";
			break;
		case 3:
			query = "SELECT * FROM `bug_master_advance` WHERE `version` LIKE ?  AND `status` = ?;";
			
			break;
		case 4:
			query = "SELECT * FROM `bug_master_advance` WHERE `version` LIKE ?  AND `status` = ? AND `os` LIKE ?;";
			break;
		case 5:
			query = "SELECT * FROM `bug_master_advance` WHERE `version` LIKE ?  AND `status` = ? AND `os` LIKE ? AND `priority` = ?;";
			break;
		case 6:
			break;
		}
		return query;
	}
}
