package com.littlepo.data;

import java.util.List;

import com.littlepo.utils.CommonConstants;

public class NodeIdata extends NodeData{
	
	private List<String> dxQrCodeIDs;
	private String dQRcodeID;
	private String bBatchNo;
	private String dBatchNo;
	private String weight; // e.g. 15000 g
	private String location;
	private String packageType;
	private String producerID;
	private String legalEntity1;
	private String qty;
	private String price;
	private String waterTemperature;
	
	
	public String getNodeType() {
		return CommonConstants.NODE_TYPE_G;
	}
	public String getDQrCodeID() {
		return this.dQRcodeID;
	}
	public List<String> getDxQrCodeIDs() {
		return this.dxQrCodeIDs;
	}
	public String getBbatchNo() {
		return this.bBatchNo;
	}
	public String getDbatchNo() {
		return this.dBatchNo;
	}
	public String getWeight() {
		return this.weight;
	}
	public String getLocation() {
		return this.location;
	}
	public String getPackageType() {
		return this.packageType;
	}
	public String getProducerID() {
		return this.producerID;
	}
	public String getLegalEntity1() {
		return this.legalEntity1;
	}
	public String getQty() {
		return this.qty;
	}
	public String getPrice() {
		return this.price;
	}
	public String getWaterTemperature() {
		return this.waterTemperature;
	}
	
	
	public void setDQrCodeID(String dQRcodeID) {
		this.dQRcodeID = dQRcodeID;
	}
	public void setDxQrCodeIDs(List<String> dxQrCodeIDs) {
		this.dxQrCodeIDs = dxQrCodeIDs;
	}
	public void setBbatchNo(String bBatchNo) {
		this.bBatchNo = bBatchNo;
	}
	public void setDbatchNo(String dBatchNo) {
		this.dBatchNo = dBatchNo;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}	
	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}	
	public void setLegalEntity1(String  legalEntity1) {
		this.legalEntity1 = legalEntity1;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setWaterTemperature(String waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
}
