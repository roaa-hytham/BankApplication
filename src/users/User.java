package users;

import accounts.Account;
import exceptions.EmptyInputException;
import exceptions.NegativeInputException;
import exceptions.NonNumberException;
import exceptions.NotEnoughBalanceException;

public class User extends Account {

	public User() {
		super();
	}

	public void deposit(String b) throws NegativeInputException, NonNumberException, EmptyInputException {
		if (b.isBlank())
			throw new EmptyInputException();
		for (int i = 0; i < b.length(); i++)
			if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z' || b.charAt(i) >= 'A' && b.charAt(i) <= 'Z')
				throw new NonNumberException();
		double bb = Double.parseDouble(b);
		if (bb < 0)
			throw new NegativeInputException();
		super.setBalance(getBalance() + bb);
		System.out.println("Deposit added!");
	}

	public void withdrawal(String b) throws NotEnoughBalanceException, NonNumberException, EmptyInputException, NegativeInputException {
		if (b.isBlank())
			throw new EmptyInputException();
		for (int i = 0; i < b.length(); i++)
			if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z' || b.charAt(i) >= 'A' && b.charAt(i) <= 'Z')
				throw new NonNumberException();
		double bb = Double.parseDouble(b);
		if (bb < 0)
			throw new NegativeInputException();
		if (getBalance() < bb)
			throw new NotEnoughBalanceException();
		super.setBalance(getBalance() - bb);
		System.out.println("Withdrawal done!");
	}

	public double checkBalance() {
		return super.getBalance();
	}

}
