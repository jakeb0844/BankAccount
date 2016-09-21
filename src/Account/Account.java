package Account;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import DepositTransaction.Deposit;
import DepositTransaction.Job;
import DepositTransaction.Other;
import Gui.sideWindow;
import Main.Runner;
import WithdrawTransaction.Food;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	
	private String userName;
	private double startingBal;
	private double currentBal;
	private String dateCreated;
	
	final Date now = new Date();
	final DateFormat dateFmt = DateFormat.getDateInstance(DateFormat.LONG);
	final DateFormat timeFmt = DateFormat.getTimeInstance (DateFormat.SHORT);
	

	public Account(){
		
	}
		
	
	public Account(String userName, double startingBal){
		
		this.userName = userName;
		this.startingBal = startingBal;
		this.currentBal=startingBal;
		
		String date =  dateFmt.format(now) + " " + timeFmt.format(now);
		
		this.dateCreated=date;
		
	}
	
	
	public String getName(){
		return userName;
	}
	
	
	public double getStartingBal(){
		return startingBal;
	}
	
	public void setCurrentBal(double num){
		currentBal = num;
	}
	
	public double getCurrentBal(){
		return currentBal;
	}
	
	public String getDateCreated(){
		return dateCreated;
	}
	
	
	public void viewAccountDetails(JEditorPane edit, Style bold, StyledDocument doc) throws BadLocationException{
		
		//System.out.println("=========="+this.userName+"==========");
		doc.insertString(doc.getLength(), this.getName()+"\n", null);
		//System.out.println("Account created on " + this.dateCreated);
		doc.insertString(doc.getLength(), "Date created: "+this.dateCreated+"\n",null);
		//System.out.println("Starting Balance: "+this.startingBal); 
		//doc.insertString(doc.getLength(), "Starting Bal: $"+String.valueOf(this.startingBal)+"\n",null);
		//System.out.println("Current Balance: "+this.currentBal);
		doc.insertString(doc.getLength(), "Current Bal: $"+String.valueOf(this.currentBal)+"\n\n",null);
		
		
		
	}
		
	
	
	
	
}
