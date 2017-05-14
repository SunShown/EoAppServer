package com.liu.xutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.liu.db.DBImp;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;
/**
 * 根据用户的id和所在公司的id 查找出当前公司的部门
 * @author hui
 *	
 */
public class GetCurrentGroup extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			PrintWriter out=response.getWriter();	
			String tel=request.getParameter("tel");
			Long companyId=Long.parseLong(request.getParameter("companyId"));
			List<Group> groups=DBImp.getInstance().getGroupsByTelCid(tel, companyId);
//			System.out.println(groups);
			if(groups==null){
				out.print("null");
			}else {				
				JSONArray array=JSONArray.fromObject(groups);
				out.print(array.toString());
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
