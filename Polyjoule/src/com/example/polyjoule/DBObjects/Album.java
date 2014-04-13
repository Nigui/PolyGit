package com.example.polyjoule.DBObjects;

import java.util.ArrayList;
import java.util.Calendar;

public class Album {

	private int id;
	private String nom;
	private Calendar date;
	private String descriptionFR;
	private String descriptionEN;
	private ArrayList<Photo> listePhotos;
	
	//------ Constructeurs
	public Album(int id, String nom, Calendar date, String descriptionFR,
			String descriptionEN, ArrayList<Photo> listePhotos) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
		this.listePhotos = listePhotos;
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public ArrayList<Photo> getListePhotos() {
		return listePhotos;
	}
	public void setListePhotos(ArrayList<Photo> listePhotos) {
		this.listePhotos = listePhotos;
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
