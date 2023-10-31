package controllLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import businessLogic.Authotication;
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
	 private static int pin ;
	 private static int account;
	 private static String fname;
	 private static String lname;
	 private static double amount;
	 private static int id;
	 private static int acc;
	 private static Authotication aut;
	 private static String placeholder;
	private static void panel2s() {
			userinterface.panel2.add(p2.getPanel1());
			pressButtons = p2.add_number_buttons();
			p2.getPanel1().revalidate();
			userinterface.panel2.revalidate();
			userinterface.panel1.add(atsc.panelSettings());
			userinterface.panel1.repaint();
			aut = new Authotication("ATMdatabase","root","");
			ButtonsArray();
			login();
			placeholder="";
			
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
					atsc.login().setText("");
					
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
						i=0;
						successlogin();
					}
				}
				else if(text=="next" || text =="Enter") {
					placeholder = atsc.login().getText();
					atsc.login().setText("");
					move =true;
					atsc.login().setText("");
					String option = position();
					if(option=="setfirstName") {
						if(placeholder.length()>0) {
							aut.setfname(placeholder);
							placeholder="";
							sname();
						}else {
							JOptionPane.showMessageDialog(null,"name must not be emty");
						}
					}
					else if(option=="setSurName") {
						if(placeholder.length()>0) {
							aut.setlname(placeholder);
							placeholder="";
							id();
						}else {
							JOptionPane.showMessageDialog(null,"name must not be emty");
						}
							
					}
					else if(option=="setpassword") {
						if(placeholder.length() >= 3) {
							aut.setPin(Integer.parseInt(placeholder));
							placeholder ="";
							boolean saved = aut.savepersonalinformation();
							if(!saved) {
								JOptionPane.showMessageDialog(null,"failed try again");
								login();
							}else {
								i=0;
								acc = aut.update();
								signupsuccess();
								successlogin();
							}
						}else {
							JOptionPane.showMessageDialog(null,"put atleast 4 digits");
						}
					}
					else if(option=="withdraw") {
						if(placeholder.length()>0) {
							amount = Double.parseDouble(placeholder);
							placeholder = "";
							withdrawUserInterfacepin();
						}else {
							JOptionPane.showMessageDialog(null, "amount cant be null");
						}
					}
					else if(option=="deposit") {
						if(placeholder.length()>0) {
						amount = Integer.parseInt(placeholder);
						placeholder ="";
						if(amount>=0)
						DepositUserInterfacepin();
					}else {
						JOptionPane.showMessageDialog(null, "amount cant be null");
					}
						
					}
					else if(option=="checkbalance") {
						if(placeholder.length()>=4) {
							i=0;
							pin = Integer.parseInt(placeholder);
							placeholder ="";
							boolean success = aut.pinValidation(pin);
							if(success) {
								atsc.login().setText("");
								Checkbalance(aut.checkBalance());
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect pin please login again to continue");
								login();
							}
						}else {
							JOptionPane.showMessageDialog(null, "pin must be 4 digit or more ");
						}
					}
					else if(option=="id") {
						if(placeholder.length() >= 7) {
							aut.setPin(Integer.parseInt(placeholder));
							placeholder ="";
							password();
						}else {
							JOptionPane.showMessageDialog(null,"id shoulde be atlease 8 digits");
						}	
					}
					else if(option=="login") {
						if(placeholder.length()>=1) {
							aut.setaccount(Integer.parseInt(placeholder));
							atsc.login().setText("");
							placeholder ="";
							pin();
						}else {
							JOptionPane.showMessageDialog(null,"your account must not be null");
						}
						
					}
					else if(option=="pin") {
						if(placeholder.length()>=4) {
							aut.setPin(Integer.parseInt(placeholder));
							atsc.login().setText("");
							placeholder ="";
							boolean check = aut.login();
							if(check) {
								i=0;
								acc = aut.update();
								loginsuccess();
								successlogin();
							}else {
								login();
								JOptionPane.showMessageDialog(null, "incorrect credetials");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "pin must be 4 digits");
						}
							
					}
					else if(option =="Depositpin") {
						if(placeholder.length()>=4) {
						i=0;
						pin = Integer.parseInt(placeholder);
						placeholder ="";
						boolean success = aut.pinValidation(pin);
						if(success) {
							if(aut.deposit(amount)) {
								depositSuccess();
								successlogin();
							}else {
								JOptionPane.showMessageDialog(null, "erro occurred please try again");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "err occured");
							login();
						}
						}else {
							JOptionPane.showMessageDialog(null, "pin must be a 4 digit or more");
						}
					}
					else if(option =="withdrawpin") {
						if(placeholder.length()>=4) {
						i=0;
						pin = Integer.parseInt(placeholder);
						placeholder="";
						boolean success = aut.pinValidation(pin);
						if(success) {
							if(aut.withdraw(amount)) {
								withdrawsuccess();
								successlogin();
							}else {
								JOptionPane.showMessageDialog(null, "something went wrong");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect pin please login again to continue");
							login();
						}
						}
						else {
							JOptionPane.showMessageDialog(null, "pin must be a 4 digit or more");
						}
					}
				}else if(text=="withdraw"){
						atsc.login().setText("");
						withdrawUserInterface();
					}else if(text == "Deposit"){
						atsc.login().setText("");
						DepositUserInterface();
					}else if(text=="check balance"){
						atsc.login().setText("");
						CheckBalanceUserInterface();
					
					}else if(text=="log out") {
						login();
					}else if(text == "clear") {
						char [] plc = placeholder.toCharArray();
						text="";
						for(int z =0;z<placeholder.length()-1;z++) {
							text += plc[z];
						}
						placeholder=text;
						atsc.login().setText(text);
					}
					else {
					placeholder += text;
					atsc.login().setText(placeholder);
				}
			}
		});
	}
	private static JButton[]  transfer;
	private static void login() {
		i=0;
		keep("login");
		closescreen();
		pressButtons =atsc.LoginScreen();
		transfer = atsc.LoginScreen();
		pressButtons[0].setText("sign up");
		pressButtons[1].setVisible(true);
		ButtonsArray();
		userinterface.panel2.remove(p2.getPanel2());
		userinterface.panel2.repaint();
		userinterface.panel1.repaint();
		userinterface.panel1.repaint();
		
	}
	private static void loginsuccess() {
		JOptionPane.showMessageDialog(null, "logged in successful");
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
		closescreen();
		atsc.login().setText(Integer.toString(acc));
		atsc.label().setText("account number is ");
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
	private static void withdrawsuccess() {
		 JOptionPane.showMessageDialog(null, "you have withdrawn "+ amount + "successfully");
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

	private static void Checkbalance(double balance){
		keep("checkbalancepin");
		atsc.label().setText("Acount "+acc + " balance");
		atsc.login().setText(Double.toString(balance));
		transfer[1].setVisible(false);
	}

	private static void fname() {
		i=1;
		keep("login");
		i=2;
		keep("setfirstName");
		openscreen();
		atsc.login().setText("");
		atsc.label().setText("enter your FirstName");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	private static void sname() {
		keep("setSurName");
		openscreen();
		atsc.login().setText("");
		atsc.label().setText("enter your SurName");
		pressButtons[0].setText("back");
		pressButtons[1].setText("next");
		userinterface.panel1.repaint();
	}
	private static void id() {
		keep("id");
		closescreen();
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
	private static void signupsuccess() {
		JOptionPane.showMessageDialog(null, "you have created Account successfully ");
	}
	private static void depositSuccess() {
		 JOptionPane.showMessageDialog(null, "you have deposited " + amount + "ksh successfull ");
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
	private static void closescreen() {
		atsc.login().setEditable(false);
	}
	private static void openscreen() {
		atsc.login().setEditable(true);
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
		atsc.panelSettings().repaint();
		p2.getPanel1().revalidate();
		userinterface.panel2.revalidate();
		panel2s();	
	}

}
