package com.littlepo.data.blockchain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BlockTxInfo {
	
	private NetworkInfo networkInfo;
	private BlockInfo blockInfo;
	private TxInfo txInfo;

	
	public void setNetworkInfo(NetworkInfo networkInfo) {
		this.networkInfo = networkInfo;
	}
	
	public BlockTxInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setBlockInfo (BlockInfo blockInfo) {
		this.blockInfo = blockInfo;
	}
	
	public void setTxInfo (TxInfo txInfo) {
		this.txInfo = txInfo;
	}
	
	public NetworkInfo getNetworkInfo() {
		return this.networkInfo;
	}
	
	public BlockInfo getBlockInfo() {
		return this.blockInfo;
	}
	
	public TxInfo getTxInfo() {
		return this.txInfo;
	}

}
