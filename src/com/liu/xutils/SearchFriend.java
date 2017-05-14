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
import com.google.gson.JsonObject;
import com.liu.db.DBImp;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

public class SearchFriend extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String friendId=request.getParameter("friendId");
		String companyId=request.getParameter("companyId");
		System.out.println(friendId);
		if(!friendId.trim().equals("")){
			List<User> userSource=DBImp.getInstance().getUserByUserId(friendId,1);//从数据库查取用户
			Group groupdefault=new Group();
			for (User user : userSource) {
				List<Group> groups=DBImp.getInstance().getGroupsByTelCid(user.getUserId(),Long.parseLong(companyId));	
				if(groups!=null){
					System.out.println(groups);
					Group group=groups.get(0);
					user.setGroup(group);
				}else {
					System.out.println(user.getUserName());
					user.setGroup(groupdefault);
				}
			}
			Gson gson=new Gson();
			String users=gson.toJson(userSource);
			out.print(users);
			System.err.println(users.toString());
		}else {
			out.print("nothing");
			System.out.println("nothing");
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
