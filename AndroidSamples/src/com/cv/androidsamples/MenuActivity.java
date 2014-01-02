package com.cv.androidsamples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

	String classes[] = { "FormInputs", "UICompActivity", "MailActivity", "LifeCycle", "Photo", "CalcActivity" , "PrefsAccessActivity", "SlidingDrawerActivity", "WebViewActivity", "SharedPreferencesActivity", "InternalStorageActivity", "WVUActivity", "ScrollViewActivity", "HorizontalScrView", "AbsoluteActivity"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MenuActivity.this, android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String className = classes[position];
		try {
			Class menuClass = Class.forName("com.cv.androidsamples." + className);
			Intent myIntent = new Intent (MenuActivity.this, menuClass);
			startActivity(myIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		getMenuInflater().inflate(R.menu.mymenu, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.mContactUs:
			Log.i("MenuActivity", "Contact us clicked");
			Intent i = new Intent(MenuActivity.this, ContactUsActivity.class);
			startActivity(i);
			break;
		case R.id.mExit:
			Log.i("MenuActivity", "About us clicked");
			finish();
			break;

		case R.id.mPreferences:
			Log.i("MenuActivity", "Preferences clicked");
			Intent prefi = new Intent(MenuActivity.this, Prefs.class);
			startActivity(prefi);
			
			break;
		}
		return false;
	}
	
	
	
}
