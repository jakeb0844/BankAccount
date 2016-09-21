package Buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DepositTransaction.Job;
import DepositTransaction.Other;
import Gui.sideWindow;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class addDeposit {
	
	public static JButton addDepo;
	private static JFrame frame;
	private static JPanel dynPanel;
	/**
	 * @wbp.nonvisual location=35,59
	 */
	private static final JComboBox comboBox = new JComboBox();
	
	
	public static void openDepoWindow(){
		
		
		
	    addDepo = new JButton("Add Deposit");
		addDepo.setBounds(25, sideWindow.frame.getHeight()-100, 120, 20);
		addDepo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideWindow.frame.dispose();
				addDepo();
			}
		});
	}
	
	public static void addDepo(){
		
		
		frame = new JFrame("Deposit");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				sideWindow.frame.setVisible(true);
			}
		});
		frame.setBounds((int)sideWindow.width/5, (int)sideWindow.height/5, 300, 300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		dynPanel = new JPanel();
		dynPanel.setBounds(0, 75, 250, 250);
		//dynPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		dynPanel.setLayout(null);
		frame.getContentPane().add(dynPanel);
		
		JLabel title = new JLabel("Add Deposit");
		title.setBounds(frame.getWidth()/2-40, 5, 100, 20);
		frame.getContentPane().add(title);
		
		final JLabel sel = new JLabel("Select a type:");
		sel.setBounds(15, 50, 100, 20);
		frame.getContentPane().add(sel);
		
		final JComboBox types = new JComboBox();
		types.setBounds(sel.getX()+100, sel.getY(), 100, 25);
		frame.getContentPane().add(types);
		
		Job Job = new Job();
		Other Other = new Other();
		
		types.addItem(Job.getType());
		types.addItem(Other.getType());
		
		jobPanel(sel,types);
		
		types.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String type = (String)types.getSelectedItem();
				
				if(type.equals("Job")){
					jobPanel(sel,types);
				}
				else{
					otherPanel(sel,types);
				}
				
			}
		});
		
	
	}
	
	public static void jobPanel(JLabel type, JComboBox box){
		
		box.setBounds(type.getX()+100, type.getY(), 100, 25);

		
		dynPanel.removeAll();
		
		JLabel income = new JLabel("Enter Income:");
		income.setBounds(15, 10, 100, 20);
		dynPanel.add(income);
		
		JLabel date = new JLabel("Enter Date:");
		date.setBounds(income.getX(), income.getY()+30, 100, 20);
		dynPanel.add(date);
		
		final JTextField incField = new JTextField();
		incField.setBounds(income.getX()+100, income.getY(), 100, 20);
		dynPanel.add(incField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+100, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Job job= new Job(Double.parseDouble(incField.getText()), dateField.getText());
				job.add(sideWindow.mainAccount.getAccount(0), job.getIncome());
				sideWindow.deposits.addDeposit(job);
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		dynPanel.repaint();
	}
	
	public static void otherPanel(JLabel type, JComboBox box){

		box.setBounds(type.getX()+125, type.getY(), 100, 25);
		
		dynPanel.removeAll();
		JLabel income = new JLabel("Enter Income:");
		income.setBounds(15, 10, 100, 20);
		dynPanel.add(income);
		
		JLabel des = new JLabel("Enter job description:");
		des.setBounds(income.getX(), income.getY()+30, 125, 20);
		dynPanel.add(des);
		
		JLabel date = new JLabel("Enter Date:");
		date.setBounds(des.getX(), des.getY()+30, 100, 20);
		dynPanel.add(date);
		
		final JTextField incField = new JTextField();
		incField.setBounds(income.getX()+125, income.getY(), 100, 20);
		dynPanel.add(incField);
		
		final JTextField desField = new JTextField();
		desField.setBounds(des.getX()+125, des.getY(), 100, 20);
		dynPanel.add(desField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+125, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Other other= new Other(Double.parseDouble(incField.getText()), desField.getText(),dateField.getText());
				other.add(sideWindow.mainAccount.getAccount(0), other.getIncome());
				sideWindow.deposits.addDeposit(other);
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		
		dynPanel.repaint();
	}
	
	
	
}
