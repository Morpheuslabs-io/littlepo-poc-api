package com.littlepo.utils;

import org.web3j.crypto.Credentials;

public class Orchard {
	
	// this is used for APIs to connect to the local POA blockchain network
	
	// private static final String PRIVATE_KEY = "0x3464c86b458388318e6c8e97e97a4b56908f3e171583516f74717555c4dcf05b";
	
	// this account is used to to access local Ganache
   private static final String PRIVATE_KEY = "3464c86b458388318e6c8e97e97a4b56908f3e171583516f74717555c4dcf05b";
	
	// this account is used to to access local Truffle
	// private static final String PRIVATE_KEY = "0xc87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3";
	
	public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
	
	// this is used for APIs to connect to the demo blockchain network on ML BPaaS
	
	// private static final String PRIVATE_KEY = "0xd06edd0ba4f3092fc0e0ce764d1698b82eb644d785c9783602ece4db01cb13df";
	// public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
	
	
	public static final String ADDRESS = CREDENTIALS.getAddress();
	
}
