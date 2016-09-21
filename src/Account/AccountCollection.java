package Account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DepositTransaction.Job;
import Gui.sideWindow;
import Main.Runner;
import Storage.PackageCollection;


public class AccountCollection extends PackageCollection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	public AccountCollection(){
		super();
	}
	
	
	
	public void addAccount(Account a)
	{
		super.addElement(a);
		 
	}
	
	public Account getAccount(int i)
	{
		return (Account)super.getElement(i);
	}
	
public void createAcct(){
		
		final JFrame frame = new JFrame("Create Account");
		
		frame.setBounds((int)sideWindow.width/5, (int)sideWindow.height/5, 300, 300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JLabel title = new JLabel("Create Account");
		title.setBounds(frame.getWidth()/3, 5, 100, 20);
		frame.getContentPane().add(title);
		
		JLabel name = new JLabel("Name of the Account:");
		name.setBounds(frame.getWidth()/8-30, frame.getHeight()/6, 150, 20);
		frame.getContentPane().add(name);
		
		JLabel bal = new JLabel("Starting Balanace:");
		bal.setBounds(name.getX(),name.getY()+30,150,20);
		frame.getContentPane().add(bal);
		
		final JTextField nameField = new JTextField();
		nameField.setBounds(name.getX()+150, name.getY(), 100, 20);
		frame.getContentPane().add(nameField);
		
		final JTextField balField = new JTextField();
		balField.setBounds(bal.getX()+150, bal.getY(), 100, 20);
		frame.getContentPane().add(balField);
		
		JButton submit = new JButton("Create Account");
		submit.setBounds(frame.getWidth()/5, frame.getHeight()-150, 150, 20);
		frame.getContentPane().add(submit);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account a = new Account(nameField.getText(),Double.parseDouble(balField.getText()));
				sideWindow.mainAccount.addAccount(a);
				
				frame.dispose();
				 sideWindow.deposits.load("Deposits");
				 sideWindow.withdraws.load("Withdraws");
				
				
					sideWindow window;
					try {
						window = new sideWindow();
						window.frame.setVisible(true);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
			}
		});
		
		
		
	}
	
}
