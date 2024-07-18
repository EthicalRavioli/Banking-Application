import java.util.ArrayList;

public class Bank {

	private ArrayList<Account> accounts;
	
	public Bank()
	{
		this.accounts = new ArrayList<>();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public Account getAccount(String accountNum) { //need to make it so that accounts are stored locally in the computer
		for(Account account : accounts) {
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		
		return null;
	}
	
	public void deposit(String accountNum, double amount) {
		Account account = getAccount(accountNum);
		if(account != null) {
			account.deposit(amount);
		}
		else {
			System.out.println("Account not found.");
		}
	}
	
	public void withdraw(String accountNum, double amount) {
		Account account = getAccount(accountNum);
		if(account != null && account.getBalance() >= amount) {
			account.withdraw(amount);
		}
		else {
			System.out.println("Withdrawl unsuccessful.");
		}
	}
}
