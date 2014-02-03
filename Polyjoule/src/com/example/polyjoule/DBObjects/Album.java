package com.example.polyjoule.DBObjects;

import java.util.ArrayList;
import java.util.Date;

public class Album {

	private int id;
	private String nom;
	private Date date;
	private String descriptionFR;
	private String descriptionEN;
	private ArrayList<Photo> listePhotos;
	
	//------ Constructeurs
	public Album(int id, String nom, Date date, String descriptionFR,
			String descriptionEN) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
	}
	public Album() {
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
		return "Album [id=" + id + ", nom=" + nom + ", date=" + date
				+ ", descriptionFR=" + descriptionFR + ", descriptionEN="
				+ descriptionEN + "]";
	}
	
	
	
}
