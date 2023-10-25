package userInterface;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class AtmKeypads {
	private JButton Clear, Enter;
	private JButton withdraw ,Deposit ,checkBalance;
	private JPanel buttonPanel, optionPanel;
	public AtmKeypads() {
		buttonPanel =new JPanel();
		panelSettings();
		Clear =new JButton();
		optionPanel = new JPanel();
		Deposit = new JButton();
		withdraw =new JButton();
		checkBalance =new JButton();
		Enter =new JButton();
	}
	public JButton[] add_number_buttons() {
		int o=0;
		JButton[] btns =new JButton[12];
		
		for(int i=0;i<=9;i++) {
			JButton btn =new JButton(Integer.toString(i));
			//btn.setSize(170,80);	
			btn.setFocusable(false);
			btns[o]=btn;
			o++;
			add_button(btn);
		}
		Clear.setFocusable(false);
		Clear.setText("clear");
		btns[o]=Clear;
		o++;
		add_button(Clear);
		Enter.setText("Enter");
		Enter.setFocusable(false);
		btns[o]=Enter;
		o++;
		add_button(Enter);
		
		return btns;
	}
	public void panelSettings() {
		buttonPanel.setLayout(new GridLayout(4,3));
		buttonPanel.setBackground(Color.white);
		buttonPanel.setBounds(2,2,335,300);
	}
	public void add_button(JButton btn) {
		buttonPanel.add(btn);	
	}
	public JPanel getPanel1() {
		return buttonPanel;
		
	}
	public void optionPanelSetting() {
		optionPanel.setLayout(null);
		optionPanel.setBackground(Color.green);
		optionPanel.setBounds(2,310,335,90);
	}
	public JPanel getPanel2() {
		optionPanelSetting();
		return optionPanel;
	}
	public JButton[] transactionsBtns() {
		JButton[] btn = new JButton[3];
		checkBalance.setFocusable(false);
		checkBalance.setText("check balance");
		checkBalance.setBounds(230,4,100,45);
		checkBalance.setBackground(Color.magenta);
		optionPanel.add(checkBalance);
		btn[0]=checkBalance;
		
		withdraw.setFocusable(false);
		withdraw.setText("withdraw");
		withdraw.setBounds(120,4,100,45);
		withdraw.setBackground(Color.magenta);
		optionPanel.add(withdraw);
		btn[1]= withdraw;
		
		Deposit.setFocusable(false);
		Deposit.setText("Deposit");
		Deposit.setBounds(4,4,100,45);
		Deposit.setBackground(Color.magenta);
		optionPanel.add(Deposit);
		btn[2]= Deposit;
		return btn;
		
	}

}
