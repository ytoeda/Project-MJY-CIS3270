package cis.gsu.edu;

public class Flights {
	private String departingCity;
	private String ArrivingCity;
	private String departingDate;
	private String ArrivingDate;
	
	
	public Flights(String departingCity, String arrivingCity, String departingDate, String arrivingDate) {
		super();
		this.departingCity = departingCity;
		ArrivingCity = arrivingCity;
		this.departingDate = departingDate;
		ArrivingDate = arrivingDate;
	}


	public String getDepartingCity() {
		return departingCity;
	}


	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}


	public String getArrivingCity() {
		return ArrivingCity;
	}
	
	


	public void setArrivingCity(String arrivingCity) {
		ArrivingCity = arrivingCity;
	}


	public String getDepartingDate() {
		return departingDate;
	}


	public void setDepartingDate(String departingDate) {
		this.departingDate = departingDate;
	}


	public String getArrivingDate() {
		return ArrivingDate;
	}


	public void setArrivingDate(String arrivingDate) {
		ArrivingDate = arrivingDate;
	}
		
	

}
