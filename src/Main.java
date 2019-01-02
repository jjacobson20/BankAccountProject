/**
 * 
 * @author jeremy
 * Period 6
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		
		final int OVER_DRAFT_FEE = 15;
		final double RATE = 0.025;
		final double TRANSACTION_FEE = 1.5;
		final int MIN_BAL = 300;
		final int MIN_BAL_FEE = 10;
		final int FREE_TRANSACTIONS = 10;
		
		Scanner in = new Scanner(System.in);
		boolean run = true;
		
		while(run)
		{
			System.out.println("Would you like to:\n\t(Add) an account\n\t(Make) a transaction\n\t(Close) program");
			String userInput = in.nextLine();
			while(!userInput.equals("add") && !userInput.equals("make") && !userInput.equals("close"))
			{
				System.out.println("Invalid input, try again");
				userInput = in.nextLine();
			}
			
			if(userInput.equals("close"))
			{
				run = false;
			}
			
			if(userInput.equals("make"))
			{
				System.out.println("What type of account would you like to make?");
				while(!userInput.equals("checking") && !userInput.equals("savings"))
				{
					System.out.println("Invalid input, try again");
				}
				
				if(userInput.equals("checking"))
				{
					String name;
					System.out.print("Enter your name: ");
					while(!in.hasNextLine())
					{
						System.out.println("Invalid input try again: ");
					}
					name = in.nextLine();
					
					double overDraftFee = 0;
					while(!in.hasNextDouble())
					{
						System.out.println("Enter the overdraft fee: ");
					}
					overDraftFee = in.nextDouble();
					
					double transactionFee = 0;
					while(!in.hasNextDouble())
					{
						System.out.println("Enter the transaction fee: ");
						
					}
					transactionFee = in.nextDouble();
					
					int freeTransactions;
					while(!in.hasNextInt())
					{
						System.out.println("Enter the number of free transations: ");
					}
					freeTransactions = in.nextInt();
					
					try
					{
						bankAccounts.add(new CheckingAccount(name, overDraftFee, transactionFee, freeTransactions));
					}
					
					catch(IllegalArgumentException e)
					{
						System.out.println("Checking account creation failed!");
					}
				}
				
				
			}
			
			if(userInput.equals("add"))
			{
						
			}
		}
		
	}
	
}
