package com.liu.xutils.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 从客户端获取json信息
 * @author hui
 *
 */
public class ChatGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String groupId;
    private List<User> users;
    private Timestamp createTime;
    	
    public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public ChatGroup(String name, String groupId, Timestamp createTime) {
		super();
		this.name = name;
		this.groupId = groupId;
		this.createTime = createTime;
	}
	public ChatGroup(String groupId, String name, List<User> users,Timestamp createTime) {
        this.groupId = groupId;
        this.name = name;
        this.users = users;
        this.createTime=createTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUserId(List<User> userIds) {
        this.users = users;
    }
}
