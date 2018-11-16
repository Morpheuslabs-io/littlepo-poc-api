package com.littlepo.web3j.wrapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class LittlepoProductTracking extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055611108806100256000396000f3006080604052600436106100e55763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631785f53c81146100ea57806327a099d81461010d5780632d7477041461017257806331ae450b146102685780633a85c2f41461027d57806370480275146102b25780638da5cb5b146102d35780639870d7fe14610304578063ac8a584a14610325578063ae76fab714610346578063d3286d5d14610367578063d89159911461037c578063e09c1e0514610394578063e29581aa146103af578063f2fde38b146103c4578063f62eb417146103e5575b600080fd5b3480156100f657600080fd5b5061010b600160a060020a03600435166103fa565b005b34801561011957600080fd5b50610122610563565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561015e578181015183820152602001610146565b505050509050019250505060405180910390f35b34801561017e57600080fd5b5061018a6004356105c6565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156101d25781810151838201526020016101ba565b50505050905001848103835286818151815260200191508051906020019060200280838360005b838110156102115781810151838201526020016101f9565b50505050905001848103825285818151815260200191508051906020019060200280838360005b83811015610250578181015183820152602001610238565b50505050905001965050505050505060405180910390f35b34801561027457600080fd5b506101226107eb565b34801561028957600080fd5b5061029e600160a060020a036004351661084b565b604080519115158252519081900360200190f35b3480156102be57600080fd5b5061010b600160a060020a036004351661091b565b3480156102df57600080fd5b506102e8610a11565b60408051600160a060020a039092168252519081900360200190f35b34801561031057600080fd5b5061010b600160a060020a0360043516610a20565b34801561033157600080fd5b5061010b600160a060020a0360043516610b14565b34801561035257600080fd5b5061029e600160a060020a0360043516610c2f565b34801561037357600080fd5b506102e8610cff565b34801561038857600080fd5b50610122600435610d0e565b3480156103a057600080fd5b50610122600435602435610e05565b3480156103bb57600080fd5b50610122610f04565b3480156103d057600080fd5b5061010b600160a060020a0360043516610ff3565b3480156103f157600080fd5b506102e8611016565b60008054600160a060020a0316331461041257600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561043957600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b60045481101561055f5781600160a060020a031660048281548110151561047e57fe5b600091825260209091200154600160a060020a03161415610557576004805460001981019081106104ab57fe5b60009182526020909120015460048054600160a060020a0390921691839081106104d157fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560048054600019019061050d9082611095565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a161055f565b60010161045b565b5050565b606060038054806020026020016040519081016040528092919081815260200182805480156105bb57602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161059d575b505050505090505b90565b600554604080517fa212cc8300000000000000000000000000000000000000000000000000000000815260048101849052905160609283928392600160a060020a039092169163a212cc83916024808201926020929091908290030181600087803b15801561063457600080fd5b505af1158015610648573d6000803e3d6000fd5b505050506040513d602081101561065e57600080fd5b5051604080517faa15efc80000000000000000000000000000000000000000000000000000000081529051600160a060020a039092169163aa15efc89160048082019260009290919082900301818387803b1580156106bc57600080fd5b505af11580156106d0573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405260608110156106f957600080fd5b81019080805164010000000081111561071157600080fd5b8201602081018481111561072457600080fd5b815185602082028301116401000000008211171561074157600080fd5b5050929190602001805164010000000081111561075d57600080fd5b8201602081018481111561077057600080fd5b815185602082028301116401000000008211171561078d57600080fd5b505092919060200180516401000000008111156107a957600080fd5b820160208101848111156107bc57600080fd5b81518560208202830111640100000000821117156107d957600080fd5b50959a94995097509295505050505050565b606060048054806020026020016040519081016040528092919081815260200182805480156105bb57602002820191906000526020600020908154600160a060020a0316815260019091019060200180831161059d575050505050905090565b60008054600160a060020a031633148061087457503360009081526002602052604090205460ff165b151561087f57600080fd5b600160a060020a03821615156108f657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601f60248201527f496e76616c69642070726f6475637420666163746f7279206164647265737300604482015290519081900360640190fd5b5060068054600160a060020a038316600160a060020a03199091161790556001919050565b600054600160a060020a0316331461093257600080fd5b600160a060020a03811660009081526002602052604090205460ff161561095857600080fd5b60045460141161096757600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a031681565b600054600160a060020a03163314610a3757600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610a5d57600080fd5b600354601411610a6c57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b60008054600160a060020a03163314610b2c57600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610b5357600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b60035481101561055f5781600160a060020a0316600382815481101515610b9857fe5b600091825260209091200154600160a060020a03161415610c2757600380546000198101908110610bc557fe5b60009182526020909120015460038054600160a060020a039092169183908110610beb57fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560038054600019019061050d9082611095565b600101610b75565b60008054600160a060020a0316331480610c5857503360009081526002602052604090205460ff165b1515610c6357600080fd5b600160a060020a0382161515610cda57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f496e76616c696420686973746f72792061646472657373000000000000000000604482015290519081900360640190fd5b5060058054600160a060020a038316600160a060020a03199091161790556001919050565b600554600160a060020a031681565b600554604080517fd8915991000000000000000000000000000000000000000000000000000000008152600481018490529051606092600160a060020a03169163d891599191602480830192600092919082900301818387803b158015610d7457600080fd5b505af1158015610d88573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610db157600080fd5b810190808051640100000000811115610dc957600080fd5b82016020810184811115610ddc57600080fd5b8151856020820283011164010000000082111715610df957600080fd5b50909695505050505050565b600554604080517fe09c1e0500000000000000000000000000000000000000000000000000000000815260048101859052602481018490529051606092600160a060020a03169163e09c1e0591604480830192600092919082900301818387803b158015610e7257600080fd5b505af1158015610e86573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610eaf57600080fd5b810190808051640100000000811115610ec757600080fd5b82016020810184811115610eda57600080fd5b8151856020820283011164010000000082111715610ef757600080fd5b5090979650505050505050565b600554604080517fe29581aa0000000000000000000000000000000000000000000000000000000081529051606092600160a060020a03169163e29581aa91600480830192600092919082900301818387803b158015610f6357600080fd5b505af1158015610f77573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610fa057600080fd5b810190808051640100000000811115610fb857600080fd5b82016020810184811115610fcb57600080fd5b8151856020820283011164010000000082111715610fe857600080fd5b509094505050505090565b600054600160a060020a0316331461100a57600080fd5b61101381611025565b50565b600654600160a060020a031681565b600160a060020a038116151561103a57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b8154818355818111156110b9576000838152602090206110b99181019083016110be565b505050565b6105c391905b808211156110d857600081556001016110c4565b50905600a165627a7a72305820c7c2ccfdc70e0cba05bbac354f0b78a157c7422089c31f6dd6c4003228fb821f0029";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_LITTLEPOHISTORY = "littlepoHistory";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_PRODUCTFACTORY = "productFactory";

    public static final String FUNC_REGISTERHISTORY = "registerHistory";

    public static final String FUNC_REGISTERPRODUCTFACTORY = "registerProductFactory";

    public static final String FUNC_GETPRODUCTBATCHBYBN = "getProductBatchByBN";

    public static final String FUNC_GETPRODUCTBATCHBYQR = "getProductBatchByQR";

    public static final String FUNC_GETPRODUCTTRACKINGINFO = "getProductTrackingInfo";

    public static final String FUNC_GETNODES = "getNodes";

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
    protected LittlepoProductTracking(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LittlepoProductTracking(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LittlepoProductTracking(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LittlepoProductTracking(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<Address> littlepoHistory() {
        final Function function = new Function(FUNC_LITTLEPOHISTORY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> productFactory() {
        final Function function = new Function(FUNC_PRODUCTFACTORY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
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

    public RemoteCall<TransactionReceipt> registerHistory(Address _littlepoHistory) {
        final Function function = new Function(
                FUNC_REGISTERHISTORY, 
                Arrays.<Type>asList(_littlepoHistory), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerProductFactory(Address _productFactory) {
        final Function function = new Function(
                FUNC_REGISTERPRODUCTFACTORY, 
                Arrays.<Type>asList(_productFactory), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>>> getProductTrackingInfo(Bytes32 _qrCodeId) {
        final Function function = new Function(FUNC_GETPRODUCTTRACKINGINFO, 
                Arrays.<Type>asList(_qrCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>>>(
                new Callable<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>>>() {
                    @Override
                    public Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>>(
                                (DynamicArray<Bytes32>) results.get(0), 
                                (DynamicArray<Bytes32>) results.get(1), 
                                (DynamicArray<Uint256>) results.get(2));
                    }
                });
    }

    public RemoteCall<DynamicArray<Bytes32>> getNodes() {
        final Function function = new Function(FUNC_GETNODES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<LittlepoProductTracking> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoProductTracking.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoProductTracking> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoProductTracking.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LittlepoProductTracking> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoProductTracking.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoProductTracking> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoProductTracking.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static LittlepoProductTracking load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoProductTracking(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LittlepoProductTracking load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoProductTracking(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LittlepoProductTracking load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LittlepoProductTracking(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LittlepoProductTracking load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LittlepoProductTracking(contractAddress, web3j, transactionManager, contractGasProvider);
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
