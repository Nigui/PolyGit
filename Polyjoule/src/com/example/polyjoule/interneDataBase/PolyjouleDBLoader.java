package com.example.polyjoule.interneDataBase;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.polyjoule.DBObjects.Article;
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
			loadDBArticles();
			/** tout charger **/
			
			
		}
		catch(LoadingErrorException err){
			Log.e("PolyjouleDBLoader", "erreur chargement Objets BDD interne", err);
			return false;
		}
		
		return true;
	}
	
	private void loadDBArticles() throws LoadingErrorException{
		
		//Recupere la liste des articles depuis la base sur internet
		ArrayList<Article> listeArticle = DataBaseGetters.getArticlesFromDB();
		
		//Importe chaques lignes dans la base interne
		for(Article artcl : listeArticle ){
			
			ContentValues newValue = new ContentValues();
			newValue.put(Requetes.DATABASE_ARTICLE_ID,artcl.getIdArticle());
			newValue.put(Requetes.DATABASE_ARTICLE_RUBRIQUE, artcl.getRubrique().getId());
			newValue.put(Requetes.DATABASE_ARTICLE_AUTEUR,artcl.getAuteur());
			newValue.put(Requetes.DATABASE_ARTICLE_TITREFR, artcl.getTitreFr());
			newValue.put(Requetes.DATABASE_ARTICLE_TITREEN,artcl.getTitreEn());
			newValue.put(Requetes.DATABASE_ARTICLE_CONTENUFR, artcl.getContenuFr());
			newValue.put(Requetes.DATABASE_ARTICLE_CONTENUEN,artcl.getContenuEng());
			newValue.put(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM, Tools.parseBooleanToInt(artcl.isCommentaireAutorise()));
			newValue.put(Requetes.DATABASE_ARTICLE_STATUT,Tools.parseBooleanToInt(artcl.isStatutArticle()));
			newValue.put(Requetes.DATABASE_ARTICLE_DATE, Tools.parseDateToString(artcl.getDateCreation()));
			newValue.put(Requetes.DATABASE_ARTICLE_PHOTO,artcl.getUrlPhotoPrincipale());
			newValue.put(Requetes.DATABASE_ARTICLE_VISIBLE,Tools.parseBooleanToInt(artcl.isVisibleHome()));

			if( db.insert(Requetes.DATABASE_ARTICLE, null, newValue) == -1) throw new LoadingErrorException("chargement article");
		}
		
	}
	
}
