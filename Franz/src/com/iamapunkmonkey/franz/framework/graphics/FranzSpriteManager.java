package com.iamapunkmonkey.franz.framework.graphics;

import javax.microedition.khronos.opengles.GL10;

import com.iamapunkmonkey.franz.framework.util.FranzList;

public class FranzSpriteManager {
	
	FranzList<FranzSpriteBase> sprites;
	
	public FranzSpriteManager(){
		sprites = new FranzList<FranzSpriteBase>();
	}
	
	public void addSprite(FranzSpriteBase sprite){
		sprites.insert(sprite);
	}
	
	public void removeSprite(FranzSpriteBase sprite){
		sprites.remove(sprite);
	}
	
	public void draw(GL10 gl, float[] mProjMatrix){
		for(int i = 0; i < sprites.size(); i++)
			sprites.get(i).draw(gl, mProjMatrix);
	}
}
