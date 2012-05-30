package com.iamapunkmonkey.franz.framework.util;

public class FranzNode<V> {
	public V element;
	public FranzNode<V> next, previous;
	
	public FranzNode(V theElement){
		this(theElement, null);
	}
	
	public FranzNode(V theElement, FranzNode<V> n){
		element = theElement;
		next = n;
	}
}
