package WithdrawTransaction;

import java.io.Serializable;

public class Gas extends Withdraw implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private double cost,gallons;
	private String store,date,type;
	
	public Gas(){
		
	}
	
	public Gas(double cost, double gallons, String store, String date){
		this.cost=cost;
		this.date=date;
		this.gallons=gallons;
		this.store=store;
	}
	
	public double getCost(){
		return cost;
	}
	
	public double getGal(){
		return gallons;
	}
	
	public String getStore(){
		return store;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getType(){
		return "Gas";
	}
	
	

}
