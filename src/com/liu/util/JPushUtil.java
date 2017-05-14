package com.liu.util;

import java.util.HashMap;
import java.util.Map;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtil {
	private static JPushClient pushClient;
	public static final String masterSecret = "7c880a01fca6faf36daed58b";
	public static final String appKey = "04cd63149d4e0a3d827b0879";

	public static JPushClient getJPushClient() {
		if (pushClient == null) {
			return new JPushClient(masterSecret, appKey);
		} else {
			return pushClient;
		}
	}
	public static void sendMessage(){
		PushResult result=null;
		try {
			result=getJPushClient().sendPush(buildPushObject_all_alias_alert());
			System.out.println(result);
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
	}
	public static PushPayload buildPushObject_all_all_alert() {
		
		return PushPayload.alertAll("alert");
	}
	
	public static PushPayload buildPushObject_all_alias_alert() {
		Map<String, String> ff=new HashMap<String ,String>();
		for (int i = 0; i < 9; i++) {
			ff.put(i+"", "张一驰"+i);
		}
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("3")).setNotification(Notification.android("吃饭了", "sb", ff))
             .setMessage(Message.newBuilder()
                        .setMsgContent("吃鸡")
                        .addExtra("from", "鸡王").addExtra("柴", "弯弯")
                        .build())
                .build();
    }
	public static void sendIShenpi(String getterId,String senderName,String type,int approveId) throws APIConnectionException, APIRequestException{
		Map<String,String> map=new HashMap<String, String>();
		map.put("approveId", approveId+"");
		map.put("isGetter", "getter");
		PushPayload p= PushPayload.newBuilder()
         .setPlatform(Platform.all())
         .setAudience(Audience.alias(getterId)).setNotification(Notification.android(senderName+"的"+type+"待您审批,点击查看详情", "易工作", map))
      
         .build();
		 getJPushClient().sendPush(p);
	}
	public static void sendShenpiI(String getterId,String type,String state,int approveId) throws APIConnectionException, APIRequestException{
		Map<String,String> map=new HashMap<String, String>();
		map.put("approveId", approveId+"");
		map.put("isGetter", "sender");
		PushPayload p= PushPayload.newBuilder()
         .setPlatform(Platform.all())
         .setAudience(Audience.alias(getterId)).setNotification(Notification.android("您发起的"+type+"已被"+state+",点击查看详情", "易工作", map))
      
         .build();
		 getJPushClient().sendPush(p);
	}
//	public static void main(String[] args) {
//		sendMessage();
//	}
}
