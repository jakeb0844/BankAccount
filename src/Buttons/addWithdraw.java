package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Gui.sideWindow;
import Main.Runner;
import WithdrawTransaction.ATM;
import WithdrawTransaction.Food;
import WithdrawTransaction.Gas;
import WithdrawTransaction.OtherW;
import WithdrawTransaction.Utilities;

public class addWithdraw {

	public static JButton addWith;
	private static JFrame frame;
	private static JPanel dynPanel;
	
	private static final JComboBox comboBox = new JComboBox();

	
	public static void openWithFrame(){
		
		 addWith = new JButton("Add Withdraw");
			addWith.setBounds(150, sideWindow.frame.getHeight()-100, 120, 20);
			addWith.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sideWindow.frame.dispose();
					addWith();
				}
			});
		
	}
	
	
public static void addWith(){
		
		
		frame = new JFrame("Withdrawl");
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
		dynPanel.setBounds(0, 75, 280, 250);
		//dynPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		dynPanel.setLayout(null);
		frame.getContentPane().add(dynPanel);
		
		JLabel title = new JLabel("Add Withdrawl");
		title.setBounds(frame.getWidth()/2-40, 5, 100, 20);
		frame.getContentPane().add(title);
		
		final JLabel sel = new JLabel("Select a type:");
		sel.setBounds(15, 50, 100, 20);
		frame.getContentPane().add(sel);
		
		final JComboBox types = new JComboBox();
		types.setBounds(sel.getX()+100, sel.getY(), 100, 25);
		frame.getContentPane().add(types);
		
		ATM ATM = new ATM();
		Food Food = new Food();
		Gas Gas = new Gas();
		final OtherW Other = new OtherW();
		final Utilities Utilities = new Utilities();
		
		types.addItem(ATM.getType());
		types.addItem(Food.getType());
		types.addItem(Gas.getType());
		types.addItem(Utilities.getType());
		types.addItem(Other.getType());
		
		atmPanel(sel,types);
		
		types.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String type = (String)types.getSelectedItem();
				
				if(type.equals("ATM")){
					atmPanel(sel,types);
				}
				
				else if(type.equals("Other") || type.equals("Utilities")){
					otherUtilPanel(sel, types, type);
				}
				
				else if(type.equals("Food")){
					foodPanel(sel,types);
				}
				
				else{
					gasPanel(sel, types);
				}
				
				
			}
		});
		
	
	}

	public static void atmPanel(JLabel type, JComboBox box){
		dynPanel.removeAll();
		
		type.setBounds(15, 50, 100, 20);
		
		box.setBounds(type.getX()+150, type.getY(), 100, 25);
		
		JLabel amount = new JLabel("Enter Amount Withdrawn:");
		amount.setBounds(15, 10, 150, 20);
		dynPanel.add(amount);
		
		JLabel date = new JLabel("Enter Date:");
		date.setBounds(amount.getX(), amount.getY()+30, 100, 20);
		dynPanel.add(date);
		
		JLabel store = new JLabel("Enter the Store:");
		store.setBounds(date.getX(), date.getY()+30, 100, 20);
		dynPanel.add(store);
		
		final JTextField amountField = new JTextField();
		amountField.setBounds(amount.getX()+150, amount.getY(), 100, 20);
		dynPanel.add(amountField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+150, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		final JTextField storeField = new JTextField();
		storeField.setBounds(store.getX()+150, store.getY(), 100, 20);
		dynPanel.add(storeField);
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM atm= new ATM(Double.parseDouble(amountField.getText()), storeField.getText(), dateField.getText());
				atm.subtract(Runner.mainAccount.getAccount(0), atm.getAmount());
				Runner.withdraws.addWithdraw(atm);
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		dynPanel.repaint();
		
	}
	
	public static void otherUtilPanel(JLabel type, JComboBox box, final String obj){
		dynPanel.removeAll();
		
		box.setBounds(type.getX()+150, type.getY(), 100, 25);
		
		JLabel amount = new JLabel("Enter the Cost:");
		amount.setBounds(15, 10, 150, 20);
		dynPanel.add(amount);
		
		JLabel date = new JLabel("Enter Date:");
		date.setBounds(amount.getX(), amount.getY()+30, 100, 20);
		dynPanel.add(date);
		
		JLabel store = new JLabel("Enter the Store:");
		store.setBounds(date.getX(), date.getY()+30, 100, 20);
		dynPanel.add(store);
		
		JLabel des = new JLabel("Enter a Description:");
		des.setBounds(store.getX(), store.getY()+30, 120, 20);
		dynPanel.add(des);
		
		final JTextField amountField = new JTextField();
		amountField.setBounds(amount.getX()+150, amount.getY(), 100, 20);
		dynPanel.add(amountField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+150, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		final JTextField storeField = new JTextField();
		storeField.setBounds(store.getX()+150, store.getY(), 100, 20);
		dynPanel.add(storeField);
		
		final JTextField desField = new JTextField();
		desField.setBounds(des.getX()+150, des.getY(), 100, 20);
		dynPanel.add(desField);
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(obj.equals("Other")){
					OtherW other= new OtherW(Double.parseDouble(amountField.getText()), storeField.getText(), dateField.getText(), desField.getText());
					other.subtract(Runner.mainAccount.getAccount(0), other.getCost());
					Runner.withdraws.addWithdraw(other);
				}
				else{
					Utilities util = new Utilities(Double.parseDouble(amountField.getText()), storeField.getText(), dateField.getText(), desField.getText());
					util.subtract(Runner.mainAccount.getAccount(0), util.getCost());
					Runner.withdraws.addWithdraw(util);
				}
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		dynPanel.repaint();
	}
	
	public static void foodPanel(JLabel type, JComboBox box){
		dynPanel.removeAll();
		
		type.setBounds(15+10, 50, 100, 20);

		box.setBounds(type.getX()+150, type.getY(), 100, 25);
		
		JLabel amount = new JLabel("Enter the Cost:");
		amount.setBounds(15+10, 10, 150, 20);
		dynPanel.add(amount);
		
		JLabel date = new JLabel("Enter Date:");
		date.setBounds(amount.getX(), amount.getY()+30, 100, 20);
		dynPanel.add(date);
		
		JLabel store = new JLabel("Enter the Store:");
		store.setBounds(date.getX(), date.getY()+30, 100, 20);
		dynPanel.add(store);
		
		JLabel des = new JLabel("Enter a Description:");
		des.setBounds(store.getX(), store.getY()+30, 120, 20);
		dynPanel.add(des);
		
		
		final JTextField amountField = new JTextField();
		amountField.setBounds(amount.getX()+150, amount.getY(), 100, 20);
		dynPanel.add(amountField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+150, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		final JTextField storeField = new JTextField();
		storeField.setBounds(store.getX()+150, store.getY(), 100, 20);
		dynPanel.add(storeField);
		
		final JTextField desField = new JTextField();
		desField.setBounds(des.getX()+150, des.getY(), 100, 20);
		dynPanel.add(desField);
		desField.setEditable(false);
		
		final JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(des.getX()-20,des.getY(), 20, 20);
		dynPanel.add(checkBox);
		
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox.isSelected()){
				desField.setEditable(true);
				}
				else{
					desField.setEditable(false);
				}
		
			}
		});
		
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkBox.isSelected()){
					Food food = new Food(Double.parseDouble(amountField.getText()), storeField.getText(), desField.getText(), dateField.getText());
					food.subtract(Runner.mainAccount.getAccount(0), food.getCost());
					Runner.withdraws.addWithdraw(food);
				}
				else{
					Food food = new Food(Double.parseDouble(amountField.getText()), storeField.getText(), desField.getText());
					food.subtract(Runner.mainAccount.getAccount(0), food.getCost());
					Runner.withdraws.addWithdraw(food);
				}
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		dynPanel.repaint();
	}
	
	public static void gasPanel(JLabel type, JComboBox box){
		
		dynPanel.removeAll();
		
		type.setBounds(15, 50, 100, 20);

		box.setBounds(type.getX()+150, type.getY(), 100, 25);
		
		JLabel amount = new JLabel("Enter the Cost:");
		amount.setBounds(15, 10, 150, 20);
		dynPanel.add(amount);
		
		JLabel date = new JLabel("Enter the Date:");
		date.setBounds(amount.getX(), amount.getY()+30, 100, 20);
		dynPanel.add(date);
		
		JLabel store = new JLabel("Enter the Store:");
		store.setBounds(date.getX(), date.getY()+30, 100, 20);
		dynPanel.add(store);
		
		JLabel gal = new JLabel("Enter the Num. of Gal:");
		gal.setBounds(store.getX(), store.getY()+30, 140, 20);
		dynPanel.add(gal);
		
		
		final JTextField amountField = new JTextField();
		amountField.setBounds(amount.getX()+150, amount.getY(), 100, 20);
		dynPanel.add(amountField);
		
		final JTextField dateField = new JTextField();
		dateField.setBounds(date.getX()+150, date.getY(), 100, 20);
		dynPanel.add(dateField);
		
		final JTextField storeField = new JTextField();
		storeField.setBounds(store.getX()+150, store.getY(), 100, 20);
		dynPanel.add(storeField);
		
		final JTextField galField = new JTextField();
		galField.setBounds(gal.getX()+150, gal.getY(), 100, 20);
		dynPanel.add(galField);
				
		
		JButton add = new JButton("Add");
		add.setBounds(dynPanel.getWidth()/2-35, dynPanel.getHeight()-100, 100, 20);
		dynPanel.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gas gas = new Gas(Double.parseDouble(amountField.getText()), Double.parseDouble(galField.getText()),storeField.getText(), dateField.getText());
				gas.subtract(Runner.mainAccount.getAccount(0), gas.getCost());
				Runner.withdraws.addWithdraw(gas);
				
				
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		dynPanel.repaint();
		
	}
	
	
}
