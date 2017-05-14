package com.liu.dao;

import java.util.List;

import com.liu.xutils.pojo.ApproveColumn;

public interface ApproveColumnDao {
 public List<ApproveColumn> getApproveColumnBytypeid(int typeid);
	
	
 public boolean addApproveData(List<ApproveColumn> datas,int approveid);
}
