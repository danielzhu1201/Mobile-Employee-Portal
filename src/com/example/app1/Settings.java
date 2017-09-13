package com.example.app1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Settings extends SuperActivity{
	private EditText edit;
	private String msg;
	private Button personalinfo,about,changeaccount;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		personalinfo=(Button)findViewById(R.id.personalinfo);
		about=(Button)findViewById(R.id.about);
		changeaccount=(Button)findViewById(R.id.changeaccount);
		
		Intent i= this.getIntent();
		final String name=i.getStringExtra("name").toString();
//		System.out.println(name);
//		String a=i.getStringExtra("name").toString();
		personalinfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent i= new Intent(Settings.this,PersonalInfo.class);
				i.putExtra("name", name);
				startActivity(i);
				
			}
		});
		
		about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(Settings.this,AboutUs.class));
				
			}
		});
		
		changeaccount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(Settings.this,Login.class));
				finish();
				
			}
		});
		
	}


}
	

