package com.example.app1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalInfo extends SuperActivity {
	
	TextView UserName,version;
	ImageButton back;
	int count=6;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personalinfo);
		
		
		UserName=(TextView)findViewById(R.id.UserName);
		back=(ImageButton) findViewById(R.id.back);
		version=(TextView)findViewById(R.id.version);
		
		Intent info= this.getIntent();
		String name= info.getStringExtra("name");
		UserName.setText(name);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		version.setOnClickListener(new View.OnClickListener() {
			

			public void onClick(View arg0) {
				count--;
				if(count<=0)
					startActivity(new Intent(PersonalInfo.this,Hidden.class));
				
				
			}
		});
	}

}
