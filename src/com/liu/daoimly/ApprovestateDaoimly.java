package com.liu.daoimly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liu.dao.ApprovestateDao;
import com.liu.dao.ApprovestateimgDao;
import com.liu.db.BaseDao;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.ApproveRule;
import com.liu.xutils.pojo.ApproveState;
import com.liu.xutils.pojo.User;

public class ApprovestateDaoimly implements ApprovestateDao {
	ApprovestateimgDao imgDao = new ApprovestateimgDaoimly();
	List<ApproveState> data1 = new ArrayList<ApproveState>();
	List<ApproveState> data = new ArrayList<ApproveState>();
	// ApproveInfoDaoimly infoDao=new ApproveInfoDaoimly();

	ApproveState approveState;
	int k = 0;
	BaseDao baseDao = new BaseDao();

	public boolean modifyApptate(ApproveState state) {
		int id = state.getApprovestateId();
		int i = baseDao
				.executeUpdateBypstmt(
						"update approvestate set decision=?, decisiontime=?,isnew=? ,comment=?, parentstateId=? where  approvestateId=?  ",
						state.getDecision(), state.getDecisiontime(), state
								.isIsnew(), state.getComment(), state
								.getParentstateId(), id);
		List<String> imgurls = state.getImgurl();
		if (imgurls != null && imgurls.size() > 0) {
		
				int num=imgDao.addImgbyappstateId(id, imgurls);
				
			
			if (num == imgurls.size() && i > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		}

	}
public int insertApptates(List<ApproveState> states){
	Connection conn =DbPool.getConnection();
	String sql="insert into approvestate(approverId,parentstateId,decision,decisiontime,applicantId,isnew,approveId,isself)  values((select approver from  approve where approveId=? ),?,?,?,?,?,?,?);";
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	int count=0;
	  try {
		

	int k=0;
		pstmt=conn.prepareStatement(sql);
		int pa=0;
for (ApproveState approveState : states) {
	pstmt.setInt(1, approveState.getApproveId());
	pstmt.setInt(2, pa);

	pstmt.setInt(3, approveState.getDecision());
	pstmt.setTimestamp(4, approveState.getDecisiontime());
	pstmt.setLong(5,approveState.getGetter().getId());
	pstmt.setBoolean(6, approveState.isIsnew());
	pstmt.setInt(7, approveState.getApproveId());
	pstmt.setBoolean(8, approveState.isIsself());
	k=pstmt.executeUpdate();
	if(k>0){
		count++;
	}
	rs = pstmt.getGeneratedKeys();
	if (rs.next()) {
		pa = rs.getInt(1);

	}
}
			
			
		

	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DbPool.DBClose(conn, pstmt, null);

	}
	
	return count;
	
	
	
	
}
	public Integer insertApptate(ApproveState state) {
		int id = state.getApprovestateId();
		int stateid = baseDao
				.executeUpdateGetGen(
						"insert into approvestate(approverId,parentstateId,comment,decision,decisiontime,applicantId,isnew,approveId,isself)  values((select approver from  approve where approveId=? ),?,?,?,?,?,?,?,?);  ",
						state.getApproveId(),
						state.getParentstateId(), state.getComment(), state
								.getDecision(), state.getDecisiontime(), state
								.getGetter().getId(), state.isIsnew(), state
								.getApproveId(), state.isIsself());
//		List<String> imgurls = state.getImgurl();
//		if (imgurls != null && imgurls.size() > 0) {
//			int num = 0;
//			for (String string : imgurls) {
//				imgDao.addImgbyappstateId(id, string);
//				num++;
//			}
//			if (num == imgurls.size() && stateid > 0) {
//				return stateid;
//			} else {
//				return null;
//			}
//		} else {
//			if (stateid > 0) {
//				return stateid;
//			} else {
//				return null;
//			}
//		}
		
		return stateid;

	}

	public List<ApproveState> getAllstatebyAppid(int approveid) {
		List<Object> lists = baseDao.queryBySql(
				"select * from approvestate where approveId= " + approveid,
				ApproveState.class);
		data.clear();
		data1.clear();
		for (Object object : lists) {
			approveState = (ApproveState) object;
			approveState.setImgurl(imgDao.getImgbyappstateId(approveState
					.getApprovestateId()));
			data.add(approveState);

		}

		linktrans(0);
		// for (ApproveState object : data) {
		// System.out.println(object.getApprovestateId());
		// }

		return data1;
	}

	public void linktrans(int a) {
		ApproveState approveState = null;
		boolean flag = false;
		for (int i = 0; i < data.size(); i++) {
			approveState = data.get(i);
			// &&data1.get(data1.size()-1).getDecision()!=0
			System.out.println(data1.size());
			if (approveState.getParentstateId() == a) {
				if (data1.size() > 0) {
					if (data1.get(data1.size() - 1).getDecision() != 0) {
						flag = true;
						break;
					}
				} else {
					flag = true;
					break;
				}

			}

		}
		if (flag) {
			data1.add(approveState);
			linktrans(approveState.getApprovestateId());
		}

	}

	public Map<Integer, Integer> getAllIShenpiID(int userId) {
		// TODO Auto-generated method stub
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int decision;
		int approveId = 0;

		String sql = "SELECT approveId,decision  FROM approvestate WHERE applicantId=? and isnew=1 and isself=0  and  decision=2";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);

			rs = stmt.executeQuery();
			while (rs.next()) {

				approveId = rs.getInt("approveId");
				decision = rs.getInt("decision");
				map.put(approveId, decision);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}

		return map;

	}

	public Map<Integer, Integer> getAllIHaveShenpiID(int userId) {
		// TODO Auto-generated method stub

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Connection conn = DbPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int decision;
		String sql = "SELECT approveId,decision  FROM approvestate WHERE applicantId=? and  decision!=2  and isself=0  ";
		int approveId;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);

			rs = stmt.executeQuery();
			while (rs.next()) {

				approveId = rs.getInt("approveId");
				decision = rs.getInt("decision");
				map.put(approveId, decision);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		System.out.println("=====================" + map.size());
		return map;

	}

	// public static void main(String[] args) {
	// System.out.println(new ApprovestateDaoimly().getAllstatebyAppid(2));
	// }
//public static void main(String[] args) {
//	String x=new Timestamp(new Date().getTime()).toString();
//	System.out.println(x);
//	Timestamp a=Timestamp.valueOf(x);
//	System.out.println(a.toString());
//	
//}
}
