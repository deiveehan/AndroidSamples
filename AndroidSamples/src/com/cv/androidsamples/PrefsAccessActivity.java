package com.cv.androidsamples;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class PrefsAccessActivity extends Activity {

	TextView tvPrefValues;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prefs_access);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String name = getPrefs.getString("name", "no name yet set");
		tvPrefValues = (TextView ) findViewById(R.id.tvPrefValues);
		Log.i("PrefsAccessActivity", name);
		
		tvPrefValues.setText(name);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prefs_access, menu);
		return true;
	}

}
