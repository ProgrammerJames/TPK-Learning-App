package com.team.titans.tpk_learning_app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseSyncHelper extends DatabaseHelper {

	private int lastVersion = -1;

	public DatabaseSyncHelper(Context context) {
		super(context);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);
	}

	public void updateDatabase(Activity activity) {
		//Send word request
		WebRequest request = new WebRequest("http://jupiter.csit.rmit.edu.au/~s3711666/mobile/words.php?version=" + lastVersion + ";");
		Thread t = new Thread(request);
		t.start();

		String text = "";

		try {
			t.join();
			text = request.getResponse();
		} catch (InterruptedException e) { e.printStackTrace(); }

		try {
			JSONObject response = new JSONObject(text);

			//Set new version
			lastVersion = response.getInt("version");

			//Add missing words to database
			updateEntries(activity, response.getJSONArray("words"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void updateEntries(Activity activity, JSONArray array) throws JSONException {
		SQLiteDatabase write = this.getWritableDatabase();
		for (int i=0; i<array.length(); i++) {
			JSONObject word = array.getJSONObject(i);
			ContentValues values = new ContentValues();

			int id = word.getInt("id");
			int image = activity.getResources().getIdentifier(word.getString("image"), "drawable", activity.getPackageName());
			int audio = activity.getResources().getIdentifier(word.getString("audio"), "raw", activity.getPackageName());

			values.put(kID, id);
			values.put(kEnglish, word.getString("english"));
			values.put(kTamil, word.getString("tamil"));
			values.put(kImage, image);
			values.put(kAudio, audio);
			values.put(kCategory, word.getString("category"));
			write.delete(tWords, "id = " + id, null);
			write.insert(tWords,null, values);
		}
		write.close();
	}
}
