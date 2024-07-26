/**
 * The Bank class is crucial for generating and storing accounts
 * Utilizes serialization and deserialization
 * @author Ethan Jones
 */

import java.io.*;
import java.util.ArrayList;

public class Bank {

	private ArrayList<Account> accounts;
	private final String FILE_PATH = "accounts.ser";
	
	public Bank()
	{
		this.accounts = new ArrayList<>();
		loadAccounts();
	}
	
	/**
	 * Adds an account and saves the account in the bank object
	 * @param account
	 */
	public void addAccount(Account account) {
		accounts.add(account);
		saveAccounts();
	}
	
	/**
	 * @param accountNum
	 * @return A user's account
	 */
	public Account getAccount(String accountNum) {
		for(Account account : accounts) {
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		
		return null;
	}
	
	public ArrayList<Account> getAllAccounts() {
		return accounts;
	}
	
	public void deposit(String accountNum, double amount) {
		Account account = getAccount(accountNum);
		if(account != null) {
			account.deposit(amount);
			saveAccounts();
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	public void withdraw(String accountNum, double amount) {
		Account account = getAccount(accountNum);
		if(account != null && account.getBalance() >= amount) {
			account.withdraw(amount);
			saveAccounts();
		}
		else {
			System.out.println("Withdrawl unsuccessful.");
		}
	}
	
	public void clearAccounts() {
		accounts.clear();
		saveAccounts();
		System.out.println("All accounts have been cleared.");
	}
	
	private void saveAccounts() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
			oos.writeObject(accounts);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadAccounts() {
		File file = new File(FILE_PATH);
		if(file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
				accounts = (ArrayList<Account>) ois.readObject();
			}
			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
