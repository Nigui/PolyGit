package com.example.polyjoule.DBObjects;

public class Membre {

	private String nom;
	private String prenom;
	private String photoPath;
	private String mail;
	private String bioFR;
	private String role;
	
	
	
	public Membre() {
		super();
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setBioFR(String bioFR) {
		this.bioFR = bioFR;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public String getMail() {
		return mail;
	}
	public String getBioFR() {
		return bioFR;
	}
	public String getRole() {
		return role;
	}


	@Override
	public String toString() {
		return "Membre [nom=" + nom + ", prenom=" + prenom + ", photoPath="
				+ photoPath + ", mail=" + mail + ", bioFR=" + bioFR + ", role="
				+ role + "]";
	}
	
	
}
