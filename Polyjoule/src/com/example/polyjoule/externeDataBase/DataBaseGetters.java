package com.example.polyjoule.externeDataBase;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
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
import com.example.polyjoule.DBObjects.Participation;
import com.example.polyjoule.DBObjects.Photo;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.utils.Tools;

public class DataBaseGetters {
	
	Context context;
	
	 public DataBaseGetters(Context context) {
		super();
		this.context = context;
	}

	/* Recupere tout les articles de la BDD et les renvois sous forme de liste*/
	public ArrayList<Album> getAlbumsFromDB()
	{
		ArrayList<Album> ret = new ArrayList<Album>();
		String querry = "SELECT * FROM ALBUM";
		try{ 
			JSONArray resultArray;
			try {
				resultArray = new DataBaseConnector(context).execute(querry).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			} catch (ExecutionException e) {
				e.printStackTrace();
				return null;
			}
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Album tmpAlbum = new Album();
					
					tmpAlbum.setId(json_data.getInt(Requetes.DATABASE_ALBUM_ID));
					tmpAlbum.setNom(json_data.getString(Requetes.DATABASE_ALBUM_NOM));
					tmpAlbum.setDate(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_ALBUM_DATE)));
					tmpAlbum.setDescriptionFR(json_data.getString(Requetes.DATABASE_ALBUM_DESCFR));
					tmpAlbum.setDescriptionEN(json_data.getString(Requetes.DATABASE_ALBUM_DESCEN));
					
					ret.add(tmpAlbum);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		}
		return ret;
	}

	/**
	 * Recupere tout les articles de la BDD et les renvois sous forme de liste
	 * nb, nombre d'objet à récupérer, -1 == all
	 * @return
	 */
	public ArrayList<Article> getArticlesFromDB(int nb)
	{
		ArrayList<Article> ret = new ArrayList<Article>();
		String querry = "SELECT * FROM ARTICLE "
				+ "WHERE "+Requetes.DATABASE_ARTICLE_RUBRIQUE+" IN (7,8,9) "
				+ "ORDER BY "+Requetes.DATABASE_ARTICLE_DATE+" DESC ";
		String nbObjects = "LIMIT ";
		if( nb == -1 ) nbObjects = "";
		else nbObjects += String.valueOf(nb);
		
		querry += nbObjects;
		
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Article tmpArticle = new Article();
					tmpArticle.setIdArticle(json_data.getInt(Requetes.DATABASE_ARTICLE_ID));
					//TODO Récupérer toutes les rubriques avant de l'affecter 
					tmpArticle.setAuteur(json_data.getString(Requetes.DATABASE_ARTICLE_AUTEUR));
					tmpArticle.setTitreFr(json_data.getString(Requetes.DATABASE_ARTICLE_TITREFR));
					tmpArticle.setTitreEn(json_data.getString(Requetes.DATABASE_ARTICLE_TITREEN));
					tmpArticle.setContenuFr(json_data.getString(Requetes.DATABASE_ARTICLE_CONTENUFR));
					tmpArticle.setContenuEng(json_data.getString(Requetes.DATABASE_ARTICLE_CONTENUEN));
					tmpArticle.setCommentaireAutorise(json_data.getBoolean(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM));
					tmpArticle.setStatutArticle(json_data.getBoolean(Requetes.DATABASE_ARTICLE_STATUT));
					tmpArticle.setDateCreation(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_ARTICLE_DATE)));
					tmpArticle.setUrlPhotoPrincipale(json_data.getString(Requetes.DATABASE_ARTICLE_PHOTO));
					
					ret.add(tmpArticle);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Article> getArticlesFromDBWithID(int nb, int id)
	{
		ArrayList<Article> ret = new ArrayList<Article>();
		String querry = "SELECT * FROM ARTICLE WHERE id_article ="+id ;
		
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Article tmpArticle = new Article();
					tmpArticle.setIdArticle(json_data.getInt(Requetes.DATABASE_ARTICLE_ID));
					//TODO Récupérer toutes les rubriques avant de l'affecter 
					tmpArticle.setAuteur(json_data.getString(Requetes.DATABASE_ARTICLE_AUTEUR));
					tmpArticle.setTitreFr(json_data.getString(Requetes.DATABASE_ARTICLE_TITREFR));
					tmpArticle.setTitreEn(json_data.getString(Requetes.DATABASE_ARTICLE_TITREEN));
					tmpArticle.setContenuFr(json_data.getString(Requetes.DATABASE_ARTICLE_CONTENUFR));
					tmpArticle.setContenuEng(json_data.getString(Requetes.DATABASE_ARTICLE_CONTENUEN));
					tmpArticle.setCommentaireAutorise(json_data.getBoolean(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM));
					tmpArticle.setStatutArticle(json_data.getBoolean(Requetes.DATABASE_ARTICLE_STATUT));
					tmpArticle.setDateCreation(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_ARTICLE_DATE)));
					tmpArticle.setUrlPhotoPrincipale(json_data.getString(Requetes.DATABASE_ARTICLE_PHOTO));
					
					ret.add(tmpArticle);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Commentaire> getCommentairesFromDB()
	{
		ArrayList<Commentaire> ret = new ArrayList<Commentaire>();
		String querry = "SELECT * FROM COMMENTAIRE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Commentaire tmpCommentaire = new Commentaire();
					tmpCommentaire.setId(json_data.getInt(Requetes.DATABASE_COMMENTAIRE_ID));
					//tmpCommentaire.set(json_data.getString(Requetes.DATABASE_COMMENTAIRE_ARTICLE));
					tmpCommentaire.setDate(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_COMMENTAIRE_DATE)));
					tmpCommentaire.setAuteur(json_data.getString(Requetes.DATABASE_COMMENTAIRE_POSTEUR));
					tmpCommentaire.setMail(json_data.getString(Requetes.DATABASE_COMMENTAIRE_MAIL));
					tmpCommentaire.setMessage(json_data.getString(Requetes.DATABASE_COMMENTAIRE_MESSAGE));
					
					ret.add(tmpCommentaire);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Course> getCoursesFromDB()
	{
		ArrayList<Course> ret = new ArrayList<Course>();
		String querry = "SELECT * FROM COURSE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Course tmpCourse = new Course();
					tmpCourse.setId(json_data.getInt(Requetes.DATABASE_COURSE_ID));
					//tmpCommentaire.set(json_data.getString(Requetes.DATABASE_COURSE_EQUIPE));
					tmpCourse.setDate(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_COURSE_DATE)));
					tmpCourse.setLieu(json_data.getString(Requetes.DATABASE_COURSE_LIEU));
					tmpCourse.setImageURL(json_data.getString(Requetes.DATABASE_COURSE_IMG));
					tmpCourse.setDescriptionFR(json_data.getString(Requetes.DATABASE_COURSE_DESCFR));
					tmpCourse.setDescriptionEN(json_data.getString(Requetes.DATABASE_COURSE_DESCEN));
					
					ret.add(tmpCourse);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Ecole> getEcoleFromDB()
	{
		ArrayList<Ecole> ret = new ArrayList<Ecole>();
		String querry = "SELECT * FROM ECOLE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Ecole tmpEcole = new Ecole();
					tmpEcole.setId(json_data.getInt(Requetes.DATABASE_ECOLE_ID));
					tmpEcole.setNom(json_data.getString(Requetes.DATABASE_ECOLE_NOM));
					tmpEcole.setAdresse(json_data.getString(Requetes.DATABASE_ECOLE_ADRESSE));
					tmpEcole.setPhotoURL(json_data.getString(Requetes.DATABASE_ECOLE_PHOTO));
					tmpEcole.setDescriptionFR(json_data.getString(Requetes.DATABASE_COURSE_DESCFR));
					tmpEcole.setDescriptionEN(json_data.getString(Requetes.DATABASE_COURSE_DESCEN));
					
					ret.add(tmpEcole);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Equipe> getEquipeFromDB()
	{
		ArrayList<Equipe> ret = new ArrayList<Equipe>();
		String querry = "SELECT * FROM EQUIPE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Equipe tmpEquipe = new Equipe();
					tmpEquipe.setId(json_data.getInt(Requetes.DATABASE_EQUIPE_ID));
					tmpEquipe.setAnnee(json_data.getInt(Requetes.DATABASE_EQUIPE_ANNEE));
					ret.add(tmpEquipe);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Formation> getFormationFromDB()
	{
		ArrayList<Formation> ret = new ArrayList<Formation>();
		String querry = "SELECT * FROM FORMATION";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Formation tmpFormation = new Formation();
					tmpFormation.setId(json_data.getInt(Requetes.DATABASE_FORMATION_ID));
					//tmpFormation.set(json_data.getString(Requetes.DATABASE_FORMATION_ECOLE));
					tmpFormation.setTitreFR(json_data.getString(Requetes.DATABASE_FORMATION_TITREFR));
					tmpFormation.setTitreEN(json_data.getString(Requetes.DATABASE_FORMATION_TITREEN));
					tmpFormation.setLienWeb(json_data.getString(Requetes.DATABASE_FORMATION_LIEN));
					tmpFormation.setDescriptionFR(json_data.getString(Requetes.DATABASE_FORMATION_DESCFR));
					tmpFormation.setDescriptionEN(json_data.getString(Requetes.DATABASE_FORMATION_DESCEN));
					
					ret.add(tmpFormation);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<LivreOr> getLivreOrFromDB()
	{
		ArrayList<LivreOr> ret = new ArrayList<LivreOr>();
		String querry = "SELECT * FROM LIVRE_OR WHERE accept_post = 1";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					LivreOr tmpLivreOr = new LivreOr();
					tmpLivreOr.setId(json_data.getInt(Requetes.DATABASE_LIVREOR_ID));
					tmpLivreOr.setAuteur(json_data.getString(Requetes.DATABASE_LIVREOR_POSTEUR));
					tmpLivreOr.setMail(json_data.getString(Requetes.DATABASE_LIVREOR_MAIL));
					tmpLivreOr.setDate(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_LIVREOR_DATE)));
					tmpLivreOr.setMessage(json_data.getString(Requetes.DATABASE_LIVREOR_MESSAGE));
					tmpLivreOr.setAccepted(Tools.parseIntToBoolean(json_data.getInt(Requetes.DATABASE_LIVREOR_ACCEPTED)));
					
					ret.add(tmpLivreOr);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Recupere tout les partenaires de la BDD et les renvois sous forme de liste
	 * @return
	 */
	public ArrayList<Partenaire> getPartenairesFromDB()
	{
		ArrayList<Partenaire> ret = new ArrayList<Partenaire>();
		String querry = "SELECT * FROM PARTENAIRE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Partenaire tmpPartenaire = new Partenaire();
				tmpPartenaire.setId(json_data.getInt(Requetes.DATABASE_PARTENAIRE_ID));
				tmpPartenaire.setNom(json_data.getString(Requetes.DATABASE_PARTENAIRE_NOM));
				tmpPartenaire.setLogoURL(json_data.getString(Requetes.DATABASE_PARTENAIRE_LOGO));
				tmpPartenaire.setWebsiteURL(json_data.getString(Requetes.DATABASE_PARTENAIRE_SITE));
				tmpPartenaire.setDescriptionFR(json_data.getString(Requetes.DATABASE_PARTENAIRE_DESCFR));
				tmpPartenaire.setDescriptionEN(json_data.getString(Requetes.DATABASE_PARTENAIRE_DESCEN));
				
				ret.add(tmpPartenaire);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Participant> getParticipantsFromDB()
	{
		ArrayList<Participant> ret = new ArrayList<Participant>();
		String querry = "SELECT * FROM PARTICIPANT";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Participant tmpParticipant = new Participant();
				tmpParticipant.setId(json_data.getInt(Requetes.DATABASE_PARTICIPANT_ID));
				tmpParticipant.setNom(json_data.getString(Requetes.DATABASE_PARTICIPANT_NOM));
				tmpParticipant.setPrenom(json_data.getString(Requetes.DATABASE_PARTICIPANT_PRENOM));
				tmpParticipant.setPhotoURL(json_data.getString(Requetes.DATABASE_PARTICIPANT_PHOTO));
				tmpParticipant.setEmail(json_data.getString(Requetes.DATABASE_PARTICIPANT_MAIL));
				tmpParticipant.setBioFR(json_data.getString(Requetes.DATABASE_PARTICIPANT_BIOFR));
				tmpParticipant.setBioEN(json_data.getString(Requetes.DATABASE_PARTICIPANT_BIOEN));
				tmpParticipant.setProf(Tools.parseIntToBoolean(json_data.getInt(Requetes.DATABASE_PARTICIPANT_ISPROF)));
				
				ret.add(tmpParticipant);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Participant> getParticipantsFromDBWithID(int id)
	{
		ArrayList<Participant> ret = new ArrayList<Participant>();
		String querry = "SELECT * FROM PARTICIPANT WHERE id_participant = "+id;
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Participant tmpParticipant = new Participant();
				tmpParticipant.setId(json_data.getInt(Requetes.DATABASE_PARTICIPANT_ID));
				tmpParticipant.setNom(json_data.getString(Requetes.DATABASE_PARTICIPANT_NOM));
				tmpParticipant.setPrenom(json_data.getString(Requetes.DATABASE_PARTICIPANT_PRENOM));
				tmpParticipant.setPhotoURL(json_data.getString(Requetes.DATABASE_PARTICIPANT_PHOTO));
				tmpParticipant.setEmail(json_data.getString(Requetes.DATABASE_PARTICIPANT_MAIL));
				tmpParticipant.setBioFR(json_data.getString(Requetes.DATABASE_PARTICIPANT_BIOFR));
				tmpParticipant.setBioEN(json_data.getString(Requetes.DATABASE_PARTICIPANT_BIOEN));
				tmpParticipant.setProf(Tools.parseIntToBoolean(json_data.getInt(Requetes.DATABASE_PARTICIPANT_ISPROF)));
				
				ret.add(tmpParticipant);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Participation> getParticipationFromDB()
	{
		ArrayList<Participation> ret = new ArrayList<Participation>();
		String querry = "SELECT * FROM PARTICIPATION";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Participation tmpParticipation = new Participation();
					//tmpParticipation.setId(json_data.getInt(Requetes.DATABASE_PARTICIPATION_EQUIPE));
					//tmpParticipation.setAnnee(json_data.getInt(Requetes.DATABASE_PARTICIPATION_PARTICIPANT));
					tmpParticipation.setRole(json_data.getString(Requetes.DATABASE_PARTICIPATION_ROLE));
					ret.add(tmpParticipation);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Participation> getParticipationFromDBWithID(int id)
	{
		ArrayList<Participation> ret = new ArrayList<Participation>();
		String querry = "SELECT * FROM PARTICIPATION WHERE id_participant = "+id;
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Participation tmpParticipation = new Participation();
					//tmpParticipation.setId(json_data.getInt(Requetes.DATABASE_PARTICIPATION_EQUIPE));
					//tmpParticipation.setAnnee(json_data.getInt(Requetes.DATABASE_PARTICIPATION_PARTICIPANT));
					tmpParticipation.setRole(json_data.getString(Requetes.DATABASE_PARTICIPATION_ROLE));
					ret.add(tmpParticipation);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Photo> getPhotosFromDB()
	{
		ArrayList<Photo> ret = new ArrayList<Photo>();
		String querry = "SELECT * FROM PHOTO";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Photo tmpPhoto = new Photo();
				tmpPhoto.setId(json_data.getInt(Requetes.DATABASE_PHOTO_ID));
				tmpPhoto.setTitreFR(json_data.getString(Requetes.DATABASE_PHOTO_TITREFR));
				tmpPhoto.setTitreEN(json_data.getString(Requetes.DATABASE_PHOTO_TITREEN));
				tmpPhoto.setPhotoURL(json_data.getString(Requetes.DATABASE_PHOTO_LIEN));
				tmpPhoto.setPhotoDate(Tools.parseStringToCalendar(json_data.getString(Requetes.DATABASE_PHOTO_DATE)));
				tmpPhoto.setDescriptionFR(json_data.getString(Requetes.DATABASE_PHOTO_DESCFR));
				tmpPhoto.setDescriptionEN(json_data.getString(Requetes.DATABASE_PHOTO_DESCEN));
				
				ret.add(tmpPhoto);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Rubrique> getRubriqueFromDB()
	{
		ArrayList<Rubrique> ret = new ArrayList<Rubrique>();
		String querry = "SELECT * FROM RUBRIQUE";
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Rubrique tmpRubrique = new Rubrique();
				tmpRubrique.setId(json_data.getInt(Requetes.DATABASE_RUBRIQUE_ID));
				//tmpRubrique.setMere(json_data.getInt(Requetes.DATABASE_RUBRIQUE_MERE));
				tmpRubrique.setTitreFR(json_data.getString(Requetes.DATABASE_RUBRIQUE_TITREFR));
				tmpRubrique.setTitreEN(json_data.getString(Requetes.DATABASE_RUBRIQUE_TITREEN));
				tmpRubrique.setDescriptionFR(json_data.getString(Requetes.DATABASE_RUBRIQUE_DESCFR));
				tmpRubrique.setDescriptionEN(json_data.getString(Requetes.DATABASE_RUBRIQUE_DESCEN));
				
				ret.add(tmpRubrique);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Rubrique> getRubriqueFromDBWhithID(int id)
	{
		ArrayList<Rubrique> ret = new ArrayList<Rubrique>();
		String querry = "SELECT * FROM RUBRIQUE WHERE id_rubrique ="+id;
		try{ 
			JSONArray resultArray = new DataBaseConnector(context).execute(querry).get();
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Rubrique tmpRubrique = new Rubrique();
				tmpRubrique.setId(json_data.getInt(Requetes.DATABASE_RUBRIQUE_ID));
				//tmpRubrique.setMere(json_data.getInt(Requetes.DATABASE_RUBRIQUE_MERE));
				tmpRubrique.setTitreFR(json_data.getString(Requetes.DATABASE_RUBRIQUE_TITREFR));
				tmpRubrique.setTitreEN(json_data.getString(Requetes.DATABASE_RUBRIQUE_TITREEN));
				tmpRubrique.setDescriptionFR(json_data.getString(Requetes.DATABASE_RUBRIQUE_DESCFR));
				tmpRubrique.setDescriptionEN(json_data.getString(Requetes.DATABASE_RUBRIQUE_DESCEN));
				
				ret.add(tmpRubrique);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
