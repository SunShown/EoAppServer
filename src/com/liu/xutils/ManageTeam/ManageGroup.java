package com.liu.xutils.ManageTeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.db.DbPool;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

/**
 * 对团队进行管理包括添加子部门，更改部门信息，添加成员 通过传过来的参数不一样来区别 addChild、update、addMem
 * 
 * @author hui
 *
 */
public class ManageGroup extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if (request.getParameter("addChild") != null) {// 添加子部门
			String groupMsg = request.getParameter("group");
			System.out.println(groupMsg);
			Gson gson = new Gson();
			Group group = gson.fromJson(groupMsg, Group.class);
			Long length = DBImp.getInstance().addGroup(group);
			if (length > 0) {
				out.print(length);// 添加成功返回id
				System.out.println(length);
			} else {

				System.out.println(length);
			}
		} else if (request.getParameter("update") != null) {// 更改 部门信息
			String groupMsg = request.getParameter("group");
			Gson gson = new Gson();
			Group group = gson.fromJson(groupMsg, Group.class);
			System.out.println("更改部门信息" + groupMsg);
			int index = DBImp.getInstance().updateGroup(group);
			if (index > 0) {
				out.print("200");
				System.out.println(200);
			} else {
				out.print("404");
				System.out.println(404);
			}
		} else if (request.getParameter("addMem") != null) {// 添加成员
			String userJson = request.getParameter("addMem");
			Gson userGson = new Gson();
			User user = userGson.fromJson(userJson, User.class);
			Group userGroup = user.getGroup();
			System.out.println(user.toString());
			System.out.println(userGroup.getTgId());
			int index = DBImp.getInstance().addMemberToGroup(user);
			if (index > 0) {
				out.print("200");
				System.out.println("200");
			} else {
				out.print("404");
				System.out.println("404");
			}
		} else if (request.getParameter("delete") != null) {// 删除部门
			String currentGidStr = request.getParameter("currentGid");
			String targetGidStr = request.getParameter("targetGid");
			Long currentGid = Long.parseLong(currentGidStr);
			Long targetGid = Long.parseLong(targetGidStr);
			System.out.println(currentGid + " " + targetGid);
			int index = DBImp.getInstance().deleteGroup(currentGid, targetGid);
			System.out.println(index);
			if (index > 0) {
				out.print("200");
				System.out.println(200);
			} else {
				out.print("404");
			}
		} else if (request.getParameter("editMember") != null) {
			String userStr = request.getParameter("user");
			// System.out.println(userStr);
			Gson gson = new Gson();
			User user = gson.fromJson(userStr, User.class);
			if (request.getParameter("deleteMember") != null) {
				int length=DBImp.getInstance().deleteUserFromGroup(user.getId());
				if(length>0){
					out.print("200");
				}
			} else {
				int length = DBImp.getInstance().updateUser(user);
				int chageGroupLength = DBImp.getInstance().changeUserGroup(
						user.getId(), user.getGroup().getTgId());
				if (length > 0 && chageGroupLength > 0) {
					out.print("200");
					System.out.println("更改成功");
				}
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
