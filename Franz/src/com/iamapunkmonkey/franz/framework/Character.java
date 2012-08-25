package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.graphics.FranzSpriteBase;
import com.iamapunkmonkey.franz.framework.structure.ICharacter;
import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.franz.framework.util.FranzMap;

public abstract class Character extends FranzSpriteBase implements ICharacter {
	private int _healthUp;
	private int _healthDown;
	
	private FranzMap<String, IEntityEventListener> _eventList;
	private FranzMap<String, IEntity> _children;
	
	public Character(){
		_eventList = new FranzMap<String, IEntityEventListener>("root");
		_children = new FranzMap<String, IEntity>("root");
		_healthUp = 0;
		_healthDown = 0;
	}
	
	@Override
	public void addChild(String name, IEntity child) {
		_children.insert(name, child);
	}
	
	@Override
	public IEntity getChild(String name){
		return _children.findNode(name).getValue();
	}

	@Override
	public int getHealth() {
		int val = _healthUp - _healthDown;
		return (val <= 0) ? 0 : val;
	}

	@Override
	public void setHealth(int value) {
		_healthUp = value;
	}

	@Override
	public void addHealth(int toAdd) {
		_healthUp += toAdd;
	}

	@Override
	public void removeHealth(int toRemove) {
		_healthDown += toRemove;
	}

	@Override
	public void addEventListener(String name, IEntityEventListener event) {
		_eventList.insert(name, event);
	}

	@Override
	public IEntityEventListener getEventListener(String name) {
		return _eventList.findNode(name).getValue();
	}
}
