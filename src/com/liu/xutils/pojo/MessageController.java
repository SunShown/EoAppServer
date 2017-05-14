package com.liu.xutils.pojo;

import java.util.Date;
import java.util.Random;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
public class MessageController {
	public String sendMessage(String telnum)throws ApiException{
		String url="http://gw.api.taobao.com/router/rest";
		String appkey="23779943";//这是阿里的APPkey
		String secret="dadd27108a9424d78f54536a681e7001";//这是密钥
		String code="";//随机生成验证码
		Random random=new Random(new Date().getTime());
		for(int i=0;i<4;i++){
			code=code+random.nextInt(10);
		}
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType( "normal" );//短信类型必填
		req.setSmsFreeSignName( "刘菲炫" );//这是注册项目的数字签名
		req.setSmsParamString( "{name:'"+code+"'}" );
		req.setRecNum( telnum );//手机号
		req.setSmsTemplateCode( "SMS_63920436" );//短信模板号必填
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return code;
	}
	
}
