package com.littlepo.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionObject;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionResult;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import com.littlepo.config.Web3Properties;
import com.littlepo.data.blockchain.BlockInfo;
import com.littlepo.data.blockchain.BlockTxInfo;
import com.littlepo.data.blockchain.NetworkInfo;
import com.littlepo.data.blockchain.TxInfo;
import com.littlepo.utils.Web3jUtils;


@Service
public class QueryBlockchainService {
	
	private static Web3j web3j = null;

	@Autowired
	public QueryBlockchainService(Web3Properties web3Properties) {
		String ip = web3Properties.getClientIP();
		String port = web3Properties.getClientPORT();
		String clientUrl = String.format("http://%s:%s", ip, port);
		web3j = Web3j.build(new HttpService(clientUrl));
	}
	
	public BlockTxInfo queryBlockTxInfo(String txHash) throws Exception{
		BlockTxInfo blockTxInfo = new BlockTxInfo();
		TxInfo txInfo = new TxInfo();
		BlockInfo blockInfo = new BlockInfo();
		NetworkInfo networkInfo = new NetworkInfo();
		
		// get and set network info
		
		networkInfo.setNetworkID(Web3jUtils.getNetworkID(web3j));
		networkInfo.setTotalBlocks(Web3jUtils.getTotalBlocks(web3j));
		networkInfo.setTotalNodes(Web3jUtils.getPeerCount(web3j) + 1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		networkInfo.setCurrentTime(dtf.format(now));
		
		Transaction transaction = Web3jUtils.getTxByHash(web3j, txHash).getTransaction().get();
		txInfo.setBlockHash(transaction.getBlockHash());
		int blockNumber = transaction.getBlockNumber().intValue();
		txInfo.setBlockNumber(blockNumber);
		txInfo.setFromAddress(transaction.getFrom());
		txInfo.setTxHash(transaction.getHash());

		Block block = Web3jUtils.getBlockByNumber(web3j, blockNumber);
		blockInfo.setBlockHash(block.getHash());
		blockInfo.setBlockNumber(blockNumber);
		blockInfo.setParentBlockHash(block.getParentHash());
		blockInfo.setSize(block.getSize().intValue());
		blockInfo.setAuthor(block.getAuthor());
		// convert unix timestamp to GMT+8 time
		BigInteger timestamp = block.getTimestamp();
		Date time = new Date(timestamp.intValue()*1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		blockInfo.setTimestamp(formatter.format(time));
		
		// get list of transaction hashes in the block
		List<TransactionResult> transactionResults = block.getTransactions();
		List<String> transactions = new ArrayList();
		for (int i =0; i < transactionResults.size(); i++) {
			TransactionObject txObj = (TransactionObject) transactionResults.get(i);
			transactions.add(txObj.getHash());
		}
		blockInfo.setTransactions(transactions);
		
		blockTxInfo.setNetworkInfo(networkInfo);
		blockTxInfo.setBlockInfo(blockInfo);
		blockTxInfo.setTxInfo(txInfo);

		
		return blockTxInfo;
	}

}
