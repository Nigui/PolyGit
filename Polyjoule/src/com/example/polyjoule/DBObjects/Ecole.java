package com.example.polyjoule.DBObjects;

public class Ecole {

	private int id;
	private String nom;
	private String adresse;
	private String photoURL;
	private String descriptionFR;
	private String descriptionEN;
	
	//------ Constructeurs
	public Ecole(int id, String nom, String adresse, String photoURL,
			String descriptionFR, String descriptionEN) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.photoURL = photoURL;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
	}
	public Ecole() {
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
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
		return "Ecole [id=" + id + ", nom=" + nom + ", adresse=" + adresse
				+ ", photoURL=" + photoURL + ", descriptionFR=" + descriptionFR
				+ ", descriptionEN=" + descriptionEN + "]";
	}
	
	
}
