package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.graphics.FranzGLRenderer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class FranzGamePanel extends GLSurfaceView implements SurfaceHolder.Callback {
	
	public static int SCREEN_WIDTH = 480;
	public static int SCREEN_HEIGHT = 800;
	private FranzGLRenderer mRenderer;
	
	public FranzGamePanel(Context context) {
		super(context);
		
		setEGLContextClientVersion(2);
		
		mRenderer = new FranzGLRenderer();
		setRenderer(mRenderer);
		
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	
	private float mPreviousX;
	private float mPreviousY;

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		FranzGamePanel.SCREEN_WIDTH = width;
		FranzGamePanel.SCREEN_HEIGHT = height;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e){
		
		float x = e.getX();
		float y = e.getY();
		
		return FranzGameManager.GetGameManager().processTouch(x, y, e.getAction());
	}
}
