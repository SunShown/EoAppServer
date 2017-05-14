package com.chai.create;

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
import com.liu.xutils.pojo.Announcement;

public class GetAllAnnouncement extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDB idb=new DBImp();
		response.setContentType("text/html");
		List<Announcement> list=new ArrayList<Announcement>();
		list=idb.getAllAnnouncements();
		Gson gson=new Gson();
		String announcements=gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.print(announcements);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
