package com.cv.androidsamples;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HorizontalScrView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horizontal_scr_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.horizontal_scr_view, menu);
		return true;
	}

}
