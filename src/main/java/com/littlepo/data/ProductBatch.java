package com.littlepo.data;

import java.util.List;

public class ProductBatch{
	
	
	private String productBatchNo;
	private String productID;
	private String productName;
	private String producerID;
	private String creationTime;
	private int qty;
	private List<String> listOfProductSerielNo;
	
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
	public List<String> getListOfProductSerielNo () {
		return this.listOfProductSerielNo;
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
	
	// product serial number = QR code ID
	public void setListOfProductSerielNo (List<String> listOfProductSerielNo) {
		this.listOfProductSerielNo = listOfProductSerielNo;
	}
}
