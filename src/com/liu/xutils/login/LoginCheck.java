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
import com.google.gson.GsonBuilder;
import com.liu.db.DBImp;
import com.liu.xutils.pojo.User;

public class LoginCheck extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Integer length=0;
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String userId=request.getParameter("userId");
		DBImp dbImp=new DBImp();
		List<User> userlist=dbImp.getUserByUserId(userId, 0);
		 length=userlist.size();
		if(length==0){
			out.print(length);
			System.out.println(length);
		}else {
			Gson g = new GsonBuilder().serializeNulls().create();
			out.print(g.toJson(userlist.get(0)));
			System.out.println(g.toJson(userlist.get(0)));
		}
		out.flush();
		out.close();		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
