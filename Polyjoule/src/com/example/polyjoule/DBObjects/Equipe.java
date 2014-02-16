package com.example.polyjoule.DBObjects;

import java.util.ArrayList;

public class Equipe {

	private int id;
	private int annee;
	private ArrayList<Participation> participants;
	
	//------ Constructeurs
	public Equipe(int id, int annee, ArrayList<Participation> participants) {
		super();
		this.id = id;
		this.annee = annee;
		this.participants = participants;
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
	public ArrayList<Participation> getParticipants() {
		return participants;
	}
	public void setParticipants(ArrayList<Participation> participants) {
		this.participants = participants;
	}
	//################## GETTERS & SETTERS
	
	@Override
	public String toString() {
		return "Equipe [id=" + id + ", annee=" + annee + ", participants="
				+ participants + "]";
	}
	
	
}
