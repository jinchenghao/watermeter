package edu.nuaa.watermeter.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1145820234580457637L;
	private String comunityCode;
	private String unitCode;
	private String roomCode;
	private String userCode;
	private String userName;
	private String userPhone;
	private String simccid;
	private String cityCode;
	private List<Record> recordList;
	public String getComunityCode() {
		return comunityCode;
	}
	public void setComunityCode(String comunityCode) {
		this.comunityCode = comunityCode;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getSimccid() {
		return simccid;
	}
	public void setSimccid(String simccid) {
		this.simccid = simccid;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public List<Record> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<Record> recordList) {
		this.recordList = recordList;
	}
	
	
	
}
