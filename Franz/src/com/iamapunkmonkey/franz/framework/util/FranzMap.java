package com.iamapunkmonkey.franz.framework.util;

public class FranzMap<K, V> {
	FranzMapNode<K, V> rootNode;
	
	public void create(K key)
	{
		rootNode = new FranzMapNode<K, V>(key, null);
		rootNode.setParent(null);
	}

	public void destroy()
	{
		rootNode.removeChild();
	}

	public FranzMapNode<K, V> getRoot()
	{
		return rootNode;
	}

	public void insert(K key, V value)
	{
		this.insert(key, value, null);
	}
	
	public void insert(K key, V value, K parent){
		FranzMapNode<K, V> root = (parent != null) ? rootNode.findNode(parent) : rootNode;
		root.insertChild(key, value);
	}

	public void remove(K key)
	{
		rootNode.removeChild(key);
	}
	
	public FranzMapNode<K, V> findNode(K key){
		return (rootNode != null) ? rootNode.findNode(key) : null;
	}
}
