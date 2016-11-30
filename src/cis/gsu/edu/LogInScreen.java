package cis.gsu.edu;

import javax.swing.*;
import java.awt.FlowLayout;

public class LogInScreen extends JFrame {
	public LogInScreen(){
		
		setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		add(new JLabel("User Name"));
		add(new JTextField(10));
		add(new JLabel("Password"));
		add(new JTextField(15));
	}
	
	public static void main(String[] args) {
		LogInScreen frame = new LogInScreen();
		frame.setTitle("User Log in");
		frame.setSize(550,250);
		frame.setVisible(true);
	}
	
	

}
