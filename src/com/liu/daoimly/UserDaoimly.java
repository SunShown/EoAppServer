package com.liu.daoimly;

import com.liu.dao.UserDao;
import com.liu.db.BaseDao;
import com.liu.xutils.pojo.User;

public class UserDaoimly implements UserDao {
BaseDao baseDao=new BaseDao();
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return (User)(baseDao.queryBySql("select * from tuser where tu_id= "+id,User.class).get(0));
	}

}
