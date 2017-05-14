package com.liu.xutils.shenpi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.service.ApproveinfoService;
import com.liu.serviceimly.ApproveinfoServiceimly;

public class GetApproveInfo extends HttpServlet {
	ApproveinfoService service=new ApproveinfoServiceimly ();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String approveid=request.getParameter("approveid");
		Gson gson=new Gson();
		String str=gson.toJson(service.getApproveinfobyid(Integer.parseInt(approveid)));
		out.println(str);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

}
