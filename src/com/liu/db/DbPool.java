package com.liu.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbPool {
	private static DbPool instance=null;
	private DbPool(){
		super();
	}
	public static Connection getConnection(){
		
		if(instance==null){
			instance=new DbPool();
		}
		return instance._getConnection();
	}
	//获得连接对象
	private Connection _getConnection(){
		try{			
			String dBDriver=null;
			String connectionUrl=null;
			String user=null;
			String passWord=null;
			Properties p=new Properties();
			InputStream is=getClass().getResourceAsStream("/database.properties");
			p.load(is);
			dBDriver=p.getProperty("dBDriver",dBDriver);
			connectionUrl=p.getProperty("url",connectionUrl);
			user=p.getProperty("userName",user);
			passWord=p.getProperty("passWord",passWord);
			//加载驱动			
			Class.forName(dBDriver);
			return DriverManager.getConnection(connectionUrl, user, passWord);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public static void DBClose(Connection conn,Statement stmt,ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
}
