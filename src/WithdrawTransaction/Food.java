package WithdrawTransaction;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Food extends Withdraw implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private double cost;
	private String place;
	private String comments;
	private String date;
	private String type;
	
	/*final Date now = new Date();
	final DateFormat dateFmt = DateFormat.getDateInstance(DateFormat.LONG);
	final DateFormat timeFmt = DateFormat.getTimeInstance (DateFormat.SHORT);
	*/
	
	
	public Food(){
		
	}
	
	public Food(double cost, String place, String date){
		this.cost=cost;
		this.place=place;
		this.date=date;
		
		
	}
	
	public Food(double cost, String place, String comments, String date){
		this.cost=cost;
		this.place=place;
		this.date=date;
		this.comments=comments;
	}
	
	public String getPlace(){
		return place;
	}
	
	public double getCost(){
		return cost;
	}
	
	public String getComments(){
		return comments;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getType(){
		return "Food";
	}
	
}
