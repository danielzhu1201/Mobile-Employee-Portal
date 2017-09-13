package com.example.app1;



import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Notifications extends ListActivity {
	private Button	btn;
	public String edittext;
	public DataBase2 database;
	String userName;
	//广播Action
		 public static final String SYSTEM_EXIT = "com.example.app1.system_exit";
		//接收器
		 private MyReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);
		btn=(Button)findViewById(R.id.btn);
	    database= new DataBase2(this);
	    userName= this.getIntent().getStringExtra("name").toString();
	    
	    IntentFilter filter = new IntentFilter();
		  filter.addAction(SYSTEM_EXIT);
		  receiver = new MyReceiver();
		  this.registerReceiver(receiver, filter);
	    
	    
	    final DataBase2 db= new DataBase2(this);
		Cursor c=db.query();
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(this,R.layout.activity_notifications,c,new String[]{"_id","info"},new int[]{R.id.no,R.id.notif});
		ListView listview=getListView();
		listview.setAdapter(adapter);


		
		
	}
	
	protected void onDestroy() {
		   //记得取消广播注册
		   this.unregisterReceiver(receiver);
		   super.onDestroy();
}
	
	private class MyReceiver extends BroadcastReceiver {
		public MyReceiver() {
			
		}

		@Override
		public void onReceive(Context context, Intent intent) {
	       finish();
		}
	
	
	

}
}
	
