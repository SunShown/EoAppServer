package com.liu.xutils.pojo;

import java.util.List;

import com.liu.util.ValueSearch;

public class Group {
	@ValueSearch("tg_id")
	private Long tgId;//组id
	@ValueSearch("group_name")
	private String tgName;//组name
	@ValueSearch("parent_tg_id")
	private Long parentTgId;//父组id
	@ValueSearch("description")
	private String description;//组描述
	@ValueSearch("tc_id")
	private Long tcId;//公司id;
	private List<User> users;
	@ValueSearch("tg_leader")
	private Long tgLeaderId;
	private Company company;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Long getTgLeaderId() {
		return tgLeaderId;
	}
	public void setTgLeaderId(Long tgLeaderId) {
		this.tgLeaderId = tgLeaderId;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Long getTgId() {
		return tgId;
	}
	public void setTgId(Long tgId) {
		this.tgId = tgId;
	}
	public String getTgName() {
		return tgName;
	}
	public void setTgName(String tgName) {
		this.tgName = tgName;
	}
	public Long getParentTgId() {
		return parentTgId;
	}
	public void setParentTgId(Long parentTgId) {
		this.parentTgId = parentTgId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTcId() {
		return tcId;
	}
	public void setTcId(Long tcId) {
		this.tcId = tcId;
	}
	@Override
	public String toString() {
		return "Group [tgId=" + tgId + ", tgName=" + tgName + ", parentTgId="
				+ parentTgId + ", description=" + description + ", tcId="
				+ tcId + ", users=" + users + "]";
	}
	
}
