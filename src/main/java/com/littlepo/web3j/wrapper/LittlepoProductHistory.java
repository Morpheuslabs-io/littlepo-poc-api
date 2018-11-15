package com.littlepo.web3j.wrapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.StaticArray20;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class LittlepoProductHistory extends Contract {
    private static final String BINARY = "0x60806040526001601e5560008054600160a060020a0319163317905561144a8061002a6000396000f3006080604052600436106100b65763ffffffff60e060020a6000350416631785f53c81146100bb57806327a099d8146100de57806331ae450b1461014357806334083de71461015857806370480275146101905780638da5cb5b146101b15780639870d7fe146101e2578063a212cc8314610203578063ac8a584a1461021b578063d161b24a1461023c578063d89159911461025d578063e09c1e0514610275578063e29581aa14610290578063f2fde38b146102de575b600080fd5b3480156100c757600080fd5b506100dc600160a060020a03600435166102ff565b005b3480156100ea57600080fd5b506100f3610468565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561012f578181015183820152602001610117565b505050509050019250505060405180910390f35b34801561014f57600080fd5b506100f36104cb565b34801561016457600080fd5b5061017c600435600160a060020a036024351661052b565b604080519115158252519081900360200190f35b34801561019c57600080fd5b506100dc600160a060020a036004351661067b565b3480156101bd57600080fd5b506101c6610771565b60408051600160a060020a039092168252519081900360200190f35b3480156101ee57600080fd5b506100dc600160a060020a0360043516610780565b34801561020f57600080fd5b506101c6600435610874565b34801561022757600080fd5b506100dc600160a060020a036004351661088f565b34801561024857600080fd5b5061017c600160a060020a03600435166109aa565b34801561026957600080fd5b506100f3600435610cb6565b34801561028157600080fd5b506100f36004356024356111e4565b34801561029c57600080fd5b506102a56112e7565b604051808261028080838360005b838110156102cb5781810151838201526020016102b3565b5050505090500191505060405180910390f35b3480156102ea57600080fd5b506100dc600160a060020a0360043516611324565b60008054600160a060020a0316331461031757600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561033e57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156104645781600160a060020a031660048281548110151561038357fe5b600091825260209091200154600160a060020a0316141561045c576004805460001981019081106103b057fe5b60009182526020909120015460048054600160a060020a0390921691839081106103d657fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560048054600019019061041290826113b7565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610464565b600101610360565b5050565b606060038054806020026020016040519081016040528092919081815260200182805480156104c057602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116104a2575b505050505090505b90565b606060048054806020026020016040519081016040528092919081815260200182805480156104c057602002820191906000526020600020908154600160a060020a031681526001909101906020018083116104a2575050505050905090565b60008054600160a060020a031633148061055457503360009081526002602052604090205460ff165b151561055f57600080fd5b600160a060020a03821660009081526008602052604090205460ff16156105e757604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f4e6f646520697320616464656420616c72656164790000000000000000000000604482015290519081900360640190fd5b600160a060020a0382166000908152600760205260409020839055601e548390600a90600019016014811061061857fe5b0155600160a060020a0382166000818152600860209081526040808320805460ff1916600190811790915587845260099092529091208054600160a060020a031916909217909155601e8054909101905561067282610780565b50600192915050565b600054600160a060020a0316331461069257600080fd5b600160a060020a03811660009081526002602052604090205460ff16156106b857600080fd5b6004546014116106c757600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a031681565b600054600160a060020a0316331461079757600080fd5b600160a060020a03811660009081526001602052604090205460ff16156107bd57600080fd5b6003546014116107cc57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b600090815260056020526040902054600160a060020a031690565b60008054600160a060020a031633146108a757600080fd5b600160a060020a03821660009081526001602052604090205460ff1615156108ce57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156104645781600160a060020a031660038281548110151561091357fe5b600091825260209091200154600160a060020a031614156109a25760038054600019810190811061094057fe5b60009182526020909120015460038054600160a060020a03909216918390811061096657fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560038054600019019061041290826113b7565b6001016108f0565b600080548190600160a060020a03163314806109d557503360009081526001602052604090205460ff165b15156109e057600080fd5b600160a060020a0383161515610a5757604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b3360009081526008602052604090205460ff161515610ad757604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601d60248201527f596f7572206e6f6465206973206e6f7420726567697374657220796574000000604482015290519081900360640190fd5b6005600084600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610b1957600080fd5b505af1158015610b2d573d6000803e3d6000fd5b505050506040513d6020811015610b4357600080fd5b50518152602081019190915260400160002054600160a060020a03169050801515610c0857826005600085600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610bab57600080fd5b505af1158015610bbf573d6000803e3d6000fd5b505050506040513d6020811015610bd557600080fd5b5051815260208101919091526040016000208054600160a060020a031916600160a060020a039290921691909117905550815b3360009081526007602090815260408083205481517fb20d3ef300000000000000000000000000000000000000000000000000000000815260048101919091524260248201529051600160a060020a0385169363b20d3ef393604480850194919392918390030190829087803b158015610c8157600080fd5b505af1158015610c95573d6000803e3d6000fd5b505050506040513d6020811015610cab57600080fd5b506001949350505050565b60008181526005602090815260409182902054825160088082526101208201909452606093600160a060020a039092169284929082016101008038833901905050905081600160a060020a031663073fae836040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610d3757600080fd5b505af1158015610d4b573d6000803e3d6000fd5b505050506040513d6020811015610d6157600080fd5b5051815182906000908110610d7257fe5b6020908102909101810191909152604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692637f7650eb92600480820193918290030181600087803b158015610dd757600080fd5b505af1158015610deb573d6000803e3d6000fd5b505050506040513d6020811015610e0157600080fd5b5051815182906001908110610e1257fe5b6020908102909101810191909152604080517f516f279e0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263516f279e92600480820193918290030181600087803b158015610e7757600080fd5b505af1158015610e8b573d6000803e3d6000fd5b505050506040513d6020811015610ea157600080fd5b5051815182906002908110610eb257fe5b6020908102909101810191909152604080517fc5ce39110000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263c5ce391192600480820193918290030181600087803b158015610f1757600080fd5b505af1158015610f2b573d6000803e3d6000fd5b505050506040513d6020811015610f4157600080fd5b5051815182906003908110610f5257fe5b6020908102909101810191909152604080517ff0935ec40000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f0935ec492600480820193918290030181600087803b158015610fb757600080fd5b505af1158015610fcb573d6000803e3d6000fd5b505050506040513d6020811015610fe157600080fd5b5051815182906004908110610ff257fe5b6020908102909101810191909152604080517f2e943fbd0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692632e943fbd92600480820193918290030181600087803b15801561105757600080fd5b505af115801561106b573d6000803e3d6000fd5b505050506040513d602081101561108157600080fd5b505181518290600590811061109257fe5b6020908102909101810191909152604080517f30e4b9110000000000000000000000000000000000000000000000000000000081529051600160a060020a038516926330e4b91192600480820193918290030181600087803b1580156110f757600080fd5b505af115801561110b573d6000803e3d6000fd5b505050506040513d602081101561112157600080fd5b505181518290600690811061113257fe5b6020908102909101810191909152604080517ff4834bbc0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f4834bbc92600480820193918290030181600087803b15801561119757600080fd5b505af11580156111ab573d6000803e3d6000fd5b505050506040513d60208110156111c157600080fd5b50518151829060079081106111d257fe5b60209081029091010152915050919050565b6000818152600960205260408082205481517fd977e6be000000000000000000000000000000000000000000000000000000008152600481018690529151606093600160a060020a0390921692839263d977e6be9260248084019382900301818387803b15801561125457600080fd5b505af1158015611268573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052602081101561129157600080fd5b8101908080516401000000008111156112a957600080fd5b820160208101848111156112bc57600080fd5b81518560208202830111640100000000821117156112d957600080fd5b509098975050505050505050565b6112ef6113e0565b6040805161028081019182905290600a9060149082845b81548152600190910190602001808311611306575050505050905090565b600054600160a060020a0316331461133b57600080fd5b61134481611347565b50565b600160a060020a038116151561135c57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b8154818355818111156113db576000838152602090206113db918101908301611400565b505050565b610280604051908101604052806014906020820280388339509192915050565b6104c891905b8082111561141a5760008155600101611406565b50905600a165627a7a72305820ab44f0cb4bb53fcb0d08f7312c6f5d1f53d3f545ac1733340fbfcf617f3f25e00029";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_REGISTERNODE = "registerNode";

    public static final String FUNC_GETNODES = "getNodes";

    public static final String FUNC_GETPRODUCTBATCHBYBN = "getProductBatchByBN";

    public static final String FUNC_GETPRODUCTBATCHBYQR = "getProductBatchByQR";

    public static final String FUNC_GETBASEPRODUCBYQR = "getBaseProducByQR";

    public static final String FUNC_UPDATETRACKINGINFO = "updateTrackingInfo";

    public static final Event OPERATORADDED_EVENT = new Event("OperatorAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event ADMINADDED_EVENT = new Event("AdminAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event OWNERSHIPRENOUNCED_EVENT = new Event("OwnershipRenounced", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected LittlepoProductHistory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LittlepoProductHistory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LittlepoProductHistory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LittlepoProductHistory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> removeAdmin(Address admin) {
        final Function function = new Function(
                FUNC_REMOVEADMIN, 
                Arrays.<Type>asList(admin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<DynamicArray<Address>> getOperators() {
        final Function function = new Function(FUNC_GETOPERATORS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<DynamicArray<Address>> getAdmins() {
        final Function function = new Function(FUNC_GETADMINS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addAdmin(Address newAdmin) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(newAdmin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addOperator(Address newOperator) {
        final Function function = new Function(
                FUNC_ADDOPERATOR, 
                Arrays.<Type>asList(newOperator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeOperator(Address operator) {
        final Function function = new Function(
                FUNC_REMOVEOPERATOR, 
                Arrays.<Type>asList(operator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<OperatorAddedEventResponse> getOperatorAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OPERATORADDED_EVENT, transactionReceipt);
        ArrayList<OperatorAddedEventResponse> responses = new ArrayList<OperatorAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OperatorAddedEventResponse typedResponse = new OperatorAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newOperator = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OperatorAddedEventResponse> operatorAddedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OperatorAddedEventResponse>() {
            @Override
            public OperatorAddedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OPERATORADDED_EVENT, log);
                OperatorAddedEventResponse typedResponse = new OperatorAddedEventResponse();
                typedResponse.log = log;
                typedResponse.newOperator = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<OperatorAddedEventResponse> operatorAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATORADDED_EVENT));
        return operatorAddedEventObservable(filter);
    }

    public List<AdminAddedEventResponse> getAdminAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADMINADDED_EVENT, transactionReceipt);
        ArrayList<AdminAddedEventResponse> responses = new ArrayList<AdminAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AdminAddedEventResponse typedResponse = new AdminAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAdmin = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AdminAddedEventResponse> adminAddedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AdminAddedEventResponse>() {
            @Override
            public AdminAddedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADMINADDED_EVENT, log);
                AdminAddedEventResponse typedResponse = new AdminAddedEventResponse();
                typedResponse.log = log;
                typedResponse.newAdmin = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<AdminAddedEventResponse> adminAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINADDED_EVENT));
        return adminAddedEventObservable(filter);
    }

    public List<OwnershipRenouncedEventResponse> getOwnershipRenouncedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPRENOUNCED_EVENT, transactionReceipt);
        ArrayList<OwnershipRenouncedEventResponse> responses = new ArrayList<OwnershipRenouncedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (Address) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipRenouncedEventResponse> ownershipRenouncedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipRenouncedEventResponse>() {
            @Override
            public OwnershipRenouncedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPRENOUNCED_EVENT, log);
                OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (Address) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipRenouncedEventResponse> ownershipRenouncedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPRENOUNCED_EVENT));
        return ownershipRenouncedEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.newOwner = (Address) eventValues.getIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.newOwner = (Address) eventValues.getIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> registerNode(Bytes32 _nodeName, Address _baseNodeAddress) {
        final Function function = new Function(
                FUNC_REGISTERNODE, 
                Arrays.<Type>asList(_nodeName, _baseNodeAddress), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<StaticArray20<Bytes32>> getNodes() {
        final Function function = new Function(FUNC_GETNODES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray20<Bytes32>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<DynamicArray<Address>> getProductBatchByBN(Bytes32 _batchNo, Bytes32 _nodeId) {
        final Function function = new Function(FUNC_GETPRODUCTBATCHBYBN, 
                Arrays.<Type>asList(_batchNo, _nodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<DynamicArray<Bytes32>> getProductBatchByQR(Bytes32 _qrCodeId) {
        final Function function = new Function(FUNC_GETPRODUCTBATCHBYQR, 
                Arrays.<Type>asList(_qrCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> getBaseProducByQR(Bytes32 _qrCodeId) {
        final Function function = new Function(FUNC_GETBASEPRODUCBYQR, 
                Arrays.<Type>asList(_qrCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> updateTrackingInfo(Address _baseProduct) {
        final Function function = new Function(
                FUNC_UPDATETRACKINGINFO, 
                Arrays.<Type>asList(_baseProduct), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LittlepoProductHistory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoProductHistory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoProductHistory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoProductHistory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LittlepoProductHistory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoProductHistory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoProductHistory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoProductHistory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static LittlepoProductHistory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoProductHistory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LittlepoProductHistory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoProductHistory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LittlepoProductHistory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LittlepoProductHistory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LittlepoProductHistory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LittlepoProductHistory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OperatorAddedEventResponse {
        public Log log;

        public Address newOperator;

        public Bool isAdd;
    }

    public static class AdminAddedEventResponse {
        public Log log;

        public Address newAdmin;

        public Bool isAdd;
    }

    public static class OwnershipRenouncedEventResponse {
        public Log log;

        public Address previousOwner;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public Address previousOwner;

        public Address newOwner;
    }
}
