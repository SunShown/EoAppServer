package com.liu.serviceimly;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;

import com.eo.dao.ISignSettingInfoDao;
import com.eo.dao.impl.SignSettingInfoDaoImpl;
import com.liu.dao.ApproveDao;
import com.liu.dao.ApproveInfoDao;
import com.liu.dao.ApprovestateDao;
import com.liu.dao.UserDao;
import com.liu.daoimly.ApproveDaoimly;
import com.liu.daoimly.ApproveInfoDaoimly;
import com.liu.daoimly.ApprovestateDaoimly;
import com.liu.daoimly.UserDaoimly;
import com.liu.db.DBImp;
import com.liu.service.ApproveService;
import com.liu.util.DateUtil;
import com.liu.util.JPushUtil;
import com.liu.xutils.pojo.AllShenPiBean;
import com.liu.xutils.pojo.ApproveColumn;
import com.liu.xutils.pojo.ApproveState;
import com.liu.xutils.pojo.Approveinfo;
import com.liu.xutils.pojo.User;

public class ApproveServiceimly implements ApproveService {
	ApproveDao dao=new ApproveDaoimly();
	UserDao userDao=new UserDaoimly();
	ApproveInfoDao infoDao=new ApproveInfoDaoimly();
    ApprovestateDao dao2=new ApprovestateDaoimly();
    ISignSettingInfoDao settingDao=new SignSettingInfoDaoImpl();
    
	public List<AllShenPiBean> GetAllShenPiHave(int userid, String searchinfo,int size,int page) {
		// TODO Auto-generated method stub
		return dao.GetAllShenPipreview(dao2.getAllIHaveShenpiID(userid), searchinfo,size,page);
	}

	public List<AllShenPiBean> GetAllShenPiNew(int userid, String searchinfo,int size,int page) {
		// TODO Auto-generated method stub
		return dao.GetAllShenPipreview(dao2.getAllIShenpiID(userid), searchinfo,size,page);
	}

	public List<AllShenPiBean> GetAllShenPii(int userid, String searchinfo,int size,int page) {
		// TODO Auto-generated method stub
		return dao.GetAllShenPiipreview(userid,searchinfo,size,page);}
	
	
	
	
	
	
	/**
	 * 
	
 * @param state
	 * @return 116用户没权限
	 *          115未知错误
	 *          112审批已被撤销无法操作
	 *         113审批已被通过无法操作
 *         114审批已被拒绝无法操作
 *         110数据库操作错误
 *         111操作成功
	 * 
	 *  

	 */
	public int AppAgree(ApproveState state) {
		Approveinfo info = infoDao.getApproveinfobyid(state.getApproveId());
		modifyTime(info);
		                  List<ApproveState> allstates= info.getAllstates();
		                  boolean flag=false;
		                  ApproveState now=null;
		                  ApproveState next=null;
		                  
		                  for (ApproveState approveState : allstates) {
							if(approveState.getGetter().getId()==state.getGetter().getId()&&approveState.isIsnew()){
								now=approveState;
								flag=true;
								for (ApproveState approveState1 : allstates) {
									if(approveState1.getParentstateId()==approveState.getApprovestateId()){
										next=approveState1;
										
									}
								}
							}
							
							
						}
		if(!flag){
			return 116;
		}else{
			switch (info.getState()) {
			case 0:
				now.setDecision(1);
				now.setIsnew(false);
				now.setComment(state.getComment());
				now.setDecisiontime(state.getDecisiontime());
				now.setImgurl(state.getImgurl());
				boolean a= dao2.modifyApptate(now);
				//System.out.println("a======="+a);
			if(a){
				if(next!=null){
				
				next.setIsnew(true);
				boolean b=dao2.modifyApptate(next);
			//	System.out.println("b======="+b);
				if(a&&b){if(modifyTime(info)){
					try {
						JPushUtil.sendIShenpi(next.getGetter().getId()+"",info.getSender().getUserName(), info.getType().getTyypeName(),info.getApproveId());
					} catch (APIConnectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (APIRequestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 111;}else {
						return 110;
					}
					
				}else{
					return 110;
				}
				
			}else {
			info.setDecison(1);
			info.setState(1);
			info.setDecison(1);
		boolean c=	infoDao.modifyApproveinfo(info);
	//	System.out.println("c======="+c);
		if(c){if(modifyTime(info)){
			try {
				JPushUtil.sendShenpiI(info.getSender().getUserId()+"", info.getType().getTyypeName(), "同意", info.getApproveId());
			} catch (APIConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (APIRequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	return 111;}else {
				return 110;
			}
		
		}else{
			return 110;
		}
			}}else {
				return 110;
			}
			
				
			
	case 1:
				
				
		   switch (info.getDecison()) {
			case 1:
				
				return 113;

			case 2:
			return 114;
			
			}
	case 2:
		
		
		return 112;

			default:
				return 115;
			}
			
	            

		
			
			
			
		}
		
		
		
		
		
		
	
	
	}

	/**
	 * 
	 * @param state
	 * @return *   Return 100:数据库修改错误
 *    Return:101成功
 *       Return:102已被撤销
 *         Return:103审批已被通过无法撤销
 *         Return:104审批已被拒绝无法撤销
 *         Return:105未知错误
 *          Return:106不是本人没权限

	 */
	
	public int AppCancel(ApproveState s) {
		long userId=s.getGetter().getId();
		int approveId=s.getApproveId();
		Timestamp decisiontime=s.getDecisiontime();
		Approveinfo info = infoDao.getApproveinfobyid(approveId);
		if(userId!=info.getSender().getId()){
        	return 106;
        }
		ApproveState state=new ApproveState();
               state.setGetter(userDao.getUserById(userId));
               state.setApproveId(approveId);
               state.setDecisiontime(decisiontime);
               state.setIsself(true);
               state.setIsnew(true);
             state.setDecision(0);
        
           
           
             ApproveState now=null;
          
            
            
            List<ApproveState> allstates=info.getAllstates();
          
            
            switch (info.getState()) {
			case 0:
				   System.out.println("======================info.getState())");
			for (ApproveState approveState : allstates) {
				
				if(approveState.isIsnew()){
				now=approveState;}
				
			}
			state.setParentstateId(now.getParentstateId());
			int newid= dao2.insertApptate(state);
			if(newid>0){
			now.setParentstateId(newid);
			now.setIsnew(false);
			now.setImgurl(null);
			boolean i=dao2.modifyApptate(now);
			if(i){
				info.setNewTime(decisiontime);
				info.setState(2);
				boolean a=infoDao.modifyApproveinfo(info);
				
				if(a){
					return 101;
				}else{
					return 100;
				}
				
				
			}else {
				return 100;
			}
			}else{
				return 100;
			}
				
				

			case 1:
			   switch (info.getDecison()) {
			case 1:
				
				return 103;

			case 2:
			return 104;
			
			}
			case 2:
				return 102;
			default:
				return 105;
			}

          
            	
           

  
            	
			
             //state.setParentstateId(parentstateId)
             
             
              
                
               
		
		
		
	
	}

	/**
	 * 
	 * @param state
	 * @return *   Return 100:数据库修改错误
 *    Return:121成功
 *       Return:122已被撤销
 *         Return:123审批已被通过无法撤销
 *         Return:124审批已被拒绝无法撤销
 *         Return:125未知错误
 *          Return:126不是本人没权限

	 */
		public int AppRefused(ApproveState state) {
			Approveinfo info = infoDao.getApproveinfobyid(state.getApproveId());
	        List<ApproveState> allstates= info.getAllstates();
	        boolean flag=false;
	        ApproveState now=null;

	        for (ApproveState approveState : allstates) {
				if(approveState.getGetter().getId()==state.getGetter().getId()&&approveState.isIsnew()){
					now=approveState;
					flag=true;
				
				}
				
				
			}
	if(!flag){
	return 126;
	}else{
	switch (info.getState()) {
	case 0:
	now.setDecision(0);

	now.setComment(state.getComment());
	now.setDecisiontime(state.getDecisiontime());
	now.setImgurl(state.getImgurl());
	boolean a= dao2.modifyApptate(now);
	if(a){
	info.setDecison(0);
	info.setState(1);
	info.setDecison(2);
	boolean c=	infoDao.modifyApproveinfo(info);
	if(c){
		try {
			JPushUtil.sendShenpiI(info.getSender().getUserId()+"", info.getType().getTyypeName(), "撤销", info.getApproveId());
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 121;
	}else{
	return 120;
	}}else{
		return 120;
	}
	
	
	
	case 1:
	
	
	switch (info.getDecison()) {
	case 1:
	
	return 123;
	
	case 2:
	return 124;
	
	}
	case 2:
	
	
	return 122;
	
	default:
	return 125;
	}
	
	
	
	
	
	
	
	}
	
	
		
	
			
			
			
			
		
	
		
	
	}


//public static void main(String[] args) {
//	//System.out.println("======cancelapp======"+new ApproveServiceimly().AppCancel(3, 1, new Timestamp(new Date().getTime())));
//	List<String> img=new ArrayList<String>();
//	for (int i = 2; i <7; i++) {
//		img.add("http://10.40.5.54:8080/EO/bg"+i+".jpg");
//	
//	}
//	
//
//	//System.out.println("========aggapp===="+new ApproveServiceimly().AppAgree(new ApproveState(1,new User(7), new Timestamp(new Date().getTime()), "fuckyou1",img) ));
//	System.out.println("========aggapp===="+new ApproveServiceimly().AppRefused(new ApproveState(1,new User(10), new Timestamp(new Date().getTime()), "fuckyou1",img) ));
//}

		public boolean modifyTime(Approveinfo info){
			
	int typeId=	info.getType().getTyypeId();
	System.out.println("typeId"+typeId);
	String beginstr="";
	String endstr="";
			if(typeId==1||typeId==2){
				System.out.println("typeId"+typeId);
				List< ApproveColumn> columns=info.getType().getColumns();
				for (ApproveColumn approveColumn : columns) {
					if("start_time_tv".equals(approveColumn.getViewId())){
						beginstr=approveColumn.getData();
					}else if("end_time_tv".equals(approveColumn.getViewId())){
						endstr=approveColumn.getData();
					}
				}
				
			
				if(beginstr!=null&&(!"".equals(beginstr.trim()))&&endstr!=null&&(!"".equals( endstr.trim()))){
				Date beginTime=	DateUtil.stringToDate(beginstr);
				Date endTime=		DateUtil.stringToDate(endstr);
				List<String> dates=new ArrayList<String>();
				long s= beginTime.getTime();
				long e=endTime.getTime();
				 long oneDay = 1000 * 60 * 60 * 24l;  
				while(s<=e){
					 beginTime.setTime(s);
					 dates.add(DateUtil.dateToString(beginTime));
						System.out.println(DateUtil.dateToString(beginTime));
					s+=oneDay;
					
					
					
				}
			
				
			long conId=	DBImp.getInstance().getCompanyByUser(info.getSender().getUserId()).getTcId();
					long  userId=info.getSender().getId();
					switch (typeId) {
					case 1:
						for (String string : dates) {
							System.out.println("dates"+string);
						}
						settingDao.insertAskforLeave(userId,conId, dates);
						return true;
					

                    case 2:
                    	for (String string : dates) {
							System.out.println("dates"+string);
						}
                    	settingDao.insertOnBusinessTrip(userId,conId, dates);
                    	return true;
                    	default:
                    		return false;
					}
				
				}else{
					return false;
				}
				
				
			}else{
			return true;}
		
		}
//		public static void main(String[] args) {
//			List<String> dates=new ArrayList<String>();
//			Date k=new Date();
//			System.out.println(DateUtil.dateToString(k));
//			Date beginTime=	DateUtil.stringToDate("2016-12-25");
//			Date endTime=		DateUtil.stringToDate("2017-01-08");
//		
//			long s= beginTime.getTime();
//			
//			long e=endTime.getTime();
//			 long oneDay = 1000 * 60 * 60 * 24l;  
//			while(s<=e){
//				 beginTime.setTime(s);
//				 System.out.println( beginTime);
//				 dates.add(DateUtil.dateToString(beginTime));
//				s+=oneDay;
//				
//				
//				
//			}
//			System.out.println(dates.size());
//			for (String date : dates) {
//				System.out.println(date);
//			}
//		}

}
