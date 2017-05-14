package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.ApproveimgDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.ApproveRule;

public class ApproveimgDaoimly implements ApproveimgDao {
	BaseDao baseDao=new BaseDao();
	public int addImgbyappId(int approveid, List<String> imgurl) {
		// TODO Auto-generated method stub
		int[]x = null;
		
		Connection conn =DbPool.getConnection();
		String sql="insert into approveimg (approveId,imgurl) values(?,?)";
		PreparedStatement pstmt = null;
		  try {
			conn.setAutoCommit(false);
			int count = 0;  
			
			pstmt=conn.prepareStatement(sql);
			for (String img : imgurl) {
			pstmt.setInt(1, approveid);
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

	public List<String> getImgbyappId(int approvestateid) {
		// TODO Auto-generated method stub
		
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		List<String> urls=new ArrayList<String>();
		String sql="select imgurl from approveimg where approveId=?";
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

}
