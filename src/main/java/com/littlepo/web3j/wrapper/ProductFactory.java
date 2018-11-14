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
public class ProductFactory extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055611c60806100256000396000f3006080604052600436106100ae5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631785f53c81146100b357806327a099d8146100d657806331ae450b1461013b5780635cbd47e31461015057806370480275146101845780638da5cb5b146101a55780639163e47d146101ba5780639870d7fe146101f2578063a26ea49614610213578063ac8a584a1461022b578063f2fde38b1461024c575b600080fd5b3480156100bf57600080fd5b506100d4600160a060020a036004351661026d565b005b3480156100e257600080fd5b506100eb6103e3565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561012757818101518382015260200161010f565b505050509050019250505060405180910390f35b34801561014757600080fd5b506100eb610446565b34801561015c57600080fd5b506101686004356104a6565b60408051600160a060020a039092168252519081900360200190f35b34801561019057600080fd5b506100d4600160a060020a03600435166104c1565b3480156101b157600080fd5b506101686105c4565b3480156101c657600080fd5b506101de6004356024356044356064356084356105d3565b604080519115158252519081900360200190f35b3480156101fe57600080fd5b506100d4600160a060020a036004351661078c565b34801561021f57600080fd5b506100d460043561088d565b34801561023757600080fd5b506100d4600160a060020a03600435166109ef565b34801561025857600080fd5b506100d4600160a060020a0360043516610b17565b60008054600160a060020a0316331461028557600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156102ac57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156103df5781600160a060020a03166004828154811015156102f157fe5b600091825260209091200154600160a060020a031614156103d75760048054600019810190811061031e57fe5b60009182526020909120015460048054600160a060020a03909216918390811061034457fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560048054600019019061038d9082610bb7565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a16103df565b6001016102ce565b5050565b6060600380548060200260200160405190810160405280929190818152602001828054801561043b57602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161041d575b505050505090505b90565b6060600480548060200260200160405190810160405280929190818152602001828054801561043b57602002820191906000526020600020908154600160a060020a0316815260019091019060200180831161041d575050505050905090565b600090815260056020526040902054600160a060020a031690565b600054600160a060020a031633146104d857600080fd5b600160a060020a03811660009081526002602052604090205460ff16156104fe57600080fd5b60045460141161050d57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b600054600160a060020a031681565b60008054600160a060020a03163314806105fc57503360009081526002602052604090205460ff165b151561060757600080fd5b600086815260056020526040902054600160a060020a03161561068b57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601a60248201527f50726f64756374206973206164647265737320616c7265616479000000000000604482015290519081900360640190fd5b8585858585610698610be0565b948552602085019390935260408085019290925260608401526080830191909152519081900360a001906000f0801580156106d7573d6000803e3d6000fd5b506000878152600560209081526040808320805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039590951694909417909355600680546001810182559083527ff652222313e28459528d920b65115c16c04f3efc82aaedc97be59f3f377c0d3f0189905582518981529081019190915281517f30438058f33fd08a288a803c20a26c6c5f3ab7633784d6c814207d62418eebba929181900390910190a150600195945050505050565b600054600160a060020a031633146107a357600080fd5b600160a060020a03811660009081526001602052604090205460ff16156107c957600080fd5b6003546014116107d857600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a031633146108a557600080fd5b600082815260056020526040902054600160a060020a0316151561092a57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f496e76616c69642070726f647563742069640000000000000000000000000000604482015290519081900360640190fd5b5060005b6006548110156103df57600680548391908390811061094957fe5b60009182526020909120015414156109e75760068054600019810190811061096d57fe5b906000526020600020015460068281548110151561098757fe5b6000918252602090912001556006805460001901906109a69082610bb7565b50604080518381526000602082015281517f30438058f33fd08a288a803c20a26c6c5f3ab7633784d6c814207d62418eebba929181900390910190a16103df565b60010161092e565b60008054600160a060020a03163314610a0757600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610a2e57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156103df5781600160a060020a0316600382815481101515610a7357fe5b600091825260209091200154600160a060020a03161415610b0f57600380546000198101908110610aa057fe5b60009182526020909120015460038054600160a060020a039092169183908110610ac657fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560038054600019019061038d9082610bb7565b600101610a50565b600054600160a060020a03163314610b2e57600080fd5b610b3781610b3a565b50565b600160a060020a0381161515610b4f57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b815481835581811115610bdb57600083815260209020610bdb918101908301610bf0565b505050565b60405161102680610c0f83390190565b61044391905b80821115610c0a5760008155600101610bf6565b50905600608060405260646013556001601455600160de5534801561001f57600080fd5b5060405160a0806110268339810160409081528151602083015191830151606084015160809094015160008054600160a060020a03191633179055600b92909255600992909255600a91909155600d91909155600e5542601055610f9e806100886000396000f30060806040526004361061018a5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae83811461018f578063139d7fed146101b657806313febc36146101cb5780631785f53c146101e057806327a099d8146102035780632e943fbd1461026857806330e4b9111461027d57806331ae450b146102925780633571ee35146102a7578063516f279e146102bf57806354fd4d50146102d4578063635e778a146102e9578063704802751461032457806371bc9d9a146103455780637f7650eb1461035d57806382aefefb146103725780638c8357361461038a5780638da5cb5b1461039f5780639464da8e146103d05780639870d7fe146103e55780639ac80dce146104065780639c6f2b251461041b578063ac8a584a146104ae578063b26e642b146104cf578063b2f4bdb0146104e7578063c5ce3911146104fc578063df4857ec14610511578063f0935ec414610529578063f2fde38b1461053e578063f375d94a1461055f578063f4834bbc14610574575b600080fd5b34801561019b57600080fd5b506101a4610589565b60408051918252519081900360200190f35b3480156101c257600080fd5b506101a461058f565b3480156101d757600080fd5b506101a4610595565b3480156101ec57600080fd5b50610201600160a060020a036004351661059b565b005b34801561020f57600080fd5b50610218610711565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561025457818101518382015260200161023c565b505050509050019250505060405180910390f35b34801561027457600080fd5b506101a4610774565b34801561028957600080fd5b506101a461077a565b34801561029e57600080fd5b50610218610780565b3480156102b357600080fd5b506101a46004356107e0565b3480156102cb57600080fd5b506101a46107f4565b3480156102e057600080fd5b506101a46107fa565b3480156102f557600080fd5b50610310600435602435600160a060020a0360443516610800565b604080519115158252519081900360200190f35b34801561033057600080fd5b50610201600160a060020a0360043516610940565b34801561035157600080fd5b50610310600435610a43565b34801561036957600080fd5b506101a4610a80565b34801561037e57600080fd5b506101a4600435610a86565b34801561039657600080fd5b506101a4610a93565b3480156103ab57600080fd5b506103b4610a99565b60408051600160a060020a039092168252519081900360200190f35b3480156103dc57600080fd5b506101a4610aa8565b3480156103f157600080fd5b50610201600160a060020a0360043516610aae565b34801561041257600080fd5b506101a4610baf565b34801561042757600080fd5b50610430610bb5565b6040518083610c8080838360005b8381101561045657818101518382015260200161043e565b5050505090500180602001828103825283818151815260200191508051906020019060200280838360005b83811015610499578181015183820152602001610481565b50505050905001935050505060405180910390f35b3480156104ba57600080fd5b50610201600160a060020a0360043516610c5a565b3480156104db57600080fd5b506103b4600435610d82565b3480156104f357600080fd5b506101a4610daa565b34801561050857600080fd5b506101a4610db0565b34801561051d57600080fd5b50610310600435610db6565b34801561053557600080fd5b506101a4610e59565b34801561054a57600080fd5b50610201600160a060020a0360043516610e5f565b34801561056b57600080fd5b506101a4610e82565b34801561058057600080fd5b506101a4610e88565b60075481565b60055481565b60085481565b60008054600160a060020a031633146105b357600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156105da57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b60045481101561070d5781600160a060020a031660048281548110151561061f57fe5b600091825260209091200154600160a060020a031614156107055760048054600019810190811061064c57fe5b60009182526020909120015460048054600160a060020a03909216918390811061067257fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906106bb9082610f0b565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a161070d565b6001016105fc565b5050565b6060600380548060200260200160405190810160405280929190818152602001828054801561076957602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161074b575b505050505090505b90565b600d5481565b600e5481565b6060600480548060200260200160405190810160405280929190818152602001828054801561076957602002820191906000526020600020908154600160a060020a0316815260019091019060200180831161074b575050505050905090565b601581606481106107ed57fe5b0154905081565b600a5481565b60145481565b60008054600160a060020a031633148061082957503360009081526001602052604090205460ff165b151561083457600080fd5b60135460de54106108a657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b836015600160de54036064811015156108bb57fe5b015560de54839060799060001901606481106108d357fe5b01555060dd8054600181810183556000929092527fac507b9f8bf86ad8bb770f71cd2b1992902ae0314d93fc0f2bb011d70e796226018054600160a060020a03841673ffffffffffffffffffffffffffffffffffffffff1990911617905560de8054820190559392505050565b600054600160a060020a0316331461095757600080fd5b600160a060020a03811660009081526002602052604090205460ff161561097d57600080fd5b60045460141161098c57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610a6c57503360009081526001602052604090205460ff165b1515610a7757600080fd5b60129190915590565b60095481565b607981606481106107ed57fe5b60de5481565b600054600160a060020a031681565b60065481565b600054600160a060020a03163314610ac557600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610aeb57600080fd5b600354601411610afa57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60125481565b610bbd610f34565b60408051610c8081019182905260609160799160dd91839060649082845b81548152600190910190602001808311610bdb575050505050915080805480602002602001604051908101604052809291908181526020018280548015610c4b57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610c2d575b50505050509050915091509091565b60008054600160a060020a03163314610c7257600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610c9957600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b60035481101561070d5781600160a060020a0316600382815481101515610cde57fe5b600091825260209091200154600160a060020a03161415610d7a57600380546000198101908110610d0b57fe5b60009182526020909120015460038054600160a060020a039092169183908110610d3157fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906106bb9082610f0b565b600101610cbb565b60dd805482908110610d9057fe5b600091825260209091200154600160a060020a0316905081565b60105481565b600b5481565b600080548190600160a060020a0316331480610de157503360009081526001602052604090205460ff165b1515610dec57600080fd5b5060005b6064811015610e53578260158260648110610e0757fe5b01541415610e4b5760de546015906000190160648110610e2357fe5b015460158260648110610e3257fe5b015560de546015906000190160648110610e4857fe5b50505b600101610df0565b50919050565b600c5481565b600054600160a060020a03163314610e7657600080fd5b610e7f81610e8e565b50565b60115481565b600f5481565b600160a060020a0381161515610ea357600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b815481835581811115610f2f57600083815260209020610f2f918101908301610f54565b505050565b610c80604051908101604052806064906020820280388339509192915050565b61077191905b80821115610f6e5760008155600101610f5a565b50905600a165627a7a72305820ea294dd48891486094db1ef08e08696a0b4e8e0d4017787a1a670e10c768eef00029a165627a7a72305820c6a8d74809e402e1a4090985e245bd958b132464daedee56bc87e093803a284e0029";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_CREATEPRODUCT = "createProduct";

    public static final String FUNC_REMOVEPRODUCT = "removeProduct";

    public static final String FUNC_GETPRODUCTINFO = "getProductInfo";

    public static final Event PRODUCTADDED_EVENT = new Event("ProductAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bool>() {}));
    ;

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
    protected ProductFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public List<ProductAddedEventResponse> getProductAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PRODUCTADDED_EVENT, transactionReceipt);
        ArrayList<ProductAddedEventResponse> responses = new ArrayList<ProductAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProductAddedEventResponse typedResponse = new ProductAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.productId = (Bytes32) eventValues.getNonIndexedValues().get(0);
            typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ProductAddedEventResponse> productAddedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ProductAddedEventResponse>() {
            @Override
            public ProductAddedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRODUCTADDED_EVENT, log);
                ProductAddedEventResponse typedResponse = new ProductAddedEventResponse();
                typedResponse.log = log;
                typedResponse.productId = (Bytes32) eventValues.getNonIndexedValues().get(0);
                typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<ProductAddedEventResponse> productAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTADDED_EVENT));
        return productAddedEventObservable(filter);
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

    public RemoteCall<TransactionReceipt> createProduct(Bytes32 _productId, Bytes32 _productName, Bytes32 _location, Bytes32 _containerId, Bytes32 _containerType) {
        final Function function = new Function(
                FUNC_CREATEPRODUCT, 
                Arrays.<Type>asList(_productId, _productName, _location, _containerId, _containerType), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeProduct(Bytes32 _productId) {
        final Function function = new Function(
                FUNC_REMOVEPRODUCT, 
                Arrays.<Type>asList(_productId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> getProductInfo(Bytes32 productId) {
        final Function function = new Function(FUNC_GETPRODUCTINFO, 
                Arrays.<Type>asList(productId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<ProductFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductFactory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ProductFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductFactory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static ProductFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProductFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ProductAddedEventResponse {
        public Log log;

        public Bytes32 productId;

        public Bool isAdd;
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