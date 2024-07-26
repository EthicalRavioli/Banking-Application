/**
 * The Account class deals with the needs a user might have in a bank
 * @author Ethan Jones
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.UUID;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String accountHolderName;
	private String accountNum;
	private double balance;
	private LinkedList<Transaction> transactions;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Account(String accountHolderName, double balance)
	{
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		accountNum = generateAccountNum();
		this.transactions = new LinkedList<>();
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @return the accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public LinkedList<Transaction> getTransactions() {
		return transactions;
	}
	
	/**
	 * Generates a random account number
	 * @return An account number with 12 digits
	 */
	private String generateAccountNum() {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString().replaceAll("[^0-9]", "");
		
		while (uuidString.length() < 12) {
            uuidString += UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        }
		
		return uuidString.substring(0, 12);
	}

	/**
	 * deposits a specified amount into the account
	 */
	public void deposit(double amount) {
		balance += amount;
		Transaction transaction = new Transaction("TRAN" + (transactions.size() + 1), "Deposit", amount);
		transactions.add(transaction);
		System.out.println("Deposit of $" + df.format(amount) + " successful.");
	}
	
	/**
	 * withdraws a specified amount from the account
	 * precondition: balance greater than or equal to the amount being withdrawn
	 */
	public boolean withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
			Transaction transaction = new Transaction("TRAN" + (transactions.size() + 1), "Withdrawl", amount);
			transactions.add(transaction);
			System.out.println("Withdrawl of $" + df.format(amount) + " successful.");
			return true;
		}
		else {
			System.out.println("Insufficient funds.");
			return false;
		}
	}
	
	public String toString() {
		return "Account: \n" + " Name on Account: " + accountHolderName + "\n Account Number: " + accountNum + "\n Balance: " + df.format(balance);
	}
	
	
	
}
