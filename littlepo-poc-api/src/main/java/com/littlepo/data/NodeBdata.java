package com.littlepo.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.littlepo.utils.CommonConstants;

@JsonInclude(Include.NON_NULL)
public class NodeBdata extends NodeData{
	
	private String bQrCodeID;
	private String bBatchNo;
	private String location;
	private String packageType;
	private String producerID;
	
	public String getNodeID() {
		return CommonConstants.NODE_TYPE_B;
	}	
	public String getNodeType() {
		return CommonConstants.NODE_TYPE_B;
	}
	public String getBQrCodeID() {
		return this.bQrCodeID;
	}
	public String getBbatchNo() {
		return this.bBatchNo;
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
	
	public void setBQrCodeID(String bQrCodeID) {
		this.bQrCodeID = bQrCodeID;
	}
	public void setBbatchNo(String bBatchNo) {
		this.bBatchNo = bBatchNo;
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
