package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.structure.ICharacter;

public abstract class Character extends FranzGameObject implements ICharacter {
	private int _healthUp;
	private int _healthDown;
	
	public Character(){
		_healthUp = 0;
		_healthDown = 0;
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
}