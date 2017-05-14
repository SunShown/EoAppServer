package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.dao.ISignSettingInfoDao;
import com.eo.entity.SignInAndOffInfo;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class InsertSignInOffInfo
 */

public class InsertSignInInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService mISignSettingInfoService = new SignSettingInfoServiceImpl();
	int resultInInt;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gsonString = URLDecoder.decode(request.getParameter("signInfo"),
				"utf-8");
		Gson mGson = new Gson();
		SignInAndOffInfo mSignInAndOffInfo = mGson.fromJson(gsonString,
				com.eo.entity.SignInAndOffInfo.class);
		System.out.println("testone" + mSignInAndOffInfo);

		resultInInt = mISignSettingInfoService
				.insertEmployeeSignInfo(mSignInAndOffInfo);
		System.out.println("插入签到数据成功否：" + resultInInt);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(resultInInt);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
