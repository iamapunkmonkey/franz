package com.iamapunkmonkey.franz.framework.structure;

public interface IEntityEventListener {
	void onEventPorcess();
	void onEventMove(float x, float y);
	void onEventPress(float x, float y);
	void onEventRelease(float x, float y);
}
