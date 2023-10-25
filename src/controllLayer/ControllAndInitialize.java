package controllLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import userInterface.AtmKeypads;
import userInterface.AtmScreen;
import userInterface.UserInterface;

public class ControllAndInitialize {
	private static UserInterface userinterface;
	 private static AtmKeypads p2;
	 private static JButton[] pressButtons;
	 private static AtmScreen atsc;
	 private static String[] keepTrack;
	 private static int i;
	private static void panel2s() {
			userinterface.panel2.add(p2.getPanel1());
			pressButtons = p2.add_number_buttons();
			p2.getPanel1().revalidate();
			userinterface.panel2.revalidate();
			userinterface.panel1.add(atsc.panelSettings());
			userinterface.panel1.repaint();
			ButtonsArray();
			login();
	}
	private static void ButtonsArray() {
		for(int i =0; i < pressButtons.length;i++) {
			addActionListeners(pressButtons[i]);
		}
	}
	static boolean move =true;
	private static void addActionListeners(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent e) {
			JButton btns =(JButton) e.getSource();
			respond(btns.getText());
			}
			private void respond(String text) {
				if(text=="sign up") {
					fname();
				}
				else if(text=="back") {
					
					String option = back();
					move =false;
					if(option=="login") {
						login();
					}
					else if(option=="setfirstName") {
						fname();
					}
					else if(option=="setSurName") {
						sname();
					}else if(option=="id") {
						id();
					}
					else if(option=="setpassword") {
						password();
					}if(option=="success") {
						successlogin();
					}
				}
				else if(text=="next") {
					move =true;
					String option = position();
					if(option=="setfirstName") {
						sname();
					}
					else if(option=="setSurName") {
						id();
					}
					else if(option=="setpassword") {
						
					}
					else if(option=="withdraw") {
						withdrawUserInterfacepin();
						
					}
					else if(option=="deposit") {
						DepositUserInterfacepin();
						
					}
					else if(option=="checkbalance") {
						Checkbalance();
						
					}
					else if(option=="id") {
						password();
						
					}
					if(option=="login") {
						pin();
					}
					if(option=="pin") {
						successlogin();
					}
				}else if(text=="withdraw"){
					withdrawUserInterface();
				}else if(text == "Deposit"){
					DepositUserInterface();
				}else if(text=="check balance"){
					CheckBalanceUserInterface();
				}
				
				
				else {
					atsc.login().setText(text);
				}
			}
		});
	}
	private static JButton[]  transfer;
	private static void login() {
		keep("login");
		pressButtons =atsc.LoginScreen();
		transfer = atsc.LoginScreen();
		pressButtons[0].setText("sign up");
		ButtonsArray();
		
	}
	
	private static void pin() {
		keep("pin");
		atsc.login().setText("");
		atsc.label().setText("enter your pin");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
		
	}
	private static void successlogin() {
		keep("success");
		atsc.login().setText("accountnumber");
		atsc.label().setText("logged in");
		transfer[0].setText("log out");
		transfer[1].setVisible(false);
		pressButtons=p2.transactionsBtns();
		ButtonsArray();
		userinterface.panel2.add(p2.getPanel2());
		userinterface.panel2.repaint();
		userinterface.panel1.repaint();
	}
	private static void withdrawUserInterface(){
		keep("withdraw");
		transfer[1].setVisible(true);
		atsc.label().setText("Enter Amount To withdraw");
		transfer[0].setText("back");
	}
	private static void withdrawUserInterfacepin(){
		keep("withdrawpin");
		atsc.label().setText("Enter pin to withdraw");
		atsc.login().setText("");
	}
	private static void DepositUserInterface(){
		keep("deposit");
		transfer[1].setVisible(true);
		atsc.label().setText("Enter Amount to deposit");
		transfer[0].setText("back");
	}
	private static void DepositUserInterfacepin(){
		keep("Depositpin");
		atsc.label().setText("Enter pin to deposit");
		atsc.login().setText("");
	}
	private static void CheckBalanceUserInterface(){
		keep("checkbalance");
		transfer[1].setVisible(true);
		atsc.label().setText("Enter Pin to checkBalance");
		transfer[0].setText("back");
	}

	private static void Checkbalance(){
		keep("checkbalancepin");
		atsc.label().setText("your balance is ");
		atsc.login().setText("68767876709");
		transfer[1].setVisible(false);
	}

	private static void fname() {
		keep("setfirstName");
		atsc.login().setText("");
		atsc.label().setText("enter your FirstName");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	private static void sname() {
		keep("setSurName");
		atsc.login().setText("");
		atsc.label().setText("enter your SurName");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	private static void id() {
		keep("id");
		atsc.login().setText("");
		atsc.label().setText("enter your Id");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	private static void password() {
		keep("setpassword");
		atsc.login().setText("");
		atsc.label().setText("enter your password");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	
	
	
	private static void keep(String string) {
		i+=1;
		keepTrack[i] =string;
	}
	private static String back() {
		if(move) {
			i-=1;
			return keepTrack[i];
		}else {
			i-=2;
			return keepTrack[i];
		}
	}
	private static String position() {
		return keepTrack[i];
	}
	public static void main(String[] args) {
		keepTrack = new String[100];
		i =-1;
		userinterface =new UserInterface();
		p2 =new AtmKeypads();
		atsc =new AtmScreen();
		panel2s();	
	}

}
