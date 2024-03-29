package com.littlepo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;

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
import com.littlepo.web3j.ContractController;

@Service
public class ProductTrackingService {
	
	private Web3Properties web3Properties;


	@Autowired
	public ProductTrackingService(Web3Properties web3Properties) {
		this.web3Properties = web3Properties;
	}
	
	public TxHashResponse productTrackingAtNodeB(NodeBdata nodeBdata, Credentials credentials) throws Exception {
		
		ContractController contractController = new ContractController(web3Properties);
		TxHashResponse txHashResponse = contractController.trackProductAtHarvesterNode(nodeBdata, credentials);

		return txHashResponse;
		
	}
	
	public NodeBdata queryProductTrackingAtNodeB(String qrCodeID, Credentials credentials) throws Exception {
		
		ContractController contractController = new ContractController(web3Properties);
		NodeBdata nodeBdata = contractController.queryProductAtHarvesterNode(qrCodeID, credentials);

		return nodeBdata;
		
	}
	
	public NodeDdata queryProductTrackingAtNodeD(String qrCodeID, Credentials credentials) throws Exception {
		
		ContractController contractController = new ContractController(web3Properties);
		NodeDdata nodeDdata = contractController.queryProductAtPackerNode(qrCodeID, credentials);

		return nodeDdata;
		
	}
	
	public NodeGdata queryProductTrackingAtNodeG(String qrCodeID, Credentials credentials) throws Exception {
		
		ContractController contractController = new ContractController(web3Properties);
		NodeGdata nodeGdata = contractController.queryLittlepoNode(qrCodeID, credentials);

		return nodeGdata;
		
	}
	
	public NodeIdata queryProductTrackingAtNodeI(String qrCodeID, Credentials credentials) throws Exception {
		
		ContractController contractController = new ContractController(web3Properties);
		NodeIdata nodeIdata = contractController.queryRetailShopNode(qrCodeID, credentials);

		return nodeIdata;
		
	}
	
	public TxHashResponse productTrackingAtNodeD(NodeDdata nodeDdata, Credentials credentials) throws Exception{
		
		// 
		// call smart contract Update Product Tracking  function
		ContractController contractController = new ContractController(web3Properties);
		TxHashResponse txHashResponse = contractController.trackProductAtPackerNode(nodeDdata, credentials);

		return txHashResponse;
		
	}
	
	public TxHashResponse addTeaBagAtNodeD(NodeDdata nodeDdata, Credentials credentials) throws Exception{
		
		// 
		// call smart contract Update Product Tracking  function
		ContractController contractController = new ContractController(web3Properties);
		TxHashResponse txHashResponse = contractController.addTeaBagAtPackNode(nodeDdata, credentials);

		return txHashResponse;
		
	}
	
	public void setTxHash(String qrCodeID, String txHash, Credentials credentials) throws Exception{
		
		// 
		// call smart contract Update Product Tracking  function
		ContractController contractController = new ContractController(web3Properties);
		contractController.setTxHash(qrCodeID, txHash, credentials);
		
	}
	
	public TxHashResponse productTrackingAtNodeG(NodeGdata nodeGdata, Credentials credentials) throws Exception{
		
		// 
		// call smart contract Update Product Tracking  function
		ContractController contractController = new ContractController(web3Properties);
		TxHashResponse txHashResponse = contractController.trackLittlepoNode(nodeGdata, credentials);

		return txHashResponse;
		
	}
	
	public TxHashResponse productTrackingAtNodeI(NodeIdata nodeIdata, Credentials credentials) throws Exception{
		
		// 
		// call smart contract Update Product Tracking  function
		ContractController contractController = new ContractController(web3Properties);
		TxHashResponse txHashResponse = contractController.trackRetailShopNode(nodeIdata, credentials);

		return txHashResponse;
		
	}

	/*
	public Product getProductInfoByProductID (String productID, Credentials credentials) {
		// get Product Info by product ID function
		Product product = new Product();
		return product;
	}
	*/
	
	/*
	public ProductBatch getProductBatchInfoByBatchNo (String bacthNo, Credentials credentials) {
		// get Product Info by product Batch Number
		ProductBatch productBatch = new ProductBatch();

		return productBatch;
	}
	*/
	
	public ProductBatch getProductBatchInfoByQrCode (String qrCodeID, Credentials credentials) throws Exception {
		// get Product Batch Info by QR code ID (dxCodeID)
		ProductBatch productBatch = new ProductBatch();
		ContractController contractController = new ContractController(web3Properties);
		productBatch = contractController.getProductBatchInfoByQrCodeID(qrCodeID, credentials);
		return productBatch;
	}
	
	public List<NodeData> getProductTrackingHistory (String qrCodeID, Credentials credentials) throws Exception {
		
		// call query product tracking history info function in the smart contract
		
		List<NodeData> listOfNodeData = new ArrayList<NodeData>();
		ContractController contractController = new ContractController(web3Properties);
		listOfNodeData = contractController.getLittlepoProductHistory(qrCodeID, credentials);
		return listOfNodeData;
		
	}
	
	
	public List<String> getChidrenOfProduct (String parentQrCodeID, Credentials credentials) throws Exception {
	
		
		List<String> listOfQrCodeIDs = new ArrayList<String>();
		ContractController contractController = new ContractController(web3Properties);
		listOfQrCodeIDs = contractController.getChildrenOfProduct(parentQrCodeID, credentials);
		return listOfQrCodeIDs;
		
	}
	
	/*
	public ProductTracking getProductTracking (String NodeID, String productBatchNo, Credentials credentials) throws Exception{
		
		// call query product tracking info function in the smart contract. productBatchNo refer to bBatchNo since it is global across all the nodes.
		
		ProductTracking productTracking = new ProductTracking();
		return productTracking;
		
	}
	*/

}
