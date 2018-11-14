package com.littlepo.web3j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.ChainId;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.response.NoOpProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Numeric;

import com.littlepo.config.Web3Properties;
import com.littlepo.data.NodeBdata;
import com.littlepo.data.NodeDdata;
import com.littlepo.data.NodeGdata;
import com.littlepo.data.NodeIdata;
import com.littlepo.data.Product;
import com.littlepo.data.ProductBatch;
import com.littlepo.data.ProductTracking;
import com.littlepo.data.ProductTrackingHistory;
import com.littlepo.data.blockchain.TxHashResponse;
import com.littlepo.utils.Orchard;
import com.littlepo.utils.Web3jConstants;
import com.littlepo.utils.Web3jUtils;
import com.littlepo.web3j.wrapper.LittlepoNode;
import com.littlepo.web3j.wrapper.ProductHarvesterNode;
import com.littlepo.web3j.wrapper.ProductPackerNode;
import com.littlepo.web3j.wrapper.RetailShopNode;


import java.sql.Timestamp;

import static org.web3j.tx.TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH;
import org.web3j.tx.response.Callback;


/**
 * Sample application to demonstrate smart contract deployment
 * and usage with the web3j library. 
 */
public class ContractController extends AbstractContractManager {
	
	private static final long POLLING_FREQUENCY = 15000;
	private Web3Properties web3Properties = new Web3Properties();
	private ProductHarvesterNode productHarvesterNode;
	private ProductPackerNode productPackerNode;
	private LittlepoNode littlepoNode;
	private RetailShopNode retailShopNode;
	
	@Override
	public void run() throws Exception {
		super.run();
	}

	public ContractController(String [] args) {
		super(args);
	}

	public ContractController() {
		super();
	}
	
	@Autowired
	public ContractController(Web3Properties web3Properties) {
		this.web3Properties = web3Properties;
		String ip = web3Properties.getClientIP();
		String port = web3Properties.getClientPORT();
		clientUrl =  String.format("http://%s:%s", ip, port);
		System.out.println("ContractController: clientUrl " + clientUrl);
		web3j = Web3j.build(new HttpService(clientUrl));
	}
	public TxHashResponse createProduct(Product profuct, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());

        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        // String txHash = productHarvesterNode.createProductBatch(bArgs).send().getTransactionHash();
        // productHarvesterNode.createProductBatch(bArgs).sendAsync();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("createProduct, create smart contract started at: " + timestamp1);
		System.out.println("createProduct, call smart contract started: " + timestamp2);
		System.out.println("createProduct, ended at: " + timestamp3);
		// System.out.println("createProduct, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		// txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(productHarvesterNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public TxHashResponse createProductBatch(ProductBatch profuctBatch, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());

        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        // String txHash = productHarvesterNode.createProductBatch(bArgs).send().getTransactionHash();
        // productHarvesterNode.createProductBatch(bArgs).sendAsync();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("createProductBatch, create smart contract started at: " + timestamp1);
		System.out.println("createProductBatch, call smart contract started: " + timestamp2);
		System.out.println("createProductBatch, ended at: " + timestamp3);
		// System.out.println("createProductBatch, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		// txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(productHarvesterNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public TxHashResponse trackProductAtHarvesterNode(NodeBdata nodeBdata, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
        accessProductHarvesterNode(credentials);
        
        Bytes32 productBatchId = Web3jUtils.stringToBytes32(nodeBdata.getBQrCodeID());
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeBdata.getBbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeBdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeBdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeBdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeBdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeBdata.getBQrCodeID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeBdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeBdata.getLegalEntity());
        
        // Array format
        // bytes32 _productBatchId,
        // bytes32 _bBatchNo,
        // bytes32 _productName,
        // bytes32 _location,
        // bytes32 _productId,
        // bytes32 _producerId,
        // bytes32 _containerId,
        // bytes32 _containerType,
        // bytes32 _legalEntity
        
        DynamicArray<Bytes32> bArgs = new DynamicArray<> (productBatchId, bBatchNo, productName, location, productId, producerId, containerId, containerType, legalEntiry);
        
        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        String txHash = productHarvesterNode.createProductBatch(bArgs).send().getTransactionHash();
        // productHarvesterNode.createProductBatch(bArgs).sendAsync();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("trackProductAtHarvesterNode, create smart contract started at: " + timestamp1);
		System.out.println("trackProductAtHarvesterNode, call smart contract started: " + timestamp2);
		System.out.println("trackProductAtHarvesterNode, ended at: " + timestamp3);
		System.out.println("trackProductAtHarvesterNode, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(productHarvesterNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public TxHashResponse trackProductAtPackerNode(NodeDdata nodeDdata, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
        accessProductPackerNode(credentials);
        
        Bytes32 productBatchId = Web3jUtils.stringToBytes32(nodeDdata.getDQrCodeID());
        Bytes32 dBatchNo = Web3jUtils.stringToBytes32(nodeDdata.getDbatchNo());
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeDdata.getBbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeDdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeDdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeDdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeDdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeDdata.getDQrCodeID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeDdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeDdata.getLegalEntity());
        Bytes32 weight = Web3jUtils.stringToBytes32(nodeDdata.getWeight());
        
        // Array format
        // bytes32 _productBatchId,
        // bytes32 _dBatchNo,
        // bytes32 _bBatchNo,
        // bytes32 _productName,
        // bytes32 _location,
        // bytes32 _productId,
        // bytes32 _containerId,
        // bytes32 _containerType,
        // bytes32 _legalEntity,
        // bytes32 _producerId,
        // bytes32 _weight
        
        DynamicArray<Bytes32> bArgs = 
        		new DynamicArray<> (productBatchId, dBatchNo, bBatchNo, productName, location, productId, containerId, containerType, legalEntiry, producerId, weight);
        
        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        String txHash = productPackerNode.createProductBatch(bArgs).send().getTransactionHash();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("trackProductAtPackerNode, create smart contract started at: " + timestamp1);
		System.out.println("trackProductAtPackerNode, call smart contract started: " + timestamp2);
		System.out.println("trackProductAtPackerNode, ended at: " + timestamp3);
		System.out.println("trackProductAtPackerNode, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(productPackerNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}

	public TxHashResponse trackLittlepoNode(NodeGdata nodeGdata, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
        accessLittlepoNode(credentials);
        
        Bytes32 productBatchId = Web3jUtils.stringToBytes32(nodeGdata.getDQrCodeID());
        Bytes32 dBatchNo = Web3jUtils.stringToBytes32(nodeGdata.getDbatchNo());
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeGdata.getBbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeGdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeGdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeGdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeGdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeGdata.getDQrCodeID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeGdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeGdata.getLegalEntity());
        Bytes32 weight = Web3jUtils.stringToBytes32(nodeGdata.getWeight());
        
        // Array format
        // bytes32 _productBatchId,
        // bytes32 _dBatchNo,
        // bytes32 _bBatchNo,
        // bytes32 _productName,
        // bytes32 _location,
        // bytes32 _productId,
        // bytes32 _containerId,
        // bytes32 _containerType,
        // bytes32 _legalEntity,
        // bytes32 _producerId,
        // bytes32 _weight
        
        DynamicArray<Bytes32> bArgs = new DynamicArray<> (productBatchId, dBatchNo, bBatchNo, productName, location, productId, containerId, containerType, legalEntiry, producerId, weight);
        
        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        String txHash = littlepoNode.createProductBatch(bArgs).send().getTransactionHash();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("trackLittlepoNode, create smart contract started at: " + timestamp1);
		System.out.println("trackLittlepoNode, call smart contract started: " + timestamp2);
		System.out.println("trackLittlepoNode, ended at: " + timestamp3);
		System.out.println("trackLittlepoNode, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(littlepoNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public TxHashResponse trackRetailShopNode(NodeIdata nodeIdata, Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
        accessRetailShopNode(credentials);
        
        Bytes32 productBatchId = Web3jUtils.stringToBytes32(nodeIdata.getDQrCodeID());
        Bytes32 dBatchNo = Web3jUtils.stringToBytes32(nodeIdata.getDbatchNo());
        List<String> dxQrCodeIDs = nodeIdata.getDxQrCodeIDs();
        Bytes32 dxQrCodeID = Web3jUtils.stringToBytes32(dxQrCodeIDs.get(0));
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeIdata.getBbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeIdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeIdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeIdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeIdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeIdata.getDQrCodeID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeIdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeIdata.getLegalEntity());
        Bytes32 quantity = Web3jUtils.stringToBytes32(nodeIdata.getQty());
        Bytes32 price = Web3jUtils.stringToBytes32(nodeIdata.getPrice());
        Bytes32 waterTemperature = Web3jUtils.stringToBytes32(nodeIdata.getWaterTemperature());
        
        // Array format
        // bytes32 _productBatchId,
        // bytes32 _dxQRCodeId,
        // bytes32 _dBatchNo,
        // bytes32 _bBatchNo,
        // bytes32 _productName,
        // bytes32 _location,
        // bytes32 _productId,
        // bytes32 _containerId,
        // bytes32 _containerType,
        // bytes32 _legalEntity,
        // bytes32 _producerId,
        // bytes32 _quantity,
        // bytes32 _price,
        // bytes32 _waterTemperature
        
        DynamicArray<Bytes32> bArgs = new DynamicArray<> (productBatchId, dxQrCodeID, dBatchNo, bBatchNo, productName, location, productId, containerId, containerType, legalEntiry, producerId, quantity, price, waterTemperature);
        
        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        String txHash = retailShopNode.createProductBatch(bArgs).send().getTransactionHash();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("trackRetailShopNode, create smart contract started at: " + timestamp1);
		System.out.println("trackRetailShopNode, call smart contract started: " + timestamp2);
		System.out.println("trackRetailShopNode, ended at: " + timestamp3);
		System.out.println("trackRetailShopNode, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(littlepoNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public ProductBatch getProductBatchInfoByBatchNo(String nodeID, String productBatchNo, Credentials credentials) throws Exception {
		
        ProductBatch productBatch = new ProductBatch();
        
		accessRetailShopNode(credentials);
		
		return productBatch;
		
	}
	
	public ProductBatch getProductBatchInfoByQrCodeID(String qrCodeID, Credentials credentials) throws Exception {
		
        ProductBatch productBatch = new ProductBatch();
        
		accessRetailShopNode(credentials);
		
		return productBatch;
		
	}
	
	public Product getProductInfoByProductID(String productID, Credentials credentials) throws Exception {
		
        Product product = new Product();
        
		accessRetailShopNode(credentials);
		
		return product;
		
	}
	
	public ProductTrackingHistory getProductTrackingHistory(String qrCodeID, Credentials credentials) throws Exception {
		
        ProductTrackingHistory productTrackingHistory = new ProductTrackingHistory();
        
		accessRetailShopNode(credentials);
		
		return productTrackingHistory;
		
	}
	
	public ProductTracking getProductTracking(String qrCodeID, Credentials credentials) throws Exception {
		
        ProductTracking productTracking = new ProductTracking();
        
		accessRetailShopNode(credentials);
		
		return productTracking;
		
	}

	public static void main(String [] args) throws Exception  {
		new ContractController(args).run();
		// new ContractController(args).createContractInstances();
		
	}
	
	private void accessProductHarvesterNode(Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
		System.out.println("accessProductHarvesterNode: started at " + timestamp1);
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressProductHarvesterNode = web3Properties.getAddressProductHarvesterNode();

		System.out.println("accessProductHarvesterNode: address is " + addressProductHarvesterNode);

		if (productHarvesterNode == null) {
			productHarvesterNode = ProductHarvesterNode.load
					(addressProductHarvesterNode, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager
			Timestamp timestamp2 = new Timestamp((new Date()).getTime());

			System.out.println("accessProductHarvesterNode: ended at " + timestamp2);
		}
		
	}
	
	private void accessProductPackerNode(Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
		System.out.println("accessProductPackerNode: started at " + timestamp1);
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressProductPackerNode = web3Properties.getAddressProductPackerNode();

		System.out.println("accessProductPackerNode: address is " + addressProductPackerNode);

		if (productPackerNode == null) {
			productPackerNode = ProductPackerNode.load
					(addressProductPackerNode, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager
			Timestamp timestamp2 = new Timestamp((new Date()).getTime());

			System.out.println("accessProductPackerNode: ended at " + timestamp2);
		}
		
	}
	private void accessLittlepoNode(Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
		System.out.println("accessLittlepoNode: started at " + timestamp1);
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressLittlepoNode = web3Properties.getAddressLittlepoNode();

		System.out.println("accessLittlepoNode: address is " + addressLittlepoNode);

		if (littlepoNode == null) {
			littlepoNode = LittlepoNode.load
					(addressLittlepoNode, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager
			Timestamp timestamp2 = new Timestamp((new Date()).getTime());

			System.out.println("accessLittlepoNode: ended at " + timestamp2);
		}
		
	}
	private void accessRetailShopNode(Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
		System.out.println("accessRetailShopNode: started at " + timestamp1);
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressRetailShopNode = web3Properties.getAddressRetailShopNode();

		System.out.println("accessRetailShopNode: address is " + addressRetailShopNode);

		if (retailShopNode == null) {
			retailShopNode = RetailShopNode.load
					(addressRetailShopNode, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager
			Timestamp timestamp2 = new Timestamp((new Date()).getTime());

			System.out.println("accessRetailShopode: ended at " + timestamp2);
		}
		
	}

}