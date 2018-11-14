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
public class LittlepoNode extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055612033806100256000396000f3006080604052600436106100c15763ffffffff60e060020a6000350416631785f53c81146100c657806327a099d8146100e957806331ae450b1461014e57806349334ee5146101635780635445647d146101975780635599e55b146101cb57806370480275146101e05780637a12b9c5146102015780638da5cb5b146102225780639870d7fe14610237578063ac8a584a14610258578063c611a4d714610279578063d977e6be146102a3578063f2fde38b146102bb578063f7aca2cb146102dc575b600080fd5b3480156100d257600080fd5b506100e7600160a060020a0360043516610303565b005b3480156100f557600080fd5b506100fe61046c565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561013a578181015183820152602001610122565b505050509050019250505060405180910390f35b34801561015a57600080fd5b506100fe6104cf565b34801561016f57600080fd5b50610183600480356024810191013561052f565b604080519115158252519081900360200190f35b3480156101a357600080fd5b506101af600435610871565b60408051600160a060020a039092168252519081900360200190f35b3480156101d757600080fd5b506101af61088c565b3480156101ec57600080fd5b506100e7600160a060020a036004351661089b565b34801561020d57600080fd5b50610183600160a060020a0360043516610991565b34801561022e57600080fd5b506101af610a60565b34801561024357600080fd5b506100e7600160a060020a0360043516610a6f565b34801561026457600080fd5b506100e7600160a060020a0360043516610b63565b34801561028557600080fd5b50610183600435602435604435600160a060020a0360643516610c7e565b3480156102af57600080fd5b506101af600435610d6a565b3480156102c757600080fd5b506100e7600160a060020a0360043516610d92565b3480156102e857600080fd5b506102f1610db5565b60408051918252519081900360200190f35b60008054600160a060020a0316331461031b57600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561034257600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156104685781600160a060020a031660048281548110151561038757fe5b600091825260209091200154600160a060020a03161415610460576004805460001981019081106103b457fe5b60009182526020909120015460048054600160a060020a0390921691839081106103da57fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556004805460001901906104169082610e49565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610468565b600101610364565b5050565b606060038054806020026020016040519081016040528092919081815260200182805480156104c457602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116104a6575b505050505090505b90565b606060048054806020026020016040519081016040528092919081815260200182805480156104c457602002820191906000526020600020908154600160a060020a031681526001909101906020018083116104a6575050505050905090565b600080548190600160a060020a031633148061055a57503360009081526001602052604090205460ff165b151561056557600080fd5b600754600160a060020a031615156105de57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f53746f72616765206973206e6f7420636f6e6669672079657400000000000000604482015290519081900360640190fd5b7f4c6974746c65706f4e6f646500000000000000000000000000000000000000008484610609610e72565b83815260406020808301828152918301849052606083019085908502808284378201915050945050505050604051809103906000f080158015610650573d6000803e3d6000fd5b509050806005600083600160a060020a0316639464da8e6040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561069657600080fd5b505af11580156106aa573d6000803e3d6000fd5b505050506040513d60208110156106c057600080fd5b505181526020810191909152604090810160009081208054600160a060020a031916600160a060020a0394851617905560075482517f9870d7fe0000000000000000000000000000000000000000000000000000000081529084166004820152915192841692639870d7fe92602480820193929182900301818387803b15801561074957600080fd5b505af115801561075d573d6000803e3d6000fd5b50505050600760009054906101000a9004600160a060020a0316600160a060020a031663c924d9a882600160a060020a03166313febc366040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156107c357600080fd5b505af11580156107d7573d6000803e3d6000fd5b505050506040513d60208110156107ed57600080fd5b50516040805160e060020a63ffffffff85160281526004810192909252600160a060020a03851660248301525160448083019260209291908290030181600087803b15801561083b57600080fd5b505af115801561084f573d6000803e3d6000fd5b505050506040513d602081101561086557600080fd5b50600195945050505050565b600090815260056020526040902054600160a060020a031690565b600754600160a060020a031681565b600054600160a060020a031633146108b257600080fd5b600160a060020a03811660009081526002602052604090205460ff16156108d857600080fd5b6004546014116108e757600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b60008054600160a060020a03163314806109ba57503360009081526002602052604090205460ff165b15156109c557600080fd5b600160a060020a0382161515610a3c57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f496e76616c69642073746f726167652061646472657373000000000000000000604482015290519081900360640190fd5b60078054600160a060020a031916600160a060020a03939093169290921790915590565b600054600160a060020a031681565b600054600160a060020a03163314610a8657600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610aac57600080fd5b600354601411610abb57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b60008054600160a060020a03163314610b7b57600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610ba257600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156104685781600160a060020a0316600382815481101515610be757fe5b600091825260209091200154600160a060020a03161415610c7657600380546000198101908110610c1457fe5b60009182526020909120015460038054600160a060020a039092169183908110610c3a57fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556003805460001901906104169082610e49565b600101610bc4565b60008054600160a060020a0316331480610ca757503360009081526001602052604090205460ff165b1515610cb257600080fd5b60008581526005602090815260408083205481517f635e778a0000000000000000000000000000000000000000000000000000000081526004810189905260248101889052600160a060020a0387811660448301529251929091169363635e778a9360648084019491939192918390030190829087803b158015610d3557600080fd5b505af1158015610d49573d6000803e3d6000fd5b505050506040513d6020811015610d5f57600080fd5b505195945050505050565b60009081526006602090815260408083205483526005909152902054600160a060020a031690565b600054600160a060020a03163314610da957600080fd5b610db281610dd9565b50565b7f426173654e6f646500000000000000000000000000000000000000000000000090565b600160a060020a0381161515610dee57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b815481835581811115610e6d57600083815260209020610e6d918101908301610e82565b505050565b60405161116780610ea183390190565b6104cc91905b80821115610e9c5760008155600101610e88565b50905600608060405260646013556001601455600160de5534801561001f57600080fd5b50604051611167380380611167833981016040528051602082015160008054600160a060020a0319163317815560058390559201805191929091829190811061006457fe5b6020908102909101015160065580518190600190811061008057fe5b6020908102909101015160085580518190600290811061009c57fe5b602090810290910101516007558051819060039081106100b857fe5b602090810290910101516009558051819060049081106100d457fe5b60209081029091010151600a558051819060059081106100f057fe5b60209081029091010151600b5580518190600690811061010c57fe5b60209081029091010151600d5580518190600790811061012857fe5b60209081029091010151600e5580518190600890811061014457fe5b60209081029091010151600f5580518190600990811061016057fe5b60209081029091010151600c5580518190600a90811061017c57fe5b6020908102909101015160df555050426010819055601155610fc4806101a36000396000f3006080604052600436106101955763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae83811461019a578063139d7fed146101c157806313febc36146101d65780631785f53c146101eb57806327a099d81461020e5780632e943fbd1461027357806330e4b9111461028857806331ae450b1461029d5780633571ee35146102b2578063516f279e146102ca57806354fd4d50146102df578063635e778a146102f4578063704802751461032f57806371bc9d9a146103505780637f7650eb1461036857806382aefefb1461037d5780638c835736146103955780638da5cb5b146103aa5780639464da8e146103db5780639870d7fe146103f05780639ac80dce146104115780639c6f2b2514610426578063a1aab33f146104b9578063ac8a584a146104ce578063b26e642b146104ef578063b2f4bdb014610507578063c5ce39111461051c578063df4857ec14610531578063f0935ec414610549578063f2fde38b1461055e578063f375d94a1461057f578063f4834bbc14610594575b600080fd5b3480156101a657600080fd5b506101af6105a9565b60408051918252519081900360200190f35b3480156101cd57600080fd5b506101af6105af565b3480156101e257600080fd5b506101af6105b5565b3480156101f757600080fd5b5061020c600160a060020a03600435166105bb565b005b34801561021a57600080fd5b50610223610731565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561025f578181015183820152602001610247565b505050509050019250505060405180910390f35b34801561027f57600080fd5b506101af610794565b34801561029457600080fd5b506101af61079a565b3480156102a957600080fd5b506102236107a0565b3480156102be57600080fd5b506101af600435610800565b3480156102d657600080fd5b506101af610814565b3480156102eb57600080fd5b506101af61081a565b34801561030057600080fd5b5061031b600435602435600160a060020a0360443516610820565b604080519115158252519081900360200190f35b34801561033b57600080fd5b5061020c600160a060020a0360043516610960565b34801561035c57600080fd5b5061031b600435610a63565b34801561037457600080fd5b506101af610aa0565b34801561038957600080fd5b506101af600435610aa6565b3480156103a157600080fd5b506101af610ab3565b3480156103b657600080fd5b506103bf610ab9565b60408051600160a060020a039092168252519081900360200190f35b3480156103e757600080fd5b506101af610ac8565b3480156103fc57600080fd5b5061020c600160a060020a0360043516610ace565b34801561041d57600080fd5b506101af610bcf565b34801561043257600080fd5b5061043b610bd5565b6040518083610c8080838360005b83811015610461578181015183820152602001610449565b5050505090500180602001828103825283818151815260200191508051906020019060200280838360005b838110156104a457818101518382015260200161048c565b50505050905001935050505060405180910390f35b3480156104c557600080fd5b506101af610c7a565b3480156104da57600080fd5b5061020c600160a060020a0360043516610c80565b3480156104fb57600080fd5b506103bf600435610da8565b34801561051357600080fd5b506101af610dd0565b34801561052857600080fd5b506101af610dd6565b34801561053d57600080fd5b5061031b600435610ddc565b34801561055557600080fd5b506101af610e7f565b34801561056a57600080fd5b5061020c600160a060020a0360043516610e85565b34801561058b57600080fd5b506101af610ea8565b3480156105a057600080fd5b506101af610eae565b60075481565b60055481565b60085481565b60008054600160a060020a031633146105d357600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156105fa57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b60045481101561072d5781600160a060020a031660048281548110151561063f57fe5b600091825260209091200154600160a060020a031614156107255760048054600019810190811061066c57fe5b60009182526020909120015460048054600160a060020a03909216918390811061069257fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906106db9082610f31565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a161072d565b60010161061c565b5050565b6060600380548060200260200160405190810160405280929190818152602001828054801561078957602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161076b575b505050505090505b90565b600d5481565b600e5481565b6060600480548060200260200160405190810160405280929190818152602001828054801561078957602002820191906000526020600020908154600160a060020a0316815260019091019060200180831161076b575050505050905090565b6015816064811061080d57fe5b0154905081565b600a5481565b60145481565b60008054600160a060020a031633148061084957503360009081526001602052604090205460ff165b151561085457600080fd5b60135460de54106108c657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b836015600160de54036064811015156108db57fe5b015560de54839060799060001901606481106108f357fe5b01555060dd8054600181810183556000929092527fac507b9f8bf86ad8bb770f71cd2b1992902ae0314d93fc0f2bb011d70e796226018054600160a060020a03841673ffffffffffffffffffffffffffffffffffffffff1990911617905560de8054820190559392505050565b600054600160a060020a0316331461097757600080fd5b600160a060020a03811660009081526002602052604090205460ff161561099d57600080fd5b6004546014116109ac57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610a8c57503360009081526001602052604090205460ff165b1515610a9757600080fd5b60129190915590565b60095481565b6079816064811061080d57fe5b60de5481565b600054600160a060020a031681565b60065481565b600054600160a060020a03163314610ae557600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610b0b57600080fd5b600354601411610b1a57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60125481565b610bdd610f5a565b60408051610c8081019182905260609160799160dd91839060649082845b81548152600190910190602001808311610bfb575050505050915080805480602002602001604051908101604052809291908181526020018280548015610c6b57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610c4d575b50505050509050915091509091565b60df5481565b60008054600160a060020a03163314610c9857600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610cbf57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b60035481101561072d5781600160a060020a0316600382815481101515610d0457fe5b600091825260209091200154600160a060020a03161415610da057600380546000198101908110610d3157fe5b60009182526020909120015460038054600160a060020a039092169183908110610d5757fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906106db9082610f31565b600101610ce1565b60dd805482908110610db657fe5b600091825260209091200154600160a060020a0316905081565b60105481565b600b5481565b600080548190600160a060020a0316331480610e0757503360009081526001602052604090205460ff165b1515610e1257600080fd5b5060005b6064811015610e79578260158260648110610e2d57fe5b01541415610e715760de546015906000190160648110610e4957fe5b015460158260648110610e5857fe5b015560de546015906000190160648110610e6e57fe5b50505b600101610e16565b50919050565b600c5481565b600054600160a060020a03163314610e9c57600080fd5b610ea581610eb4565b50565b60115481565b600f5481565b600160a060020a0381161515610ec957600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b815481835581811115610f5557600083815260209020610f55918101908301610f7a565b505050565b610c80604051908101604052806064906020820280388339509192915050565b61079191905b80821115610f945760008155600101610f80565b50905600a165627a7a72305820990d157f61430b0913e4b73600dbd33aeee624241a60eeba281ebedb23fd834f0029a165627a7a72305820f493edcfda84869a902e66a8252c552a6c8c7c3f4f6c62fef274c3f8bc180ac70029";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_GETPRODUCTBATCHINFO = "getProductBatchInfo";

    public static final String FUNC_LITTLEPOPRODUCTHISTORY = "littlepoProductHistory";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_SETPRODUCTSTORAGE = "setProductStorage";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_ADDCHILD = "addChild";

    public static final String FUNC_GETPRODUCTBATCHBYBATCHNO = "getProductBatchByBatchNo";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_GETNODENAME = "getNodeName";

    public static final String FUNC_CREATEPRODUCTBATCH = "createProductBatch";

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
    protected LittlepoNode(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LittlepoNode(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LittlepoNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LittlepoNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<Address> getProductBatchInfo(Bytes32 _productBatchId) {
        final Function function = new Function(FUNC_GETPRODUCTBATCHINFO, 
                Arrays.<Type>asList(_productBatchId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> littlepoProductHistory() {
        final Function function = new Function(FUNC_LITTLEPOPRODUCTHISTORY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addAdmin(Address newAdmin) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(newAdmin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setProductStorage(Address _littlepoProductHistory) {
        final Function function = new Function(
                FUNC_SETPRODUCTSTORAGE, 
                Arrays.<Type>asList(_littlepoProductHistory), 
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

    public RemoteCall<TransactionReceipt> addChild(Bytes32 _productBatchId, Bytes32 _childId, Bytes32 _childName, Address _childAddress) {
        final Function function = new Function(
                FUNC_ADDCHILD, 
                Arrays.<Type>asList(_productBatchId, _childId, _childName, _childAddress), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> getProductBatchByBatchNo(Bytes32 _bBatchNo) {
        final Function function = new Function(FUNC_GETPRODUCTBATCHBYBATCHNO, 
                Arrays.<Type>asList(_bBatchNo), 
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

    public RemoteCall<Bytes32> getNodeName() {
        final Function function = new Function(FUNC_GETNODENAME, 
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

    public RemoteCall<TransactionReceipt> createProductBatch(DynamicArray<Bytes32> bArgs) {
        final Function function = new Function(
                FUNC_CREATEPRODUCTBATCH, 
                Arrays.<Type>asList(bArgs), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LittlepoNode> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoNode.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoNode> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoNode.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LittlepoNode> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LittlepoNode.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LittlepoNode> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LittlepoNode.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static LittlepoNode load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoNode(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LittlepoNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LittlepoNode(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LittlepoNode load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LittlepoNode(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LittlepoNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LittlepoNode(contractAddress, web3j, transactionManager, contractGasProvider);
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
