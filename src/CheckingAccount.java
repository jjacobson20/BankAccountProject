/**
 * 
 * @author jeremy
 * Period 6
 * Checking Account
 *
 */
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE;
	//must be negative
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	
	private static int numTransactions;
	
	/**
	 * 
	 * @param name
	 * @param odf
	 * @param tf
	 * @param freeTrans
	 */
	public CheckingAccount(String name, double odf, double tf, int freeTrans)
	{
		super(name);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	public CheckingAccount(String name, double balance, double odf, double tf, int freeTrans)
	{
		super(name, balance);
		OVER_DRAFT_FEE = odf;;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	public void deposit(double amt)
	{
		if(numTransactions < FREE_TRANS)
		{
			if(amt <= TRANSACTION_FEE) throw(new IllegalArgumentException());
			super.deposit(amt + TRANSACTION_FEE);
		}
		
		else
		{
			super.deposit(amt);
		}
		
		numTransactions++;
	}
	
	public void withdraw(double amt)
	{
		//withdraw cannot happen if balance is already negative
		if(super.getBalance() < 0) throw(new IllegalArgumentException());
		
		
		//overdraft if transaction makes balance negative
		if(numTransactions < FREE_TRANS)
		{
			if(super.getBalance() - amt + TRANSACTION_FEE < 0) super.withdraw(amt + TRANSACTION_FEE + OVER_DRAFT_FEE);
		}
		
		else
		{
			if(super.getBalance() - amt < 0)
		}
	
		
		
		else
		{
			super.withdraw(amt);
		}
		
		numTransactions++;
	}
	
	public void transfer(BankAccount other, double amt)
	{
		//accounts under same name
		if(super.getName() == other.getName())
		{
			//balance cannot be negative
			if(other.getBalance() - amt - TRANSACTION_FEE < 0)
			{
				throw(new IllegalArgumentException());
			}
			
			super.withdraw(amt + TRANSACTION_FEE);
			other.deposit(amt + TRANSACTION_FEE);
		}
		
		else throw(new IllegalArgumentException());
		
		numTransactions++;
	}
	
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}
