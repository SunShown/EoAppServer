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
import com.liu.service.Approveruleservice;
import com.liu.serviceimly.Approveruleserviceimly;
import com.liu.xutils.pojo.ApproveRule;
import com.liu.xutils.pojo.ApproveType;


public class GetRules extends HttpServlet {
	Approveruleservice service=new Approveruleserviceimly();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
	   String companyId=request.getParameter("companyId");
	   Gson gson=new Gson();
	   Type type=new TypeToken<List<ApproveType>>(){}.getType();
		
		out.println(gson.toJson(service.GetApproveRuleByTypeName(Long.parseLong(companyId)), type));
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

}
