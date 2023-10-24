package userInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class AtmKeypads {
	private JButton Clear, login , signin , Enter;
	private JPanel buttonPanel;
	public AtmKeypads() {
		buttonPanel =new JPanel();
		panelSettings();
		Clear =new JButton();
		login =new JButton();
		Enter =new JButton();
		signin =new JButton();
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
	public JPanel getPanel() {
		return buttonPanel;
		
	}

}
