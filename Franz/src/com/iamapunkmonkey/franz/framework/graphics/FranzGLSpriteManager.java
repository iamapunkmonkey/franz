package com.iamapunkmonkey.franz.framework.graphics;

import javax.microedition.khronos.opengles.GL10;

import com.iamapunkmonkey.franz.framework.util.FranzList;

public class FranzGLSpriteManager {
	
	FranzList<FranzGLSpriteBase> sprites;
	
	public FranzGLSpriteManager(){
		sprites = new FranzList<FranzGLSpriteBase>();
	}
	
	public void addSprite(FranzGLSpriteBase sprite){
		sprites.insert(sprite);
	}
	
	public void removeSprite(FranzGLSpriteBase sprite){
		sprites.remove(sprite);
	}
	
	public void draw(GL10 gl, float[] mProjMatrix){
		for(int i = 0; i < sprites.size(); i++)
			sprites.get(i).draw(gl, mProjMatrix);
	}
}
