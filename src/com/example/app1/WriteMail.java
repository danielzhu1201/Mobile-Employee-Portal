package com.example.app1;


import android.R;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteMail extends SuperActivity {
	private EditText to,from,subject,content;
	String toInfo,subjectInfo,contentInfo;
	public static DataBase db;
	ContentValues cv;
	SQLiteDatabase dbWrite;
	private Button sendBtn;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_mail);
		to=(EditText)findViewById(R.id.to);
		from=(EditText)findViewById(R.id.from);
		subject=(EditText)findViewById(R.id.subject);
		content=(EditText)findViewById(R.id.content);
		sendBtn=(Button)findViewById(R.id.sendBtn);
		
		Intent i= this.getIntent();
		
		
		to.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				toInfo = to.getText().toString();				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		from.setText(i.getStringExtra("name").toString());
		
		subject.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				subjectInfo = subject.getText().toString();				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		content.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				contentInfo = content.getText().toString();				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		sendBtn.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				//全局
				db= new DataBase(getApplicationContext());
				cv= new ContentValues();

				cv.put("stopID","发件人："+from.getText().toString());
				cv.put("stopLat","收件人："+toInfo);
				cv.put("stopLon","主题："+subjectInfo);
				cv.put("stopName","内容："+contentInfo);
				db.insert(cv);
				db.close();
				Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
//				startActivity(new Intent(WriteMail.this,InBox.class));
				finish();
			}
		});

	}

}
