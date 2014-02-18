package com.example.polyjoule.DBObjects;

import java.util.Date;

public class Commentaire {

	private int id;
	private Date date;
	private String auteur;
	private String mail;
	private String message;
	private Article article;
	
	//------ Constructeurs
	public Commentaire(int id, Date date, String auteur, String mail,
			String message, Article article) {
		super();
		this.id = id;
		this.date = date;
		this.auteur = auteur;
		this.mail = mail;
		this.message = message;
		this.article = article;
	}
	public Commentaire() {
		super();
	}
	//################## Constructeurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	//------GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", date=" + date + ", auteur="
				+ auteur + ", mail=" + mail + ", message=" + message
				+ ", article=" + article + "]";
	}
	
	
	
}
