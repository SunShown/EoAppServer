package com.liu.xutils.pojo;



import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.liu.util.ValueSearch;

public class ApproveRule implements Serializable, Comparable<ApproveRule> {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@ValueSearch("id")
private int id;
@ValueSearch("approvetypeId")
private int approvetypeId;
@ValueSearch("shunxu")
private String shunxu;
@ValueSearch("limit")
private double  limit;
@ValueSearch("limitcolumnid")
private int limitcolumnid;
@ValueSearch("companyId")
private long companyId;
private String[] shunxulist;

public ApproveRule() {
	super();
}



public ApproveRule(int id, int approvetypeId, String shunxu, double limit,
		int limitcolumnid, long companyId, List<User> shunxulist) {
	super();
	this.id = id;
	this.approvetypeId = approvetypeId;
	this.shunxu = shunxu;
	this.limit = limit;
	this.limitcolumnid = limitcolumnid;
	this.companyId = companyId;
	
}





public String[] getShunxulist() {
	return shunxulist;
}



public void setShunxulist(String[] shunxulist) {
	this.shunxulist = shunxulist;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getApprovetypeId() {
	return approvetypeId;
}
public void setApprovetypeId(int approvetypeId) {
	this.approvetypeId = approvetypeId;
}
public String getShunxu() {
	return shunxu;
}
public void setShunxu(String shunxu) {
	this.shunxu = shunxu;
}
public double getLimit() {
	return limit;
}
public void setLimit(double limit) {
	this.limit = limit;
}
public int getLimitcolumnid() {
	return limitcolumnid;
}
public void setLimitcolumnid(int limitcolumnid) {
	this.limitcolumnid = limitcolumnid;
}
public long getCompanyId() {
	return companyId;
}
public void setCompanyId(long companyId) {
	this.companyId = companyId;
}

public int compareTo(ApproveRule o) {
	if(this.getLimit()>o.getLimit()){return -1; }
	else if(this.getLimit()>o.getLimit()){return 1; }
	else{	return 0;}
}



@Override
public String toString() {
	return "ApproveRule [id=" + id + ", approvetypeId=" + approvetypeId
			+ ", shunxu=" + shunxu + ", limit=" + limit + ", limitcolumnid="
			+ limitcolumnid + ", companyId=" + companyId + ", shunxulist="
			+ shunxulist + "]";
}








}
