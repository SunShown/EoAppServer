package com.liu.xutils.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.db.DBImp;
import com.liu.xutils.pojo.User;

public class TelExist extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String telnum=request.getParameter("telnum");
		System.out.println(telnum);
		DBImp dbImp=new DBImp();
		List<User> users=dbImp.getUserByUserId(telnum, 0);
		Integer isExist=users.size();
		PrintWriter out = response.getWriter();
		System.out.println(isExist);
		out.print(isExist);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
