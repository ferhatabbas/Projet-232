package controller;

import static org.junit.Assert.*;
import model.Dinosaure;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.annotation.ExceptionProxy;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class GameTest {

    Game myGame;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        Dinosaure firstDino = new Dinosaure("Rex");
        try {
            myGame.addDino(firstDino);
        }catch (Exception e){
            fail();
        }
        Dinosaure secondDino = myGame.getDino("Rex");
        assertEquals(firstDino, secondDino);
    }

    @Test
    public void testAddMultipleDino() throws Exception {
        Dinosaure firstDino = new Dinosaure("Rex");
        Dinosaure secondDino = new Dinosaure("Rex");

        try{
            myGame.addDino(firstDino);
        }catch (Exception e){
            fail();
        }

        exception.expect(Exception.class);
        myGame.addDino(secondDino);

    }
}
