package com.eo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eo.entity.CompanySignSettingInfoBean;
import com.eo.service.ISignSettingInfoService;
import com.eo.service.impl.SignSettingInfoServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class ReceiverSettingInfo
System.out.println("公司Id:"+companyIdInt);
 */
public class ReceiverSettingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISignSettingInfoService iInsertSettingInfo = new SignSettingInfoServiceImpl();
	private int resultInt;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiverString = URLDecoder.decode(request.getParameter("companySignSettingInfo"), "utf-8");
		String companyIdString = request.getParameter("companyId");
		int companyIdInt = Integer.valueOf(companyIdString);
		Gson myGson = new Gson();
		CompanySignSettingInfoBean companySignSettingInfo = myGson.fromJson(receiverString,com.eo.entity.CompanySignSettingInfoBean.class);
		
		System.out.println("测试一下，设置签到信息后的打印信息，主要看考勤周信息："+companySignSettingInfo);
		//将公司ID和公司的上班日期筛选出来并且插入数据库
		iInsertSettingInfo.insertSettingInfo(companyIdInt,companySignSettingInfo);
		
		//将公司ID和公司经、纬度、地点title、地点snippet、有效范围、上班弹性时间、旷工及迟到时间、最早打卡时间、上班提醒
		//下班提醒、上榜平均时长插入到数据库
		resultInt = iInsertSettingInfo.insertSettingInfoAll(companyIdInt,companySignSettingInfo);
		
		PrintWriter printWriter = response.getWriter();
		if (resultInt>0) {
			printWriter.print("保存成功！");
		}else {
			printWriter.print("保存失败，请重新保存！");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
