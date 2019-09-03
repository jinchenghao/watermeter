package edu.nuaa.watermeter.pojo;

import java.io.Serializable;
import java.util.List;

public class CommunityCity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9106063579910559371L;
	private String cityCode;
	private String unitCode;
	private String comunityCode;
	private String communityName;
	private String cityName;
	private String unitName;
	private List<User> userList;
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getComunityCode() {
		return comunityCode;
	}
	public void setComunityCode(String comunityCode) {
		this.comunityCode = comunityCode;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
