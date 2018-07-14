package com.dataset;

import java.util.ArrayList;

import com.dataset.bean.DataSetBean;

public class DataSetUtil {
	public static void main(String[] args) {
		
	}

	public static ArrayList<DataSetBean> getAssingedList() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/assigned_to.xml");
		///bughunt/mozilla/Firefox/assigned_to.xml
		System.out.println("Number of buges in Assinged " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getBugStatusList() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/bug_status.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getCCList() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/cc.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean>getComponentList() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/component.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getopSys() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/op_sys.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getProarity() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/priority.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}
	

	public static ArrayList<DataSetBean> getProduct() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/product.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getResolution() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/resolution.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getSeverity() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/severity.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getShortDesc() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/short_desc.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

	public static ArrayList<DataSetBean> getVer() {
		XMLExtractFactory extractFactory = new XMLExtractFactory();
		ArrayList<DataSetBean> reposrtList;
		reposrtList = new ArrayList<>();
		reposrtList = extractFactory.Parse(0, "../bughunt/mozilla/Firefox/version.xml");
		System.out.println("Number of buges in status " + reposrtList.size());
		return reposrtList;
	}

}
