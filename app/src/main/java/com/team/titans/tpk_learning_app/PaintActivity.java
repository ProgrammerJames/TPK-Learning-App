package com.team.titans.tpk_learning_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PaintActivity extends AppCompatActivity {

	private PaintView paintView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paint);
		paintView = (PaintView) findViewById(R.id.paintView);
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.normal:
				paintView.normal();
				return true;
			case R.id.emboss:
				paintView.emboss();
				return true;
			case R.id.blur:
				paintView.blur();
				return true;
			case R.id.clear:
				//paintView.clear();
				setContentView(R.layout.activity_paint);
				paintView = (PaintView) findViewById(R.id.paintView);
				DisplayMetrics metrics = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(metrics);
				paintView.init(metrics);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
