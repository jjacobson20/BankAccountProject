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
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	
	private static int numTransactions;
	
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
		super.deposit(amt - TRANSACTION_FEE);
	}
	
	public void withdraw(double amt)
	{
		if(super.getBalance() - amt < 0)
		{
			super.withdraw(amt + TRANSACTION_FEE + OVER_DRAFT_FEE);
		}
		
		
	}
	

}
