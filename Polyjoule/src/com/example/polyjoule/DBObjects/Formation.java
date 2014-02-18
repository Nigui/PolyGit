package com.example.polyjoule.DBObjects;

public class Formation {

	private int id;
	private String titre;
	private String lienWeb;
	private String descriptionFR;
	private String descriptionEN;
	
	//------ Constructeurs
	public Formation(int id, String titre, String lienWeb,
			String descriptionFR, String descriptionEN) {
		super();
		this.id = id;
		this.titre = titre;
		this.lienWeb = lienWeb;
		this.descriptionFR = descriptionFR;
		this.descriptionEN = descriptionEN;
	}
	public Formation() {
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLienWeb() {
		return lienWeb;
	}
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
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
		return "Formation [id=" + id + ", titre=" + titre + ", lienWeb="
				+ lienWeb + ", descriptionFR=" + descriptionFR
				+ ", descriptionEN=" + descriptionEN + "]";
	}
	
	
}
