package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.liu.dao.ApproveDao;
import com.liu.dao.ApproveDecisionDao;
import com.liu.dao.ApproveIspassDao;
import com.liu.dao.ApproveStateStrDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.AllShenPiBean;
import com.liu.xutils.pojo.User;

public class ApproveDaoimly implements ApproveDao {
	ApproveDecisionDao decisionDao=new ApproveDecisionDaoimly();
	ApproveStateStrDao statestrDao=new ApproveStateStrDaoimly();
	ApproveIspassDao ispassDao=new ApproveIspassDaoimly();
	BaseDao basedao=new BaseDao();
	
	
public  List<AllShenPiBean> GetAllShenPiipreview (int userId,String searchinfo,int size,int page){
		
		List<AllShenPiBean> lists=new ArrayList<AllShenPiBean>();
		AllShenPiBean bean=null;
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		User newgetter=null;
		String sql="select approveId ,approvetype,approvetitle,newTime,state,ispass FROM approve where approver=?  ";
		if(searchinfo!=null&&!("".equals(searchinfo))){
			sql+=" and approvetitle like '%"+searchinfo+"%'";
		}
		sql+=" order by state asc , ispass desc,newTime desc";
		sql += " limit "+(page-1)*size+","+size;
		System.out.println(sql);
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,  userId);
			rs=stmt.executeQuery();
			
			
			while(rs.next()){
				
				int approveId=rs.getInt("approveId");
				int approvetype=rs.getInt("approvetype");
				String approvetitle=rs.getString("approvetitle");
			Timestamp newTime=rs.getTimestamp("newTime");
			int i=rs.getInt("state");
			int c=rs.getInt("ispass");
			String state=statestrDao.getApprovestatestrbyid(i);
		
			String ispass=ispassDao.getApproveispassstrbyid(c);
			if (i==0){
				List<Object> lists1=basedao.queryBySql("SELECT * from tuser where tu_id=(select applicantId from  approvestate where approveId="+approveId+" and isnew=1 )", User.class);
			
				newgetter=(User) lists1.get(0);
			
			}
			bean=new AllShenPiBean(approvetype, approveId, approvetitle, newTime, newgetter, state, ispass);
			
			lists.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		//Collections.sort(lists);
		return lists;
		
	} 
	public List<AllShenPiBean> GetAllShenPipreview(  Map<Integer,Integer> data,String searchinfo,int size,int page){
		List<AllShenPiBean> lists=new ArrayList<AllShenPiBean>();
		AllShenPiBean bean=null;
		User sender=null;
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		
		System.out.println(searchinfo);
		String sql="select approveId ,approvetitle,approvetype,newTime,approver,state FROM approve where approveId=?  ";
		if(searchinfo!=null&&!("".equals(searchinfo))){
			sql+=" and approvetitle like '%"+searchinfo+"%'";
		}
	
		String i=null;
		String b=null;
		Integer decision=null;
		try {
	
		String sql1=sql;
		for (Entry<Integer,Integer> e : data.entrySet()) {
			sql1=sql;
			
			
	
	 decision=e.getValue();
	 if(decision==2){
		 sql1+=" and state=0";
	 }else{
		 b=decisionDao.getaApproveDecisionstrbyid(decision);
	 }
		sql1+=" order by state asc , ispass desc,newTime desc";
		sql1 += " limit "+(page-1)*size+","+size;
	
	 stmt=conn.prepareStatement(sql1);
		
		stmt.setInt(1, e.getKey());

		rs=stmt.executeQuery();
		while (rs.next()) {
			int approveId1=rs.getInt("approveId");
		
			String approvetitle=rs.getString("approvetitle");
		
			int approvetype=rs.getInt("approvetype");
			Timestamp newTime=rs.getTimestamp("newTime");
			int approver=rs.getInt("approver");
			int state=rs.getInt("state");
			List<Object> lists1=basedao.queryBySql("select * from tuser where tu_id ="+approver,User.class);

			sender=(User) (lists1.get(0));
		
		i=statestrDao.getApprovestatestrbyid(state);
		
			 bean=new AllShenPiBean(approvetype, approveId1, approvetitle, newTime, sender,i,b);
			
			lists.add(bean);}} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbPool.DBClose(conn, stmt, rs);
			}
			Collections.sort(lists);
	return lists;
		
	}

}
