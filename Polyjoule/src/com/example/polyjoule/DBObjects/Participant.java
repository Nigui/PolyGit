package com.example.polyjoule.DBObjects;

import java.util.ArrayList;

public class Participant {

	private int id;
	private String nom;
	private String prenom;
	private String photoURL;
	private String email;
	private String bioFR;
	private String bioEN;
	private boolean isProf;
	private ArrayList<Participation> participation;

	//------ Constructeurs
	public Participant(int id, String nom, String prenom, String photoURL,
			String email, String bioFR, String bioEN, boolean isProf,
			ArrayList<Participation> participation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photoURL = photoURL;
		this.email = email;
		this.bioFR = bioFR;
		this.bioEN = bioEN;
		this.isProf = isProf;
		this.participation = participation;
	}
	public Participant() {
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBioFR() {
		return bioFR;
	}
	public void setBioFR(String bioFR) {
		this.bioFR = bioFR;
	}
	public String getBioEN() {
		return bioEN;
	}
	public void setBioEN(String bioEN) {
		this.bioEN = bioEN;
	}
	public boolean isProf() {
		return isProf;
	}
	public void setProf(boolean isProf) {
		this.isProf = isProf;
	}
	public ArrayList<Participation> getParticipation() {
		return participation;
	}
	public void setParticipation(ArrayList<Participation> participation) {
		this.participation = participation;
	}
	//################## GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", photoURL=" + photoURL + ", email=" + email + ", bioFR="
				+ bioFR + ", bioEN=" + bioEN + ", isProf=" + isProf
				+ ", participation=" + participation + "]";
	}
}
