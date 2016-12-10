package cis.gsu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseInsert extends RegistrationScreen{
	
	public static void createTable() throws Exception{
		try {
			RegistrationScreen r = new RegistrationScreen();
			Connection con = getConnection();
			Statement myStat = con.createStatement();
			String sql =  "insert into user " + "(FirstName, LastName, Username, Password, Email, SSN, SecurityQuestion , SecurityAnswer, Address, Zip , State, Telephone )" +
			"values" ,firstName, lastName,  userName, password, email, ssn, question, answer, address, zip, state, telephone; 
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
		//	  Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila" , "student" , "student");
			String driver = "com.mysql.jdbc.Driver";
		//	String url = "jdbc:mysql://131.96.220.96/cis3270";
			String url = "jdbc:mysql://127.0.0.1:3306/airlineflights";
			
			
			String userName = "root";
			String password = "Gsu22390";
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
