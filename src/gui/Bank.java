package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import exceptions.EmptyInputException;
import exceptions.NegativeInputException;
import exceptions.NonNumberException;
import exceptions.NotEnoughBalanceException;
import users.User;

@SuppressWarnings("serial")
public class Bank extends JFrame implements ActionListener {
	User user;
	JTextPane amtxt;
	JTextArea amount;
	JTextPane error;
	JTextPane bltxt;
	JTextPane balance;
	JButton deposit;
	JButton withdrawal;
	JButton checkBalance;
	JButton exit;

	public Bank() {
		user = new User();

		amtxt = new JTextPane();
		amtxt.setBounds(100, 30, 70, 30);
		amtxt.setText("Amount: ");
		amtxt.setForeground(Color.black);
		amtxt.setBackground(null);
		amtxt.setEditable(false);
		amtxt.setOpaque(true);
		amtxt.setVisible(true);
		amtxt.setFont(new Font("MV Boli", Font.BOLD, 15));

		amount = new JTextArea();
		amount.setBounds(180, 30, 70, 30);
		amount.setForeground(Color.black);
		amount.setBackground(Color.white);
		amount.setEditable(true);
		amount.setOpaque(true);
		amount.setVisible(true);
		amount.setFont(new Font("MV Boli", Font.BOLD, 15));

		error = new JTextPane();
		error.setBounds(100, 70, 250, 30);
		error.setForeground(Color.red);
		error.setBackground(null);
		error.setEditable(false);
		error.setOpaque(true);
		error.setVisible(true);
		error.setFont(new Font("MV Boli", Font.BOLD, 15));

		bltxt = new JTextPane();
		bltxt.setBounds(100, 110, 70, 30);
		bltxt.setText("Balance: ");
		bltxt.setForeground(Color.black);
		bltxt.setBackground(null);
		bltxt.setEditable(false);
		bltxt.setOpaque(true);
		bltxt.setVisible(true);
		bltxt.setFont(new Font("MV Boli", Font.BOLD, 15));

		balance = new JTextPane();
		balance.setBounds(180, 110, 100, 30);
		balance.setForeground(Color.black);
		balance.setBackground(null);
		balance.setEditable(false);
		balance.setOpaque(true);
		balance.setVisible(true);
		balance.setFont(new Font("MV Boli", Font.BOLD, 15));

		deposit = new JButton();
		deposit.addActionListener(this);
		deposit.setBounds(100, 170, 140, 30);
		deposit.setBackground(Color.LIGHT_GRAY);
		deposit.setFocusable(false);
		deposit.setText("Deposit");
		deposit.setBorderPainted(false);

		withdrawal = new JButton();
		withdrawal.addActionListener(this);
		withdrawal.setBounds(260, 170, 140, 30);
		withdrawal.setBackground(Color.LIGHT_GRAY);
		withdrawal.setFocusable(false);
		withdrawal.setText("Withdrawal");
		withdrawal.setBorderPainted(false);

		checkBalance = new JButton();
		checkBalance.addActionListener(this);
		checkBalance.setBounds(100, 220, 140, 30);
		checkBalance.setBackground(Color.LIGHT_GRAY);
		checkBalance.setFocusable(false);
		checkBalance.setText("Check Balance");
		checkBalance.setBorderPainted(false);

		exit = new JButton();
		exit.addActionListener(this);
		exit.setBounds(260, 220, 140, 30);
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setFocusable(false);
		exit.setText("Exit");
		exit.setBorderPainted(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 500, 350);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		add(amtxt);
		add(amount);
		add(error);
		add(bltxt);
		add(balance);
		add(deposit);
		add(withdrawal);
		add(checkBalance);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == withdrawal) {
			try {
				user.withdrawal(amount.getText());
				error.setForeground(Color.blue);
				error.setText("Successful Withdrawal!");
			} catch (NotEnoughBalanceException e1) {
				error.setForeground(Color.red);
				error.setText("Not enough balance.");
			} catch (NonNumberException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a number.");
			} catch (EmptyInputException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a number.");
			} catch (NegativeInputException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a positive number.");
			}
		}

		if (e.getSource() == deposit) {
			try {
				user.deposit(amount.getText());
				error.setText("Successful Deposit!");
				error.setForeground(Color.blue);
			} catch (NegativeInputException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a positive number.");
			} catch (NonNumberException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a number.");
			} catch (EmptyInputException e1) {
				error.setForeground(Color.red);
				error.setText("Please enter a number.");
			}
		}

		if (e.getSource() == checkBalance) {
			balance.setText(user.checkBalance() + "");
			error.setText(null);
		}

		if (e.getSource() == exit) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new Bank();
	}

}
