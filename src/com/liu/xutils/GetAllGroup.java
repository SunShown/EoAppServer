package com.liu.xutils;

import io.rong.RongCloud;

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
import com.liu.db.DbPool;
import com.liu.util.Util;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.GroupMember;
import com.liu.xutils.pojo.User;

public class GetAllGroup extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long companyId=Long.parseLong(request.getParameter("companyId"));
		String chatGroupId=request.getParameter("chatGroupId");
		List<Group> groupsSql=DBImp.getInstance().getAllGroupByCid(companyId);
		
		List<Group> groups=new ArrayList<Group>();
		for (Group group : groupsSql) {
			List<User> users=DBImp.getInstance().getUsersByCidPgid(group.getTgId());
			group.setUsers(users);
			for (User user : users) {
				try {
					Util.getRongCloud().user.refresh(user.getUserId(),user.getUserName(),user.getImgUrl());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(chatGroupId!=null){
				List<String> chatGroups=DBImp.getInstance().getChatUserIds(chatGroupId);
				System.out.println(chatGroups);
				for (int i = 0; i <users.size(); i++) {					
					for (int j = 0; j < chatGroups.size(); j++) {
						if(users.get(i).getUserId().equals(chatGroups.get(j))){
							users.get(i).setExist(true);
							break;
						}
					}
				}
			}
			groups.add(group);
		}
		Gson gson=new Gson();
		String groupStr=gson.toJson(groups);
		PrintWriter out=response.getWriter();
		out.print(groupStr);
	
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
