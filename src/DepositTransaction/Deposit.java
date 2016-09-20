package DepositTransaction;

import java.io.Serializable;

import Account.Account;

public class Deposit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;

	public void add(Account acc, double income){
		double num=acc.getCurrentBal();
		
		acc.setCurrentBal((num+income));
		
	}
	
	public static String getDetails(){
		
		String temp="";
		
		
		
		
		return temp;
		
	}
	
}
