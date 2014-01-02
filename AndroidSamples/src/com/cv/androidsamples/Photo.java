package com.cv.androidsamples;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Photo extends Activity implements OnClickListener {

	ImageButton ib;
	Button bSetWallPaper;
	ImageView iv;
	Intent i;
	final static int cameraData = 0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
		initialize();
	}

	private void initialize() {
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		bSetWallPaper = (Button) findViewById(R.id.bSetWall);
		ib.setOnClickListener(this);
		bSetWallPaper.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.bSetWall:
				Log.d("PhotoActivity", "inside Set wallpaper ");
				try {
					getApplicationContext().setWallpaper(bmp);
				} catch (IOException e) {
					Log.e("PhotoActivity", e.getMessage());
					System.out.println("exception: " + e.getMessage());
				}
				break;
				
			case R.id.ibTakePic:
				Log.d("PhotoActivity", "inside TakePic");
				i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, cameraData);
				break;
		}
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo, menu);
		return true;
	}


}
