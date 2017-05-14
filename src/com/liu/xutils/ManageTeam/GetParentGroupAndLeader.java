package com.liu.xutils.ManageTeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.GroupMember;
import com.liu.xutils.pojo.User;

/**
 * 根据当前的group查找父group信息和当前部门的leader
 * 
 * @author hui
 *
 */
public class GetParentGroupAndLeader extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String parentId=request.getParameter("parentId");
		String currentTgId=request.getParameter("currentTgId");
		System.out.println(parentId+" "+currentTgId);
		long groupId=Long.parseLong(parentId);
		long currentId=Long.parseLong(currentTgId);
		Group group=DBImp.getInstance().getGroupById(groupId);
		System.out.println("group"+group);
		Group currentGroup=DBImp.getInstance().getGroupById(currentId);
		Long leaderId=currentGroup.getTgLeaderId();
		System.out.println("leaderId"+leaderId);
		GroupMember groupMember=new GroupMember();
		List<User> users=new ArrayList<User>();
		if(leaderId!=null&&!leaderId.equals(0L)){
			User user=DBImp.getInstance().getUserById(leaderId);
			users.add(user);
		}
		groupMember.setUsers(users);
		List<Group> groups=new ArrayList<Group>();
		if(group!=null){
			groups.add(group);		
		}
		groupMember.setGroups(groups);
		Gson gson=new Gson();
		String groupMsg=gson.toJson(groupMember);
		out.print(groupMsg);
		System.out.println(groupMsg);
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
