package com.example.polyjoule.DBObjects;

public class Formation {

	private int id;
	private Ecole ecole;
	private String titreFR;
	private String titreEN;
	private String lienWeb;
	private String descriptionFR;
	private String descriptionEN;
	
	//------ Constructeurs
	
	public Formation(int id, Ecole ecole, String titreFR, String titreEN,
			String lienWeb, String descriptionFR, String descriptionEN) {
		super();
		this.id = id;
		this.ecole = ecole;
		this.titreFR = titreFR;
		this.titreEN = titreEN;
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
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
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
		return "Formation [id=" + id + ", ecole=" + ecole + ", titreFR="
				+ titreFR + ", titreEN=" + titreEN + ", lienWeb=" + lienWeb
				+ ", descriptionFR=" + descriptionFR + ", descriptionEN="
				+ descriptionEN + "]";
	}
	
	
}
