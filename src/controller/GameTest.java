package controller;

import model.Dinosaure;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class GameTest {

    Game myGame;
    final String USERNAME = "ALEX";

    @Before
    public void setup()
    {
        myGame = new Game();
        myGame.initialize(USERNAME);
    }

    @Test
    public void testUsername(){
        assertEquals(myGame.get_userName(), USERNAME);
    }

    @Test
    public void testAddDino()
    {
        myGame.createDino("Rex", "Tyranosaure");

        Dinosaure d = myGame.getDino("Rex");
        assertNotNull(d);
    }

    @Test
    public void testAddMultipleDino() throws Exception {
        assertTrue(myGame.createDino("Rex", "Tyranosaure"));
        assertFalse(myGame.createDino("Rex", "Tyranosaure"));
    }

    @Test
    public void testListOfDinos(){
        myGame.createDino("Rex", "Tyranosaure");

        ArrayList<String> names = myGame.getListOfDinos();
        assertTrue(names.size() == 1);
        assertTrue(names.get(0) == "Rex");
    }
}
