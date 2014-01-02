package com.cv.androidsamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalStorageActivity extends Activity {

	EditText etIsInput;
	Button bIsLoad;
	Button bIsSave;
	TextView tvIsResults;
	FileOutputStream fos;
	FileInputStream fis;
	static String fileName = "InternalString";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_internal_storage);
		initialize();
	}
	
	private void initialize() {
		
		
		etIsInput = (EditText) findViewById(R.id.etShInput);
		bIsLoad = (Button) findViewById(R.id.bShLoad);
		bIsSave = (Button) findViewById(R.id.bShSave);
		tvIsResults = (TextView) findViewById(R.id.tvShResults);


		bIsSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String stringData = etIsInput.getText().toString();
				try {
					fos = openFileOutput(fileName, Context.MODE_PRIVATE);
					fos.write(stringData.getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

		bIsLoad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String obtainedValue = "";
				try {
					fis = openFileInput(fileName);
					byte[] dataArray = new byte[fis.available()];
					while (fis.read(dataArray) != -1) {
						obtainedValue = new String(dataArray);
					}
					
					fis.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tvIsResults.setText(obtainedValue);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.internal_storage, menu);
		return true;
	}

}
