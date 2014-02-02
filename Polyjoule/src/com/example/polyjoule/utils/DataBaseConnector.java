package com.example.polyjoule.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DataBaseConnector {

	private static final String phpFileURL = "http://polyjoule.org/site/PRESENTATION/Android/androidQuerries.php";
	
	/**
	 * Recupere tout les articles de la BDD et les renvois sous forme de liste
	 * @return
	 */
	public static ArrayList<Article> getArticlesFromDB()
	{
		ArrayList<Article> ret = new ArrayList<Article>();
		try{ 
			String querry = "SELECT * FROM ARTICLE";
			
			JSONArray resultArray = executeQuerry(querry);
			for(int i=0;i<resultArray.length();i++){
					JSONObject json_data = resultArray.getJSONObject(i);
					Article tmpArticle = new Article();
					tmpArticle.setIdArticle(json_data.getInt("id_article"));
					tmpArticle.setIdRubrique(json_data.getInt("id_rubrique"));
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
					
//					System.out.println("titre : "+json_data.getString("titreFR_article")+"\n");
					ret.add(tmpArticle);
			}
			
		} catch (JSONException e) {
			Log.e("DataBaseConnector", "Error reading JSON Object "+e.toString());
			return null;
		}
		return ret;
	}
	
	
	
	
	/**
	 * Effectue la connexion HTTP au fichier php present sur le serveur.
	 * Initialise l'inputStream de la reponse (en JSON) a la requete envoyee en parametre
	 * @param querry
	 */
	private static JSONArray executeQuerry(String querry)
	{
		JSONArray ret = null;
		InputStream answerStream = null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("app_querry",querry));
		
		//http post
		try{
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost(phpFileURL);
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost);
		        HttpEntity entity = response.getEntity();
		        answerStream = entity.getContent();
		        
		        return convertStreamToString(answerStream);
		        
		}catch(Exception e){
		        Log.e("DataBaseConnector", "Error in http connection "+e.toString());
		}
		return ret;
	}
	
	/**
	 * Lit l'inputStream et convertit les elements de cette derniere en une String
	 */
	private static JSONArray convertStreamToString(InputStream stream){
		JSONArray ret = null;
		if( stream != null ){
			String result = "";
			//convert response to string
			try{
			        BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"),8);
			        StringBuilder sb = new StringBuilder();
			        String line = null;
			        while ((line = reader.readLine()) != null) {
			                sb.append(line + "\n");
			        }
			        stream.close();
			 
			        result=sb.toString();
			        
			        return parseResultToJSONArray(result);
			
			}catch(Exception e){
			        Log.e("DataBaseConnector", "Error converting result "+e.toString());
			}
		}
		return ret;
	}
	
	/**
	 * parse la String en parametre et cree un tableau d'objets JSON puis le retourne
	 * @param result
	 * @return 
	 */
	private static JSONArray parseResultToJSONArray(String result){
		//parse json data
		try{
		        return new JSONArray(result);
		}catch(JSONException e){
		        Log.e("DataBaseConnector", "Error parsing data "+e.toString());
		        return null;
		}
	}
	
}
