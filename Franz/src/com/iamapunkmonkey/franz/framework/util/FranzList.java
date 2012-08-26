package com.iamapunkmonkey.franz.framework.util;

public class FranzList<V> {
	
	public FranzNode<V> head = null;
	private FranzNode<V> tail = null;
	private FranzNode<V> temp = null;
	
	private int counter = 0;
	public FranzList(){
		
	}
	
	public int size(){
		return counter;
	}
	
	public String print(){
		String out = "";
		for(FranzNode<V> n = head; n != null; n = n.next)
			out += " " + n.element.toString();
		return out;
	}
	
	public void insert(V elem){
		if(head == null){
			head = new FranzNode<V>(elem);
			tail = head;
			head.next = tail;
		} else {
			tail.next = new FranzNode<V>(elem);
			tail = tail.next;
		}
		counter++;
	}
	
	public void insert(int index, V elem){
		if(index == size()){
			insert(elem);
			return;
		} else if(index == 0) {
			FranzNode<V> temp = new FranzNode<V>(elem);
			temp.next = head;
			head.previous = temp;
			head = temp;
			counter++;
			return;
		} 
		
		temp = head;
		for(int i = 0; i < index - 1; i++)
			temp = temp.next;
		
		FranzNode<V> myNode = new FranzNode<V>(elem);
		myNode.next = temp.next;
		temp.next = myNode;
		counter++;
	}
	
	public V get(int index){
		
		temp = head;
		//for(int i = 0; i < index; i++)
		//	temp = temp.next;
		return get(0, temp, index).element;
	}
	
	private FranzNode<V> get(int i, FranzNode<V> t, int index){
		if(index == i)
			return t;
		
		return get(i + 1, t.next, index);
	}
	
	public int get(V elem){
		return indexOf(elem);
	}
	
	public int indexOf(V elem){
		temp = head;
		int i = 0;
		
		//for(; !(temp.element).equals(elem) && temp != null; i++)
		//	temp = temp.next;
		
		//return (i == size()) ? -1 : i;
		return indexOf(i, temp, elem);
	}
	
	private int indexOf(int i, FranzNode<V> t, V elem){
		if(t == null)
			return -1;
		
		if(t.element.equals(elem))
			return i;
		
		return indexOf(i + 1, t.next, elem);
	}
	
	public V remove(int index){
		assert(index >= 0 && index < size());
		
		temp = head;
		
		if(index == 0){
			V elem = head.element;
			head = head.next;
			counter--;
			return elem;
		} else if(index == size()){
			V elem = tail.element;
			tail = tail.previous;
			counter--;
			return elem;
		}
		
		for(int i = 0; i < index; i++)
			temp = temp.next;
		
		FranzNode<V> two = temp.next;
		
		temp.next = two.next;
		V elem = two.element;
		two = null;
		counter--;
		return elem;
	}
	
	public V remove(V elem){
		temp = head;
		FranzNode<V> two = null;
		
		if(head.element.equals(elem)){
			head = head.next;
			head.previous = null;
			counter--;
			return elem;
		} else if(tail.element.equals(elem)){
			tail = tail.previous;
			tail.next = null;
			counter--;
			return elem;
		}
		
		while(temp != null && !temp.element.equals(elem)){
			two = temp;
			temp = temp.next;
		}
		
		if(temp == null) 
			return null;
		
		two.next = temp.next;
		
		V spare = temp.element;
		temp = null;
		counter--;
		return spare;
	}
}
