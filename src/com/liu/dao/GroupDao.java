package com.liu.dao;

import com.liu.xutils.pojo.Group;

public interface GroupDao {
	public Group getGroupbyuserid(long userid);
	public String[] getAlleaderId(long userId);

}
