package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Gui.sideWindow;
import Main.Runner;

public class viewAcctInfo {
	
	public static JButton info;
	public static JFrame frame;
	public static JPanel panel;
	
	public static void openInfoFrame(){
		
		info = new JButton("View Acct Info");
		info.setBounds(addDeposit.addDepo.getX(), addDeposit.addDepo.getY()+30, 120, 20);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideWindow.frame.dispose();
				try {
					infoFrame();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	public static void infoFrame() throws ParseException, BadLocationException{
		
		frame = new JFrame("Account Information");
		frame.setBounds((int)sideWindow.width/5, (int)sideWindow.height/5, 500, 500);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				sideWindow.frame.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		panel = new JPanel();
		//panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBounds(5, 5, 470, 450);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 455, 350);
		panel.add(scrollPane);
				
		JEditorPane pane = new JEditorPane();
		pane.setContentType("text/html");
		//pane.setBounds(5, 5, 455,350);
		panel.add(pane);
		
		pane.setEditable(false);
		scrollPane.setViewportView(pane);
		
		JButton back = new JButton("Back");
		back.setBounds(panel.getWidth()/3+30, scrollPane.getHeight()+50, 100, 20);
		panel.add(back);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				sideWindow.frame.setVisible(true);
			}
		});
		
		
		String acct;
		String deposit;
		String withdraws;
		//pane.setText(null);
		
		StyledDocument doc = (StyledDocument) pane.getDocument();

	    Style bold = doc.addStyle("Bold", null);


	    StyleConstants.setBold(bold, true);
	    //doc.insertString(doc.getLength(), "Some Text", style);
	    //doc.insertString(doc.getLength(), "\n \t Some Text", null);
		Runner.mainAccount.getAccount(0).viewAccountDetails(pane, bold, doc);
		Runner.deposits.getDetails(pane, bold, doc);
		Runner.withdraws.getDetails(pane, bold, doc);
		
		
	}

	
	
	
}
