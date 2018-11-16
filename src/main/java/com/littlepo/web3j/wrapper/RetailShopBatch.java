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
    private static final String BINARY = "0x6080604052606460165560016017556001601b553480156200002057600080fd5b506040516200171a3803806200171a833981016040528051602082015160008054600160a060020a031916331781556005839055920180519192909182919081106200006857fe5b602090810290910101516006558051819060019081106200008557fe5b60209081029091010151601c55805181906002908110620000a257fe5b60209081029091010151601d55805181906003908110620000bf57fe5b60209081029091010151601555805181906004908110620000dc57fe5b60209081029091010151600855805181906005908110620000f957fe5b602090810290910101516009558051819060069081106200011657fe5b60209081029091010151600a558051819060079081106200013357fe5b60209081029091010151600c558051819060089081106200015057fe5b60209081029091010151600d558051819060099081106200016d57fe5b60209081029091010151600e5580518190600a9081106200018a57fe5b60209081029091010151600b90815581518291908110620001a757fe5b60209081029091010151601e5580518190600c908110620001c457fe5b60209081029091010151601f5580518190600d908110620001e157fe5b60209081029091018101519055505042600f81905560105561151180620002096000396000f3006080604052600436106101d45763ffffffff60e060020a600035041663073fae8381146101d9578063139d7fed1461020057806313febc36146102155780631785f53c1461022a57806317fc45e21461024d5780631eee993a1461026257806320982bce1461029757806327a099d8146102af5780632d200a06146103145780632e943fbd1461032957806330e4b9111461033e57806331ae450b146103535780633571ee3514610368578063516f279e1461038057806354fd4d50146103955780635ceccff4146103aa578063604080f7146103bf57806370480275146103dd57806371bc9d9a146103fe5780637f7650eb1461041657806382aefefb1461042b57806383240f83146104435780638920c3391461045b5780638c835736146104735780638da5cb5b146104885780639870d7fe146104b95780639ac80dce146104da5780639c6f2b25146104ef578063a035b1fe146105e2578063aa15efc8146105f7578063ac8a584a1461060c578063b26e642b1461062d578063b2f4bdb014610645578063c5ce39111461065a578063df4857ec1461066f578063f0935ec414610687578063f2fde38b1461069c578063f375d94a146106bd578063f4834bbc146106d2578063f78b0be0146106e7575b600080fd5b3480156101e557600080fd5b506101ee6106fc565b60408051918252519081900360200190f35b34801561020c57600080fd5b506101ee610702565b34801561022157600080fd5b506101ee610708565b34801561023657600080fd5b5061024b600160a060020a036004351661070e565b005b34801561025957600080fd5b506101ee610884565b34801561026e57600080fd5b50610283600160a060020a036004351661088a565b604080519115158252519081900360200190f35b3480156102a357600080fd5b506101ee600435610aba565b3480156102bb57600080fd5b506102c4610ad9565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156103005781810151838201526020016102e8565b505050509050019250505060405180910390f35b34801561032057600080fd5b506101ee610b3c565b34801561033557600080fd5b506101ee610b42565b34801561034a57600080fd5b506101ee610b48565b34801561035f57600080fd5b506102c4610b4e565b34801561037457600080fd5b506101ee600435610bae565b34801561038c57600080fd5b506101ee610bbc565b3480156103a157600080fd5b506101ee610bc2565b3480156103b657600080fd5b506101ee610bc8565b3480156103cb57600080fd5b50610283600435602435604435610bce565b3480156103e957600080fd5b5061024b600160a060020a0360043516610d09565b34801561040a57600080fd5b50610283600435610e0c565b34801561042257600080fd5b506101ee610e49565b34801561043757600080fd5b506101ee600435610e4f565b34801561044f57600080fd5b506101ee600435610e5d565b34801561046757600080fd5b506101ee600435610e6b565b34801561047f57600080fd5b506101ee610e79565b34801561049457600080fd5b5061049d610e7f565b60408051600160a060020a039092168252519081900360200190f35b3480156104c557600080fd5b5061024b600160a060020a0360043516610e8e565b3480156104e657600080fd5b506101ee610f8f565b3480156104fb57600080fd5b50610504610f95565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b8381101561054c578181015183820152602001610534565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561058b578181015183820152602001610573565b50505050905001848103825285818151815260200191508051906020019060200280838360005b838110156105ca5781810151838201526020016105b2565b50505050905001965050505050505060405180910390f35b3480156105ee57600080fd5b506101ee6110ad565b34801561060357600080fd5b506105046110b3565b34801561061857600080fd5b5061024b600160a060020a03600435166111c0565b34801561063957600080fd5b5061049d6004356112e8565b34801561065157600080fd5b506101ee611310565b34801561066657600080fd5b506101ee611316565b34801561067b57600080fd5b5061028360043561131c565b34801561069357600080fd5b506101ee6113e6565b3480156106a857600080fd5b5061024b600160a060020a03600435166113ec565b3480156106c957600080fd5b506101ee61140f565b3480156106de57600080fd5b506101ee611415565b3480156106f357600080fd5b506101ee61141b565b60155481565b60055481565b601d5481565b60008054600160a060020a0316331461072657600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561074d57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156108805781600160a060020a031660048281548110151561079257fe5b600091825260209091200154600160a060020a03161415610878576004805460001981019081106107bf57fe5b60009182526020909120015460048054600160a060020a0390921691839081106107e557fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560048054600019019061082e908261149e565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610880565b60010161076f565b5050565b601e5481565b60008054600160a060020a03163314806108b357503360009081526001602052604090205460ff165b15156108be57600080fd5b601654601b541061093057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b81600160a060020a031663f78b0be06040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561096e57600080fd5b505af1158015610982573d6000803e3d6000fd5b505050506040513d602081101561099857600080fd5b5051601b54601880549091600019019081106109b057fe5b90600052602060002001816000191690555081600160a060020a0316637f7650eb6040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610a0057600080fd5b505af1158015610a14573d6000803e3d6000fd5b505050506040513d6020811015610a2a57600080fd5b5051601b5460198054909160001901908110610a4257fe5b6000918252602082200191909155601a805460018181018355919092527f057c384a7d1c54f3a1b2e5e67b2617b8224fdfd1ea7234eea573a6ff665ff63e9091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19909116179055601b8054820190559050919050565b6014805482908110610ac857fe5b600091825260209091200154905081565b60606003805480602002602001604051908101604052809291908181526020018280548015610b3157602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610b13575b505050505090505b90565b60205481565b600c5481565b600d5481565b60606004805480602002602001604051908101604052809291908181526020018280548015610b3157602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610b13575050505050905090565b6018805482908110610ac857fe5b60095481565b60175481565b601c5481565b60008054600160a060020a0316331480610bf757503360009081526001602052604090205460ff165b1515610c0257600080fd5b60008211610c7157604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601460248201527f496e76616c696420686973746f72792074696d65000000000000000000000000604482015290519081900360640190fd5b506012805460018082019092557fbb8a6a4669ba250d26cd7a459eca9d215f8307e33aebe50379bc5a3617ec34440193909355601380548085019091557f66de8ffda797e3de9c05e8fc57b3bf0ec28a930d40b0d285d93c06501cf6a09001919091556014805480840182556000919091527fce6d7b5282bd9a3661ae061feed1dbda4e52ab073b1f9285be6e155d9c38d4ec015590565b600054600160a060020a03163314610d2057600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610d4657600080fd5b600454601411610d5557600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610e3557503360009081526001602052604090205460ff165b1515610e4057600080fd5b60119190915590565b60085481565b6019805482908110610ac857fe5b6012805482908110610ac857fe5b6013805482908110610ac857fe5b601b5481565b600054600160a060020a031681565b600054600160a060020a03163314610ea557600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610ecb57600080fd5b600354601411610eda57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60115481565b606080606060186019601a82805480602002602001604051908101604052809291908181526020018280548015610fec57602002820191906000526020600020905b81548152600190910190602001808311610fd7575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561103f57602002820191906000526020600020905b8154815260019091019060200180831161102a575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561109b57602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161107d575b50505050509050925092509250909192565b601f5481565b60608060606012601360148280548060200260200160405190810160405280929190818152602001828054801561110a57602002820191906000526020600020905b815481526001909101906020018083116110f5575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561115d57602002820191906000526020600020905b81548152600190910190602001808311611148575b505050505091508080548060200260200160405190810160405280929190818152602001828054801561109b57602002820191906000526020600020905b81548152602001906001019080831161119b5750505050509050925092509250909192565b60008054600160a060020a031633146111d857600080fd5b600160a060020a03821660009081526001602052604090205460ff1615156111ff57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156108805781600160a060020a031660038281548110151561124457fe5b600091825260209091200154600160a060020a031614156112e05760038054600019810190811061127157fe5b60009182526020909120015460038054600160a060020a03909216918390811061129757fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560038054600019019061082e908261149e565b600101611221565b601a8054829081106112f657fe5b600091825260209091200154600160a060020a0316905081565b600f5481565b600a5481565b600080548190600160a060020a031633148061134757503360009081526001602052604090205460ff165b151561135257600080fd5b5060005b6018548110156113e057601880548491908390811061137157fe5b60009182526020909120015414156113d85760186001601b540381548110151561139757fe5b90600052602060002001546018828154811015156113b157fe5b600091825260209091200155601b54601880549091600019019081106113d357fe5b506000525b600101611356565b50919050565b600b5481565b600054600160a060020a0316331461140357600080fd5b61140c81611421565b50565b60105481565b600e5481565b60065481565b600160a060020a038116151561143657600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b8154818355818111156114c2576000838152602090206114c29181019083016114c7565b505050565b610b3991905b808211156114e157600081556001016114cd565b50905600a165627a7a723058202de9f2701433d5b8ae896af6aa2ede7dd37635cfe02b74c22fa0415ce682fb840029";

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
