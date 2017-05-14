package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.ApproveRuleDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.ApproveRule;
import com.liu.xutils.pojo.User;
import com.taobao.api.internal.toplink.embedded.websocket.util.Base64;

public class ApproveRuleDaoimly implements ApproveRuleDao {
BaseDao baseDao=new BaseDao();
	public List<ApproveRule> getApproveRule(int approvetypeId,long companyId) {
		 List<Object> rules=baseDao.queryBySql("select * from approverule where approvetypeId ="+approvetypeId+" and companyId= "+companyId+" order by limited asc", ApproveRule.class);
		 List<ApproveRule> rs=new ArrayList<ApproveRule>();
		 ApproveRule approveRule=null;
		 List<Object> list=null;
		 String a=null;
		 String[] z=null;
		 for (Object object : rules) {
		    
			 approveRule=(ApproveRule)object;
			z= approveRule.getShunxu().split("\\.");
		
//			list=baseDao.queryBySql(,User.class);
		 approveRule.setShunxulist(z);
			rs.add(approveRule);
		}
		 
		 
		
		 
		 return rs;
	}

	public void addApproveRule(List<ApproveRule> rules) {
          //  int i=base
		Connection conn =DbPool.getConnection();
		String sql="insert into approverule(approvetypeId,shunxu,limited,limitcolumnid,companyId) values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		  try {
			conn.setAutoCommit(false);
			int count = 0;  
			pstmt=conn.prepareStatement(sql);
			for (ApproveRule approveRule : rules) {
				pstmt.setInt(1, approveRule.getApprovetypeId());
				pstmt.setString(2, approveRule.getShunxu());
				pstmt.setDouble(3, approveRule.getLimit());
				pstmt.setInt(4, approveRule.getLimitcolumnid());
				pstmt.setLong(5, approveRule.getCompanyId());
				
				pstmt.addBatch();          
		            count++;      
				
			}
		int[]x=	pstmt.executeBatch();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbPool.DBClose(conn, pstmt, null);

		}
	
	}

	public boolean modifyApproveRule(ApproveRule approveRule) {
	int i=baseDao.executeUpdateBypstmt("update approverule set  shunxu=?,limited=?,limitcolumnid=? where id=?", approveRule.getShunxu(),approveRule.getLimit(),approveRule.getLimitcolumnid(),approveRule.getId());
		if(i>0){return true;}else{
	return false;}
	}
	public  List<ApproveRule> GetApproveRuleBycon(long companyId){
		 List<Object> rules=baseDao.queryBySql("select * from approverule where  companyId= "+companyId, ApproveRule.class);
		 List<ApproveRule> rs=new ArrayList<ApproveRule>();
		 ApproveRule approveRule=null;
		 String a=null;
		
		 for (Object object : rules) {
		    
			 approveRule=(ApproveRule)object;
			 approveRule.setShunxulist(approveRule.getShunxu().split("\\."));
			rs.add(approveRule);
		}
		 
		 
		
		 
		 return rs;
	}
//public static void main(String[] args) {
//	ApproveRuleDaoimly daoimly=new ApproveRuleDaoimly();
////	List<ApproveRule> rules =new ArrayList<ApproveRule>();
////	rules.add(new ApproveRule(0, 1, "3,2,1,4", 5, 4, 1, null));
////	rules.add(new ApproveRule(0, 2, "3,3,1,4", 8, 11, 1, null));
////	rules.add(new ApproveRule(0, 3, "3,4,1,4", 11, 6,1, null));
////	daoimly.addApproveRule(rules);
//	
////	System.out.println(daoimly.getApproveRule(1, 1));
//	daoimly.modifyApproveRule(new ApproveRule(10,0, "1,3,5", 15, 6, 1, null));
//}
}
