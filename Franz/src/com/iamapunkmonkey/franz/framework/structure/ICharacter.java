package com.iamapunkmonkey.franz.framework.structure;

public interface ICharacter {
	int getHealth();
	void setHealth(int value);
	void addHealth(int toAdd);
	void removeHealth(int toRemove);
	
	void addEventListener(String name, IEntityEventListener event);
	IEntityEventListener getEventListener(String name);
}
