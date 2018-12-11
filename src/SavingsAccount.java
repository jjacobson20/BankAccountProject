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
	
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public void withDraw(double amt)
	{
		if(super.getBalance() - amt < 0) throw(new IllegalArgumentException());
		
		if(super.getBalance() - amt < MIN_BAL)
		{
			super.withdraw(amt + MIN_BAL_FEE);
		}
		
		else super.withdraw(amt);
	}
	
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
	
	public void addInterest()
	{	
		super.deposit((super.getBalance() * intRate) - super.getBalance());
	}
	
	public void endOfMonthUpdate()
	{
		addInterest();
	}
}
