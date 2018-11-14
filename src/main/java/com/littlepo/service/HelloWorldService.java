package com.littlepo.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionObject;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionResult;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import com.littlepo.data.blockchain.TxInfo;
import com.littlepo.utils.Web3jConstants;
import com.littlepo.web3j.helloworld.ContractDemo;
import com.littlepo.web3j.helloworld.TransferDemo;


@Service
public class HelloWorldService {
	
	private static Web3j web3j = null;

	public HelloWorldService() {
		String ip = Web3jConstants.CLIENT_IP;
		String port = Web3jConstants.CLIENT_PORT;
		String clientUrl = String.format("http://%s:%s", ip, port);
		web3j = Web3j.build(new HttpService(clientUrl));
	}
	
	public void execContract() throws Exception {
		String[] args = {};
		ContractDemo contractDemo = new ContractDemo(args);
		contractDemo.run();
	}
	
	public TxInfo callContractFunction() throws Exception {
		
		String[] args = {};
		TxInfo txInfo = new TxInfo();
		ContractDemo contractDemo = new ContractDemo(args);
		String txHash = contractDemo.callGreet();		
		txInfo.setTxHash(txHash);
		return txInfo;
	}
	
	public void execTransfer() throws Exception {
		String[] args = {};
		TransferDemo transferDemo = new TransferDemo(args);
		transferDemo.run();
	}


}
