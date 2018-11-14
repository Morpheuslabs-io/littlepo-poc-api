package com.littlepo.web3j.helloworld;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.littlepo.utils.Orchard;
import com.littlepo.utils.Web3jConstants;
import com.littlepo.utils.Web3jUtils;

/**
 * Sample application to demonstrate smart contract deployment
 * and usage with the web3j library. 
 */
public class ContractDemoWithDeploymentOnly extends AbstractDemo {

	@Override
	public void run() throws Exception {
		super.run();

		// fundOrchard();                        // make Orchard rich
		Greeter greeter = deployContract(); // deploy the greeter contract
		sendFunds(greeter);                 // send money to contract
		String txHash = callGreet(greeter);                 // call greet()
		killContract(greeter);              // kill contract
	}
	
	public static void main(String [] args) throws Exception  {
		new ContractDemoWithDeploymentOnly(args).run();
	}
	
	public String callGreet() throws Exception {
		Greeter greeter = deployContract();
		String txHash = callGreet(greeter);
		killContract(greeter); 
		return txHash;
		
	}

	public ContractDemoWithDeploymentOnly(String [] args) {
		super(args);
	}


	private Greeter deployContract() throws Exception {
		System.out.println("// Deploy contract Greeter");

		Greeter contract = Greeter
				.deploy(
						web3j, 
						Orchard.CREDENTIALS, 
						Web3jConstants.GAS_PRICE, 
						Web3jConstants.GAS_LIMIT_GREETER_TX, 
						"hello world")
				.sendAsync().get();

		// get tx receipt
		TransactionReceipt txReceipt = contract
				.getTransactionReceipt()
				.get();

		// get tx hash and tx fees
		String deployHash = txReceipt.getTransactionHash();
		BigInteger deployFees = txReceipt
				.getCumulativeGasUsed()
				.multiply(Web3jConstants.GAS_PRICE);

		System.out.println("Deploy hash: " + deployHash);
		System.out.println("Deploy fees: " + Web3jUtils.weiToEther(deployFees));

		// get initial contract balance
		int deposits = contract
				.deposits()
				.sendAsync().get().intValue();

		String contractAddress = contract.getContractAddress();
		System.out.println("Contract address: " + contractAddress);
		System.out.println("Contract address balance (initial): " + Web3jUtils.getBalanceWei(web3j, contractAddress));
		System.out.println("Contract.deposits(): " + deposits);
		printBalanceOrchard("after deploy");
		System.out.println("PeerCount: " + Web3jUtils.getPeerCount(web3j));
		System.out.println();

		return contract;
	}

	private void sendFunds(Greeter contract) throws Exception {
		System.out.println("// Send 0.05 Ethers to contract");
		
		// trasfer ether to contract account
		String contractAddress = contract.getContractAddress();
		BigDecimal amountEther = BigDecimal.valueOf(0.05); // need to adjust this amount based on your situation
		BigInteger amountWei = Web3jUtils.etherToWei(amountEther);
		Web3jUtils.transferFromCoinbaseAndWait(web3j, contractAddress, amountWei);			

		// check current # of deposits and balance
		int deposits = contract
				.deposits()
				.sendAsync().get().intValue();

		System.out.println("Contract address balance (after funding): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, contractAddress)));
		System.out.println("Contract.deposits(): " + deposits + "\n");
	}
	
	private String callGreet(Greeter contract) throws Exception {
		System.out.println("// Call greet()");
		
		String message = contract
				.greet()
				.sendAsync().get();
		
		String txHash = contract.getTransactionReceipt().get().getTransactionHash();
		
		
		System.out.println("Message returned by Contract.greet(): " + message.toString());
		printBalanceOrchard("after greet");
		System.out.println();
		return txHash;
	}

	private void killContract(Greeter contract) throws Exception {
		System.out.println("// Kill contract");
		
		TransactionReceipt txReceipt = contract
				.kill()
				 .sendAsync().get();

		BigInteger killFees = txReceipt
				.getCumulativeGasUsed()
				.multiply(Web3jConstants.GAS_PRICE);

		System.out.println("Contract.kill() fee: " + Web3jUtils.weiToEther(killFees));
		printBalanceOrchard("after kill");
	}

	private void fundOrchard() throws Exception {
		System.out.println("// Fund Orchard");
		
		// make sure Orchard has sufficient funds to run this demo
		BigInteger orchardBalance = Web3jUtils.getBalanceWei(web3j, Orchard.ADDRESS);
		BigInteger initialBalance = BigInteger.valueOf(25_000_000_000_000_000L);

		if(orchardBalance.subtract(initialBalance).signum() < 0) {
			Web3jUtils.transferFromCoinbaseAndWait(web3j, Orchard.ADDRESS, initialBalance.subtract(orchardBalance));			
		}

		printBalanceOrchard("before deploy");
		System.out.println();
	}

	private void printBalanceOrchard(String info) throws Exception {
		System.out.println("Orchard's account balance (" + info + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Orchard.ADDRESS)));
	}
}