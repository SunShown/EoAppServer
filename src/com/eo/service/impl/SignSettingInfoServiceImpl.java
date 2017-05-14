package com.eo.service.impl;

import java.util.List;
import java.util.Map;

import cn.jpush.api.report.UsersResult.User;

import com.eo.dao.ISignSettingInfoDao;
import com.eo.dao.impl.SignSettingInfoDaoImpl;
import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.entity.HardworkingInfo;
import com.eo.entity.LateInfo;
import com.eo.entity.QueryCompanySettingInfoBean;
import com.eo.entity.SignInAndOffInfo;
import com.eo.entity.SignInfoBean;
import com.eo.service.ISignSettingInfoService;

public class SignSettingInfoServiceImpl implements ISignSettingInfoService {

	ISignSettingInfoDao iSignSettingInfoDao = new SignSettingInfoDaoImpl();

	// 插入签到信息，主要是上班日期
	@Override
	public void insertSettingInfo(Integer companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfoBean) {
		iSignSettingInfoDao.insertSignSettingInfo(companyIdInt,
				companySignSettingInfoBean);

	}

	// 插入签到信息
	@Override
	public int insertSettingInfoAll(int companyIdInt,
			CompanySignSettingInfoBean companySignSettingInfo) {
		
		return iSignSettingInfoDao.insertSignSettingInfoAll(companyIdInt,
				companySignSettingInfo);

	}

	// 根据公司Id，查询出所在公司的一些签到设置
	@Override
	public QueryCompanySettingInfoBean querySettingInfoByCompanyId(
			long companyIdLong) {
		return iSignSettingInfoDao.querySettingInfoByCompanyId(companyIdLong);

	}

	// 插入签到信息
	@Override
	public int insertEmployeeSignInfo(SignInAndOffInfo mSignInAndOffInfo) {
		return iSignSettingInfoDao.insertSignInfo(mSignInAndOffInfo);

	}

	// 插入签退信息
	@Override
	public int insertEmployeeSignOffInfo(SignInAndOffInfo mSignInAndOffInfo) {
		return iSignSettingInfoDao.insertSignOffInfo(mSignInAndOffInfo);

	}

	@Override
	public String queryEmployeeSignOnTime(long employeeId,long companyId,String signDateString) {
		return iSignSettingInfoDao.queryEmployeeSignTime(employeeId,companyId,
				signDateString);

	}

	// 查询签到正常的人数
	@Override
	public int querySignInNormalStatus(long companyId, String dateString) {

		return iSignSettingInfoDao
				.querySignInNormalCount(companyId, dateString);
	}

	// 查询签到迟到的人数
	@Override
	public int querySignInLateStatus(long companyId, String dateString) {

		return iSignSettingInfoDao.querySignInLateCount(companyId, dateString);
	}

	@Override
	public int querySignOffEarlyStatus(long companyId, String dateString) {

		return iSignSettingInfoDao
				.querySignOffEarlyCount(companyId, dateString);
	}

	@Override
	public List<Long> queryWorkTimesLists(int currentMonth, long companyId) {

		return iSignSettingInfoDao.queryWorkTimesLists(currentMonth, companyId);
	}

	/**
	 * 根据用户Id查询出用户的整个信息对象，然后传到客户端
	 */
	@Override
	public List<com.liu.xutils.pojo.User> queryUserObjectByUSerId(
			List<Long> userTimeLists) {

		return iSignSettingInfoDao.queryUserObjectByUserId(userTimeLists);
	}

	@Override
	public int queryTotalCount(long companyId, String dateString) {
		return iSignSettingInfoDao.queryTotalCount(companyId, dateString);
	}

	@Override
	public Long queryHardworkingTimes(Long companyId) {
		return iSignSettingInfoDao.queryHardworkingTimes(companyId);

	}

	@Override
	public List<HardworkingInfo> queryHardworkingEmpInfo(String dateString,
			Long companyIdLong, int workTimes) {
		
		return iSignSettingInfoDao.queryHardworkingEmpInfo(dateString,companyIdLong,workTimes);

	}

	@Override
	public List<LateInfo> queryLateTimes(Long companyIdLong, String dateString) {
		return iSignSettingInfoDao.queryEmpLateTimes(companyIdLong,dateString);
	}

	@Override
	public int querySignInAskforleave(long companyId, String dateString) {
		return iSignSettingInfoDao.querySignInAskforleave(companyId,dateString);
	}

	@Override
	public int querySignInOnBusiness(long companyId, String dateString) {
		
		return iSignSettingInfoDao.querySignInOnBusiness(companyId,dateString);
	}

	@Override
	public Float queryAveworktimes(String yearString, String monthString,
			Long companyIdLong, Long employeeIdLong) {
		return iSignSettingInfoDao.queryAveWorkTimes(yearString,monthString,companyIdLong,employeeIdLong);
	}

//	@Override
//	public int queryPersonNormalCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonNormalCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}
//
//	@Override
//	public int queryPersonEarlyCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonEarlyCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}
//
//	@Override
//	public int queryPersonLateCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonLateCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}
//
//	@Override
//	public int queryPersonAbsentCount(String yearString, String monthString,
//			Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonAbsentCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}
//
//	@Override
//	public int queryPersonAskforleaveCount(String yearString,
//			String monthString, Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonAskforleaveCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}
//
//	@Override
//	public int queryPersonOnBusinessCount(String yearString,
//			String monthString, Long companyIdLong, Long employeeIdLong) {
//		return iSignSettingInfoDao.queryPersonOnBusinessCount(yearString,monthString,companyIdLong,employeeIdLong);
//	}

	@Override
	public List<Integer> queryPersonCountList(String yearString,
			String monthString, Long companyIdLong, Long employeeIdLong) {
		return iSignSettingInfoDao.queryPersonCountList(yearString,monthString,companyIdLong,employeeIdLong);
	}

	@Override
	public com.liu.xutils.pojo.User queryUserObjectByEmployeeId(
			Long employeeIdLong) {
		// TODO Auto-generated method stub
		return iSignSettingInfoDao.queryUserObjectByEmpId(employeeIdLong);
	}

	@Override
	public int queryButtonStatus(long employeeId, long companyId,
			String dateString) {
			return iSignSettingInfoDao.queryButtonStatus(employeeId,companyId,dateString);
		
	}

	@Override
	public CompanySignSettingInfoBean queryAllSettingInfo(Long companyIdLong) {
		return iSignSettingInfoDao.querySettingAllInfo(companyIdLong);
		
		
	}

}
