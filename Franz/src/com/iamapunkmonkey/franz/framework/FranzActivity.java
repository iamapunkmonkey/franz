package com.iamapunkmonkey.franz.framework;

import android.app.Activity;
import android.os.Bundle;

public class FranzActivity extends Activity {
	private FranzGamePanel mGLView;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGLView = new FranzGamePanel(this);
		
		setContentView(mGLView);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		mGLView.onResume();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		
		mGLView.onPause();
	}
}
