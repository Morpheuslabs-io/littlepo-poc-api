package com.littlepo.utils;

import org.web3j.crypto.Credentials;

public class Orchard {
	
	// this is used for APIs to connect to the local POA blockchain network
	
	// private static final String PRIVATE_KEY = "0x7673b0ae99fed748dcb4648502dc032de69f529ca66d3891c29adcad9afcb4a8";
	
	// this account is used to to access local Ganache
	private static final String PRIVATE_KEY = "0xeaafe8a2221a1d023fe55fd9df3f6784ae91746863e279b9f7a286722cbc6d22";
	
	public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
	
	// this is used for APIs to connect to the demo blockchain network on ML BPaaS
	
	// private static final String PRIVATE_KEY = "0xd06edd0ba4f3092fc0e0ce764d1698b82eb644d785c9783602ece4db01cb13df";
	// public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
	
	
	public static final String ADDRESS = CREDENTIALS.getAddress();
	
}
