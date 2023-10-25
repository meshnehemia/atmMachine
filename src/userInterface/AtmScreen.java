package userInterface;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class AtmScreen {
	private JTextField login;
	private JLabel label;
	private JPanel panel;
	private JButton btn1,btn2;
	private JButton [] btns;
	private BevelBorder border;
	public AtmScreen() {
		login = new JTextField();
		label =new JLabel();
		panel =new JPanel();
		border =new BevelBorder(5);
		btn1 =new JButton();
		btn2 = new JButton();
		
	}
	public JButton[] LoginScreen() {
		btns = new JButton[2];
		label.setText("enter the account number");
		label.setBounds(30,50,200,20);
		login.setEditable(false);
		login.setBounds(20,80,170,30);
		btn1.setText("sign up");
		btn1.setFocusable(false);
		btn1.setBackground(Color.magenta);
		btn1.setBounds(20,140,80,30);
		btn2.setText("next");
		btn2.setFocusable(false);
		btn2.setBackground(Color.magenta);
		btn2.setBounds(110,140,80,30);
		panel.add(label);
		panel.add(login);
		panel.add(btn1);
		panel.add(btn2);
		btns[0]=btn1;
		btns[1]=btn2;
		return btns;
		
	}
	public JPanel panelSettings() {
		panel.setBorder(border);
		panel.setVisible(true);
		panel.setLayout(null);
		panel.setBounds(50,50,200,200);
		panel.setBackground(Color.BLUE);
		return panel;
	}
	public JTextField login() {
		return login;
		
	}
	public JLabel label() {
		return label;	
	}

	
}
