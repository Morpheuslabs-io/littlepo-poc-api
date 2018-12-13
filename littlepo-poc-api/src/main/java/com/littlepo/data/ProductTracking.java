package com.littlepo.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductTracking {
	private String qrCodeID; // QR Code ID of a finished product
	private String productBatchNo;
	private String productID;
	private String userID;
	private NodeBdata nodeBdata;
	private NodeDdata nodeDdata;
	private NodeGdata nodeGdata;
	private NodeIdata nodeIdata;
	
	
	public String getQrCodeID (String qrCodeID) {
		return this.qrCodeID;
	}
	public String getProductBatchNo() {
		return this.productBatchNo;
	}
	public String getProductID() {
		return this.productID;
	}
	public String getUserID() {
		return this.userID;
	}
	public NodeBdata getNodeBdata () {
		return this.nodeBdata;
	}
	public NodeDdata getNodeDdata () {
		return this.nodeDdata;
	}
	public NodeGdata getNodeGdata () {
		return this.nodeGdata;
	}
	public NodeIdata getNodeIdata () {
		return this.nodeIdata;
	}
	
	public void setQrCodeID (String qrCodeID) {
		this.qrCodeID = qrCodeID;
	}
	public void setProductBatchNo (String productBatchNo) {
		this.productBatchNo = productBatchNo;
	}
	public void setProductID (String productID) {
		this.productID = productID;
	}
	public void setUserID (String userID) {
		this.userID = userID;
	}
	public void setNodeBdata (NodeBdata nodeBdata) {
		this.nodeBdata = nodeBdata;
	}
	public void setNodeDdata (NodeDdata nodeDdata) {
		this.nodeDdata = nodeDdata;
	}
	public void setNodeGdata (NodeGdata nodeGdata) {
		this.nodeGdata = nodeGdata;
	}
	public void setNodeIdata (NodeIdata nodeIdata) {
		this.nodeIdata = nodeIdata;
	}

}
