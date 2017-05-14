package com.liu.xutils.shenpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.service.ApproveinfoService;
import com.liu.serviceimly.ApproveinfoServiceimly;
import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.Approveinfo;

public class GetColumns extends HttpServlet {

	ApproveinfoService service=new ApproveinfoServiceimly();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		PrintWriter out = response.getWriter();
	    String typename=request.getParameter("typename");
		Gson gson=new Gson();
		List<ApproveColumn> columns=service.getAppcolumns(typename);
		Type type=new TypeToken<List<ApproveColumn>>(){}.getType();
		
		out.println(gson.toJson(columns, type));
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

}
