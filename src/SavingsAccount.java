/**
 * 
 * @author jeremy
 * Period 6
 * Savings Account
 *
 */
public class SavingsAccount extends BankAccount 
{
	
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	/**
	 * Savings account extends bank account, has an interest rate, and a minimum balance
	 * @param n name of person that holds the account
	 * @param b starting balance of the account
	 * @param r interest rate
	 * @param mb minimum balance the account can be
	 * @param mbf fee charged when balance goes under minimum
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	/**
	 * Savings account extends bank account, has an interest rate, and a minimum balance
	 * @param n name of person that holds the account
	 * @param r interest rate
	 * @param mb minimum balance the account can be
	 * @param mbf fee charged when balance goes under minimum
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	/**
	 * Withdraw money from the account
	 * @param amt amount of money to withdraw
	 */
	public void withdraw(double amt)
	{
		if(super.getBalance() - amt < 0) throw(new IllegalArgumentException());
		
		if(super.getBalance() - amt < MIN_BAL)
		{
			super.withdraw(amt + MIN_BAL_FEE);
		}
		
		else super.withdraw(amt);
	}
	
	/**
	 * Transfer money from one account to another
	 * @param other bank account receiving the money
	 * @param amt amount of money to transfer
	 */
	public void transfer(BankAccount other, double amt)
	{
		//accounts under same name
		if(super.getName() == other.getName())
		{
			//balance cannot be negative
			if(other.getBalance() - amt < 0)
			{
				throw(new IllegalArgumentException());
			}
			
			if(other.getBalance() - amt < MIN_BAL)
			{
				super.withdraw(amt + MIN_BAL_FEE);
				super.deposit(amt - MIN_BAL_FEE);
			}
			
			super.withdraw(amt);			
			other.deposit(amt);
		}
				
		else throw(new IllegalArgumentException());
	}
	
	/**
	 * Calculates and adds interest to balance, called in end of month update
	 */
	public void addInterest()
	{	
		super.deposit((super.getBalance() * intRate) - super.getBalance());
	}
	
	/**
	 * Calls the add interest method at end of the month
	 */
	public void endOfMonthUpdate()
	{
		addInterest();
	}
}
