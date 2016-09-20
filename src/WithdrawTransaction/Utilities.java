package WithdrawTransaction;

import java.io.Serializable;

public class Utilities extends Withdraw implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	private double cost;
	private String store,date,description,type;
	
	public Utilities(){
		
	}
	
	public Utilities(double cost, String store, String date, String description){
		this.store=store;
		this.cost=cost;
		this.date=date;
		this.description=description;
		
	}
	
	
	public double getCost(){
		return cost;
	}
	
	public String getStore(){
		return store;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getType(){
		return "Utilities";
	}

}
