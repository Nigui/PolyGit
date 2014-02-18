package com.example.polyjoule.DBObjects;

import java.util.Date;

public class LivreOr {

	private int id;
	private String auteur;
	private String mail;
	private Date date;
	private String message;
	private boolean accepted;
	
	
	//------ Constructeurs
	public LivreOr(int id, String auteur, String mail, Date date,
			String message, boolean accepted) {
		super();
		this.id = id;
		this.auteur = auteur;
		this.mail = mail;
		this.date = date;
		this.message = message;
		this.accepted = accepted;
	}
	public LivreOr() {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	//################## GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "LivreOr [id=" + id + ", auteur=" + auteur + ", mail=" + mail
				+ ", date=" + date + ", message=" + message + ", accepted="
				+ accepted + "]";
	}
	
}
