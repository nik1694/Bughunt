package com.bean;

import java.util.ArrayList;

public class FilterResultBean {
long id;
long fid;
String developerId;
int weight;
String soln;
ArrayList<BugBean> round1,round2,round3,round4;

public ArrayList<BugBean> getRound1() {
	return round1;
}
public void setRound1(ArrayList<BugBean> round1) {
	this.round1 = round1;
}
public ArrayList<BugBean> getRound2() {
	return round2;
}
public void setRound2(ArrayList<BugBean> round2) {
	this.round2 = round2;
}
public ArrayList<BugBean> getRound3() {
	return round3;
}
public void setRound3(ArrayList<BugBean> round3) {
	this.round3 = round3;
}
public ArrayList<BugBean> getRound4() {
	return round4;
}
public void setRound4(ArrayList<BugBean> round4) {
	this.round4 = round4;
}
public String getSoln() {
	return soln;
}
public void setSoln(String soln) {
	this.soln = soln;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getFid() {
	return fid;
}
public void setFid(long fid) {
	this.fid = fid;
}
public String getDeveloperId() {
	return developerId;
}
public void setDeveloperId(String developerId) {
	this.developerId = developerId;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
}
