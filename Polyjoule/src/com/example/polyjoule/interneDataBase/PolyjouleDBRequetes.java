package com.example.polyjoule.interneDataBase;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.polyjoule.DBObjects.Article;
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
	
	public ArrayList<Article> getArticleInternalFromDB(){
		ArrayList<Article> ret = new ArrayList<Article>();
		this.result.add(Requetes.DATABASE_ARTICLE_ID);
		this.result.add(Requetes.DATABASE_ARTICLE_RUBRIQUE);
		this.result.add(Requetes.DATABASE_ARTICLE_AUTEUR);
		this.result.add(Requetes.DATABASE_ARTICLE_TITREFR);
		this.result.add(Requetes.DATABASE_ARTICLE_TITREEN);
		this.result.add(Requetes.DATABASE_ARTICLE_CONTENUFR);
		this.result.add(Requetes.DATABASE_ARTICLE_CONTENUEN);
		this.result.add(Requetes.DATABASE_ARTICLE_AUTORISATIONCOM);
		this.result.add(Requetes.DATABASE_ARTICLE_STATUT);
		this.result.add(Requetes.DATABASE_ARTICLE_DATE);
		this.result.add(Requetes.DATABASE_ARTICLE_PHOTO);
		this.result.add(Requetes.DATABASE_ARTICLE_VISIBLE);
		
		this.cursor = db.query(Requetes.DATABASE_ARTICLE, (String[]) this.result.toArray(), null, null, null, null, null);
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
			int visible = cursor.getColumnIndex(Requetes.DATABASE_ARTICLE_VISIBLE);
			
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
				a.setVisibleHome(Tools.parseIntToBoolean(this.cursor.getInt(visible)));
				
				ret.add(a);
			}
			cursor.close();
		}
		return ret;
	}
	
	
	
	
	
	
	
	
}
