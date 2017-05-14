package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;
import com.liu.xutils.pojo.User;

/**
 * Servlet implementation class QueryPersonPortrait
 */
public class QueryPersonPortrait extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iSignSettingInfoService = new SignSettingInfoServiceImpl();
	private User userObject;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long employeeIdLong = Long.valueOf(request.getParameter("employeeId"));
		userObject = iSignSettingInfoService
				.queryUserObjectByEmployeeId(employeeIdLong);
		Gson mGson = new Gson();
		String gsonString = mGson.toJson(userObject,
				com.liu.xutils.pojo.User.class);
		String urlGsonString = URLEncoder.encode(gsonString, "utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(urlGsonString);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
