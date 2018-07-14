package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.BugBean;
import com.bean.FilterResultBean;

public class AttributeFilter {
	/**
	 * We apply classification on basis of 4 parameter for create outer clusters
	 * and minimize then we got Optimized list of developer.
	 * 
	 */
	ArrayList<BugBean> i2;
	ArrayList<BugBean> i3;
	ArrayList<BugBean> i4;
	ArrayList<BugBean> i5;
	int efficentIttration = 5;
	BugBean bugreport;
	ArrayList<FilterResultBean> resList;

	public void AppyClssificationIttration(BugBean bean) {
		SVMQDQ svmqdq = new SVMQDQ();

		// ArrayList<BugBean> i1 = svmqdq.classfiyAndGetResult(1, bean);

		i2 = svmqdq.classfiyAndGetResult(2, bean);

		i3 = svmqdq.classfiyAndGetResult(3, bean);

		i4 = svmqdq.classfiyAndGetResult(4, bean);

		i5 = svmqdq.classfiyAndGetResult(5, bean);

	}

	public void getMostefficesntIttation() {
		if (i5.size() > 0) {
			efficentIttration = 5;
			processIttration(i5);
		} else if (i4.size() > 0) {
			efficentIttration = 4;
			processIttration(i4);
		} else if (i3.size() > 0) {
			efficentIttration = 3;
			processIttration(i3);
		} else if (i2.size() > 0) {
			efficentIttration = 2;
			processIttration(i2);
		}
	}

	public int getCommanWeightByDistances(String s1, String s2) {
		int weight = 0;
		java.util.List<String> paraList1 = new ArrayList<String>();
		paraList1 = Arrays.asList(s1.split(" "));

		java.util.List<String> paraList2 = new ArrayList<String>();
		paraList2 = Arrays.asList(s1.split(" "));

		System.out.println(paraList1);
		System.out.println(paraList1);

		int size1 = paraList1.size();
		int size2 = paraList2.size();

		int i = 0;
		Map<String, Integer> dCountMap = new HashMap<String, Integer>();

		for (int j = 0; size1 > j; j++) {
			int count = 0;
			for (i = 0; size2 > i; i++) {
				if (paraList1.get(j).equals(paraList2.get(i))) {
					count++;
					weight++;
					dCountMap.put(paraList1.get(j), count);
				}
			}
		}
		System.out.println(dCountMap);
		List<Integer> myCountList = new ArrayList<>();
		Set<String> myValueSet = new HashSet<>();
		for (Map.Entry<String, Integer> entry : dCountMap.entrySet()) {
			myCountList.add(entry.getValue());
			myValueSet.add(entry.getKey());
		}
		System.out.println(myCountList);
		System.out.println(myValueSet);
		return weight;
	}

	private ArrayList<FilterResultBean> processIttration(ArrayList<BugBean> list) {
		resList = new ArrayList<>();
		if (list.size() == 1) {
			FilterResultBean bean = new FilterResultBean();
			bean.setFid(list.get(1).getRid());
			bean.setId(list.get(1).getRid());
			bean.setWeight(1000);
			bean.setDeveloperId(list.get(1).getDev());
			bean.setSoln(list.get(1).getSolution());
			bean.setRound1(i2);
			bean.setRound2(i3);
			bean.setRound3(i4);
			bean.setRound4(i5);
			resList.add(bean);
		} else {
			for (int a = 0; a < list.size(); a++) {
				FilterResultBean bean = new FilterResultBean();
				bean.setFid(list.get(a).getRid());
				bean.setId(list.get(a).getRid());
				bean.setWeight(getCommanWeightByDistances(list.get(a).getBugDisc(), bugreport.getBugDisc()));
				bean.setDeveloperId(list.get(a).getDev());
				bean.setSoln(list.get(a).getSolution());
				bean.setRound1(i2);
				bean.setRound2(i3);
				bean.setRound3(i4);
				bean.setRound4(i5);
				resList.add(bean);
			}
		}
		return resList;
	}

	public ArrayList<FilterResultBean> filterDeveloperDataGetMostMatchDeveloperList(BugBean bean) {
		bugreport = bean;
		AppyClssificationIttration(bugreport);
		getMostefficesntIttation();
		
		return resList;
	}
}
