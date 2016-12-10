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

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.proteanit.sql.*;
public class FlightScreen extends LogInScreen {

	JFrame frmFlight;
	private JTextField txtCityName;
	private JTextField textField;
	private JTextField txtMmddyyyy;
	private JTextField txtMmddyyyy_1;
	private JTable FlightTable;

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
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//put a action listner	
				
				Statement myStat;
				ResultSet rs;
				try {
					Connection con = getConnection();
					 myStat = con.createStatement();
					String searchQuery =  "select * from flightdata " ;
					PreparedStatement create = (PreparedStatement) con.prepareStatement(searchQuery);
					rs = create.executeQuery(searchQuery);
					FlightTable.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1){
					System.out.println(e1);}
				finally {
					System.out.println("Function complete");
				};
				
			
						}
			}	);
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(23, 3));
		frmFlight.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		scrollPane.setColumnHeaderView(panel_1);
		
		JLabel lblDeparting = new JLabel("Departing");
		panel_1.add(lblDeparting);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("MM/DD/YYYY");
		txtMmddyyyy.setColumns(9);
		panel_1.add(txtMmddyyyy);
		
		JLabel lblArriving = new JLabel("Arriving");
		panel_1.add(lblArriving);
		
		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText("MM/DD/YYYY");
		txtMmddyyyy_1.setColumns(9);
		panel_1.add(txtMmddyyyy_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		scrollPane.setRowHeaderView(layeredPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 412, 174);
		layeredPane.add(scrollPane_1);
		
		FlightTable = new JTable();
		scrollPane_1.setViewportView(FlightTable);
		
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","Jay11121991");
					Statement stmt = myConn.createStatement();
					String departingCity = lblDepartingCity.getText();				
					String arrvingCity = lblEnterCity.getText();
					String departingDate = lblDeparting.getText();
					String arrvingDate = lblArriving.getText();
					} 
				catch (Exception exc) {
					System.out.println(exc.getMessage());
					
		
			}	}});
	}
	public static Connection getConnection() throws Exception{
		try {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cis3270";
		String userName = "root";
		String password = "Jay11121991";
		Class.forName(driver);
		Connection myConn = DriverManager.getConnection(url, userName, password);
		System.out.println("Connected");
		return myConn;
}
		catch (Exception e){
			System.out.println(e);
		}
		return null;
}
}