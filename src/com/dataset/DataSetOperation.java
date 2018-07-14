package com.dataset;

import java.util.ArrayList;

import com.bean.DeveloperBeaN;
import com.dao.DataSetDao;
import com.dao.DeveloperDao;
import com.dao.ProjectDao;
import com.utils.Comman;

public class DataSetOperation {
	public static void main(String argd[]) {
		DataSetOperation dao = new DataSetOperation();
		dao.insetDataSetInToSlaveTables();
	}

	public void insetDataSetInToSlaveTables() {
		DataSetDao dao = new DataSetDao();
		syncDeveloper();
		/**
		 * Step 1
		 */
		
		dao.insertAssignTo();
		dao.insertBugCC();
		dao.insertBugDisp();
		dao.insertBugOS();
		dao.insertBugProarity();
		dao.insertBugProduct();
		dao.insertBugStatus();
		dao.insertComponant();
		dao.insertResolution();
		dao.insertVer();
		dao.insertSeverity();

		/**
		 * Step 2
		 */
		//dao.getBasicData();
		//System.out.println(Comman.getVersion());
		

		/**
		 * Step 3
		 */
		//dao.insertIntoBugMaster();
		

		/**
		 * Step 4
		 */
		//syncDeveloper();
		
		
		
		//project 
		//ProjectDao dao2 = new ProjectDao();
		//dao2.getAllUnSolvedBuges("asqueella@gmail.com");
	}
	
	
	
	/**
	 * bello fun is used for syncronized data in developer table and bugmaster table.
	 * when bug date is generated from  data set that time the bug data contains randon 
	 * developers. so we add develper from genefrated data and for that we use bello method.
	 * 
	 */
	public void syncDeveloper(){
		DataSetDao dao = new DataSetDao();
		 ArrayList<DeveloperBeaN> list =dao.getSysncBean();
		 DeveloperDao dao2 = new DeveloperDao();
		 for(DeveloperBeaN bean:list){
			 dao2.syncDeveloper(bean);
		 }
	}
	
}
