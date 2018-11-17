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
public class RetailShopBatch extends Contract {
    private static final String BINARY = "0x6080604052606460165560016017556001601b553480156200002057600080fd5b506040516200174e3803806200174e833981016040528051602082015160008054600160a060020a031916331781556005839055920180519192909182919081106200006857fe5b602090810290910101516006558051819060019081106200008557fe5b60209081029091010151601c55805181906002908110620000a257fe5b60209081029091010151601d55805181906003908110620000bf57fe5b60209081029091010151601555805181906004908110620000dc57fe5b60209081029091010151600855805181906005908110620000f957fe5b602090810290910101516009558051819060069081106200011657fe5b60209081029091010151600a558051819060079081106200013357fe5b60209081029091010151600c558051819060089081106200015057fe5b60209081029091010151600d558051819060099081106200016d57fe5b60209081029091010151600e5580518190600a9081106200018a57fe5b60209081029091010151600b90815581518291908110620001a757fe5b60209081029091010151601e5580518190600c908110620001c457fe5b60209081029091010151601f5580518190600d908110620001e157fe5b60209081029091018101519055505042600f81905560105561154580620002096000396000f3006080604052600436106101ed5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae8381146101f2578063139d7fed1461021957806313febc361461022e5780631785f53c1461024357806317fc45e2146102665780631eee993a1461027b57806320982bce146102b057806327a099d8146102c85780632d200a061461032d5780632e943fbd1461034257806330e4b9111461035757806331ae450b1461036c5780633571ee3514610381578063516f279e1461039957806354fd4d50146103ae5780635ceccff4146103c3578063604080f7146103d857806370480275146103f657806371bc9d9a146104175780637f7650eb1461042f57806382aefefb1461044457806383240f831461045c5780638920c339146104745780638c8357361461048c5780638da5cb5b146104a15780639870d7fe146104d25780639ac80dce146104f35780639c6f2b2514610508578063a035b1fe146105fb578063aa15efc814610610578063ac8a584a14610625578063b26e642b14610646578063b2f4bdb01461065e578063c5ce391114610673578063df4857ec14610688578063f0935ec4146106a0578063f2fde38b146106b5578063f375d94a146106d6578063f4834bbc146106eb578063f78b0be014610700575b600080fd5b3480156101fe57600080fd5b50610207610715565b60408051918252519081900360200190f35b34801561022557600080fd5b5061020761071b565b34801561023a57600080fd5b50610207610721565b34801561024f57600080fd5b50610264600160a060020a0360043516610727565b005b34801561027257600080fd5b5061020761089d565b34801561028757600080fd5b5061029c600160a060020a03600435166108a3565b604080519115158252519081900360200190f35b3480156102bc57600080fd5b50610207600435610aee565b3480156102d457600080fd5b506102dd610b0d565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610319578181015183820152602001610301565b505050509050019250505060405180910390f35b34801561033957600080fd5b50610207610b70565b34801561034e57600080fd5b50610207610b76565b34801561036357600080fd5b50610207610b7c565b34801561037857600080fd5b506102dd610b82565b34801561038d57600080fd5b50610207600435610be2565b3480156103a557600080fd5b50610207610bf0565b3480156103ba57600080fd5b50610207610bf6565b3480156103cf57600080fd5b50610207610bfc565b3480156103e457600080fd5b5061029c600435602435604435610c02565b34801561040257600080fd5b50610264600160a060020a0360043516610d3d565b34801561042357600080fd5b5061029c600435610e40565b34801561043b57600080fd5b50610207610e7d565b34801561045057600080fd5b50610207600435610e83565b34801561046857600080fd5b50610207600435610e91565b34801561048057600080fd5b50610207600435610e9f565b34801561049857600080fd5b50610207610ead565b3480156104ad57600080fd5b506104b6610eb3565b60408051600160a060020a039092168252519081900360200190f35b3480156104de57600080fd5b50610264600160a060020a0360043516610ec2565b3480156104ff57600080fd5b50610207610fc3565b34801561051457600080fd5b5061051d610fc9565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b8381101561056557818101518382015260200161054d565b50505050905001848103835286818151815260200191508051906020019060200280838360005b838110156105a457818101518382015260200161058c565b50505050905001848103825285818151815260200191508051906020019060200280838360005b838110156105e35781810151838201526020016105cb565b50505050905001965050505050505060405180910390f35b34801561060757600080fd5b506102076110e1565b34801561061c57600080fd5b5061051d6110e7565b34801561063157600080fd5b50610264600160a060020a03600435166111f4565b34801561065257600080fd5b506104b660043561131c565b34801561066a57600080fd5b50610207611344565b34801561067f57600080fd5b5061020761134a565b34801561069457600080fd5b5061029c600435611350565b3480156106ac57600080fd5b5061020761141a565b3480156106c157600080fd5b50610264600160a060020a0360043516611420565b3480156106e257600080fd5b50610207611443565b3480156106f757600080fd5b50610207611449565b34801561070c57600080fd5b5061020761144f565b60155481565b60055481565b601d5481565b60008054600160a060020a0316331461073f57600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561076657600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156108995781600160a060020a03166004828154811015156107ab57fe5b600091825260209091200154600160a060020a03161415610891576004805460001981019081106107d857fe5b60009182526020909120015460048054600160a060020a0390921691839081106107fe57fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560048054600019019061084790826114d2565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610899565b600101610788565b5050565b601e5481565b60008054600160a060020a03163314806108cc57503360009081526001602052604090205460ff165b15156108d757600080fd5b601654601b541061094957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b601882600160a060020a031663f78b0be06040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156109a257600080fd5b505af11580156109b6573d6000803e3d6000fd5b505050506040513d60208110156109cc57600080fd5b505181546001810183556000928352602080842090910191909155604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051601993600160a060020a03871693637f7650eb936004808201949293918390030190829087803b158015610a4357600080fd5b505af1158015610a57573d6000803e3d6000fd5b505050506040513d6020811015610a6d57600080fd5b505181546001818101845560009384526020842090910191909155601a8054808301825592527f057c384a7d1c54f3a1b2e5e67b2617b8224fdfd1ea7234eea573a6ff665ff63e9091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19909116179055601b8054820190559050919050565b6014805482908110610afc57fe5b600091825260209091200154905081565b60606003805480602002602001604051908101604052809291908181526020018280548015610b6557602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610b47575b505050505090505b90565b60205481565b600c5481565b600d5481565b60606004805480602002602001604051908101604052809291908181526020018280548015610b6557602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610b47575050505050905090565b6018805482908110610afc57fe5b60095481565b60175481565b601c5481565b60008054600160a060020a0316331480610c2b57503360009081526001602052604090205460ff165b1515610c3657600080fd5b60008211610ca557604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b506012805460018082019092557fbb8a6a4669ba250d26cd7a459eca9d215f8307e33aebe50379bc5a3617ec34440193909355601380548085019091557f66de8ffda797e3de9c05e8fc57b3bf0ec28a930d40b0d285d93c06501cf6a09001919091556014805480840182556000919091527fce6d7b5282bd9a3661ae061feed1dbda4e52ab073b1f9285be6e155d9c38d4ec015590565b600054600160a060020a03163314610d5457600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610d7a57600080fd5b600454601411610d8957600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610e6957503360009081526001602052604090205460ff165b1515610e7457600080fd5b60119190915590565b60085481565b6019805482908110610afc57fe5b6012805482908110610afc57fe5b6013805482908110610afc57fe5b601b5481565b600054600160a060020a031681565b600054600160a060020a03163314610ed957600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610eff57600080fd5b600354601411610f0e57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60115481565b606080606060186019601a8280548060200260200160405190810160405280929190818152602001828054801561102057602002820191906000526020600020905b8154815260019091019060200180831161100b575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561107357602002820191906000526020600020905b8154815260019091019060200180831161105e575b50505050509150808054806020026020016040519081016040528092919081815260200182805480156110cf57602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116110b1575b50505050509050925092509250909192565b601f5481565b60608060606012601360148280548060200260200160405190810160405280929190818152602001828054801561113e57602002820191906000526020600020905b81548152600190910190602001808311611129575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561119157602002820191906000526020600020905b8154815260019091019060200180831161117c575b50505050509150808054806020026020016040519081016040528092919081815260200182805480156110cf57602002820191906000526020600020905b8154815260200190600101908083116111cf5750505050509050925092509250909192565b60008054600160a060020a0316331461120c57600080fd5b600160a060020a03821660009081526001602052604090205460ff16151561123357600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156108995781600160a060020a031660038281548110151561127857fe5b600091825260209091200154600160a060020a03161415611314576003805460001981019081106112a557fe5b60009182526020909120015460038054600160a060020a0390921691839081106112cb57fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560038054600019019061084790826114d2565b600101611255565b601a80548290811061132a57fe5b600091825260209091200154600160a060020a0316905081565b600f5481565b600a5481565b600080548190600160a060020a031633148061137b57503360009081526001602052604090205460ff165b151561138657600080fd5b5060005b6018548110156114145760188054849190839081106113a557fe5b600091825260209091200154141561140c5760186001601b54038154811015156113cb57fe5b90600052602060002001546018828154811015156113e557fe5b600091825260209091200155601b546018805490916000190190811061140757fe5b506000525b60010161138a565b50919050565b600b5481565b600054600160a060020a0316331461143757600080fd5b61144081611455565b50565b60105481565b600e5481565b60065481565b600160a060020a038116151561146a57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b8154818355818111156114f6576000838152602090206114f69181019083016114fb565b505050565b610b6d91905b808211156115155760008155600101611501565b50905600a165627a7a72305820f83373b351cef6bceda656ef3541ffacd47c40d324091fad614fd5b2934d576e0029";

    public static final String FUNC_BBATCHNO = "bBatchNo";

    public static final String FUNC_NODEID = "nodeId";

    public static final String FUNC_DBATCHNO = "dBatchNo";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_QUANTITY = "quantity";

    public static final String FUNC_ADDCHILD = "addChild";

    public static final String FUNC_TIMES = "times";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_WATERTEMPERATURE = "waterTemperature";

    public static final String FUNC_CONTAINERID = "containerId";

    public static final String FUNC_CONTAINERTYPE = "containerType";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_CHILDIDS = "childIds";

    public static final String FUNC_LOCATION = "location";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_DXQRCODEID = "dxQRCodeId";

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

    public static final String FUNC_PRICE = "price";

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
    protected RetailShopBatch(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RetailShopBatch(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RetailShopBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RetailShopBatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<Bytes32> quantity() {
        final Function function = new Function(FUNC_QUANTITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
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

    public RemoteCall<Bytes32> waterTemperature() {
        final Function function = new Function(FUNC_WATERTEMPERATURE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
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

    public RemoteCall<Bytes32> dxQRCodeId() {
        final Function function = new Function(FUNC_DXQRCODEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
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

    public RemoteCall<Bytes32> price() {
        final Function function = new Function(FUNC_PRICE, 
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

    public static RemoteCall<RetailShopBatch> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(RetailShopBatch.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RetailShopBatch> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(RetailShopBatch.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RetailShopBatch> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(RetailShopBatch.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RetailShopBatch> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Bytes32 _nodeId, DynamicArray<Bytes32> bArgs) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nodeId, bArgs));
        return deployRemoteCall(RetailShopBatch.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
    public static RetailShopBatch load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailShopBatch(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RetailShopBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailShopBatch(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RetailShopBatch load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RetailShopBatch(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RetailShopBatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RetailShopBatch(contractAddress, web3j, transactionManager, contractGasProvider);
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
