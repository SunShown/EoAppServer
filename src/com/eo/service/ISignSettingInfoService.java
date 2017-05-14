package com.eo.service;

import java.util.List;
import java.util.Map;

import cn.jpush.api.report.UsersResult.User;

import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.entity.HardworkingInfo;
import com.eo.entity.LateInfo;
import com.eo.entity.QueryCompanySettingInfoBean;
import com.eo.entity.SignInAndOffInfo;
import com.eo.entity.SignInfoBean;

public interface ISignSettingInfoService {

	public void insertSettingInfo(Integer companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfoBean);

	public int insertSettingInfoAll(int companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfo);

	public QueryCompanySettingInfoBean querySettingInfoByCompanyId(long companyIdLong);

	public int insertEmployeeSignInfo(SignInAndOffInfo mSignInAndOffInfo);

	public int insertEmployeeSignOffInfo(SignInAndOffInfo mSignInAndOffInfo);

	public String queryEmployeeSignOnTime(long employeeId, long companyId, String signDateString);

	public int querySignInNormalStatus(long companyId, String dateString);

	public int querySignInLateStatus(long companyId, String dateString);

	public int querySignOffEarlyStatus(long companyId, String dateString);

	public List<Long> queryWorkTimesLists(int currentMonth, long companyId);

	public List<com.liu.xutils.pojo.User> queryUserObjectByUSerId(List<Long> userTimeLists);

	/**
	 *根据公司Id和所选日期查询该公司员工总数
	 * @param companyId
	 * @param dateString
	 * @return
	 */
	public int queryTotalCount(long companyId, String dateString);

	/**
	 * 根据公司Id查询出设置的上榜时间(勤奋榜)
	 * @param companyId
	 */
	public Long queryHardworkingTimes(Long companyId);

	/**
	 * 根据日期、公司Id、设置的上榜时间获取员工的信息(员工名、头像、所属部门、员工工作时长)，并且以工作时长降序排列出来
	 * @param dateString
	 * @param companyIdLong
	 * @param workTimes
	 * @return 
	 */
	public List<HardworkingInfo> queryHardworkingEmpInfo(String dateString, Long companyIdLong,
			int workTimes);

	/**
	 * 根据公司Id与日期获取员工信心(LateInfo包含有员工名、部门名、员工头像、迟到时间)
	 * @param companyIdLong
	 * @param dateString
	 * @return 
	 */
	public List<LateInfo> queryLateTimes(Long companyIdLong, String dateString);

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
	public Float queryAveworktimes(String yearString, String monthString,
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
	public com.liu.xutils.pojo.User queryUserObjectByEmployeeId(
			Long employeeIdLong);

	/**
	 * 根据员工号、公司号、日期String查询出判断签到签退按钮的状态
	 * @param employeeId
	 * @param companyId
	 * @param dateString
	 */
	public int queryButtonStatus(long employeeId, long companyId,
			String dateString);

	//通过公司Id，查询出所有签到设置信息
	public CompanySignSettingInfoBean queryAllSettingInfo(Long companyIdLong);
	

}
