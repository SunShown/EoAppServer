package com.liu.serviceimly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.liu.dao.ApproveRuleDao;
import com.liu.dao.ApproveTypeDao;
import com.liu.daoimly.ApproveRuleDaoimly;
import com.liu.daoimly.ApproveTypeDaoimly;
import com.liu.service.Approveruleservice;
import com.liu.xutils.pojo.ApproveRule;
import com.liu.xutils.pojo.ApproveType;

public class Approveruleserviceimly implements Approveruleservice {
	ApproveTypeDao typeDao=new ApproveTypeDaoimly();
	ApproveRuleDao ruleDao=new ApproveRuleDaoimly();
	public List<ApproveType> GetApproveRuleByTypeName(long companyId) {
		 List<ApproveType> types=typeDao.getAllAppType();
		 List<ApproveType> approveTypes=new ArrayList<ApproveType>();
		 List<ApproveRule> rules=ruleDao.GetApproveRuleBycon(companyId);
		 System.out.println(rules);
		 List<ApproveRule> rsrule=new ArrayList<ApproveRule>();
		 for (ApproveType approveType : types) {
				for (ApproveRule approveRule : rules) {
					if(approveType.getTyypeId()==approveRule.getApprovetypeId()){
						rsrule.add(approveRule);
					
						
					}
				
				}
				Collections.sort(rsrule);
				approveType.setRules(rsrule);
				// System.out.println(rsrule);
				 
				 approveTypes.add(approveType);
				 rsrule=new ArrayList<ApproveRule>();
			
			}
	
	
	
		return types;
		
	}

}
