package com.littlepo.web3j.wrapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
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
public class PackerBatch extends Contract {
    private static final String BINARY = "0x6080604052606460165560016017556001601b553480156200002057600080fd5b506040516200168538038062001685833981016040528051602082015160008054600160a060020a031916331781556005839055920180519192909182919081106200006857fe5b602090810290910101516006558051819060019081106200008557fe5b60209081029091010151601d55805181906002908110620000a257fe5b60209081029091010151601555805181906003908110620000bf57fe5b60209081029091010151600855805181906004908110620000dc57fe5b60209081029091010151600955805181906005908110620000f957fe5b60209081029091010151600a558051819060069081106200011657fe5b60209081029091010151600c558051819060079081106200013357fe5b60209081029091010151600d558051819060089081106200015057fe5b60209081029091010151600e558051819060099081106200016d57fe5b60209081029091010151600b5580518190600a9081106200018a57fe5b60209081029091010151601c55505042600f8190556010556114d380620001b26000396000f3006080604052600436106101cc5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae8381146101d1578063139d7fed146101f857806313febc361461020d5780631785f53c146102225780631eee993a1461024557806320982bce1461027a57806327a099d8146102925780632e943fbd146102f757806330e4b9111461030c57806331ae450b146103215780633571ee3514610336578063516f279e1461034e57806354fd4d5014610363578063604080f714610378578063704802751461039657806371bc9d9a146103b75780637f7650eb146103cf57806382aefefb146103e457806383240f83146103fc5780638920c339146104145780638c8357361461042c5780638da5cb5b146104415780639870d7fe146104725780639ac80dce146104935780639c6f2b25146104a8578063a1aab33f1461059b578063aa15efc8146105b0578063ac8a584a146105c5578063b26e642b146105e6578063b2f4bdb0146105fe578063c5ce391114610613578063df4857ec14610628578063f0935ec414610640578063f2fde38b14610655578063f375d94a14610676578063f4834bbc1461068b578063f78b0be0146106a0575b600080fd5b3480156101dd57600080fd5b506101e66106b5565b60408051918252519081900360200190f35b34801561020457600080fd5b506101e66106bb565b34801561021957600080fd5b506101e66106c1565b34801561022e57600080fd5b50610243600160a060020a03600435166106c7565b005b34801561025157600080fd5b50610266600160a060020a036004351661083d565b604080519115158252519081900360200190f35b34801561028657600080fd5b506101e6600435610a88565b34801561029e57600080fd5b506102a7610aa7565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156102e35781810151838201526020016102cb565b505050509050019250505060405180910390f35b34801561030357600080fd5b506101e6610b0a565b34801561031857600080fd5b506101e6610b10565b34801561032d57600080fd5b506102a7610b16565b34801561034257600080fd5b506101e6600435610b76565b34801561035a57600080fd5b506101e6610b84565b34801561036f57600080fd5b506101e6610b8a565b34801561038457600080fd5b50610266600435602435604435610b90565b3480156103a257600080fd5b50610243600160a060020a0360043516610ccb565b3480156103c357600080fd5b50610266600435610dce565b3480156103db57600080fd5b506101e6610e0b565b3480156103f057600080fd5b506101e6600435610e11565b34801561040857600080fd5b506101e6600435610e1f565b34801561042057600080fd5b506101e6600435610e2d565b34801561043857600080fd5b506101e6610e3b565b34801561044d57600080fd5b50610456610e41565b60408051600160a060020a039092168252519081900360200190f35b34801561047e57600080fd5b50610243600160a060020a0360043516610e50565b34801561049f57600080fd5b506101e6610f51565b3480156104b457600080fd5b506104bd610f57565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156105055781810151838201526020016104ed565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561054457818101518382015260200161052c565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561058357818101518382015260200161056b565b50505050905001965050505050505060405180910390f35b3480156105a757600080fd5b506101e661106f565b3480156105bc57600080fd5b506104bd611075565b3480156105d157600080fd5b50610243600160a060020a0360043516611182565b3480156105f257600080fd5b506104566004356112aa565b34801561060a57600080fd5b506101e66112d2565b34801561061f57600080fd5b506101e66112d8565b34801561063457600080fd5b506102666004356112de565b34801561064c57600080fd5b506101e66113a8565b34801561066157600080fd5b50610243600160a060020a03600435166113ae565b34801561068257600080fd5b506101e66113d1565b34801561069757600080fd5b506101e66113d7565b3480156106ac57600080fd5b506101e66113dd565b60155481565b60055481565b601d5481565b60008054600160a060020a031633146106df57600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561070657600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156108395781600160a060020a031660048281548110151561074b57fe5b600091825260209091200154600160a060020a031614156108315760048054600019810190811061077857fe5b60009182526020909120015460048054600160a060020a03909216918390811061079e57fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906107e79082611460565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610839565b600101610728565b5050565b60008054600160a060020a031633148061086657503360009081526001602052604090205460ff165b151561087157600080fd5b601654601b54106108e357604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b601882600160a060020a031663f78b0be06040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561093c57600080fd5b505af1158015610950573d6000803e3d6000fd5b505050506040513d602081101561096657600080fd5b505181546001810183556000928352602080842090910191909155604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051601993600160a060020a03871693637f7650eb936004808201949293918390030190829087803b1580156109dd57600080fd5b505af11580156109f1573d6000803e3d6000fd5b505050506040513d6020811015610a0757600080fd5b505181546001818101845560009384526020842090910191909155601a8054808301825592527f057c384a7d1c54f3a1b2e5e67b2617b8224fdfd1ea7234eea573a6ff665ff63e9091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19909116179055601b8054820190559050919050565b6014805482908110610a9657fe5b600091825260209091200154905081565b60606003805480602002602001604051908101604052809291908181526020018280548015610aff57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610ae1575b505050505090505b90565b600c5481565b600d5481565b60606004805480602002602001604051908101604052809291908181526020018280548015610aff57602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610ae1575050505050905090565b6018805482908110610a9657fe5b60095481565b60175481565b60008054600160a060020a0316331480610bb957503360009081526001602052604090205460ff165b1515610bc457600080fd5b60008211610c3357604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b506012805460018082019092557fbb8a6a4669ba250d26cd7a459eca9d215f8307e33aebe50379bc5a3617ec34440193909355601380548085019091557f66de8ffda797e3de9c05e8fc57b3bf0ec28a930d40b0d285d93c06501cf6a09001919091556014805480840182556000919091527fce6d7b5282bd9a3661ae061feed1dbda4e52ab073b1f9285be6e155d9c38d4ec015590565b600054600160a060020a03163314610ce257600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610d0857600080fd5b600454601411610d1757600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610df757503360009081526001602052604090205460ff165b1515610e0257600080fd5b60119190915590565b60085481565b6019805482908110610a9657fe5b6012805482908110610a9657fe5b6013805482908110610a9657fe5b601b5481565b600054600160a060020a031681565b600054600160a060020a03163314610e6757600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610e8d57600080fd5b600354601411610e9c57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60115481565b606080606060186019601a82805480602002602001604051908101604052809291908181526020018280548015610fae57602002820191906000526020600020905b81548152600190910190602001808311610f99575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561100157602002820191906000526020600020905b81548152600190910190602001808311610fec575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561105d57602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161103f575b50505050509050925092509250909192565b601c5481565b6060806060601260136014828054806020026020016040519081016040528092919081815260200182805480156110cc57602002820191906000526020600020905b815481526001909101906020018083116110b7575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561111f57602002820191906000526020600020905b8154815260019091019060200180831161110a575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561105d57602002820191906000526020600020905b81548152602001906001019080831161115d5750505050509050925092509250909192565b60008054600160a060020a0316331461119a57600080fd5b600160a060020a03821660009081526001602052604090205460ff1615156111c157600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156108395781600160a060020a031660038281548110151561120657fe5b600091825260209091200154600160a060020a031614156112a25760038054600019810190811061123357fe5b60009182526020909120015460038054600160a060020a03909216918390811061125957fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906107e79082611460565b6001016111e3565b601a8054829081106112b857fe5b600091825260209091200154600160a060020a0316905081565b600f5481565b600a5481565b600080548190600160a060020a031633148061130957503360009081526001602052604090205460ff165b151561131457600080fd5b5060005b6018548110156113a257601880548491908390811061133357fe5b600091825260209091200154141561139a5760186001601b540381548110151561135957fe5b906000526020600020015460188281548110151561137357fe5b600091825260209091200155601b546018805490916000190190811061139557fe5b506000525b600101611318565b50919050565b600b5481565b600054600160a060020a031633146113c557600080fd5b6113ce816113e3565b50565b60105481565b600e5481565b60065481565b600160a060020a03811615156113f857600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b81548183558181111561148457600083815260209020611484918101908301611489565b505050565b610b0791905b808211156114a3576000815560010161148f565b50905600a165627a7a72305820ebe457b28eca7f5e8f7f41230b04cef39f69a406c78ae7632e67f500c69c886d0029";

    public static final String FUNC_BBATCHNO = "bBatchNo";

    public static final String FUNC_NODEID = "nodeId";

    public static final String FUNC_DBATCHNO = "dBatchNo";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_ADDCHILD = "addChild";

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

    public static final String FUNC_GETLISTCHILDS = "getListChilds";

    public static final String FUNC_WEIGHT = "weight";

    public static final String FUNC_GETHISTORY = "getHistory";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_CHILDADDRESS = "childAddress";

    public static final String FUNC_CREATEDTIME = "createdTime";

    public static final String FUNC_PRODUCTID = "productId";

    public static final String FUNC_REMOVECHILD = "removeChild";

    public static final String FUNC_PRODUCERID = "producerId";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DATETIMEIN = "dateTimeIn";

    public static final String FUNC_LEGALENTITY = "legalEntity";

    public static final String FUNC_QRCODEID = "qrCodeId";

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
    protected PackerBatch(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PackerBatch(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PackerBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PackerBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<Bytes32> dBatchNo() {
        final Function function = new Function(FUNC_DBATCHNO, 
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

    public RemoteCall<TransactionReceipt> addChild(Address _child) {
        final Function function = new Function(
                FUNC_ADDCHILD, 
                Arrays.<Type>asList(_child), 
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

    public RemoteCall<Bytes32> weight() {
        final Function function = new Function(FUNC_WEIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
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

    public RemoteCall<TransactionReceipt> removeChild(Bytes32 _childId) {
        final Function function = new Function(
                FUNC_REMOVECHILD, 
                Arrays.<Type>asList(_childId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public static RemoteCall<PackerBatch> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(PackerBatch.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PackerBatch> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(PackerBatch.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PackerBatch> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(PackerBatch.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PackerBatch> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(PackerBatch.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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

    @Deprecated
    public static PackerBatch load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PackerBatch(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PackerBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PackerBatch(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PackerBatch load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PackerBatch(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PackerBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PackerBatch(contractAddress, web3j, transactionManager, contractGasProvider);
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
