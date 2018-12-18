/**
 * 
 * @author jeremy
 * Period 6
 * Bank Account
 *
 */
public abstract class BankAccount
{
	private static int nextAccNum;
	private int accNum;
	private String name;
	private double balance;
	
	/**
	 * BankAccount constructor, holds the owner's name, account number, and balance
	 * 
	 * @param name	name of person that holds the account
	 */
	public BankAccount(String name)
	{
		accNum = nextAccNum;
		this.name = name;
		balance = 0;
		nextAccNum++;
	}
	
	/**
	 * Constructor that has a balance argument to set initial balance as something other than 0
	 * @param name	name of the person that holds the account
	 * @param balance	set a different initial balance than 0
	 */
	public BankAccount(String name, double balance)
	{
		accNum = nextAccNum;
		this.name = name;
		this.balance = balance;
		nextAccNum++;
	}
	
	/**
	 * Takes an amount and adds it to the balance
	 * @param amt	amount of money to be added
	 */
	public void deposit(double amt)
	{
		if(amt > 0)
		{
			balance += amt;
		}
		
		else
		{
			throw(new IllegalArgumentException());
		}
	}
	
	/**
	 * Takes an amount and subtracts it from the balance
	 * @param amt	amount of money to be subtracted
	 */
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	
	/**
	 * Gets the name of account holder
	 * @return account holder name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the balance of the account
	 * @return	balance of the account
	 */
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
	/**
	 * Move funds from the current account to another
	 * @param other	bank account to receive the funds
	 * @param amt	amount to transfer
	 */
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}
	
	/**
	 * Returns a string containing the account number, name, and balance
	 * @return string with the account number, name, and balance
	 */
	public String toString()
	{
		return "" + accNum + "\t" + name + "\t" + balance;
	}
}
