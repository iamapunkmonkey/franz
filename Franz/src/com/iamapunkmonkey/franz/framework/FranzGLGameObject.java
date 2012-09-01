package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.graphics.FranzGLSpriteBase;
import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.franz.framework.structure.IGLRenderable;
import com.iamapunkmonkey.franz.framework.util.FranzMap;

public abstract class FranzGLGameObject extends FranzGLSpriteBase {
	private FranzMap<String, IEntityEventListener> _eventList;
	private FranzMap<String, IEntity> _children;
	
	private String _currentEvent = "default";
	
	public FranzGLGameObject(){
		super();
		
		_eventList = new FranzMap<String, IEntityEventListener>("Root");
		_children = new FranzMap<String, IEntity>("Root");
	}
	
	public void setCurrentEvent(String event){
		this._currentEvent = event;
	}
	
	public String getCurrentEvent(){
		return _currentEvent;
	}
	
	@Override
	public void addChild(String name, IEntity child) {
		_children.insert(name, child);
	}

	@Override
	public IEntity getChild(String name) {
		return _children.findNode(name).getValue();
	}

	@Override
	public void addEventListener(String name, IEntityEventListener event) {
		_eventList.insert(name, event);
	}

	@Override
	public IEntityEventListener getEventListener(String name) {
		return _eventList.findNode(name).getValue();
	}
	
	@Override
	public void addDefaultEventListener(IEntityEventListener event){
		_eventList.insert("default", event);
	}
	
	@Override
	public IEntityEventListener getEventListener(){
		return _eventList.findNode("default").getValue();
	}
	
	@Override
	public void addCurrentEventListener(IEntityEventListener event){
		_eventList.insert(_currentEvent, event);
	}

	@Override
	public IEntityEventListener getCurrentEventListener(){
		IEntityEventListener returnValue = _eventList.findNode(_currentEvent).getValue();
		return (returnValue != null) ? returnValue : getEventListener();
	}

}
