package cis.gsu.edu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInScreen extends JFrame {
	public LogInScreen(){
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("User Name");
		label.setBounds(11, 24, 52, 14);
		getContentPane().add(label);
		JTextField userNameField = new JTextField (10);
		userNameField.setBounds(73, 21, 86, 20);
		getContentPane().add(userNameField);
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(169, 24, 46, 14);
		getContentPane().add(label_1);
		JPasswordField passField = new JPasswordField (15);
		passField.setBounds(225, 21, 83, 20);
		getContentPane().add(passField);
		JButton forgotPassword = new JButton("Forgot password?");
		forgotPassword.setBounds(11, 105, 149, 23);
		getContentPane().add(forgotPassword);
		
		
		forgotPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					PasswordRecovery pwr = new PasswordRecovery();
					pwr.setTitle("Registration");
					pwr.setSize(500,500);
					pwr.setLocationRelativeTo(null);
					pwr.setVisible(true);
					dispose();
					
				}catch(Exception exc){
					System.out.println(exc.getMessage());	
				}
			}
				});
		
		JButton btnNewBmutton = new JButton("Main Menu");
		btnNewBmutton.setBounds(292, 105, 132, 23);
		btnNewBmutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen frame = new MainScreen();
				frame.setTitle("Premier Flights");
				frame.setSize(500,500);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		getContentPane().add(btnNewBmutton);
		JButton registration = new JButton("Register");
		registration.setBounds(169, 105, 113, 23);
		getContentPane().add(registration);
		JButton logInButton = new JButton("Log in");
		logInButton.setBounds(320, 20, 104, 23);
		getContentPane().add(logInButton);
		
		//Insert method to start up the flight reservation page.
		
		
		//Insert method to show security questions and return password value.
		logInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270?useSSL=false","root","Jay11121991");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false","root","Gsu22390");
					Statement stmt = myConn.createStatement();
					String userName = userNameField.getText();
					String password= new String(passField.getPassword());

					        if (userName != null && password != null) {
					           // String sql = "SELECT * FROM user WHERE Username='" + userName + "' and password='" + password + "'";
					        	 String sql = "SELECT * FROM user WHERE userName='" + userName + "' and password='" + password + "'";
					            ResultSet rs = stmt.executeQuery(sql);
					            if (rs.next()) {
					            	JOptionPane.showMessageDialog(null,"Login Succesful");
					            	 dispose();
					            	
			
					            	FlightScreen window = new FlightScreen();
									window.frmFlight.setVisible(true);
									JFrame frmFlight = new JFrame();
									frmFlight.setTitle("Flight ");
									frmFlight.setBounds(100, 100, 450, 300);
									frmFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									
									JPanel panel = new JPanel();
									FlowLayout flowLayout = (FlowLayout) panel.getLayout();
									flowLayout.setAlignment(FlowLayout.LEFT);
									frmFlight.getContentPane().add(panel, BorderLayout.NORTH);
				                  
					            } else {
					            	String sql2 = "SELECT q1 from user WHERE uname ='" + userName +"'";
					            	ResultSet rs2 = stmt.executeQuery(sql2);
					            	
					            	while(rs2.next()){
					            		String value = rs2.getString("q1");
					            		JFrame passRecovery = new JFrame(); 
					            		passRecovery.getContentPane().setLayout(new GridLayout(4,1,10,5));

					            		JLabel l2= new JLabel("Incorrect Login. Answer your sesurity question to retrieve password.");
					            		passRecovery.getContentPane().add(l2);

					            		JLabel l1= new JLabel (value);
					            		passRecovery.getContentPane().add(l1);

					            		JTextField answer = new JTextField (25);
					            		passRecovery.getContentPane().add(answer);

					            		JButton submitButton = new JButton("Submit");
					            		passRecovery.getContentPane().add(submitButton);
					            		
					            		passRecovery.setTitle("Password Recovery");
					            		passRecovery.setSize(500,250);
					            		passRecovery.setLocationRelativeTo(null);
					            		passRecovery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					            		passRecovery.setVisible(true);
					            		
					            		submitButton.addActionListener(new ActionListener(){
					            			public void actionPerformed(ActionEvent e){
					            				
					            				try{
					            					//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270?useSSL=false","root","Jay11121991");
					            					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:121.0.0.1/airlineflight?useSSL=false","root","Gsu22390");
					            					Statement stmt = myConn.createStatement();
					            					String a1 = answer.getText();
					            					
					            					
					            					 if (a1!= null) {
					     					            String sql = "SELECT pwd, a1 FROM NonAdminUsers WHERE uname ='" + userName +"'";
					     					            ResultSet rs = stmt.executeQuery(sql);
      
					     					            if (rs.next()) {
					     					            	 String value = rs.getString(1);
					     					            	String value2 = rs.getString(2);
					     					            	
					     					            	if(a1.equals(value2)){
					     					            		JOptionPane.showMessageDialog(null,"Your password is: "+value);
					     					            	}else {
					     					            	JOptionPane.showMessageDialog(null,"Wrong answer. Account temporalily locked.");
					     					            }
					            					 }
					            					 }
					            				}catch(Exception exc){
					            					System.out.println(exc.getMessage());
					            				}
					            				
					            			}
					            			
					            		
					            		});
					            		
					            	}
					            }
					        }

					        // You can also validate user by result size if its comes zero user is invalid else user is valid

					    } catch (Exception exc) {
					        System.out.println(exc.getMessage());
					    }

			}
	});
		
				//When clicking on registration button, user directed to the registration form.
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
