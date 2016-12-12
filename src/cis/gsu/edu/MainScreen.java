package cis.gsu.edu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainScreen extends JFrame{
	public MainScreen(){

		setLayout(new BorderLayout()); 
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Welcome to Premier Flights! "));  
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel(new ImageIcon("/Users/Yasuko/Desktop/beach.jpg")));
		
		JPanel p3 = new JPanel();
		JButton regBtn = new JButton("Register");
		p3.add(regBtn);  
		JButton logBtn = new JButton("User Log in");
		p3.add(logBtn);  
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		
		regBtn.addActionListener(new ActionListener(){             
			public void actionPerformed(ActionEvent e){                  
				RegistrationScreen regFrame = new RegistrationScreen();  
				regFrame.setTitle("Registration");                       
				regFrame.setSize(500,500);                               
				regFrame.setLocationRelativeTo(null);                    
				regFrame.setVisible(true);                               
				dispose();                  
				
			}	                                                         
		});
		
		logBtn.addActionListener(new ActionListener(){             
			public void actionPerformed(ActionEvent e){                  
				LogInScreen regFrame = new LogInScreen();  
				regFrame.setTitle("User Log in");                       
				regFrame.setSize(500,500);                               
				regFrame.setLocationRelativeTo(null);                    
				regFrame.setVisible(true);                               
				dispose();  
				
			}	                                                         
		});  
		
		
	}
	
	public static void main(String[] args) {
		MainScreen frame = new MainScreen();
		frame.setTitle("Premier Flights");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}	

}
