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

    Dinosaure dinoIncrease;
    Dinosaure dinoDecrease;
    Dinosaure dinoDouble;

    @Before
    public void setUp()
    {
        attack = new DinoAction("Attack", TypeAction.Atacktype, 5);
        flee = new DinoAction("Flee", TypeAction.Fleetype, 1);

        dinoIncrease = DinoFactory.construct(Family.Velocyraptor);
        dinoIncrease = new DecoratorIncrease(dinoIncrease);

        dinoDecrease = DinoFactory.construct(Family.Velocyraptor);
        dinoDecrease = new DecoratorDecrease(dinoDecrease);

        dinoDouble = DinoFactory.construct(Family.Velocyraptor);
        dinoDouble = new DecoratorDouble(dinoDouble);
    }

    @After
    public void tearDown()
    {
        attack = null;
        flee = null;

        dinoIncrease = null;
        dinoDecrease = null;
        dinoDouble = null;
    }

    @Test
    public void testDecoratorIncrease() {
        System.out.println("Increse : depart = " + attack.getValue());
        dinoIncrease.addAttack(attack);
        DinoAction newAction = dinoIncrease.getAttack("Attack");
        assertTrue(newAction.getValue() >= 5 || newAction.getValue() <= 7);
        System.out.println(" et fin = " + newAction.getValue());
    }

    @Test
    public void testDecoratorDecrease() {
        System.out.println("Decrease : depart = " + attack.getValue());
        dinoDecrease.addAttack(attack);
        DinoAction newAction = dinoDecrease.getAttack("Attack");
        assertTrue(newAction.getValue() >= 3 || newAction.getValue() <= 5);
        System.out.println(" et fin = " + newAction.getValue());
    }

    @Test
    public void testDecoratorDouble() {
        System.out.println("Double : depart = " + attack.getValue());
        dinoDouble.addAttack(attack);
        DinoAction newAction = dinoDouble.getAttack("Attack");
        assertTrue(newAction.getValue() == 5 || newAction.getValue() == 10);
        System.out.println(" et fin = " + newAction.getValue());
    }

    @Test
    public void testActionFlee() {
        System.out.println("Flee Increase : depart = " + flee.getValue());
        dinoIncrease.addAttack(flee);
        DinoAction actionIncrease = dinoIncrease.getAttack(flee.getActionName());
        assertTrue(actionIncrease.getValue() == 1);
        System.out.println(" et fin = " + actionIncrease.getValue());

        System.out.println("Flee Increase : depart = " + flee.getValue());
        dinoDecrease.addAttack(flee);
        DinoAction actionDecrease = dinoDecrease.getAttack(flee.getActionName());
        assertTrue(actionDecrease.getValue() == 1);
        System.out.println(" et fin = " + actionDecrease.getValue());

        System.out.println("Flee Increase : depart = " + flee.getValue());
        dinoDouble.addAttack(flee);
        DinoAction actionDouble = dinoDouble.getAttack(flee.getActionName());
        assertTrue(actionDouble.getValue() == 1);
        System.out.println(" et fin = " + actionDouble.getValue());
    }
}
