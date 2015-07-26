package view;

import static org.junit.Assert.assertEquals;
import model.Dinosaure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Game;

public class MenuTest {

/**
 * Carole, Vahei
 */
	
	Menu test;
	Game game;
	Dinosaure dino;
	
	@Before
	public void setUp()
	{
		test = new Menu();
		game = new Game();
	}
	
	@After
	public void tearDown() 
	{
		test = null;
		game = null;
	}
	
	@Test
	public void newGameTest() {
		test.createNewGame("ferhat");
		assertEquals("ferhat",game.getUserName());	
	}

	@Test
	public void loadGameTest() {
		test.loadGame("Alexandre Landry");
		//TODO	
	}
	
	@Test
	public void createNewDinoTest() {
		test.createNewGame("carole");
		test.createNewDino("rex");
		assertEquals("rex",dino.getName());
	}
}
