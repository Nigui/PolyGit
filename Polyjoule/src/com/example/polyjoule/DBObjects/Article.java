package com.example.polyjoule.DBObjects;
import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{

	private int idArticle;
	private String auteur;
	private String titreFr;
	private String titreEn;
	private String contenuFr;
	private String contenuEng;
	private boolean commentaireAutorise;
	private boolean statutArticle;
	private Date dateCreation;
	private String urlPhotoPrincipale;
	private boolean visibleHome;
	private boolean mainArticle;
	
	//------ Constructeurs
	public Article(int idArticle, String auteur,
			String titreFr, String titreEn, String contenuFr,
			String contenuEng, boolean commentaireAutorise,
			boolean statutArticle, Date dateCreation,
			String urlPhotoPrincipale, boolean visibleHome, boolean mainArticle) {
		super();
		this.idArticle = idArticle;
		this.auteur = auteur;
		this.titreFr = titreFr;
		this.titreEn = titreEn;
		this.contenuFr = contenuFr;
		this.contenuEng = contenuEng;
		this.commentaireAutorise = commentaireAutorise;
		this.statutArticle = statutArticle;
		this.dateCreation = dateCreation;
		this.urlPhotoPrincipale = urlPhotoPrincipale;
		this.visibleHome = visibleHome;
		this.mainArticle = mainArticle;
	}
	public Article() {
		super();
	}
	//################## Constructeurs


	//------GETTERS & SETTERS
	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getTitreFr() {
		return titreFr;
	}


	public void setTitreFr(String titreFr) {
		this.titreFr = titreFr;
	}


	public String getTitreEn() {
		return titreEn;
	}


	public void setTitreEn(String titreEn) {
		this.titreEn = titreEn;
	}


	public String getContenuFr() {
		return contenuFr;
	}


	public void setContenuFr(String contenuFr) {
		this.contenuFr = contenuFr;
	}


	public String getContenuEng() {
		return contenuEng;
	}


	public void setContenuEng(String contenuEng) {
		this.contenuEng = contenuEng;
	}


	public boolean isCommentaireAutorise() {
		return commentaireAutorise;
	}


	public void setCommentaireAutorise(boolean commentaireAutorise) {
		this.commentaireAutorise = commentaireAutorise;
	}


	public boolean isStatutArticle() {
		return statutArticle;
	}


	public void setStatutArticle(boolean statutArticle) {
		this.statutArticle = statutArticle;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public String getUrlPhotoPrincipale() {
		return urlPhotoPrincipale;
	}


	public void setUrlPhotoPrincipale(String urlPhotoPrincipale) {
		this.urlPhotoPrincipale = urlPhotoPrincipale;
	}


	public boolean isVisibleHome() {
		return visibleHome;
	}


	public void setVisibleHome(boolean visibleHome) {
		this.visibleHome = visibleHome;
	}


	public boolean isMainArticle() {
		return mainArticle;
	}


	public void setMainArticle(boolean mainArticle) {
		this.mainArticle = mainArticle;
	}
	//################## GETTERS & SETTERS

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle
				+ ", auteur=" + auteur + ", titreFr=" + titreFr
				+ ", titreEn=" + titreEn + ", contenuFr=" + contenuFr
				+ ", contenuEng=" + contenuEng + ", commentaireAutorise="
				+ commentaireAutorise + ", statutArticle=" + statutArticle
				+ ", dateCreation=" + dateCreation + ", urlPhotoPrincipale="
				+ urlPhotoPrincipale + ", visibleHome=" + visibleHome
				+ ", mainArticle=" + mainArticle + "]";
	}
	
	
	
}
