package com.liu.service;


import java.util.List;

import com.liu.xutils.pojo.ApproveType;

public interface Approveruleservice {
public   List<ApproveType>   GetApproveRuleByTypeName(long companyId);
}
