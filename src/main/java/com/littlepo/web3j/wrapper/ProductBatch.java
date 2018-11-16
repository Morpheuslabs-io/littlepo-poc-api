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
public class ProductBatch extends Contract {
    private static final String BINARY = "0x6080604052606460165560016017819055601b5560008054600160a060020a03191633179055611453806100346000396000f30060806040526004361061019d5763ffffffff60e060020a600035041663073fae8381146101a2578063139d7fed146101c95780631785f53c146101de5780631eee993a1461020157806320982bce1461023657806327a099d81461024e5780632e943fbd146102b357806330e4b911146102c857806331ae450b146102dd5780633571ee35146102f2578063516f279e1461030a57806354fd4d501461031f578063604080f714610334578063704802751461035257806371bc9d9a146103735780637f7650eb1461038b57806382aefefb146103a057806383240f83146103b85780638920c339146103d05780638c835736146103e85780638da5cb5b146103fd5780639870d7fe1461042e5780639ac80dce1461044f5780639c6f2b2514610464578063aa15efc814610557578063ac8a584a1461056c578063b26e642b1461058d578063b2f4bdb0146105a5578063c5ce3911146105ba578063df4857ec146105cf578063f0935ec4146105e7578063f2fde38b146105fc578063f375d94a1461061d578063f4834bbc14610632578063f78b0be014610647575b600080fd5b3480156101ae57600080fd5b506101b761065c565b60408051918252519081900360200190f35b3480156101d557600080fd5b506101b7610662565b3480156101ea57600080fd5b506101ff600160a060020a0360043516610668565b005b34801561020d57600080fd5b50610222600160a060020a03600435166107de565b604080519115158252519081900360200190f35b34801561024257600080fd5b506101b7600435610a0e565b34801561025a57600080fd5b50610263610a2d565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561029f578181015183820152602001610287565b505050509050019250505060405180910390f35b3480156102bf57600080fd5b506101b7610a90565b3480156102d457600080fd5b506101b7610a96565b3480156102e957600080fd5b50610263610a9c565b3480156102fe57600080fd5b506101b7600435610afc565b34801561031657600080fd5b506101b7610b0a565b34801561032b57600080fd5b506101b7610b10565b34801561034057600080fd5b50610222600435602435604435610b16565b34801561035e57600080fd5b506101ff600160a060020a0360043516610c51565b34801561037f57600080fd5b50610222600435610d54565b34801561039757600080fd5b506101b7610d91565b3480156103ac57600080fd5b506101b7600435610d97565b3480156103c457600080fd5b506101b7600435610da5565b3480156103dc57600080fd5b506101b7600435610db3565b3480156103f457600080fd5b506101b7610dc1565b34801561040957600080fd5b50610412610dc7565b60408051600160a060020a039092168252519081900360200190f35b34801561043a57600080fd5b506101ff600160a060020a0360043516610dd6565b34801561045b57600080fd5b506101b7610ed7565b34801561047057600080fd5b50610479610edd565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156104c15781810151838201526020016104a9565b50505050905001848103835286818151815260200191508051906020019060200280838360005b838110156105005781810151838201526020016104e8565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561053f578181015183820152602001610527565b50505050905001965050505050505060405180910390f35b34801561056357600080fd5b50610479610ff5565b34801561057857600080fd5b506101ff600160a060020a0360043516611102565b34801561059957600080fd5b5061041260043561122a565b3480156105b157600080fd5b506101b7611252565b3480156105c657600080fd5b506101b7611258565b3480156105db57600080fd5b5061022260043561125e565b3480156105f357600080fd5b506101b7611328565b34801561060857600080fd5b506101ff600160a060020a036004351661132e565b34801561062957600080fd5b506101b7611351565b34801561063e57600080fd5b506101b7611357565b34801561065357600080fd5b506101b761135d565b60155481565b60055481565b60008054600160a060020a0316331461068057600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156106a757600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156107da5781600160a060020a03166004828154811015156106ec57fe5b600091825260209091200154600160a060020a031614156107d25760048054600019810190811061071957fe5b60009182526020909120015460048054600160a060020a03909216918390811061073f57fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560048054600019019061078890826113e0565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a16107da565b6001016106c9565b5050565b60008054600160a060020a031633148061080757503360009081526001602052604090205460ff165b151561081257600080fd5b601654601b541061088457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b81600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156108c257600080fd5b505af11580156108d6573d6000803e3d6000fd5b505050506040513d60208110156108ec57600080fd5b5051601b546018805490916000190190811061090457fe5b90600052602060002001816000191690555081600160a060020a0316637f7650eb6040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561095457600080fd5b505af1158015610968573d6000803e3d6000fd5b505050506040513d602081101561097e57600080fd5b5051601b546019805490916000190190811061099657fe5b6000918252602082200191909155601a805460018181018355919092527f057c384a7d1c54f3a1b2e5e67b2617b8224fdfd1ea7234eea573a6ff665ff63e9091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19909116179055601b8054820190559050919050565b6014805482908110610a1c57fe5b600091825260209091200154905081565b60606003805480602002602001604051908101604052809291908181526020018280548015610a8557602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610a67575b505050505090505b90565b600c5481565b600d5481565b60606004805480602002602001604051908101604052809291908181526020018280548015610a8557602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610a67575050505050905090565b6018805482908110610a1c57fe5b60095481565b60175481565b60008054600160a060020a0316331480610b3f57503360009081526001602052604090205460ff165b1515610b4a57600080fd5b60008211610bb957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b506012805460018082019092557fbb8a6a4669ba250d26cd7a459eca9d215f8307e33aebe50379bc5a3617ec34440193909355601380548085019091557f66de8ffda797e3de9c05e8fc57b3bf0ec28a930d40b0d285d93c06501cf6a09001919091556014805480840182556000919091527fce6d7b5282bd9a3661ae061feed1dbda4e52ab073b1f9285be6e155d9c38d4ec015590565b600054600160a060020a03163314610c6857600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610c8e57600080fd5b600454601411610c9d57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610d7d57503360009081526001602052604090205460ff165b1515610d8857600080fd5b60119190915590565b60085481565b6019805482908110610a1c57fe5b6012805482908110610a1c57fe5b6013805482908110610a1c57fe5b601b5481565b600054600160a060020a031681565b600054600160a060020a03163314610ded57600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610e1357600080fd5b600354601411610e2257600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60115481565b606080606060186019601a82805480602002602001604051908101604052809291908181526020018280548015610f3457602002820191906000526020600020905b81548152600190910190602001808311610f1f575b5050505050925081805480602002602001604051908101604052809291908181526020018280548015610f8757602002820191906000526020600020905b81548152600190910190602001808311610f72575b5050505050915080805480602002602001604051908101604052809291908181526020018280548015610fe357602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610fc5575b50505050509050925092509250909192565b60608060606012601360148280548060200260200160405190810160405280929190818152602001828054801561104c57602002820191906000526020600020905b81548152600190910190602001808311611037575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561109f57602002820191906000526020600020905b8154815260019091019060200180831161108a575b5050505050915080805480602002602001604051908101604052809291908181526020018280548015610fe357602002820191906000526020600020905b8154815260200190600101908083116110dd5750505050509050925092509250909192565b60008054600160a060020a0316331461111a57600080fd5b600160a060020a03821660009081526001602052604090205460ff16151561114157600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156107da5781600160a060020a031660038281548110151561118657fe5b600091825260209091200154600160a060020a03161415611222576003805460001981019081106111b357fe5b60009182526020909120015460038054600160a060020a0390921691839081106111d957fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560038054600019019061078890826113e0565b600101611163565b601a80548290811061123857fe5b600091825260209091200154600160a060020a0316905081565b600f5481565b600a5481565b600080548190600160a060020a031633148061128957503360009081526001602052604090205460ff165b151561129457600080fd5b5060005b6018548110156113225760188054849190839081106112b357fe5b600091825260209091200154141561131a5760186001601b54038154811015156112d957fe5b90600052602060002001546018828154811015156112f357fe5b600091825260209091200155601b546018805490916000190190811061131557fe5b506000525b600101611298565b50919050565b600b5481565b600054600160a060020a0316331461134557600080fd5b61134e81611363565b50565b60105481565b600e5481565b60065481565b600160a060020a038116151561137857600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b81548183558181111561140457600083815260209020611404918101908301611409565b505050565b610a8d91905b80821115611423576000815560010161140f565b50905600a165627a7a72305820deed963abfa41157cb85d5f9d3a6614f97ef881848a7cd4c7c8230719207a4c70029";

    public static final String FUNC_BBATCHNO = "bBatchNo";

    public static final String FUNC_NODEID = "nodeId";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_TIMES = "times";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_CONTAINERID = "containerId";

    public static final String FUNC_CONTAINERTYPE = "containerType";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_CHILDIDS = "childIds";

    public static final String FUNC_LOCATION = "location";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_ADDHISTORY = "addHistory";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_SETDATETIMEOUT = "setDateTimeOut";

    public static final String FUNC_PRODUCTNAME = "productName";

    public static final String FUNC_CHILDNAMES = "childNames";

    public static final String FUNC_ACTIONS = "actions";

    public static final String FUNC_PARENTNODEIDS = "parentNodeIds";

    public static final String FUNC_CHILDCOUNTER = "childCounter";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_DATETIMEOUT = "dateTimeOut";

    public static final String FUNC_GETHISTORY = "getHistory";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_CHILDADDRESS = "childAddress";

    public static final String FUNC_CREATEDTIME = "createdTime";

    public static final String FUNC_PRODUCTID = "productId";

    public static final String FUNC_PRODUCERID = "producerId";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DATETIMEIN = "dateTimeIn";

    public static final String FUNC_LEGALENTITY = "legalEntity";

    public static final String FUNC_QRCODEID = "qrCodeId";

    public static final String FUNC_ADDCHILD = "addChild";

    public static final String FUNC_REMOVECHILD = "removeChild";

    public static final String FUNC_GETLISTCHILDS = "getListChilds";

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
    protected ProductBatch(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductBatch(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Bytes32> bBatchNo() {
        final Function function = new Function(FUNC_BBATCHNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> nodeId() {
        final Function function = new Function(FUNC_NODEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> removeAdmin(Address admin) {
        final Function function = new Function(
                FUNC_REMOVEADMIN, 
                Arrays.<Type>asList(admin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> times(Uint256 param0) {
        final Function function = new Function(FUNC_TIMES, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<DynamicArray<Address>> getOperators() {
        final Function function = new Function(FUNC_GETOPERATORS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> containerId() {
        final Function function = new Function(FUNC_CONTAINERID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> containerType() {
        final Function function = new Function(FUNC_CONTAINERTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<DynamicArray<Address>> getAdmins() {
        final Function function = new Function(FUNC_GETADMINS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> childIds(Uint256 param0) {
        final Function function = new Function(FUNC_CHILDIDS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> location() {
        final Function function = new Function(FUNC_LOCATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addHistory(Bytes32 _action, Bytes32 parentQRCodeId, Uint256 _time) {
        final Function function = new Function(
                FUNC_ADDHISTORY, 
                Arrays.<Type>asList(_action, parentQRCodeId, _time), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addAdmin(Address newAdmin) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(newAdmin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDateTimeOut(Uint256 _timeOut) {
        final Function function = new Function(
                FUNC_SETDATETIMEOUT, 
                Arrays.<Type>asList(_timeOut), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Bytes32> productName() {
        final Function function = new Function(FUNC_PRODUCTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> childNames(Uint256 param0) {
        final Function function = new Function(FUNC_CHILDNAMES, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> actions(Uint256 param0) {
        final Function function = new Function(FUNC_ACTIONS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> parentNodeIds(Uint256 param0) {
        final Function function = new Function(FUNC_PARENTNODEIDS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> childCounter() {
        final Function function = new Function(FUNC_CHILDCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
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

    public RemoteCall<Uint256> dateTimeOut() {
        final Function function = new Function(FUNC_DATETIMEOUT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Uint256>>> getHistory() {
        final Function function = new Function(FUNC_GETHISTORY, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<TransactionReceipt> removeOperator(Address operator) {
        final Function function = new Function(
                FUNC_REMOVEOPERATOR, 
                Arrays.<Type>asList(operator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> childAddress(Uint256 param0) {
        final Function function = new Function(FUNC_CHILDADDRESS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> createdTime() {
        final Function function = new Function(FUNC_CREATEDTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> productId() {
        final Function function = new Function(FUNC_PRODUCTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> producerId() {
        final Function function = new Function(FUNC_PRODUCERID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> dateTimeIn() {
        final Function function = new Function(FUNC_DATETIMEIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> legalEntity() {
        final Function function = new Function(FUNC_LEGALENTITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> qrCodeId() {
        final Function function = new Function(FUNC_QRCODEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
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

    public RemoteCall<TransactionReceipt> addChild(Address _child) {
        final Function function = new Function(
                FUNC_ADDCHILD, 
                Arrays.<Type>asList(_child), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeChild(Bytes32 _childId) {
        final Function function = new Function(
                FUNC_REMOVECHILD, 
                Arrays.<Type>asList(_childId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Address>>> getListChilds() {
        final Function function = new Function(FUNC_GETLISTCHILDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Address>>>(
                new Callable<Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Address>>>() {
                    @Override
                    public Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Address>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<DynamicArray<Bytes32>, DynamicArray<Bytes32>, DynamicArray<Address>>(
                                (DynamicArray<Bytes32>) results.get(0), 
                                (DynamicArray<Bytes32>) results.get(1), 
                                (DynamicArray<Address>) results.get(2));
                    }
                });
    }

    public static RemoteCall<ProductBatch> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductBatch.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductBatch> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductBatch.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ProductBatch> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductBatch.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductBatch> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductBatch.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static ProductBatch load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductBatch(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductBatch(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductBatch load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProductBatch(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductBatch(contractAddress, web3j, transactionManager, contractGasProvider);
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
