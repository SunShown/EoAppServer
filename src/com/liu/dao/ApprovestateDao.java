package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.xutils.pojo.ApproveState;

public interface ApprovestateDao {
	public Map<Integer,Integer> getAllIShenpiID(int userId );
	public Map<Integer,Integer> getAllIHaveShenpiID(int userId ) ;
	public List<ApproveState> getAllstatebyAppid(int approveid);
	  public boolean modifyApptate(ApproveState state);
	  public Integer insertApptate(ApproveState state);
	  public int insertApptates(List<ApproveState> states);


}
