package com.littlepo.utils;

import org.web3j.crypto.Credentials;

// this is a mock up class to get user credentials

public class UserAdmin {
	
	private Credentials credentials;
	
	public Credentials getCredentials(String userID) {
		credentials = Orchard.CREDENTIALS;
		return credentials;
		
	}
	
	public Credentials getDefaultCredentials() {
		credentials = Orchard.CREDENTIALS;
		return credentials;
		
	}

}
