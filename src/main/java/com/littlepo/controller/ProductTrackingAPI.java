package com.littlepo.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;

import com.littlepo.data.NodeBdata;
import com.littlepo.data.NodeData;
import com.littlepo.data.NodeDdata;
import com.littlepo.data.NodeGdata;
import com.littlepo.data.NodeIdata;
import com.littlepo.data.Product;
import com.littlepo.data.ProductBatch;
import com.littlepo.data.ProductTracking;
import com.littlepo.data.ProductTrackingHistory;
import com.littlepo.data.QrData;
import com.littlepo.data.blockchain.TxHashResponse;
import com.littlepo.service.ProductTrackingService;
import com.littlepo.utils.UserAdmin;
import com.littlepo.web3j.ContractController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product/")

public class ProductTrackingAPI {

    @Autowired
	ProductTrackingService productTrackingService;
    
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-b", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-B of the supply chain process",
    notes = "Track product info")
	public TxHashResponse trackProductAtNodeB(@RequestBody ProductTracking productTracking) {
		try {
			NodeBdata nodeBdata = productTracking.getNodeBdata();
			
			String userID = nodeBdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeB(nodeBdata, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-d", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-D of the supply chain process",
    notes = "Track product info")
	public TxHashResponse trackProductAtNodeD(@RequestBody ProductTracking productTracking) {
		try {
			NodeDdata nodeDdata = productTracking.getNodeDdata();
			String userID = nodeDdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeD(nodeDdata, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-g", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-G of the supply chain process",
    notes = "Track product info")
	public TxHashResponse trackProductAtNodeG(@RequestBody ProductTracking productTracking) {
		try {
			NodeGdata nodeGdata = productTracking.getNodeGdata();
			String userID = nodeGdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeG(nodeGdata, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-i", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-I of the supply chain process",
    notes = "Track product info")
	public TxHashResponse trackProductAtNodeI(@RequestBody ProductTracking productTracking) {
		try {
			NodeIdata nodeIdata = productTracking.getNodeIdata();
			String userID = nodeIdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeI(nodeIdata, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/productbatch/batchno", produces = "application/json")
	@ApiOperation(value = "Get product batch info by product batch no",
    notes = "This gets product batch based on product batch no.")

    public ProductBatch queryProductBatchByBatchNo(@RequestParam  String productBatchNo) throws Exception {
    	try {
	    	ProductBatch productBatchInfo = new ProductBatch();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productBatchInfo = productTrackingService.getProductBatchInfoByBatchNo(productBatchNo, credentials);
	        return productBatchInfo;
    	} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while getting info", ex);
		}
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/productbatch/qrcode", produces = "application/json")
	@ApiOperation(value = "Get product batch info by QR Code ID",
    notes = "This returns product batch info that is related to the QR code, based on QR code ID.")

    public ProductBatch queryProductBatchByQRcode(@RequestParam QrData qrData) throws Exception {
    	try {
    		String qrCodeID = qrData.getQrString();
	    	ProductBatch productBatchInfo = new ProductBatch();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productBatchInfo = productTrackingService.getProductBatchInfoByQrCode(qrCodeID, credentials);
	        return productBatchInfo;
    	} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while getting info", ex);
		}
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/id", produces = "application/json")
	@ApiOperation(value = "Get product info by product ID",
    notes = "This returns product basic info, including list of product batches, based on product ID.")

    public Product queryProductByProductID(@RequestParam String productID) throws Exception {
    	try {
    		Product productInfo = new Product();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productInfo = productTrackingService.getProductInfoByProductID(productID, credentials);  		
    		return productInfo;
    	} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while getting info", ex);
		}
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/trackinghistory", produces = "application/json")
	@ApiOperation(value = "Get product tracking history by QR code ID of the finished product",
    notes = "This returns tracking history.")

    public ProductTrackingHistory getProductTrackingHistory(@RequestParam String qrCodeID) throws Exception {
    	try {
	    	ProductTrackingHistory productTrackingHistoryInfo = new ProductTrackingHistory();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productTrackingHistoryInfo = productTrackingService.getProductTrackingHistory(qrCodeID, credentials);  	    	
	        return productTrackingHistoryInfo;
      	} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalServerError("Error while getting info", ex);
    	}    
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tracking", produces = "application/json")
	@ApiOperation(value = "Get product tracking details by Node ID and Product Batch No - bBatchNo",
    notes = "This returns tracking details at a particular node.")

    public ProductTracking getProductTrackingInfo(@RequestParam String nodeID, String productBatchNo) throws Exception {
    	try {
	    	ProductTracking productTrackingInfo = new ProductTracking();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productTrackingInfo = productTrackingService.getProductTracking(nodeID, productBatchNo, credentials);  	    	
	        return productTrackingInfo;
      	} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalServerError("Error while getting info", ex);
    	} 	        
    }
    
	@RequestMapping(method = RequestMethod.POST, path = "/product", produces = "application/json")
	@ApiOperation(value = "Create a new product.",
    notes = "Create a new product.")
	public TxHashResponse createProduct(@RequestBody Product product) {
		try {
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			TxHashResponse txHashResponse = productTrackingService.createProduct(product, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
    
	@RequestMapping(method = RequestMethod.POST, path = "/productbatch", produces = "application/json")
	@ApiOperation(value = "Create a new product batch.",
    notes = "Create a new product batch.")
	public TxHashResponse createProductBatch(@RequestBody ProductBatch productBatch) {
		try {
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			TxHashResponse txHashResponse = productTrackingService.createProductBatch(productBatch, credentials);
			return txHashResponse;

		} catch (Exception ex) {
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public class InternalServerError extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public InternalServerError(final String message, final Throwable cause) {
			super(message);
		}

	}

 
}

