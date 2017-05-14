package com.liu.dao;

import java.util.List;

public interface ApprovestateimgDao {

	public List<String> getImgbyappstateId(int approvestateid);
	public int addImgbyappstateId(int approvestateid,List<String> imgurl);
}
