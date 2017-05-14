package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liu.dao.ApproveStateStrDao;
import com.liu.db.DbPool;


public class ApproveStateStrDaoimly implements ApproveStateStrDao {

	public String getApprovestatestrbyid(int id){
		
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		String sql="select state_str from approve_state_str where id="+id;
		String str="";
		try{
		stmt= conn.prepareStatement(sql);
		
	
		
		rs=stmt.executeQuery(sql);
		while (rs.next()) {
			str=rs.getString("state_str");
			
		}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		return str;
		
		
		
	}

}
