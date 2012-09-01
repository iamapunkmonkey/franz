package com.iamapunkmonkey.franz.framework.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.IGLRenderable;

public abstract class FranzGLSpriteBase implements IGLRenderable {

	private final String vertexShaderCode =
		"uniform mat4 uMVPMatrix;" +
		"attribute vec4 vPosition;" +
		"void main() {" +
		"  gl_Position = vPosition * uMVPMatrix;" +
		"}";
	
	private final String fragmentShaderCode =
		"precision mediump float;" +
		"uniform vec4 vColor;" +
		"void main() {" +
		"  gl_FragColor = vColor;" +
		"}";
	
	private final FloatBuffer vertexBuffer;
	private final ShortBuffer drawListBuffer;
	private final int mProgram;
	private int mPositionHandle;
	private int mColorHandle;
	private int mMVPMatrixHandle;
	
	static final int COORDS_PER_VERTEX = 3;
	
	static float squareCoords[] = {
		-0.5f, 0.5f, 0.0f,
		-0.5f, -0.5f, 0.0f,
		0.5f, -0.5f, 0.0f,
		0.5f, 0.5f, 0.0f
	};
	
	private final short drawOrder[] = {0,1,2,0,2,3};
	
	private final int vertexStride = COORDS_PER_VERTEX * 4;
	
	float color[] = { 0.2f, 0.709803922f, 0.898039216f, 1.0f };
	
	private final float[] mMVPMatrix = new float[16];
	private final float[] mVMatrix = new float[16];
	private final float[] mRotationMatrix = new float[16];
	
	public volatile float mAngle;

	public FranzGLSpriteBase(){
		ByteBuffer bb = ByteBuffer.allocateDirect(squareCoords.length * 4);
		bb.order(ByteOrder.nativeOrder());
		
		vertexBuffer = bb.asFloatBuffer();
		vertexBuffer.put(squareCoords);
		vertexBuffer.position(0);
		
		ByteBuffer dlb = ByteBuffer.allocateDirect(drawOrder.length * 2);
		dlb.order(ByteOrder.nativeOrder());
		drawListBuffer = dlb.asShortBuffer();
		drawListBuffer.put(drawOrder);
		drawListBuffer.position(0);
		
		int vertexShader = FranzGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
		int fragmentShader = FranzGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
		
		mProgram = GLES20.glCreateProgram();
		GLES20.glAttachShader(mProgram, vertexShader);
		GLES20.glAttachShader(mProgram, fragmentShader);
		GLES20.glLinkProgram(mProgram);
	}
	
	@Override
	public void draw(GL10 gl, float[] mProjMatrix) {
		Matrix.setLookAtM(mVMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
		Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);
		
		GLES20.glUseProgram(mProgram);
		
		mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
		
		GLES20.glEnableVertexAttribArray(mPositionHandle);
		
		GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);
		
		mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
		
		GLES20.glUniform4fv(mColorHandle, 1, color, 0);
		
		mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
		FranzGLRenderer.checkGlError("glGetUniformLocation");
		
		GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);
		FranzGLRenderer.checkGlError("glUniformMatrix4fv");
		
		GLES20.glDrawElements(GLES20.GL_TRIANGLES, drawOrder.length, GLES20.GL_UNSIGNED_SHORT, drawListBuffer);
		
		GLES20.glDisableVertexAttribArray(mPositionHandle);
	}
}