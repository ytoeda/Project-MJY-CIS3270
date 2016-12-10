package cis.gsu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class FlightTable extends FlightScreen  {
	public static void createTable() throws Exception{
	try {
		FlightScreen r = new FlightScreen();
		Connection con = getConnection();
		Statement myStat = con.createStatement();
		String sql =  "insert into flightdata " + "(DepartingCity, ArrivingCity, DepartingDate, ArrivingDate )" +
		"values" ,departingCity, arrivingCity, departingDate, arrivingDate; 
		//PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS User (Username varchar(12), Password varchar(15), FirstName varchar(25), LastName varchar(25), SSN int (10), Address varchar(35), Zip int (5), State varchar(2), Telephone int (10), Email varchar(25), SecurityQuestion varchar(50), SecurityAnswer varchar(15))");
		myStat.executeUpdate(sql);
	
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
