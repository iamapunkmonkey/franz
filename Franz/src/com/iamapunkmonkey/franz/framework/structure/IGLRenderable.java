package com.iamapunkmonkey.franz.framework.structure;

import javax.microedition.khronos.opengles.GL10;

public interface IGLRenderable extends IEntity {
	void init();
	void draw(GL10 gl, float[] mProjMatrix);
}
