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
	 * Checking account extends bank account, with transaction fees and overdraft fees
	 * @param name name of person who holds the account
	 * @param odf overdraft fee
	 * @param tf transaction fee
	 * @param freeTrans amount of transactions that are free
	 */
	public CheckingAccount(String name, double odf, double tf, int freeTrans)
	{
		super(name);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	/**
	 * Checking account extends bank account, with transaction fees and overdraft fees
	 * this constructor allows a balance to be passed
	 * @param name name of person who holds the account
	 * @param balance starting balance of account
	 * @param odf overdraft fee
	 * @param tf transaction fee
	 * @param freeTrans amount of transactions that are free
	 */
	public CheckingAccount(String name, double balance, double odf, double tf, int freeTrans)
	{
		super(name, balance);
		OVER_DRAFT_FEE = odf;;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	/**
	 * deposit money into the account
	 * @param amt amount of money to deposit
	 */
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
	
	/**
	 * Withdraw money from the account
	 * @param amt amount of money to withdraw
	 */
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
			{
				super.withdraw(amt + TRANSACTION_FEE);
			}
			
			else
			{
				super.withdraw(amt);
			}
		}
		
		numTransactions++;
	}
	
	/**
	 * Transfers money from one bank account to under if both are owned by the same person
	 * @param other bank account receiving the money
	 * @param amt amount of money to transfer
	 */
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
	
	/**
	 * Resets the transaction count to 0 at the end of the month
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}
