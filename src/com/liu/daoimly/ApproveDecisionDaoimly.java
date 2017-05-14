package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liu.dao.ApproveDecisionDao;
import com.liu.db.DbPool;

public class ApproveDecisionDaoimly implements ApproveDecisionDao {
public String getaApproveDecisionstrbyid(int id){
		
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt =null;
		ResultSet rs=null;
		String sql="select decision from approve_decision where id=?";
		String str="";
		try{
		stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		while (rs.next()) {
			str=rs.getString("decision");
			
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
