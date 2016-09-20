package WithdrawTransaction;

import java.io.Serializable;

public class OtherW extends Withdraw implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;

	private double cost;
	private String location, date, description,type;
	
	public OtherW(){
		
	}
	
	public OtherW(double cost, String location, String date, String description){
		this.cost=cost;
		this.location=location;
		this.date=date;
		this.description=description;
	}
	
	public double getCost(){
		return cost;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String date(){
		return date;
	}
	
	public String description(){
		return description;
	}
	
	public static String getType(){
		return "Other";
	}
}
