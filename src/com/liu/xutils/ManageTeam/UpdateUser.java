package com.liu.xutils.ManageTeam;

import io.rong.RongCloud;
import io.rong.models.CodeSuccessReslut;
import io.rong.models.MsgObj;
import io.rong.models.PushMessage;
import io.rong.models.TagObj;
import io.rong.util.GsonUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liu.db.DBImp;
import com.liu.util.Util;
import com.liu.xutils.pojo.User;
import com.taobao.api.internal.mapping.Reader;

public class UpdateUser extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String userGson=request.getParameter("user");
		System.out.println(userGson);
		Gson gson=new Gson();
		User user=gson.fromJson(userGson,User.class);
		int index=DBImp.getInstance().updateUser(user);
		
		if(index>0){
			out.print("200");
		}
		
	}

}
