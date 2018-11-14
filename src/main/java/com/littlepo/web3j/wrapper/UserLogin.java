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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class UserLogin extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a031916331790556118b4806100256000396000f3006080604052600436106100955763ffffffff60e060020a6000350416630e24c52c811461009a5780631785f53c146101c157806327a099d8146101e457806331ae450b1461024957806331feb6711461025e57806370480275146104685780638da5cb5b146104895780639870d7fe146104ba5780639a95fdd5146104db578063ac8a584a146104f0578063f2fde38b14610511575b600080fd5b3480156100a657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101ad94369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506105329650505050505050565b604080519115158252519081900360200190f35b3480156101cd57600080fd5b506101e2600160a060020a0360043516610921565b005b3480156101f057600080fd5b506101f9610a8a565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561023557818101518382015260200161021d565b505050509050019250505060405180910390f35b34801561025557600080fd5b506101f9610aed565b34801561026a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102b7943694929360249392840191908190840183828082843750949750610b4d9650505050505050565b6040518086815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156103065781810151838201526020016102ee565b50505050905090810190601f1680156103335780820380516001836020036101000a031916815260200191505b5085810384528851815288516020918201918a019080838360005b8381101561036657818101518382015260200161034e565b50505050905090810190601f1680156103935780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b838110156103c65781810151838201526020016103ae565b50505050905090810190601f1680156103f35780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b8381101561042657818101518382015260200161040e565b50505050905090810190601f1680156104535780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b34801561047457600080fd5b506101e2600160a060020a0360043516610fa7565b34801561049557600080fd5b5061049e61109d565b60408051600160a060020a039092168252519081900360200190f35b3480156104c657600080fd5b506101e2600160a060020a03600435166110ac565b3480156104e757600080fd5b506101f96111a0565b3480156104fc57600080fd5b506101e2600160a060020a0360043516611200565b34801561051d57600080fd5b506101e2600160a060020a036004351661131b565b6000805481908190600160a060020a031633148061055f57503360009081526002602052604090205460ff165b151561056a57600080fd5b6000600160a060020a03166006886040518082805190602001908083835b602083106105a75780518252601f199092019160209182019101610588565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054600160a060020a031692909214915061064f905057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f557365726e616d6520697320616c726561647920726567697374657265640000604482015290519081900360640190fd5b600754600101878787876106616113ae565b8086815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156106ad578181015183820152602001610695565b50505050905090810190601f1680156106da5780820380516001836020036101000a031916815260200191505b5085810384528851815288516020918201918a019080838360005b8381101561070d5781810151838201526020016106f5565b50505050905090810190601f16801561073a5780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b8381101561076d578181015183820152602001610755565b50505050905090810190601f16801561079a5780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b838110156107cd5781810151838201526020016107b5565b50505050905090810190601f1680156107fa5780820380516001836020036101000a031916815260200191505b509950505050505050505050604051809103906000f080158015610822573d6000803e3d6000fd5b50600160a060020a0381166000818152600560209081526040918290208054600160a060020a03191690931790925551895192945084935083926006928b929182918401908083835b6020831061088a5780518252601f19909201916020918201910161086b565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092208054600160a060020a0319908116600160a060020a039586161790915560078054600181810183556000929092527fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c688018054909216959094169490941790935550979650505050505050565b60008054600160a060020a0316331461093957600080fd5b600160a060020a03821660009081526002602052604090205460ff16151561096057600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b600454811015610a865781600160a060020a03166004828154811015156109a557fe5b600091825260209091200154600160a060020a03161415610a7e576004805460001981019081106109d257fe5b60009182526020909120015460048054600160a060020a0390921691839081106109f857fe5b60009182526020909120018054600160a060020a031916600160a060020a0392909216919091179055600480546000190190610a3490826113be565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610a86565b600101610982565b5050565b60606003805480602002602001604051908101604052809291908181526020018280548015610ae257602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610ac4575b505050505090505b90565b60606004805480602002602001604051908101604052809291908181526020018280548015610ae257602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610ac4575050505050905090565b60006060806060806000600560006006896040518082805190602001908083835b60208310610b8d5780518252601f199092019160209182019101610b6e565b51815160209384036101000a60001901801990921691161790529201948552506040805194859003820190942054600160a060020a0390811686528582019690965293830160009081205484517faf640d0f000000000000000000000000000000000000000000000000000000008152945196169650869563af640d0f956004808701969195509193508390030190829087803b158015610c2d57600080fd5b505af1158015610c41573d6000803e3d6000fd5b505050506040513d6020811015610c5757600080fd5b5051604080517f61fac54d0000000000000000000000000000000000000000000000000000000081529051600160a060020a038416916361fac54d91600480830192600092919082900301818387803b158015610cb357600080fd5b505af1158015610cc7573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610cf057600080fd5b810190808051640100000000811115610d0857600080fd5b82016020810184811115610d1b57600080fd5b8151640100000000811182820187101715610d3557600080fd5b505092919050505082600160a060020a031663224b610b6040518163ffffffff1660e060020a028152600401600060405180830381600087803b158015610d7b57600080fd5b505af1158015610d8f573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610db857600080fd5b810190808051640100000000811115610dd057600080fd5b82016020810184811115610de357600080fd5b8151640100000000811182820187101715610dfd57600080fd5b505092919050505083600160a060020a031663820e93f56040518163ffffffff1660e060020a028152600401600060405180830381600087803b158015610e4357600080fd5b505af1158015610e57573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610e8057600080fd5b810190808051640100000000811115610e9857600080fd5b82016020810184811115610eab57600080fd5b8151640100000000811182820187101715610ec557600080fd5b505092919050505084600160a060020a03166389b7ddf26040518163ffffffff1660e060020a028152600401600060405180830381600087803b158015610f0b57600080fd5b505af1158015610f1f573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526020811015610f4857600080fd5b810190808051640100000000811115610f6057600080fd5b82016020810184811115610f7357600080fd5b8151640100000000811182820187101715610f8d57600080fd5b50979f969e50949c50929a50929850929650505050505050565b600054600160a060020a03163314610fbe57600080fd5b600160a060020a03811660009081526002602052604090205460ff1615610fe457600080fd5b600454601411610ff357600080fd5b60408051600160a060020a03831681526001602082015281517f8a7039f4ea6f86a6a98d9c1efb0ea9d190f6b3fa37c32627cf48f767f51e36d5929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a031681565b600054600160a060020a031633146110c357600080fd5b600160a060020a03811660009081526001602052604090205460ff16156110e957600080fd5b6003546014116110f857600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a031660008181526001602081905260408220805460ff1916821790556003805491820181559091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b018054600160a060020a0319169091179055565b60606007805480602002602001604051908101604052809291908181526020018280548015610ae257602002820191906000526020600020908154600160a060020a03168152600190910190602001808311610ac4575050505050905090565b60008054600160a060020a0316331461121857600080fd5b600160a060020a03821660009081526001602052604090205460ff16151561123f57600080fd5b50600160a060020a0381166000908152600160205260408120805460ff191690555b600354811015610a865781600160a060020a031660038281548110151561128457fe5b600091825260209091200154600160a060020a03161415611313576003805460001981019081106112b157fe5b60009182526020909120015460038054600160a060020a0390921691839081106112d757fe5b60009182526020909120018054600160a060020a031916600160a060020a0392909216919091179055600380546000190190610a3490826113be565b600101611261565b600054600160a060020a0316331461133257600080fd5b61133b8161133e565b50565b600160a060020a038116151561135357600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b6040516104838061140683390190565b8154818355818111156113e2576000838152602090206113e29181019083016113e7565b505050565b610aea91905b8082111561140157600081556001016113ed565b50905600608060405234801561001057600080fd5b506040516104833803806104838339810160409081528151602080840151928401516060850151608086015160008590559486018051949690959281019491810193920191610064916001918701906100ab565b5082516100789060029060208601906100ab565b50815161008c9060039060208501906100ab565b5080516100a09060049060208401906100ab565b505050505050610146565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100ec57805160ff1916838001178555610119565b82800160010185558215610119579182015b828111156101195782518255916020019190600101906100fe565b50610125929150610129565b5090565b61014391905b80821115610125576000815560010161012f565b90565b61032e806101556000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663224b610b811461007157806361fac54d146100fb578063820e93f51461011057806389b7ddf214610125578063af640d0f1461013a575b600080fd5b34801561007d57600080fd5b50610086610161565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100c05781810151838201526020016100a8565b50505050905090810190601f1680156100ed5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561010757600080fd5b506100866101ec565b34801561011c57600080fd5b50610086610246565b34801561013157600080fd5b506100866102a1565b34801561014657600080fd5b5061014f6102fc565b60408051918252519081900360200190f35b6002805460408051602060018416156101000260001901909316849004601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b820191906000526020600020905b8154815290600101906020018083116101c757829003601f168201915b505050505081565b60018054604080516020600284861615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b600054815600a165627a7a72305820e8d075269d5d3c39eda06f07524cc6667b0b6acdfbdf13fe654bd29bf58f59000029a165627a7a7230582095458c2ce5dfd855a72b2b88c9a8bdca88e5a7ba867bf9a839e8419a5a5c9c8f0029";

    public static final String FUNC_REMOVEADMIN = "removeAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_GETADMINS = "getAdmins";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_GETUSER = "getUser";

    public static final String FUNC_GETLISTUSER = "getListUser";

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
    protected UserLogin(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserLogin(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserLogin(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserLogin(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<TransactionReceipt> register(Utf8String _username, Utf8String _password, Utf8String _email, Utf8String _fullName) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(_username, _password, _email, _fullName), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<Uint256, Utf8String, Utf8String, Utf8String, Utf8String>> getUser(Utf8String _username) {
        final Function function = new Function(FUNC_GETUSER, 
                Arrays.<Type>asList(_username), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple5<Uint256, Utf8String, Utf8String, Utf8String, Utf8String>>(
                new Callable<Tuple5<Uint256, Utf8String, Utf8String, Utf8String, Utf8String>>() {
                    @Override
                    public Tuple5<Uint256, Utf8String, Utf8String, Utf8String, Utf8String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Uint256, Utf8String, Utf8String, Utf8String, Utf8String>(
                                (Uint256) results.get(0), 
                                (Utf8String) results.get(1), 
                                (Utf8String) results.get(2), 
                                (Utf8String) results.get(3), 
                                (Utf8String) results.get(4));
                    }
                });
    }

    public RemoteCall<DynamicArray<Address>> getListUser() {
        final Function function = new Function(FUNC_GETLISTUSER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<UserLogin> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UserLogin.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UserLogin> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserLogin.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<UserLogin> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UserLogin.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UserLogin> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserLogin.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static UserLogin load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserLogin(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserLogin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserLogin(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserLogin load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserLogin(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserLogin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserLogin(contractAddress, web3j, transactionManager, contractGasProvider);
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
