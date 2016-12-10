package cis.gsu.edu;
import java.sql.*;
import java.sql.DriverManager;
public class Driver {
	public static void main(String[]args){
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airlineflights","root","Gsu22390");
			Statement myStmt=myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from user");
			while(myRs.next()){
				System.out.println(myRs.getString("lastname"));
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
