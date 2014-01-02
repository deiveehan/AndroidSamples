package com.cv.androidsamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class WebViewActivity extends Activity implements OnClickListener {

	Button bBack;
	Button bForward;
	Button bGo;
	Button bRefresh;
	Button bHistory;
	TextView etURL;
	WebView myBrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		myBrow = (WebView) findViewById(R.id.wvBrowser);
		/*myBrow.loadUrl("http://www.google.com");*/
		initialize();
	}

	private void initialize() {
		bBack = (Button) findViewById(R.id.bBack);
		bForward = (Button) findViewById(R.id.bForward);
		bHistory = (Button) findViewById(R.id.bHistory);
		bGo = (Button) findViewById(R.id.bGo);
		bRefresh = (Button) findViewById(R.id.bRefresh);
		etURL = (TextView) findViewById(R.id.etURL);

		bBack.setOnClickListener(this);
		bForward.setOnClickListener(this);
		bHistory.setOnClickListener(this);
		bGo.setOnClickListener(this);
		bRefresh.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bGo:
			String websiteURL = etURL.getText().toString();
			myBrow.loadUrl(websiteURL);
			break;
		case R.id.bBack:
			if (myBrow.canGoBack()) {
				myBrow.goBack();
			}
			break;
		case R.id.bRefresh:
			myBrow.reload();
			break;
		case R.id.bHistory:
			myBrow.clearHistory();
			break;
		case R.id.bForward:
			if (myBrow.canGoForward()) {
				myBrow.goForward();
			}
			break;
		default:
			break;
		}

	}

}
