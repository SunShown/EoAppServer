package com.liu.xutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.xutils.pojo.User;

public class ContactCard extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String userId = request.getParameter("userId");
		DBImp dbImp = DBImp.getInstance();
		List<User> users=dbImp.getUserByUserId(userId,0);
		Gson gson=new Gson();
		String user=gson.toJson(users.get(0));
		out.print(user);
		System.out.println(user+"哈哈哈哈哈");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
