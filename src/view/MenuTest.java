package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {

/**
 * Carole, Vahei
 */
	
	Menu test;
	
	@Test
	public void newGameTest() {
		test.createNewGame("ferhat");
		assertEquals("ferhat",test.getUsername());
		
	}

}
