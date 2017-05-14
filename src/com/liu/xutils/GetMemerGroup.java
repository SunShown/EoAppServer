package com.liu.xutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liu.db.DBImp;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.Company;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.GroupMember;
import com.liu.xutils.pojo.User;

public class GetMemerGroup extends HttpServlet {
	/**
	 * 根据用户id 来寻所在团队。以及公司下的所有部门
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Long companyId = Long.parseLong(request.getParameter("companyId"));
		Long currentGid = Long.parseLong(request.getParameter("currentGId"));
		// 如果是查找只是查找当前部门所有成员
		GroupMember groupMember = new GroupMember();
		if(companyId!=-1){			
			if (currentGid != -1L) {
				List<Group> groups = DBImp.getInstance().getGroupsByCidPgid(companyId,
						currentGid, 1);
				groupMember.setGroups(groups);
			}
			List<User> users = DBImp.getInstance().getUsersByCidPgid(currentGid);
			groupMember.setUsers(users);
			Gson gson=new Gson();
			String array=gson.toJson(groupMember);
			out.print(array);
			System.out.println(array + "=========");
		}else {
			out.print("null");
			
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
