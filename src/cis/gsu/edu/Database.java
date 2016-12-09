package cis.gsu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Database {
	public static void main(String[] args) throws Exception{
createTable();
	}
	public static void createTable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS User ( FirstName varchar(25), LastName varchar(25), Username varchar(12), Password varchar(15), Email varchar(25), SSN int (10),  SecurityQuestion varchar(50), SecurityAnswer varchar(15), Address varchar(35), Zip int (5), State varchar(2), Telephone int (10))");
			create.executeUpdate();
			
		}catch (Exception e){
			System.out.println(e);}
		finally {
			System.out.println("Function complete");
		};
		
	try {
		Connection con = getConnection();
		PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS FlightData ( DepartingCity varchar(10), ArrivingCity varchar(10), DepartingDate date , ArrivingDate date)");
		create.executeUpdate();
		
	}catch (Exception e){
		System.out.println(e);}
	finally {
		System.out.println("Function complete");
	};
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
