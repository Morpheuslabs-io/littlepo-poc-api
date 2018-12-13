package com.littlepo.data.blockchain;

import java.sql.Timestamp;

public class TxHashResponse {
	private String txHash;
	private String contractAddress;
	private Timestamp submittedTime;
	
	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
	
	public String getTxHash() {
		return this.txHash;
	}
	
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	
	public String getContractAddress( ) {
		return this.contractAddress;
	}
	
	public void setSubmiitedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
		
	}
	
	public Timestamp getSubmittedTime () {
		return this.submittedTime;
	}
	
}
