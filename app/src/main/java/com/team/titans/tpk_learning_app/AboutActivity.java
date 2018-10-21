package com.team.titans.tpk_learning_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		// Find the View
		CardView facebook = (CardView) findViewById(R.id.CardView_facebook);
		CardView twitter = (CardView) findViewById(R.id.CardView_twitter);
		CardView website = (CardView) findViewById(R.id.CardView_website);
		CardView info = (CardView) findViewById(R.id.CardView_info);

		// Set a click listener on that View
		facebook.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
                String url = "https://www.facebook.com/Tamizh-Pallikoodam-Inc-227835430628668/timeline/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
			}
		});

		twitter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
                String url = "https://twitter.com/tamizhpallioz";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
			}
		});

		website.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
                String url = "http://www.tamizhpallikoodam.org.au/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
			}
		});

		info.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
                Intent aboutIntent = new Intent(AboutActivity.this, InfoActivity.class);
                startActivity(aboutIntent);
			}
		});
	}
}