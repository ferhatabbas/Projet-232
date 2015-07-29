package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patricia Boutin on 28 juil. 2015.
 */

public class BreedingTest {
    Dinosaure stegosorus;
    Dinosaure velocyraptor;

    Dinosaure newDino;

    @Before
    public void setUp()
    {
        stegosorus = DinoFactory.construct(Family.Stegosorus);
        velocyraptor = DinoFactory.construct(Family.Velocyraptor);

        newDino = Breeding.newBreeding(stegosorus, velocyraptor, "Rex");
    }

    @After
    public void tearDown()
    {
        stegosorus = null;
        velocyraptor = null;
        newDino = null;
    }

    @Test
    public void testBreeding() {
        Dinosaure breedingDino = Breeding.newBreeding(stegosorus, velocyraptor, "Dino");

        assertEquals(breedingDino.getName(), "Dino");
    }

    @Test
    public void testBreedingFamily() {
        assertTrue(newDino.getFamily() == stegosorus.getFamily()
                || newDino.getFamily() == velocyraptor.getFamily());
    }

    @Test
    public void testBreedingType() {
        assertTrue(newDino.getType() == stegosorus.getType()
                || newDino.getType() == velocyraptor.getType());
    }


    @Test
    public void testBreedingDefense() {
        System.out.println("Defense : newDino = " + newDino.getDefense()
                + ", stegosorus = " + stegosorus.getDefense()
                + ", velocyraptor = " + velocyraptor.getDefense());
        if(stegosorus.getDefense() <= velocyraptor.getDefense()) {
            assertTrue(newDino.getDefense() >= stegosorus.getDefense()
                    && newDino.getDefense() <= velocyraptor.getDefense());
        }
        else {
            assertTrue(newDino.getDefense() >= velocyraptor.getDefense()
                    && newDino.getDefense() <= stegosorus.getDefense());
        }
    }

    @Test
    public void testBreedingSpeed() {
        System.out.println("Speed : newDino = " + newDino.getSpeed()
                + ", stegosorus = " + stegosorus.getSpeed()
                + ", velocyraptor = " + velocyraptor.getSpeed());
        if(stegosorus.getSpeed() <= velocyraptor.getSpeed()) {
            assertTrue(newDino.getSpeed() >= stegosorus.getSpeed()
                    && newDino.getSpeed() <= velocyraptor.getSpeed());
        }
        else {
            assertTrue(newDino.getSpeed() >= velocyraptor.getSpeed()
                    && newDino.getSpeed() <= stegosorus.getSpeed());
        }
    }

    @Test
    public void testBreedingStrenght() {
        System.out.println("Strength : newDino = " + newDino.getStrenght()
                + ", stegosorus = " + stegosorus.getStrenght()
                + ", velocyraptor = " + velocyraptor.getStrenght());
        if(stegosorus.getStrenght() <= velocyraptor.getStrenght()) {
            assertTrue(newDino.getStrenght() >= stegosorus.getStrenght()
                    && newDino.getStrenght() <= velocyraptor.getStrenght());
        }
        else {
            assertTrue(newDino.getStrenght() >= velocyraptor.getStrenght()
                    && newDino.getStrenght() <= stegosorus.getStrenght());
        }
    }

    @Test
    public void testBreedingLifePoint() {
        System.out.println("LifePoint : newDino = " + newDino.getLifePoint()
                + ", stegosorus = " + stegosorus.getLifePoint()
                + ", velocyraptor = " + velocyraptor.getLifePoint());
        if(stegosorus.getLifePoint() <= velocyraptor.getLifePoint()) {
            assertTrue(newDino.getLifePoint() >= stegosorus.getLifePoint()
                    && newDino.getLifePoint() <= velocyraptor.getLifePoint());
        }
        else {
            assertTrue(newDino.getLifePoint() >= velocyraptor.getLifePoint()
                    && newDino.getLifePoint() <= stegosorus.getLifePoint());
        }
    }

    @Test
    public void testBreedingFeatureList() {
        for(Feature f : newDino.getFeatureList()) {
            assertTrue(stegosorus.getFeatureList().contains(f)
                    || velocyraptor.getFeatureList().contains(f));

            System.out.println("Feature "+ f.toString());
        }
    }

}
