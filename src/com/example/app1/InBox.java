package com.example.app1;



import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class InBox extends ListActivity {
	
	//广播Action
	 public static final String SYSTEM_EXIT = "com.example.app1.system_exit";
	//接收器
	 private MyReceiver receiver;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_box);
		
		IntentFilter filter = new IntentFilter();
		  filter.addAction(SYSTEM_EXIT);
		  receiver = new MyReceiver();
		  this.registerReceiver(receiver, filter);
		
		final DataBase db= new DataBase(this);
		Cursor c=db.query();
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(this,R.layout.activity_in_box,c,new String[]{"stopID","stopLat","stopLon","stopName"},new int[]{R.id.from,R.id.to,R.id.subejct,R.id.content});
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


