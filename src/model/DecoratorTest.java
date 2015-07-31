package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Patricia Boutin on 31 juil. 2015.
 */
public class DecoratorTest {
    DinoAction attack;
    DinoAction flee;

    @Before
    public void setUp()
    {
        attack = new DinoAction("Attack", TypeAction.Atacktype, 5);
        flee = new DinoAction("Attack", TypeAction.Fleetype, 1);
    }

    @After
    public void tearDown()
    {
        attack = null;
    }

    @Test
    public void testDecoratorIncrease() {
        DinoAction newAction = new DecoratorIncrease(attack).modifyValueAction();
        assertTrue(newAction.getValue() >= 5 || newAction.getValue() <= 7);
        System.out.println("depart : " + attack.getValue() + "et fin : " + newAction.getValue());
    }

    @Test
    public void testDecoratorDecrease() {
        DinoAction newAction = new DecoratorDecrease(attack).modifyValueAction();
        assertTrue(newAction.getValue() >= 3 || newAction.getValue() <= 5);
        System.out.println("depart : " + attack.getValue() + "et fin : " + newAction.getValue());
    }

    @Test
    public void testDecoratorDouble() {
        DinoAction newAction = new DecoratorDouble(attack).modifyValueAction();
        assertTrue(newAction.getValue() == 10);
        System.out.println("depart : " + attack.getValue() + "et fin : " + newAction.getValue());
    }

    @Test
    public void testActionFlee() {
        DinoAction newAction = new DecoratorDouble(flee).modifyValueAction();
        assertTrue(newAction.getValue() == 1);
        System.out.println("depart : " + flee.getValue() + "et fin : " + newAction.getValue());
    }
}
