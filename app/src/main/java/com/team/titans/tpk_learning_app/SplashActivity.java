package com.team.titans.tpk_learning_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.util.Log;

import org.json.JSONException;

public class SplashActivity extends AppCompatActivity {

	private final int SPLASH_DISPLAY_LENGTH = 3000;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Populate Database */
		DatabaseSyncHelper db = new DatabaseSyncHelper(this);
 		try {
			db.updateDatabase();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run() {
                /* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(SplashActivity.this, HomeActivity.class);
				SplashActivity.this.startActivity(mainIntent);
				SplashActivity.this.finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}