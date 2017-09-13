package com.example.app1;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class AboutUs extends SuperActivity {
	
	RatingBar ratingBar;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.);
		ratingBar=(RatingBar)findViewById(R.id);
		textView=(TextView)findViewById(R.id.result);
		
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener()  {

			@Override
			public void onRatingChanged(RatingBar ratingbar, float grade, boolean arg2) {
				switch ((int)grade) {
	            case 1:
	                textView.setText("当前的用户评价：太糟了");
	                break;
	                case 2:
	                    textView.setText("当前的用户评价：不太好");
	                break;
	                case 3:
	                    textView.setText("当前的用户评价：不错哦");
	                break;
	                case 4:
	                    textView.setText("当前的用户评价：很好哦");
	                break;
	                case 5:
	                    textView.setText("当前的用户评价：太棒了");
	                break;
	            default:
	                break;
			}

				
			
		};
	

});
}
}
