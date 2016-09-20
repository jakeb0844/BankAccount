package DepositTransaction;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import Storage.PackageCollection;

public class DepositCollection extends PackageCollection<Object> implements Serializable{

	private static final long serialVersionUID = 45;

	public DepositCollection(){
		super();
	}
	
	public void addDeposit(Deposit d)
	{
		super.addElement(d);
		
	}
	
	public void addDeposit(int index, Deposit d){
		ArrayList<Deposit>temp = new ArrayList<Deposit>();
		ArrayList<Deposit>temp1 = new ArrayList<Deposit>();
		
		for(int i=0; i < this.getSize(); i++){
			
			if(i < index){
				temp.add(this.getDeposit(i));
			}
			
			if(i >= index){
				temp1.add(this.getDeposit(i));
			}
			
		}
		
		temp.add(d);
		this.removeAll();
		
		for(int i =0; i < temp.size(); i++){
			this.addDeposit(temp.get(i));
		}
		
		for(int i =0; i < temp1.size(); i++){
			this.addDeposit(temp1.get(i));
		}
		
		
		
	}
	
	public void removeAll(){	
		
		while(this.getSize() != 0){
			this.removeElement(0);
		}
			
	}
	
	
	
	public Deposit getDeposit(int i)
	{
		return (Deposit)super.getElement(i);
	}
	
	
	
	public double getTotal(){
		double amount =0;
		
		for(int i=0; i < this.getSize(); i++){
			Job j = new Job();
			Other o = new Other();
			
			if(this.getElement(i).getClass().equals(j.getClass())){
				j = (Job) this.getElement(i);
				amount += j.getIncome();
			}
			
			else{
				o = (Other) this.getElement(i);
				amount += o.getIncome();
			}
		}
		
		return amount;
		
	}
	
	public void getDetails(JEditorPane edit, Style bold, StyledDocument doc) throws ParseException, BadLocationException{
		String info = "";
		Job job = new Job();
		Other other = new Other();
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		ArrayList<Other> others = new ArrayList<Other>();
		
		sortDates();
		
		doc.insertString(doc.getLength(), "Deposits:  $"+getTotal()+"\n", bold);
		
		for(int i =0; i < this.getSize(); i++){
			
			if(this.getDeposit(i).getClass().equals(job.getClass())){
				job = (Job) this.getDeposit(i);
				jobs.add(job);
			}
			else{
				other = (Other) this.getDeposit(i);
				others.add(other);
			}
			
		}
		
		//info=info+"<b><u>Jobs</u></b>:<br>";
		doc.insertString(doc.getLength(), "     Job: \n", null);
		
		for(int i =0; i < jobs.size(); i++){
			info+="\t-"+jobs.get(i).getDate() + "  $"+ jobs.get(i).getIncome()+"\n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		info="";
		
		//info+="<b><u>Others</u></b>: <br>";
		doc.insertString(doc.getLength(), "     Other\n", null);
		
		for(int i=0; i < others.size(); i++){
			info+="\t-"+others.get(i).getDate() + "  $"+ others.get(i).getIncome()+"     " + others.get(i).getJobDescription()+"\n";
		}
		
		doc.insertString(doc.getLength(), info, null);
		
		
		
	}
	
	public void sortDates() throws ParseException{
		
		if(this.getSize() > 0){
		ArrayList<Deposit>temp = new ArrayList<Deposit>();
		Calendar myDate = new GregorianCalendar();
		DateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		
		Job job = new Job();
		Job job2 = new Job();
		Other other = new Other();
		Other other2 = new Other();
		Date date;
		Date date2;
		
		int count =1;
		
		while(count != this.getSize()){
			
			count =1;
			
			for(int i=0; i < this.getSize(); i++){
				
				if( i != this.getSize()-1){

				
				if(this.getDeposit(i).getClass().equals(job.getClass())){
					
					job = (Job) this.getDeposit(i);
					date = formatter.parse(job.getDate());
					
				}
				else{
					other = (Other) this.getDeposit(i);
					date = formatter.parse(other.getDate());
				}
				
				if(this.getDeposit(i+1).getClass().equals(job2.getClass())){
					
					job2 = (Job) this.getDeposit(i+1);
					date2 = formatter.parse(job2.getDate());
				}
				else{
					other2 = (Other) this.getDeposit(i+1);
					date2 = formatter.parse(other2.getDate());
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
		}//end if
		
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
