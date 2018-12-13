package com.littlepo.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductBatch{
	
	
	private String productBatchNo;
	private String productID;
	private String productName;
	private String producerID;
	private String location;
	private String packageID;
	private String packageType;
	private String creationTime;
	private String legalEntity;
	private String txHash;
	private int qty;
	private List<String> listOfQrCodeIds;
	
	public String getProductBatchNo() {
		return this.productBatchNo;
	}
	public String getProductID() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public String getProducerID() {
		return this.producerID;
	}
	public String getCreationTime() {
		return this.creationTime;
	}
	public int getQty() {
		return this.qty;
	}
	public String getLocation() {
		return this.location;
	}
	public String getPackageID() {
		return this.packageID;
	}
	public String getPackageType() {
		return this.packageType;
	}
	
	public String getTxHash() {
		return this.txHash;
	}
	
	public String getLegalEntity() {
		return this.legalEntity;
	}
	public List<String> getListOfQrCodeIds () {
		return this.listOfQrCodeIds;
	}
	public void setProductBatchNo (String productBatchNo) {
		this.productBatchNo = productBatchNo;
	}
	public void setProductID (String productID) {
		this.productID = productID;
	}
	public void setProductName (String productName) {
		this.productName = productName;
	}
	public void setProducerID (String producerID) {
		this.producerID = producerID;
	}
	public void setCreationTime (String creationTime) {
		this.creationTime = creationTime;
	}
	public void setQty (int qty) {
		this.qty = qty;
	}
	public void setLocation (String location) {
		this.location = location;
	}
	public void setPackageID (String packageID) {
		this.packageID = packageID;
	}
	public void setPackageType (String packageType) {
		this.packageID = packageType;
	}

	public void setTxHash (String txHash) {
		this.txHash = txHash;
	}
	
	public void setLegalEntity (String legalEntity) {
		this.legalEntity = legalEntity;
	}
	// product serial number = QR code ID
	public void setListOfQrCodeIds (List<String> listOfQrCodeIds) {
		this.listOfQrCodeIds = listOfQrCodeIds;
	}
}
