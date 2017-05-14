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
import com.liu.xutils.pojo.Company;

public class MyCompany extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDB idb=new DBImp();
		response.setContentType("text/html");
		Company company;
		PrintWriter out = response.getWriter();
		Long tcId=Long.parseLong(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		company=idb.searchCompanyByCompanyId(tcId);
		Gson gson=new Gson();
		String companyto=gson.toJson(company);
		System.out.println(companyto);
		out.print(companyto);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
