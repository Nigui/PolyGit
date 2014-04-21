package com.example.polyjoule.externeDataBase;

public abstract class Requetes {

	//TODO 
	/** Tables + Attributs **/
	public static final String DATABASE_ALBUM = "ALBUM";
		public static final String DATABASE_ALBUM_ID = "id_album";
		public static final String DATABASE_ALBUM_NOM = "nom_album";
		public static final String DATABASE_ALBUM_DATE = "date_album";
		public static final String DATABASE_ALBUM_DESCFR = "descFR_album";
		public static final String DATABASE_ALBUM_DESCEN = "descEN_album";
		
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
		
	public static final String DATABASE_COMMENTAIRE = "COMMENTAIRE";
		public static final String DATABASE_COMMENTAIRE_ID = "id_commentaire";
		public static final String DATABASE_COMMENTAIRE_ARTICLE = "id_article";
		public static final String DATABASE_COMMENTAIRE_DATE = "date_commentaire";
		public static final String DATABASE_COMMENTAIRE_POSTEUR = "posteur_commentaire";
		public static final String DATABASE_COMMENTAIRE_MAIL = "mail_commentaire";
		public static final String DATABASE_COMMENTAIRE_MESSAGE = "message_commentaire";
		
	public static final String DATABASE_COURSE = "COURSE";
		public static final String DATABASE_COURSE_ID = "id_course";
		public static final String DATABASE_COURSE_EQUIPE = "id_equipe";
		public static final String DATABASE_COURSE_DATE = "date_course";
		public static final String DATABASE_COURSE_LIEU = "lieu_course";
		public static final String DATABASE_COURSE_IMG = "img_course";
		public static final String DATABASE_COURSE_DESCFR = "descFR_course";
		public static final String DATABASE_COURSE_DESCEN = "descEN_course";
	
	public static final String DATABASE_ECOLE = "ECOLE";
		public static final String DATABASE_ECOLE_ID = "id_ecole";
		public static final String DATABASE_ECOLE_NOM = "nom_ecole";
		public static final String DATABASE_ECOLE_ADRESSE = "adresse_ecole";
		public static final String DATABASE_ECOLE_PHOTO = "photo_ecole";
		public static final String DATABASE_ECOLE_DESCFR = "descFR_ecole";
		public static final String DATABASE_ECOLE_DESCEN = "descEN_ecole";
		
	public static final String DATABASE_EQUIPE = "EQUIPE";
		public static final String DATABASE_EQUIPE_ID = "id_equipe";
		public static final String DATABASE_EQUIPE_ANNEE = "annee_equipe";
		
	public static final String DATABASE_FORMATION = "FORMATION";
		public static final String DATABASE_FORMATION_ID = "id_formation";
		public static final String DATABASE_FORMATION_ECOLE = "id_ecole";
		public static final String DATABASE_FORMATION_TITREFR = "titreFR_formation";
		public static final String DATABASE_FORMATION_TITREEN = "titreEN_formation";
		public static final String DATABASE_FORMATION_LIEN = "lien_formation";
		public static final String DATABASE_FORMATION_DESCFR = "descFR_formation";
		public static final String DATABASE_FORMATION_DESCEN = "descEN_formation";
	
	public static final String DATABASE_LIVREOR = "LIVREOR";
		public static final String DATABASE_LIVREOR_ID = "id_post";
		public static final String DATABASE_LIVREOR_POSTEUR = "posteur_post";
		public static final String DATABASE_LIVREOR_MAIL = "mail_post";
		public static final String DATABASE_LIVREOR_DATE = "date_post";
		public static final String DATABASE_LIVREOR_MESSAGE = "message_post";
		public static final String DATABASE_LIVREOR_ACCEPTED = "accept_post";
		
	public static final String DATABASE_PARTENAIRE = "PARTENAIRE";
		public static final String DATABASE_PARTENAIRE_ID = "id_partenaire";
		public static final String DATABASE_PARTENAIRE_NOM = "nom_partenaire";
		public static final String DATABASE_PARTENAIRE_LOGO = "logo_partenaire";
		public static final String DATABASE_PARTENAIRE_SITE = "site_partenaire";
		public static final String DATABASE_PARTENAIRE_DESCFR = "descFR_partenaire";
		public static final String DATABASE_PARTENAIRE_DESCEN = "descEN_partenaire";
		
	
	public static final String DATABASE_PARTICIPANT = "PARTICIPANT";
		public static final String DATABASE_PARTICIPANT_ID = "id_participant";
		public static final String DATABASE_PARTICIPANT_NOM = "nom_participant";
		public static final String DATABASE_PARTICIPANT_PRENOM = "prenom_participant";
		public static final String DATABASE_PARTICIPANT_PHOTO = "photo_participant";
		public static final String DATABASE_PARTICIPANT_MAIL = "mail_participant";
		public static final String DATABASE_PARTICIPANT_BIOFR = "bioFR_participant";
		public static final String DATABASE_PARTICIPANT_BIOEN = "bioEN_participant";
		public static final String DATABASE_PARTICIPANT_ISPROF = "isProf";
		
	
	public static final String DATABASE_PARTICIPATION = "PARTICIPATION";
		public static final String DATABASE_PARTICIPATION_EQUIPE = "id_equipe";
		public static final String DATABASE_PARTICIPATION_PARTICIPANT = "id_participant";
		public static final String DATABASE_PARTICIPATION_ROLE = "role_participation";
		
	public static final String DATABASE_PHOTO = "PHOTO";
		public static final String DATABASE_PHOTO_IDALBUM = "id_album";
		public static final String DATABASE_PHOTO_TITREFR = "titreFR_photo";
		public static final String DATABASE_PHOTO_TITREEN = "titreEN_photo";
		public static final String DATABASE_PHOTO_LIEN = "lien_photo";
		public static final String DATABASE_PHOTO_DATE = "date_photo";
		public static final String DATABASE_PHOTO_DESCFR = "descFR_photo";
		public static final String DATABASE_PHOTO_DESCEN = "descEN_photo";
		
	public static final String DATABASE_RUBRIQUE = "RUBRIQUE";
		public static final String DATABASE_RUBRIQUE_ID = "id_rubrique";
		public static final String DATABASE_RUBRIQUE_MERE = "id_mere";
		public static final String DATABASE_RUBRIQUE_TITREFR = "titreFR_rubrique";
		public static final String DATABASE_RUBRIQUE_TITREEN = "titreEN_rubrique";
		public static final String DATABASE_RUBRIQUE_DESCFR = "descFR_rubrique";
		public static final String DATABASE_RUBRIQUE_DESCEN = "descEN_rubrique";
		
	
	/** Creations **/
	public static final String DATABASE_CREATE_ALBUM = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_ALBUM+" ( "
					+ DATABASE_ALBUM_ID+" INTEGER,"
					+ DATABASE_ALBUM_NOM+" TEXT,"
					+ DATABASE_ALBUM_DATE+" TEXT,"
					+ DATABASE_ALBUM_DESCFR+" TEXT,"
					+ DATABASE_ALBUM_DESCEN+" TEXT"
			+ ")";
	
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
					+ DATABASE_ARTICLE_PHOTO+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_COMMENTAIRE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_COMMENTAIRE+" ( "
					+ DATABASE_COMMENTAIRE_ID+" INTEGER,"
					+ DATABASE_COMMENTAIRE_ARTICLE+" INTEGER,"
					+ DATABASE_COMMENTAIRE_DATE+" TEXT,"
					+ DATABASE_COMMENTAIRE_POSTEUR+" TEXT,"
					+ DATABASE_COMMENTAIRE_MAIL+" TEXT,"
					+ DATABASE_COMMENTAIRE_MESSAGE+" TEXT"
			+ ")";

	public static final String DATABASE_CREATE_COURSE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_COURSE+" ( "
					+ DATABASE_COURSE_ID+" INTEGER,"
					+ DATABASE_COURSE_EQUIPE+" INTEGER,"
					+ DATABASE_COURSE_DATE+" TEXT,"
					+ DATABASE_COURSE_LIEU+" TEXT,"
					+ DATABASE_COURSE_IMG+" TEXT,"
					+ DATABASE_COURSE_DESCFR+" TEXT,"
					+ DATABASE_COURSE_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_ECOLE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_ECOLE+" ( "
					+ DATABASE_ECOLE_ID+" INTEGER,"
					+ DATABASE_ECOLE_NOM+" TEXT,"
					+ DATABASE_ECOLE_ADRESSE+" TEXT,"
					+ DATABASE_ECOLE_PHOTO+" TEXT,"
					+ DATABASE_ECOLE_DESCFR+" TEXT,"
					+ DATABASE_ECOLE_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_EQUIPE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_EQUIPE+" ( "
					+ DATABASE_EQUIPE_ID+" INTEGER,"
					+ DATABASE_EQUIPE_ANNEE+" INTEGER"
			+ ")";
	
	public static final String DATABASE_CREATE_FORMATION = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_FORMATION+" ( "
					+ DATABASE_FORMATION_ID+" INTEGER,"
					+ DATABASE_FORMATION_ECOLE+" INTEGER,"
					+ DATABASE_FORMATION_TITREFR+" TEXT,"
					+ DATABASE_FORMATION_TITREEN+" TEXT,"
					+ DATABASE_FORMATION_LIEN+" TEXT,"
					+ DATABASE_FORMATION_DESCFR+" TEXT,"
					+ DATABASE_FORMATION_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_LIVREOR = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_LIVREOR+" ( "
					+ DATABASE_LIVREOR_ID+" INTEGER,"
					+ DATABASE_LIVREOR_POSTEUR+" INTEGER,"
					+ DATABASE_LIVREOR_MAIL+" TEXT,"
					+ DATABASE_LIVREOR_DATE+" TEXT,"
					+ DATABASE_LIVREOR_MESSAGE+" TEXT,"
					+ DATABASE_LIVREOR_ACCEPTED+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_PARTENAIRE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_PARTENAIRE+" ( "
					+ DATABASE_PARTENAIRE_ID+" INTEGER,"
					+ DATABASE_PARTENAIRE_NOM+" TEXT,"
					+ DATABASE_PARTENAIRE_LOGO+" TEXT,"
					+ DATABASE_PARTENAIRE_SITE+" TEXT,"
					+ DATABASE_PARTENAIRE_DESCFR+" TEXT,"
					+ DATABASE_PARTENAIRE_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_PARTICIPANT = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_PARTICIPANT+" ( "
					+ DATABASE_PARTICIPANT_ID+" INTEGER,"
					+ DATABASE_PARTICIPANT_NOM+" TEXT,"
					+ DATABASE_PARTICIPANT_PRENOM+" TEXT,"
					+ DATABASE_PARTICIPANT_PHOTO+" TEXT,"
					+ DATABASE_PARTICIPANT_MAIL+" TEXT,"
					+ DATABASE_PARTICIPANT_BIOFR+" TEXT,"
					+ DATABASE_PARTICIPANT_BIOEN+" TEXT,"
					+ DATABASE_PARTICIPANT_ISPROF+" INTEGER"
			+ ")";
	
	public static final String DATABASE_CREATE_PARTICIPATION = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_PARTICIPATION+" ( "
					+ DATABASE_PARTICIPATION_EQUIPE+" INTEGER,"
					+ DATABASE_PARTICIPATION_PARTICIPANT+" INTEGER,"
					+ DATABASE_PARTICIPATION_ROLE+" TEXT"
			+ ")";
			
	public static final String DATABASE_CREATE_PHOTO = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_PHOTO+" ( "
					+ DATABASE_PHOTO_IDALBUM+" INTEGER,"
					+ DATABASE_PHOTO_TITREFR+" TEXT,"
					+ DATABASE_PHOTO_TITREEN+" TEXT,"
					+ DATABASE_PHOTO_LIEN+" TEXT,"
					+ DATABASE_PHOTO_DATE+" TEXT,"
					+ DATABASE_PHOTO_DESCFR+" TEXT,"
					+ DATABASE_PHOTO_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE_RUBRIQUE = 
			"CREATE TABLE IF NOT EXISTS "+DATABASE_RUBRIQUE+" ( "
					+ DATABASE_RUBRIQUE_ID+" INTEGER,"
					+ DATABASE_RUBRIQUE_MERE+" INTEGER,"
					+ DATABASE_RUBRIQUE_TITREFR+" TEXT,"
					+ DATABASE_RUBRIQUE_TITREEN+" TEXT,"
					+ DATABASE_RUBRIQUE_DESCFR+" TEXT,"
					+ DATABASE_RUBRIQUE_DESCEN+" TEXT"
			+ ")";
	
	public static final String DATABASE_CREATE = 
			DATABASE_CREATE_ARTICLE+"; "
			+ DATABASE_CREATE_ALBUM+"; "
			+ DATABASE_CREATE_COMMENTAIRE+"; "
			+ DATABASE_CREATE_COURSE+"; "
			+ DATABASE_CREATE_ECOLE+"; "
			+ DATABASE_CREATE_EQUIPE+"; "
			+ DATABASE_CREATE_FORMATION+"; "
			+ DATABASE_CREATE_LIVREOR+"; "
			+ DATABASE_CREATE_PARTENAIRE+"; "
			+ DATABASE_CREATE_PARTICIPANT+"; "
			+ DATABASE_CREATE_PARTICIPATION+"; "
			+ DATABASE_CREATE_PHOTO+"; "
			+ DATABASE_CREATE_RUBRIQUE+"; "
			;
	
	/** Destructions **/
	public static final String DATABASE_DESTROY_ARTICLE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_ARTICLE+";";
	
	public static final String DATABASE_DESTROY_ALBUM = 
			"DROP TABLE IF IT EXISTS "+DATABASE_ALBUM+";";
	
	public static final String DATABASE_DESTROY_COMMENTAIRE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_COMMENTAIRE+";";
	
	public static final String DATABASE_DESTROY_COURSE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_COURSE+";";
	
	public static final String DATABASE_DESTROY_ECOLE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_ECOLE+";";
	
	public static final String DATABASE_DESTROY_EQUIPE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_EQUIPE+";";
	
	public static final String DATABASE_DESTROY_FORMATION = 
			"DROP TABLE IF IT EXISTS "+DATABASE_FORMATION+";";
	
	public static final String DATABASE_DESTROY_LIVREOR = 
			"DROP TABLE IF IT EXISTS "+DATABASE_LIVREOR+";";
			
	public static final String DATABASE_DESTROY_PARTENAIRE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_PARTENAIRE+";";
	
	public static final String DATABASE_DESTROY_PARTICIPANT = 
			"DROP TABLE IF IT EXISTS "+DATABASE_PARTICIPANT+";";
	
	public static final String DATABASE_DESTROY_PARTICIPATION = 
			"DROP TABLE IF IT EXISTS "+DATABASE_PARTICIPATION+";";
	
	public static final String DATABASE_DESTROY_PHOTO = 
			"DROP TABLE IF IT EXISTS "+DATABASE_PHOTO+";";
			
	public static final String DATABASE_DESTROY_RUBRIQUE = 
			"DROP TABLE IF IT EXISTS "+DATABASE_RUBRIQUE+";";
	
	
	public static final String DATABASE_DESTROY = 
			DATABASE_DESTROY_ARTICLE
			+ DATABASE_DESTROY_ALBUM
			+ DATABASE_DESTROY_COMMENTAIRE
			+ DATABASE_DESTROY_COURSE
			+ DATABASE_DESTROY_ECOLE
			+ DATABASE_DESTROY_EQUIPE
			+ DATABASE_DESTROY_FORMATION
			+ DATABASE_DESTROY_LIVREOR
			+ DATABASE_DESTROY_PARTENAIRE
			+ DATABASE_DESTROY_PARTICIPANT
			+ DATABASE_DESTROY_PARTICIPATION
			+ DATABASE_DESTROY_PHOTO
			+ DATABASE_DESTROY_RUBRIQUE
			;
	
	/** Requetes **/
	
	
	
}
