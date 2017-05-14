package com.liu.xutils.pojo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.liu.util.ValueSearch;


public class User {
	@ValueSearch("name")
	private String userName;//用户名
	@ValueSearch("tel")
	private String userId;//用户id
	@ValueSearch("password")
	private String userPwd;//用户密码
	@ValueSearch("token")
	private String userToken;//token
	@ValueSearch("img_url")
	private String imgUrl;
	@ValueSearch("tu_id")
	private long id;
	@ValueSearch("birthday")
	private Timestamp birthday;
	@ValueSearch("address")
	private String address;
	@ValueSearch("sex")
	private int sex;
	private boolean isExist=false;//判断此成员在不在当前组内
	private String userPosition;
	Group group;
	
	public User(long id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User(long id,String userName, String userId, String userPwd,
			String userToken, String imgUrl,  Timestamp birthday,
			String address, int sex, String userPosition) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userToken = userToken;
		this.imgUrl = imgUrl;
		this.id = id;
		this.birthday = birthday;
		this.address = address;
		this.sex = sex;
		this.userPosition = userPosition;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId
				+ ", userPwd=" + userPwd + ", userToken=" + userToken
				+ ", imgUrl=" + imgUrl  + ", birthday="
				+ birthday + ", address=" + address + ", sex=" + sex + "]";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public	Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public User(String userName, String userId, String userPwd,
			String userToken, String imgUrl, Timestamp birthday,
			String address, int sex) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userToken = userToken;
		this.imgUrl = imgUrl;
		this.birthday = birthday;
		this.address = address;
		this.sex = sex;
	}
	public User() {
	}

	public User(String userName, String userId, String userPwd,
			String userToken, String imaUrl) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userToken = userToken;
		this.imgUrl = imaUrl;
	}
	public User(String userName, String userId, String userPwd) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imaUrl) {
		this.imgUrl = imaUrl;
	}
	
}
