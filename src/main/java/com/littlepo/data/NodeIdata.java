package com.littlepo.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.littlepo.utils.CommonConstants;

@JsonInclude(Include.NON_NULL)
public class NodeIdata extends NodeData{
	
	@JsonProperty("dxQrCodeID")
	private String dxQrCodeID;
	private String iQRcodeID;
	@JsonProperty("bBatchNo")
	private String bBatchNo;
	@JsonProperty("dBatchNo")
	private String dBatchNo;
	private String weight; // e.g. 15000 g
	private String location;
	private String packageType;
	private String producerID;
	private String qty;
	private String price;
	private String waterTemperature;
	
	public String getNodeID() {
		return CommonConstants.NODE_TYPE_I;
	}
	public String getNodeType() {
		return CommonConstants.NODE_TYPE_I;
	}
	public String getIQrCodeID() {
		return this.iQRcodeID;
	}
	public String getDxQrCodeID() {
		return this.dxQrCodeID;
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
	public String getQty() {
		return this.qty;
	}
	public String getPrice() {
		return this.price;
	}
	public String getWaterTemperature() {
		return this.waterTemperature;
	}
	
	
	public void setIQrCodeID(String iQRcodeID) {
		this.iQRcodeID = iQRcodeID;
	}
	public void setDxQrCodeID(String dxQrCodeID) {
		this.dxQrCodeID = dxQrCodeID;
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
