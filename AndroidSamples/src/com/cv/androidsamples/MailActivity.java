package com.cv.androidsamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends Activity {

	EditText tvEmailTo;
	EditText tvSubject;
	EditText etMailContent;
	Button bSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail);
		
		tvEmailTo = (EditText ) findViewById(R.id.tvEmailTo);
		tvSubject= (EditText )findViewById(R.id.tvSubject);
		etMailContent= (EditText )findViewById(R.id.etMailContent);
		Button bSend= (Button )findViewById(R.id.bSend);
		
		bSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String emailTo = tvEmailTo.getText().toString();
				String emailAddresses[] = {emailTo};
				String subject = tvSubject.getText().toString();
				String mailContent = etMailContent.getText().toString();
				
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddresses);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mailContent);
				emailIntent.setType("plain/text");
				startActivity(emailIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail, menu);
		return true;
	}

}
