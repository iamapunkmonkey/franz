package com.iamapunkmonkey.franz.framework.graphics;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

public class FranzGLRenderer implements GLSurfaceView.Renderer {
	
	private static final String TAG = "FranzGLRenderer";
	
	private FranzSpriteManager spriteManager;
	
	private final float[] mProjMatrix = new float[16];
	
	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		spriteManager.draw(gl, mProjMatrix);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
		
		float ratio = (float) width / height;
		
		Matrix.frustumM(mProjMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	}
	
	public static int loadShader(int type, String shaderCode){
		int shader = GLES20.glCreateShader(type);
		
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);
		
		return shader;
	}
	
	public static void checkGlError(String glOperation){
		int error;
		while((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR){
			Log.e(TAG, glOperation + ": glError " + error);
			throw new RuntimeException(glOperation + ": glError " + error);
		}
	}
}
