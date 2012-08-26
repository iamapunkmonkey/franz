package com.iamapunkmonkey.franz.framework.structure;

public interface IEntity {
	void addChild(String name, IEntity child);
	IEntity getChild(String name);

	void addEventListener(String name, IEntityEventListener event);
	IEntityEventListener getEventListener(String name);

	
	void addDefaultEventListener(IEntityEventListener event);
	IEntityEventListener getEventListener();

	void addCurrentEventListener(IEntityEventListener event);
	IEntityEventListener getCurrentEventListener();

	void update();
}
