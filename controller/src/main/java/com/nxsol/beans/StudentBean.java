package com.nxsol.beans;

import java.io.Serializable;

public class StudentBean implements Serializable {

	private int id;
	private String fName;
	private String lName;
	private String city;

	public String getfName() {
		return fName;
		
	}
	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
