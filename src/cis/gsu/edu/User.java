package cis.gsu.edu;

public abstract class User {
	 private String userName;
	 private char [] password;
	 private String name;
	 private String address;
	
	 
	 
	 
	 public User(String userName, char[] password) {
		this.userName = userName;
		this.password = password;
	}
	
	 public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
