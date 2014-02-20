package com.example.polyjoule.interneDataBase;

public abstract class Requetes {

	//TODO 
	/** Tables + Attributs **/
	public static final String DATABASE_ALBUM = "ALBUM";
	public static final String DATABASE_ARTICLE = "ARTICLE";
		public static final String DATABASE_ARTICLE_ID = "id_article";
		public static final String DATABASE_ARTICLE_RUBRIQUE = "id_rubrique";
		public static final String DATABASE_ARTICLE_AUTEUR = "auteur_article";
		public static final String DATABASE_ARTICLE_TITREFR = "titreFR_article";
		public static final String DATABASE_ARTICLE_TITREEN = "titreEN_article";
		public static final String DATABASE_ARTICLE_CONTENUFR = "contenuFR_article";
		public static final String DATABASE_ARTICLE_CONTENUEN = "contenuEN_article";
		public static final String DATABASE_ARTICLE_AUTORISATIONCOM = "autorisation_com";
		public static final String DATABASE_ARTICLE_STATUT = "statut_article";
		public static final String DATABASE_ARTICLE_DATE = "date_article";
		public static final String DATABASE_ARTICLE_PHOTO = "url_photo_principale";
		public static final String DATABASE_ARTICLE_VISIBLE = "visible_home";
		
	public static final String DATABASE_COMMENTAIRE = "COMMENTAIRE";
	public static final String DATABASE_COURSE = "COURSE";
	public static final String DATABASE_ECOLE = "ECOLE";
	public static final String DATABASE_EQUIPE = "EQUIPE";
	public static final String DATABASE_FORMATION = "FORMATION";
	public static final String DATABASE_LIVREOR = "LIVREOR";
	public static final String DATABASE_PARTENAIRE = "PARTENAIRE";
	public static final String DATABASE_PARTICIPANT = "PARTICIPANT";
	public static final String DATABASE_PARTICIPATION = "PARTICIPATION";
	public static final String DATABASE_PHOTO = "PHOTO";
	public static final String DATABASE_RUBRIQUE = "RUBRIQUE";
	
	/** Creations **/
	public static final String DATABASE_CREATE_ALBUM = "";
	
	public static final String DATABASE_CREATE_ARTICLE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_ARTICLE+" ( "
					+ DATABASE_ARTICLE_ID+" INTEGER,"
					+ DATABASE_ARTICLE_RUBRIQUE+" INTEGER,"
					+ DATABASE_ARTICLE_AUTEUR+" TEXT,"
					+ DATABASE_ARTICLE_TITREFR+" TEXT,"
					+ DATABASE_ARTICLE_TITREEN+" TEXT,"
					+ DATABASE_ARTICLE_CONTENUFR+" TEXT,"
					+ DATABASE_ARTICLE_CONTENUEN+" TEXT,"
					+ DATABASE_ARTICLE_AUTORISATIONCOM+" INT,"
					+ DATABASE_ARTICLE_STATUT+" INT,"
					+ DATABASE_ARTICLE_DATE+" TEXT,"
					+ DATABASE_ARTICLE_PHOTO+" TEXT,"
					+ DATABASE_ARTICLE_VISIBLE+" INT"
			+ ")";
	
	public static final String DATABASE_CREATE_COMMENTAIRE = "COMMENTAIRE";
	public static final String DATABASE_CREATE_COURSE = "COURSE";
	public static final String DATABASE_CREATE_ECOLE = "ECOLE";
	public static final String DATABASE_CREATE_EQUIPE = "EQUIPE";
	public static final String DATABASE_CREATE_FORMATION = "FORMATION";
	public static final String DATABASE_CREATE_LIVREOR = "LIVREOR";
	public static final String DATABASE_CREATE_PARTENAIRE = "PARTENAIRE";
	public static final String DATABASE_CREATE_PARTICIPANT = "PARTICIPANT";
	public static final String DATABASE_CREATE_PARTICIPATION = "PARTICIPATION";
	public static final String DATABASE_CREATE_PHOTO = "PHOTO";
	public static final String DATABASE_CREATE_RUBRIQUE = "RUBRIQUE";
	
	public static final String DATABASE_CREATE = 
			DATABASE_CREATE_ARTICLE;
	
	/** Destructions **/
	public static final String DATABASE_DESTROY_ARTICLE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_ARTICLE+";";
	
	public static final String DATABASE_DESTROY_COMMENTAIRE = "COMMENTAIRE";
	public static final String DATABASE_DESTROY_COURSE = "COURSE";
	public static final String DATABASE_DESTROY_ECOLE = "ECOLE";
	public static final String DATABASE_DESTROY_EQUIPE = "EQUIPE";
	public static final String DATABASE_DESTROY_FORMATION = "FORMATION";
	public static final String DATABASE_DESTROY_LIVREOR = "LIVREOR";
	public static final String DATABASE_DESTROY_PARTENAIRE = "PARTENAIRE";
	public static final String DATABASE_DESTROY_PARTICIPANT = "PARTICIPANT";
	public static final String DATABASE_DESTROY_PARTICIPATION = "PARTICIPATION";
	public static final String DATABASE_DESTROY_PHOTO = "PHOTO";
	public static final String DATABASE_DESTROY_RUBRIQUE = "RUBRIQUE";
	
	public static final String DATABASE_DESTROY = 
			DATABASE_DESTROY_ARTICLE;
	
	/** Requetes **/
	
	
	
}
