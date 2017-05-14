package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class ShowSignSetttingInfo
 */
public class ShowSignSetttingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	CompanySignSettingInfoBean companySignSettingInfoBean;
	private String gsonString;
	private String gsonUrlString;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long companyIdLong = Long.valueOf(request.getParameter("companyId"));
		System.out.println("测试客户端的数据穿过来没有："+companyIdLong);
		companySignSettingInfoBean = iSignSettingInfoService.queryAllSettingInfo(companyIdLong);
		PrintWriter printWriter = response.getWriter();
		Gson mGson = new Gson();
		
		if (companySignSettingInfoBean!=null) {
			gsonString = mGson.toJson(companySignSettingInfoBean, com.eo.entity.CompanySignSettingInfoBean.class);
			gsonUrlString = URLEncoder.encode(gsonString, "utf-8");
			printWriter.print(gsonUrlString);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
