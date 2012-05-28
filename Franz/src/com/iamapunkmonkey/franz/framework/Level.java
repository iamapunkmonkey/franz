package com.iamapunkmonkey.franz.framework;

import com.iamapunkmonkey.franz.framework.structure.IEntity;
import com.iamapunkmonkey.franz.framework.structure.ILevel;
import com.iamapunkmonkey.franz.framework.util.FranzList;


public abstract class Level implements ILevel {
	
	FranzList<IEntity> levelObjects;
	
	public Level(){
		levelObjects = new FranzList<IEntity>();
	}

	@Override
	public void addObject(IEntity obj) {
		levelObjects.insert(obj);
	}

	@Override
	public void removeObject(IEntity obj) {
		levelObjects.remove(obj);
	}
	
	@Override
	public IEntity getObject(int index){
		return levelObjects.get(index);
	}
}