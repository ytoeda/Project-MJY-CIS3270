package cis.gsu.edu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class FlightScreen extends LogInScreen {

	JFrame frmFlight;
	private JTextField txtCityName;
	private JTextField textField;
	private JTextField txtMmddyyyy;
	private JTextField txtMmddyyyy_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightScreen window = new FlightScreen();
					window.frmFlight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlightScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmFlight = new JFrame();
		frmFlight.setTitle("Flight ");
		frmFlight.setBounds(100, 100, 450, 300);
		frmFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmFlight.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterCity = new JLabel("Flying from");
		panel.add(lblEnterCity);
		
		txtCityName = new JTextField();
		txtCityName.setText(" ");
		panel.add(txtCityName);
		txtCityName.setColumns(9);
		
		JLabel lblDepartingCity = new JLabel("Flying to");
		panel.add(lblDepartingCity);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setText(" ");
		textField.setColumns(9);
		
		JButton btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		frmFlight.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		
		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("MM/DD/YYYY");
		txtMmddyyyy.setColumns(9);
		panel_1.add(txtMmddyyyy);
		
		JLabel lblDeparting = new JLabel("Departing");
		panel_1.add(lblDeparting);
		
		JLabel lblArriving = new JLabel("Arriving");
		panel_1.add(lblArriving);
		
		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText("MM/DD/YYYY");
		txtMmddyyyy_1.setColumns(9);
		panel_1.add(txtMmddyyyy_1);
		
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","Jay11121991");
					Statement stmt = myConn.createStatement();
					String departingCity = lblDepartingCity.getText();				
					String arrvingCity = lblEnterCity.getText();
					String departingDate = lblDeparting.getText();
					String arrvingDate = lblArriving.getText();
					} catch (Exception exc) {
					System.out.println(exc.getMessage());
			//	JOptionPane.showMessageDialog(null, "Ooopos. Invalid entry. Make sure you enter 9 digits for your SSN! Try Again.");
					
				}
			}	});

	}}