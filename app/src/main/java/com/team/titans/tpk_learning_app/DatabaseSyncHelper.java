package com.team.titans.tpk_learning_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DatabaseSyncHelper extends DatabaseHelper {

	public DatabaseSyncHelper(Context context) {
		super(context);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);

		//Set last version
		int lastVersion = -1;
	}

	public void updateDatabase() throws JSONException {
		SQLiteDatabase db = this.getWritableDatabase();

		//Get last version
		int lastVersion = -1;

		//Send word request
		JSONObject request = new JSONObject();

		try {
			URL url = new URL("http://jupiter.csit.rmit.edu.au/~s3711666/mobile/words.php?version=" + lastVersion + ";");
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			try {
				InputStream in = new BufferedInputStream(connect.getInputStream());
				//readStream(in);
			} finally {
				connect.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Log.d("A", request.toString());
		//Set new version
		lastVersion = request.getInt("version");

		//Add missing words to database
//		JSONArray words = request.getJSONArray("words");
//
//		for (int i=0; i<words.length(); i++) {
//			JSONObject word = words.getJSONObject(i);
//
//			int image = 0;
//			int audio = 0;
// 			Word obj = new Word(word.getString("english"), word.getString("tamil"), word.getInt("image"), word.getInt("audio"), word.getString("category"));
//			this.addWord(word.getInt("id"), obj);
//		}
	}
}
