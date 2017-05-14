package com.liu.daoimly;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







import com.google.gson.Gson;
import com.liu.dao.ApproveColumnDao;
import com.liu.dao.ApproveInfoDao;
import com.liu.dao.ApproveTypeDao;
import com.liu.dao.ApproveimgDao;
import com.liu.dao.ApprovestateDao;
import com.liu.dao.GroupDao;
import com.liu.dao.UserDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.util.DateUtil;
import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.ApproveState;
import com.liu.xutils.pojo.ApproveType;
import com.liu.xutils.pojo.Approveinfo;
import com.liu.xutils.pojo.User;

public class ApproveInfoDaoimly implements ApproveInfoDao {

	ApproveTypeDao typeDao=new ApproveTypeDaoimly();
	BaseDao baseDao=new BaseDao();
	 ApprovestateDao stateDao=new ApprovestateDaoimly();
	 UserDao userDao=new UserDaoimly();
	 ApproveimgDao imgDao=new ApproveimgDaoimly();
	 GroupDao groupDao=new GroupDaoimly();
	 ApproveColumnDao columnDao=new ApproveColumnDaoimy();

	 public int addApprove(Approveinfo approveinfo){
		
		
		 
		 
		int i=baseDao.executeUpdateGetGen("insert into approve (approvetitle,approvetype,appr"
				+ "over,applytime,newTime) values(CONCAT((select name from tuser where tu_id=?),'的',(select approve"
				+ "type_str from approve_type where id=?)),?,?,?,?)",approveinfo.getSender().getId(),approveinfo.getApprovetypeId(),approveinfo.getApprovetypeId(),approveinfo.getSender().getId(),approveinfo.getNewTime(),approveinfo.getNewTime());
		 
		 
	
		return i;

		 
		 
		 
		 
		 
	 }
 	 public   boolean modifyApproveinfo(Approveinfo info){
		int i= baseDao.executeUpdateBypstmt("update approve set newTime=? ,state=?, ispass=? where approveId=? ", info.getNewTime(),info.getState(),info.getDecison(),info.getApproveId());
		 
		 
		 
		 if(i>0){
		 
		 
		 return true;
		 }else{
			 return false;
		 }		 
	 }
	 
	 
	 
	 
	 
			public Approveinfo getApproveinfobyid(int approveid){
			Connection conn=DbPool.getConnection();
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Approveinfo info=(Approveinfo)(baseDao.queryBySql("select * from approve where approveId= "+approveid, Approveinfo.class).get(0));
			 info.setSenderGroup(groupDao.getGroupbyuserid(info.getSender().getId()));
			 System.out.println(info.getSenderGroup());
			List<ApproveState> states=stateDao.getAllstatebyAppid(info.getApproveId());
			 
			 User newGetter=null;
			 if("0".equals(info.getState()))
			 for (ApproveState approveState : states) {
				if(approveState.isIsnew()){
					newGetter=approveState.getGetter();
				}
			}
			 info.setNewgetter(newGetter);
			 info.setAllstates(states);
		ApproveType type	=typeDao.getApproveTypeByid(info.getApprovetypeId());
		type.setColumns(columnDao.getApproveColumnBytypeid(type.getTyypeId()));
		List<ApproveColumn> columns= type.getColumns();
		List<ApproveColumn> newcolumns= new ArrayList<ApproveColumn>();
		String sql="select ";
		for (ApproveColumn approveColumn : columns) {
			sql+=approveColumn.getShijicolumn()+",";
			
		}
		sql=sql.substring(0,sql.length()-1);
	
		sql+=" from approvedata where approveid= "+info.getApproveId();
		try {
			String  columnsname;
			stmt=conn.prepareStatement(sql);
			String dbName;
			String columnname;
			String d = null;
			rs=stmt.executeQuery();
			  ResultSetMetaData rsmd=rs.getMetaData();
			
			while(rs.next()){
				for (ApproveColumn approveColumn : columns) {
				for (int i = 1; i <=rsmd.getColumnCount(); i++) {
					dbName=rsmd.getColumnTypeName(i);
					columnname=rsmd.getColumnName(i);
					
					if("DECIMAL".equalsIgnoreCase(dbName)){
						d=rs.getBigDecimal(i).toString();
					
						
					}else if("BIT".equalsIgnoreCase(dbName)){
						d=	Byte.toString(rs.getByte(i));
					
					
					}else if("INTEGER".equalsIgnoreCase(dbName)){
						d=String.valueOf(rs.getInt(i));
						
						
						
					}else if("DATETIME".equalsIgnoreCase(dbName)){
						
						d=DateUtil.dateToString(rs.getTimestamp(i));
						
						
						
						
					
						
					}else if("VARCHAR".equalsIgnoreCase(dbName)){
						d=rs.getString(i);
						
						
					}
				
						if(approveColumn.getShijicolumn().equals(columnname)){
							approveColumn.setData(d);
							newcolumns.add(approveColumn);
							
							
							
							
						}
					}
					
					
				}
				
				}
				
				
				type.setColumns(newcolumns);
				info.setType(type);
				info.setImgurl(imgDao.getImgbyappId(approveid));
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		
			
			
			
			
			
			
			
			
			
			return info;
			
			
			
			
		}
//		public static void main(String[] args) {
//			ApproveInfoDaoimly daoimly=new ApproveInfoDaoimly();
////			
////			Gson gson=new Gson();
////			String str=gson.toJson(daoimly.getApproveinfobyid(1));
////			System.out.println(str);
//			
//			System.out.println(daoimly.addApprove(new Approveinfo(1, new User(1), new Timestamp(new Date().getTime()))));
//		}
	
	
	
}
