package com.liu.xutils.pojo;

import java.sql.Timestamp;

public class Company {
	private Long tcId;
	private String tcName;
	private String currentGid;
	private Timestamp createTime;
	private String tcarea;
	private String tctype;
	
	
	
	public Company(Long tcId, String tcName, String currentGid,
			Timestamp createTime, String tcarea, String tctype) {
		super();
		this.tcId = tcId;
		this.tcName = tcName;
		this.currentGid = currentGid;
		this.createTime = createTime;
		this.tcarea = tcarea;
		this.tctype = tctype;
	}
	public String getTcarea() {
		return tcarea;
	}
	public void setTcarea(String tcarea) {
		this.tcarea = tcarea;
	}
	public String getTctype() {
		return tctype;
	}
	public void setTctype(String tctype) {
		this.tctype = tctype;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public String getTcName() {
		return tcName;
	}
	
	public Long getTcId() {
		return tcId;
	}
	public void setTcId(Long tcId) {
		this.tcId = tcId;
	}
	public void setTcName(String tcName) {
		this.tcName = tcName;
	}
	
}
