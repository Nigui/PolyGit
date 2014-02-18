package com.example.polyjoule.interneDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PolyjouleDBOpenHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME="polyjoule.db";
	private static final int DATABASE_VERSION=1;		
			
	public PolyjouleDBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	//Executee lors de la creation de la base de donnee, lorsqu'elle est inexistante sur le telephone
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Requetes.DATABASE_CREATE);
	}

	//Appelee si une version de la base ne correspond pas, ce qui signifie que la version de la base sur le disque doit etre mise a jour vers la version courante.
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Marque la mise a jour dans le log
		Log.w("TaskDBAdapter","Mise a jour de la version "+oldVersion+" vers la version "+newVersion+", ce qui detruira toutes les anciennes donnees");
	
		//Mise a jour de la base. Destruction puis Creation.
		db.execSQL(Requetes.DATABASE_DESTROY);
	}

	
}
