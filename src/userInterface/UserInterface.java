package userInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.*;
public class UserInterface{
	private  JFrame frame;
	public  JPanel panel1 ;
	public JPanel panel2;
	public  UserInterface() {
		frame =new JFrame();
		frame.setTitle("ATM Machine");
		frame.setBounds(200, 50, 700, 400);
		frame.setLayout(new GridLayout());
		frame.setResizable(false);
		panel2settings();
		panel1settings();
		
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	}
	private void panel1settings() {
		panel1 =new JPanel();
		panel1.setLayout(null);
		panel1.setVisible(true);
		panel1.setBackground(Color.DARK_GRAY);
	}
	public void panel2settings() {
		panel2 =new JPanel();
		panel2.setVisible(true);
		panel2.setLayout(null);
		panel2.setBackground(Color.blue);
	}
}
