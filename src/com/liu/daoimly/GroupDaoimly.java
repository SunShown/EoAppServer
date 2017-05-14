package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.GroupDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.Group;

public class GroupDaoimly implements GroupDao {
	List<String> a=new ArrayList<String>();
BaseDao baseDao=new BaseDao();
	public Group getGroupbyuserid(long userid) {
		System.out.println("userid========================"+userid);
		List<Object> s=baseDao.queryBySql("select * from tgroup where tg_id=(select tg_id from tusergrouprelation where tu_id= "+userid+" )  ", Group.class);
		if(s!=null&&s.size()>0){
		return (Group)(s.get(0));}else{return null;}
	}
		
	public String[] getAlleaderId(long userId){
		String sql1 = "select tg_id from tusergrouprelation where tu_id=";
	
		Connection conn=DbPool.getConnection();
		
	a.clear();
	
		Statement stmt = null;
		ResultSet rs=null;
		try {
			stmt = conn.createStatement();
			// 4. 执行sql executeUpdate(sql);
		      
			rs = stmt.executeQuery(sql1+userId);
			if(rs.next()){
				long i=rs.getLong(1);
				if(i!=0){
					getParentGroup(i, stmt, rs);
					String[] k=new String[a.size()];
					for (int j = 0; j < k.length; j++) {
						k[j]=a.get(j);
					}
					return k;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, null);
		}
		
		
		return null;
		
		
		
	}
	
	
	public void getParentGroup(long groupId,Statement stmt,ResultSet rs) throws SQLException{
		String sql2="select tg_leader,parent_tg_id from tgroup where tg_id=";

		rs = stmt.executeQuery(sql2+groupId);
		System.out.println(sql2+groupId);
	
		if(rs.next()){
			long  tg_leader=rs.getLong(1);
			long parent_tg_id=rs.getLong(2);
			 if(tg_leader!=0){
				 System.out.println(tg_leader);
					a.add(tg_leader+"");
				}
			 if(parent_tg_id!=0){
				 getParentGroup(parent_tg_id,stmt,rs);
			 }else{
				 rs = stmt.executeQuery("select tu_id from  tuserrolerelation  where tr_id=1  and tu_id in(select tu_id from  tusergrouprelation  where tg_id in(select tg_id from tgroup where tc_id=(select tc_id from tgroup  where  tg_id ="+groupId+" )  ) ) ");
				 if(rs.next()){
					 long boss=rs.getLong(1);
					 if(boss!=0){
					 a.add( boss+"");}
				 }
				 
			 }
		}
		
		
		
		
	}
	
	
//	public static void main(String[] args) {
//	String[] a	=new GroupDaoimly().getAlleaderId(7);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//		
//	}
	
	
	

}
