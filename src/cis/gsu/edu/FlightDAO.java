package cis.gsu.edu;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO  {

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
	public static void main(String[]args) throws Exception{
		FlightDAO dao= new FlightDAO();
		System.out.println(dao.getallFlights());
		
	}

public List<Flights> getallFlights() throws Exception{
	List<Flights> list= new ArrayList<>();
	Statement myStmt= null;
	ResultSet myRs=null;
	try{
	Connection myConn = null;
	myStmt= myConn.createStatement();
	myRs=myStmt.executeQuery("select*from flightdata");
	
	while(myRs.next()){
		Flights tempFlight= convertRowToFlight(myRs);
		list.add(tempFlight);
	}
	return list;
	}
	catch (Exception e){
		System.out.println(e);
	}
	return null;
}

public Flights convertRowToFlight(ResultSet myRs) throws SQLException {
String departingCity = myRs.getString("Departing City");
String arrivingCity = myRs.getString("Arriving City");
String departingDate = myRs.getString("Departing Date");
String arrivingDate = myRs.getString("Arriving Date");
Flights tempFlights = new Flights(departingCity, arrivingCity, arrivingDate, departingDate);


return tempFlights;

}
//end
}

