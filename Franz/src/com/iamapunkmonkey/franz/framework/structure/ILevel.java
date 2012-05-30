package com.iamapunkmonkey.franz.framework.structure;

public interface ILevel {
	void addObject(IEntity obj);
	void removeObject(IEntity obj);
	IEntity getObject(int index);
	void update();
	void draw();
}
