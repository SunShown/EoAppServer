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
 * Servlet implementation class QerySignInAndOffInfo
 */
public class QerySignInAndOffInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private int ButtonStatus;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			long employeeId = Long.valueOf(request.getParameter("employeeId"));
			long companyId = Long.valueOf(request.getParameter("companyId"));
			String dateString  = request.getParameter("dateString");
			ButtonStatus = iSignSettingInfoService.queryButtonStatus(employeeId,companyId,dateString);
			
			//return 0;     //说明没签到，没签退
			//return 1;     // 说明今天已签到和签退
			//return 2;     // 说明已签到，但未签退
			PrintWriter printWriter = response.getWriter();
			printWriter.print(ButtonStatus);
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
