/**
 * The application class acts as the main driver for the bank app.
 * @author Ethan Jones
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nBanking Application created by Ethan Jones");
			System.out.println("Use the menu below to operate the app");
			System.out.println("1. Create an account");
			System.out.println("2. View account information");
			System.out.println("3. View account transaction history");
			System.out.println("4. Deposit money into an account");
			System.out.println("5. Withdraw money from an account");
			System.out.println("6. Show all accounts");
			System.out.println("7. Clear all accounts");
			System.out.println("8. Exit");
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Type the account holder's first and last name: ");
				input.nextLine();
				String name = input.nextLine();
				System.out.print("Type the account's balance: ");
				double balance = input.nextDouble();
				Account newAccount = new Account(name, balance);
				bank.addAccount(newAccount);
				System.out.println(newAccount);
				break;
			case 2:
				viewAccount(bank, input);
				break;
			case 3:
				viewAccountTransactionHistory(bank, input);
				break;
				
			case 4:
				performDeposit(bank, input);
				break;
			case 5:
				performWithdrawl(bank, input);
				break;
			case 6:
				showAllAccounts(bank);
				break;
			case 7:
				clearAllAccounts(bank);
				break;
			case 8:
				System.out.println("Exited.");
				input.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice, please select a valid option.");
					
			}
			
		}
	}
	
	/**
	 * This method takes the user's account ID and deposits a specified amount into the account.
	 * @param bank
	 * @param input
	 */
	private static void performDeposit(Bank bank, Scanner input) {
		System.out.print("Enter the account ID: ");
		String accountNum = input.next();
		System.out.print("Enter the amount to be deposited: ");
		double amount = input.nextDouble();
		bank.deposit(accountNum, amount);
	}
	
	/**
	 * This method takes the user's account ID and withdraws a specified amount from the account.
	 * Precondition: the amount to be withdrawn must be greater than or equal to the amount the user has in his or her account.
	 * @param bank
	 * @param input
	 */
	private static void performWithdrawl(Bank bank, Scanner input) {
		System.out.print("Enter the account ID: ");
		String accountNum = input.next();
		System.out.print("Enter the amount to be withdrawn: ");
		double amount = input.nextDouble();
		bank.withdraw(accountNum, amount);
	}
	
	/**
	 * This method displays the account information of an individual user
	 * @param bank
	 * @param input
	 */
	private static void viewAccount(Bank bank, Scanner input) {
		System.out.print("Enter the ID number of the account to view: ");
		String accountNum = input.next();
		Account account = bank.getAccount(accountNum);
		if(account != null) {
			System.out.println(account);
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	/**
	 * This method displays the transaction history for a given account
	 * @param bank
	 * @param input
	 */
	private static void viewAccountTransactionHistory(Bank bank, Scanner input) {
		System.out.print("Enter the account ID: ");
		String accountNum = input.next();
		Account account = bank.getAccount(accountNum);
		if(account != null) {
			LinkedList<Transaction> transactions = account.getTransactions();
			System.out.println("\nTransactions for Account ID " + accountNum);
			for(Transaction transaction : transactions) {
				System.out.println(transaction);
			}
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	/**
	 * This method displays all accounts that are stored in the bank class
	 * @param bank
	 */
	private static void showAllAccounts(Bank bank) {
		System.out.println("All accounts:");
		for(Account account : bank.getAllAccounts()) {
			System.out.println(account);
		}
	}
	
	/**
	 * This method clears all accounts stored in the bank class
	 * @param bank
	 */
	private static void clearAllAccounts(Bank bank) {
		bank.clearAccounts();
	}

}
