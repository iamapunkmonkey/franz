package com.iamapunkmonkey.franz.framework.graphics;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class FranzGLSurfaceView extends GLSurfaceView {
	private GLSurfaceView.Renderer mRenderer;
	
	public FranzGLSurfaceView(Context context, GLSurfaceView.Renderer renderer){
		super(context);
		
		mRenderer = renderer;
		setRenderer(mRenderer);
	}
}
