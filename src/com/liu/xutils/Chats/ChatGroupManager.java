package com.liu.xutils.Chats;

import io.rong.RongCloud;
import io.rong.models.ChatRoom;
import io.rong.models.ChatRoomInfo;
import io.rong.models.ChatRoomUser;
import io.rong.models.ChatroomQueryReslut;
import io.rong.models.ChatroomUserQueryReslut;
import io.rong.models.CodeSuccessReslut;
import io.rong.models.SMSSendCodeReslut;
import io.rong.models.TokenReslut;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ChatGroupManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		RongCloud rongCloud=Util.getRongCloud();
		
		System.out.println("讨论组");
		//表示是添加成员
		String chatMessage=request.getParameter("chatMessage");
		Gson gson=new Gson();
		ChatGroup chatGroup=gson.fromJson(chatMessage,ChatGroup.class);
		if(request.getParameter("flag")!=null){
			int[] legth=DBImp.getInstance().insertMemberToChatGroup(chatGroup);
			String[] a=new String[chatGroup.getUsers().size()];
			for (int i = 0; i < chatGroup.getUsers().size(); i++) {
				a[i]=chatGroup.getUsers().get(i).getUserId();
			}
			if(legth!=null){
				try {
					CodeSuccessReslut reslut=rongCloud.chatroom.join(a,chatGroup.getGroupId());
					System.out.println("添加成员"+reslut.getCode());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}else if(request.getParameter("quit")!=null){//退出讨论组
			System.out.println("quit"+chatGroup);
			int length[]=DBImp.getInstance().quitChatGroup(chatGroup);
			if(length!=null){
				out.print("200");
				System.out.println("更新成功");
			}else{
				out.print("404");
			}
		}else if(request.getParameter("changeName")!=null){//更新讨论组名称
			int length=DBImp.getInstance().updateChatGroupName(chatGroup);
			if(length>0){
				out.print("200");
			}else {
				out.print("404");
			}
		}else {
			int length=DBImp.getInstance().createChatGroup(chatGroup);
			System.out.println(chatGroup);
			if(length>0){			
				ChatRoomInfo chatRoomInfo[]={new ChatRoomInfo(chatGroup.getGroupId(),chatGroup.getName())};		
				try {
					CodeSuccessReslut reslut=rongCloud.chatroom.create(chatRoomInfo);
					System.out.println(reslut.getCode());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
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

		doGet(request, response);
	}

}
