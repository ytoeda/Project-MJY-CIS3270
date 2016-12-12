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

public class FlightScreen extends LogInScreen {

	JFrame frmFlight;
	private JTextField txtCityName;
	private JTextField textField;
	private JTextField txtMmddyyyy;
	private JTextField txtMmddyyyy_1;
	private JTable table;
	private JTable flightTable;
	private JTable ftable;
	private JButton btnMainMenu;

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
		frmFlight.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frmFlight.getContentPane().add(panel, "name_701305153678920");
		panel.setLayout(null);

		JLabel lblEnterCity = new JLabel("Flying from");
		lblEnterCity.setBounds(18, 14, 70, 14);
		panel.add(lblEnterCity);

		txtCityName = new JTextField();
		txtCityName.setBounds(81, 11, 78, 20);
		txtCityName.setText(" ");
		panel.add(txtCityName);
		txtCityName.setColumns(9);

		JLabel lblDepartingCity = new JLabel("Flying to");
		lblDepartingCity.setBounds(189, 14, 41, 14);
		panel.add(lblDepartingCity);

		textField = new JTextField();
		textField.setBounds(253, 11, 78, 20);
		panel.add(textField);
		textField.setText(" ");
		textField.setColumns(9);

		JButton btnSearch = new JButton("Search");
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
		lblDeparting.setBounds(18, 71, 53, 14);
		panel.add(lblDeparting);

		JLabel lblArriving = new JLabel("Arrival");
		lblArriving.setBounds(189, 71, 41, 14);
		panel.add(lblArriving);

		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("mm/dd/yyyy");
		txtMmddyyyy.setColumns(9);
		txtMmddyyyy.setBounds(81, 68, 78, 20);
		panel.add(txtMmddyyyy);

		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText(" mm/dd/yyyy");
		txtMmddyyyy_1.setColumns(9);
		txtMmddyyyy_1.setBounds(253, 68, 78, 20);
		panel.add(txtMmddyyyy_1);

		ftable = new JTable();
		ftable.setBounds(81, 145, 261, 55);
		panel.add(ftable);
		
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
		btnMainMenu.setBounds(81, 227, 261, 23);
		panel.add(btnMainMenu);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					try {
						// Connection myConn =
						// DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270?useSSL=false","root","Jay11121991");
						Connection myConn = DriverManager.getConnection(
								"jdbc:mysql://127.0.0.1:3306/airlineflights?useSSL=false", "root", "Gsu22390");
						Statement myStat = myConn.createStatement();
						String searchQuery = "select * from flightdata ";
						PreparedStatement create = (PreparedStatement) myConn.prepareStatement(searchQuery);
						ResultSet rs = create.executeQuery(searchQuery);
						ftable.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						System.out.println(e1);
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
