package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.entity.SignInAndOffInfo;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class InsertSignOffInfo
 */
public class InsertSignOffInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService mISignSettingInfoService = new SignSettingInfoServiceImpl();
	private int resultInt;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gsonString = URLDecoder.decode(request.getParameter("signOffInfo"), "utf-8");
		Gson mGson = new Gson();
		SignInAndOffInfo mSignInAndOffInfo = mGson.fromJson(gsonString, com.eo.entity.SignInAndOffInfo.class);
		System.out.println("testone"+mSignInAndOffInfo);
		resultInt = mISignSettingInfoService.insertEmployeeSignOffInfo(mSignInAndOffInfo);
		
		System.out.println("签退数据是否插入："+resultInt);
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print(resultInt);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
