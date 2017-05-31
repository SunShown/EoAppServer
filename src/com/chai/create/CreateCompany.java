package com.chai.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.db.DBImp;
import com.liu.db.IDB;
import com.liu.util.DateUtil;
import com.liu.util.Util;
import com.liu.xutils.pojo.Company;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

public class CreateCompany extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDB idb=new DBImp();
		List<User> list=null;
		Long id=-1L;
		Long gid=-1L;
		int addnum=-1;
		String name=request.getParameter("name");
		String userId=request.getParameter("userid");
		String type=request.getParameter("type");
		String area=request.getParameter("area");
		String member=request.getParameter("member");
		Gson gson=new Gson();
		System.out.println("hahahaha");
		Type type1 = new TypeToken<List<User>>() {}.getType();
		list=gson.fromJson(member, type1);
		System.out.println(list);
//		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss[.fffffffff]");//设置显示格式
//        String nowTime="";
//        nowTime= df.format(dt);
		
        Timestamp time=new Timestamp(new Date().getTime());
        Company company=new Company();
        company.setCreateTime(time);
        company.setTcarea(area);
        company.setTcName(name);
        company.setTctype(type);
        id=idb.createCompany(company);
        company.setTcId(id);
        Group group=new Group();
        group.setDescription("默认");
        group.setParentTgId(0L);
        group.setTcId(id);
        group.setTgName(name);
        group.setTgId(gid);
        group.setCompany(company);
        group.setTgLeaderId(Long.parseLong(userId));
        gid=idb.addGroup(group);
        boolean addboss=idb.setUserBoss(Long.parseLong(userId));
        System.out.println(gid);
        addnum=idb.addMembersToCreateGruop(list, gid);
        Gson companyGson=new Gson();
        if(id>0&&gid>0&&addnum==list.size()&&addboss){
        	System.out.println("chenggong");
        	out.print(companyGson.toJson(group));
        }else{
        	out.print("fail");  
        }
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
