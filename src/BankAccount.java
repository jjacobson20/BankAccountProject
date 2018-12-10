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
	
	public BankAccount(String name)
	{
		accNum = nextAccNum;
		this.name = name;
		balance = 0;
		nextAccNum++;
	}
	
	public BankAccount(String name, double balance)
	{
		accNum = nextAccNum;
		this.name = name;
		this.balance = balance;
		nextAccNum++;
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}
	
	public String toString()
	{
		return "" + accNum + "\t" + name + "\t" + balance;
	}
}
