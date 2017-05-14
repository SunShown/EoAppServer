package com.liu.serviceimly;

import java.util.ArrayList;
import java.util.List;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.liu.dao.ApproveColumnDao;
import com.liu.dao.ApproveInfoDao;
import com.liu.dao.ApproveRuleDao;
import com.liu.dao.ApproveTypeDao;
import com.liu.dao.ApproveimgDao;
import com.liu.dao.ApprovestateDao;
import com.liu.dao.GroupDao;
import com.liu.daoimly.ApproveColumnDaoimy;
import com.liu.daoimly.ApproveInfoDaoimly;
import com.liu.daoimly.ApproveRuleDaoimly;
import com.liu.daoimly.ApproveTypeDaoimly;
import com.liu.daoimly.ApproveimgDaoimly;
import com.liu.daoimly.ApprovestateDaoimly;
import com.liu.daoimly.GroupDaoimly;
import com.liu.service.ApproveinfoService;
import com.liu.util.JPushUtil;
import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.ApproveRule;
import com.liu.xutils.pojo.ApproveState;
import com.liu.xutils.pojo.ApproveType;
import com.liu.xutils.pojo.Approveinfo;
import com.liu.xutils.pojo.User;

public class ApproveinfoServiceimly implements ApproveinfoService {
	ApproveInfoDao infodao=new ApproveInfoDaoimly();
	ApprovestateDao stateDao=new ApprovestateDaoimly();
	ApproveRuleDao ruleDao=new ApproveRuleDaoimly();
	ApproveimgDao imgDao=new ApproveimgDaoimly();
	ApproveTypeDao typeDao=new ApproveTypeDaoimly();
	ApproveColumnDao columnDao=new ApproveColumnDaoimy();
	GroupDao groupDao=new GroupDaoimly();
	public Approveinfo getApproveinfobyid(int approveid){
		
		return infodao.getApproveinfobyid(approveid);
	}
public int ApproveSend(Approveinfo approveinfo,long companyId){
System.out.println("ApproveSend===================");
	
	int approveId=infodao.addApprove(approveinfo);
	if(approveId>0){
	List<ApproveRule> approveRules =ruleDao.getApproveRule(approveinfo.getApprovetypeId(), companyId);
		ApproveType approveType= approveinfo.getType();
	List<ApproveColumn> columns=	approveType.getColumns();


	
		ApproveRule needrule=null;
		if(approveRules!=null&&approveRules.size()>0){
		if(approveRules.size()>1){
			Integer limtcolumn=approveRules.get(0).getLimitcolumnid();
	for (ApproveColumn approveColumn: columns) {
		if(approveColumn.getId()==limtcolumn){
			for (int i = approveRules.size()-1; i>=0; i++) {
System.out.println("approveColumn.getData()=============="+approveColumn.getData());
				if(Double.parseDouble(approveColumn.getData())>=approveRules.get(i).getLimit()){
					needrule=approveRules.get(i);
					break;
				}
				break;
			}
		}}
	
	
	}else{
		needrule=approveRules.get(0);
		
	}
		}
List<ApproveState> states=new ArrayList<ApproveState>();
String[] k=null;
if(needrule!=null){
    k=needrule.getShunxulist();}else{
     
    	 k=groupDao.getAlleaderId(approveinfo.getSender().getId());
      }
        ApproveState tempstata;
        tempstata=new ApproveState(approveId, approveinfo.getSender(), approveinfo.getNewTime() ,1 ,false, true);
        states.add( tempstata);
        boolean isnew=false;
for (int i = 0; i < k.length; i++) {
	if(i==0){
		isnew=true;
	}else{
		isnew=false;
	}
	System.out.println(k[i]+"(k[i]==================");
	tempstata=new ApproveState(approveId, new User(Long.parseLong(k[i])), null, 2, isnew, false);
	states.add(tempstata);
}


    int statersnum=stateDao.insertApptates(states);
    if( statersnum==states.size()){
    	if(columnDao.addApproveData(columns,approveId)){
    		List <String> imgs=approveinfo.getImgurl();
    		if(imgDao.addImgbyappId(approveId,imgs )==imgs.size()){
    		try {
				JPushUtil.sendIShenpi(k[0],approveinfo.getSender().getUserName(),approveinfo.getType().getTyypeName() ,approveId);
			} catch (APIConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (APIRequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    			return approveId;
    		}else{
    			return 0;
    		}
        
    		
    	}else{
    		
    	}return 0;
    }else{
    	return 0;
    }
         
		
		
		
	}else{
		return 0;
	}
	
	
	
	

	
}
public List<ApproveColumn> getAppcolumns(String typeName) {
	
	return columnDao.getApproveColumnBytypeid(typeDao.getApproveTypebyname(typeName).getTyypeId());
}
	
}
