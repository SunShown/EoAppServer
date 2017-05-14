package com.liu.dao;

import java.util.List;

import com.liu.xutils.pojo.ApproveType;

public interface ApproveTypeDao {

	public ApproveType getApproveTypeByid(int typeid);
	
	public ApproveType getApproveTypebyname(String typeName);
	public List<ApproveType> getAllAppType();
	
}
