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
import org.web3j.tuples.generated.Tuple2;
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
    private static final String BINARY = "0x60806040526001600d5560008054600160a060020a03191633179055611a938061002a6000396000f3006080604052600436106100e25763ffffffff60e060020a60003504166315451e7c81146100e75780631785f53c146101165780631c345dec146101395780631ddba66c146101a157806327a099d8146101c557806331ae450b146101da57806334083de7146101ef57806370480275146102135780638da5cb5b146102345780639870d7fe14610265578063992b76da14610286578063a212cc83146102a7578063ac8a584a146102bf578063c924d9a8146102e0578063d891599114610304578063e09c1e0514610377578063e29581aa14610392578063f2fde38b146103a7575b600080fd5b3480156100f357600080fd5b506101026004356024356103c8565b604080519115158252519081900360200190f35b34801561012257600080fd5b50610137600160a060020a03600435166104a1565b005b34801561014557600080fd5b5061015160043561060a565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561018d578181015183820152602001610175565b505050509050019250505060405180910390f35b3480156101ad57600080fd5b50610102600435600160a060020a036024351661066d565b3480156101d157600080fd5b506101516107cb565b3480156101e657600080fd5b5061015161082e565b3480156101fb57600080fd5b50610102600435600160a060020a036024351661088e565b34801561021f57600080fd5b50610137600160a060020a0360043516610a26565b34801561024057600080fd5b50610249610b1c565b60408051600160a060020a039092168252519081900360200190f35b34801561027157600080fd5b50610137600160a060020a0360043516610b2b565b34801561029257600080fd5b50610102600160a060020a0360043516610c1f565b3480156102b357600080fd5b50610249600435610d0c565b3480156102cb57600080fd5b50610137600160a060020a0360043516610d27565b3480156102ec57600080fd5b50610102600435600160a060020a0360243516610e42565b34801561031057600080fd5b5061031c60043561111c565b6040518080602001838152602001828103825284818151815260200191508051906020019060200280838360005b8381101561036257818101518382015260200161034a565b50505050905001935050505060405180910390f35b34801561038357600080fd5b50610151600435602435611776565b34801561039e57600080fd5b50610151611879565b3480156103b357600080fd5b50610137600160a060020a03600435166118d1565b60008054600160a060020a03163314806103f157503360009081526001602052604090205460ff165b15156103fc57600080fd5b60008381526005602090815260408083205481517f187fdb6d000000000000000000000000000000000000000000000000000000008152600481018790529151600160a060020a039091169363187fdb6d93602480850194919392918390030190829087803b15801561046e57600080fd5b505af1158015610482573d6000803e3d6000fd5b505050506040513d602081101561049857600080fd5b50519392505050565b60008054600160a060020a031633146104b957600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156104e057600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156106065781600160a060020a031660048281548110151561052557fe5b600091825260209091200154600160a060020a031614156105fe5760048054600019810190811061055257fe5b60009182526020909120015460048054600160a060020a03909216918390811061057857fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556004805460001901906105b49082611964565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610606565b600101610502565b5050565b60008181526007602090815260409182902080548351818402810184019094528084526060939283018282801561066157602002820191906000526020600020905b8154815260019091019060200180831161064c575b50505050509050919050565b6000805481908190600160a060020a031633148061069a57503360009081526001602052604090205460ff165b15156106a557600080fd5b505060008381526007602090815260408083206008835281842082517ff78b0be00000000000000000000000000000000000000000000000000000000081529251919490938593600160a060020a0389169363f78b0be093600480840194938390030190829087803b15801561071a57600080fd5b505af115801561072e573d6000803e3d6000fd5b505050506040513d602081101561074457600080fd5b50518154600180820184556000938452602080852090920192909255835491820184558383528083209091018054600160a060020a031916600160a060020a038816179055868252600790526040902082546107a29190849061198d565b50600085815260086020526040902081546107bf919083906119dd565b50600195945050505050565b6060600380548060200260200160405190810160405280929190818152602001828054801561082357602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610805575b505050505090505b90565b6060600480548060200260200160405190810160405280929190818152602001828054801561082357602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610805575050505050905090565b60008054600160a060020a03163314806108b757503360009081526002602052604090205460ff165b15156108c257600080fd5b600160a060020a0382166000908152600a602052604090205460ff1615610933576040805160e560020a62461bcd02815260206004820152601560248201527f4e6f646520697320616464656420616c72656164790000000000000000000000604482015290519081900360640190fd5b600c546014101561098e576040805160e560020a62461bcd02815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206e6f6465730000000000000000000000604482015290519081900360640190fd5b600160a060020a0382166000818152600960209081526040808320879055600c805460018082019092557fdf6966c971051c3d54ec59162606531493a51404a002842f56009d7e5cf4a8c701889055600a8352818420805460ff191682179055878452600b9092529091208054600160a060020a031916909217909155600d80549091019055610a1d82610b2b565b50600192915050565b600054600160a060020a03163314610a3d57600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610a6357600080fd5b600454601411610a7257600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a031681565b600054600160a060020a03163314610b4257600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610b6857600080fd5b600354601411610b7757600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b600080548190600160a060020a0316331480610c4a57503360009081526001602052604090205460ff165b1515610c5557600080fd5b5060005b600c54811015610d065782600160a060020a0316639870d7fe600b6000600c85815481101515610c8557fe5b600091825260208083209091015483528201929092526040908101822054815160e060020a63ffffffff8616028152600160a060020a03909116600482015290516024808301939282900301818387803b158015610ce257600080fd5b505af1158015610cf6573d6000803e3d6000fd5b505060019092019150610c599050565b50919050565b600090815260056020526040902054600160a060020a031690565b60008054600160a060020a03163314610d3f57600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610d6657600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156106065781600160a060020a0316600382815481101515610dab57fe5b600091825260209091200154600160a060020a03161415610e3a57600380546000198101908110610dd857fe5b60009182526020909120015460038054600160a060020a039092169183908110610dfe57fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556003805460001901906105b49082611964565b600101610d88565b600080548190600160a060020a0316331480610e6d57503360009081526001602052604090205460ff165b1515610e7857600080fd5b600160a060020a0383161515610ed8576040805160e560020a62461bcd02815260206004820152601460248201527f496e76616c69642070726f647563742074696d65000000000000000000000000604482015290519081900360640190fd5b336000908152600a602052604090205460ff161515610f41576040805160e560020a62461bcd02815260206004820152601d60248201527f596f7572206e6f6465206973206e6f7420726567697374657220796574000000604482015290519081900360640190fd5b6005600084600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610f8357600080fd5b505af1158015610f97573d6000803e3d6000fd5b505050506040513d6020811015610fad57600080fd5b50518152602081019190915260400160002054600160a060020a0316905080151561107257826005600085600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561101557600080fd5b505af1158015611029573d6000803e3d6000fd5b505050506040513d602081101561103f57600080fd5b5051815260208101919091526040016000208054600160a060020a031916600160a060020a039290921691909117905550815b3360009081526009602090815260408083205481517f604080f70000000000000000000000000000000000000000000000000000000081526004810191909152602481018890524260448201529051600160a060020a0385169363604080f793606480850194919392918390030190829087803b1580156110f257600080fd5b505af1158015611106573d6000803e3d6000fd5b505050506040513d60208110156107bf57600080fd5b60008181526005602090815260408083205481516009808252610140820190935260609493600160a060020a0390921692859282016101208038833901905050905081600160a060020a031663073fae836040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561119c57600080fd5b505af11580156111b0573d6000803e3d6000fd5b505050506040513d60208110156111c657600080fd5b50518151829060009081106111d757fe5b6020908102909101810191909152604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692637f7650eb92600480820193918290030181600087803b15801561123c57600080fd5b505af1158015611250573d6000803e3d6000fd5b505050506040513d602081101561126657600080fd5b505181518290600190811061127757fe5b6020908102909101810191909152604080517f516f279e0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263516f279e92600480820193918290030181600087803b1580156112dc57600080fd5b505af11580156112f0573d6000803e3d6000fd5b505050506040513d602081101561130657600080fd5b505181518290600290811061131757fe5b6020908102909101810191909152604080517fc5ce39110000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263c5ce391192600480820193918290030181600087803b15801561137c57600080fd5b505af1158015611390573d6000803e3d6000fd5b505050506040513d60208110156113a657600080fd5b50518151829060039081106113b757fe5b6020908102909101810191909152604080517ff0935ec40000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f0935ec492600480820193918290030181600087803b15801561141c57600080fd5b505af1158015611430573d6000803e3d6000fd5b505050506040513d602081101561144657600080fd5b505181518290600490811061145757fe5b6020908102909101810191909152604080517f2e943fbd0000000000000000000000000000000000000000000000000000000081529051600160a060020a03851692632e943fbd92600480820193918290030181600087803b1580156114bc57600080fd5b505af11580156114d0573d6000803e3d6000fd5b505050506040513d60208110156114e657600080fd5b50518151829060059081106114f757fe5b6020908102909101810191909152604080517f30e4b9110000000000000000000000000000000000000000000000000000000081529051600160a060020a038516926330e4b91192600480820193918290030181600087803b15801561155c57600080fd5b505af1158015611570573d6000803e3d6000fd5b505050506040513d602081101561158657600080fd5b505181518290600690811061159757fe5b6020908102909101810191909152604080517ff4834bbc0000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263f4834bbc92600480820193918290030181600087803b1580156115fc57600080fd5b505af1158015611610573d6000803e3d6000fd5b505050506040513d602081101561162657600080fd5b505181518290600790811061163757fe5b6020908102909101810191909152604080517feb2c89a30000000000000000000000000000000000000000000000000000000081529051600160a060020a0385169263eb2c89a392600480820193918290030181600087803b15801561169c57600080fd5b505af11580156116b0573d6000803e3d6000fd5b505050506040513d60208110156116c657600080fd5b50518151829060089081106116d757fe5b6020908102909101810191909152604080517fb2f4bdb000000000000000000000000000000000000000000000000000000000815290518392600160a060020a0386169263b2f4bdb092600480830193928290030181600087803b15801561173e57600080fd5b505af1158015611752573d6000803e3d6000fd5b505050506040513d602081101561176857600080fd5b505190945092505050915091565b6000818152600b60205260408082205481517fd977e6be000000000000000000000000000000000000000000000000000000008152600481018690529151606093600160a060020a0390921692839263d977e6be9260248084019382900301818387803b1580156117e657600080fd5b505af11580156117fa573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052602081101561182357600080fd5b81019080805164010000000081111561183b57600080fd5b8201602081018481111561184e57600080fd5b815185602082028301116401000000008211171561186b57600080fd5b509098975050505050505050565b6060600c80548060200260200160405190810160405280929190818152602001828054801561082357602002820191906000526020600020905b815481526001909101906020018083116118b3575050505050905090565b600054600160a060020a031633146118e857600080fd5b6118f1816118f4565b50565b600160a060020a038116151561190957600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b81548183558181111561198857600083815260209020611988918101908301611a29565b505050565b8280548282559060005260206000209081019282156119cd5760005260206000209182015b828111156119cd5782548255916001019190600101906119b2565b506119d9929150611a29565b5090565b828054828255906000526020600020908101928215611a1d5760005260206000209182015b82811115611a1d578254825591600101919060010190611a02565b506119d9929150611a43565b61082b91905b808211156119d95760008155600101611a2f565b61082b91905b808211156119d9578054600160a060020a0319168155600101611a495600a165627a7a72305820dd1056935cabff200398f0cebe4c2bb15306c1d8c775da4df83cc7c6fa5a83b40029";

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

    public static final String FUNC_SETTXHASH = "setTxHash";

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

    public RemoteCall<Tuple2<DynamicArray<Bytes32>, Uint256>> getProductBatchByQR(Bytes32 _qrCodeId) {
        final Function function = new Function(FUNC_GETPRODUCTBATCHBYQR, 
                Arrays.<Type>asList(_qrCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<DynamicArray<Bytes32>, Uint256>>(
                new Callable<Tuple2<DynamicArray<Bytes32>, Uint256>>() {
                    @Override
                    public Tuple2<DynamicArray<Bytes32>, Uint256> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<DynamicArray<Bytes32>, Uint256>(
                                (DynamicArray<Bytes32>) results.get(0), 
                                (Uint256) results.get(1));
                    }
                });
    }

    public RemoteCall<Address> getBaseProducByQR(Bytes32 _qrCodeId) {
        final Function function = new Function(FUNC_GETBASEPRODUCBYQR, 
                Arrays.<Type>asList(_qrCodeId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> setTxHash(Bytes32 _qrCodeId, Bytes32 _txHash) {
        final Function function = new Function(
                FUNC_SETTXHASH, 
                Arrays.<Type>asList(_qrCodeId, _txHash), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
