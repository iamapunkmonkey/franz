package com.iamapunkmonkey.franz.framework.structure;

import javax.microedition.khronos.opengles.GL10;

public interface IRenderable {
	void init();
	void update();
	void draw(GL10 gl);
}
