package com.eo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class CompanySignSettingInfoBean implements Serializable {
	private static final long serialVersionUID = 1235893901871216823L;
	private double mDoubleLatitude; // 纬度
	private double mDoubleLongitude; // 经度
	private String mStringTitle;
	private String mStringSnippet;
	private int mIntEffectiveRange; // 有效距离
	private int mIntElasticTime;
	private int mIntlateAndAbsen;
	private int mIntEarliestTime;
	private int mIntOnRemind;
	private int mIntOffRemind;
	private int mIntHardAveTime;
	private String mOnWeekString;
	private String mOffWeekString;
	private String onTimeString;
	private String offTimeString;
	private boolean autoBreakByLaw;
	private boolean isNextDayBegin; // 是否从明天开始考勤打卡，默认是false，说明是从下周开始的

	public CompanySignSettingInfoBean() {
	}

	public CompanySignSettingInfoBean(double mDoubleLatitude,
			double mDoubleLongitude, String mStringTitle,
			String mStringSnippet, int mIntEffectiveRange, int mIntElasticTime,
			int mIntlateAndAbsen, int mIntEarliestTime, int mIntOnRemind,
			int mIntOffRemind, int mIntHardAveTime, String mOnWeekString,
			String mOffWeekString, String onTimeString, String offTimeString,
			boolean autoBreakByLaw, boolean isNextDayBegin) {
		super();
		this.mDoubleLatitude = mDoubleLatitude;
		this.mDoubleLongitude = mDoubleLongitude;
		this.mStringTitle = mStringTitle;
		this.mStringSnippet = mStringSnippet;
		this.mIntEffectiveRange = mIntEffectiveRange;
		this.mIntElasticTime = mIntElasticTime;
		this.mIntlateAndAbsen = mIntlateAndAbsen;
		this.mIntEarliestTime = mIntEarliestTime;
		this.mIntOnRemind = mIntOnRemind;
		this.mIntOffRemind = mIntOffRemind;
		this.mIntHardAveTime = mIntHardAveTime;
		this.mOnWeekString = mOnWeekString;
		this.mOffWeekString = mOffWeekString;
		this.onTimeString = onTimeString;
		this.offTimeString = offTimeString;
		this.autoBreakByLaw = autoBreakByLaw;
		this.isNextDayBegin = isNextDayBegin;
	}

	public double getmDoubleLatitude() {
		return mDoubleLatitude;
	}

	public void setmDoubleLatitude(double mDoubleLatitude) {
		this.mDoubleLatitude = mDoubleLatitude;
	}

	public double getmDoubleLongitude() {
		return mDoubleLongitude;
	}

	public void setmDoubleLongitude(double mDoubleLongitude) {
		this.mDoubleLongitude = mDoubleLongitude;
	}

	public String getmStringTitle() {
		return mStringTitle;
	}

	public void setmStringTitle(String mStringTitle) {
		this.mStringTitle = mStringTitle;
	}

	public String getmStringSnippet() {
		return mStringSnippet;
	}

	public void setmStringSnippet(String mStringSnippet) {
		this.mStringSnippet = mStringSnippet;
	}

	public int getmIntEffectiveRange() {
		return mIntEffectiveRange;
	}

	public void setmIntEffectiveRange(int mIntEffectiveRange) {
		this.mIntEffectiveRange = mIntEffectiveRange;
	}

	public int getmIntElasticTime() {
		return mIntElasticTime;
	}

	public void setmIntElasticTime(int mIntElasticTime) {
		this.mIntElasticTime = mIntElasticTime;
	}

	public int getmIntlateAndAbsen() {
		return mIntlateAndAbsen;
	}

	public void setmIntlateAndAbsen(int mIntlateAndAbsen) {
		this.mIntlateAndAbsen = mIntlateAndAbsen;
	}

	public int getmIntEarliestTime() {
		return mIntEarliestTime;
	}

	public void setmIntEarliestTime(int mIntEarliestTime) {
		this.mIntEarliestTime = mIntEarliestTime;
	}

	public int getmIntOnRemind() {
		return mIntOnRemind;
	}

	public void setmIntOnRemind(int mIntOnRemind) {
		this.mIntOnRemind = mIntOnRemind;
	}

	public int getmIntOffRemind() {
		return mIntOffRemind;
	}

	public void setmIntOffRemind(int mIntOffRemind) {
		this.mIntOffRemind = mIntOffRemind;
	}

	public int getmIntHardAveTime() {
		return mIntHardAveTime;
	}

	public void setmIntHardAveTime(int mIntHardAveTime) {
		this.mIntHardAveTime = mIntHardAveTime;
	}

	public String getmOnWeekString() {
		return mOnWeekString;
	}

	public void setmOnWeekString(String mOnWeekString) {
		this.mOnWeekString = mOnWeekString;
	}

	public String getmOffWeekString() {
		return mOffWeekString;
	}

	public void setmOffWeekString(String mOffWeekString) {
		this.mOffWeekString = mOffWeekString;
	}

	public String getOnTimeString() {
		return onTimeString;
	}

	public void setOnTimeString(String onTimeString) {
		this.onTimeString = onTimeString;
	}

	public String getOffTimeString() {
		return offTimeString;
	}

	public void setOffTimeString(String offTimeString) {
		this.offTimeString = offTimeString;
	}

	public boolean isAutoBreakByLaw() {
		return autoBreakByLaw;
	}

	public void setAutoBreakByLaw(boolean autoBreakByLaw) {
		this.autoBreakByLaw = autoBreakByLaw;
	}

	public boolean isNextDayBegin() {
		return isNextDayBegin;
	}

	public void setNextDayBegin(boolean isNextDayBegin) {
		this.isNextDayBegin = isNextDayBegin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CompanySignSettingInfoBean [mDoubleLatitude=" + mDoubleLatitude
				+ ", mDoubleLongitude=" + mDoubleLongitude + ", mStringTitle="
				+ mStringTitle + ", mStringSnippet=" + mStringSnippet
				+ ", mIntEffectiveRange=" + mIntEffectiveRange
				+ ", mIntElasticTime=" + mIntElasticTime
				+ ", mIntlateAndAbsen=" + mIntlateAndAbsen
				+ ", mIntEarliestTime=" + mIntEarliestTime + ", mIntOnRemind="
				+ mIntOnRemind + ", mIntOffRemind=" + mIntOffRemind
				+ ", mIntHardAveTime=" + mIntHardAveTime + ", mOnWeekString="
				+ mOnWeekString + ", mOffWeekString=" + mOffWeekString
				+ ", onTimeString=" + onTimeString + ", offTimeString="
				+ offTimeString + ", autoBreakByLaw=" + autoBreakByLaw
				+ ", isNextDayBegin=" + isNextDayBegin + "]";
	}

}
