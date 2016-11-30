package cis.gsu.edu;

import java.awt.*;
import javax.swing.*;

public class RegistrationScreen extends JFrame {
	public RegistrationScreen(){
		setLayout(new GridLayout(10,2,5,5));
		
		add(new JLabel ("First name"));
		add(new JTextField (8));
		add(new JLabel ("Last name"));
		add(new JTextField (8));
		add(new JLabel ("User name"));
		add(new JTextField (10));
		add(new JLabel ("Password"));
		add(new JTextField (15));
		add(new JLabel ("Email"));
		add(new JTextField (15));
		add(new JLabel ("SSN"));
		add(new JTextField (9));
		add(new JLabel ("Security question for password retrival"));
		add(SecurityQuestions.jcdo);
		add(new JLabel ("Answer to your security question"));
		add(new JTextField (9));
		
	}
	
	public static void main(String[] args) {
		RegistrationScreen frame = new RegistrationScreen();
		frame.setTitle("Registration");
		frame.setSize(550,250);
		frame.setVisible(true);
	}
	
	
		
	}
	
	


