package com.littlepo.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.littlepo.utils.CommonConstants;

@JsonInclude(Include.NON_NULL)
public class NodeGdata extends NodeData{
	
	private String gQRcodeID;
	private String dxQrCodeID;
	private String dQRcodeID;
	private String bBatchNo;
	private String dBatchNo;
	private String weight; // e.g. 15000 g
	private String location;
	private String packageType;
	private String producerID;
	
	public String getNodeID() {
		return CommonConstants.NODE_TYPE_G;
	}
	public String getNodeType() {
		return CommonConstants.NODE_TYPE_G;
	}
	public String getGQrCodeID() {
		return this.gQRcodeID;
	}
	public String getDQrCodeID() {
		return this.dQRcodeID;
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
	
	
	public void setDQrCodeID(String dQRcodeID) {
		this.dQRcodeID = dQRcodeID;
	}
	public void setGQrCodeID(String gQRcodeID) {
		this.gQRcodeID = gQRcodeID;
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

	
}
