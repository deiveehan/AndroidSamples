package com.cv.androidsamples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class CalcAnswersActivity extends Activity {

	TextView tvCalcAnswers;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc_answers);
		
		tvCalcAnswers = (TextView) findViewById(R.id.tvCalcAnswers);
		Bundle obtainedBasket = getIntent().getExtras();
		String answer = obtainedBasket.get("answer").toString();
		Log.i("CalcAnswersActivity", answer);
		tvCalcAnswers.setText(answer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calc_answers, menu);
		return true;
	}

}
