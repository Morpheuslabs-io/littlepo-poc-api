package com.littlepo.web3j.wrapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class User extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516104833803806104838339810160409081528151602080840151928401516060850151608086015160008590559486018051949690959281019491810193920191610064916001918701906100ab565b5082516100789060029060208601906100ab565b50815161008c9060039060208501906100ab565b5080516100a09060049060208401906100ab565b505050505050610146565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100ec57805160ff1916838001178555610119565b82800160010185558215610119579182015b828111156101195782518255916020019190600101906100fe565b50610125929150610129565b5090565b61014391905b80821115610125576000815560010161012f565b90565b61032e806101556000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663224b610b811461007157806361fac54d146100fb578063820e93f51461011057806389b7ddf214610125578063af640d0f1461013a575b600080fd5b34801561007d57600080fd5b50610086610161565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100c05781810151838201526020016100a8565b50505050905090810190601f1680156100ed5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561010757600080fd5b506100866101ec565b34801561011c57600080fd5b50610086610246565b34801561013157600080fd5b506100866102a1565b34801561014657600080fd5b5061014f6102fc565b60408051918252519081900360200190f35b6002805460408051602060018416156101000260001901909316849004601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b820191906000526020600020905b8154815290600101906020018083116101c757829003601f168201915b505050505081565b60018054604080516020600284861615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101e45780601f106101b9576101008083540402835291602001916101e4565b600054815600a165627a7a72305820e8d075269d5d3c39eda06f07524cc6667b0b6acdfbdf13fe654bd29bf58f59000029";

    public static final String FUNC_PASSWORD = "password";

    public static final String FUNC_USERNAME = "username";

    public static final String FUNC_EMAIL = "email";

    public static final String FUNC_FULLNAME = "fullName";

    public static final String FUNC_ID = "id";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected User(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected User(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected User(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected User(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Utf8String> password() {
        final Function function = new Function(FUNC_PASSWORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> username() {
        final Function function = new Function(FUNC_USERNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> email() {
        final Function function = new Function(FUNC_EMAIL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> fullName() {
        final Function function = new Function(FUNC_FULLNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> id() {
        final Function function = new Function(FUNC_ID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<User> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Uint256 _id, Utf8String _username, Utf8String _password, Utf8String _email, Utf8String _fullName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_id, _username, _password, _email, _fullName));
        return deployRemoteCall(User.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<User> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Uint256 _id, Utf8String _username, Utf8String _password, Utf8String _email, Utf8String _fullName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_id, _username, _password, _email, _fullName));
        return deployRemoteCall(User.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<User> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Uint256 _id, Utf8String _username, Utf8String _password, Utf8String _email, Utf8String _fullName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_id, _username, _password, _email, _fullName));
        return deployRemoteCall(User.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<User> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Uint256 _id, Utf8String _username, Utf8String _password, Utf8String _email, Utf8String _fullName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_id, _username, _password, _email, _fullName));
        return deployRemoteCall(User.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static User load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new User(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static User load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new User(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static User load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new User(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static User load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new User(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
