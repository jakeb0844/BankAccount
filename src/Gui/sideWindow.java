package Gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Account.Account;
import Buttons.addDeposit;
import Buttons.addWithdraw;
import Buttons.viewAcctInfo;
import DepositTransaction.Job;
import DepositTransaction.Other;
import Main.Runner;
import WithdrawTransaction.ATM;
import WithdrawTransaction.Food;
import WithdrawTransaction.Gas;
import WithdrawTransaction.OtherW;
import WithdrawTransaction.Utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class sideWindow {

	public static  JFrame frame;
	public static JPanel panel;
	private int onlyOnce=0;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static double width = screenSize.getWidth();
	public static double height = screenSize.getHeight();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Runner.mainAccount.load("Account");
				Runner.deposits.load("Deposits");
				Runner.withdraws.load("Withdraws");
				
				
					sideWindow window = new sideWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public sideWindow() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		
		
		
		
		frame = new JFrame();
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		//This is the mouse enter/exit functionality
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				onlyOnce++;
				if(onlyOnce<=1){
					frame.dispose();
					frame.setUndecorated(false);
					frame.setBounds((int)width-300, 0, 300, 300);
					
					frame.setVisible(true);
					addDeposit.openDepoWindow();
					frame.add(addDeposit.addDepo);
					addWithdraw.openWithFrame();;
					frame.add(addWithdraw.addWith);
					viewAcctInfo.openInfoFrame();
					frame.add(viewAcctInfo.info);
					/*System.out.println(addDeposit.addDepo.getX());
					System.out.println(addDeposit.addDepo.getX()+addDeposit.addDepo.getWidth());*/
		
				}
			}
			@Override
			public void mouseExited(MouseEvent e){
				
				//System.out.println(e.getX() + " " + e.getY());
				
				if(e.getX() < 34 || e.getX() > 275){ //|| e.getX() > (addDeposit.addDepo.getX()+addDeposit.addDepo.getWidth()+7)){
					frame.dispose();
					//frame.setUndecorated(true);
					//frame.setBounds((int)width-300, 0, 300, 150);
					mini();
					frame.setVisible(true);
					onlyOnce=0;
				}
				else if(e.getY() > 265){// || e.getY() > (addDeposit.addDepo.getY()+addDeposit.addDepo.getHeight()+50)){
				
						frame.dispose();
						//frame.setUndecorated(true);
						//frame.setBounds((int)width-300, 0, 300, 150);
						//frame.setVisible(true);
						mini();
						frame.setVisible(true);
						onlyOnce=0;
					}
				}
			
			
		});
		
		/*frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("X: "+e.getX() + " " + addDeposit.addDepo.getX());
				System.out.println("Y: "+e.getY() + " " + addDeposit.addDepo.getY());
				//System.out.println(e.getLocationOnScreen());
				
			}
		});*/
		
		
		//this is the side bar function
		mini();
		//frame.setBounds((int)width-300, 0, 300, 150);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		//frame.setUndecorated(true);
		//addDeposit.openDepoWindow();
		//addWithdraw.openWithFrame();
		//frame.getContentPane().add(addDeposit.addDepo);
		//frame.getContentPane().add(addWithdraw.addWith);
		
		panel = new JPanel();
		
		panel.setBounds(10, 11, 264, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblYourAccount = new JLabel("Your Account");
		lblYourAccount.setBounds(panel.getWidth()/3, 11, 100, 14);
		panel.add(lblYourAccount);
		
		JLabel lblDate = new JLabel("Today's Date:");
		lblDate.setBounds(10, 40, 100, 20);
		panel.add(lblDate);
				
		JLabel lblCurrentAmount = new JLabel("Current Amount:");
		lblCurrentAmount.setBounds(lblDate.getX(), lblDate.getY()+20, 100, 20);
		panel.add(lblCurrentAmount);
		
		JLabel lblTotalDeposits = new JLabel("Total Deposits:");
		lblTotalDeposits.setBounds(lblCurrentAmount.getX(),lblCurrentAmount.getY()+20, 100, 20);
		panel.add(lblTotalDeposits);
		
		JLabel lblTotalWithdraws = new JLabel("Total Withdraws:");
		lblTotalWithdraws.setBounds(lblTotalDeposits.getX(), lblTotalDeposits.getY()+20, 100, 20);
		panel.add(lblTotalWithdraws);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPanel.setBounds(lblTotalWithdraws.getWidth()+10, lblDate.getY()-10, 150, 100);
		infoPanel.setLayout(null);
		panel.add(infoPanel);
		
		final JLabel date = new JLabel();
		date.setBounds(lblDate.getX(), 12, 150, 16);
		infoPanel.add(date);
		
		final JLabel amount = new JLabel();
		amount.setBounds(date.getX(),date.getY()+20, 120, 16);
		infoPanel.add(amount);
		
		final JLabel totalDep = new JLabel();
		totalDep.setBounds(amount.getX(),amount.getY()+20, 120, 16);
		infoPanel.add(totalDep);
		
		final JLabel totalWith = new JLabel();
		totalWith.setBounds(totalDep.getX(),totalDep.getY()+20, 120, 16);
		infoPanel.add(totalWith);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Runner.deposits.save("Deposits");
				Runner.mainAccount.save("Account");
				Runner.withdraws.save("Withdraws");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				getInfo(date,amount,totalDep,totalWith);
			}
		});
		
		
		
	}//end initialize
	
	public static void mini(){
		frame.setBounds((int)width-300, 0, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
	}
	public static void getInfo(JLabel date, JLabel amount, JLabel totalDep, JLabel totalWith){
		Account acc = Runner.mainAccount.getAccount(0);
		//gets the current date
		final Date now = new Date();
		final DateFormat dateFmt = DateFormat.getDateInstance(DateFormat.LONG);
		String DATE =  dateFmt.format(now); 
		date.setText(DATE);
		
		amount.setText("$"+String.valueOf(acc.getCurrentBal()));
		
		totalDep.setText("$"+String.valueOf(Runner.deposits.getTotal()));
		totalWith.setText("$"+String.valueOf(Runner.withdraws.getTotal()));
	}
	
}
