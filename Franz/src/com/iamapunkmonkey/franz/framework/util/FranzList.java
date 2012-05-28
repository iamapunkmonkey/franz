package com.iamapunkmonkey.franz.framework.util;

public class FranzList<V> {
	
	private FranzNode<V> head = null;
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
		for(int i = 0; i < index; i++)
			temp = temp.next;
		return temp.element;
	}
	
	public int get(V elem){
		return indexOf(elem);
	}
	
	public int indexOf(V elem){
		temp = head;
		int i = 0;
		
		for(; !(temp.element).equals(elem) && temp != null; i++)
			temp = temp.next;
		
		return (i == size()) ? -1 : i;
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
	
/*	FranzNode<V> header;
	
	public FranzList(){
		header = new FranzNode<V>(null);
	}
	
	public boolean isEmpty(){
		return header.next == null;
	}
	
	public void makeEmpty(){
		header.next = null;
	}
	
	public FranzListIterator<V> zeroth(){
		return new FranzListIterator<>(header);
	}
	
	public FranzListIterator<V> first(){
		return new FranzListIterator<>(header.next);
	}
	
	public void insert(V x, FranzListIterator<V> p){
		if(p != null && p.current != null)
			p.current.next = new FranzNode<V>(x, p.current.next);
	}
	
	public FranzListIterator<V> find(V x){
		FranzNode<V> itr = header.next;
		
		while(itr != null && !itr.element.equals(x))
			itr = itr.next;
		
		return new FranzListIterator<>(itr);
	}
	
	public FranzListIterator<V> findPrevious(V x){
		FranzNode<V> itr = header;
		
		while(itr.next != null && !itr.next.element.equals(x))
			itr = itr.next;
		
		return new FranzListIterator<>(itr);
	}
	
	public void remove(V x){
		FranzListIterator<V> p = findPrevious(x);
		
		if(p.current.next != null)
			p.current.next = p.current.next.next;
	}*/
}
