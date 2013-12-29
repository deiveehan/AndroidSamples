package com.cv.androidsamples;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormInputs extends Activity {

	ToggleButton passTog;
	Button chkCmd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_inputs);
		
		passTog = (ToggleButton) findViewById(R.id.tbPassword);
		chkCmd = (Button) findViewById(R.id.bResults);
		final TextView display = (TextView) findViewById(R.id.tvResults);
		
		final EditText input = (EditText) findViewById(R.id.etCommands);
		passTog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(passTog.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					Toast.makeText(FormInputs.this, "Text input is now Password type", 2000).show();
				}
				else {
					input.setInputType(InputType.TYPE_CLASS_TEXT );
					Toast.makeText(FormInputs.this, "Text input is normal type", 2000).show();
				}
			}
		});
		chkCmd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String check = input.getText().toString();
				display.setText(check);
				System.out.println("CHECL : " + check);
				if(check.contentEquals("left")) {
					display.setGravity(Gravity.LEFT);
				} else if(check.contentEquals("center")) {
					display.setGravity(Gravity.CENTER);
				} else if(check.contentEquals("right")) {
					display.setGravity(Gravity.RIGHT);
				} else if(check.contentEquals("blue")) {
					display.setTextColor(Color.BLUE);
				} else if(check.contentEquals("random")) {
					Random randomValue = new Random();
					display.setText("Some junk value");
					display.setTextSize(randomValue.nextInt(50));
					display.setTextColor(Color.rgb(randomValue.nextInt(255), randomValue.nextInt(255), randomValue.nextInt(255)));
				} else {
					display.setText("invalid");
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_inputs, menu);
		return true;
	}

}
