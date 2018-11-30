package com.littlepo.utils;

import java.math.BigInteger;

public class Web3jConstants {

	/* used tp connect to web3jdemo node in Docker
	public static final String CLIENT_IP = "localhost";
	public static final String CLIENT_PORT = "8545"; */
	
	// used to connect to the local POA private network with 3 nodes
	// public static final String CLIENT_IP = "localhost";
	// public static final String CLIENT_PORT = "8501";
	
	// used to connect to the demo POA private network in ML BPaaS
	public static final String CLIENT_IP = "127.0.0.1";
	public static final String CLIENT_PORT = "7545";


	// see https://www.reddit.com/r/ethereum/comments/5g8ia6/attention_miners_we_recommend_raising_gas_limit/
	public static final BigInteger GAS_PRICE = BigInteger.valueOf(50_000_000L);
	
	// http://ethereum.stackexchange.com/questions/1832/cant-send-transaction-exceeds-block-gas-limit-or-intrinsic-gas-too-low
	public static final BigInteger GAS_LIMIT_ETHER_TX = BigInteger.valueOf(21_000);
	public static final BigInteger GAS_LIMIT_GREETER_TX = BigInteger.valueOf(500_000L);
	public static final BigInteger GAS_LIMIT_TX = BigInteger.valueOf(5_000_000L);

	public static final int CONFIRMATION_ATTEMPTS = 40;
	public static final int SLEEP_DURATION = 1000;

	// file name extensions for smart contracts
	public static final String EXT_SOLIDITY = "sol";
	public static final String EXT_BINARY = "bin";
	public static final String EXT_ABI = "abi";
}
