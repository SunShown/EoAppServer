package com.liu.xutils.login;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.db.IDB;
import com.liu.util.Util;
import com.liu.xutils.pojo.User;

public class Regist extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDB idb=new DBImp();
		System.out.println("hahaha");
		List<User> registlist=new ArrayList<User>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Gson gson=new Gson();
		System.out.println(request.getParameter("registJson"));
		User user=gson.fromJson(request.getParameter("registJson"),User.class);
		System.out.println(user.getUserId()+user.getUserPwd());
		RongCloud cloud=Util.getRongCloud();
		TokenReslut userGetTokenResult=null;
		String imgUrl="http://www.rongcloud.cn/images/logo.png";
		try {
			userGetTokenResult = cloud.user.getToken(user.getUserId(),user.getUserPwd(),imgUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userGetTokenResult+"+++++++++++++++++++++++++++++++++++++");
		String token=userGetTokenResult.getToken();
		user.setUserToken(token);
		user.setImgUrl(imgUrl);
		user.setUserName(user.getUserId());
		int length=idb.insert(user);
		if(length>0){
			registlist=idb.getUserByUserId(user.getUserId(), 0);
		}
		Gson gson1=new Gson();
		String user_return=gson1.toJson(registlist.get(0));
		out.print(user_return);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
