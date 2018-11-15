package com.littlepo.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductTrackingHistory {
	private String qrCodeID; // QR Code ID of a finished product
	private String productBatchNo;
	private String productID;
	private ArrayList<NodeData> listOfNodes; // list of nodes showing the product tracking data
	
	public String getQrCodeID (String qrCodeID) {
		return this.qrCodeID;
	}
	public String getProductBatchNo() {
		return this.productBatchNo;
	}
	public String getProductID() {
		return this.productID;
	}
	public ArrayList<NodeData> getListOfNodes() {
		return this.listOfNodes;
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
	public void setListOfNodes (ArrayList<NodeData> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}
	

}
