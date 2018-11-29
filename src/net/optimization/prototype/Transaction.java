package net.optimization.prototype;

/**
 * 
 * @author Weifeng Hao
 * Write for the basic blockchain data structure(transaction)
 *
 */
public class Transaction {
	private final String tid; // the id of the transaction
	private final NetNode input; // the input of the transaction
	private final NetNode output; // the output of the transaction
	private final double amount; // the balance of the transaction 
	private final double fee; // the fee 
	
	public Transaction(String id, NetNode input, NetNode output, double amount, double fee) {
		tid = id;
		this.input = input;
		this.output = output;
		this.amount = amount;
		this.fee = fee;
	}
	
	public String getTid() {
		return tid;
	}
	
	public NetNode getOutput() {
		return output;
	}
	
	public double getAmount() {
		return amount;
	}

	public double getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		return "Transaction " + tid + ": Source = " + input.getID() + ", Destination = " +
				output.getID() + ", amount = " + amount + ", fee = " + fee;
	}

}
