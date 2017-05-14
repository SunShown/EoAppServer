package com.liu.xutils.login;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.db.DBImp;
import com.liu.db.IDB;
import com.liu.xutils.pojo.User;

public class ForgetPassword extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int length=0;
		IDB idb=new DBImp();
		PrintWriter out = response.getWriter();
		String userTel=request.getParameter("telnum");
		String userPwd=request.getParameter("password");
		System.out.println(userTel+userPwd);
		length=idb.updatePwd(userTel, userPwd);
		Gson g = new GsonBuilder().serializeNulls().create();
		List<User> list=idb.getUserByUserId(userTel, 0);
		System.out.println(g.toJson(list.get(0)));
		out.print(g.toJson(list.get(0)));
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
