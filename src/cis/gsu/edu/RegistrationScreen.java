package cis.gsu.edu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class RegistrationScreen extends JFrame {
	public RegistrationScreen() {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 434, 237);

		JLabel firstNameLabel = new JLabel("First name");
		firstNameLabel.setBounds(30, 28, 70, 28);
		JTextField firstNameField = new JTextField(8);
	
		firstNameField.setBounds(95, 30, 63, 25);
		p1.setLayout(null);
		p1.add(firstNameLabel);
		p1.add(firstNameField);

		JLabel lastNameLabel = new JLabel("Last name");
		lastNameLabel.setBounds(30, 67, 70, 25);
		JTextField lastNameField = new JTextField(8);
		lastNameField.setBounds(95, 66, 63, 26);
		p1.add(lastNameLabel);
		p1.add(lastNameField);

		JLabel userNameLabel = new JLabel("User name");
		userNameLabel.setBounds(30, 103, 55, 25);
		JTextField userNameField = new JTextField(10);
		userNameField.setBounds(95, 112, 63, 16);
		p1.add(userNameLabel);
		p1.add(userNameField);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 139, 70, 25);
		JPasswordField passwordField = new JPasswordField(15);
		passwordField.setBounds(95, 148, 63, 16);
		p1.add(passwordLabel);
		p1.add(passwordField);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(30, 202, 32, 25);
		JTextField emailField = new JTextField(15);
		emailField.setBounds(92, 206, 66, 16);
		p1.add(emailLabel);
		p1.add(emailField);

		JLabel ssnLabel = new JLabel("SSN");
		ssnLabel.setBounds(30, 175, 70, 25);
		JTextField ssnField = new JTextField(9);
		ssnField.setBounds(95, 175, 63, 16);
		p1.add(ssnLabel);
		p1.add(ssnField);

		JLabel questionLabel = new JLabel("Security question for password retrival");
		questionLabel.setBounds(198, 30, 138, 25);
		JTextField questionField = new JTextField(15);
		questionField.setBounds(346, 32, 70, 20);
		p1.add(questionLabel);
		p1.add(questionField);

		JLabel answerLabel = new JLabel("Security Answer");
		answerLabel.setBounds(218, 67, 118, 25);
		JTextField answerField = new JTextField(15);
		answerField.setBounds(349, 69, 63, 20);
		p1.add(answerLabel);
		p1.add(answerField);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(228, 103, 70, 25);
		JTextField addressField = new JTextField(25);
		addressField.setBounds(346, 103, 66, 25);
		p1.add(addressLabel);
		p1.add(addressField);

		JLabel zipLabel = new JLabel("Zip");
		zipLabel.setBounds(238, 139, 63, 25);
		JTextField zipField = new JTextField(5);
		zipField.setBounds(346, 139, 66, 25);
		p1.add(zipLabel);
		p1.add(zipField);

		JLabel stateLabel = new JLabel("State");
		stateLabel.setBounds(228, 175, 63, 25);
		JTextField stateField = new JTextField(2);
		stateField.setBounds(346, 177, 66, 20);
		p1.add(stateLabel);
		p1.add(stateField);

		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(228, 202, 55, 25);
		JTextField phoneField = new JTextField(10);
		phoneField.setBounds(346, 206, 63, 21);
		p1.add(phoneLabel);
		p1.add(phoneField);

		JPanel p2 = new JPanel();
		p2.setBounds(0, 238, 434, 23);
		JButton buttonRegister = new JButton("Register");
		buttonRegister.setBounds(0, 0, 219, 23);

		// Insert code to send registration detail to the database.
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270", "root",
							//"Jay11121991");
					Connection myConn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false", "root", "Gsu22390");
					Statement stmt = myConn.createStatement();
					String firstName = firstNameField.getText();
					String lastName = lastNameField.getText();
					String userName = userNameField.getText();
					String password = new String(passwordField.getPassword());
					String email = emailField.getText();
					Integer ssn = Integer.parseInt(ssnField.getText());
					String question = questionField.getText();
					String answer = answerField.getText();
					String address = addressField.getText();
					String zip = zipField.getText();
					String state = stateField.getText();
					String phone = phoneField.getText();

					// String sql = "INSERT INTO `sys`.`NonAdminUsers` (`fname`,
					// `lname`, `uname`, `pwd`, `email`, `ssn`, `q1`, `a1`)
					// VALUES
					// ('"+firstName+"','"+lastName+"','"+userName+"','"+password+"','"+email+"','"+ssn+"','"+question+"','"+answer+"');";
					String sql = "INSERT INTO `user` (`FirstName`, `LastName`, `Username`, `Password`, `Email`, `SSN`, `SecurityQuestion`, `SecurityAnswer`, `Address`, `zip`, `state`, `telephone`) VALUES "
							+ "('" + firstName + "','" + lastName + "','" + userName + "','" + password + "','" + email
							+ "','" + ssn + "','" + question + "','" + answer + "','" + address + "','" + zip + "','"
							+ state + "','" + phone + "');";
					 JOptionPane.showMessageDialog(null,"Register Succesfull");
	            	 dispose();
	            	 LogInScreen regFrame = new LogInScreen();  
	 				regFrame.setTitle("User Log in");                       
	 				regFrame.setSize(500,500);                               
	 				regFrame.setLocationRelativeTo(null);                    
	 				regFrame.setVisible(true);                               
	 				dispose(); 
					stmt.executeUpdate(sql);

				} catch (Exception exc) {
					System.out.println(exc.getMessage());
					// JOptionPane.showMessageDialog(null, "Ooopos. Invalid
					// entry. Make sure you enter 9 digits for your SSN! Try
					// Again.");

				}
				dispose();
			}
		});
		p2.setLayout(null);

		p2.add(buttonRegister);
		getContentPane().setLayout(null);

		getContentPane().add(p1);
		getContentPane().add(p2);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen frame = new MainScreen();
				frame.setTitle("Premier Flights");
				frame.setSize(500,500);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
		btnMainMenu.setBounds(215, 0, 219, 23);
		p2.add(btnMainMenu);
	}

	public static void main(String[] args) {
		RegistrationScreen frame = new RegistrationScreen();
		frame.setTitle("Registration");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
