package com.liu.xutils.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.liu.util.ValueSearch;

public class ApproveState implements Serializable {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@ValueSearch("approvestateId")
private int approvestateId	;

@ValueSearch("approveId")
private int approveId;

public int getApproveId() {
	return approveId;
}









public void setApproveId(int approveId) {
	this.approveId = approveId;
}









@ValueSearch("applicantId")
private  User getter;
@ValueSearch("decisiontime")
private Timestamp decisiontime;
@ValueSearch("comment")
private String comment;
@ValueSearch("parentstateId")
private int parentstateId;
@ValueSearch("decision")
private int decision;
@ValueSearch("isnew")
private boolean isnew;
@ValueSearch("isself")
private boolean isself;
private List<String> imgurl;


public ApproveState() {
}



















public ApproveState(int approveId, User getter, Timestamp decisiontime,
		int decision, boolean isnew, boolean isself) {
	super();
	this.approveId = approveId;
	this.getter = getter;
	this.decisiontime = decisiontime;
	this.decision = decision;
	this.isnew = isnew;
	this.isself = isself;
}









public ApproveState(int approveId, User getter, Timestamp decisiontime,
		String comment, List<String> imgurl) {
	this.approveId = approveId;
	this.getter = getter;
	this.decisiontime = decisiontime;
	this.comment = comment;
	this.imgurl = imgurl;
}









public int getApprovestateId() {
	return approvestateId;
}



public void setApprovestateId(int approvestateId) {
	this.approvestateId = approvestateId;
}





public boolean isIsself() {
	return isself;
}









public ApproveState(int approvestateId, User getter, Timestamp decisiontime,
		String comment, int parentstateId, int decision, boolean isnew,
		boolean isself, List<String> imgurl) {
	this.approvestateId = approvestateId;
	this.getter = getter;
	this.decisiontime = decisiontime;
	this.comment = comment;
	this.parentstateId = parentstateId;
	this.decision = decision;
	this.isnew = isnew;
	this.isself = isself;
	this.imgurl = imgurl;
}









public void setIsself(boolean isself) {
	this.isself = isself;
}









public User getGetter() {
	return getter;
}

public void setGetter(User getter) {
	this.getter = getter;
}

public Timestamp getDecisiontime() {
	return decisiontime;
}

public void setDecisiontime(Timestamp decisiontime) {
	this.decisiontime = decisiontime;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public int getParentstateId() {
	return parentstateId;
}

public void setParentstateId(int parentstateId) {
	this.parentstateId = parentstateId;
}

public int getDecision() {
	return decision;
}

public void setDecision(int decision) {
	this.decision = decision;
}

public boolean isIsnew() {
	return isnew;
}

public void setIsnew(boolean isnew) {
	this.isnew = isnew;
}

public List<String> getImgurl() {
	return imgurl;
}

public void setImgurl(List<String> imgurl) {
	this.imgurl = imgurl;
}









@Override
public String toString() {
	return "ApproveState [approvestateId=" + approvestateId + ", comment="
			+ comment + ", decision=" + decision + ", decisiontime="
			+ decisiontime + ", getter=" + getter + ", imgurl=" + imgurl
			+ ", isnew=" + isnew + ", isself=" + isself + ", parentstateId="
			+ parentstateId + "]";
}









//public static void main(String[] args) {
//	System.out.println(User.class.getName());
//}
}
