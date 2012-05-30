package com.iamapunkmonkey.franz.framework.util;

public class FranzMapNode<K, V> {
	private K key;
	private FranzMapNode<K, V> parent;
	private FranzMapNode<K, V> child;
	private FranzMapNode<K, V> sibling;
	private V value;

	FranzMapNode(K key, V value)
	{
		create(key);
		this.setValue(value);
	}

	public void create(K _key)
	{
		this.key = _key;
		parent = null;
		child = null;
		sibling = null;
	}

	public void destroy()
	{
		key = null;
		parent = null;
		child = null;
		sibling = null;
	}

	public void insertChild(K key, V value){
		FranzMapNode<K, V> node = new FranzMapNode<K, V>(key, value);
		this.insertChild(node);
	}

	private void insertChild(FranzMapNode<K, V> node)
	{
		if(child == null){
			child = node;
			child.setParent(this);
		} else {
			node.setParent(this);
			child.setSibling(node);
		}
	}

	public void removeChild()
	{
		if(child != null){
			child.removeSibling();
			child.removeChild();
			child.destroy();
			child = null;
		}
	}
	
	public void removeChild(K key){
		if(child != null && child.key.equals(key)){
			removeChild();
		} else {
			removeSibling(key);
			if(child != null)
				child.removeChild(key);
		}
	}
	
	public FranzMapNode<K, V> findNode(K key){
		if(this.key.equals(key)) {
			return this;
		} else {
			if(child != null && child.key.equals(key)){
				return child;
			} else {
				if(sibling != null){
					FranzMapNode<K, V> s = sibling.findNode(key);
					if(s != null)
						return s;
				}
				if(child != null) {
					FranzMapNode<K, V> c = child.findNode(key);
					if(c != null)
						return c;
				}
			}
		}
		return null;
	}

	public FranzMapNode<K, V> getChild()
	{
		return child;
	}

	public FranzMapNode<K, V> getSibling()
	{
		return sibling;
	}

	public void setSibling(FranzMapNode<K, V> node)
	{
		if(sibling == null)
			sibling = node;
		else
			sibling.setSibling(node);
	}

	public void removeSibling()
	{
		if(sibling != null){
			sibling.removeChild();
			FranzMapNode<K, V> temp = sibling.sibling;
			sibling.removeSibling();
			sibling.destroy();
			sibling = temp;
		}
	}

	public void removeSibling(K key)
	{
		if(sibling != null && sibling.key.equals(key)){
			sibling.removeChild();
			FranzMapNode<K, V> temp = sibling.sibling;
			sibling.destroy();
			sibling = temp;
		} else {
			if(sibling != null)
				sibling.removeSibling(key);
			if(child != null)
				child.removeChild(key);
		}
	}

	public void setParent(FranzMapNode<K, V> node)
	{
		this.parent = node;
	}

	public FranzMapNode<K, V> getParent()
	{
		return parent;
	}

	public V getValue()
	{
		return value;
	}

	public void setValue(V value)
	{
		this.value = value;
	}

	public K getKey(){
		return key;
	}
}