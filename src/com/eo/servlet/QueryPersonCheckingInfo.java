package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class QueryPersonCheckingInfo
 */
public class QueryPersonCheckingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private Float aveWorktimes;
	private int aveWorktimesInt;
	// private int normalCount;
	// private int earlyOffCount;
	// private int lateCount;
	// private int absentCount;
	// private int askforleaveCount;
	// private int onBusinessCount;
	private List<Integer> countList;

	/**
	 * 正常=1 早退=2 迟到=3 请假=4 出差=5 旷工=6==========将aveWorktimes也添加到countList中
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String yearString = request.getParameter("yearString");
		String monthString = request.getParameter("monthString");
		Long companyIdLong = Long.valueOf(request.getParameter("companyId"));
		Long employeeIdLong = Long.valueOf(request.getParameter("employeeId"));

		aveWorktimes = iSignSettingInfoService.queryAveworktimes(yearString,
				monthString, companyIdLong, employeeIdLong);
		// normalCount =
		// iSignSettingInfoService.queryPersonNormalCount(yearString,monthString,companyIdLong,employeeIdLong);
		// earlyOffCount =
		// iSignSettingInfoService.queryPersonEarlyCount(yearString,monthString,companyIdLong,employeeIdLong);
		// lateCount =
		// iSignSettingInfoService.queryPersonLateCount(yearString,monthString,companyIdLong,employeeIdLong);
		// absentCount =
		// iSignSettingInfoService.queryPersonAbsentCount(yearString,monthString,companyIdLong,employeeIdLong);
		// askforleaveCount =
		// iSignSettingInfoService.queryPersonAskforleaveCount(yearString,monthString,companyIdLong,employeeIdLong);
		// onBusinessCount =
		// iSignSettingInfoService.queryPersonOnBusinessCount(yearString,monthString,companyIdLong,employeeIdLong);
		countList = iSignSettingInfoService.queryPersonCountList(yearString,
				monthString, companyIdLong, employeeIdLong);
		aveWorktimesInt = (int) (aveWorktimes / 60);
		countList.add(aveWorktimesInt); // 此时countList的数据为(正常、早退、迟到、请假、出差、平均工作时长)

		Gson mGson = new Gson();
		Type type = new TypeToken<List<Integer>>() {
		}.getType();
		
		String gsonString = mGson.toJson(countList, type);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(gsonString);

		System.out.println("打印的countList：" + countList);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
