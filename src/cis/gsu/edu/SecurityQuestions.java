package cis.gsu.edu;

import javax.swing.*;

public class SecurityQuestions extends JFrame {
	
	private static String [] securityQuestions = {
			"What is your mother's maiden name?",
			"What is the name of the city you were born in?",
			"What is the name of your first pet?",
			"What is the make of your first car?"
	};
	
	public static JComboBox jcdo = new JComboBox(securityQuestions);
	
	public static void main(String[] args) {
	
		SecurityQuestions frame = new SecurityQuestions();
		frame.pack();
		frame.setTitle("Security Question");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
}
	}

