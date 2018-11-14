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
public class RetailShopNode extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a031916331790556122e1806100256000396000f300608060405260043610620000d15763ffffffff60e060020a6000350416631785f53c8114620000d657806327a099d814620000fc57806331ae450b146200016657806349334ee5146200017e5780635445647d14620001b55780635599e55b14620001ec5780637048027514620002045780637a12b9c514620002285780638da5cb5b146200024c5780639870d7fe1462000264578063ac8a584a1462000288578063c611a4d714620002ac578063d977e6be14620002d9578063f2fde38b14620002f4578063f7aca2cb1462000318575b600080fd5b348015620000e357600080fd5b50620000fa600160a060020a036004351662000342565b005b3480156200010957600080fd5b5062000114620004c3565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156200015257818101518382015260200162000138565b505050509050019250505060405180910390f35b3480156200017357600080fd5b506200011462000528565b3480156200018b57600080fd5b50620001a160048035602481019101356200058a565b604080519115158252519081900360200190f35b348015620001c257600080fd5b50620001d0600435620009e3565b60408051600160a060020a039092168252519081900360200190f35b348015620001f957600080fd5b50620001d0620009fe565b3480156200021157600080fd5b50620000fa600160a060020a036004351662000a0d565b3480156200023557600080fd5b50620001a1600160a060020a036004351662000b13565b3480156200025957600080fd5b50620001d062000bf2565b3480156200027157600080fd5b50620000fa600160a060020a036004351662000c01565b3480156200029557600080fd5b50620000fa600160a060020a036004351662000d05565b348015620002b957600080fd5b50620001a1600435602435604435600160a060020a036064351662000e37565b348015620002e657600080fd5b50620001d060043562000f28565b3480156200030157600080fd5b50620000fa600160a060020a036004351662000f50565b3480156200032557600080fd5b506200033062000f76565b60408051918252519081900360200190f35b60008054600160a060020a031633146200035b57600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156200038357600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b600454811015620004bf5781600160a060020a0316600482815481101515620003ca57fe5b600091825260209091200154600160a060020a03161415620004b657600480546000198101908110620003f957fe5b60009182526020909120015460048054600160a060020a0390921691839081106200042057fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556004805460001901906200046b908262001018565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1620004bf565b600101620003a5565b5050565b606060038054806020026020016040519081016040528092919081815260200182805480156200051d57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311620004fe575b505050505090505b90565b606060048054806020026020016040519081016040528092919081815260200182805480156200051d57602002820191906000526020600020908154600160a060020a03168152600190910190602001808311620004fe575050505050905090565b600080548190600160a060020a0316331480620005b657503360009081526001602052604090205460ff165b1515620005c257600080fd5b600754600160a060020a031615156200063c57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f53746f72616765206973206e6f7420636f6e6669672079657400000000000000604482015290519081900360640190fd5b7f52657461696c53686f700000000000000000000000000000000000000000000084846200066962001044565b83815260406020808301828152918301849052606083019085908502808284378201915050945050505050604051809103906000f080158015620006b1573d6000803e3d6000fd5b50600754604080517f9870d7fe000000000000000000000000000000000000000000000000000000008152600160a060020a039283166004820152905192935090831691639870d7fe9160248082019260009290919082900301818387803b1580156200071d57600080fd5b505af115801562000732573d6000803e3d6000fd5b50505050600760009054906101000a9004600160a060020a0316600160a060020a031663c924d9a882600160a060020a03166313febc366040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156200079957600080fd5b505af1158015620007ae573d6000803e3d6000fd5b505050506040513d6020811015620007c557600080fd5b50516040805160e060020a63ffffffff85160281526004810192909252600160a060020a03851660248301525160448083019260209291908290030181600087803b1580156200081457600080fd5b505af115801562000829573d6000803e3d6000fd5b505050506040513d60208110156200084057600080fd5b5050600754604080517f13febc360000000000000000000000000000000000000000000000000000000081529051600160a060020a0392831692631f06e91c92908516916313febc36916004808201926020929091908290030181600087803b158015620008ad57600080fd5b505af1158015620008c2573d6000803e3d6000fd5b505050506040513d6020811015620008d957600080fd5b5051604080517f5ceccff40000000000000000000000000000000000000000000000000000000081529051600160a060020a03861691635ceccff49160048083019260209291908290030181600087803b1580156200093757600080fd5b505af11580156200094c573d6000803e3d6000fd5b505050506040513d60208110156200096357600080fd5b50516040805160e060020a63ffffffff8616028152600481019390935260248301919091525160448083019260209291908290030181600087803b158015620009ab57600080fd5b505af1158015620009c0573d6000803e3d6000fd5b505050506040513d6020811015620009d757600080fd5b50600195945050505050565b600090815260056020526040902054600160a060020a031690565b600754600160a060020a031681565b600054600160a060020a0316331462000a2557600080fd5b600160a060020a03811660009081526002602052604090205460ff161562000a4c57600080fd5b60045460141162000a5c57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a031633148062000b3d57503360009081526002602052604090205460ff165b151562000b4957600080fd5b600160a060020a038216151562000bc157604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f496e76616c69642073746f726167652061646472657373000000000000000000604482015290519081900360640190fd5b6007805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03939093169290921790915590565b600054600160a060020a031681565b600054600160a060020a0316331462000c1957600080fd5b600160a060020a03811660009081526001602052604090205460ff161562000c4057600080fd5b60035460141162000c5057600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331462000d1e57600080fd5b600160a060020a03821660009081526001602052604090205460ff16151562000d4657600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b600354811015620004bf5781600160a060020a031660038281548110151562000d8d57fe5b600091825260209091200154600160a060020a0316141562000e2e5760038054600019810190811062000dbc57fe5b60009182526020909120015460038054600160a060020a03909216918390811062000de357fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790556003805460001901906200046b908262001018565b60010162000d68565b60008054600160a060020a031633148062000e6157503360009081526001602052604090205460ff165b151562000e6d57600080fd5b60008581526005602090815260408083205481517f635e778a0000000000000000000000000000000000000000000000000000000081526004810189905260248101889052600160a060020a0387811660448301529251929091169363635e778a9360648084019491939192918390030190829087803b15801562000ef157600080fd5b505af115801562000f06573d6000803e3d6000fd5b505050506040513d602081101562000f1d57600080fd5b505195945050505050565b60009081526006602090815260408083205483526005909152902054600160a060020a031690565b600054600160a060020a0316331462000f6857600080fd5b62000f738162000f9a565b50565b7f426173654e6f646500000000000000000000000000000000000000000000000090565b600160a060020a038116151562000fb057600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b8154818355818111156200103f576000838152602090206200103f91810190830162001055565b505050565b60405161123f806200107783390190565b6200052591905b808211156200107257600081556001016200105c565b50905600608060405260646013556001601455600160de553480156200002057600080fd5b506040516200123f3803806200123f833981016040528051602082015160008054600160a060020a031916331781556005839055920180519192909182919081106200006857fe5b602090810290910101516006558051819060019081106200008557fe5b6020908102909101015160df55805181906002908110620000a257fe5b60209081029091010151600855805181906003908110620000bf57fe5b60209081029091010151600755805181906004908110620000dc57fe5b60209081029091010151600955805181906005908110620000f957fe5b60209081029091010151600a558051819060069081106200011657fe5b60209081029091010151600b558051819060079081106200013357fe5b60209081029091010151600d558051819060089081106200015057fe5b60209081029091010151600e558051819060099081106200016d57fe5b60209081029091010151600f5580518190600a9081106200018a57fe5b60209081029091010151600c5580518190600b908110620001a757fe5b6020908102909101015160e05580518190600c908110620001c457fe5b6020908102909101015160e15580518190600d908110620001e157fe5b6020908102909101015160e255505042601081905560115561103680620002096000396000f3006080604052600436106101b65763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663073fae8381146101bb578063139d7fed146101e257806313febc36146101f75780631785f53c1461020c57806317fc45e21461022f57806327a099d8146102445780632d200a06146102a95780632e943fbd146102be57806330e4b911146102d357806331ae450b146102e85780633571ee35146102fd578063516f279e1461031557806354fd4d501461032a5780635ceccff41461033f578063635e778a14610354578063704802751461038f57806371bc9d9a146103b05780637f7650eb146103c857806382aefefb146103dd5780638c835736146103f55780638da5cb5b1461040a5780639464da8e1461043b5780639870d7fe146104505780639ac80dce146104715780639c6f2b2514610486578063a035b1fe14610519578063ac8a584a1461052e578063b26e642b1461054f578063b2f4bdb014610567578063c5ce39111461057c578063df4857ec14610591578063f0935ec4146105a9578063f2fde38b146105be578063f375d94a146105df578063f4834bbc146105f4575b600080fd5b3480156101c757600080fd5b506101d0610609565b60408051918252519081900360200190f35b3480156101ee57600080fd5b506101d061060f565b34801561020357600080fd5b506101d0610615565b34801561021857600080fd5b5061022d600160a060020a036004351661061b565b005b34801561023b57600080fd5b506101d0610791565b34801561025057600080fd5b50610259610797565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561029557818101518382015260200161027d565b505050509050019250505060405180910390f35b3480156102b557600080fd5b506101d06107fa565b3480156102ca57600080fd5b506101d0610800565b3480156102df57600080fd5b506101d0610806565b3480156102f457600080fd5b5061025961080c565b34801561030957600080fd5b506101d060043561086c565b34801561032157600080fd5b506101d0610880565b34801561033657600080fd5b506101d0610886565b34801561034b57600080fd5b506101d061088c565b34801561036057600080fd5b5061037b600435602435600160a060020a0360443516610892565b604080519115158252519081900360200190f35b34801561039b57600080fd5b5061022d600160a060020a03600435166109d2565b3480156103bc57600080fd5b5061037b600435610ad5565b3480156103d457600080fd5b506101d0610b12565b3480156103e957600080fd5b506101d0600435610b18565b34801561040157600080fd5b506101d0610b25565b34801561041657600080fd5b5061041f610b2b565b60408051600160a060020a039092168252519081900360200190f35b34801561044757600080fd5b506101d0610b3a565b34801561045c57600080fd5b5061022d600160a060020a0360043516610b40565b34801561047d57600080fd5b506101d0610c41565b34801561049257600080fd5b5061049b610c47565b6040518083610c8080838360005b838110156104c15781810151838201526020016104a9565b5050505090500180602001828103825283818151815260200191508051906020019060200280838360005b838110156105045781810151838201526020016104ec565b50505050905001935050505060405180910390f35b34801561052557600080fd5b506101d0610cec565b34801561053a57600080fd5b5061022d600160a060020a0360043516610cf2565b34801561055b57600080fd5b5061041f600435610e1a565b34801561057357600080fd5b506101d0610e42565b34801561058857600080fd5b506101d0610e48565b34801561059d57600080fd5b5061037b600435610e4e565b3480156105b557600080fd5b506101d0610ef1565b3480156105ca57600080fd5b5061022d600160a060020a0360043516610ef7565b3480156105eb57600080fd5b506101d0610f1a565b34801561060057600080fd5b506101d0610f20565b60075481565b60055481565b60085481565b60008054600160a060020a0316331461063357600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561065a57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b60045481101561078d5781600160a060020a031660048281548110151561069f57fe5b600091825260209091200154600160a060020a03161415610785576004805460001981019081106106cc57fe5b60009182526020909120015460048054600160a060020a0390921691839081106106f257fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560048054600019019061073b9082610fa3565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a161078d565b60010161067c565b5050565b60e05481565b606060038054806020026020016040519081016040528092919081815260200182805480156107ef57602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116107d1575b505050505090505b90565b60e25481565b600d5481565b600e5481565b606060048054806020026020016040519081016040528092919081815260200182805480156107ef57602002820191906000526020600020908154600160a060020a031681526001909101906020018083116107d1575050505050905090565b6015816064811061087957fe5b0154905081565b600a5481565b60145481565b60df5481565b60008054600160a060020a03163314806108bb57503360009081526001602052604090205460ff165b15156108c657600080fd5b60135460de541061093857604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601560248201527f43616e6e6f7420616464206d6f7265206368696c640000000000000000000000604482015290519081900360640190fd5b836015600160de540360648110151561094d57fe5b015560de548390607990600019016064811061096557fe5b01555060dd8054600181810183556000929092527fac507b9f8bf86ad8bb770f71cd2b1992902ae0314d93fc0f2bb011d70e796226018054600160a060020a03841673ffffffffffffffffffffffffffffffffffffffff1990911617905560de8054820190559392505050565b600054600160a060020a031633146109e957600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610a0f57600080fd5b600454601411610a1e57600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60008054600160a060020a0316331480610afe57503360009081526001602052604090205460ff165b1515610b0957600080fd5b60129190915590565b60095481565b6079816064811061087957fe5b60de5481565b600054600160a060020a031681565b60065481565b600054600160a060020a03163314610b5757600080fd5b600160a060020a03811660009081526001602052604090205460ff1615610b7d57600080fd5b600354601411610b8c57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60125481565b610c4f610fcc565b60408051610c8081019182905260609160799160dd91839060649082845b81548152600190910190602001808311610c6d575050505050915080805480602002602001604051908101604052809291908181526020018280548015610cdd57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610cbf575b50505050509050915091509091565b60e15481565b60008054600160a060020a03163314610d0a57600080fd5b600160a060020a03821660009081526001602052604090205460ff161515610d3157600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b60035481101561078d5781600160a060020a0316600382815481101515610d7657fe5b600091825260209091200154600160a060020a03161415610e1257600380546000198101908110610da357fe5b60009182526020909120015460038054600160a060020a039092169183908110610dc957fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560038054600019019061073b9082610fa3565b600101610d53565b60dd805482908110610e2857fe5b600091825260209091200154600160a060020a0316905081565b60105481565b600b5481565b600080548190600160a060020a0316331480610e7957503360009081526001602052604090205460ff165b1515610e8457600080fd5b5060005b6064811015610eeb578260158260648110610e9f57fe5b01541415610ee35760de546015906000190160648110610ebb57fe5b015460158260648110610eca57fe5b015560de546015906000190160648110610ee057fe5b50505b600101610e88565b50919050565b600c5481565b600054600160a060020a03163314610f0e57600080fd5b610f1781610f26565b50565b60115481565b600f5481565b600160a060020a0381161515610f3b57600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b815481835581811115610fc757600083815260209020610fc7918101908301610fec565b505050565b610c80604051908101604052806064906020820280388339509192915050565b6107f791905b808211156110065760008155600101610ff2565b50905600a165627a7a72305820b7c051346586e2efcaa07ad4c54297b368bdf057eb2cbac6ced3854afb2155e90029a165627a7a72305820c7242a60ebff50b94eefeafec0c931a4ab4e62b1e2d3deff39ec4e45f7191b1d0029";

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
    protected RetailShopNode(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RetailShopNode(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RetailShopNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RetailShopNode(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static RemoteCall<RetailShopNode> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RetailShopNode.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RetailShopNode> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RetailShopNode.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RetailShopNode> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RetailShopNode.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RetailShopNode> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RetailShopNode.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RetailShopNode load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailShopNode(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RetailShopNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailShopNode(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RetailShopNode load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RetailShopNode(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RetailShopNode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RetailShopNode(contractAddress, web3j, transactionManager, contractGasProvider);
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
