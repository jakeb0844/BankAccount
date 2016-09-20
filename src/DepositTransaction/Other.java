package DepositTransaction;

import java.io.Serializable;

public class Other extends Deposit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	private double income;
	private String jobDes,date;

	public Other(){
		
	}
	
	public Other(double income, String jobDes, String date){
		this.income=income;
		this.jobDes=jobDes;
		this.date=date;
	}
	
	
	public double getIncome(){
		return income;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getJobDescription(){
		return jobDes;
	}
	
	public String getType(){
		return "Other";
	}
	
	
}
