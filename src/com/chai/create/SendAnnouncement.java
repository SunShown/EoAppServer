package com.chai.create;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.db.IDB;
import com.liu.xutils.pojo.Announcement;
/*
 * encoded by chai
 */
public class SendAnnouncement extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDB idb=new DBImp();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Announcement a=null;
		String announcement=request.getParameter("announcement");
		Long tcId=Long.getLong(request.getParameter("tcId"));
		Gson gson=new Gson();
		a=gson.fromJson(announcement, Announcement.class);
		int index=-1;
		index=idb.addAnnouncement(a);
		if(index>0){
			out.print(announcement);
		}
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	
	}

}
