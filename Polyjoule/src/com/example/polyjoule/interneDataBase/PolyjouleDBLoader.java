package com.example.polyjoule.interneDataBase;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
import com.example.polyjoule.DBObjects.Photo;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.Exceptions.LoadingErrorException;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.utils.Tools;

public class PolyjouleDBLoader {

	private PolyjouleDBOpenHelper oh; 
	private SQLiteDatabase db;
	
	public PolyjouleDBLoader(PolyjouleDBOpenHelper helper){
		this.oh = helper;
		this.db = this.oh.getWritableDatabase();
	}
	
	/**
	 * Charge toute la base de donnee
	 * @return
	 */
	public boolean loadDB(){
		
		try{
			loadDBArticles(-1);
			loadDBAlbums();
			loadDBCommentaires();
			loadDBCourses();
			loadDBEcole();
			loadDBEquipe();
			loadDBFormation();
			loadDBLivreOr();
			loadDBPartenaire();
			loadDBParticipant();
			loadDBParticipation();
			loadDBPhoto();
			loadDBRubrique();
			
			
		}
		catch(LoadingErrorException err){
			Log.e("PolyjouleDBLoader", "erreur chargement Objets BDD interne", err);
			return false;
		}
		
		return true;
	}
	
	private void loadDBAlbums() throws LoadingErrorException{
		ArrayList<Album> listeAlbum = DataBaseGetters.getAlbumsFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Album album : listeAlbum ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_ALBUM_ID,album.getId());
			newValue.put(Requetes.DATABASE_ALBUM_NOM,album.getNom());
			newValue.put(Requetes.DATABASE_ALBUM_DATE, Tools.parseCalendarToString(album.getDate()));
			newValue.put(Requetes.DATABASE_ALBUM_DESCFR,album.getDescriptionFR());
			newValue.put(Requetes.DATABASE_ALBUM_DESCEN, album.getDescriptionEN());

			if( db.insert(Requetes.DATABASE_ALBUM, null, newValue) == -1) throw new LoadingErrorException("erreur chargement album");
		}
	}
	
	private void loadDBArticles(int nb) throws LoadingErrorException{
		
		//Recupere la liste des articles depuis la base sur internet
		ArrayList<Article> listeArticle = DataBaseGetters.getArticlesFromDB(nb);
		
		//Importe chaques lignes dans la base interne
		for(Article artcl : listeArticle ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_ARTICLE_ID,artcl.getIdArticle());
			//newValue.put(Requetes.DATABASE_ARTICLE_RUBRIQUE, artcl.getRubrique().getId());
			newValue.put(Requetes.DATABASE_ARTICLE_AUTEUR,artcl.getAuteur());
			newValue.put(Requetes.DATABASE_ARTICLE_TITREFR, artcl.getTitreFr());
			newValue.put(Requetes.DATABASE_ARTICLE_TITREEN,artcl.getTitreEn());
			newValue.put(Requetes.DATABASE_ARTICLE_CONTENUFR, artcl.getContenuFr());
			newValue.put(Requetes.DATABASE_ARTICLE_CONTENUEN,artcl.getContenuEng());
			newValue.put(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM, Tools.parseBooleanToInt(artcl.isCommentaireAutorise()));
			newValue.put(Requetes.DATABASE_ARTICLE_STATUT,Tools.parseBooleanToInt(artcl.isStatutArticle()));
			newValue.put(Requetes.DATABASE_ARTICLE_DATE, Tools.parseCalendarToString(artcl.getDateCreation()));
			newValue.put(Requetes.DATABASE_ARTICLE_PHOTO,artcl.getUrlPhotoPrincipale());

			if( db.insert(Requetes.DATABASE_ARTICLE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement article");
		}
		
	}
	
	private void loadDBCommentaires() throws LoadingErrorException{
		ArrayList<Commentaire> listeCommentaire = DataBaseGetters.getCommentairesFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Commentaire comm : listeCommentaire ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_COMMENTAIRE_ID,comm.getId());
			newValue.put(Requetes.DATABASE_COMMENTAIRE_ARTICLE,comm.getArticle().getIdArticle());
			newValue.put(Requetes.DATABASE_COMMENTAIRE_DATE, Tools.parseCalendarToString(comm.getDate()));
			newValue.put(Requetes.DATABASE_COMMENTAIRE_POSTEUR,comm.getAuteur());
			newValue.put(Requetes.DATABASE_COMMENTAIRE_MAIL, comm.getMail());
			newValue.put(Requetes.DATABASE_COMMENTAIRE_MESSAGE, comm.getMessage());

			if( db.insert(Requetes.DATABASE_COMMENTAIRE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement commentaire");
		}
	}

	private void loadDBCourses() throws LoadingErrorException{
		ArrayList<Course> listeCourse = DataBaseGetters.getCoursesFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Course course : listeCourse ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_COURSE_ID,course.getId());
			newValue.put(Requetes.DATABASE_COURSE_EQUIPE,course.getEquipe().getId());
			newValue.put(Requetes.DATABASE_COURSE_DATE, Tools.parseCalendarToString(course.getDate()));
			newValue.put(Requetes.DATABASE_COURSE_LIEU,course.getLieu());
			newValue.put(Requetes.DATABASE_COURSE_IMG, course.getImageURL());
			newValue.put(Requetes.DATABASE_COURSE_DESCFR, course.getDescriptionFR());
			newValue.put(Requetes.DATABASE_COURSE_DESCEN, course.getDescriptionEN());

			if( db.insert(Requetes.DATABASE_COURSE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement course");
		}
	}

	private void loadDBEcole() throws LoadingErrorException{
		ArrayList<Ecole> listeEcole = DataBaseGetters.getEcoleFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Ecole ecole : listeEcole ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_ECOLE_ID,ecole.getId());
			newValue.put(Requetes.DATABASE_ECOLE_NOM,ecole.getNom());
			newValue.put(Requetes.DATABASE_ECOLE_ADRESSE, ecole.getAdresse());
			newValue.put(Requetes.DATABASE_ECOLE_PHOTO,ecole.getPhotoURL());
			newValue.put(Requetes.DATABASE_ECOLE_DESCFR, ecole.getDescriptionFR());
			newValue.put(Requetes.DATABASE_ECOLE_DESCEN, ecole.getDescriptionEN());


			if( db.insert(Requetes.DATABASE_ECOLE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement ecole");
		}
	}

	private void loadDBEquipe() throws LoadingErrorException{
		ArrayList<Equipe> listeEquipe = DataBaseGetters.getEquipeFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Equipe eq : listeEquipe ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_EQUIPE_ID,eq.getId());
			newValue.put(Requetes.DATABASE_EQUIPE_ANNEE,eq.getAnnee());


			if( db.insert(Requetes.DATABASE_EQUIPE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement equipe");
		}
	}

	private void loadDBFormation() throws LoadingErrorException{
		ArrayList<Formation> listeFormation = DataBaseGetters.getFormationFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Formation form : listeFormation ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_FORMATION_ID,form.getId());
			newValue.put(Requetes.DATABASE_FORMATION_ECOLE,form.getEcole().getId());
			newValue.put(Requetes.DATABASE_FORMATION_TITREFR,form.getTitreFR());
			newValue.put(Requetes.DATABASE_FORMATION_TITREEN,form.getTitreEN());
			newValue.put(Requetes.DATABASE_FORMATION_LIEN,form.getLienWeb());
			newValue.put(Requetes.DATABASE_FORMATION_DESCFR,form.getDescriptionFR());
			newValue.put(Requetes.DATABASE_FORMATION_DESCEN,form.getDescriptionEN());


			if( db.insert(Requetes.DATABASE_FORMATION, null, newValue) == -1) throw new LoadingErrorException("erreur chargement formation");
		}
	}

	private void loadDBLivreOr() throws LoadingErrorException{
		ArrayList<LivreOr> listeLivreOr = DataBaseGetters.getLivreOrFromDB();
		
		//Importe chaques lignes dans la base interne
		for(LivreOr livre : listeLivreOr ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_LIVREOR_ID,livre.getId());
			newValue.put(Requetes.DATABASE_LIVREOR_POSTEUR,livre.getAuteur());
			newValue.put(Requetes.DATABASE_LIVREOR_MAIL,livre.getMail());
			newValue.put(Requetes.DATABASE_LIVREOR_DATE,Tools.parseCalendarToString(livre.getDate()));
			newValue.put(Requetes.DATABASE_LIVREOR_MESSAGE,livre.getMessage());
			newValue.put(Requetes.DATABASE_LIVREOR_ACCEPTED,livre.isAccepted());


			if( db.insert(Requetes.DATABASE_LIVREOR, null, newValue) == -1) throw new LoadingErrorException("erreur chargement livreOr");
		}
	}
	
	private void loadDBPartenaire() throws LoadingErrorException{
		ArrayList<Partenaire> listePartenaire = DataBaseGetters.getPartenairesFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Partenaire part : listePartenaire ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_PARTENAIRE_ID,part.getId());
			newValue.put(Requetes.DATABASE_PARTENAIRE_NOM,part.getNom());
			newValue.put(Requetes.DATABASE_PARTENAIRE_LOGO,part.getLogoURL());
			newValue.put(Requetes.DATABASE_PARTENAIRE_SITE,part.getWebsiteURL());
			newValue.put(Requetes.DATABASE_PARTENAIRE_DESCFR,part.getDescriptionFR());
			newValue.put(Requetes.DATABASE_PARTENAIRE_DESCEN,part.getDescriptionEN());


			if( db.insert(Requetes.DATABASE_PARTENAIRE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement partenaire");
		}
	}

	private void loadDBParticipant() throws LoadingErrorException{
		ArrayList<Participant> listeParticipant = DataBaseGetters.getParticipantsFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Participant part : listeParticipant ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_PARTICIPANT_ID,part.getId());
			newValue.put(Requetes.DATABASE_PARTICIPANT_NOM,part.getNom());
			newValue.put(Requetes.DATABASE_PARTICIPANT_PRENOM,part.getPrenom());
			newValue.put(Requetes.DATABASE_PARTICIPANT_PHOTO,part.getPhotoURL());
			newValue.put(Requetes.DATABASE_PARTICIPANT_MAIL,part.getEmail());
			newValue.put(Requetes.DATABASE_PARTICIPANT_BIOFR,part.getBioFR());
			newValue.put(Requetes.DATABASE_PARTICIPANT_BIOEN,part.getBioEN());
			newValue.put(Requetes.DATABASE_PARTICIPANT_ISPROF,part.isProf());


			if( db.insert(Requetes.DATABASE_PARTICIPANT, null, newValue) == -1) throw new LoadingErrorException("erreur chargement participant");
		}
	}
	
	private void loadDBParticipation() throws LoadingErrorException{
		/*Get participation */
	}
	
	private void loadDBPhoto() throws LoadingErrorException{
		ArrayList<Photo> listePhoto = DataBaseGetters.getPhotosFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Photo photo : listePhoto ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_PHOTO_ID,photo.getId());
			newValue.put(Requetes.DATABASE_PHOTO_TITREFR,photo.getTitreFR());
			newValue.put(Requetes.DATABASE_PHOTO_TITREEN,photo.getTitreEN());
			newValue.put(Requetes.DATABASE_PHOTO_LIEN,photo.getPhotoURL());
			newValue.put(Requetes.DATABASE_PHOTO_DATE,Tools.parseCalendarToString(photo.getPhotoDate()));
			newValue.put(Requetes.DATABASE_PHOTO_DESCFR,photo.getDescriptionFR());
			newValue.put(Requetes.DATABASE_PHOTO_DESCEN,photo.getDescriptionEN());


			if( db.insert(Requetes.DATABASE_PHOTO, null, newValue) == -1) throw new LoadingErrorException("erreur chargement photo");
		}
	}

	private void loadDBRubrique() throws LoadingErrorException{
		ArrayList<Rubrique> listeRubrique = DataBaseGetters.getRubriqueFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Rubrique rub : listeRubrique ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_RUBRIQUE_ID,rub.getId());
			newValue.put(Requetes.DATABASE_RUBRIQUE_MERE,rub.getMere().getId());
			newValue.put(Requetes.DATABASE_RUBRIQUE_TITREFR,rub.getTitreFR());
			newValue.put(Requetes.DATABASE_RUBRIQUE_TITREEN,rub.getTitreEN());
			newValue.put(Requetes.DATABASE_RUBRIQUE_DESCFR,rub.getDescriptionFR());
			newValue.put(Requetes.DATABASE_RUBRIQUE_DESCEN,rub.getDescriptionEN());


			if( db.insert(Requetes.DATABASE_RUBRIQUE, null, newValue) == -1) throw new LoadingErrorException("erreur chargement rubrique");
		}
	}
}
