package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;

/**
 * Servlet implementation class QueryHardworkingTime
 */
public class QueryHardworkingTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
    private Long companySettingHardworkingTimes;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long companyId = Long.valueOf(request.getParameter("companyId"));
		System.out.println("查询客户端传递过来的值："+companyId);
		companySettingHardworkingTimes = iSignSettingInfoService.queryHardworkingTimes(companyId);
		System.out.println("公司设定的上榜时间："+companySettingHardworkingTimes);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(companySettingHardworkingTimes);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
