package com.liu.xutils.shenpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.service.ApproveService;
import com.liu.serviceimly.ApproveServiceimly;
import com.liu.xutils.pojo.ApproveState;

public class ShenpiCancel extends HttpServlet {

	ApproveService service = new ApproveServiceimly();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String statestr = request.getParameter("statejson");

		System.out.println(statestr);

		Gson gson = new Gson();
		ApproveState state = gson.fromJson(statestr, ApproveState.class);

		int str = service.AppCancel(state);
		System.out.println(str);
		// String str=gson.toJson();
		out.println(str);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
