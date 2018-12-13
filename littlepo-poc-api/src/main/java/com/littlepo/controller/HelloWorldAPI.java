package com.littlepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.littlepo.data.blockchain.TxInfo;
import com.littlepo.service.HelloWorldService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/hello/")

public class HelloWorldAPI {
	

    @Autowired
	HelloWorldService apiService;

    @RequestMapping(method = RequestMethod.POST, path = "/contract", produces = "application/json")
	@ApiOperation(value = "Execute the smart contract demo Hello World.",
    notes = "This will execute ContractDemo.")
    public void execContract() {
    	try {
    	apiService.execContract();
    	} catch(Exception e) {
    		System.out.println("Exception" + e);
    		e.printStackTrace();
    		
    	}

    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/greet", produces = "application/json")
	@ApiOperation(value = "Execute the smart contract demo (Hello World) function Greet.",
    notes = "This will execute ContractDemo function greet().")
    public TxInfo callContractFunction() {
    	TxInfo txInfo = new TxInfo();
    	try {
    	txInfo = apiService.callContractFunction();
    	} catch(Exception e) {
    		System.out.println("Exception" + e);
    		e.printStackTrace();
    		
    	}
    	return txInfo;

    }

    @RequestMapping(method = RequestMethod.POST, path = "/transfer", produces = "application/json")
	@ApiOperation(value = "Execute the transfer contract demo.",
    notes = "This will execute TransferDemo.")
    public void execTransfer() {
    	try {
    	apiService.execTransfer();
    	} catch(Exception e) {
    		System.out.println("Exception" + e);
    		e.printStackTrace();
    		
    	}

    }

 
}

