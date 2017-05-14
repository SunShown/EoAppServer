package com.liu.xutils.shenpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.service.ApproveService;
import com.liu.serviceimly.ApproveServiceimly;
import com.liu.xutils.pojo.AllShenPiBean;

public class GetAllShenpiI extends HttpServlet {
	ApproveService service=new ApproveServiceimly();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userid");
		String searchinfo=request.getParameter("searchinfo");
		String  size=request.getParameter("size");
		String  page=request.getParameter("page");
		
		List<AllShenPiBean> beans=service.GetAllShenPii(Integer.parseInt(userId), searchinfo,Integer.parseInt(size),Integer.parseInt(page));
		Gson gson=new Gson();
		String str=gson.toJson(beans);
		
		
		out.println(str);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

}
