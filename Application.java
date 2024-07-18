import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			System.out.println("6. Exit");
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
				
				
			case 4:
				performDeposit(bank, input);
				break;
			case 5:
				performWithdrawl(bank, input);
				break;
			case 6:
				System.out.println("Exiting.");
				input.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice, please select a valid option.");
					
			}
			
		}
	}
	
	private static void performDeposit(Bank bank, Scanner input) {
		System.out.print("Enter the account ID: ");
		String accountNum = input.next();
		System.out.print("Enter the amount to be deposited: ");
		double amount = input.nextDouble();
		bank.deposit(accountNum, amount);
	}
	
	private static void performWithdrawl(Bank bank, Scanner input) {
		System.out.print("Enter the account ID: ");
		String accountNum = input.next();
		System.out.print("Enter the amount to be withdrawn: ");
		double amount = input.nextDouble();
		bank.withdraw(accountNum, amount);
	}
	
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

}
