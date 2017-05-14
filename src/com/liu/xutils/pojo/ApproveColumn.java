package com.liu.xutils.pojo;

import java.io.Serializable;

import com.liu.util.ValueSearch;

public class ApproveColumn implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@ValueSearch("id")
	private int id;
   @ValueSearch("approvetypeid")
	private int approvetypeid;
   @ValueSearch("approvecolumncnname")
	private String approvecolumncnname;

   @ValueSearch("shijicolumn")
	private String shijicolumn;
  private String data;
  @ValueSearch("viewId")
  private String viewId;
  

public String getViewId() {
	return viewId;
}

public void setViewId(String viewId) {
	this.viewId = viewId;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public ApproveColumn() {
}

public ApproveColumn(int id, int approvetypeid, String approvecolumncnname,
		String shijicolumn) {
	this.id = id;
	this.approvetypeid = approvetypeid;
	this.approvecolumncnname = approvecolumncnname;
	this.shijicolumn = shijicolumn;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getApprovetypeid() {
	return approvetypeid;
}

public void setApprovetypeid(int approvetypeid) {
	this.approvetypeid = approvetypeid;
}

public String getApprovecolumncnname() {
	return approvecolumncnname;
}

public void setApprovecolumncnname(String approvecolumncnname) {
	this.approvecolumncnname = approvecolumncnname;
}

public String getShijicolumn() {
	return shijicolumn;
}

public void setShijicolumn(String shijicolumn) {
	this.shijicolumn = shijicolumn;
}

@Override
public String toString() {
	return "ApproveColumn [approvecolumncnname=" + approvecolumncnname
			+ ", approvetypeid=" + approvetypeid + ", data=" + data + ", id="
			+ id + ", shijicolumn=" + shijicolumn + "]";
}


   
  

}
