package com.littlepo.data;

import java.util.List;

public class Product {
	private String productID;
	private String productName;
	private List<String> productBatches ;
	// private ArrayList<String> parentProducts;
	// private ArrayList<String> childrenProducts;
	
	public String getProductID() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public List<String> getProductBatches() {
		return this.productBatches;
	}

	/*
	public ArrayList<String> getParentProducts() {
		return this.parentProducts;
	}
	public ArrayList<String> getChidrenProducts() {
		return this.childrenProducts;
	}
	*/
	
	public void setProductID (String productID) {
		this.productID = productID;
	}
	public void setProductName (String productName) {
		this.productName = productName;
	}	
	public void addProductBatche (String productBatchNo) {
		this.productBatches.add(productBatchNo);
	}
	
	/*
	public void setParentProducts (ArrayList<String> parentProducts) {
		this.parentProducts = parentProducts;
	}
	public void addParentProducts (String parentProductID) {
		this.parentProducts.add(parentProductID);
	}
	public void setChidrenProducts (ArrayList<String> childrenProducts) {
		this.childrenProducts = childrenProducts;
	}
	public void addChidrenProducts (String childProductID) {
		this.childrenProducts.add(childProductID);
	}
	*/

}
