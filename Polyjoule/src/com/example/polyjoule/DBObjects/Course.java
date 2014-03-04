package com.example.polyjoule.DBObjects;

import java.util.Calendar;
import java.util.Date;

public class Course {

	private int id;
	private Equipe equipe;
	private Calendar date;
	private String lieu;
	private String imageURL;
	private String descriptionFR;
	private String descriptionEN;
	
	//------ Constructeurs
	public Course(int id, Equipe equipe, Calendar date, String lieu,
			String imageURL, String descriptionFR, String descriptionEN) {
		super();
		this.id = id;
		this.equipe = equipe;
		this.date = date;
		this.lieu = lieu;
		this.imageURL = imageURL;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
	}
	public Course() {
		super();
	}
	//################## Constructeurs
	
	
	//------GETTERS & SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescriptionFR() {
		return descriptionFR;
	}
	public void setDescriptionFR(String descriptionFR) {
		this.descriptionFR = descriptionFR;
	}
	public String getDescriptionEN() {
		return descriptionEN;
	}
	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}
	//################## GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", id_equipe=" + equipe + ", date="
				+ date + ", lieu=" + lieu + ", imageURL=" + imageURL
				+ ", descriptionFR=" + descriptionFR + ", descriptionEN="
				+ descriptionEN + "]";
	}
	
	
	
}
