package com.littlepo.data.blockchain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BlockInfo {
	
	private int blockNumber;
	private String blockHash;
	private String parentBlockHash;
	private String timestamp;
	private int transactionCount;
	private int size;
	private String author;
	private List<String> transactions;
	

	public BlockInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	
	public void setParentBlockHash(String parentBlockHash) {
		this.parentBlockHash = parentBlockHash;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
		
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}
	
	public String getBlockHash() {
		return blockHash;
	}
	
	public String getParentBlockHash() {
		return parentBlockHash;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public List<String> getTransactions() {
		return transactions;
		
	}

}
