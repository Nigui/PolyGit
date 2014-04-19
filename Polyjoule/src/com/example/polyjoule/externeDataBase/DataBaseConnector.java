package com.example.polyjoule.externeDataBase;

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

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class DataBaseConnector extends AsyncTask<String, String, JSONArray> {

	ProgressDialog pd;
	Context context;

	public DataBaseConnector(Context c) {
		super();
		this.context = c;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Log.v("DBConnector", "onPreExecute");
		pd = new ProgressDialog(context);
		pd.setTitle("Processing...");
		pd.setMessage("Please wait.");
		pd.setCancelable(false);
		pd.setIndeterminate(true);
		pd.show();
		
		
	}


	@Override
	protected void onPostExecute(JSONArray result) {
		super.onPostExecute(result);
		Log.v("DBConnector", "onPostExecute");
		if (pd!=null) {
			pd.dismiss();
		}
	}

	private static final String phpFileURL = "http://polyjoule.org/site/PRESENTATION/Android/androidQuerries.php";
		
	@Override
	protected JSONArray doInBackground(String... url) {
		return executeQuerry(url[0]);
	}
	
	/**
	 * Effectue la connexion HTTP au fichier php present sur le serveur.
	 * Initialise l'inputStream de la reponse (en JSON) a la requete envoyee en parametre
	 * @param querry
	 */
	private JSONArray executeQuerry(String querry)
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
	private JSONArray convertStreamToString(InputStream stream){
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
	private JSONArray parseResultToJSONArray(String result){
		//parse json data
		try{
		        return new JSONArray(result);
		}catch(JSONException e){
		        Log.e("DataBaseConnector", "Error parsing data "+e.toString());
		        return null;
		}
	}

	
	
}
