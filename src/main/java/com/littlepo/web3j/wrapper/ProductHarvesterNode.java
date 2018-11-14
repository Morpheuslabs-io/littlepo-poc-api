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
public class ProductHarvesterNode extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a031916331790556120fd806100256000396000f3006080604052600436106100c15763ffffffff60e060020a6000350416631785f53c81146100c657806327a099d8146100e957806331ae450b1461014e57806349334ee5146101635780635445647d146101975780635599e55b146101cb57806370480275146101e05780637a12b9c5146102015780638da5cb5b146102225780639870d7fe14610237578063ac8a584a14610258578063c611a4d714610279578063d977e6be146102a3578063f2fde38b146102bb578063f7aca2cb146102dc575b600080fd5b3480156100d257600080fd5b506100e7600160a060020a0360043516610303565b005b3480156100f557600080fd5b506100fe61046c565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561013a578181015183820152602001610122565b505050509050019250505060405180910390f35b34801561015a57600080fd5b506100fe6104cf565b34801561016f57600080fd5b50610183600480356024810191013561052f565b604080519115158252519081900360200190f35b3480156101a357600080fd5b506101af600435610999565b60408051600160a060020a039092168252519081900360200190f35b3480156101d757600080fd5b506101af6109b4565b3480156101ec57600080fd5b506100e7600160a060020a03600435166109c3565b34801561020d57600080fd5b50610183600160a060020a0360043516610ab9565b34801561022e57600080fd5b506101af610b88565b34801561024357600080fd5b506100e7600160a060020a0360043516610b97565b34801561026457600080fd5b506100e7600160a060020a0360043516610c8b565b34801561028557600080fd5b50610183600435602435604435600160a060020a0360643516610da6565b3480156102af57600080fd5b506101af600435610e92565b3480156102c757600080fd5b506100e7600160a060020a0360043516610eba565b3480156102e857600080fd5b506102f1610edd565b60408051918252519081900360200190f35b60008054600160a060020a0316331461031b57600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561034257600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156104685781600160a060020a031660048281548110151561038757fe5b600091825260209091200154600160a060020a03161415610460576004805460001981019081106103b457fe5b60009182526020909120015460048054600160a060020a0390921691839081106103da57fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556004805460001901906104169082610f71565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610468565b600101610364565b5050565b606060038054806020026020016040519081016040528092919081815260200182805480156104c457602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116104a6575b505050505090505b90565b606060048054806020026020016040519081016040528092919081815260200182805480156104c457602002820191906000526020600020908154600160a060020a031681526001909101906020018083116104a6575050505050905090565b600080548190600160a060020a031633148061055a57503360009081526001602052604090205460ff165b151561056557600080fd5b600754600160a060020a031615156105de57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f53746f72616765206973206e6f7420636f6e6669672079657400000000000000604482015290519081900360640190fd5b7f50726f64756374486172766573746572000000000000000000000000000000008484610609610f9a565b83815260406020808301828152918301849052606083019085908502808284378201915050945050505050604051809103906000f080158015610650573d6000803e3d6000fd5b509050806005600083600160a060020a0316639464da8e6040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561069657600080fd5b505af11580156106aa573d6000803e3d6000fd5b505050506040513d60208110156106c057600080fd5b50518152602080820192909252604090810160009081208054600160a060020a031916600160a060020a0395861617905581517f9464da8e000000000000000000000000000000000000000000000000000000008152915193851693639464da8e936004808501949193918390030190829087803b15801561074157600080fd5b505af1158015610755573d6000803e3d6000fd5b505050506040513d602081101561076b57600080fd5b5051604080517f073fae830000000000000000000000000000000000000000000000000000000081529051600691600091600160a060020a0386169163073fae8391600480830192602092919082900301818787803b1580156107cd57600080fd5b505af11580156107e1573d6000803e3d6000fd5b505050506040513d60208110156107f757600080fd5b505181526020810191909152604090810160009081209290925560075481517f9870d7fe000000000000000000000000000000000000000000000000000000008152600160a060020a039182166004820152915190841692639870d7fe926024808201939182900301818387803b15801561087157600080fd5b505af1158015610885573d6000803e3d6000fd5b50505050600760009054906101000a9004600160a060020a0316600160a060020a031663c924d9a882600160a060020a031663073fae836040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156108eb57600080fd5b505af11580156108ff573d6000803e3d6000fd5b505050506040513d602081101561091557600080fd5b50516040805160e060020a63ffffffff85160281526004810192909252600160a060020a03851660248301525160448083019260209291908290030181600087803b15801561096357600080fd5b505af1158015610977573d6000803e3d6000fd5b505050506040513d602081101561098d57600080fd5b50600195945050505050565b600090815260056020526040902054600160a060020a031690565b600754600160a060020a031681565b600054600160a060020a031633146109da57600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610a0057600080fd5b600454601411610a0f57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b60008054600160a060020a0316331480610ae257503360009081526002602052604090205460ff165b1515610aed57600080fd5b600160a060020a0382161515610b6457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f496e76616c69642073746f726167652061646472657373000000000000000000604482015290519081900360640190fd5b60078054600160a060020a031916600160a060020a03939093169290921790915590565b600054600160a060020a031681565b600054600160a060020a03163314610bae57600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610bd457600080fd5b600354601411610be357600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b60008054600160a060020a03163314610ca357600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610cca57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b6003548110156104685781600160a060020a0316600382815481101515610d0f57fe5b600091825260209091200154600160a060020a03161415610d9e57600380546000198101908110610d3c57fe5b60009182526020909120015460038054600160a060020a039092169183908110610d6257fe5b60009182526020909120018054600160a060020a031916600160a060020a03929092169190911790556003805460001901906104169082610f71565b600101610cec565b60008054600160a060020a0316331480610dcf57503360009081526001602052604090205460ff165b1515610dda57600080fd5b60008581526005602090815260408083205481517f635e778a0000000000000000000000000000000000000000000000000000000081526004810189905260248101889052600160a060020a0387811660448301529251929091169363635e778a9360648084019491939192918390030190829087803b158015610e5d57600080fd5b505af1158015610e71573d6000803e3d6000fd5b505050506040513d6020811015610e8757600080fd5b505195945050505050565b60009081526006602090815260408083205483526005909152902054600160a060020a031690565b600054600160a060020a03163314610ed157600080fd5b610eda81610f01565b50565b7f426173654e6f646500000000000000000000000000000000000000000000000090565b600160a060020a0381161515610f1657600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b815481835581811115610f9557600083815260209020610f95918101908301610faa565b505050565b60405161110980610fc983390190565b6104cc91905b80821115610fc45760008155600101610fb0565b50905600608060405260646013556001601455600160de5534801561001f57600080fd5b50604051611109380380611109833981016040528051602082015160008054600160a060020a0319163317815560058390559201805191929091829190811061006457fe5b6020908102909101015160065580518190600190811061008057fe5b6020908102909101015160075580518190600290811061009c57fe5b602090810290910101516009558051819060039081106100b857fe5b60209081029091010151600a558051819060049081106100d457fe5b60209081029091010151600b558051819060059081106100f057fe5b60209081029091010151600c5580518190600690811061010c57fe5b60209081029091010151600d5580518190600790811061012857fe5b60209081029091010151600e5580518190600890811061014457fe5b60209081029091010151600f555050426010819055601155610f9e8061016b6000396000f30060806040526004361061018a5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae83811461018f578063139d7fed146101b657806313febc36146101cb5780631785f53c146101e057806327a099d8146102035780632e943fbd1461026857806330e4b9111461027d57806331ae450b146102925780633571ee35146102a7578063516f279e146102bf57806354fd4d50146102d4578063635e778a146102e9578063704802751461032457806371bc9d9a146103455780637f7650eb1461035d57806382aefefb146103725780638c8357361461038a5780638da5cb5b1461039f5780639464da8e146103d05780639870d7fe146103e55780639ac80dce146104065780639c6f2b251461041b578063ac8a584a146104ae578063b26e642b146104cf578063b2f4bdb0146104e7578063c5ce3911146104fc578063df4857ec14610511578063f0935ec414610529578063f2fde38b1461053e578063f375d94a1461055f578063f4834bbc14610574575b600080fd5b34801561019b57600080fd5b506101a4610589565b60408051918252519081900360200190f35b3480156101c257600080fd5b506101a461058f565b3480156101d757600080fd5b506101a4610595565b3480156101ec57600080fd5b50610201600160a060020a036004351661059b565b005b34801561020f57600080fd5b50610218610711565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561025457818101518382015260200161023c565b505050509050019250505060405180910390f35b34801561027457600080fd5b506101a4610774565b34801561028957600080fd5b506101a461077a565b34801561029e57600080fd5b50610218610780565b3480156102b357600080fd5b506101a46004356107e0565b3480156102cb57600080fd5b506101a46107f4565b3480156102e057600080fd5b506101a46107fa565b3480156102f557600080fd5b50610310600435602435600160a060020a0360443516610800565b604080519115158252519081900360200190f35b34801561033057600080fd5b50610201600160a060020a0360043516610940565b34801561035157600080fd5b50610310600435610a43565b34801561036957600080fd5b506101a4610a80565b34801561037e57600080fd5b506101a4600435610a86565b34801561039657600080fd5b506101a4610a93565b3480156103ab57600080fd5b506103b4610a99565b60408051600160a060020a039092168252519081900360200190f35b3480156103dc57600080fd5b506101a4610aa8565b3480156103f157600080fd5b50610201600160a060020a0360043516610aae565b34801561041257600080fd5b506101a4610baf565b34801561042757600080fd5b50610430610bb5565b6040518083610c8080838360005b8381101561045657818101518382015260200161043e565b5050505090500180602001828103825283818151815260200191508051906020019060200280838360005b83811015610499578181015183820152602001610481565b50505050905001935050505060405180910390f35b3480156104ba57600080fd5b50610201600160a060020a0360043516610c5a565b3480156104db57600080fd5b506103b4600435610d82565b3480156104f357600080fd5b506101a4610daa565b34801561050857600080fd5b506101a4610db0565b34801561051d57600080fd5b50610310600435610db6565b34801561053557600080fd5b506101a4610e59565b34801561054a57600080fd5b50610201600160a060020a0360043516610e5f565b34801561056b57600080fd5b506101a4610e82565b34801561058057600080fd5b506101a4610e88565b60075481565b60055481565b60085481565b60008054600160a060020a031633146105b357600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156105da57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b60045481101561070d5781600160a060020a031660048281548110151561061f57fe5b600091825260209091200154600160a060020a031614156107055760048054600019810190811061064c57fe5b60009182526020909120015460048054600160a060020a03909216918390811061067257fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906106bb9082610f0b565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a161070d565b6001016105fc565b5050565b6060600380548060200260200160405190810160405280929190818152602001828054801561076957602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161074b575b505050505090505b90565b600d5481565b600e5481565b6060600480548060200260200160405190810160405280929190818152602001828054801561076957602002820191906000526020600020908154600160a060020a0316815260019091019060200180831161074b575050505050905090565b601581606481106107ed57fe5b0154905081565b600a5481565b60145481565b60008054600160a060020a031633148061082957503360009081526001602052604090205460ff165b151561083457600080fd5b60135460de54106108a657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b836015600160de54036064811015156108bb57fe5b015560de54839060799060001901606481106108d357fe5b01555060dd8054600181810183556000929092527fac507b9f8bf86ad8bb770f71cd2b1992902ae0314d93fc0f2bb011d70e796226018054600160a060020a03841673ffffffffffffffffffffffffffffffffffffffff1990911617905560de8054820190559392505050565b600054600160a060020a0316331461095757600080fd5b600160a060020a03811660009081526002602052604090205460ff161561097d57600080fd5b60045460141161098c57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610a6c57503360009081526001602052604090205460ff165b1515610a7757600080fd5b60129190915590565b60095481565b607981606481106107ed57fe5b60de5481565b600054600160a060020a031681565b60065481565b600054600160a060020a03163314610ac557600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610aeb57600080fd5b600354601411610afa57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60125481565b610bbd610f34565b60408051610c8081019182905260609160799160dd91839060649082845b81548152600190910190602001808311610bdb575050505050915080805480602002602001604051908101604052809291908181526020018280548015610c4b57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610c2d575b50505050509050915091509091565b60008054600160a060020a03163314610c7257600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610c9957600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b60035481101561070d5781600160a060020a0316600382815481101515610cde57fe5b600091825260209091200154600160a060020a03161415610d7a57600380546000198101908110610d0b57fe5b60009182526020909120015460038054600160a060020a039092169183908110610d3157fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906106bb9082610f0b565b600101610cbb565b60dd805482908110610d9057fe5b600091825260209091200154600160a060020a0316905081565b60105481565b600b5481565b600080548190600160a060020a0316331480610de157503360009081526001602052604090205460ff165b1515610dec57600080fd5b5060005b6064811015610e53578260158260648110610e0757fe5b01541415610e4b5760de546015906000190160648110610e2357fe5b015460158260648110610e3257fe5b015560de546015906000190160648110610e4857fe5b50505b600101610df0565b50919050565b600c5481565b600054600160a060020a03163314610e7657600080fd5b610e7f81610e8e565b50565b60115481565b600f5481565b600160a060020a0381161515610ea357600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b815481835581811115610f2f57600083815260209020610f2f918101908301610f54565b505050565b610c80604051908101604052806064906020820280388339509192915050565b61077191905b80821115610f6e5760008155600101610f5a565b50905600a165627a7a723058200f4defdfd2d63b1c9f376d178013b9e75ee4250c08fd4ce6a939a4840be1ca7a0029a165627a7a723058203e429376ac252f9445331f4d6d37e675ad56b89d633eed7415eabef08c1b9a5d0029";

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
    protected ProductHarvesterNode(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductHarvesterNode(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductHarvesterNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductHarvesterNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static RemoteCall<ProductHarvesterNode> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductHarvesterNode.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductHarvesterNode> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductHarvesterNode.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ProductHarvesterNode> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductHarvesterNode.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductHarvesterNode> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductHarvesterNode.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static ProductHarvesterNode load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductHarvesterNode(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductHarvesterNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductHarvesterNode(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductHarvesterNode load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProductHarvesterNode(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductHarvesterNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductHarvesterNode(contractAddress, web3j, transactionManager, contractGasProvider);
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
