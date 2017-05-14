package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.xutils.pojo.AllShenPiBean;

public interface ApproveDao {
	public  List<AllShenPiBean> GetAllShenPiipreview (int userId,String searchinfo,int size,int page);
	public List<AllShenPiBean> GetAllShenPipreview(  Map<Integer,Integer> data,String searchinfo,int size,int page);
}
