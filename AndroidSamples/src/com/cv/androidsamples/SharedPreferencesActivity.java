package com.cv.androidsamples;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends Activity {

	EditText etShInput;
	Button bShLoad;
	Button bShSave;
	TextView tvShResults;
	
	final static String prefsFileName = "MySharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_preferences);
		initialize();
		someData = getSharedPreferences(prefsFileName, 0);
	}
	

	private void initialize() {
		etShInput = (EditText) findViewById(R.id.etShInput);
		bShLoad = (Button) findViewById(R.id.bShLoad);
		bShSave = (Button) findViewById(R.id.bShSave);
		tvShResults = (TextView) findViewById(R.id.tvShResults);

		bShSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String stringData = etShInput.getText().toString();
				SharedPreferences.Editor editor = someData.edit();
				editor.putString("sharedString", stringData);
				editor.commit();
			}
		});

		bShLoad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				someData = getSharedPreferences(prefsFileName, 0);
				String stringDataFromSharedPreference = someData.getString("sharedString", "No data available");
				tvShResults.setText(stringDataFromSharedPreference);
				
				
			}
		});
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shared_preferences, menu);
		return true;
	}

}
