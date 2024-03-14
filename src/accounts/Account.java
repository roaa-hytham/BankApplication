package accounts;

public class Account {
	private double balance;

	public Account() {
		balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double b) {
		if (b < 0)
			return;
		balance= b;
	}
	
}
