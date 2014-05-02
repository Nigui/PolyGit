package com.example.polyjoule.DBObjects;


public class Equipe {

	private int id;
	private int annee;
	
	//------ Constructeurs
	
	public Equipe(int id, int annee) {
		super();
		this.id = id;
		this.annee = annee;
	}
	public Equipe() {
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	//################## GETTERS & SETTERS
	
}
