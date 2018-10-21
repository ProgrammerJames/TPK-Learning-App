package com.team.titans.tpk_learning_app;

import android.content.Intent;
import android.graphics.Color;
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

		initialize();
	}

	public void initialize() {
		setContentView(R.layout.activity_trace);

		paintView = (PaintView) findViewById(R.id.paintView);
		trace = (TextView)findViewById(R.id.textTrace);

		trace.setText(tamilConsonants[tamilIndex]);

		Button prev = findViewById(R.id.buttonPrev);
		if (tamilIndex == 0) {
			prev.setEnabled(false);
			prev.setBackgroundColor(Color.GRAY);
		} else {
			prev.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					change(tamilIndex-1);
				}
			});
		}

		Button next = findViewById(R.id.buttonNext);
		if (tamilIndex == tamilConsonants.length-1) {
			next.setEnabled(false);
			next.setBackgroundColor(Color.GRAY);
		} else {
			next.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					change(tamilIndex+1);
				}
			});
		}

		Button clear = findViewById(R.id.buttonClear);
		clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				initialize();
			}
		});

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		paintView.init(metrics);
	}

	public void change(int val) {
		tamilIndex = val;
		initialize();
	}
}
