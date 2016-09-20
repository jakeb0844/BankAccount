package WithdrawTransaction;

import java.io.Serializable;

import Account.Account;

public class Withdraw implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID =45;

	public void subtract(Account acc, double cost){
		
		double num = acc.getCurrentBal();
		
		acc.setCurrentBal((num-cost));
		
	}
	
	
}
