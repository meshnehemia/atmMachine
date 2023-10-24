package controllLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import userInterface.AtmKeypads;
import userInterface.UserInterface;

public class ControllAndInitialize {
	private static UserInterface userinterface;
	 private static AtmKeypads p2;
	 private static JButton[] pressButtons;
	private static void panel2s() {
			userinterface.panel2.add(p2.getPanel());
			pressButtons = p2.add_number_buttons();
			p2.getPanel().revalidate();
			userinterface.panel2.revalidate();
	}
	private static void ButtonsArray() {
		for(int i =0; i < pressButtons.length;i++) {
			addActionListeners(pressButtons[i]);
		}
	}
	
	private static void addActionListeners(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			JButton btns =(JButton) e.getSource();
			respond(btns.getText());
			}
			private void respond(String text) {
				System.out.println(text);
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		userinterface =new UserInterface();
		p2 =new AtmKeypads();
		panel2s();
		ButtonsArray();

	}

}
