package com.littlepo.utils;

import org.web3j.crypto.Credentials;

public class Woodlands {

	
	// Used for a POA Ethereum network - 3 nodes. Private key for the account in node 1.
	private static final String PRIVATE_KEY = "0x9618c0b046b65978a7b9768266feaea64b267854f9bcc47cdef353698bfdba82";
	public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
	public static final String ADDRESS = CREDENTIALS.getAddress();
}
