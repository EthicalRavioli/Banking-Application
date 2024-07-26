/**
 * The Transaction class is used to generate a transaction when money is deposited or withdrawn from their account
 * @author Ethan Jones
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.text.DecimalFormat;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String transactionID;
	private LocalDateTime transactionDateTime;
	private double amount;
	private String type; //the type of transaction (deposit or withdraw)
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Transaction(String transactionID, String type, double amount) {
		this.transactionID = transactionID;
		this.transactionDateTime = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
		
	}
	
	/**
	 * Override toString to display data associated with the transaction
	 */
	public String toString() {
		return "Transaction[" + "transactionID= " + transactionID + " , transactionDateTime= " + transactionDateTime + " , type= " + type + " , amount= " + df.format(amount);
	}
	
}
