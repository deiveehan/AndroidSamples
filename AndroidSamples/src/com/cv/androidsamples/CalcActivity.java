package com.cv.androidsamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity {

	int counter ;
	Button bPlus;
	Button bMinus;
	Button bDisplayAnswersInNextPage;
	
	
	TextView tDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		
		
		bPlus = (Button) findViewById(R.id.bPlus);
		bMinus = (Button) findViewById(R.id.bMinus);
		tDisplay = (TextView) findViewById(R.id.tDisplay);
		bDisplayAnswersInNextPage = (Button) findViewById(R.id.bDisplayAnswers);
		
		
		bPlus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				counter = counter + 1;
				tDisplay.setText("Your Answer is : " + counter);
			}
		});
		
		bMinus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter = counter -1;
				tDisplay.setText("Your Answer is : " + counter);
			}
		});
		bDisplayAnswersInNextPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle basket = new Bundle();
				basket.putString("answer", "Your answer is " + counter);
				
				Intent activityAnswers = new Intent(CalcActivity.this, CalcAnswersActivity.class);
				activityAnswers.putExtras(basket);
				startActivity(activityAnswers);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
