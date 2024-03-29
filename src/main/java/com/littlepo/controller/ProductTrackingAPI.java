package com.littlepo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.littlepo.data.NodeBdata;
import com.littlepo.data.NodeData;
import com.littlepo.data.NodeDdata;
import com.littlepo.data.NodeGdata;
import com.littlepo.data.NodeIdata;
import com.littlepo.data.ProductBatch;
import com.littlepo.data.blockchain.TxHashResponse;
import com.littlepo.service.ProductTrackingService;
import com.littlepo.utils.IDGenerator;
import com.littlepo.utils.UserAdmin;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product/")
public class ProductTrackingAPI {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(ProductTrackingAPI.class);
	
    @Autowired
	ProductTrackingService productTrackingService;
    
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-b", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-B of the supply chain process, this will create product batch no and QR codes",
    notes = "Track product info")
	public NodeBdata trackProductAtNodeB(@RequestBody NodeBdata nodeBdata) {
		try {
			log.info("Tracking at node B request {}",MAPPER.writeValueAsString(nodeBdata));
			
			NodeBdata nodeBdata1 = nodeBdata;
			
			String userID = nodeBdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			
			String productID = nodeBdata.getProductID();
			if (productID == null) {
				productID = "P";
			}
			String bBatchNo = IDGenerator.createBBatchNo(productID);
			String bQrCodeID = IDGenerator.createBQrCodeID();
			nodeBdata1.setBbatchNo(bBatchNo);
			nodeBdata1.setBQrCodeID(bQrCodeID);
			
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeB(nodeBdata1, credentials);
			productTrackingService.setTxHash(bQrCodeID, txHashResponse.getTxHash(), credentials);
			nodeBdata1.setTxHash(txHashResponse.getTxHash());
			nodeBdata1.setScAddress(txHashResponse.getContractAddress());
			return nodeBdata1;

		} catch (Exception ex) {
			log.info("There is error in creating tracking at node B", ex);
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-d", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-D of the supply chain process, this will create product batch no and QR codes",
    notes = "Track product info")
	public NodeDdata trackProductAtNodeD(@RequestBody NodeDdata nodeDdata) {
		try {
			log.info("Tracking at node D request {}", MAPPER.writeValueAsString(nodeDdata));
			
			NodeDdata nodeDdata1 = nodeDdata;
			String userID = nodeDdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			
			String productID = nodeDdata.getProductID();
			if (productID == null) {
				productID = "P";
			}
			String dBatchNo = IDGenerator.createDBatchNo(productID);
			String dQrCodeID = IDGenerator.createDQrCodeID();
			// String dxQrCodeID = IDGenerator.createDxQrCodeID();
			nodeDdata1.setDbatchNo(dBatchNo);
			nodeDdata1.setDQrCodeID(dQrCodeID);
			// nodeDdata1.setDxQrCodeID(dxQrCodeID);
			
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeD(nodeDdata1, credentials);
			productTrackingService.setTxHash(dQrCodeID, txHashResponse.getTxHash(), credentials);
			nodeDdata1.setTxHash(txHashResponse.getTxHash());
			nodeDdata1.setScAddress(txHashResponse.getContractAddress());
			return nodeDdata1;

		} catch (Exception ex) {
			log.info("There is error in creating tracking at node D", ex);
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-d/teabag", produces = "application/json")
	@ApiOperation(value = "Add tea bag at Node-D of the supply chain process, this will generate dxQrCodeId",
    notes = "Track product info")
	public NodeDdata addTeaBagAtNodeD(@RequestBody NodeDdata nodeDdata) {
		try {
			log.info("add Teabag at node D request {}", MAPPER.writeValueAsString(nodeDdata));
			
			NodeDdata nodeDdata1 = nodeDdata;
			String userID = nodeDdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			
			String dxQrCodeID = IDGenerator.createDxQrCodeID();
		    nodeDdata1.setDxQrCodeID(dxQrCodeID);
			
			TxHashResponse txHashResponse = productTrackingService.addTeaBagAtNodeD(nodeDdata1, credentials);
			productTrackingService.setTxHash(dxQrCodeID, txHashResponse.getTxHash(), credentials);
			nodeDdata1.setTxHash(txHashResponse.getTxHash());
			nodeDdata1.setScAddress(txHashResponse.getContractAddress());
			return nodeDdata1;

		} catch (Exception ex) {
			log.info("There is error in creating tracking at node D", ex);
			throw new InternalServerError("Error while adding tea bag", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-g", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-G of the supply chain process.",
    notes = "Track product info")
	public NodeGdata trackProductAtNodeG(@RequestBody NodeGdata nodeGdata) {
		try {
			log.info("Tracking product at node G request {}", MAPPER.writeValueAsString(nodeGdata));
			NodeGdata nodeGdata1 = nodeGdata;
			String userID = nodeGdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			
			String gQrCodeID = IDGenerator.createGQrCodeID();
			nodeGdata1.setGQrCodeID(gQrCodeID);
			
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeG(nodeGdata1, credentials);
			productTrackingService.setTxHash(gQrCodeID, txHashResponse.getTxHash(), credentials);
			nodeGdata1.setTxHash(txHashResponse.getTxHash());
			nodeGdata1.setScAddress(txHashResponse.getContractAddress());
			return nodeGdata1;

		} catch (Exception ex) {
			log.info("There is error in creating tracking at node G", ex);
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tracking/node-i", produces = "application/json")
	@ApiOperation(value = "Product Tracking at Node-I of the supply chain process",
    notes = "Track product info")
	public NodeIdata trackProductAtNodeI(@RequestBody NodeIdata nodeIdata) {
		try {
			log.info("Tracking product at node I request {}", MAPPER.writeValueAsString(nodeIdata));
			NodeIdata nodeIdata1 = nodeIdata;		
			
			String userID = nodeIdata.getUserID();
			Credentials credentials = new UserAdmin().getCredentials(userID);
			
			String iQrCodeID = IDGenerator.createIQrCodeID();
		    nodeIdata1.setIQrCodeID(iQrCodeID);
			
			TxHashResponse txHashResponse = productTrackingService.productTrackingAtNodeI(nodeIdata1, credentials);
			productTrackingService.setTxHash(iQrCodeID, txHashResponse.getTxHash(), credentials);
			nodeIdata1.setTxHash(txHashResponse.getTxHash());
			nodeIdata1.setScAddress(txHashResponse.getContractAddress());
			return nodeIdata1;

		} catch (Exception ex) {
			log.info("There is error in creating tracking at node I", ex);
			throw new InternalServerError("Error while tracking product info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tracking/node-b", produces = "application/json")
	@ApiOperation(value = "query product tracking at Node-B of the supply chain process",
    notes = "Query product tracking info at node B")
	public NodeBdata queryProductAtNodeB(@RequestParam String qrCodeID) {
		log.info("queryProductAtNodeB {}", qrCodeID);
		try {
			
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			NodeBdata nodeBdata = productTrackingService.queryProductTrackingAtNodeB(qrCodeID, credentials);
			return nodeBdata;

		} catch (NullPointerException ex) {
			log.info("There is no product batch for request qr {}", qrCodeID);
			throw new ResourceNotFound("ProductBatch Not Found", ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while query product tracking info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tracking/node-d", produces = "application/json")
	@ApiOperation(value = "query product tracking at Node-D of the supply chain process",
    notes = "Query product tracking info at node D")
	public NodeDdata queryProductAtNodeD(@RequestParam String qrCodeID) {
		log.info("queryProductAtNodeD {}", qrCodeID);
		try {
			
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			NodeDdata nodeDdata = productTrackingService.queryProductTrackingAtNodeD(qrCodeID, credentials);
			return nodeDdata;
		} catch (NullPointerException ex) {
			log.info("There is no product batch for request qr {}", qrCodeID);
			throw new ResourceNotFound("ProductBatch Not Found", ex);
		} catch (Exception ex) {
			log.info("queryProductAtNodeB error", ex);
			throw new InternalServerError("Error while query product tracking info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tracking/node-g", produces = "application/json")
	@ApiOperation(value = "query product tracking at Node-G of the supply chain process",
    notes = "Query product tracking info at node G")
	public NodeGdata queryProductAtNodeG(@RequestParam String qrCodeID) {
		log.info("queryProductAtNodeG {}", qrCodeID);
		try {
			
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			NodeGdata nodeGdata = productTrackingService.queryProductTrackingAtNodeG(qrCodeID, credentials);
			return nodeGdata;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerError("Error while query product tracking info", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tracking/node-i", produces = "application/json")
	@ApiOperation(value = "query product tracking at Node-G of the supply chain process",
    notes = "Query product tracking info at node I")
	public NodeIdata queryProductAtNodeI(@RequestParam String qrCodeID) {
		log.info("queryProductAtNodeI {}", qrCodeID);
		try {
			
			Credentials credentials = new UserAdmin().getDefaultCredentials();
			NodeIdata nodeIdata = productTrackingService.queryProductTrackingAtNodeI(qrCodeID, credentials);
			return nodeIdata;

		} catch (Exception ex) {
			log.info("queryProductAtNodeB error", ex);
			throw new InternalServerError("Error while query product tracking info", ex);
		}
	}
	
	/*
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
    */
    
    @RequestMapping(method = RequestMethod.GET, path = "/productbatch/qrcode", produces = "application/json")
	@ApiOperation(value = "Get product batch info by QR Code ID",
    notes = "This returns product batch info that is related to the QR code, based on QR code ID.")

    public ProductBatch getProductBatchByQRcode(@RequestParam String qrCodeID) throws Exception {
    	log.info("getProductBatchByQRcode {}", qrCodeID);
    	try {
	    	ProductBatch productBatchInfo = new ProductBatch();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	productBatchInfo = productTrackingService.getProductBatchInfoByQrCode(qrCodeID, credentials);
	        return productBatchInfo;
    	} catch (Exception ex) {
    		log.info("queryProductAtNodeB error", ex);
			throw new InternalServerError("Error while getting info", ex);
		}
    }
    
    /*
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
    */
    
    @RequestMapping(method = RequestMethod.GET, path = "/trackinghistory", produces = "application/json")
	@ApiOperation(value = "Get product tracking history (list of Nodes) by QR code ID of the finished product",
    notes = "This returns tracking history.")

    public List<NodeData> getProductTrackingHistory(@RequestParam String qrCodeID) throws Exception {
    	log.info("getProductTrackingHistory {}", qrCodeID);
    	try {
    		
	    	List<NodeData> listOfNodeData = new ArrayList<NodeData>();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	listOfNodeData = productTrackingService.getProductTrackingHistory(qrCodeID, credentials);  	    	
	        return listOfNodeData;
      	} catch (Exception ex) {
      		log.info("queryProductAtNodeB error", ex);
			throw new InternalServerError("Error while getting info", ex);
    	}    
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/children", produces = "application/json")
	@ApiOperation(value = "Get children of a product (list of QR code IDs of the children products), query by the QR code ID of the parent product",
    notes = "This returns a list of QR code IDs of the children products.")

    public List<String> getChildrenOfProduct (@RequestParam String parentQrCodeID) throws Exception {
    	log.info("getChildrenOfProduct {}", parentQrCodeID);
    	try {
    		
	    	List<String> listOfChildrenQrCodeIDs = new ArrayList<String>();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	listOfChildrenQrCodeIDs = productTrackingService.getChidrenOfProduct(parentQrCodeID, credentials);  	    	
	        return listOfChildrenQrCodeIDs ;
      	} catch (Exception ex) {
      		log.info("\"getChildrenOfProduct error", ex);
			throw new InternalServerError("Error while getChildrenOfProduct", ex);
    	}    
    }
    
    /*
    @RequestMapping(method = RequestMethod.GET, path = "/tracking", produces = "application/json")
	@ApiOperation(value = "Get product tracking details for a tea bag QR code",
    notes = "This returns tracking details at a particular node.")

    public ProductBatch getProductTrackingInfo(@RequestParam String nodeID, String dxQrCode) throws Exception {
    	try {
	    	ProductBatch productBatch = new ProductBatch();
	    	Credentials credentials = new UserAdmin().getDefaultCredentials();
	    	List<ProductBatch> listOfProductBatch = productTrackingService.getProductTracking(nodeID, productBatchNo, credentials);  	    	
	        return productTrackingInfo;
      	} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalServerError("Error while getting info", ex);
    	} 	        
    }
    */
	
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFound extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public ResourceNotFound(final String message, final Throwable cause) {
			super(message);
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

