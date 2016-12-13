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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.proteanit.sql.*;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class FlightScreen extends LogInScreen {

	JFrame frmFlight;
	private JTextField txtMmddyyyy;
	private JTextField txtMmddyyyy_1;
	private JTable table;
	private JTable flightTable;
	private JTable ftable;
	private JButton btnMainMenu;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;

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
		frmFlight.setBounds(100, 100, 517, 455);
		frmFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFlight.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frmFlight.getContentPane().add(panel, "name_701305153678920");
		panel.setLayout(null);

		JLabel lblEnterCity = new JLabel("Flying from");
		lblEnterCity.setBounds(18, 14, 70, 14);
		panel.add(lblEnterCity);

		JLabel lblDepartingCity = new JLabel("Flying to");
		lblDepartingCity.setBounds(226, 14, 41, 14);
		panel.add(lblDepartingCity);

		JButton btnSearch = new JButton("Load flights");
		btnSearch.setBounds(81, 111, 261, 23);

		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// put a action listner

				Statement myStat;
				ResultSet rs;

			};

		});
		panel.add(btnSearch);

		JLabel lblDeparting = new JLabel("Departure");
		lblDeparting.setBounds(18, 71, 70, 14);
		panel.add(lblDeparting);

		JLabel lblArriving = new JLabel("Arrival");
		lblArriving.setBounds(226, 71, 41, 14);
		panel.add(lblArriving);

		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("mm/dd/yyyy");
		txtMmddyyyy.setColumns(9);
		txtMmddyyyy.setBounds(101, 68, 78, 20);
		panel.add(txtMmddyyyy);

		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText(" mm/dd/yyyy");
		txtMmddyyyy_1.setColumns(9);
		txtMmddyyyy_1.setBounds(299, 68, 78, 20);
		panel.add(txtMmddyyyy_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 145, 388, 170);
		panel.add(scrollPane);

		ftable = new JTable();
		scrollPane.setViewportView(ftable);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen frame = new MainScreen();
				frame.setTitle("Premier Flights");
				frame.setSize(500,500);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frmFlight.setVisible(false);
			}
		});
		btnMainMenu.setBounds(30, 326, 114, 23);
		panel.add(btnMainMenu);
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.setBounds(304, 326, 114, 23);
		panel.add(btnBookFlight);
		
		textField = new JTextField();
		textField.setBounds(93, 11, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(291, 11, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

						try{
							Connection myConn = DriverManager.getConnection(
									"jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false", "root", "Gsu22390"); 
						        Statement st = myConn.createStatement();
						        String searchQuery = "select * from flightdata  WHERE DepartingCity LIKE '%" + textField.getText() + "%'";
						      ResultSet rs = st.executeQuery(searchQuery);
						      ftable.setModel(DbUtils.resultSetToTableModel(rs)); 

						}
						     catch (Exception e1) { 
						        System.err.println(e1.getMessage()); 
						    }        
					

					// Connection myConn =
					// DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270?useSSL=false","root","Jay11121991");
					Connection myConn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false", "root", "Gsu22390");
					Statement stmt = myConn.createStatement();
					String departingCity = lblDepartingCity.getText();
					String arrvingCity = lblEnterCity.getText();
					String departingDate = lblDeparting.getText();
					String arrvingDate = lblArriving.getText();
				} catch (Exception exc) {
					System.out.println(exc.getMessage());

				}
			}
		});
	}
}
