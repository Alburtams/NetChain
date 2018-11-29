package net.optimization.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weifeng Hao
 * Write for the basic blockchain data structure(block)
 */
public class Block {
	private final String bid; // the id of the block
	private final String parent; // the parent address of the current block
	private final List<Transaction> transactions;  //the transaction list of the block
	private final NetNode miner; // the miner who mined the block
	private final double reward;  // the reward to the miner(the reward include:transaction fee and fixed fee)

	public Block(String bid, String parent, List<Transaction> trans, NetNode miner, double fixedFee) {
		this.bid = bid;
		this.parent = parent;
		transactions = new ArrayList<>();
		this.miner = miner;		
		double fees = 0;
		// the reward to the miner(the reward include:transaction fee and fixed fee)
		for (Transaction t : trans) {
			transactions.add(t);
			fees += t.getFee();
		}
		reward = fixedFee + fees;		
	}

	public String getBid() {
		return bid;
	}

	public String getParent() {
		return parent;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public NetNode getMiner() {
		return miner;
	}

	public double getReward() {
		return reward;
	}
		
	/** Gets the amount of coins destined to the Node tn in the transactions of the Block.
	 */
	public double getTransactionsAmountIfRecipient(NetNode tn)
	{
		int amount = 0;		
		for (Transaction t: transactions) {
			if (t.getOutput() == tn)
				amount += t.getAmount();
		}
		return amount;		
	}
}
