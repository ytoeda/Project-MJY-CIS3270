package cis.gsu.edu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class PasswordRecovery extends JFrame{
	
	public PasswordRecovery(){
		
		setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		add(new JLabel("Enter your SSN"));  
		JTextField ssnField = new JTextField (9);
		add(ssnField);
		JButton submitButton = new JButton ("Submit");
		add(submitButton);
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false","root","Georgia2018");
					Statement stmt = myConn.createStatement();
					String s1 = ssnField.getText();
					
					if (s1 != null) {
				            String sql = "SELECT pwd FROM NonAdminUsers WHERE ssn ='" + s1 +"'";
				            ResultSet rs = stmt.executeQuery(sql);

				            if (rs.next()) {
				            	 String value = rs.getString(1);
				            JOptionPane.showMessageDialog(null,"Your password is: "+value);
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
