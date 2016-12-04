package cis.gsu.edu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInScreen extends JFrame {
	public LogInScreen(){
		
		setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		add(new JLabel("User Name"));
		add(new JTextField(10));
		add(new JLabel("Password"));
		add(new JPasswordField(15));
		
		JPanel p2 = new JPanel(new BorderLayout());
		JButton logInButton = new JButton("Log in");
		
		JPanel p3 = new JPanel(new BorderLayout());
		JButton forgotPassword = new JButton("Forgot password?");
		
		JPanel p4 = new JPanel(new BorderLayout());
		JButton registration = new JButton("Register");
		
		//Insert method to start up the flight reservation page.
		logInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Action Listner working.");
			}	
		});
		
		//Insert method to show security questions and return password value.
		forgotPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Action Listner working.");
			}	
		});
		
		registration.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegistrationScreen regFrame = new RegistrationScreen();
				regFrame.setTitle("Registration");
				regFrame.setSize(500,500);
				regFrame.setLocationRelativeTo(null);
				regFrame.setVisible(true);
				dispose();
			}	
		});
		
		p2.add(logInButton);
		add(p2,BorderLayout.SOUTH);	
		
		p3.add(forgotPassword);
		add(p3,BorderLayout.SOUTH);
		
		p4.add(registration);
		add(p4,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		LogInScreen frame = new LogInScreen();
		frame.setTitle("User Log in");
		frame.setSize(500,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
