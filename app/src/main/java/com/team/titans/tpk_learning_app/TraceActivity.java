package com.team.titans.tpk_learning_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TraceActivity extends AppCompatActivity {

	private static String[] tamilConsonants = {
			"க்", "ங்", "ச்", "ஞ்", "ட்", "ண்", "த்", "ந்", "ப்",
			"ம்", "ய்", "ர்", "ல்", "வ்", "ழ்", "ள்", "ற்", "ன்"};

	private PaintView paintView;
	private TextView trace;
	private int tamilIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trace);

		initialize();

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		paintView.init(metrics);
	}

	public void initialize() {
		paintView = (PaintView) findViewById(R.id.paintView);
		trace = (TextView)findViewById(R.id.textTrace);

		trace.setText(tamilConsonants[tamilIndex]);

		Button change = findViewById(R.id.buttonChange);
		change.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				change();
			}
		});

		Button clear = findViewById(R.id.buttonClear);
		clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clear();
			}
		});
	}

	public void change() {
		Random rand = new Random();
		tamilIndex++;
		if (tamilIndex >= tamilConsonants.length) {
			tamilIndex = 0;
		}
		clear();
	}

	public void clear() {
		setContentView(R.layout.activity_trace);
		initialize();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		paintView.init(metrics);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.paint, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
