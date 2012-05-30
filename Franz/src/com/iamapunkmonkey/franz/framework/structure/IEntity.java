package com.iamapunkmonkey.franz.framework.structure;

public interface IEntity extends IRenderable {
	void addChild(String name, IEntity child);
	IEntity getChild(String name);
}
