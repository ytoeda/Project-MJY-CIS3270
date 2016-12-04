package cis.gsu.edu;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PublicUserDAO {
	
	private Connection myConn;
	
	public PublicUserDAO() throws Exception{
		
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public List<NonAdminUsers> getAllUsers() throws Exception{
		List<NonAdminUsers> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from NonAdminUsers ");
			
			while (myRs.next()){
				NonAdminUsers tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}
			return list;
		}
		finally{
			close(myStmt,myRs);
		}
	}
	
private NonAdminUsers convertRowToUser(ResultSet myRs) throws SQLException {
		
		String firstName = myRs.getString("First name");
		String lastName = myRs.getString("Last name");
		String userName = myRs.getString("User name");
		String password = myRs.getString("Password");
		String emailAddress = myRs.getString("Email address");
		int ssn = myRs.getInt("SSN");
		int secutiryQuestion = myRs.getInt("Security question");
		String answer = myRs.getString("Answer");
		
		NonAdminUsers tempUser = new NonAdminUsers(firstName,lastName, userName, 
				password, emailAddress,ssn,secutiryQuestion, answer);
		
		return tempUser;
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {	
		}
	
	if (myConn != null) {
		myConn.close();
	}
	}
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		
		PublicUserDAO dao = new PublicUserDAO();
		System.out.println(dao.getAllUsers());
	}
}
	
