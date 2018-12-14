package com.littlepo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlepo.config.Web3Properties;
import com.littlepo.data.blockchain.BlockTxInfo;
import com.littlepo.service.QueryBlockchainService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")

public class QueryBlockchainAPI {
	
	@Autowired
	Web3Properties web3Properties;

    @Autowired
	QueryBlockchainService apiService;


    
    @RequestMapping(method = RequestMethod.GET, path = "/blocktx", produces = "application/json")
	@ApiOperation(value = "Query block and transaction info based on a transaction hash value.",
    notes = "This will return the transaction info and the info about the block that contains the transaxtion.")
    public BlockTxInfo queryBlockTxInfoByTxHash(String txhash) {
    	BlockTxInfo blockTxInfo = new BlockTxInfo();
    	try {
    	blockTxInfo = apiService.queryBlockTxInfo(txhash);
    	} catch(Exception e) {
    		System.out.println("Exception" + e);
    		e.printStackTrace();
    		
    	}
    	return blockTxInfo;

    }
 
}

