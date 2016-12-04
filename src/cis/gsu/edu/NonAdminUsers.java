package cis.gsu.edu;

public class NonAdminUsers {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emailAddress;
	private int ssn;
	private int secutiryQuestion;
	private String answer;
	private int securityQuestion;
	
	
	public NonAdminUsers(String firstName,String lastName, String userName, 
			String password, String emailAddress,int ssn,int secutiryQuestion, String answer){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.ssn = ssn;
		this.userName = userName;
		this.password = password;
		this.secutiryQuestion = securityQuestion;
		this.answer = answer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getSecutiryQuestion() {
		return secutiryQuestion;
	}

	public void setSecutiryQuestion(int secutiryQuestion) {
		this.secutiryQuestion = secutiryQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(int securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	@Override
	public String toString(){
		return String
				.format("NonAdminUsers [firstName=%s, lastName=%s,userName=%s, password=%s, emailAddress=%s,ssn=%s,secutiryQuestion=%s,answer=%s]", firstName, lastName,userName, password,
				emailAddress,ssn,secutiryQuestion,answer);
	}
	
	
	
}
