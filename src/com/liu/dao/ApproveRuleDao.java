package com.liu.dao;

import java.util.List;

import com.liu.xutils.pojo.ApproveRule;

public interface ApproveRuleDao {
	public List<ApproveRule> getApproveRule(int approvetypeId,long companyId);
	public void addApproveRule(List<ApproveRule> rules);
	public boolean modifyApproveRule(ApproveRule approveRule);
	public  List<ApproveRule> GetApproveRuleBycon(long companyId);
}
