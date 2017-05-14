package com.liu.xutils.pojo;



import java.io.Serializable;
import java.util.Date;

/**
 * Created by zyc on 2016/10/17.
 */

public class AllShenPiBean implements Serializable,Comparable<AllShenPiBean>{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  int type;
    private int approveId;
    private  String approveTitle;
    private Date newDate;
    private User sender;
 
    private String state;
    private String decison;
	public AllShenPiBean() {
	}
	
	@Override
	public String toString() {
		return "AllShenPiBean [approveId=" + approveId + ", approveTitle="
				+ approveTitle + ", newDate=" + newDate + ", sender=" + sender
				+ ", state=" + state + ", type=" + type + "]";
	}





	public AllShenPiBean(int type, int approveId, String approveTitle,
			Date newDate, User sender, String state, String decison) {
		this.type = type;
		this.approveId = approveId;
		this.approveTitle = approveTitle;
		this.newDate = newDate;
		this.sender = sender;
		this.state = state;
		this.decison = decison;
	}

	public String getDecison() {
		return decison;
	}

	public void setDecison(String decison) {
		this.decison = decison;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getApproveId() {
		return approveId;
	}
	public void setApproveId(int approveId) {
		this.approveId = approveId;
	}
	public String getApproveTitle() {
		return approveTitle;
	}
	public void setApproveTitle(String approveTitle) {
		this.approveTitle = approveTitle;
	}
	public Date getNewDate() {
		return newDate;
	}
	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	public int compareTo(AllShenPiBean o) {

if(this.getNewDate().getTime()>o.getNewDate().getTime()){return -1; }
else if(this.getNewDate().getTime()<o.getNewDate().getTime()){return 1; }
else{	return 0;}
	}

	
    



}
