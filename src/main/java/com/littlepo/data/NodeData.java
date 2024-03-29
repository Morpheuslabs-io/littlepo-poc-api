package com.littlepo.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class NodeData {
	
	private String nodeID;
	private String nodeType;
	private String userID;
	private String legalEntity;
	private String createTime;
	private String qrCodeID;
	private String productID;
	private String productName;
	private String txHash;
	private String scAddress;

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setQrCodeID(String qrCodeID) {
		this.qrCodeID = qrCodeID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
	public void setScAddress(String scAddress) {
		this.scAddress = scAddress;
	}

	public String getNodeID() {
		return this.nodeID;
	}
	public String getNodeType() {
		return this.nodeType;
	}
	public String getUserID() {
		return this.userID;
	}
	public String getLegalEntity() {
		return this.legalEntity;
	}
	public String getCreateTime() {
		return this.createTime;
	}
	public String getQrCodeID() {
		return this.qrCodeID;
	}
	public String getProductID() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public String getTxHash() {
		return this.txHash;
	}
	public String getScAddress() {
		return this.scAddress;
	}
	
}
