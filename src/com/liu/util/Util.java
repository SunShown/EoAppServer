package com.liu.util;

import io.rong.RongCloud;

public class Util {
	public static final String APP_KEY="c9kqb3rdkct2j";
	public static final String APP_SECRET="zhxWxO7zTIg";
	public static RongCloud getRongCloud(){
		return RongCloud.getInstance(APP_KEY,APP_SECRET);
	}
	public static final String HTTPPRE="http://10.40.5.51:8080/Xutils/upload/";
}
