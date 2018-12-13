package com.littlepo.data.blockchain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TxInfo {
	
	private String txHash;
	private int blockNumber;
	private String blockHash;
	private String fromAddress;

	public TxInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
	
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public  String getTxHash() {
		return this.txHash;
	}
	
	public int getBlockNumber() {
		return this.blockNumber;
	}
	
	public  String getBlockHash() {
		return this.blockHash;
	}
	
	public  String getFromAddress() {
		return this.fromAddress;
	}
	
}
