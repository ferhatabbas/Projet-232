package controller;

import model.DinoFactory;
import model.Dinosaure;
import model.Family;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Philippe on 2015-07-30.
 */
public class TestClassCombat {

    Dinosaure argentavis;
    Dinosaure azhdarchidea;
    Dinosaure stegosorus;
    Dinosaure triceraptaure;
    Dinosaure tyranosaure;
    Dinosaure velocyraptor;
    CombatScriptController controller;
    Combat combat;

    ArrayList<Dinosaure> listeUser;
    ArrayList<Dinosaure> listeCPU;

    @Before
    public void setUp()
    {
        argentavis = DinoFactory.construct(Family.Argentavis);
        azhdarchidea = DinoFactory.construct(Family.Azhdarchidea);
        stegosorus = DinoFactory.construct(Family.Stegosorus);
        triceraptaure = DinoFactory.construct(Family.Triceraptaure);
        tyranosaure = DinoFactory.construct(Family.Tyranosaure);
        velocyraptor = DinoFactory.construct(Family.Velocyraptor);

        listeCPU = new  ArrayList<Dinosaure>();
        listeUser = new ArrayList<Dinosaure>();

        listeUser.add(argentavis);
        listeUser.add(azhdarchidea);
        listeUser.add(stegosorus);
        listeCPU.add(triceraptaure);
        listeCPU.add(tyranosaure);
        listeCPU.add(velocyraptor);
        controller = new CombatScriptController(listeUser, listeCPU);
        combat = new Combat(listeUser, listeCPU);
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
        listeUser = null;
        listeCPU = null;
    }

    @Test
    public void testRandomBool()
    {
        boolean value = combat.getRandomBoolean(1);
        System.out.println(value);
    }

    @Test
    public void testAdjustDinolist()
    {
        Dinosaure bob = listeCPU.get(0);
        int value = bob.getLifePoint() - 2;
        combat.AdjustDinolist(listeCPU, bob, true);
    }
}
