package com.littlepo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("web3")
public class Web3Properties {

	private String clientIP = ""; // Property web3.clientIP
	private String clientPORT = "";	 // Property web3.clientPORT
	private String addressProductHarvesterNode = ""; 
	private String addressProductPackerNode = "";
	private String addressLittlepoNode = "";
	private String addressRetailShopNode = "";

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	
	public String getClientIP() {
		return clientIP;
	}

	public void setClientPORT(String clientPORT) {
		this.clientPORT = clientPORT;
	}
	
	public String getClientPORT() {
		return clientPORT;
	}

	public void setAddressProductHarvesterNode(String addressProductHarvesterNode) {
		this.addressProductHarvesterNode = addressProductHarvesterNode;
	}
	
	public String getAddressProductHarvesterNode() {
		return this.addressProductHarvesterNode;
	}
	
	public void setAddressProductPackerNode(String addressProductPackerNode) {
		this.addressProductPackerNode = addressProductPackerNode;
	}
	
	public String getAddressProductPackerNode() {
		return this.addressProductPackerNode;
	}
	
	public void setAddressLittlepoNode(String addressLittlepoNode) {
		this.addressLittlepoNode = addressLittlepoNode;
	}
	
	public String getAddressLittlepoNode() {
		return this.addressLittlepoNode;
	}
	
	public void setAddressRetailShopNode(String addressRetailShopNode) {
		this.addressRetailShopNode = addressRetailShopNode;
	}
	
	public String getAddressRetailShopNode() {
		return this.addressRetailShopNode;
	}
	
}
