package com.eo.entity;



import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/1.
 */

public class SignInfoBean implements Serializable {
    private Double latitudeDouble;
    private Double longitudeDouble;
    private long companyIdLong;
    private int signStatusIdInt;  //签到状态，转换成int类型
    private String addressString;
    private String remarkString;
    private double distanceDouble;
    private String dateString;   //日期暂为String类型，服务器端收到数据，服务器端进行处理
    private String timeString;   //时间暂为String类型，服务器端收到数据，服务器端进行处理

    public SignInfoBean() {
    }

    public SignInfoBean(Double latitudeDouble, Double longitudeDouble, long companyIdLong, int signStatusIdInt,
                    String addressString, String remarkString, double distanceDouble, String dateString,
                    String timeString) {
        this.latitudeDouble = latitudeDouble;
        this.longitudeDouble = longitudeDouble;
        this.companyIdLong = companyIdLong;
        this.signStatusIdInt = signStatusIdInt;
        this.addressString = addressString;
        this.remarkString = remarkString;
        this.distanceDouble = distanceDouble;
        this.dateString = dateString;
        this.timeString = timeString;
    }

    public Double getLatitudeDouble() {
        return latitudeDouble;
    }

    public void setLatitudeDouble(Double latitudeDouble) {
        this.latitudeDouble = latitudeDouble;
    }

    public Double getLongitudeDouble() {
        return longitudeDouble;
    }

    public void setLongitudeDouble(Double longitudeDouble) {
        this.longitudeDouble = longitudeDouble;
    }

    public long getCompanyIdLong() {
        return companyIdLong;
    }

    public void setCompanyIdLong(long companyIdLong) {
        this.companyIdLong = companyIdLong;
    }

    public int getSignStatusIdInt() {
        return signStatusIdInt;
    }

    public void setSignStatusIdInt(int signStatusIdInt) {
        this.signStatusIdInt = signStatusIdInt;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getRemarkString() {
        return remarkString;
    }

    public void setRemarkString(String remarkString) {
        this.remarkString = remarkString;
    }

    public double getDistanceDouble() {
        return distanceDouble;
    }

    public void setDistanceDouble(double distanceDouble) {
        this.distanceDouble = distanceDouble;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

	@Override
	public String toString() {
		return "SignInfoBean [latitudeDouble=" + latitudeDouble
				+ ", longitudeDouble=" + longitudeDouble + ", companyIdLong="
				+ companyIdLong + ", signStatusIdInt=" + signStatusIdInt
				+ ", addressString=" + addressString + ", remarkString="
				+ remarkString + ", distanceDouble=" + distanceDouble
				+ ", dateString=" + dateString + ", timeString=" + timeString
				+ "]";
	}
    
    
    
}

