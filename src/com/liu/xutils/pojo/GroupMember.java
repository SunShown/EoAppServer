package com.liu.xutils.pojo;

import java.util.List;

public class GroupMember {
	private List<User> users;
	private List<Group> groups;
	public GroupMember() {
		// TODO Auto-generated constructor stub
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
}
