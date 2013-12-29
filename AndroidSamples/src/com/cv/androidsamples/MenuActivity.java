package com.cv.androidsamples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

	String classes[] = { "FormInputs", "MailActivity", "ex3"};

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
	
}
