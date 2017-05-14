package com.liu.xutils.ManageTeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.db.DBImp;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;
/**
 * 根据客户端传过来的手机联系人进行筛选。与数据库的成员进行匹配，返回存在的成员
 * @author hui
 *
 */
public class TelContacts extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contact=request.getParameter("contacts");
		String companyId=request.getParameter("companyId");
		PrintWriter out=response.getWriter();
		System.out.println(contact);
		Gson gson=new Gson();
		List<User> users=gson.fromJson(contact, new TypeToken<List<User>>(){}.getType());
		List<User> resultUsers=DBImp.getInstance().getUserByTelConatacts(users);
		Group groupDefault=new Group();
		for (User user : resultUsers) {
			List<Group> groups=DBImp.getInstance().getGroupsByTelCid(user.getUserId(),Long.parseLong(companyId));
			if(groups!=null){				
				Group group=groups.get(0);
				user.setGroup(group);
			}else {
				user.setGroup(groupDefault);
			}
		}
		String userJson=gson.toJson(resultUsers);
		out.print(userJson);
		System.out.println(userJson);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
