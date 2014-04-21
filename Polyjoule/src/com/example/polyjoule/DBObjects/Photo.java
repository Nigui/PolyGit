package com.example.polyjoule.DBObjects;

import java.util.Calendar;

public class Photo {

	private String album;
	private String titreFR;
	private String photoURL;
	private Calendar photoDate;
	private String descriptionFR;
	
	private final String imageBDDUrl = "http://www.polyjoule.org/administration/ressources/data/Photo/";

	//------ Constructeurs
	
	public Photo() {
		super();
	}
	public Photo(int id, String album, String titreFR, String photoURL,
			Calendar photoDate, String descriptionFR) {
		super();
		this.album = album;
		this.titreFR = titreFR;
		this.photoURL = photoURL;
		this.photoDate = photoDate;
		this.descriptionFR = descriptionFR;
	}
	//################## Constructeurs
	
	//------GETTERS & SETTERS
	public String getTitreFR() {
		return titreFR;
	}
	public void setTitreFR(String titreFR) {
		this.titreFR = titreFR;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = this.imageBDDUrl+photoURL;
	}
	public Calendar getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Calendar photoDate) {
		this.photoDate = photoDate;
	}
	public String getDescriptionFR() {
		return descriptionFR;
	}
	public void setDescriptionFR(String descriptionFR) {
		this.descriptionFR = descriptionFR;
	}
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	//################## GETTERS & SETTERS
	@Override
	public String toString() {
		return "Photo [album=" + album + ", titreFR=" + titreFR
				+ ", photoURL=" + photoURL + ", photoDate=" + photoDate
				+ ", descriptionFR=" + descriptionFR + ", imageBDDUrl="
				+ imageBDDUrl + "]";
	}
	
	
}
