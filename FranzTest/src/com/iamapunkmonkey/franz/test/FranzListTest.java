package com.iamapunkmonkey.franz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iamapunkmonkey.franz.framework.util.FranzList;

public class FranzListTest {

	@Test
	public void testFranzList() {
		
	}

	@Test
	public void testSize() {
		FranzList<Integer> ll = new FranzList<Integer>();
		
		for(int i = 0; i < 10; i++)
			ll.insert(i);
		
		assertEquals(10, ll.size());
		ll.print();
		
		Integer v = ll.remove(0);
		System.out.println("Removed: " + v);
		ll.print();
		assertEquals(9, ll.size());
	}

	@Test
	public void testPrint() {
		FranzList<Integer> ll = new FranzList<Integer>();
		
		for(int i = 0; i < 10; i++)
			ll.insert(i);
		
		//assertEquals(" 0 1 2 3 4 5 6 7 8 9", ll.print());
		assertEquals(" 0 1 2 3 4 5 6 7 8 9".toString(), ll.print());
		
		ll.remove(0);
		assertEquals(" 1 2 3 4 5 6 7 8 9".toString(), ll.print());
		
		ll.remove(5);
		assertEquals(" 1 2 3 4 5 6 8 9".toString(), ll.print());
				
	}
	
	@Test
	public void testPrint2(){
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");
		
		assertEquals(" A B C D E F G H I".toString(), ll.print());
		
		ll.remove(0);
		assertEquals(" B C D E F G H I".toString(), ll.print());
		
		ll.remove("F");
		assertEquals(" B C D E G H I".toString(), ll.print());

	}

	@Test
	public void testInsertV() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("H");
		ll.insert("G");
		ll.insert("I");
		
		assertEquals(" A B C D E F H G I".toString(), ll.print());
	}

	@Test
	public void testInsertIntV() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert(0, "A");
		ll.insert(1, "B");
		ll.insert(2, "C");
		ll.insert(3, "D");
		ll.insert(4, "E");
		ll.insert(1, "F");
		ll.insert(3, "H");
		ll.insert(2, "G");
		ll.insert(6, "I");
		
		assertEquals(" A F G B H C I D E".toString(), ll.print());
	}

	@Test
	public void testGetInt() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");

		assertEquals("G", ll.get(6));
	}

	@Test
	public void testGetV() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");

		assertEquals(3, ll.get("D"));
	}

	@Test
	public void testIndexOf() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");
		
		assertEquals(3, ll.indexOf("D"));
	}

	@Test
	public void testRemoveInt() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");
		
		ll.remove(0);
		assertEquals(" B C D E F G H I".toString(), ll.print());
	}

	@Test
	public void testRemoveV() {
		FranzList<String> ll = new FranzList<String>();
		
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");
		
		ll.remove("F");
		assertEquals(" A B C D E G H I".toString(), ll.print());
	}

}
