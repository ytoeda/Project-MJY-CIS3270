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
		//testing repo syncs
		setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		add(new JLabel("User Name"));
		JTextField userNameField = new JTextField (10);
		add(userNameField);
		add(new JLabel("Password"));
		JPasswordField passField = new JPasswordField (15);
		add(passField);
		
		JPanel p2 = new JPanel(new BorderLayout());
		JButton logInButton = new JButton("Log in");
		
		JPanel p3 = new JPanel(new BorderLayout());
		JButton forgotPassword = new JButton("Forgot password?");
		
		JPanel p4 = new JPanel(new BorderLayout());
		JButton registration = new JButton("Register");
		
		//Insert method to start up the flight reservation page.
		
		
		//Insert method to show security questions and return password value.
		logInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","Jay11121991");
					Statement stmt = myConn.createStatement();
					String userName = userNameField.getText();
					String password= new String(passField.getPassword());

					        if (userName != null && password != null) {
					            String sql = "SELECT * FROM user WHERE Username='" + userName + "' and password='" + password + "'";
					            ResultSet rs = stmt.executeQuery(sql);
					            if (rs.next()) {
					            	
			
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
					            		passRecovery.setLayout(new GridLayout(4,1,10,5));

					            		JLabel l2= new JLabel("Incorrect Login. Answer your sesurity question to retrieve password.");
					            		passRecovery.add(l2);

					            		JLabel l1= new JLabel (value);
					            		passRecovery.add(l1);

					            		JTextField answer = new JTextField (25);
					            		passRecovery.add(answer);

					            		JButton submitButton = new JButton("Submit");
					            		passRecovery.add(submitButton);
					            		
					            		passRecovery.setTitle("Password Recovery");
					            		passRecovery.setSize(500,250);
					            		passRecovery.setLocationRelativeTo(null);
					            		passRecovery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					            		passRecovery.setVisible(true);
					            		
					            		submitButton.addActionListener(new ActionListener(){
					            			public void actionPerformed(ActionEvent e){
					            				
					            				try{
					            					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","Jay11121991");
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
