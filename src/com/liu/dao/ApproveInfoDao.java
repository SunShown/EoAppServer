package com.liu.dao;

import com.liu.xutils.pojo.Approveinfo;

public interface ApproveInfoDao {
	public Approveinfo getApproveinfobyid(int approveid);
	 public   boolean modifyApproveinfo(Approveinfo info);
	 public int addApprove(Approveinfo approveinfo);
}
