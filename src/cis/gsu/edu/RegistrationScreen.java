
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
		p1.setLayout(new GridLayout(8, 2, 10, 5));

		JLabel firstNameLabel = new JLabel("First name");
		JTextField firstNameField = new JTextField(8);
		p1.add(firstNameLabel);
		p1.add(firstNameField);

		JLabel lastNameLabel = new JLabel("Last name");
		JTextField lastNameField = new JTextField(8);
		p1.add(lastNameLabel);
		p1.add(lastNameField);

		JLabel userNameLabel = new JLabel("User name");
		JTextField userNameField = new JTextField(10);
		p1.add(userNameLabel);
		p1.add(userNameField);

		JLabel passwordLabel = new JLabel("Password");
		JPasswordField passwordField = new JPasswordField(15);
		p1.add(passwordLabel);
		p1.add(passwordField);

		JLabel emailLabel = new JLabel("Email");
		JTextField emailField = new JTextField(15);
		p1.add(emailLabel);
		p1.add(emailField);

		JLabel ssnLabel = new JLabel("SSN");
		JTextField ssnField = new JTextField(9);
		p1.add(ssnLabel);
		p1.add(ssnField);

		JLabel questionLabel = new JLabel("Security question for password retrival");
		JTextField questionField = new JTextField(15);
		p1.add(questionLabel);
		p1.add(questionField);

		JLabel answerLabel = new JLabel("Answer to your security question");
		JTextField answerField = new JTextField(15);
		p1.add(answerLabel);
		p1.add(answerField);

		JLabel addressLabel = new JLabel("Address");
		JTextField addressField = new JTextField(25);
		p1.add(addressLabel);
		p1.add(addressField);

		JLabel zipLabel = new JLabel("Zip");
		JTextField zipField = new JTextField(5);
		p1.add(zipLabel);
		p1.add(zipField);

		JLabel stateLabel = new JLabel("State");
		JTextField stateField = new JTextField(2);
		p1.add(stateLabel);
		p1.add(stateField);

		JLabel phoneLabel = new JLabel("Phone");
		JTextField phoneField = new JTextField(10);
		p1.add(phoneLabel);
		p1.add(phoneField);

		JPanel p2 = new JPanel(new BorderLayout());
		JButton buttonRegister = new JButton("Register");

		// Insert code to send registration detail to the database.
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airlineflights",
							"root", "Gsu22390");
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
					// github.com/ytoeda/Project-MJY-CIS3270.git
					System.out.println(sql);
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

		p2.add(buttonRegister);

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
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


