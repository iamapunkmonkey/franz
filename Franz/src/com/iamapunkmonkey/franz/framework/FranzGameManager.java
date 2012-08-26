package com.iamapunkmonkey.franz.framework;

import android.view.MotionEvent;

import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.franz.framework.structure.IRenderable;
import com.iamapunkmonkey.franz.framework.util.FranzList;
import com.iamapunkmonkey.franz.framework.util.FranzListIterator;

public class FranzGameManager {
	
	private FranzList<FranzGameObject> _gameObjects;
	
	private static FranzGameManager _gameManager;
	
	public FranzGameManager(){
		_gameObjects = new FranzList<FranzGameObject>();
	}
	
	public void addGameObejct(FranzGameObject obj){
		_gameObjects.insert(obj);
	}
	
	public IRenderable getGameObject(int index){
		return _gameObjects.get(index);
	}
	
	public void removeGameObject(int index){
		_gameObjects.remove(index);
	}
	
	public void removeGameObject(FranzGameObject obj){
		_gameObjects.remove(obj);
	}
	
	public boolean processTouch(float x, float y, int action){
		
		FranzListIterator<FranzGameObject> it = new FranzListIterator<>(_gameObjects.head);
		FranzGameObject gameObj = null;
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
