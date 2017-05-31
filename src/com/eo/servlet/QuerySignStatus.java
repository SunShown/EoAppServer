package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;

/**
 * Servlet implementation class QuerySignStatus
 */
public class QuerySignStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private List<Integer> countLists;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("heheda");
		System.out.println(request.getParameter("companyId"));
		long companyId = Integer.valueOf(request.getParameter("companyId"));
		String dateString = request.getParameter("dateString");
		
		System.out.println("公司Id:"+companyId);
		System.out.println("当前日期："+dateString);
		int totalCount = iSignSettingInfoService.queryTotalCount(companyId,dateString);
		int signInNormalCount = iSignSettingInfoService.querySignInNormalStatus(companyId,dateString);
		int signInLateCount = iSignSettingInfoService.querySignInLateStatus(companyId,dateString);
		int signOffEarlyCount = iSignSettingInfoService.querySignOffEarlyStatus(companyId,dateString);
		int signInAskforleaveCount = iSignSettingInfoService.querySignInAskforleave(companyId,dateString);
		int signInOnBusinessCount = iSignSettingInfoService.querySignInOnBusiness(companyId,dateString);
		System.out.println(totalCount + " "+signInNormalCount+" "+signInAskforleaveCount);
		countLists = new ArrayList<Integer>();
		countLists.add(totalCount);
		countLists.add(signInNormalCount);    //状态应该为1
		countLists.add(signInLateCount);      //状态应该为3
		countLists.add(signOffEarlyCount);    //状态应该为2
		countLists.add(signInAskforleaveCount); //状态应该为4
		countLists.add(signInOnBusinessCount); //状态应该为5
		
		
		// public static final int ASKFORLEAVE = 4;   //请假
	   // public static final int BUSITRIP = 5;  //出差
	   // public static final int ABSENT = 6;  //旷工
		
		for (int i = 0; i < countLists.size(); i++) {
			System.out.println(countLists.get(i));
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.print(countLists);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
