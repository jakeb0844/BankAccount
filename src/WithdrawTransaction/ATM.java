package WithdrawTransaction;

import java.io.Serializable;

public class ATM extends Withdraw implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private double amount;
	private String store, date,type;
	
	public ATM(){
		
	}
	
	public ATM(double amount, String store, String date){
		this.amount=amount;
		this.date=date;
		this.store=store;
	}
	
	
	public double getAmount(){
		return amount;
	}
	
	public String getStore(){
		return store;
	}
	
	public String getDate(){
		return date;
	}
	
	public static String getType(){
		return "ATM";
	}

}
