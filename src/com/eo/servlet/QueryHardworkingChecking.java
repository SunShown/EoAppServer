package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.entity.HardworkingInfo;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class QueryHardworkingChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private List<HardworkingInfo> hardworkingInfoList = new ArrayList<HardworkingInfo>();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String dateString = request.getParameter("finalDateString");
		Long companyIdLong = Long.valueOf(request.getParameter("companyId"));
		int workTimes = Integer.valueOf(request.getParameter("checkingTime"));
		System.out.println("========================================");
		System.out.println("QueryHardworkingCheckingServlet的dateString"
				+ dateString);
		System.out.println("QueryHardworkingCheckingServlet的companyIdLong"
				+ companyIdLong);
		System.out.println("QueryHardworkingCheckingServlet的workTimes"
				+ workTimes);
		System.out.println("========================================");
		hardworkingInfoList = iSignSettingInfoService.queryHardworkingEmpInfo(
				dateString, companyIdLong, workTimes);
		System.out.println("QueryHardworkingCheckingServlet："
				+ hardworkingInfoList);
		Gson mGson = new Gson();
		Type type = new TypeToken<List<HardworkingInfo>>() {
		}.getType();
		String gsonString = URLEncoder.encode(
				mGson.toJson(hardworkingInfoList, type), "utf-8");
		System.out.println("gsonString最后传过去的值:" + gsonString);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(gsonString);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
