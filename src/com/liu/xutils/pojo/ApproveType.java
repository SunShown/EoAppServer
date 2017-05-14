package com.liu.xutils.pojo;

import java.io.Serializable;
import java.util.List;

import com.liu.util.ValueSearch;

public class ApproveType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ValueSearch("id")
	private int tyypeId;
	@ValueSearch("approvetype_str")
	private String tyypeName;
	List<ApproveColumn> columns;
	private List<ApproveRule> rules;
	public List<ApproveRule> getRules() {
		return rules;
	}



	public void setRules(List<ApproveRule> rules) {
		this.rules = rules;
	}



	public ApproveType() {
	}
	


	public int getTyypeId() {
		return tyypeId;
	}
	public void setTyypeId(int tyypeId) {
		this.tyypeId = tyypeId;
	}

	public List<ApproveColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<ApproveColumn> columns) {
		this.columns = columns;
	}



	public String getTyypeName() {
		return tyypeName;
	}



	public void setTyypeName(String tyypeName) {
		this.tyypeName = tyypeName;
	}



	public ApproveType(int tyypeId, String tyypeName,
			List<ApproveColumn> columns) {
		this.tyypeId = tyypeId;
		this.tyypeName = tyypeName;
		this.columns = columns;
	}



	@Override
	public String toString() {
		return "ApproveType [tyypeId=" + tyypeId + ", tyypeName=" + tyypeName
				+ ", columns=" + columns + ", rules=" + rules + "]";
	}



	

	

	
	
	
}
