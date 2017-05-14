package com.liu.xutils.Chats;

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
import com.liu.xutils.pojo.ChatGroup;
import com.liu.xutils.pojo.User;

public class GetAllChatGroup extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId=request.getParameter("userId");
//		User users=new User();
		List<ChatGroup> chatGroups=DBImp.getInstance().getChatGroupByUserId(userId);
		for (ChatGroup chatGroup : chatGroups) {
			List<User> users=new ArrayList<User>();
			List<String> userIds=DBImp.getInstance().getChatUserIds(chatGroup.getGroupId());
			System.out.println("用户"+userIds);
			for (String string : userIds) {
				List<User> usersDb=DBImp.getInstance().getUserByUserId(string, 0);
				User user=usersDb.get(0);
				try {
					Util.getRongCloud().user.refresh(user.getUserId(),user.getUserName(),Util.HTTPPRE+user.getImgUrl());
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				users.add(user);
			}
			chatGroup.setUsers(users);
		}
		Gson gson=new Gson();
		
		String outJson=gson.toJson(chatGroups);
		System.out.println("hhahha"+outJson);
		PrintWriter out=response.getWriter();
		out.print(outJson);
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
