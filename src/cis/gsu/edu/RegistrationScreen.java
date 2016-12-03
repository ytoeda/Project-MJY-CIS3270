package cis.gsu.edu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistrationScreen extends JFrame {
	public RegistrationScreen(){
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(8,2,10,5));
		
		p1.add(new JLabel ("First name"));
		p1.add(new JTextField (8));
		p1.add(new JLabel ("Last name"));
		p1.add(new JTextField (8));
		p1.add(new JLabel ("User name"));
		p1.add(new JTextField (10));
		p1.add(new JLabel ("Password"));
		p1.add(new JPasswordField (15));
		p1.add(new JLabel ("Email"));
		p1.add(new JTextField (15));
		p1.add(new JLabel ("SSN"));
		p1.add(new JTextField (9));
		p1.add(new JLabel ("Security question for password retrival"));
		p1.add(SecurityQuestions.jcdo);
		p1.add(new JLabel ("Answer to your security question"));
		p1.add(new JTextField (9));
		
		JPanel p2 = new JPanel(new BorderLayout());
		JButton buttonRegister = new JButton("Register");
		
		//Insert code to send registration detail to the database.
		buttonRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Action Listner working.");
			}	
		});
		
		p2.add(buttonRegister);
		
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		RegistrationScreen frame = new RegistrationScreen();
		frame.setTitle("Registration");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
	
	


