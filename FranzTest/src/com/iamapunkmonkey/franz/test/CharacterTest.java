package com.iamapunkmonkey.franz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iamapunkmonkey.franz.framework.Character;
import com.iamapunkmonkey.franz.framework.NPC;
import com.iamapunkmonkey.franz.framework.structure.IEntityEventListener;

public class CharacterTest {

	@Test
	public void testCharacter() {
		
	}

	@Test
	public void testAddChild() {
		NPC bob = new NPC();
		NPC frank = new NPC();
		
		NPC mother = new NPC();
		
		mother.addChild("bob", bob);
		mother.addChild("frank", frank);
		
		assertEquals(bob, mother.getChild("bob"));
		assertEquals(frank, mother.getChild("frank"));
	}

	@Test
	public void testGetChild() {
		NPC bob = new NPC();
		NPC frank = new NPC();
		
		NPC mother = new NPC();
		
		mother.addChild("bob", bob);
		mother.addChild("frank", frank);
		
		assertEquals(frank, mother.getChild("frank"));
		assertEquals(bob, mother.getChild("bob"));
	}

	@Test
	public void testGetHealth() {
		NPC bob = new NPC();
		bob.setHealth(100);
		
		assertEquals(100, bob.getHealth());
	}

	@Test
	public void testSetHealth() {
		NPC bob = new NPC();
		bob.setHealth(100);
		
		assertEquals(100, bob.getHealth());
		
		bob.setHealth(32);
		assertEquals(32, bob.getHealth());
	}

	@Test
	public void testAddHealth() {
		NPC bob = new NPC();
		bob.setHealth(100);
		
		assertEquals(100, bob.getHealth());
		
		bob.addHealth(22);
		assertEquals(122, bob.getHealth());
	}

	@Test
	public void testRemoveHealth() {
		NPC bob = new NPC();
		bob.setHealth(100);
		
		assertEquals(100, bob.getHealth());
		
		bob.removeHealth(22);
		assertEquals(78, bob.getHealth());
	}

	@Test
	public void testAddEventListener() {
		IEntityEventListener temp = new IEntityEventListener() {
			
			@Override
			public void onEventPorcess() {
				// TODO Auto-generated method stub
				
			}
		};
		
		NPC bob = new NPC();
		
		bob.addEventListener("temp", temp);
		
		assertEquals(temp, bob.getEventListener("temp"));
	}

	@Test
	public void testGetEventListener() {
		IEntityEventListener temp = new IEntityEventListener() {
			
			@Override
			public void onEventPorcess() {
				// TODO Auto-generated method stub
				
			}
		};
		
		IEntityEventListener temp2 = new IEntityEventListener() {
			
			@Override
			public void onEventPorcess() {
				// TODO Auto-generated method stub
				
			}
		};
		
		NPC bob = new NPC();
		
		bob.addEventListener("temp", temp);
		bob.addEventListener("temp2", temp2);
		
		assertEquals(temp2, bob.getEventListener("temp2"));
		assertEquals(temp, bob.getEventListener("temp"));
		
		bob.addEventListener("temp", temp2);
		assertEquals(temp2, bob.getEventListener("temp"));
	}
}
