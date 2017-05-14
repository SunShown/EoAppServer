package com.liu.dao;

import java.util.List;

public interface ApproveimgDao {
	public int addImgbyappId(int approveid, List<String> imgurl);
	public List<String> getImgbyappId(int approvestateid);
}
