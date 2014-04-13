package com.example.polyjoule.DBObjects;

import java.io.Serializable;
import java.util.ArrayList;

public class Partenaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String logoURL;
	private String websiteURL;
	private String descriptionFR;
	private String descriptionEN;
	private ArrayList<Article> article;
	
	//------ Constructeurs
	public Partenaire(int id, String nom, String logoURL, String websiteURL,
			String descriptionFR, String descriptionEN,
			ArrayList<Article> article) {
		super();
		this.id = id;
		this.nom = nom;
		this.logoURL = logoURL;
		this.websiteURL = websiteURL;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
		this.article = article;
	}
	public Partenaire() {
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
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getWebsiteURL() {
		return websiteURL;
	}
	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
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
	public ArrayList<Article> getArticle() {
		return article;
	}
	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}
	//################## GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "Partenaire [id=" + id + ", nom=" + nom + ", logoURL=" + logoURL
				+ ", websiteURL=" + websiteURL + ", descriptionFR="
				+ descriptionFR + ", descriptionEN=" + descriptionEN
				+ ", article=" + article + "]";
	}
	
	
}
