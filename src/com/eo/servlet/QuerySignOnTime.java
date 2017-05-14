package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.dao.impl.SignSettingInfoDaoImpl;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;

/**
 * Servlet implementation class QuerySignOnTime
 */
public class QuerySignOnTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//这里的signEmployeeId就是用户ID
		long employeeId = Integer.valueOf(request.getParameter("signEmployeeId"));
		long companyId = Integer.valueOf(request.getParameter("signCompanyId"));
		String signDateString = request.getParameter("signDateString");
		System.out.println("服务器端的签到日期："+signDateString);
		String returnSignTimeString = iSignSettingInfoService.queryEmployeeSignOnTime(employeeId,companyId,signDateString);
		System.out.println("返回的签到时间："+returnSignTimeString);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(returnSignTimeString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
