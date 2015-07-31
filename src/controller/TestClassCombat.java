package controller;

import model.DinoAction;
import model.DinoFactory;
import model.Dinosaure;
import model.Family;
import model.TypeAction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
        Dinosaure target = listeCPU.get(0);
        target.setLifePoint(target.getLifePoint() - 2);
        combat.AdjustDinolist(listeCPU, target, false);
        assertEquals(listeCPU, oldListeCPU);
    }
    
    @Test
    public void testApplyStrenghtAction()
    {
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
    	Dinosaure target = listeCPU.get(0);
    	
    	DinoAction action = new DinoAction("testStrength", TypeAction.ImproveStrenghttype, 2);
        combat.ApplyStrenghtAction(action, target, false);
        
        assertEquals(listeCPU, oldListeCPU);
    }
    
    @Test
    public void testApplySpeedAction()
    {
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
    	Dinosaure target = listeCPU.get(0);
    	
    	DinoAction action = new DinoAction("testSpeed", TypeAction.ImproveSpeedtype, 2);
        combat.ApplySpeedAction(action, target, false);
        
        assertEquals(listeCPU, oldListeCPU);
    }
    
    @Test
    public void testApplyHealthAction()
    {
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
    	Dinosaure target = listeCPU.get(0);
    	
    	DinoAction action = new DinoAction("testHealth", TypeAction.Healttype, 2);
        combat.ApplyHealthAction(action, target, false);
        
        assertEquals(listeCPU, oldListeCPU);
    }
    
    @Test
    public void testApplyDefenseAction()
    {
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
    	Dinosaure target = listeCPU.get(0);
    	
    	DinoAction action = new DinoAction("testDefense", TypeAction.ImproveDefensetype, 2);
        combat.ApplyDefenseAction(action, target, false);
        
        assertEquals(listeCPU, oldListeCPU);
    }
    
    @Test
    public void testApplyAttackAction()
    {
    	ArrayList<Dinosaure> oldListeCPU = listeCPU;
    	Dinosaure target = listeCPU.get(0);
    	
    	DinoAction action = new DinoAction("testAttack", TypeAction.Atacktype, 1);
        combat.ApplyAttackAction(action, target, false);
        
        assertEquals(listeCPU, oldListeCPU);
    }
}
