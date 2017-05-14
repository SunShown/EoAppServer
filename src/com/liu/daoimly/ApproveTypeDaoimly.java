package com.liu.daoimly;

import java.util.ArrayList;
import java.util.List;

import com.liu.dao.ApproveColumnDao;
import com.liu.dao.ApproveTypeDao;
import com.liu.db.BaseDao;
import com.liu.xutils.pojo.ApproveType;



public class ApproveTypeDaoimly implements ApproveTypeDao {
BaseDao baseDao=new BaseDao();

 public List<ApproveType> getAllAppType(){
	List<Object>  obs= baseDao.queryBySql("select * from approve_type ", ApproveType.class);
	List<ApproveType> approveTypes=new ArrayList<ApproveType>();
	for (Object object : obs) {
		approveTypes.add((ApproveType)object);
	}
	return approveTypes;
	 
 }
	public ApproveType getApproveTypeByid(int typeid) {
		ApproveType  type=(ApproveType)(baseDao.queryBySql("select * from approve_type where id= "+typeid, ApproveType.class).get(0));


		
		
	
		
		return type;
	}
	
	
	public ApproveType getApproveTypebyname(String typeName){
ApproveType  type=(ApproveType)(baseDao.queryBySql("select * from approve_type where approvetype_str= '"+typeName+"'", ApproveType.class).get(0));


		
		
	
		
		return type;
	}
	
	
	
	

}
