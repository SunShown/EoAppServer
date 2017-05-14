package com.liu.xutils.Chats;

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
import com.liu.xutils.pojo.ChatGroup;
import com.liu.xutils.pojo.User;

public class GetCurrentChatGroup extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String chatGroupId=request.getParameter("chatGroupId");
		ChatGroup chatGroup=DBImp.getInstance().getChatGroup(chatGroupId);
		List<String> userIds=DBImp.getInstance().getChatUserIds(chatGroupId);
		System.out.println("userIds"+userIds);
		List<User> chatUsers=new ArrayList<User>();
		for (String userId : userIds) {
			List<User> users=DBImp.getInstance().getUserByUserId(userId, 0);
			User user=users.get(0);
			chatUsers.add(user);
		}
		chatGroup.setUsers(chatUsers);
		Gson gson=new Gson();
		String chatUserStr=gson.toJson(chatGroup);
		out.print(chatUserStr);
		System.out.println(chatGroupId);
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
