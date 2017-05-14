package com.liu.xutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.xutils.pojo.Group;

public class GetGroupCurrentId extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Long companyId = Long.parseLong(request.getParameter("companyId"));
		Long parentId = Long.parseLong(request.getParameter("parentId"));
		List<Group> groups = DBImp.getInstance().getGroupsByCidPgid(
				companyId, parentId,0);
		if (groups.size() != 0) {
			Group group = groups.get(0);
			Gson gson=new Gson();
			String groupJson=gson.toJson(group);
			System.out.println(groupJson);
			out.print(groupJson);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
