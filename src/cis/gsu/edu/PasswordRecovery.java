package cis.gsu.edu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
//hello
public class PasswordRecovery extends JFrame{
	
	public PasswordRecovery(){
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		getContentPane().add(new JLabel("Enter your SSN"));  
		JTextField ssnField = new JTextField (9);
		getContentPane().add(ssnField);
		JButton submitButton = new JButton ("Submit");
		getContentPane().add(submitButton);
		
		JButton button = new JButton("Main Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen frame = new MainScreen();
				frame.setTitle("Premier Flights");
				frame.setSize(500,500);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				}
		});
		getContentPane().add(button);
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270?useSSL=false","root","Jay11121991");
					//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false","root","Georgia2018");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false","root","Gsu22390");
					Statement stmt = myConn.createStatement();
					String s1 = ssnField.getText();
					
					if (s1 != null) {
				            String sql = "SELECT password FROM user WHERE ssn ='" + s1 +"'";
				            ResultSet rs = stmt.executeQuery(sql);

				            if (rs.next()) {
				            	 String value = rs.getString(1);
				            JOptionPane.showMessageDialog(null,"Your password is: "+value);
				            	 dispose();
				            	 LogInScreen regFrame = new LogInScreen();  
				 				regFrame.setTitle("User Log in");                       
				 				regFrame.setSize(500,500);                               
				 				regFrame.setLocationRelativeTo(null);                    
				 				regFrame.setVisible(true);                               
				 				dispose(); 
				            }else{
				            	JOptionPane.showMessageDialog(null, "Ooopos. Invalid entry. Try Again.");
				            }
					}
					            
					        }catch(Exception exc){
					System.out.println(exc.getMessage());
					
				}
				
			}
		});
	}
	public static void main(String[] args) {
		PasswordRecovery frame = new PasswordRecovery();
		frame.setTitle("Password Recovery");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

}
