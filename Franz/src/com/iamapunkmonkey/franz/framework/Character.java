package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.structure.ICharacter;
import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.franz.framework.util.FranzMap;

public abstract class Character implements ICharacter {
	private int _healthUp;
	private int _healthDown;
	
	private FranzMap<String, IEntityEventListener> _eventList;
	private FranzMap<String, IEntity> _children;
	
	public Character(){
		_eventList = new FranzMap<String, IEntityEventListener>();
		_children = new FranzMap<String, IEntity>();
	}
	
	@Override
	public void addChild(String name, IEntity child) {
		_children.insert(name, child);
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
