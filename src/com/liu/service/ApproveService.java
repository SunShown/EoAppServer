package com.liu.service;

import java.sql.Timestamp;
import java.util.List;

import com.liu.xutils.pojo.AllShenPiBean;
import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.ApproveState;
import com.liu.xutils.pojo.Approveinfo;

public interface ApproveService {
public	List<AllShenPiBean> GetAllShenPiNew(int userid,String searchinfo,int size,int page);
public	List<AllShenPiBean> GetAllShenPiHave(int userid,String searchinfo,int size,int page);
public	List<AllShenPiBean> GetAllShenPii(int userid,String searchinfo,int size,int page);
public int AppAgree(ApproveState state);
public int AppRefused(ApproveState state);

public int AppCancel(ApproveState s);

	
	
}
