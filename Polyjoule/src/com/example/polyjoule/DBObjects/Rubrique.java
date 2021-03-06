package com.example.polyjoule.DBObjects;

import java.util.ArrayList;

public class Rubrique {

	
	private int id;
	private String titreFR;
	private String titreEN;
	private String descriptionFR;
	private String descriptionEN;
	private ArrayList<Article> articles;
	private ArrayList<Rubrique> sousRubriques;
	private Rubrique mere;
	
	

	//------ Constructeurs
	public Rubrique(int id, String titreFR, String titreEN,
			String descriptionFR, String descriptionEN,
			ArrayList<Article> articles, ArrayList<Rubrique> sousRubriques,
			Rubrique mere) {
		super();
		this.id = id;
		this.titreFR = titreFR;
		this.titreEN = titreEN;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
		this.articles = articles;
		this.sousRubriques = sousRubriques;
		this.mere = mere;
	}
	public Rubrique() {
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
	public ArrayList<Article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	public ArrayList<Rubrique> getSousRubriques() {
		return sousRubriques;
	}
	public void setSousRubriques(ArrayList<Rubrique> sousRubriques) {
		this.sousRubriques = sousRubriques;
	}
	public Rubrique getMere() {
		return mere;
	}
	public void setMere(Rubrique mere) {
		this.mere = mere;
	}
	//################## GETTERS & SETTERS
	
	
	@Override
	public String toString() {
		return "Rubrique [id=" + id + ", titreFR=" + titreFR + ", titreEN="
				+ titreEN + ", descriptionFR=" + descriptionFR
				+ ", descriptionEN=" + descriptionEN + ", articles=" + articles
				+ ", sousRubriques=" + sousRubriques + ", mere=" + mere + "]";
	}
	
	
}
