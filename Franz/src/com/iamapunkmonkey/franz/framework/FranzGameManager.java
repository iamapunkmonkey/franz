package com.iamapunkmonkey.franz.framework;

import android.view.MotionEvent;

import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.franz.framework.util.FranzEntityEventException;
import com.iamapunkmonkey.franz.framework.util.FranzList;
import com.iamapunkmonkey.franz.framework.util.FranzListIterator;

public class FranzGameManager {
	
	private FranzList<IEntity> _gameObjects;
	
	private static FranzGameManager _gameManager;
	
	public FranzGameManager(){
		_gameObjects = new FranzList<IEntity>();
	}
	
	public void addGameObejct(FranzGLGameObject obj) throws FranzEntityEventException{
		if(obj.getEventListener() == null)
			throw new FranzEntityEventException("You need to create a default Entity Event.");
		_gameObjects.insert(obj);
	}
	
	public IEntity getGameObject(int index){
		return _gameObjects.get(index);
	}
	
	public void removeGameObject(int index){
		_gameObjects.remove(index);
	}
	
	public void removeGameObject(FranzGLGameObject obj){
		_gameObjects.remove(obj);
	}
	
	public boolean processTouch(float x, float y, int action){
		
		FranzListIterator<IEntity> it = new FranzListIterator<IEntity>(_gameObjects.head);
		IEntity gameObj = null;
		while((gameObj = it.retrieve()) != null){
			IEntityEventListener event = gameObj.getCurrentEventListener();
			if(event != null){
				switch(action){
				case MotionEvent.ACTION_MOVE:
					event.onEventMove(x, y);
					break;
				case MotionEvent.ACTION_DOWN:
					event.onEventPress(x, y);
					break;
				case MotionEvent.ACTION_UP:
					event.onEventRelease(x, y);
					break;
				}
			}
			
			it.advance();
		}
				
		return true;
	}
	
	public static FranzGameManager GetGameManager(){
		if(_gameManager == null)
			_gameManager = new FranzGameManager();
		
		return _gameManager;
	}
}
