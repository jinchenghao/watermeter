package edu.nuaa.watermeter.pojo;

import java.sql.Blob;

public class WmStatus {
	private String readId;
	private String meterAddress;
	private String meterReading;
	private String recordTime;
	private String batteryVoltage;
	private String signalIndicator;
	private String meterImageWidth;
	private String meterImageHeight;
	private byte[] meterImage;
	private String cityCode;
	private byte[] grayImage;
	public String getReadId() {
		return readId;
	}
	public void setReadId(String readId) {
		this.readId = readId;
	}
	public String getMeterAddress() {
		return meterAddress;
	}
	public void setMeterAddress(String meterAddress) {
		this.meterAddress = meterAddress;
	}
	public String getMeterReading() {
		return meterReading;
	}
	public void setMeterReading(String meterReading) {
		this.meterReading = meterReading;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public String getBatteryVoltage() {
		return batteryVoltage;
	}
	public void setBatteryVoltage(String batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}
	public String getSignalIndicator() {
		return signalIndicator;
	}
	public void setSignalIndicator(String signalIndicator) {
		this.signalIndicator = signalIndicator;
	}
	public String getMeterImageWidth() {
		return meterImageWidth;
	}
	public void setMeterImageWidth(String meterImageWidth) {
		this.meterImageWidth = meterImageWidth;
	}
	public String getMeterImageHeight() {
		return meterImageHeight;
	}
	public void setMeterImageHeight(String meterImageHeight) {
		this.meterImageHeight = meterImageHeight;
	}
	public byte[] getMeterImage() {
		return meterImage;
	}
	public void setMeterImage(byte[] meterImage) {
		this.meterImage = meterImage;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public byte[] getGrayImage() {
		return grayImage;
	}
	public void setGrayImage(byte[] grayImage) {
		this.grayImage = grayImage;
	}
	
	
}
