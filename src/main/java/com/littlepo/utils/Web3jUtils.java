package com.littlepo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

public class Web3jUtils {

	public static Web3j buildHttpClient(String ip, String port) {
		String url = String.format("http://%s:%s", ip, port);
		return Web3j.build(new HttpService(url));
	}

	public static String getClientVersion(Web3j web3j) throws InterruptedException, ExecutionException {
		Web3ClientVersion client = web3j
				.web3ClientVersion()
				.sendAsync()
				.get();

		return client.getWeb3ClientVersion();
	}
	
	public static int getPeerCount(Web3j web3j) throws InterruptedException, ExecutionException {
		int  peerCount = web3j
				.netPeerCount().sendAsync().get().getQuantity().intValue();

		return peerCount;
	}
	
	public static int getTotalBlocks(Web3j web3j) throws InterruptedException, ExecutionException {
		int  totalBlocks = web3j.ethBlockNumber().sendAsync().get().getBlockNumber().intValue();
		return totalBlocks;
	}
	
	public static String getNetworkID(Web3j web3j) throws InterruptedException, ExecutionException {
		String  networkID = web3j.netVersion().sendAsync().get().getNetVersion();
		return networkID;
	}
	
	
	public static EthTransaction getTxByHash(Web3j web3j, String transactionHash) throws InterruptedException, ExecutionException {
		EthTransaction ethTransaction = web3j.ethGetTransactionByHash(transactionHash).sendAsync().get();
		return ethTransaction;
	}
	
	public static Block getBlockByNumber(Web3j web3j, int blockNumber) throws InterruptedException, ExecutionException {
		DefaultBlockParameter blockParameter = DefaultBlockParameter
				.valueOf(BigInteger.valueOf(blockNumber));
		
		Block block = web3j.ethGetBlockByNumber(blockParameter, true).sendAsync().get().getBlock();
		return block;
	}

	public static EthCoinbase getCoinbase(Web3j web3j) throws InterruptedException, ExecutionException {
		return web3j
				.ethCoinbase()
				.sendAsync()
				.get();
	}

	/**
	 * Returns the list of addresses owned by this client.
	 */
	public static EthAccounts getAccounts(Web3j web3j) throws InterruptedException, ExecutionException {
		return web3j
				.ethAccounts()
				.sendAsync()
				.get();
	}
	
	/**
	 * Returns the balance (in Ether) of the specified account address. 
	 */
	public static BigDecimal getBalanceEther(Web3j web3j, String address) throws InterruptedException, ExecutionException {
		return weiToEther(getBalanceWei(web3j, address));
	}
	
	/**
	 * Returns the balance (in Wei) of the specified account address. 
	 */
	public static BigInteger getBalanceWei(Web3j web3j, String address) throws InterruptedException, ExecutionException {
		EthGetBalance balance = web3j
				.ethGetBalance(address, DefaultBlockParameterName.LATEST)
				.sendAsync()
				.get();

		return balance.getBalance();
	}

	/**
	 * Return the nonce (tx count) for the specified address.
	 */
	public static BigInteger getNonce(Web3j web3j, String address) throws InterruptedException, ExecutionException {
		EthGetTransactionCount ethGetTransactionCount = 
				web3j.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

		return ethGetTransactionCount.getTransactionCount();
	}
	

	
	/**
	 * Converts the provided Wei amount (smallest value Unit) to Ethers. 
	 */
	public static BigDecimal weiToEther(BigInteger wei) {
		return Convert.fromWei(wei.toString(), Convert.Unit.ETHER);
	}
	
	public static BigInteger etherToWei(BigDecimal ether) {
		return Convert.toWei(ether, Convert.Unit.ETHER).toBigInteger();
	}
	
	/**
	 * Transfers the specified amount of Wei from the coinbase to the specified account.
	 * The method waits for the transfer to complete using method {@link waitForReceipt}.  
	 */
	public static TransactionReceipt transferFromCoinbaseAndWait(Web3j web3j, String to, BigInteger amountWei) 
			throws Exception 
	{
		String coinbase = getCoinbase(web3j).getResult();
		BigInteger nonce = getNonce(web3j, coinbase);
		// this is a contract method call -> gas limit higher than simple fund transfer
		BigInteger gasLimit = Web3jConstants.GAS_LIMIT_ETHER_TX.multiply(BigInteger.valueOf(2)); 
		Transaction transaction = Transaction.createEtherTransaction(
				coinbase, 
				nonce, 
				Web3jConstants.GAS_PRICE, 
				gasLimit, 
				to, 
				amountWei);

		EthSendTransaction ethSendTransaction = web3j
				.ethSendTransaction(transaction)
				.sendAsync()
				.get();

		String txHash = ethSendTransaction.getTransactionHash();
		
		return waitForReceipt(web3j, txHash);
	}

	/**
	 * Waits for the receipt for the transaction specified by the provided tx hash.
	 * Makes 40 attempts (waiting 1 sec. inbetween attempts) to get the receipt object.
	 * In the happy case the tx receipt object is returned.
	 * Otherwise, a runtime exception is thrown. 
	 */
	public static TransactionReceipt waitForReceipt(Web3j web3j, String transactionHash) 
			throws Exception 
	{

		int attempts = Web3jConstants.CONFIRMATION_ATTEMPTS;
		int sleep_millis = Web3jConstants.SLEEP_DURATION;
		
		Optional<TransactionReceipt> receipt = getReceipt(web3j, transactionHash);

		while(attempts-- > 0 && !receipt.isPresent()) {
			Thread.sleep(sleep_millis);
			receipt = getReceipt(web3j, transactionHash);
		}

		if (attempts <= 0) {
			throw new RuntimeException("No Tx receipt received");
		}

		return receipt.get();
	}

	/**
	 * Returns the TransactionRecipt for the specified tx hash as an optional.
	 */
	public static Optional<TransactionReceipt> getReceipt(Web3j web3j, String transactionHash) 
			throws Exception 
	{
		EthGetTransactionReceipt receipt = web3j
				.ethGetTransactionReceipt(transactionHash)
				.sendAsync()
				.get();
	
		return receipt.getTransactionReceipt();
	}

	/**
	 * Reads the specified solidity file and returns it as a single line string.
	 * Includes some preprocessing: removing '//' comments and \s+ are replaced by ' ' globally. 
	 */
	public static String readSolidityFile(String fileName) {
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer text = new StringBuffer();

			br.lines().forEach(line -> {
				if(text.length() > 0) {
					text.append(" ");
				}

				// treat comments
				if(line.contains("//")) {
					line = line.substring(0, line.indexOf("//"));
				}

				text.append(line);
			});
			
			br.close();

			String sourceCode = text.toString();
			return sourceCode.replaceAll("\\s+", " ");
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String convertUnixTimestamp (BigInteger unixTimestamp) {
		// convert unix timestamp to GMT+8 time
		Date time = new Date(unixTimestamp.intValue()*1000L);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(java.util.TimeZone.getTimeZone("GMT+8"));
		
		String timestamp = formatter.format(time);
		return timestamp;
	}
	
	public static Bytes32 stringToBytes32(String string) {
        byte[] byteValue = string.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return new Bytes32(byteValueLen32);
    }
	
	public static String hexToASCII(String hexValue)
    {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < hexValue.length(); i += 2)
        {
            String str = hexValue.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }
	
	public static String removePadding(String string) {
		int index;
		for (index = 0; index < string.length(); index++)
		{
		    char c = string.charAt(index);
		    if (c == '\0')
		    {
		        break;
		    }
		}
		string = string.substring(0, index);
		return string;
	}
	
}
