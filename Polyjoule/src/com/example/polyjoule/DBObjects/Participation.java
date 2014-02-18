package com.example.polyjoule.DBObjects;

public class Participation {

	private Equipe equipe;
	private Participant participant;
	private String role;

	
	//------ Constructeurs
	public Participation(Equipe equipe, Participant participant, String role) {
		super();
		this.equipe = equipe;
		this.participant = participant;
		this.role = role;
	}
	public Participation() {
		super();
	}
	//################## Constructeurs

	//------GETTERS & SETTERS
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//################## GETTERS & SETTERS
	
	
	@Override
	public String toString() {
		return "Participation [equipe=" + equipe + ", participant="
				+ participant + ", role=" + role + "]";
	}
	
	
}
