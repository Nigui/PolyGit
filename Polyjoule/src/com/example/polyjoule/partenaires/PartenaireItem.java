package com.example.polyjoule.partenaires;

public class PartenaireItem {
	
    private String imageURL;
    private String nom;
 
    public PartenaireItem(String imageURL,String nom) {
        this.imageURL = imageURL;
        this.nom = nom;
    }
    public String getNom() {
		return nom;
	}
	public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}