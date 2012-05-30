package com.iamapunkmonkey.franz.framework.util;

public class FranzListIterator<V> {
	FranzNode<V> current;
	
	public FranzListIterator(FranzNode<V> theNode) {
		current = theNode;
	}
	
	public boolean isValid(){
		return current != null;
	}
	
	public V retrieve(){
		return isValid() ? current.element : null;
	}
	
	public void advance(){
		if(isValid())
			current = current.next;
	}
}
