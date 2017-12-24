package com.nxsol.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_datail")
public class Student  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sId")
	private int sId;
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getSfName() {
		return sfName;
	}

	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public String getSlName() {
		return slName;
	}

	public void setSlName(String slName) {
		this.slName = slName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Column(name="sfName")
	private String sfName;
	
	@Column(name="slName")
	private String slName;
	
	@Column(name="sCity")
	private String sCity;

	
	}
