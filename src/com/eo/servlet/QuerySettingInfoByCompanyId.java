package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.entity.QueryCompanySettingInfoBean;
import com.eo.entity.SignInfoBean;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class QuerySettingInfoByCompanyId
 */
public class QuerySettingInfoByCompanyId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryCompanySettingInfoBean mQueryCompanySettingInfoBean;
    ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyIdString = request.getParameter("signInfo");
		long companyIdLong = Long.valueOf(companyIdString);
		mQueryCompanySettingInfoBean = iSignSettingInfoService.querySettingInfoByCompanyId(companyIdLong);
		Gson mGson = new Gson();
		String mQueryCompanySettingInfoBeanGsonString = mGson.toJson(mQueryCompanySettingInfoBean);
		System.out.println(mQueryCompanySettingInfoBeanGsonString);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(mQueryCompanySettingInfoBeanGsonString);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
