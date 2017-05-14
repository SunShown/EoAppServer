package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.xutils.pojo.User;

/**
 * Servlet implementation class QueryWorkTimes
 */
public class QueryWorkTimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	List<Long> userTimeLists = new ArrayList<Long>();  //工作时长前三名的员工Id
	List<com.liu.xutils.pojo.User> userObjectList = new ArrayList<com.liu.xutils.pojo.User>();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentMonth = Integer.valueOf(request.getParameter("currentMonth"));
		long companyId = Long.valueOf(request.getParameter("companyId"));
		
		userTimeLists = iSignSettingInfoService.queryWorkTimesLists(currentMonth,companyId);
		System.out.println("servlet打印的List："+userTimeLists);  //[1,3,5]
		
		//继续查询根据userId，查询出三个用户的对象，并且以List<User>的形式返回
		userObjectList = iSignSettingInfoService.queryUserObjectByUSerId(userTimeLists);
		
		Gson mGson  = new Gson();
		Type type=new TypeToken<List<User>>(){}.getType();
		String gsonString = URLEncoder.encode(mGson.toJson(userObjectList, type), "utf-8");
		System.out.println("encoder后的gson字符串："+gsonString);

		PrintWriter printWriter = response.getWriter();
		printWriter.print(gsonString);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
