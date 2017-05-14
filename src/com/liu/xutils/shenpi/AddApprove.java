package com.liu.xutils.shenpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.service.ApproveinfoService;
import com.liu.serviceimly.ApproveinfoServiceimly;
import com.liu.xutils.pojo.Approveinfo;

public class AddApprove extends HttpServlet {

	ApproveinfoService service=new ApproveinfoServiceimly();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String companyId=request.getParameter("companyId");
		String str=request.getParameter("approveinfo");
		System.out.println();
		Gson gson=new Gson();
		Type type=new TypeToken<Approveinfo>(){}.getType();
		Approveinfo approveinfo=gson.fromJson(str, type);
		int flag=service.ApproveSend(approveinfo, Integer.parseInt(companyId));
		out.println(flag);
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

}
