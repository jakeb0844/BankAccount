package Main;

import Account.Account;
import Account.AccountCollection;
import DepositTransaction.DepositCollection;
import DepositTransaction.Job;
import WithdrawTransaction.Food;
import WithdrawTransaction.WithdrawsCollection;



public class Runner {
	
	public static AccountCollection mainAccount = new AccountCollection();
	public static WithdrawsCollection withdraws = new WithdrawsCollection();
	public static DepositCollection deposits = new DepositCollection();
	
	public static void main(String[] args) {
		
		Account a = new Account("Jake Busby", 3318.57);
		//Food f = new Food(25.00, "Popeyes", "4/30/16", "7:00 PM");
		//Job j = new Job(250, "4/30/16");
		
		//deposits.addDeposit(j);
		//withdraws.addWithdraw(f);
		mainAccount.addAccount(a);
		//System.out.println(a.getName());
		//System.out.println(a.getStartingBal());
		
		//j.add(a,j.getIncome());
		
		//System.out.println(a.getCurrentBal());
		
		//f.subtract(a, f.getCost());
		
		//System.out.println(a.getCurrentBal());
		
		/*withdraws.load("Withdraws");
		deposits.load("Deposits");
		mainAccount.load("Account");
		*/
		
		/*for(int i=0; i < withdraws.getSize(); i++){
			Food ff = new Food();
			
			if(withdraws.getElement(i).getClass().equals(ff.getClass())){
				ff = (Food) withdraws.getElement(i);
				System.out.println(ff.getCost());
			}
			
			
		}
		
		
		for(int i=0; i < deposits.getSize(); i++){
			Job jj = new Job();
			
			if(deposits.getElement(i).getClass().equals(jj.getClass())){
				jj = (Job) deposits.getElement(i);
				System.out.println(jj.getIncome());
			}
			
		}
		
		//System.out.println(mainAccount.getSize());
		
		for(int i=0; i < mainAccount.getSize(); i++){
			Account acc = new Account();
			
			if(mainAccount.getElement(i).getClass().equals(acc.getClass())){
				acc = mainAccount.getAccount(i);
				System.out.println(acc.getName());
				System.out.println(acc.getCurrentBal());
				
			}
		}*/
		
		//Account a = mainAccount.getAccount(0);
		//a.viewAccountDetails(0);
		
		//withdraws.save("Withdraws");
		//deposits.save("Deposits");
		mainAccount.save("Account");
		
	}

}
