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
    private static final String BINARY = "0x60806040526001600d5560008054600160a060020a0319163317905561180d8061002a6000396000f3006080604052600436106100d75763ffffffff60e060020a6000350416631785f53c81146100dc5780631c345dec146100ff5780631ddba66c1461016757806327a099d81461019f57806331ae450b146101b457806334083de7146101c957806370480275146101ed5780638da5cb5b1461020e5780639870d7fe1461023f578063992b76da14610260578063a212cc8314610281578063ac8a584a14610299578063c924d9a8146102ba578063d8915991146102de578063e09c1e05146102f6578063e29581aa14610311578063f2fde38b14610326575b600080fd5b3480156100e857600080fd5b506100fd600160a060020a0360043516610347565b005b34801561010b57600080fd5b506101176004356104b0565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561015357818101518382015260200161013b565b505050509050019250505060405180910390f35b34801561017357600080fd5b5061018b600435600160a060020a0360243516610513565b604080519115158252519081900360200190f35b3480156101ab57600080fd5b50610117610671565b3480156101c057600080fd5b506101176106d4565b3480156101d557600080fd5b5061018b600435600160a060020a0360243516610734565b3480156101f957600080fd5b506100fd600160a060020a03600435166108cc565b34801561021a57600080fd5b506102236109c2565b60408051600160a060020a039092168252519081900360200190f35b34801561024b57600080fd5b506100fd600160a060020a03600435166109d1565b34801561026c57600080fd5b5061018b600160a060020a0360043516610ac5565b34801561028d57600080fd5b50610223600435610bb2565b3480156102a557600080fd5b506100fd600160a060020a0360043516610bcd565b3480156102c657600080fd5b5061018b600435600160a060020a0360243516610ce8565b3480156102ea57600080fd5b50610117600435610fc2565b34801561030257600080fd5b506101176004356024356114f0565b34801561031d57600080fd5b506101176115f3565b34801561033257600080fd5b506100fd600160a060020a036004351661164b565b60008054600160a060020a0316331461035f57600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561038657600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156104ac5781600160a060020a03166004828154811015156103cb57fe5b600091825260209091200154600160a060020a031614156104a4576004805460001981019081106103f857fe5b60009182526020909120015460048054600160a060020a03909216918390811061041e57fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560048054600019019061045a90826116de565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a16104ac565b6001016103a8565b5050565b60008181526007602090815260409182902080548351818402810184019094528084526060939283018282801561050757602002820191906000526020600020905b815481526001909101906020018083116104f2575b50505050509050919050565b6000805481908190600160a060020a031633148061054057503360009081526001602052604090205460ff165b151561054b57600080fd5b505060008381526007602090815260408083206008835281842082517ff78b0be00000000000000000000000000000000000000000000000000000000081529251919490938593600160a060020a0389169363f78b0be093600480840194938390030190829087803b1580156105c057600080fd5b505af11580156105d4573d6000803e3d6000fd5b505050506040513d60208110156105ea57600080fd5b50518154600180820184556000938452602080852090920192909255835491820184558383528083209091018054600160a060020a031916600160a060020a0388161790558682526007905260409020825461064891908490611707565b506000858152600860205260409020815461066591908390611757565b50600195945050505050565b606060038054806020026020016040519081016040528092919081815260200182805480156106c957602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116106ab575b505050505090505b90565b606060048054806020026020016040519081016040528092919081815260200182805480156106c957602002820191906000526020600020908154600160a060020a031681526001909101906020018083116106ab575050505050905090565b60008054600160a060020a031633148061075d57503360009081526002602052604090205460ff165b151561076857600080fd5b600160a060020a0382166000908152600a602052604090205460ff16156107d9576040805160e560020a62461bcd02815260206004820152601560248201527f4e6f646520697320616464656420616c72656164790000000000000000000000604482015290519081900360640190fd5b600c5460141015610834576040805160e560020a62461bcd02815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206e6f6465730000000000000000000000604482015290519081900360640190fd5b600160a060020a0382166000818152600960209081526040808320879055600c805460018082019092557fdf6966c971051c3d54ec59162606531493a51404a002842f56009d7e5cf4a8c701889055600a8352818420805460ff191682179055878452600b9092529091208054600160a060020a031916909217909155600d805490910190556108c3826109d1565b50600192915050565b600054600160a060020a031633146108e357600080fd5b600160a060020a03811660009081526002602052604090205460ff161561090957600080fd5b60045460141161091857600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a031681565b600054600160a060020a031633146109e857600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610a0e57600080fd5b600354601411610a1d57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b600080548190600160a060020a0316331480610af057503360009081526001602052604090205460ff165b1515610afb57600080fd5b5060005b600c54811015610bac5782600160a060020a0316639870d7fe600b6000600c85815481101515610b2b57fe5b600091825260208083209091015483528201929092526040908101822054815160e060020a63ffffffff8616028152600160a060020a03909116600482015290516024808301939282900301818387803b158015610b8857600080fd5b505af1158015610b9c573d6000803e3d6000fd5b505060019092019150610aff9050565b50919050565b600090815260056020526040902054600160a060020a031690565b60008054600160a060020a03163314610be557600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610c0c57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156104ac5781600160a060020a0316600382815481101515610c5157fe5b600091825260209091200154600160a060020a03161415610ce057600380546000198101908110610c7e57fe5b60009182526020909120015460038054600160a060020a039092169183908110610ca457fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560038054600019019061045a90826116de565b600101610c2e565b600080548190600160a060020a0316331480610d1357503360009081526001602052604090205460ff165b1515610d1e57600080fd5b600160a060020a0383161515610d7e576040805160e560020a62461bcd02815260206004820152601460248201527f496e76616c69642070726f647563742074696d65000000000000000000000000604482015290519081900360640190fd5b336000908152600a602052604090205460ff161515610de7576040805160e560020a62461bcd02815260206004820152601d60248201527f596f7572206e6f6465206973206e6f7420726567697374657220796574000000604482015290519081900360640190fd5b6005600084600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610e2957600080fd5b505af1158015610e3d573d6000803e3d6000fd5b505050506040513d6020811015610e5357600080fd5b50518152602081019190915260400160002054600160a060020a03169050801515610f1857826005600085600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610ebb57600080fd5b505af1158015610ecf573d6000803e3d6000fd5b505050506040513d6020811015610ee557600080fd5b5051815260208101919091526040016000208054600160a060020a031916600160a060020a039290921691909117905550815b3360009081526009602090815260408083205481517f604080f70000000000000000000000000000000000000000000000000000000081526004810191909152602481018890524260448201529051600160a060020a0385169363604080f793606480850194919392918390030190829087803b158015610f9857600080fd5b505af1158015610fac573d6000803e3d6000fd5b505050506040513d602081101561066557600080fd5b60008181526005602090815260409182902054825160088082526101208201909452606093600160a060020a039092169284929082016101008038833901905050905081600160a060020a031663073fae836040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561104357600080fd5b505af1158015611057573d6000803e3d6000fd5b505050506040513d602081101561106d57600080fd5b505181518290600090811061107e57fe5b6020908102909101810191909152604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692637f7650eb92600480820193918290030181600087803b1580156110e357600080fd5b505af11580156110f7573d6000803e3d6000fd5b505050506040513d602081101561110d57600080fd5b505181518290600190811061111e57fe5b6020908102909101810191909152604080517f516f279e0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263516f279e92600480820193918290030181600087803b15801561118357600080fd5b505af1158015611197573d6000803e3d6000fd5b505050506040513d60208110156111ad57600080fd5b50518151829060029081106111be57fe5b6020908102909101810191909152604080517fc5ce39110000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263c5ce391192600480820193918290030181600087803b15801561122357600080fd5b505af1158015611237573d6000803e3d6000fd5b505050506040513d602081101561124d57600080fd5b505181518290600390811061125e57fe5b6020908102909101810191909152604080517ff0935ec40000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f0935ec492600480820193918290030181600087803b1580156112c357600080fd5b505af11580156112d7573d6000803e3d6000fd5b505050506040513d60208110156112ed57600080fd5b50518151829060049081106112fe57fe5b6020908102909101810191909152604080517f2e943fbd0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692632e943fbd92600480820193918290030181600087803b15801561136357600080fd5b505af1158015611377573d6000803e3d6000fd5b505050506040513d602081101561138d57600080fd5b505181518290600590811061139e57fe5b6020908102909101810191909152604080517f30e4b9110000000000000000000000000000000000000000000000000000000081529051600160a060020a038516926330e4b91192600480820193918290030181600087803b15801561140357600080fd5b505af1158015611417573d6000803e3d6000fd5b505050506040513d602081101561142d57600080fd5b505181518290600690811061143e57fe5b6020908102909101810191909152604080517ff4834bbc0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f4834bbc92600480820193918290030181600087803b1580156114a357600080fd5b505af11580156114b7573d6000803e3d6000fd5b505050506040513d60208110156114cd57600080fd5b50518151829060079081106114de57fe5b60209081029091010152915050919050565b6000818152600b60205260408082205481517fd977e6be000000000000000000000000000000000000000000000000000000008152600481018690529151606093600160a060020a0390921692839263d977e6be9260248084019382900301818387803b15801561156057600080fd5b505af1158015611574573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052602081101561159d57600080fd5b8101908080516401000000008111156115b557600080fd5b820160208101848111156115c857600080fd5b81518560208202830111640100000000821117156115e557600080fd5b509098975050505050505050565b6060600c8054806020026020016040519081016040528092919081815260200182805480156106c957602002820191906000526020600020905b8154815260019091019060200180831161162d575050505050905090565b600054600160a060020a0316331461166257600080fd5b61166b8161166e565b50565b600160a060020a038116151561168357600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b815481835581811115611702576000838152602090206117029181019083016117a3565b505050565b8280548282559060005260206000209081019282156117475760005260206000209182015b8281111561174757825482559160010191906001019061172c565b506117539291506117a3565b5090565b8280548282559060005260206000209081019282156117975760005260206000209182015b8281111561179757825482559160010191906001019061177c565b506117539291506117bd565b6106d191905b8082111561175357600081556001016117a9565b6106d191905b80821115611753578054600160a060020a03191681556001016117c35600a165627a7a7230582028e2a751875e80f7e02e5be6967733633260db2452ea4ab0fd2fe3c3946129470029";

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

    public static final String FUNC_ADDCHILDFORPRODUCTBATCH = "addChildForProductBatch";

    public static final String FUNC_GETCHILDSOFPRODUCTBATCH = "getChildsOfProductBatch";

    public static final String FUNC_SHAREOPERATOR = "shareOperator";

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

    public RemoteCall<DynamicArray<Bytes32>> getNodes() {
        final Function function = new Function(FUNC_GETNODES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
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

    public RemoteCall<TransactionReceipt> updateTrackingInfo(Bytes32 _parentQrCodeId, Address _baseProduct) {
        final Function function = new Function(
                FUNC_UPDATETRACKINGINFO, 
                Arrays.<Type>asList(_parentQrCodeId, _baseProduct), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addChildForProductBatch(Bytes32 _parentQRCodeId, Address _child) {
        final Function function = new Function(
                FUNC_ADDCHILDFORPRODUCTBATCH, 
                Arrays.<Type>asList(_parentQRCodeId, _child), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<DynamicArray<Bytes32>> getChildsOfProductBatch(Bytes32 _parentQRCodeId) {
        final Function function = new Function(FUNC_GETCHILDSOFPRODUCTBATCH, 
                Arrays.<Type>asList(_parentQRCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> shareOperator(Address _baseProduct) {
        final Function function = new Function(
                FUNC_SHAREOPERATOR, 
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
