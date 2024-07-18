import java.time.LocalDateTime;

public class Transaction {

	private String transactionID;
	private LocalDateTime transactionDateTime;
	private double amount;
	private String type;
	
	public Transaction(String transactionID, String type, double amount) {
		this.transactionID = transactionID;
		this.transactionDateTime = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
		
	}
	
}
