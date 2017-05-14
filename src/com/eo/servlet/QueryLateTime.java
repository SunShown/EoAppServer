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

import com.eo.entity.LateInfo;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class QueryLateTime
 */
public class QueryLateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private Long companyIdLong;
	private String dateString;
	private List<LateInfo> lateInfoList = new ArrayList<LateInfo>();
	private String gsonString;
	private String urlgsonString;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		companyIdLong = Long.valueOf(request.getParameter("companyId"));
		dateString = request.getParameter("dateString");
		lateInfoList = iSignSettingInfoService.queryLateTimes(companyIdLong,
				dateString);
		System.out.println("QueryLateTimeServlet层的lateInfo：" + lateInfoList);
		Gson mGson = new Gson();
		Type type = new TypeToken<List<LateInfo>>() {
		}.getType();
		gsonString = mGson.toJson(lateInfoList, type);
		urlgsonString = URLEncoder.encode(gsonString, "utf-8");
		System.out.println("最终要传输的urlgsonString:"+urlgsonString);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(urlgsonString);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
