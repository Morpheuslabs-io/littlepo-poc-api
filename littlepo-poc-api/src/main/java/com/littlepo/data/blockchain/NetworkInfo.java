package com.littlepo.data.blockchain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class NetworkInfo {
	
	private String networkID;
	private int totalNodes;
	private int totalBlocks;
	private String currentTime;

	public NetworkInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNetworkID(String networkID) {
		this.networkID = networkID;
	}
	
	public void setTotalNodes(int totalNodes) {
		this.totalNodes = totalNodes;
	}
	
	public void setTotalBlocks(int totalBlocks) {
		this.totalBlocks = totalBlocks;
	}
	
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getNetworkID() {
		return this.networkID;
	}
	
	public int getTotalNodes() {
		return this.totalNodes;
	}
	
	public int getTotalBlocks() {
		return this.totalBlocks;
	}
	
	public String getCurrentTime() {
		return this.currentTime;
	}
	
}
