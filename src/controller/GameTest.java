package controller;

import static org.junit.Assert.*;
import model.Dinosaure;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.annotation.ExceptionProxy;

import java.util.ArrayList;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class GameTest {

    Game myGame;

    @Before
    public void setup()
    {
        myGame = new Game();
        myGame.setUserName("Alexandre");
    }

    @Test
    public void testUsername(){
        assertEquals(myGame.getUserName(), "Alexandre");
    }

    @Test
    public void testAddDino()
    {
        myGame.createDino("Rex");

        Dinosaure d = myGame.getDino("Rex");
        assertNotNull(d);
    }

    @Test
    public void testAddMultipleDino() throws Exception {
        assertTrue(myGame.createDino("Rex"));
        assertFalse(myGame.createDino("Rex"));
    }

    @Test
    public void testListOfDinos(){
        myGame.createDino("Rex");

        ArrayList<String> names = myGame.getListOfDinos();
        assertTrue(names.size() == 1);
        assertTrue(names.get(0) == "Rex");
    }
}
