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
    private static final String BINARY = "0x6080604052606460165560016017819055601b5560008054600160a060020a03191633179055611487806100346000396000f3006080604052600436106101b65763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae8381146101bb578063139d7fed146101e25780631785f53c146101f75780631eee993a1461021a57806320982bce1461024f57806327a099d8146102675780632e943fbd146102cc57806330e4b911146102e157806331ae450b146102f65780633571ee351461030b578063516f279e1461032357806354fd4d5014610338578063604080f71461034d578063704802751461036b57806371bc9d9a1461038c5780637f7650eb146103a457806382aefefb146103b957806383240f83146103d15780638920c339146103e95780638c835736146104015780638da5cb5b146104165780639870d7fe146104475780639ac80dce146104685780639c6f2b251461047d578063aa15efc814610570578063ac8a584a14610585578063b26e642b146105a6578063b2f4bdb0146105be578063c5ce3911146105d3578063df4857ec146105e8578063f0935ec414610600578063f2fde38b14610615578063f375d94a14610636578063f4834bbc1461064b578063f78b0be014610660575b600080fd5b3480156101c757600080fd5b506101d0610675565b60408051918252519081900360200190f35b3480156101ee57600080fd5b506101d061067b565b34801561020357600080fd5b50610218600160a060020a0360043516610681565b005b34801561022657600080fd5b5061023b600160a060020a03600435166107f7565b604080519115158252519081900360200190f35b34801561025b57600080fd5b506101d0600435610a42565b34801561027357600080fd5b5061027c610a61565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156102b85781810151838201526020016102a0565b505050509050019250505060405180910390f35b3480156102d857600080fd5b506101d0610ac4565b3480156102ed57600080fd5b506101d0610aca565b34801561030257600080fd5b5061027c610ad0565b34801561031757600080fd5b506101d0600435610b30565b34801561032f57600080fd5b506101d0610b3e565b34801561034457600080fd5b506101d0610b44565b34801561035957600080fd5b5061023b600435602435604435610b4a565b34801561037757600080fd5b50610218600160a060020a0360043516610c85565b34801561039857600080fd5b5061023b600435610d88565b3480156103b057600080fd5b506101d0610dc5565b3480156103c557600080fd5b506101d0600435610dcb565b3480156103dd57600080fd5b506101d0600435610dd9565b3480156103f557600080fd5b506101d0600435610de7565b34801561040d57600080fd5b506101d0610df5565b34801561042257600080fd5b5061042b610dfb565b60408051600160a060020a039092168252519081900360200190f35b34801561045357600080fd5b50610218600160a060020a0360043516610e0a565b34801561047457600080fd5b506101d0610f0b565b34801561048957600080fd5b50610492610f11565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156104da5781810151838201526020016104c2565b50505050905001848103835286818151815260200191508051906020019060200280838360005b83811015610519578181015183820152602001610501565b50505050905001848103825285818151815260200191508051906020019060200280838360005b83811015610558578181015183820152602001610540565b50505050905001965050505050505060405180910390f35b34801561057c57600080fd5b50610492611029565b34801561059157600080fd5b50610218600160a060020a0360043516611136565b3480156105b257600080fd5b5061042b60043561125e565b3480156105ca57600080fd5b506101d0611286565b3480156105df57600080fd5b506101d061128c565b3480156105f457600080fd5b5061023b600435611292565b34801561060c57600080fd5b506101d061135c565b34801561062157600080fd5b50610218600160a060020a0360043516611362565b34801561064257600080fd5b506101d0611385565b34801561065757600080fd5b506101d061138b565b34801561066c57600080fd5b506101d0611391565b60155481565b60055481565b60008054600160a060020a0316331461069957600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156106c057600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156107f35781600160a060020a031660048281548110151561070557fe5b600091825260209091200154600160a060020a031614156107eb5760048054600019810190811061073257fe5b60009182526020909120015460048054600160a060020a03909216918390811061075857fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906107a19082611414565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a16107f3565b6001016106e2565b5050565b60008054600160a060020a031633148061082057503360009081526001602052604090205460ff165b151561082b57600080fd5b601654601b541061089d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b601882600160a060020a031663f78b0be06040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156108f657600080fd5b505af115801561090a573d6000803e3d6000fd5b505050506040513d602081101561092057600080fd5b505181546001810183556000928352602080842090910191909155604080517f7f7650eb0000000000000000000000000000000000000000000000000000000081529051601993600160a060020a03871693637f7650eb936004808201949293918390030190829087803b15801561099757600080fd5b505af11580156109ab573d6000803e3d6000fd5b505050506040513d60208110156109c157600080fd5b505181546001818101845560009384526020842090910191909155601a8054808301825592527f057c384a7d1c54f3a1b2e5e67b2617b8224fdfd1ea7234eea573a6ff665ff63e9091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19909116179055601b8054820190559050919050565b6014805482908110610a5057fe5b600091825260209091200154905081565b60606003805480602002602001604051908101604052809291908181526020018280548015610ab957602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610a9b575b505050505090505b90565b600c5481565b600d5481565b60606004805480602002602001604051908101604052809291908181526020018280548015610ab957602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610a9b575050505050905090565b6018805482908110610a5057fe5b60095481565b60175481565b60008054600160a060020a0316331480610b7357503360009081526001602052604090205460ff165b1515610b7e57600080fd5b60008211610bed57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b506012805460018082019092557fbb8a6a4669ba250d26cd7a459eca9d215f8307e33aebe50379bc5a3617ec34440193909355601380548085019091557f66de8ffda797e3de9c05e8fc57b3bf0ec28a930d40b0d285d93c06501cf6a09001919091556014805480840182556000919091527fce6d7b5282bd9a3661ae061feed1dbda4e52ab073b1f9285be6e155d9c38d4ec015590565b600054600160a060020a03163314610c9c57600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610cc257600080fd5b600454601411610cd157600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610db157503360009081526001602052604090205460ff165b1515610dbc57600080fd5b60119190915590565b60085481565b6019805482908110610a5057fe5b6012805482908110610a5057fe5b6013805482908110610a5057fe5b601b5481565b600054600160a060020a031681565b600054600160a060020a03163314610e2157600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610e4757600080fd5b600354601411610e5657600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60115481565b606080606060186019601a82805480602002602001604051908101604052809291908181526020018280548015610f6857602002820191906000526020600020905b81548152600190910190602001808311610f53575b5050505050925081805480602002602001604051908101604052809291908181526020018280548015610fbb57602002820191906000526020600020905b81548152600190910190602001808311610fa6575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561101757602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610ff9575b50505050509050925092509250909192565b60608060606012601360148280548060200260200160405190810160405280929190818152602001828054801561108057602002820191906000526020600020905b8154815260019091019060200180831161106b575b50505050509250818054806020026020016040519081016040528092919081815260200182805480156110d357602002820191906000526020600020905b815481526001909101906020018083116110be575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561101757602002820191906000526020600020905b8154815260200190600101908083116111115750505050509050925092509250909192565b60008054600160a060020a0316331461114e57600080fd5b600160a060020a03821660009081526001602052604090205460ff16151561117557600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156107f35781600160a060020a03166003828154811015156111ba57fe5b600091825260209091200154600160a060020a03161415611256576003805460001981019081106111e757fe5b60009182526020909120015460038054600160a060020a03909216918390811061120d57fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906107a19082611414565b600101611197565b601a80548290811061126c57fe5b600091825260209091200154600160a060020a0316905081565b600f5481565b600a5481565b600080548190600160a060020a03163314806112bd57503360009081526001602052604090205460ff165b15156112c857600080fd5b5060005b6018548110156113565760188054849190839081106112e757fe5b600091825260209091200154141561134e5760186001601b540381548110151561130d57fe5b906000526020600020015460188281548110151561132757fe5b600091825260209091200155601b546018805490916000190190811061134957fe5b506000525b6001016112cc565b50919050565b600b5481565b600054600160a060020a0316331461137957600080fd5b61138281611397565b50565b60105481565b600e5481565b60065481565b600160a060020a03811615156113ac57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b8154818355818111156114385760008381526020902061143891810190830161143d565b505050565b610ac191905b808211156114575760008155600101611443565b50905600a165627a7a7230582065e36fd938f89b03bc8e1ae1a1cfd64e64ce5698e55c540ef99e352c4ebc530b0029";

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
