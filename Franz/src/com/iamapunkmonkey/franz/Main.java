package com.iamapunkmonkey.franz;

import com.iamapunkmonkey.franz.framework.util.FranzList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FranzList<Integer> ll = new FranzList<Integer>();
		
		for(int i = 0; i < 10; i++)
			ll.insert(i);
		
		assert(ll.size() == 10);
		System.out.println(ll.print());
		
		Integer v = ll.remove(0);
		System.out.println("Removed: " + v);
		System.out.println(ll.print());
		assert(ll.size() == 9);
	}

}
