package com.eo.dao;

import java.util.List;
import java.util.Map;

import cn.jpush.api.report.UsersResult.User;

import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.entity.HardworkingInfo;
import com.eo.entity.LateInfo;
import com.eo.entity.QueryCompanySettingInfoBean;
import com.eo.entity.SignInAndOffInfo;
import com.eo.entity.SignInfoBean;

public interface ISignSettingInfoDao {

	public void insertSignSettingInfo(Integer companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfoBean);

	public int insertSignSettingInfoAll(int companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfo);

	public QueryCompanySettingInfoBean querySettingInfoByCompanyId(
			long companyIdLong);

	public int insertSignInfo(SignInAndOffInfo mSignInAndOffInfo);

	public int insertSignOffInfo(SignInAndOffInfo mSignInAndOffInfo);

	public String queryEmployeeSignTime(long employeeId, long companyId, String signDateString);

	public int querySignInNormalCount(long companyId, String dateString);

	public int querySignInLateCount(long companyId, String dateString);

	public int querySignOffEarlyCount(long companyId, String dateString);

	public List<Long> queryWorkTimesLists(int currentMonth, long companyId);

	public List<com.liu.xutils.pojo.User> queryUserObjectByUserId(
			List<Long> userTimeLists);

	/**
	 * 查询该公司员工总数
	 * 
	 * @param companyId
	 * @param dateString
	 * @return
	 */
	public int queryTotalCount(long companyId, String dateString);

	/**
	 * 根据公司Id查询出公司设置的上榜时间
	 * 
	 * @param companyId
	 * @return
	 */
	public Long queryHardworkingTimes(Long companyId);

	/**
	 * 根据日期、公司Id、设置的上榜时间获取员工的信息(员工名、头像、所属部门、员工工作时长)，并且以工作时长降序排列出来
	 * @param dateString
	 * @param companyIdLong
	 * @param workTimes
	 * @return 
	 */
	public List<HardworkingInfo> queryHardworkingEmpInfo(String dateString,
			Long companyIdLong, int workTimes);

	public List<LateInfo> queryEmpLateTimes(Long companyIdLong,
			String dateString);
	
	/**
	 * 留给老司机的方法(将请假信息插入到表signinandoffinfo)
	 * @param employeeIdLong
	 * @param companyIdLong    
	 * @param dateString
	 * 
	 */
	public void insertAskforLeave(Long employeeIdLong,Long companyIdLong,List<String> dateStringList);

	/**
	 * 留给老司机的方法(将出差信息插入到表signinandoffinfo)
	 * @param employeeIdLong
	 * @param companyIdLong    
	 * @param dateString
	 * 
	 */
	public void insertOnBusinessTrip(Long employeeIdLong,Long companyIdLong,List<String> dateStringList);

	/**
	 * 根据公司Id与日期统计signInStatus为4(请假)情况下的人数
	 * @param companyId
	 * @param dateString
	 * @return
	 */
	public int querySignInAskforleave(long companyId, String dateString);

	/**
	 * 根据公司Id与日期统计signInStatus为5(出差)情况下的人数
	 * @param companyId
	 * @param dateString
	 * @return
	 */
	public int querySignInOnBusiness(long companyId, String dateString);

	/**
	 * 根据年、月、公司Id、员工Id查询出该员工平局工时
	 * @param yearString
	 * @param monthString
	 * @param companyIdLong
	 * @param employeeIdLong
	 * @return
	 */
	public Float queryAveWorkTimes(String yearString, String monthString,
			Long companyIdLong, Long employeeIdLong);

//	public int queryPersonNormalCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong);
//
//	public int queryPersonEarlyCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong);
//
//	public int queryPersonLateCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong);
//
//	public int queryPersonAbsentCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong);
//
//	public int queryPersonAskforleaveCount(String yearString,
//			String monthString, Long companyIdLong, Long employeeIdLong);
//
//	public int queryPersonOnBusinessCount(String yearString,
//			String monthString, Long companyIdLong, Long employeeIdLong);

	public List<Integer> queryPersonCountList(String yearString,
			String monthString, Long companyIdLong, Long employeeIdLong);

	/**
	 * 根据员工Id查询出员工user对象，用户客户端获取头像
	 * @param employeeIdLong
	 * @return
	 */
	public com.liu.xutils.pojo.User queryUserObjectByEmpId(Long employeeIdLong);

	/**
	 * 根据员工Id、公司Id、日期判断出按钮的状态
	 * @param employeeId
	 * @param companyId
	 * @param dateString
	 * @return 
	 */
	public int queryButtonStatus(long employeeId, long companyId,
			String dateString);

	public CompanySignSettingInfoBean querySettingAllInfo(Long companyIdLong);
	
	
	
}
