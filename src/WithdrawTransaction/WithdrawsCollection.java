package WithdrawTransaction;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import DepositTransaction.Deposit;
import DepositTransaction.Job;
import DepositTransaction.Other;
import Storage.PackageCollection;


public class WithdrawsCollection extends PackageCollection<Object> implements Serializable {

	
	private static final long serialVersionUID = 45;

	public WithdrawsCollection(){
		super();
	}
	
	public void addWithdraw(Withdraw w)
	{
		super.addElement(w);
		
	}
	
	public void addWithdraw(int index, Withdraw d){
		ArrayList<Withdraw>temp = new ArrayList<Withdraw>();
		ArrayList<Withdraw>temp1 = new ArrayList<Withdraw>();
		
		for(int i=0; i < this.getSize(); i++){
			
			if(i < index){
				temp.add(this.getWithdraw(i));
			}
			
			if(i >= index){
				temp1.add(this.getWithdraw(i));
			}
			
		}
		
		temp.add(d);
		this.removeAll();
		
		for(int i =0; i < temp.size(); i++){
			this.addWithdraw(temp.get(i));
		}
		
		for(int i =0; i < temp1.size(); i++){
			this.addWithdraw(temp1.get(i));
		}
		
		
	}
	

	public void removeAll(){	
		
		while(this.getSize() != 0){
			this.removeElement(0);
		}
			
	}
	
	public Withdraw getWithdraw(int i){
		return (Withdraw)super.getElement(i);
	}
	
	
	public double getTotal(){
		double amount=0;
		
		for(int i=0; i < this.getSize(); i++){
			ATM atm = new ATM();
			Food food = new Food();
			Gas gas = new Gas();
			Utilities util = new Utilities();
			OtherW other = new OtherW();
			
			if(this.getElement(i).getClass().equals(atm.getClass())){
				atm = (ATM) this.getElement(i);
				amount += atm.getAmount();
			}
			else if(this.getElement(i).getClass().equals(food.getClass())){
				food = (Food) this.getElement(i);
				amount += food.getCost();
			}
			else if(this.getElement(i).getClass().equals(gas.getClass())){
				gas = (Gas) this.getElement(i);
				amount += gas.getCost();
			}
			else if(this.getElement(i).getClass().equals(util.getClass())){
				util = (Utilities) this.getElement(i);
				amount += util.getCost();
			}
			else{
				other = (OtherW) this.getElement(i);
				amount += other.getCost();
			}
			
		}
		
		return amount;
	}
	
	public void getDetails(JEditorPane edit, Style bold, StyledDocument doc) throws ParseException, BadLocationException{
		String info = "";
		ATM atm = new ATM();
		Gas gas = new Gas();
		Food food = new Food();
		Utilities util = new Utilities();
		OtherW other = new OtherW();
		
		ArrayList<ATM> atms = new ArrayList<ATM>();
		ArrayList<OtherW> others = new ArrayList<OtherW>();
		ArrayList<Food> foods = new ArrayList<Food>();
		ArrayList<Gas> gases = new ArrayList<Gas>();
		ArrayList<Utilities> utils = new ArrayList<Utilities>();
		
		sortDates();
		
		for(int i =0; i < this.getSize(); i++){
			
			if(this.getWithdraw(i).getClass().equals(atm.getClass())){
				
				atm = (ATM) this.getWithdraw(i);
				atms.add(atm);
				
			}
			else if(this.getWithdraw(i).getClass().equals(other.getClass())){
				other = (OtherW) this.getWithdraw(i);
				others.add(other);
			}
			
			else if(this.getWithdraw(i).getClass().equals(food.getClass())){
				food = (Food)this.getWithdraw(i);
				foods.add(food);
			}
			
			else if(this.getWithdraw(i).getClass().equals(gas.getClass())){
				gas = (Gas)this.getWithdraw(i);
				gases.add(gas);
			}
			
			else {
				util = (Utilities)this.getWithdraw(i);
				utils.add(util);
			}
			
		}
		
		
		doc.insertString(doc.getLength(), "\n\nWithdraws: $"+getTotal()+"\n", bold);
		
		//info=info+"<b><u>Jobs</u></b>:<br>";
		doc.insertString(doc.getLength(), "     ATM: \n", null);
		
		for(int i =0; i < atms.size(); i++){
			info+="\t-"+atms.get(i).getDate() + "  $"+ atms.get(i).getAmount()+"\n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		info="";
		
		//info+="<b><u>Others</u></b>: <br>";
		
		
		doc.insertString(doc.getLength(), "     Food:\n", null);
		for(int i=0; i < foods.size(); i++){
			info+="\t-"+foods.get(i).getDate() + "  $"+ foods.get(i).getCost()+"    \n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		info="";
		
		doc.insertString(doc.getLength(), "     Gas:\n", null);
		for(int i=0; i < gases.size(); i++){
			info+="\t-"+gases.get(i).getDate() + "  $"+gases.get(i).getCost() + "    \n";
		}
		
		info="";
		
		doc.insertString(doc.getLength(), "     Utilities:\n" , null);
		
		for(int i=0; i < utils.size(); i++){
			info+="\t-"+utils.get(i).getDate() + "  $"+utils.get(i).getCost() + "     \n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		info="";
		
		doc.insertString(doc.getLength(), "     Other:\n", null);
		
		for(int i=0; i < others.size(); i++){
			info+="\t-"+others.get(i).date() + "  $"+ others.get(i).getCost()+"     \n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		
		
	}
	
	
public void sortDates() throws ParseException{
		
	
	if(this.getSize() > 0){
		ArrayList<Deposit>temp = new ArrayList<Deposit>();
		Calendar myDate = new GregorianCalendar();
		DateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		
		ATM atm = new ATM();
		ATM	atm2 = new ATM();
		Food food = new Food();
		Food food2 = new Food();
		Gas  gas = new Gas();
		Gas  gas2 = new Gas();
		OtherW	other = new OtherW();
		OtherW  other2 = new OtherW();
		Utilities	util = new Utilities();
		Utilities	util2 = new Utilities();
		Date date;
		Date date2;
		
		int count =1;
		
		while(count != this.getSize()){
			
			count =1;
			
			for(int i=0; i < this.getSize(); i++){
				
				if( i != this.getSize()-1){

				
					if(this.getWithdraw(i).getClass().equals(atm.getClass())){
						
						atm = (ATM) this.getWithdraw(i);
						date = formatter.parse(atm.getDate());
						
					}
					else if(this.getWithdraw(i).getClass().equals(other.getClass())){
						other = (OtherW) this.getWithdraw(i);
						date = formatter.parse(other.date());
					}
					
					else if(this.getWithdraw(i).getClass().equals(food.getClass())){
						food = (Food)this.getWithdraw(i);
						date = formatter.parse(food.getDate());
					}
					
					else if(this.getWithdraw(i).getClass().equals(gas.getClass())){
						gas = (Gas)this.getWithdraw(i);
						date = formatter.parse(gas.getDate());
					}
					
					else {
						util = (Utilities)this.getWithdraw(i);
						date = formatter.parse(food.getDate());
					}
					
					
					
					if(this.getWithdraw(i+1).getClass().equals(atm2.getClass())){
						
						atm2 = (ATM) this.getWithdraw(i+1);
						date2 = formatter.parse(atm2.getDate());
						
					}
					else if(this.getWithdraw(i+1).getClass().equals(other2.getClass())){
						other2 = (OtherW) this.getWithdraw(i+1);
						date2 = formatter.parse(other2.date());
					}
					
					else if(this.getWithdraw(i+1).getClass().equals(food.getClass())){
						food2 = (Food)this.getWithdraw(i+1);
						date2 = formatter.parse(food2.getDate());
					}
					
					else if(this.getWithdraw(i+1).getClass().equals(gas.getClass())){
						gas2 = (Gas)this.getWithdraw(i+1);
						date2 = formatter.parse(gas2.getDate());
					}
					
					else {
						util2 = (Utilities)this.getWithdraw(i+1);
						date2 = formatter.parse(food2.getDate());
					}
				
				
					
					if(date.compareTo(date2) > 0){
						swap(this.getCollection(),i,i+1);
					}
					else{
						count++;
					}
					
				}
				
				
			}//end for
			
			
		}//end while
		
	}//if
	}//end method
	
public static void swap(ArrayList<Object> arg, int index1, int index2){
		
		ArrayList<Object> temp = new ArrayList<Object>();
		//date2 == index1 && date1 == index2
		Object date1 = arg.get(index1);
		//System.out.println(date1);
		Object date2 = arg.get(index2);
		//System.out.println(date2);
		Object date3 = new Date();
		
		date3 = date1;
		
		arg.remove(index2);
		arg.add(index2, date3);
		
		date3 = date2;
		arg.remove(index1);
		arg.add(index1, date3);		
		
	}
	
}
