package com.liu.service;

import java.util.List;

import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.Approveinfo;

public interface ApproveinfoService {
	public Approveinfo getApproveinfobyid(int approveid);
	public int ApproveSend(Approveinfo approveinfo,long companyId);
	public List<ApproveColumn> getAppcolumns(String typeName);
	
}
