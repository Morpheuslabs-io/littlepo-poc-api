package com.littlepo.web3j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
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
import com.littlepo.data.NodeData;
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
import com.littlepo.web3j.wrapper.LittlepoProductHistory;
import com.littlepo.web3j.wrapper.LittlepoProductTracking;
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
	private LittlepoProductHistory littlepoProductHistory;
	private LittlepoProductTracking littlepoProductTracking;
	
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
	
		public TxHashResponse addTeaBagAtPackNode(NodeDdata nodeDdata, Credentials credentials) throws Exception {
		
        accessProductPackerNode(credentials);
        
        Bytes32 dQrCodeID = Web3jUtils.stringToBytes32(nodeDdata.getDQrCodeID());
        Bytes32 dxQrCodeID = Web3jUtils.stringToBytes32(nodeDdata.getDxQrCodeID());
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeDdata.getBbatchNo());
        Bytes32 dBatchNo = Web3jUtils.stringToBytes32(nodeDdata.getDbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeDdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeDdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeDdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeDdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeDdata.getDQrCodeID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeDdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeDdata.getLegalEntity());

        
        // bytes32 _qrCodeId, (dxQrCodeId)
        // bytes32 _dBatchNo
        // bytes32 _bBatchNo,
        // bytes32 _productName,
        // bytes32 _location,
        // bytes32 _productId,
        // bytes32 _producerId,
        // bytes32 _containerId,
        // bytes32 _containerType,
        // bytes32 _legalEntity
        
        DynamicArray<Bytes32> bArgs = 
        		new DynamicArray<> (dxQrCodeID, dBatchNo, bBatchNo, productName, location, productId, producerId, containerId, containerType, legalEntiry);

        String txHash = productPackerNode.addTeaBagBatch(dQrCodeID, bArgs).send().getTransactionHash();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       


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
        
        Bytes32 iQrCodeID = Web3jUtils.stringToBytes32(nodeIdata.getIQrCodeID());
        Bytes32 dBatchNo = Web3jUtils.stringToBytes32(nodeIdata.getDbatchNo());
        Bytes32 dxQrCodeID = Web3jUtils.stringToBytes32(nodeIdata.getDxQrCodeID());
        Bytes32 bBatchNo = Web3jUtils.stringToBytes32(nodeIdata.getBbatchNo());
        Bytes32 productName =  Web3jUtils.stringToBytes32(nodeIdata.getProductName());
        Bytes32 location =  Web3jUtils.stringToBytes32(nodeIdata.getLocation());

        Bytes32 productId = Web3jUtils.stringToBytes32(nodeIdata.getProductID());
        Bytes32 producerId = Web3jUtils.stringToBytes32(nodeIdata.getProducerID());
        Bytes32 containerId = Web3jUtils.stringToBytes32(nodeIdata.getProductID());
        Bytes32 containerType = Web3jUtils.stringToBytes32(nodeIdata.getPackageType());
        Bytes32 legalEntiry = Web3jUtils.stringToBytes32(nodeIdata.getLegalEntity());
        Bytes32 quantity = Web3jUtils.stringToBytes32(nodeIdata.getQty());
        Bytes32 price = Web3jUtils.stringToBytes32(nodeIdata.getPrice());
        Bytes32 waterTemperature = Web3jUtils.stringToBytes32(nodeIdata.getWaterTemperature());
        
        // qrCodeId = bArgs[0];
        // dxQRCodeId = bArgs[1];
        // dBatchNo = bArgs[2];
        // bBatchNo = bArgs[3];
        // productName = bArgs[4];
        // location = bArgs[5];

        // productId = bArgs[6];
        // containerId = bArgs[7];
        // containerType = bArgs[8];
        // legalEntity = bArgs[9];
        // producerId = bArgs[10];
        // quantity = bArgs[11];
        // price = bArgs[12];
        // waterTemperature = bArgs[13];
        
        DynamicArray<Bytes32> bArgs = new DynamicArray<> (iQrCodeID, dxQrCodeID, dBatchNo, bBatchNo, productName, location, productId, containerId, containerType, legalEntiry, producerId, quantity, price, waterTemperature);
        
        Timestamp timestamp2 = new Timestamp((new Date()).getTime());
        String txHash = retailShopNode.createProductBatch(bArgs).send().getTransactionHash();
        Timestamp timestamp3 = new Timestamp((new Date()).getTime());       

		System.out.println("trackRetailShopNode, create smart contract started at: " + timestamp1);
		System.out.println("trackRetailShopNode, call smart contract started: " + timestamp2);
		System.out.println("trackRetailShopNode, ended at: " + timestamp3);
		System.out.println("trackRetailShopNode, txTash: " + txHash);
		
		TxHashResponse txHashResponse = new TxHashResponse();
		txHashResponse.setTxHash(txHash);
		txHashResponse.setContractAddress(retailShopNode.getContractAddress());
		txHashResponse.setSubmiitedTime(timestamp3);
		
		return txHashResponse;
		
	}
	
	public NodeBdata queryProductAtHarvesterNode(String qrCodeID, Credentials credentials) throws Exception {
		
        NodeBdata nodeBdata = new NodeBdata();
   
        Bytes32 qrCodeIDByte32 = Web3jUtils.stringToBytes32(qrCodeID);
        accessProductHarvesterNode(credentials);
		DynamicArray<Bytes32> productHarvesterBatch = productHarvesterNode.getProductBatchInfo(qrCodeIDByte32).send();
		
		productHarvesterBatch = productHarvesterNode.getProductBatchInfo(qrCodeIDByte32).send();
       // bBatchNo
       // productName
       // location
       // productId
       // producerId
       // containerId
       // containerType
       // legalEntity
		List<Bytes32> productHarvesterBatchValue = productHarvesterBatch.getValue();
	    
		String bBatchNo = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(0).getValue()));
		String productName = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(1).getValue()));
		String location = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(2).getValue()));
		String productID = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(3).getValue()));
		String producerID = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(4).getValue()));
		String containerId = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(5).getValue()));
		String packageType = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(6).getValue()));
		String legalEntity = Web3jUtils.removePadding(new String(productHarvesterBatchValue.get(7).getValue()));	
		
		nodeBdata.setBbatchNo(bBatchNo);
		nodeBdata.setProductID(productID);
		nodeBdata.setProductName(productName);
		nodeBdata.setProducerID(producerID);
		nodeBdata.setLocation(location);
		nodeBdata.setLegalEntity(legalEntity);
		nodeBdata.setPackageType(packageType);
		nodeBdata.setBQrCodeID(qrCodeID);
		
		return nodeBdata;
		
	}
	
	public NodeDdata queryProductAtPackerNode(String qrCodeID, Credentials credentials) throws Exception {
		
        NodeDdata nodeDdata = new NodeDdata();
   
        Bytes32 qrCodeIDByte32 = Web3jUtils.stringToBytes32(qrCodeID);
        accessProductPackerNode(credentials);
		DynamicArray<Bytes32> productPackerBatch = productPackerNode.getProductBatchInfo(qrCodeIDByte32).send();
       // bBatchNo
       // productName
       // location
       // productId
       // producerId
       // containerId
       // containerType
       // legalEntity
		
	   // dBatchNo
	   // weight
		List<Bytes32> productPackerBatchValue = productPackerBatch.getValue();
	    
		String bBatchNo = Web3jUtils.removePadding(new String(productPackerBatchValue.get(0).getValue()));
		String productName = Web3jUtils.removePadding(new String(productPackerBatchValue.get(1).getValue()));
		String location = Web3jUtils.removePadding(new String(productPackerBatchValue.get(2).getValue()));
		String productID = Web3jUtils.removePadding(new String(productPackerBatchValue.get(3).getValue()));
		String producerID = Web3jUtils.removePadding(new String(productPackerBatchValue.get(4).getValue()));
		String containerId = Web3jUtils.removePadding(new String(productPackerBatchValue.get(5).getValue()));
		String packageType = Web3jUtils.removePadding(new String(productPackerBatchValue.get(6).getValue()));
		String legalEntity = Web3jUtils.removePadding(new String(productPackerBatchValue.get(7).getValue()));
		
		String dBatchNo = Web3jUtils.removePadding(new String(productPackerBatchValue.get(8).getValue()));
		String weight = Web3jUtils.removePadding(new String(productPackerBatchValue.get(9).getValue()));	
		
		nodeDdata.setBbatchNo(bBatchNo);
		nodeDdata.setProductID(productID);
		nodeDdata.setProductName(productName);
		nodeDdata.setProducerID(producerID);
		nodeDdata.setLocation(location);
		nodeDdata.setLegalEntity(legalEntity);
		nodeDdata.setPackageType(packageType);
		nodeDdata.setDQrCodeID(qrCodeID);
		
		nodeDdata.setDbatchNo(dBatchNo);
		nodeDdata.setWeight(weight);
		
		return nodeDdata;
	}
	
	public NodeGdata queryLittlepoNode(String qrCodeID, Credentials credentials) throws Exception {
		
        NodeGdata nodeGdata = new NodeGdata();
   
        Bytes32 qrCodeIDByte32 = Web3jUtils.stringToBytes32(qrCodeID);
        accessLittlepoNode(credentials);
		DynamicArray<Bytes32> littlepoBatch = littlepoNode.getProductBatchInfo(qrCodeIDByte32).send();
       // bBatchNo
       // productName
       // location
       // productId
       // producerId
       // containerId
       // containerType
       // legalEntity
		
	   // dBatchNo
	   // weight
		List<Bytes32> littlepoBatchValue = littlepoBatch.getValue();
	    
		String bBatchNo = Web3jUtils.removePadding(new String(littlepoBatchValue.get(0).getValue()));
		String productName = Web3jUtils.removePadding(new String(littlepoBatchValue.get(1).getValue()));
		String location = Web3jUtils.removePadding(new String(littlepoBatchValue.get(2).getValue()));
		String productID = Web3jUtils.removePadding(new String(littlepoBatchValue.get(3).getValue()));
		String producerID = Web3jUtils.removePadding(new String(littlepoBatchValue.get(4).getValue()));
		String containerId = Web3jUtils.removePadding(new String(littlepoBatchValue.get(5).getValue()));
		String packageType = Web3jUtils.removePadding(new String(littlepoBatchValue.get(6).getValue()));
		String legalEntity = Web3jUtils.removePadding(new String(littlepoBatchValue.get(7).getValue()));
		
		String dBatchNo = Web3jUtils.removePadding(new String(littlepoBatchValue.get(8).getValue()));
		String weight = Web3jUtils.removePadding(new String(littlepoBatchValue.get(9).getValue()));	
		
		nodeGdata.setBbatchNo(bBatchNo);
		nodeGdata.setProductID(productID);
		nodeGdata.setProductName(productName);
		nodeGdata.setProducerID(producerID);
		nodeGdata.setLocation(location);
		nodeGdata.setLegalEntity(legalEntity);
		nodeGdata.setPackageType(packageType);
		nodeGdata.setDQrCodeID(qrCodeID);
		
		nodeGdata.setDbatchNo(bBatchNo);
		nodeGdata.setWeight(weight);
		
		return nodeGdata;
	}
	
	public NodeIdata queryRetailShopNode(String qrCodeID, Credentials credentials) throws Exception {
		
        NodeIdata nodeIdata = new NodeIdata();
   
        Bytes32 qrCodeIDByte32 = Web3jUtils.stringToBytes32(qrCodeID);
        accessRetailShopNode(credentials);
		DynamicArray<Bytes32> retailShopBatch = retailShopNode.getProductBatchInfo(qrCodeIDByte32).send();
		// bBatchNo
		// productName
		// location
		// productId
		// producerId
		// containerId
		// containerType
		// legalEntity

		// dBatchNo
		// dxQRCodeId
		// quantity
		
		List<Bytes32> retailShopBatchValue = retailShopBatch.getValue();
	    
		String bBatchNo = Web3jUtils.removePadding(new String(retailShopBatchValue.get(0).getValue()));
		String productName = Web3jUtils.removePadding(new String(retailShopBatchValue.get(1).getValue()));
		String location = Web3jUtils.removePadding(new String(retailShopBatchValue.get(2).getValue()));
		String productID = Web3jUtils.removePadding(new String(retailShopBatchValue.get(3).getValue()));
		String producerID = Web3jUtils.removePadding(new String(retailShopBatchValue.get(4).getValue()));
		String containerId = Web3jUtils.removePadding(new String(retailShopBatchValue.get(5).getValue()));
		String packageType = Web3jUtils.removePadding(new String(retailShopBatchValue.get(6).getValue()));
		String legalEntity = Web3jUtils.removePadding(new String(retailShopBatchValue.get(7).getValue()));
		
		String dBatchNo = Web3jUtils.removePadding(new String(retailShopBatchValue.get(8).getValue()));
		String dxQRCodeId = Web3jUtils.removePadding(new String(retailShopBatchValue.get(9).getValue()));
		
		nodeIdata.setBbatchNo(bBatchNo);
		nodeIdata.setProductID(productID);
		nodeIdata.setProductName(productName);
		nodeIdata.setProducerID(producerID);
		nodeIdata.setLocation(location);
		nodeIdata.setLegalEntity(legalEntity);
		nodeIdata.setPackageType(packageType);
		nodeIdata.setIQrCodeID(qrCodeID);
		
		nodeIdata.setDbatchNo(bBatchNo);
		
		nodeIdata.setDxQrCodeID(dxQRCodeId);
		
		return nodeIdata;
	}
	
	public ProductBatch getProductBatchInfoByBatchNo(String nodeID, String productBatchNo, Credentials credentials) throws Exception {
		
        ProductBatch productBatch = new ProductBatch();
        
		accessRetailShopNode(credentials);
		
		
		
		return productBatch;
		
	}
	
	public ProductBatch getProductBatchInfoByQrCodeID(String qrCodeID, Credentials credentials) throws Exception {
		
        ProductBatch productBatch = new ProductBatch();
   
        Bytes32 qrCodeIDByte32 = Web3jUtils.stringToBytes32(qrCodeID);
        accessProductHarvesterNode(credentials);
		DynamicArray<Bytes32> productHarvesterBatch = productHarvesterNode.getProductBatchInfo(qrCodeIDByte32).sendAsync().get();
       // bBatchNo
       // productName
       // location
       // productId
       // producerId
       // containerId
       // containerType
       // legalEntity
		List<Bytes32> productHarvesterBatchValue = productHarvesterBatch.getValue();

		String productBatchNo = Web3jUtils.hexToASCII(new String(productHarvesterBatchValue.get(0).getValue()));
		String productName = new String(productHarvesterBatchValue.get(1).getValue(), StandardCharsets.UTF_8);
		String location = new String(productHarvesterBatchValue.get(2).getValue());
		String productID = new String(productHarvesterBatchValue.get(3).getValue());
		String producerID = new String(productHarvesterBatchValue.get(4).getValue());
		String containerId = new String(productHarvesterBatchValue.get(5).getValue());
		String containerType = new String(productHarvesterBatchValue.get(6).getValue());
		String legalEntity = new String(productHarvesterBatchValue.get(7).getValue());	
		
		productBatch.setProductBatchNo(productBatchNo);
		productBatch.setProductID(productID);
		productBatch.setProductName(productName);
		productBatch.setProducerID(producerID);
		
		return productBatch;
		
	}
	
	public Product getProductInfoByProductID(String productID, Credentials credentials) throws Exception {
		
        Product product = new Product();
        
		accessRetailShopNode(credentials);
		
		return product;
		
	}
	
	public ProductTrackingHistory getProductTrackingHistory(String qrCodeID, Credentials credentials) throws Exception {
		// dxQrCode
        
        ProductTrackingHistory productTrackingHistory = new ProductTrackingHistory();
        
        List<NodeData> listOfNodeData = new ArrayList<NodeData> ();
        
		accessLittlepoProductTracking(credentials);
		
		// nodeID, qrCodeID, timestamp
		
		Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>> result 
			= littlepoProductTracking.getProductTrackingInfo(Web3jUtils.stringToBytes32(qrCodeID)).send();
		
		List<Bytes32> nodeIDs = result.getValue1().getValue();
		List<Bytes32>  qrCodeIDs = result.getValue2().getValue();
		List<Uint256>  createTimes = result.getValue3().getValue();
		
        NodeIdata nodeIdata = queryRetailShopNode(qrCodeID, credentials);
		
		int cnt = nodeIDs.size();
		
		for (int i = 0; i < cnt; i++) {
			NodeData nodeData = new NodeData();
			String nodeID = Web3jUtils.removePadding(new String(nodeIDs.get(i).getValue()));
			String qrCodeID1 = Web3jUtils.removePadding(new String(qrCodeIDs.get(i).getValue()));
			String createTime = createTimes.get(i).getValue().toString(i);
			
			nodeData.setNodeID(nodeID);
			nodeData.setNodeID(qrCodeID1);
			nodeData.setCreateTime(createTime);
			listOfNodeData.add(nodeData);

		}
		
		productTrackingHistory.setListOfNodes(listOfNodeData);
		productTrackingHistory.setProductID(nodeIdata.getProducerID());
		
		return productTrackingHistory;
		
	}
	

	/*
	
	public ProductTracking getProductTracking(String qrCodeID, Credentials credentials) throws Exception {
		
        ProductTracking productTracking = new ProductTracking();
        
		accessProduct(credentials);
		
		return productTracking;
		
	}
	*/

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
	private void accessLittlepoProductTrackingHistory(Credentials credentials) throws Exception {
		
        Timestamp timestamp1 = new Timestamp((new Date()).getTime());
		System.out.println("accessLittlepoProductHistory: started at " + timestamp1);
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressLittlepoProductHistory = web3Properties.getAddressLittlepoProductTrackingHistory();

		System.out.println("accessLittlepoProductHistory: address is " + addressLittlepoProductHistory);

		if (littlepoProductHistory == null) {
			littlepoProductHistory = littlepoProductHistory.load
					(addressLittlepoProductHistory, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager
			Timestamp timestamp2 = new Timestamp((new Date()).getTime());

			System.out.println("accessLittlepoProductHistory: ended at " + timestamp2);
		}
		
	}
	
	private void accessLittlepoProductTracking(Credentials credentials) throws Exception {
		
        
		TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);

		TransactionManager transactionManager = new FastRawTransactionManager(
				web3j, 
				credentials, 
				ChainId.NONE, 
				transactionReceiptProcessor); 
		
		String addressLittlepoProductTracking = web3Properties.getAddressLittlepoProductTrackingHistory();

		if (littlepoProductTracking == null) {
			littlepoProductTracking = littlepoProductTracking.load
					(addressLittlepoProductTracking, web3j, transactionManager, new DefaultGasProvider()); // use default Transaction Manager

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