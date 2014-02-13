package com.example.polyjoule.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.DBObjects.Partenaire;

public class DataBaseGetters {

	/**
	 * Recupere tout les articles de la BDD et les renvois sous forme de liste
	 * @return
	 */
	public static ArrayList<Article> getArticlesFromDB()
	{
		ArrayList<Article> ret = new ArrayList<Article>();
		String querry = "SELECT * FROM ARTICLE";
		try{ 
			JSONArray resultArray = DataBaseConnector.executeQuerry(querry);
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Article tmpArticle = new Article();
					tmpArticle.setIdArticle(json_data.getInt("id_article"));
					tmpArticle.setAuteur(json_data.getString("auteur_article"));
					tmpArticle.setTitreFr(json_data.getString("titreFR_article"));
					tmpArticle.setTitreEn(json_data.getString("titreEN_article"));
					tmpArticle.setContenuFr(json_data.getString("contenuFR_article"));
					tmpArticle.setContenuEng(json_data.getString("contenuEN_article"));
					tmpArticle.setCommentaireAutorise(json_data.getBoolean("autorisation_com"));
					tmpArticle.setStatutArticle(json_data.getBoolean("statut_article"));
					tmpArticle.setDateCreation(Tools.parseStringToDate(json_data.getString("date_article")));
					tmpArticle.setUrlPhotoPrincipale(json_data.getString("url_photo_principale"));
					tmpArticle.setVisibleHome(json_data.getBoolean("visible_home"));
					tmpArticle.setMainArticle(json_data.getBoolean("main_article"));
					
					ret.add(tmpArticle);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		}
		return ret;
	}

	/**
	 * Recupere tout les partenaires de la BDD et les renvois sous forme de liste
	 * @return
	 */
	public static ArrayList<Partenaire> getPartenairesFromDB()
	{
		ArrayList<Partenaire> ret = new ArrayList<Partenaire>();
		String querry = "SELECT * FROM PARTENAIRE";
		try{ 
			JSONArray resultArray = DataBaseConnector.executeQuerry(querry);
			for(int i=0;i<resultArray.length();i++){
				JSONObject json_data = resultArray.getJSONObject(i);
				Partenaire tmpPartenaire = new Partenaire();
				tmpPartenaire.setId(json_data.getInt("id_partenaire"));
				tmpPartenaire.setNom(json_data.getString("nom_partenaire"));
				tmpPartenaire.setLogoURL(json_data.getString("logo_partenaire"));
				tmpPartenaire.setWebsiteURL(json_data.getString("site_partenaire"));
				tmpPartenaire.setDescriptionFR(json_data.getString("descFR_partenaire"));
				tmpPartenaire.setDescriptionEN(json_data.getString("descEN_partenaire"));
				
				ret.add(tmpPartenaire);
			}
		} catch (JSONException e) {
			Log.e("DataBaseGetters", "Error reading JSON Object "+e.toString());
		}
		return ret;
	}
}
