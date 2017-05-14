package com.eo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eo.conn.DBConn;
import com.eo.dao.ISignSettingInfoDao;
import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.entity.HardworkingInfo;
import com.eo.entity.LateInfo;
import com.eo.entity.QueryCompanySettingInfoBean;
import com.eo.entity.SignInAndOffInfo;
import com.eo.utils.CopyOfCountDate;
import com.eo.utils.CountDate;
import com.liu.db.DBImp;
import com.liu.db.IDB;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

public class SignSettingInfoDaoImpl implements ISignSettingInfoDao {

	private boolean isData;
	private List<String> breakDateLists = new ArrayList<String>();
	private String[] offWeekDay = new String[] { "周一", "周二", "周三", "周四", "周五",
			"周六", "周日" };
	private List<Integer> breakWeekIntLists = new ArrayList<Integer>();
	private CopyOfCountDate mCopyOfCountDate = new CopyOfCountDate();
	private List<String> workDateLists = new ArrayList<String>();
	private boolean isAutoLawHoliday;
	private boolean isNextDayBegin;
	private Double companyLatitudeDouble;
	private Double companyLongitudeDouble;
	private int companyEffectiveRangeInt;
	private String companyOnTimeString;
	private String companyOffTimeString;
	private int companyElasticityInt;
	private int companyEarlistTimeInt;
	private IDB iDBGroup = new DBImp();
	List<com.liu.xutils.pojo.User> userList = new ArrayList<com.liu.xutils.pojo.User>();

	@Override
	public void insertSignSettingInfo(Integer companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfoBean) {
		// 1.先删除数据库中该公司的上班日期，如果有的话
		Connection conn = DBConn.getConn();
		PreparedStatement queryPstmt = null;
		PreparedStatement deletePstmt = null;
		PreparedStatement insertPstmt = null;
		ResultSet rs = null;
		String querySql = "select * from workday where companyId = "
				+ companyIdInt;
		String deleteSql = "DELETE FROM workday WHERE companyId="
				+ companyIdInt;
		String insertSql = "INSERT INTO workday(companyId,workdayDate) VALUES (?,?)";
		try {
			queryPstmt = conn.prepareStatement(querySql);
			insertPstmt = conn.prepareStatement(insertSql);
			isData = queryPstmt.execute();
			if (isData) {
				deletePstmt = conn.prepareStatement(deleteSql);
				deletePstmt.execute();
			}
			// 2.向数据库插入工作日的日期，以date的形式
			String[] offWeekInfoStrings = companySignSettingInfoBean
					.getmOffWeekString().split(" ");
			for (int i = 0; i < offWeekInfoStrings.length; i++) {
				breakDateLists.add(offWeekInfoStrings[i]);
			}
			System.out.println("转过后的集合breakDateLists的长度："
					+ breakDateLists.size());
			isAutoLawHoliday = companySignSettingInfoBean.isAutoBreakByLaw();
			isNextDayBegin = companySignSettingInfoBean.isNextDayBegin();
			for (int i = 1; i < breakDateLists.size(); i++) {
				for (int j = 0; j < offWeekDay.length; j++) {
					if (breakDateLists.get(i).trim().equals(offWeekDay[j])) {
						breakWeekIntLists.add(j + 1);
					}
				}
			}
			workDateLists = mCopyOfCountDate.countWorkDateLists(
					breakWeekIntLists, isAutoLawHoliday, !isNextDayBegin);
			for (int i = 0; i < workDateLists.size(); i++) {
				insertPstmt.setObject(1, companyIdInt);
				insertPstmt.setObject(2, workDateLists.get(i));
				insertPstmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, queryPstmt, deletePstmt, rs);
		}
	}

	// 插入全面的设置信息
	// 将公司ID和公司经、纬度、地点title、地点snippet、有效范围、上班弹性时间、旷工及迟到时间、最早打卡时间、上班提醒
	// 下班提醒、上榜平均时长插入到数据库
	@Override
	public int insertSignSettingInfoAll(int companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfo) {
		int resultInt;
		Connection connAll = DBConn.getConn();
		PreparedStatement deleteAllInfoPstmt = null;
		PreparedStatement insertAllInfoPstmt = null;
		String deleteSqlAll = "delete from company_setting where companyId="
				+ companyIdInt;
		String insertSqlAll = "INSERT INTO company_setting(companyId,latitude,longitude,companyTitle,"
				+ "companySnippet,effectiveRange,elasticityTime,earliestTime,hardworkingTime,onTime,offTime,workWeeks,breakWeeks,isAutoBreakByLaw,isNextWeek) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			deleteAllInfoPstmt = connAll.prepareStatement(deleteSqlAll);
			deleteAllInfoPstmt.execute();
			insertAllInfoPstmt = connAll.prepareStatement(insertSqlAll);
			insertAllInfoPstmt.setObject(1, companyIdInt);
			insertAllInfoPstmt.setObject(2,
					companySignSettingInfo.getmDoubleLatitude());
			insertAllInfoPstmt.setObject(3,
					companySignSettingInfo.getmDoubleLongitude());
			insertAllInfoPstmt.setObject(4,
					companySignSettingInfo.getmStringTitle());
			insertAllInfoPstmt.setObject(5,
					companySignSettingInfo.getmStringSnippet());
			insertAllInfoPstmt.setObject(6,
					companySignSettingInfo.getmIntEffectiveRange());
			insertAllInfoPstmt.setObject(7,
					companySignSettingInfo.getmIntElasticTime());
			insertAllInfoPstmt.setObject(8,
					companySignSettingInfo.getmIntEarliestTime());
			insertAllInfoPstmt.setObject(9,
					companySignSettingInfo.getmIntHardAveTime());
			insertAllInfoPstmt.setObject(10,
					companySignSettingInfo.getOnTimeString());
			insertAllInfoPstmt.setObject(11,
					companySignSettingInfo.getOffTimeString());
			insertAllInfoPstmt.setObject(12,
					companySignSettingInfo.getmOnWeekString());
			insertAllInfoPstmt.setObject(13,
					companySignSettingInfo.getmOffWeekString());
			insertAllInfoPstmt.setObject(14,
					companySignSettingInfo.isAutoBreakByLaw() ? 1 : 0);
			insertAllInfoPstmt.setObject(15,
					companySignSettingInfo.isNextDayBegin() ? 0 : 1);
			resultInt = insertAllInfoPstmt.executeUpdate();
			return resultInt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(connAll, deleteAllInfoPstmt, insertAllInfoPstmt);
		}
		return 0;
	}

	// 普通用户签到前查询签到相关制度根据公司号
	// 通过companyID调用服务器端的servlet,查看管理员设置的信息(日期、签到时间、经纬度信息、有效范围、弹性时间
	// 、旷工及迟到时间、最早打卡时间)
	@Override
	public QueryCompanySettingInfoBean querySettingInfoByCompanyId(
			long companyIdLong) {
		Connection connPatial = DBConn.getConn();
		PreparedStatement queryPatialSettingInfopstmt = null;
		PreparedStatement queryWorkDatePstmt = null;
		String queryPatialSettingInfopatmtString = "select * from company_setting where companyId = "
				+ companyIdLong;
		String queryWorkdateString = "select * from workday where companyId = "
				+ companyIdLong;
		ResultSet queryResultSet = null;
		ResultSet queryWorkdayResultSet = null;
		List<String> workDateLists = new ArrayList<String>();
		QueryCompanySettingInfoBean mCompanySettingInfoBean = new QueryCompanySettingInfoBean();

		try {
			queryWorkDatePstmt = connPatial
					.prepareStatement(queryWorkdateString);
			queryWorkdayResultSet = queryWorkDatePstmt.executeQuery();
			while (queryWorkdayResultSet.next()) {
				workDateLists.add(queryWorkdayResultSet
						.getObject("workdayDate") + "");
			}

			queryPatialSettingInfopstmt = connPatial
					.prepareStatement(queryPatialSettingInfopatmtString);
			queryResultSet = queryPatialSettingInfopstmt.executeQuery();
			while (queryResultSet.next()) {
				companyLatitudeDouble = (Double) queryResultSet
						.getObject("latitude");
				companyLongitudeDouble = (Double) queryResultSet
						.getObject("longitude");
				companyOnTimeString = (String) queryResultSet
						.getObject("onTime");
				companyOffTimeString = (String) queryResultSet
						.getObject("offTime");
				companyElasticityInt = (Integer) queryResultSet
						.getObject("elasticityTime");
				companyEffectiveRangeInt = (Integer) queryResultSet
						.getObject("effectiveRange");
				// companyLateTimeInt = (Integer) queryResultSet
				// .getObject("lateTime");
				companyEarlistTimeInt = (Integer) queryResultSet
						.getObject("earliestTime");
				mCompanySettingInfoBean
						.setmDoubleLatitude(companyLatitudeDouble);
				mCompanySettingInfoBean
						.setmDoubleLongitude(companyLongitudeDouble);
				mCompanySettingInfoBean.setOnTimeString(companyOnTimeString);
				mCompanySettingInfoBean.setOffTimeString(companyOffTimeString);
				mCompanySettingInfoBean
						.setmIntElasticTime(companyElasticityInt);
				mCompanySettingInfoBean
						.setmIntEffectiveRange(companyEffectiveRangeInt);
				// mCompanySettingInfoBean.setmIntlateAndAbsen(companyLateTimeInt);
				mCompanySettingInfoBean
						.setmIntEarliestTime(companyEarlistTimeInt);
			}
			mCompanySettingInfoBean.setWorkDateLists(workDateLists);
			System.out.println("CompanySettingInfoBean对象："
					+ mCompanySettingInfoBean);
			return mCompanySettingInfoBean;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(connPatial, queryPatialSettingInfopstmt,
					queryWorkDatePstmt, queryResultSet, queryWorkdayResultSet);
		}
		return null;
	}

	/**
	 * 向signInAndOffInfo表中插入签到数据
	 */
	@Override
	public int insertSignInfo(SignInAndOffInfo mSignInAndOffInfo) {
		int resultInInt = 0;
		Connection conn4 = DBConn.getConn();
		PreparedStatement insertPreparedStatement = null;
		String insertSqlString = "INSERT INTO signInAndOffInfo(employeeId,companyId,onTime,signDate,signInStatus,lateTimes) VALUES (?,?,?,?,?,?)";
		try {
			insertPreparedStatement = conn4.prepareStatement(insertSqlString);
			insertPreparedStatement.setObject(1,
					mSignInAndOffInfo.getEmployeeIdLong());
			insertPreparedStatement.setObject(2,
					mSignInAndOffInfo.getCompanyIdLong());
			insertPreparedStatement.setObject(3,
					mSignInAndOffInfo.getOnTimeString());
			insertPreparedStatement.setObject(4,
					mSignInAndOffInfo.getDateString());
			insertPreparedStatement.setObject(5,
					mSignInAndOffInfo.getSignStatusIdInt());
			insertPreparedStatement.setObject(6,
					mSignInAndOffInfo.getLateTimes());
			resultInInt = insertPreparedStatement.executeUpdate();
			System.out.println("dao层的结果码：" + resultInInt);
			return resultInInt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn4, insertPreparedStatement);
		}
		return 0;
	}

	/**
	 * 插入签退信息
	 */
	@Override
	public int insertSignOffInfo(SignInAndOffInfo mSignInAndOffInfo) {
		int resultOffInt = 0;
		Connection conn5 = DBConn.getConn();
		PreparedStatement insertOffInfoPreparedStatement = null;
		String insertSqlString = "UPDATE signInAndOffInfo SET offTime =?"
				+ ",signOffStatus = ?,workTimes =? ,earlyOffTimes = ? WHERE companyId=? "
				+ "and employeeId =? and signDate = ?";
		System.out.println(insertSqlString);
		try {
			insertOffInfoPreparedStatement = conn5
					.prepareStatement(insertSqlString);
			insertOffInfoPreparedStatement.setObject(1,
					mSignInAndOffInfo.getOffTimeString());
			insertOffInfoPreparedStatement.setObject(2,
					mSignInAndOffInfo.getSignOffStatusIdInt());
			insertOffInfoPreparedStatement.setObject(3,
					mSignInAndOffInfo.getWorkTimesLong());
			insertOffInfoPreparedStatement.setObject(4,
					mSignInAndOffInfo.getEarlyOffTimes());
			insertOffInfoPreparedStatement.setObject(5,
					mSignInAndOffInfo.getCompanyIdLong());
			insertOffInfoPreparedStatement.setObject(6,
					mSignInAndOffInfo.getEmployeeIdLong());
			insertOffInfoPreparedStatement.setObject(7,
					mSignInAndOffInfo.getDateString());
			resultOffInt = insertOffInfoPreparedStatement.executeUpdate();
			return resultOffInt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn5, insertOffInfoPreparedStatement);
		}
		return 0;
	}

	/**
	 * 根据签到日期和员工Id查询出当前员工的签到时间
	 */
	@Override
	public String queryEmployeeSignTime(long employeeId, long companyId,
			String signDateString) {
		Connection conn6 = DBConn.getConn();
		PreparedStatement querySignTimePreparedStatement = null;
		String querySignTimeStringSql = "SELECT onTime FROM signinandoffinfo WHERE employeeId=? AND companyId = ? AND signDate =?";
		ResultSet rsResultSet = null;
		try {
			querySignTimePreparedStatement = conn6
					.prepareStatement(querySignTimeStringSql);
			querySignTimePreparedStatement.setObject(1, employeeId);
			querySignTimePreparedStatement.setObject(2, companyId);
			querySignTimePreparedStatement.setObject(3, signDateString);
			rsResultSet = querySignTimePreparedStatement.executeQuery();
			while (rsResultSet.next()) {
				System.out.println("rsResultSet是否有值");
				System.out.println((String) rsResultSet.getObject(1));
				return (String) rsResultSet.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 根据公司Id和日期查询出正常签到的员工数
	 */
	@Override
	public int querySignInNormalCount(long companyId, String dateString) {
		Connection conn6 = DBConn.getConn();
		PreparedStatement pstmt6 = null;
		String sqlString6 = "SELECT * FROM signinandoffinfo WHERE companyId = ? AND signDate = ? AND signInStatus = 1";
		ResultSet rsResultSet = null;
		int signInNormalCount = 0;
		try {
			pstmt6 = conn6.prepareStatement(sqlString6);
			pstmt6.setObject(1, companyId);
			pstmt6.setObject(2, dateString);
			rsResultSet = pstmt6.executeQuery();
			while (rsResultSet.next()) {
				signInNormalCount++;
			}
			return signInNormalCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn6, pstmt6, rsResultSet);
		}
		return 0;
	}

	/**
	 * 根据公司Id和日期查询出签到迟到的员工数
	 */
	@Override
	public int querySignInLateCount(long companyId, String dateString) {
		Connection conn7 = DBConn.getConn();
		PreparedStatement pstmt7 = null;
		String sqlString7 = "SELECT * FROM signinandoffinfo WHERE companyId = ? AND signDate = ? AND signInStatus = 3";
		ResultSet rsResultSet = null;
		int signInLateCount = 0;
		try {
			pstmt7 = conn7.prepareStatement(sqlString7);
			pstmt7.setObject(1, companyId);
			pstmt7.setObject(2, dateString);
			rsResultSet = pstmt7.executeQuery();
			while (rsResultSet.next()) {
				signInLateCount++;
			}
			return signInLateCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn7, pstmt7, rsResultSet);
		}
		return 0;
	}

	/**
	 * 根据公司Id和日期查询出早退的员工数
	 */
	@Override
	public int querySignOffEarlyCount(long companyId, String dateString) {
		Connection conn8 = DBConn.getConn();
		PreparedStatement pstmt8 = null;
		String sqlString8 = "SELECT * FROM signinandoffinfo WHERE companyId = ? AND signDate = ? AND signOffStatus = 2";
		ResultSet rsResultSet = null;
		int signOffEarlyCount = 0;
		try {
			pstmt8 = conn8.prepareStatement(sqlString8);
			pstmt8.setObject(1, companyId);
			pstmt8.setObject(2, dateString);
			rsResultSet = pstmt8.executeQuery();
			while (rsResultSet.next()) {
				signOffEarlyCount++;
			}
			return signOffEarlyCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn8, pstmt8, rsResultSet);
		}
		return 0;
	}

	/**
	 * 根据公司Id和当前日期查询出员工工作时长
	 */

	@Override
	public List<Long> queryWorkTimesLists(int currentMonth, long companyId) {
		// 一.IDB的第57和70行查找出该公司Id的所有员工
		// 1.根据公司Id查找所有部门70行 getAllGroupByCid(companyId)
		// 2.根据组Id查询出所有员工 getUsersByCidPgid(gId)
		List<Group> groupLists = new ArrayList<Group>();
		List<com.liu.xutils.pojo.User> userLists = new ArrayList<com.liu.xutils.pojo.User>();
		List<Long> empIdList = new ArrayList<Long>();
		List<Long> afterEmpIdList = new ArrayList<Long>();

		groupLists = iDBGroup.getAllGroupByCid(companyId); // 共用同一个对象可能有问题
		for (int i = 0; i < groupLists.size(); i++) {
			for (int j = 0; j < iDBGroup.getUsersByCidPgid(
					groupLists.get(i).getTgId()).size(); j++) {
				userLists.add(iDBGroup.getUsersByCidPgid(
						groupLists.get(i).getTgId()).get(j));
			}
		}

		Connection conn9 = DBConn.getConn();
		PreparedStatement pstmt9 = null;
		ResultSet rsResultSet9 = null;
		Map<Long, Integer> userMap = new HashMap<Long, Integer>();
		List<Map<Long, Integer>> userTimesLists = new ArrayList<Map<Long, Integer>>();

		// 遍历公司所有员工
		String sqlString9 = "SELECT employeeId ,SUM(workTimes) FROM signinandoffinfo WHERE month(signDate)= ? GROUP BY employeeId ORDER BY SUM(workTimes) DESC";
		try {
			pstmt9 = conn9.prepareStatement(sqlString9);
			pstmt9.setObject(1, currentMonth);
			rsResultSet9 = pstmt9.executeQuery();
			while (rsResultSet9.next()) {
				empIdList.add(rsResultSet9.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 注意这时候取出来的Map是无序的，虽然已经数据已经排过序了
		afterEmpIdList.add(empIdList.get(0));
		afterEmpIdList.add(empIdList.get(1));
		afterEmpIdList.add(empIdList.get(2));
		System.out.println(afterEmpIdList);
		DBConn.close(conn9, pstmt9, rsResultSet9);
		return afterEmpIdList;
	}

	@Override
	public List<com.liu.xutils.pojo.User> queryUserObjectByUserId(
			List<Long> userTimeLists) {
		// userTimeLists每次都是只有三个数
		IDB iDBUser = new DBImp();
		for (int i = 0; i < userTimeLists.size(); i++) {
			userList.add(iDBUser.getUserById(userTimeLists.get(i)));
		}
		return userList;
	}

	@Override
	public int queryTotalCount(long companyId, String dateString) {

		// 一.IDB的第57和70行查找出该公司Id的所有员工
		// 1.根据公司Id查找所有部门70行 getAllGroupByCid(companyId)
		// 2.根据组Id查询出所有员工 getUsersByCidPgid(gId)
		List<Group> groupLists = new ArrayList<Group>();
		List<com.liu.xutils.pojo.User> userLists = new ArrayList<com.liu.xutils.pojo.User>();
		groupLists = iDBGroup.getAllGroupByCid(companyId); // 共用同一个对象可能有问题
		for (int i = 0; i < groupLists.size(); i++) {
			for (int j = 0; j < iDBGroup.getUsersByCidPgid(
					groupLists.get(i).getTgId()).size(); j++) {
				userLists.add(iDBGroup.getUsersByCidPgid(
						groupLists.get(i).getTgId()).get(j));
			}
		}
		for (int i = 0; i < userLists.size(); i++) {
			System.out.println("daoimpl层打印出来的员工：" + userLists.get(i));
		}
		return userLists.size();
	}

	@Override
	public Long queryHardworkingTimes(Long companyId) {
		Connection conn10 = DBConn.getConn();
		PreparedStatement pstmt10 = null;
		String sqlString10 = "SELECT hardworkingTime FROM company_setting WHERE companyId= ?";
		ResultSet rsResultSet10 = null;
		try {
			pstmt10 = conn10.prepareStatement(sqlString10);
			pstmt10.setObject(1, companyId);
			rsResultSet10 = pstmt10.executeQuery();
			while (rsResultSet10.next()) {
				return rsResultSet10.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn10, pstmt10, rsResultSet10);
		}
		return (long) 0;
	}

	@Override
	public List<HardworkingInfo> queryHardworkingEmpInfo(String dateString,
			Long companyIdLong, int workTimes) {
		List<HardworkingInfo> empHardworkingInfoList = new ArrayList<HardworkingInfo>();
		// 1.先根据日期以及公司Id和工作时长大于之前设定的工作时长查找出表(signinandoffinfo)中的数据查询出员工Id(employeeId)和工作时长
		Connection conn11 = DBConn.getConn();
		PreparedStatement pstmt11 = null;
		String sqlString11 = "SELECT employeeId ,workTimes FROM signinandoffinfo WHERE "
				+ "signDate=? and companyId=? and workTimes>? ORDER BY workTimes DESC";
		ResultSet rsResultSet11 = null;
		IDB iDBUser = new DBImp();
		HardworkingInfo hardworkingInfo = null;
		try {
			pstmt11 = conn11.prepareStatement(sqlString11);
			pstmt11.setObject(1, dateString);
			pstmt11.setObject(2, companyIdLong);
			pstmt11.setObject(3, workTimes);
			System.out.println("日期：" + dateString);
			System.out.println("公司Id：" + companyIdLong);
			System.out.println("工作时长：" + workTimes);
			rsResultSet11 = pstmt11.executeQuery();
			while (rsResultSet11.next()) {
				hardworkingInfo = new HardworkingInfo();
				Long empIdLong = rsResultSet11.getLong(1);
				int empWorkTimes = rsResultSet11.getInt(2);
				hardworkingInfo.setUserName(iDBUser.getUserById(empIdLong)
						.getUserName());
				hardworkingInfo.setWorkTimes(empWorkTimes);
				hardworkingInfo.setImgUrl(iDBUser.getUserById(empIdLong)
						.getImgUrl());
				hardworkingInfo.setDepartmentName(iDBUser.getGroupsByUidCid(
						empIdLong, companyIdLong).getTgName());
				System.out.println("hardworkingInfo:" + hardworkingInfo);
				empHardworkingInfoList.add(hardworkingInfo);
			}
			System.out.println("打印出empHardworkingInfoList:"
					+ empHardworkingInfoList);
			return empHardworkingInfoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn11, pstmt11, rsResultSet11);
		}

		return null;
	}

	@Override
	public List<LateInfo> queryEmpLateTimes(Long companyIdLong,
			String dateString) {
		// 根据公司Id和日期查询出员工迟到排行榜，降序(注意查询时要让lateTimes字段大于0)
		List<LateInfo> lateInfoList = new ArrayList<LateInfo>();
		Connection conn12 = DBConn.getConn();
		PreparedStatement pstmt12 = null;
		ResultSet rsResultSet12 = null;
		String sqlString12 = "SELECT employeeId,lateTimes FROM signinandoffinfo WHERE "
				+ "signDate=? and companyId=? and lateTimes>0 ORDER BY lateTimes DESC";
		IDB iDBUser = new DBImp();
		LateInfo lateInfo = null;
		try {
			pstmt12 = conn12.prepareStatement(sqlString12);
			pstmt12.setObject(1, dateString);
			pstmt12.setObject(2, companyIdLong);
			rsResultSet12 = pstmt12.executeQuery();
			while (rsResultSet12.next()) {
				lateInfo = new LateInfo();
				Long empIdLong = rsResultSet12.getLong(1);
				int empLateTimes = rsResultSet12.getInt(2);
				// String departmentString = lateInfo.getDepartmentName();
				// String portraitUrl = lateInfo.getImgUrl();
				lateInfo.setUserName(iDBUser.getUserById(empIdLong)
						.getUserName());
				lateInfo.setLateTimes(empLateTimes);
				lateInfo.setImgUrl(iDBUser.getUserById(empIdLong).getImgUrl());
				lateInfo.setDepartmentName(iDBUser.getGroupsByUidCid(empIdLong,
						companyIdLong).getTgName());
				System.out.println("DaoImpl层打印迟到信息：" + lateInfo);
				lateInfoList.add(lateInfo);
			}
			return lateInfoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn12, pstmt12, rsResultSet12);
		}
		return null;
	}

	/**
	 * 请假的处理
	 */
	// public static void main(String[] args) {
	// List<String> a=new ArrayList<>();
	// for (int i = 9; i <12; i++) {
	// a.add("2016-11-"+i);
	// }
	// new SignSettingInfoDaoImpl().insertAskforLeave(1l,1l,a);
	// }
	@Override
	public void insertAskforLeave(Long employeeIdLong, Long companyIdLong,
			List<String> dateStringList) {

		Connection conn13 = DBConn.getConn();
		PreparedStatement pstmt13 = null;
		String sqlString13 = "INSERT INTO signinandoffinfo(employeeId,companyId,signInStatus,signDate) VALUES (?,?,4,?)";
		try {

			for (int i = 0; i < dateStringList.size(); i++) {
				pstmt13 = conn13.prepareStatement(sqlString13);
				pstmt13.setObject(1, employeeIdLong);
				pstmt13.setObject(2, companyIdLong);
				pstmt13.setObject(3, dateStringList.get(i));
				System.out.println(" employeeIdLong" + employeeIdLong);
				System.out.println("companyIdLong" + employeeIdLong);
				System.out.println("dateStringList.get(i)"
						+ dateStringList.get(i));
				pstmt13.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn13, pstmt13);
		}
	}

	/**
	 * 出差的处理
	 */
	@Override
	public void insertOnBusinessTrip(Long employeeIdLong, Long companyIdLong,
			List<String> dateStringList) {
		Connection conn14 = DBConn.getConn();
		PreparedStatement pstmt14 = null;
		String sqlString14 = "INSERT INTO signinandoffinfo(employeeId,companyId,signInStatus,signDate) VALUES (?,?,5,?)";
		try {
			for (int i = 0; i < dateStringList.size(); i++) {
				pstmt14 = conn14.prepareStatement(sqlString14);
				pstmt14.setObject(1, employeeIdLong);
				pstmt14.setObject(2, companyIdLong);
				pstmt14.setObject(3, dateStringList.get(i));
				pstmt14.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn14, pstmt14);
		}

	}

	/**
	 * 统计请假人数
	 */
	@Override
	public int querySignInAskforleave(long companyId, String dateString) {
		Connection conn15 = DBConn.getConn();
		PreparedStatement pstmt15 = null;
		String sqlString15 = "SELECT * FROM signinandoffinfo WHERE companyId = ? AND signDate = ? AND signInStatus = 4";
		ResultSet rsResultSet15 = null;
		int signOffEarlyCount15 = 0;
		try {
			pstmt15 = conn15.prepareStatement(sqlString15);
			pstmt15.setObject(1, companyId);
			pstmt15.setObject(2, dateString);
			rsResultSet15 = pstmt15.executeQuery();
			while (rsResultSet15.next()) {
				signOffEarlyCount15++;
			}
			return signOffEarlyCount15;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn15, pstmt15, rsResultSet15);
		}
		return 0;
	}

	/**
	 * 统计出差人数
	 */
	@Override
	public int querySignInOnBusiness(long companyId, String dateString) {
		Connection conn16 = DBConn.getConn();
		PreparedStatement pstmt16 = null;
		String sqlString16 = "SELECT * FROM signinandoffinfo WHERE companyId = ? AND signDate = ? AND signInStatus = 5";
		ResultSet rsResultSet16 = null;
		int signOffEarlyCount16 = 0;
		try {
			pstmt16 = conn16.prepareStatement(sqlString16);
			pstmt16.setObject(1, companyId);
			pstmt16.setObject(2, dateString);
			rsResultSet16 = pstmt16.executeQuery();
			while (rsResultSet16.next()) {
				signOffEarlyCount16++;
			}
			return signOffEarlyCount16;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn16, pstmt16, rsResultSet16);
		}
		return 0;
	}

	/**
	 * 查询员工平均工作时长
	 */
	@Override
	public Float queryAveWorkTimes(String yearString, String monthString,
			Long companyIdLong, Long employeeIdLong) {
		int yearInt = Integer.valueOf(yearString);
		int monthInt = Integer.valueOf(monthString);
		System.out.println("年：" + yearInt);
		System.out.println("月：" + monthInt);
		System.out.println("公司Id：" + companyIdLong);
		System.out.println("员工Id：" + employeeIdLong);
		Connection conn17 = DBConn.getConn();
		PreparedStatement pstmt17 = null;
		ResultSet rsResultSet17 = null;
		String sqlString17 = "SELECT AVG(workTimes) FROM signinandoffinfo WHERE companyId = ? AND employeeId = ? AND year(signDate)=? AND month(signDate)=?";
		System.out.println("查询平均工时语句：" + sqlString17);
		try {
			pstmt17 = conn17.prepareStatement(sqlString17);
			pstmt17.setObject(1, companyIdLong);
			pstmt17.setObject(2, 4);
			pstmt17.setObject(3, yearInt);
			pstmt17.setObject(4, monthInt);
			rsResultSet17 = pstmt17.executeQuery();
			while (rsResultSet17.next()) {
				System.out.println("平均工时：" + rsResultSet17.getFloat(1));
				return rsResultSet17.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (float) 0.000;
	}

	// @Override
	// public int queryPersonNormalCount(String yearString, String monthString,
	// Long companyIdLong, Long employeeIdLong) {
	// return 0;
	// }
	//
	// @Override
	// public int queryPersonEarlyCount(String yearString, String monthString,
	// Long companyIdLong, Long employeeIdLong) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int queryPersonLateCount(String yearString, String monthString,
	// Long companyIdLong, Long employeeIdLong) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int queryPersonAbsentCount(String yearString, String monthString,
	// Long companyIdLong, Long employeeIdLong) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int queryPersonAskforleaveCount(String yearString,
	// String monthString, Long companyIdLong, Long employeeIdLong) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int queryPersonOnBusinessCount(String yearString,
	// String monthString, Long companyIdLong, Long employeeIdLong) {
	// // TODO Auto-generated method stub
	// return 0;
	// }

	/**
	 * 正常=1 早退=2 迟到=3 请假=4 出差=5 旷工=6
	 */
	@Override
	public List<Integer> queryPersonCountList(String yearString,
			String monthString, Long companyIdLong, Long employeeIdLong) {
		List<Integer> statusList = new ArrayList<Integer>();
		List<Integer> statusCountList = new ArrayList<Integer>();
		int statusInt;
		statusList.add(1); // 正常
		statusList.add(2); // 早退
		statusList.add(3); // 迟到
		statusList.add(4); // 请假
		statusList.add(5); // 出差
		Connection conn18 = DBConn.getConn();
		PreparedStatement pstmt18 = null;
		ResultSet rsResultSet18 = null;
		System.out.println("statusList的大小：" + statusList.size());
		for (int i = 0; i < statusList.size(); i++) {
			// statusList = new ArrayList<Integer>();
			statusInt = statusList.get(i);
			String sqlString18 = "SELECT COUNT(employeeId) FROM signinandoffinfo WHERE companyId = ? AND employeeId = ? AND year(signDate)=? AND month(signDate)=? AND signInStatus = ?";
			try {
				pstmt18 = conn18.prepareStatement(sqlString18);
				pstmt18.setObject(1, companyIdLong);
				pstmt18.setObject(2, 4);
				pstmt18.setObject(3, Integer.valueOf(yearString));
				pstmt18.setObject(4, Integer.valueOf(monthString));
				pstmt18.setObject(5, statusInt);
				System.out.println("sqlString18语句：" + sqlString18);
				rsResultSet18 = pstmt18.executeQuery();
				while (rsResultSet18.next()) {
					statusCountList.add(rsResultSet18.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("打印statusCountList：" + statusCountList);
		DBConn.close(conn18, pstmt18, rsResultSet18);
		return statusCountList;
	}

	@Override
	public User queryUserObjectByEmpId(Long employeeIdLong) {
		IDB iDBUser = new DBImp();
		return iDBUser.getUserById(employeeIdLong);
	}

	@Override
	public int queryButtonStatus(long employeeId, long companyId,
			String dateString) {
		String onTimeString = "";
		String offTimeString = "";
		Connection conn19 = DBConn.getConn();
		PreparedStatement pstmt19 = null;
		ResultSet rsResultSet19 = null;
		String sqlString19 = "select onTime,offTime from signinandoffinfo where employeeId = ? and companyId = ? and signDate = ?";
		try {
			pstmt19 = conn19.prepareStatement(sqlString19);
			pstmt19.setObject(1, employeeId);
			pstmt19.setObject(2, companyId);
			pstmt19.setObject(3, dateString);
			rsResultSet19 = pstmt19.executeQuery();
			// 三种情况：1.rsResultSet19直接为空，那么返回0;
			while (rsResultSet19.next()) {
				onTimeString = rsResultSet19.getString(1);
				offTimeString = rsResultSet19.getString(2);
				if (!onTimeString.equals("00:00")
						&& !offTimeString.equals("00:00")) {
					return 1; // 说明今天已签到和签退
				}
				if (!onTimeString.equals("00:00")
						&& offTimeString.equals("00:00")) {
					return 2; // 说明已签到，但未签退
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn19, pstmt19, rsResultSet19);
		}
		return 0; // 说明没签到，没签退
	}

	// Connection connPatial = DBConn.getConn();
	// PreparedStatement queryPatialSettingInfopstmt = null;
	// PreparedStatement queryWorkDatePstmt = null;
	// String queryPatialSettingInfopatmtString =
	// "select * from company_setting where companyId = "
	// + companyIdLong;
	// String queryWorkdateString = "select * from workday where companyId = "
	// + companyIdLong;
	// ResultSet queryResultSet = null;
	// ResultSet queryWorkdayResultSet = null;
	// List<String> workDateLists = new ArrayList<String>();
	// QueryCompanySettingInfoBean mCompanySettingInfoBean = new
	// QueryCompanySettingInfoBean();
	//
	// try {
	// queryWorkDatePstmt = connPatial
	// .prepareStatement(queryWorkdateString);
	// queryWorkdayResultSet = queryWorkDatePstmt.executeQuery();
	// while (queryWorkdayResultSet.next()) {
	// workDateLists.add(queryWorkdayResultSet
	// .getObject("workdayDate") + "");
	// }
	//
	// queryPatialSettingInfopstmt = connPatial
	// .prepareStatement(queryPatialSettingInfopatmtString);
	// queryResultSet = queryPatialSettingInfopstmt.executeQuery();
	// while (queryResultSet.next()) {
	// companyLatitudeDouble = (Double) queryResultSet
	// .getObject("latitude");
	// companyLongitudeDouble = (Double) queryResultSet
	// .getObject("longitude");
	// companyOnTimeString = (String) queryResultSet
	// .getObject("onTime");
	// companyOffTimeString = (String) queryResultSet
	// .getObject("offTime");
	// companyElasticityInt = (Integer) queryResultSet
	// .getObject("elasticityTime");
	// companyEffectiveRangeInt = (Integer) queryResultSet
	// .getObject("effectiveRange");
	// companyEarlistTimeInt = (Integer) queryResultSet
	// .getObject("earliestTime");
	// mCompanySettingInfoBean
	// .setmDoubleLatitude(companyLatitudeDouble);
	// mCompanySettingInfoBean
	// .setmDoubleLongitude(companyLongitudeDouble);
	// mCompanySettingInfoBean.setOnTimeString(companyOnTimeString);
	// mCompanySettingInfoBean.setOffTimeString(companyOffTimeString);
	// mCompanySettingInfoBean
	// .setmIntElasticTime(companyElasticityInt);
	// mCompanySettingInfoBean
	// .setmIntEffectiveRange(companyEffectiveRangeInt);
	// mCompanySettingInfoBean
	// .setmIntEarliestTime(companyEarlistTimeInt);
	// }
	// mCompanySettingInfoBean.setWorkDateLists(workDateLists);
	// System.out.println("CompanySettingInfoBean对象："
	// + mCompanySettingInfoBean);
	// return mCompanySettingInfoBean;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// DBConn.close(connPatial, queryPatialSettingInfopstmt,
	// queryWorkDatePstmt, queryResultSet, queryWorkdayResultSet);
	// }
	// return null;

	@Override
	public CompanySignSettingInfoBean querySettingAllInfo(Long companyIdLong) {
		CompanySignSettingInfoBean companySignSettingInfoBean = new CompanySignSettingInfoBean();
		Connection conn20 = DBConn.getConn();
		PreparedStatement pstmt20 = null;
		String sqlString20 = "select * from company_setting where companyId ="
				+ companyIdLong;
		ResultSet rsResultSet20 = null;
		Boolean isAutoBreakByLaw;

		try {
			pstmt20 = conn20.prepareStatement(sqlString20);
			rsResultSet20 = pstmt20.executeQuery();
			while (rsResultSet20.next()) {
				double mCompanyLatitudeDouble = (Double) rsResultSet20
						.getObject("latitude");
				double mCompanyLongitudeDouble = (Double) rsResultSet20
						.getObject("longitude");
				String mCompanyOnTimeString = (String) rsResultSet20
						.getObject("onTime");
				String mCompanyOffTimeString = (String) rsResultSet20
						.getObject("offTime");
				int mCompanyElasticityInt = (Integer) rsResultSet20
						.getObject("elasticityTime");
				int mCompanyEffectiveRangeInt = (Integer) rsResultSet20
						.getObject("effectiveRange");
				int mCompanyEarlistTimeInt = (Integer) rsResultSet20
						.getObject("earliestTime");
				String mTitleString = (String) rsResultSet20
						.getObject("companyTitle");
				String mSnippetString = (String) rsResultSet20
						.getObject("companySnippet");
				int hardworkingTime = (Integer) rsResultSet20
						.getObject("hardworkingTime");
				String mWorkWeekString = (String) rsResultSet20
						.getObject("workWeeks");
				String mBreakString = (String) rsResultSet20
						.getObject("breakWeeks");
				byte mIsAutoBreakByLaw = rsResultSet20
						.getByte("isAutoBreakByLaw");
				if (mIsAutoBreakByLaw == 0) {
					isAutoBreakByLaw = false;
				} else {
					isAutoBreakByLaw = true;
				}

				companySignSettingInfoBean
						.setmDoubleLatitude(mCompanyLatitudeDouble);
				companySignSettingInfoBean
						.setmDoubleLongitude(mCompanyLongitudeDouble);
				companySignSettingInfoBean
						.setOnTimeString(mCompanyOnTimeString);
				companySignSettingInfoBean
						.setOffTimeString(mCompanyOffTimeString);
				companySignSettingInfoBean
						.setmIntElasticTime(mCompanyElasticityInt);
				companySignSettingInfoBean
						.setmIntEffectiveRange(mCompanyEffectiveRangeInt);
				companySignSettingInfoBean
						.setmIntEarliestTime(mCompanyEarlistTimeInt);
				companySignSettingInfoBean.setAutoBreakByLaw(isAutoBreakByLaw);
				companySignSettingInfoBean.setmIntHardAveTime(hardworkingTime);
				companySignSettingInfoBean.setmOnWeekString(mWorkWeekString);
				companySignSettingInfoBean.setmOffWeekString(mBreakString);
				companySignSettingInfoBean.setmStringTitle(mTitleString);
				companySignSettingInfoBean.setmStringSnippet(mSnippetString);
				System.out.println("服务器端的对象：" + companySignSettingInfoBean);
				return companySignSettingInfoBean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// test
	// public static void main(String[] args) {
	// SignSettingInfoDaoImpl test = new SignSettingInfoDaoImpl();
	// System.out.println(test.queryButtonStatus(1, 1, "2016-11-09"));
	// }

}
