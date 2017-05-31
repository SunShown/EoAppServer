package com.liu.util;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;

public class Util {
	public static final String APP_KEY="c9kqb3rdkct2j";
	public static final String APP_SECRET="zhxWxO7zTIg";
	public static RongCloud getRongCloud(){
		return RongCloud.getInstance(APP_KEY,APP_SECRET);
	}
	public static final String HTTPPRE="http://10.40.5.51:8080/Xutils/upload/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				RongCloud cloud=Util.getRongCloud();
				try {
					TokenReslut userGetTokenResult=cloud.user.getToken("18151587323","王五",HTTPPRE+"emotion_003.png");
					System.out.println(userGetTokenResult.getToken());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
