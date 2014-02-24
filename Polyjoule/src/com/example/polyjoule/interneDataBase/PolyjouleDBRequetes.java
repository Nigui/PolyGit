package com.example.polyjoule.interneDataBase;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.polyjoule.DBObjects.Album;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.DBObjects.Commentaire;
import com.example.polyjoule.DBObjects.Course;
import com.example.polyjoule.DBObjects.Ecole;
import com.example.polyjoule.DBObjects.Equipe;
import com.example.polyjoule.DBObjects.Formation;
import com.example.polyjoule.DBObjects.LivreOr;
import com.example.polyjoule.DBObjects.Partenaire;
import com.example.polyjoule.DBObjects.Participant;
import com.example.polyjoule.DBObjects.Participation;
import com.example.polyjoule.DBObjects.Photo;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.utils.Tools;

public class PolyjouleDBRequetes {

	private PolyjouleDBOpenHelper oh; 
	private SQLiteDatabase db;
	private Cursor cursor;
	

	private ArrayList<String> result;
	private String where;
	private ArrayList<String> whereArgs;
	private String groupBy;
	private String having;
	private String order;
	
	
	public PolyjouleDBRequetes(PolyjouleDBOpenHelper helper) {
		this.oh = helper;
		this.db = this.oh.getReadableDatabase();
		result = new ArrayList<String>();
		whereArgs = new ArrayList<String>();
		where = "";
		groupBy = "";
		having = "";
		order = "";
	}
	
	public ArrayList<Album> getAlbumInternalFromDB(){
		ArrayList<Album> ret = new ArrayList<Album>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_ALBUM_ID,
				Requetes.DATABASE_ALBUM_NOM,
				Requetes.DATABASE_ALBUM_DATE,
				Requetes.DATABASE_ALBUM_DESCFR,
				Requetes.DATABASE_ALBUM_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_ALBUM, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_ALBUM_ID);
			int nom = cursor.getColumnIndex(Requetes.DATABASE_ALBUM_NOM);
			int date = cursor.getColumnIndex(Requetes.DATABASE_ALBUM_DATE);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_ALBUM_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_ALBUM_DESCEN);
			
			while( cursor.moveToNext() ){
				Album a = new Album();
				a.setId(this.cursor.getInt(id));
				a.setNom(this.cursor.getString(nom));
				a.setDate(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	public ArrayList<Article> getArticleInternalFromDB(){
		ArrayList<Article> ret = new ArrayList<Article>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_ARTICLE_ID,
				Requetes.DATABASE_ARTICLE_RUBRIQUE,
				Requetes.DATABASE_ARTICLE_AUTEUR,
				Requetes.DATABASE_ARTICLE_TITREFR,
				Requetes.DATABASE_ARTICLE_TITREEN,
				Requetes.DATABASE_ARTICLE_CONTENUFR,
				Requetes.DATABASE_ARTICLE_CONTENUEN,
				Requetes.DATABASE_ARTICLE_AUTORISATIONCOM,
				Requetes.DATABASE_ARTICLE_STATUT,
				Requetes.DATABASE_ARTICLE_DATE,
				Requetes.DATABASE_ARTICLE_PHOTO,
		};
		
		this.cursor = db.query(Requetes.DATABASE_ARTICLE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_ID);
			int rubrique = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_RUBRIQUE);
			int auteur = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_AUTEUR);
			int titreFR = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_TITREFR);
			int titreEN = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_TITREEN);
			int contenuFR = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_CONTENUFR);
			int contenuEN = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_CONTENUEN);
			int autoriseCom = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM);
			int statut = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_STATUT);
			int date = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_DATE);
			int photo = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_PHOTO);
			
			while( cursor.moveToNext() ){
				Article a = new Article();
				a.setIdArticle(this.cursor.getInt(id));
				//TODO setRubrique
				a.setAuteur(this.cursor.getString(auteur));
				a.setTitreFr(this.cursor.getString(titreFR));
				a.setTitreEn(this.cursor.getString(titreEN));
				a.setContenuFr(this.cursor.getString(contenuFR));
				a.setContenuEng(this.cursor.getString(contenuEN));
				a.setCommentaireAutorise(Tools.parseIntToBoolean(this.cursor.getInt(autoriseCom)));
				a.setStatutArticle(Tools.parseIntToBoolean(this.cursor.getInt(statut)));
				a.setDateCreation(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setUrlPhotoPrincipale(this.cursor.getString(photo));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	public ArrayList<Commentaire> getCommentaireInternalFromDB(){
		ArrayList<Commentaire> ret = new ArrayList<Commentaire>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_COMMENTAIRE_ID,
				Requetes.DATABASE_COMMENTAIRE_ARTICLE,
				Requetes.DATABASE_COMMENTAIRE_DATE,
				Requetes.DATABASE_COMMENTAIRE_POSTEUR,
				Requetes.DATABASE_COMMENTAIRE_MAIL,
				Requetes.DATABASE_COMMENTAIRE_MESSAGE
		};
		
		this.cursor = db.query(Requetes.DATABASE_COMMENTAIRE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_ID);
			int art = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_ARTICLE);
			int date = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_DATE);
			int posteur = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_POSTEUR);
			int mail = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_POSTEUR);
			int message = cursor.getColumnIndex(Requetes.DATABASE_COMMENTAIRE_MESSAGE);
			
			while( cursor.moveToNext() ){
				Commentaire a = new Commentaire();
				a.setId(this.cursor.getInt(id));
				//a.setNom(this.cursor.getString(art));
				a.setDate(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setAuteur(this.cursor.getString(posteur));
				a.setMail(this.cursor.getString(mail));
				a.setMessage(this.cursor.getString(message));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<Course> getCourseInternalFromDB(){
		ArrayList<Course> ret = new ArrayList<Course>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_COURSE_ID,
				Requetes.DATABASE_COURSE_EQUIPE,
				Requetes.DATABASE_COURSE_DATE,
				Requetes.DATABASE_COURSE_LIEU,
				Requetes.DATABASE_COURSE_IMG,
				Requetes.DATABASE_COURSE_DESCFR,
				Requetes.DATABASE_COURSE_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_COURSE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_COURSE_ID);
			int eq = cursor.getColumnIndex(Requetes.DATABASE_COURSE_EQUIPE);
			int date = cursor.getColumnIndex(Requetes.DATABASE_COURSE_DATE);
			int lieu = cursor.getColumnIndex(Requetes.DATABASE_COURSE_LIEU);
			int img = cursor.getColumnIndex(Requetes.DATABASE_COURSE_IMG);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_COURSE_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_COURSE_DESCEN);
			
			while( cursor.moveToNext() ){
				Course a = new Course();
				a.setId(this.cursor.getInt(id));
				//a.setEquipe(this.cursor.getString(eq));
				a.setDate(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setLieu(this.cursor.getString(lieu));
				a.setImageURL(this.cursor.getString(img));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	public ArrayList<Ecole> getEcoleInternalFromDB(){
		ArrayList<Ecole> ret = new ArrayList<Ecole>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_ECOLE_ID,
				Requetes.DATABASE_ECOLE_NOM,
				Requetes.DATABASE_ECOLE_ADRESSE,
				Requetes.DATABASE_ECOLE_PHOTO,
				Requetes.DATABASE_ECOLE_DESCFR,
				Requetes.DATABASE_ECOLE_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_ECOLE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_ID);
			int nom = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_NOM);
			int adresse = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_ADRESSE);
			int photo = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_PHOTO);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_ECOLE_DESCEN);
			
			while( cursor.moveToNext() ){
				Ecole a = new Ecole();
				a.setId(this.cursor.getInt(id));
				a.setNom(this.cursor.getString(nom));
				a.setAdresse(this.cursor.getString(adresse));
				a.setPhotoURL(this.cursor.getString(photo));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	public ArrayList<Equipe> getEquipeInternalFromDB(){
		ArrayList<Equipe> ret = new ArrayList<Equipe>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_EQUIPE_ID,
				Requetes.DATABASE_EQUIPE_ANNEE
		};
		
		this.cursor = db.query(Requetes.DATABASE_EQUIPE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_EQUIPE_ID);
			int annee = cursor.getColumnIndex(Requetes.DATABASE_EQUIPE_ANNEE);
			
			while( cursor.moveToNext() ){
				Equipe a = new Equipe();
				a.setId(this.cursor.getInt(id));
				a.setAnnee(this.cursor.getInt(annee));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	public ArrayList<Formation> getFormationInternalFromDB(){
		ArrayList<Formation> ret = new ArrayList<Formation>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_FORMATION_ID,
				Requetes.DATABASE_FORMATION_ECOLE,
				Requetes.DATABASE_FORMATION_TITREFR,
				Requetes.DATABASE_FORMATION_TITREEN,
				Requetes.DATABASE_FORMATION_LIEN,
				Requetes.DATABASE_FORMATION_DESCFR,
				Requetes.DATABASE_FORMATION_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_FORMATION, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_ID);
			int ecole = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_ECOLE);
			int titreFR = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_TITREFR);
			int titreEN = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_TITREEN);
			int lien = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_LIEN);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_FORMATION_DESCEN);
			
			while( cursor.moveToNext() ){
				Formation a = new Formation();
				a.setId(this.cursor.getInt(id));
				//a.setNom(this.cursor.getString(ecole));
				a.setTitreFR(this.cursor.getString(titreFR));
				a.setTitreEN(this.cursor.getString(titreEN));
				a.setLienWeb(this.cursor.getString(lien));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<LivreOr> getLivreOrInternalFromDB(){
		ArrayList<LivreOr> ret = new ArrayList<LivreOr>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_LIVREOR_ID,
				Requetes.DATABASE_LIVREOR_POSTEUR,
				Requetes.DATABASE_LIVREOR_MAIL,
				Requetes.DATABASE_LIVREOR_DATE,
				Requetes.DATABASE_LIVREOR_MESSAGE,
				Requetes.DATABASE_LIVREOR_ACCEPTED
		};
		
		this.cursor = db.query(Requetes.DATABASE_FORMATION, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_ID);
			int post = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_POSTEUR);
			int mail = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_MAIL);
			int date = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_DATE);
			int mess = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_MESSAGE);
			int acc = cursor.getColumnIndex(Requetes.DATABASE_LIVREOR_ACCEPTED);
			
			while( cursor.moveToNext() ){
				LivreOr a = new LivreOr();
				a.setId(this.cursor.getInt(id));
				a.setAuteur(this.cursor.getString(post));
				a.setMail(this.cursor.getString(mail));
				a.setDate(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setMessage(this.cursor.getString(mess));
				a.setAccepted(Tools.parseIntToBoolean(this.cursor.getInt(acc)));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<Partenaire> getPartenaireInternalFromDB(){
		ArrayList<Partenaire> ret = new ArrayList<Partenaire>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_PARTENAIRE_ID,
				Requetes.DATABASE_PARTENAIRE_NOM,
				Requetes.DATABASE_PARTENAIRE_LOGO,
				Requetes.DATABASE_PARTENAIRE_SITE,
				Requetes.DATABASE_PARTENAIRE_DESCFR,
				Requetes.DATABASE_PARTENAIRE_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_PARTENAIRE, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_ID);
			int nom = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_NOM);
			int logo = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_LOGO);
			int site = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_SITE);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_PARTENAIRE_DESCEN);
			
			while( cursor.moveToNext() ){
				Partenaire a = new Partenaire();
				a.setId(this.cursor.getInt(id));
				a.setNom(this.cursor.getString(nom));
				a.setLogoURL(this.cursor.getString(logo));
				a.setWebsiteURL(this.cursor.getString(site));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionFR(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<Participant> getParticipantInternalFromDB(){
		ArrayList<Participant> ret = new ArrayList<Participant>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_PARTICIPANT_ID,
				Requetes.DATABASE_PARTICIPANT_NOM,
				Requetes.DATABASE_PARTICIPANT_PRENOM,
				Requetes.DATABASE_PARTICIPANT_PHOTO,
				Requetes.DATABASE_PARTICIPANT_MAIL,
				Requetes.DATABASE_PARTICIPANT_BIOFR,
				Requetes.DATABASE_PARTICIPANT_BIOEN,
				Requetes.DATABASE_PARTICIPANT_ISPROF
		};
		
		this.cursor = db.query(Requetes.DATABASE_PARTICIPANT, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_ID);
			int nom = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_NOM);
			int prenom = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_PRENOM);
			int photo = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_PHOTO);
			int mail = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_MAIL);
			int bioFR = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_BIOFR);
			int bioEN = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_BIOEN);
			int prof = cursor.getColumnIndex(Requetes.DATABASE_PARTICIPANT_ISPROF);
			
			while( cursor.moveToNext() ){
				Participant a = new Participant();
				a.setId(this.cursor.getInt(id));
				a.setNom(this.cursor.getString(nom));
				a.setPrenom(this.cursor.getString(prenom));
				a.setPhotoURL(this.cursor.getString(photo));
				a.setEmail(this.cursor.getString(mail));
				a.setBioFR(this.cursor.getString(bioFR));
				a.setBioEN(this.cursor.getString(bioEN));
				a.setProf(Tools.parseIntToBoolean(this.cursor.getInt(prof)));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<Participation> getParticipationInternalFromDB(){
		/* participation */
		return null;
	}

	public ArrayList<Photo> getPhotoInternalFromDB(){
		ArrayList<Photo> ret = new ArrayList<Photo>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_PHOTO_ID,
				Requetes.DATABASE_PHOTO_TITREFR,
				Requetes.DATABASE_PHOTO_TITREEN,
				Requetes.DATABASE_PHOTO_LIEN,
				Requetes.DATABASE_PHOTO_DATE,
				Requetes.DATABASE_PHOTO_DESCFR,
				Requetes.DATABASE_PHOTO_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_PHOTO, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_ID);
			int titreFR = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_TITREFR);
			int titreEN = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_TITREEN);
			int lien = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_LIEN);
			int date = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_DATE);
			int descFR = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_PHOTO_DESCEN);
			
			while( cursor.moveToNext() ){
				Photo a = new Photo();
				a.setId(this.cursor.getInt(id));
				a.setTitreFR(this.cursor.getString(titreFR));
				a.setTitreEN(this.cursor.getString(titreEN));
				a.setPhotoURL(this.cursor.getString(lien));
				a.setPhotoDate(Tools.parseStringToDate(this.cursor.getString(date)));
				a.setDescriptionFR(this.cursor.getString(descFR));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}

	public ArrayList<Rubrique> getRubriqueInternalFromDB(){
		ArrayList<Rubrique> ret = new ArrayList<Rubrique>();
		String[] result_columns = new String[]{
				Requetes.DATABASE_RUBRIQUE_ID,
				Requetes.DATABASE_RUBRIQUE_MERE,
				Requetes.DATABASE_RUBRIQUE_TITREFR,
				Requetes.DATABASE_RUBRIQUE_TITREEN,
				Requetes.DATABASE_RUBRIQUE_DESCFR,
				Requetes.DATABASE_RUBRIQUE_DESCEN
		};
		
		this.cursor = db.query(Requetes.DATABASE_PHOTO, result_columns, null, null, null, null, null);
		if( this.cursor != null && this.cursor.getCount()>0 ){
			int id = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_ID);
			int mere = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_MERE);
			int titreFR = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_TITREFR);
			int titreEN = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_TITREEN);
			int descFr = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_DESCFR);
			int descEN = cursor.getColumnIndex(Requetes.DATABASE_RUBRIQUE_DESCEN);
			
			while( cursor.moveToNext() ){
				Rubrique a = new Rubrique();
				a.setId(this.cursor.getInt(id));
				//a.setMere(this.cursor.getString(mere));
				a.setTitreFR(this.cursor.getString(titreFR));
				a.setTitreEN(this.cursor.getString(titreEN));
				a.setDescriptionFR(this.cursor.getString(descFr));
				a.setDescriptionEN(this.cursor.getString(descEN));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
}
