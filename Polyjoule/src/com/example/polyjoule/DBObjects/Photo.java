package com.example.polyjoule.DBObjects;

import java.util.Date;

public class Photo {

	private int id;
	private Album album;
	private String titreFR;
	private String titreEN;
	private String photoURL;
	private Date photoDate;
	private String descriptionFR;
	private String descriptionEN;
	
	//------ Constructeurs
	public Photo(int id, Album album, String titreFR, String titreEN,
			String photoURL, Date photoDate, String descriptionFR,
			String descriptionEN) {
		super();
		this.id = id;
		this.album = album;
		this.titreFR = titreFR;
		this.titreEN = titreEN;
		this.photoURL = photoURL;
		this.photoDate = photoDate;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
	}
	public Photo() {
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
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public String getTitreFR() {
		return titreFR;
	}
	public void setTitreFR(String titreFR) {
		this.titreFR = titreFR;
	}
	public String getTitreEN() {
		return titreEN;
	}
	public void setTitreEN(String titreEN) {
		this.titreEN = titreEN;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public Date getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
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
		return "Photo [id=" + id + ", album=" + album + ", titreFR=" + titreFR
				+ ", titreEN=" + titreEN + ", photoURL=" + photoURL
				+ ", photoDate=" + photoDate + ", descriptionFR="
				+ descriptionFR + ", descriptionEN=" + descriptionEN + "]";
	}
	
	
}
