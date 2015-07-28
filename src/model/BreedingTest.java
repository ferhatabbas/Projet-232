package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patricia Boutin on 28 juil. 2015.
 */

public class BreedingTest {
    Dinosaure argentavis;
    Dinosaure azhdarchidea;
    Dinosaure stegosorus;
    Dinosaure triceraptaure;
    Dinosaure tyranosaure;
    Dinosaure velocyraptor;

    Dinosaure newDino;

    @Before
    public void setUp()
    {
        argentavis = DinoFactory.construct(Family.Argentavis);
        azhdarchidea = DinoFactory.construct(Family.Azhdarchidea);
        stegosorus = DinoFactory.construct(Family.Stegosorus);
        triceraptaure = DinoFactory.construct(Family.Triceraptaure);
        tyranosaure = DinoFactory.construct(Family.Tyranosaure);
        velocyraptor = DinoFactory.construct(Family.Velocyraptor);

        newDino = Breeding.newBreeding(triceraptaure, velocyraptor, "Rex");

    }

    @After
    public void tearDown()
    {
        argentavis = null;
        azhdarchidea = null;
        stegosorus = null;
        triceraptaure = null;
        tyranosaure = null;
        velocyraptor = null;
    }

    @Test
    public void testBreeding() {
        Dinosaure breedingDino = Breeding.newBreeding(stegosorus, tyranosaure, "Rex");

        assertEquals(breedingDino.getName(), "Rex");
    }
/*
    @Test
    public void testBreedingFamily() {
        assertEquals(newDino.getFamily(), triceraptaure.getFamily());
    }
*/
}
