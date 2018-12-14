package com.littlepo.web3j;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.littlepo.utils.Web3jConstants;


public class AbstractContractManager {
	
	protected static Web3j web3j = null;
	static String clientUrl = null;
	
	public AbstractContractManager(String [] args) {
		clientUrl = argsToUrl(args);
		web3j = Web3j.build(new HttpService(clientUrl));
	}
	
	public AbstractContractManager() {
		String ip = Web3jConstants.CLIENT_IP;
		String port = Web3jConstants.CLIENT_PORT;
		clientUrl =  String.format("http://%s:%s", ip, port);
		web3j = Web3j.build(new HttpService(clientUrl));
	}
	
	public String argsToUrl(String [] args) {
		String ip = Web3jConstants.CLIENT_IP;
		String port = Web3jConstants.CLIENT_PORT;

		if(args.length >= 1) { ip = args[0]; }
		if(args.length >= 2) { port = args[1]; }
		
		return String.format("http://%s:%s", ip, port);
	}
	
	
	public void run() throws Exception {

		// show client details
		Web3ClientVersion client = web3j
				.web3ClientVersion()
				.sendAsync()
				.get();
		
		System.out.println("Connected to " + client.getWeb3ClientVersion() + "\n");
	};
	
	public String getClientVersion() throws Exception {

		// show client details
		
		String clientVersionInfo = "";
		Web3ClientVersion client = web3j
				.web3ClientVersion()
				.sendAsync()
				.get();
		
		clientVersionInfo =  client.getWeb3ClientVersion();
		return clientVersionInfo;
	};
}
