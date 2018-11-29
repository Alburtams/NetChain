package net.optimization.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import peersim.core.*;

/**
 * 
 * @author Weifeng Hao
 * the blockchain network node
 */
public class NetNode extends GeneralNode{
    private NodeType nodeType; // the type of the node(include: general_node,miner,self-mining miner)
    private MinerType minerType; //the type of the miner(include:CPU,GPU,FPGA,ASIC)
    private double balance; // the balance of the node
    private List<Block> blockchain; // the blockchain data of the node
    private Map<String, Transaction> transPool; // the transpool of the node
    
	public NetNode(String prefix) {
		super(prefix);
		// TODO Auto-generated constructor stub
		blockchain = new ArrayList<>();
    	transPool = new HashMap<>();	
	}

    @Override
    public Object clone()
    {
    	NetNode clone = (NetNode)super.clone();
    	clone.setTransPool(new HashMap<>());
    	clone.setBlockchain(new ArrayList<>());
    	return clone;
    }
	// node type selection
	public boolean isGeneralNode() {
		return nodeType==NodeType.GENERAL_NODE;
	}
	
	public boolean isMiner() {
		return nodeType==NodeType.MINER;
	}
	
	public boolean isSelfmingMiner() {
		return nodeType==NodeType.SELFMINING_MINER;
	}	
	
	public void setNodetype(NodeType ntype) {
		this.nodeType = ntype;
	}
	
	// miner type selection
	public MinerType getMtype() {
		return minerType;
	}

	public void setMtype(MinerType mtype) {
		this.minerType = mtype;
	}

	// balance type selection
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void increaseBalance(double amount) {
		balance += amount;
	}
	
	public void decreaseBalance(double amount) {
		balance -= amount;
	}	

	// blockchain type selection
	public List<Block> getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(List<Block> blockchain) {
		this.blockchain = blockchain;
	}
	
	// transaction type selection 
	public Map<String, Transaction> getTransPool() {
		return transPool;
	}
	
	public void setTransPool(Map<String, Transaction> transPool) {
		this.transPool = transPool;		
	}
}
