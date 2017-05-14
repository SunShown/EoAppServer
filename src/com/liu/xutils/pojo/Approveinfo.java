package com.liu.xutils.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.liu.util.ValueSearch;

public class Approveinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ValueSearch("approveId")
	private int approveId;
	@ValueSearch("approvetitle")
	private String approvetitle;
	@ValueSearch("approvetype")
	private int approvetypeId;
    @ValueSearch("approver")
	private User sender;
   @ValueSearch("newTime")
    private Timestamp newTime;
   @ValueSearch("state")
    private int state;
   @ValueSearch("ispass")
    private int decison;
   private ApproveType type;
    private User newgetter;
    private Group senderGroup;
   
    private List<String> imgurl;
    private  List<ApproveState> allstates;
	public Approveinfo() {
	}

	public int getApprovetypeId() {
		return approvetypeId;
	}


	public void setApprovetypeId(int approvetypeId) {
		this.approvetypeId = approvetypeId;
	}



	public Approveinfo(int approvetypeId, User sender, Timestamp newTime) {
		super();
		this.approvetypeId = approvetypeId;
		this.sender = sender;
		this.newTime = newTime;
	}

	public Timestamp getNewTime() {
		return newTime;
	}


	public void setNewTime(Timestamp newTime) {
		this.newTime = newTime;
	}


	public int getApproveId() {
		return approveId;
	}

	public ApproveType getType() {
		return type;
	}

	public void setType(ApproveType type) {
		this.type = type;
	}

	public void setApproveId(int approveId) {
		this.approveId = approveId;
	}

	public String getApprovetitle() {
		return approvetitle;
	}
	public void setApprovetitle(String approvetitle) {
		this.approvetitle = approvetitle;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getNewgetter() {
		return newgetter;
	}
	public void setNewgetter(User newgetter) {
		this.newgetter = newgetter;
	}



	public List<String> getImgurl() {
		return imgurl;
	}

	public void setImgurl(List<String> imgurl) {
		this.imgurl = imgurl;
	}

	


	public Group getSenderGroup() {
		return senderGroup;
	}

	public void setSenderGroup(Group senderGroup) {
		this.senderGroup = senderGroup;
	}

	public Approveinfo(int approveId, String approvetitle, int approvetypeId,
			User sender, Timestamp newTime, int state, int decison,
			ApproveType type, User newgetter, Group senderGroup,
			List<String> imgurl, List<ApproveState> allstates) {
		this.approveId = approveId;
		this.approvetitle = approvetitle;
		this.approvetypeId = approvetypeId;
		this.sender = sender;
		this.newTime = newTime;
		this.state = state;
		this.decison = decison;
		this.type = type;
		this.newgetter = newgetter;
		this.senderGroup = senderGroup;
		this.imgurl = imgurl;
		this.allstates = allstates;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDecison() {
		return decison;
	}

	public void setDecison(int decison) {
		this.decison = decison;
	}

	public List<ApproveState> getAllstates() {
		return allstates;
	}
	public void setAllstates(List<ApproveState> allstates) {
		this.allstates = allstates;
	}

	@Override
	public String toString() {
		return "Approveinfo [allstates=" + allstates + ", approveId="
				+ approveId + ", approvetitle=" + approvetitle
				+ ", approvetypeId=" + approvetypeId + ", decison=" + decison
				+ ", imgurl=" + imgurl + ", newTime=" + newTime
				+ ", newgetter=" + newgetter + ", sender=" + sender
				+ ", state=" + state + ", type=" + type + "]";
	}

    

}
