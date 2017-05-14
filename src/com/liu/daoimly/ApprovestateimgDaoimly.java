package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.ApprovestateimgDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;

public class ApprovestateimgDaoimly implements ApprovestateimgDao  {
BaseDao baseDao=new BaseDao();
	public int addImgbyappstateId(int approvestateid, List<String> imgurl) {
		// TODO Auto-generated method stub
		
int[]x = null;
		
		Connection conn =DbPool.getConnection();
		String sql="insert into approvestateimg (approvestateid,imgurl) values(?,?);";
		PreparedStatement pstmt = null;
		  try {
			conn.setAutoCommit(false);
			int count = 0;  
			
			pstmt=conn.prepareStatement(sql);
			for (String img : imgurl) {
			pstmt.setInt(1, approvestateid);
			pstmt.setString(2, img);
				pstmt.addBatch();          
		            count++;      
				
			}
		x=	pstmt.executeBatch();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbPool.DBClose(conn, pstmt, null);

		}
		
		
		
		
		return x.length;
		
		
		
		
		

		
		
	}

	public List<String> getImgbyappstateId(int approvestateid) {
		// TODO Auto-generated method stub
		
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		List<String> urls=new ArrayList<String>();
		String sql="select imgurl from approvestateimg where approvestateid=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,approvestateid );
			rs=stmt.executeQuery();
			String a="";
			while (rs.next()) {
				a=rs.getString("imgurl");
				if(!("".equals(a))){
					
					urls.add(a);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		
		return urls;
	}


	
//public static void main(String[] args) {
//		System.out.println(new ApprovestateimgDaoimly().addImgbyappstateId(7,"http://10.40.5.54:8080/EO/emotion_004.png"));
//	}
//	
	
	
}
