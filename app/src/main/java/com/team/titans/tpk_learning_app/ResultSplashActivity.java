package com.team.titans.tpk_learning_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultSplashActivity extends AppCompatActivity {

	private final int SPLASH_DISPLAY_LENGTH = 1500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_splash);

		Intent myIntent = getIntent();
		String correct = myIntent.getStringExtra("correct");
		final int score = myIntent.getIntExtra("score", 0);

		TextView resultText = (TextView)findViewById(R.id.textResult);
		resultText.setText(correct);

		TextView scoreText = (TextView)findViewById(R.id.textScore);
		scoreText.setText(Integer.toString(score));

		//Toast.makeText(getApplicationContext(), "Answer: " + correct, Toast.LENGTH_LONG).show();

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				/* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(ResultSplashActivity.this, QuestionActivity.class);
				mainIntent.putExtra("score", score);
				ResultSplashActivity.this.startActivity(mainIntent);
				ResultSplashActivity.this.finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}

	@Override
	public void onBackPressed() {
		//Do nothing
	}
}
