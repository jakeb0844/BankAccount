package DepositTransaction;

import java.io.Serializable;

public class Job extends Deposit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	private double income;
	private String date;
	
	
	public Job(){
		
	}
	
	public Job(double income, String date){
		this.income=income;
		this.date=date;
	}
	
	public double getIncome(){
		return income;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getType(){
		return "Job";
	}
	
	
}
