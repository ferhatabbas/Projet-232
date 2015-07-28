package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestClassDinausaure {

	Dinosaure argentavis;
	Dinosaure azhdarchidea;
	Dinosaure stegosorus;
	Dinosaure triceraptaure;
	Dinosaure tyranosaure;
	Dinosaure velocyraptor;

	
	@Before
	public void setUp()
	{
		argentavis = DinoFactory.construct(Family.Argentavis);
		azhdarchidea = DinoFactory.construct(Family.Azhdarchidea);
		stegosorus = DinoFactory.construct(Family.Stegosorus);
		triceraptaure = DinoFactory.construct(Family.Triceraptaure);
		tyranosaure = DinoFactory.construct(Family.Tyranosaure);
		velocyraptor = DinoFactory.construct(Family.Velocyraptor);
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
	public void testName() 
	{
		String name_Dino = "Rex";
		argentavis.setName(name_Dino);
		assertEquals(argentavis.getName(), name_Dino);
	}
	
	@Test
	public void testLifePoint() 
	{		
		int LifePoint_Dino = 25;
		argentavis.setLifePoint(LifePoint_Dino);
		assertEquals(argentavis.getLifePoint(), LifePoint_Dino);
	}
	
	@Test
	public void testLifePointRandom() 
	{
		boolean condition = false;
		argentavis.setLifePointRandom();
		if (argentavis.getLifePoint() >= argentavis.BASE_LIFEPOINT_DINO_MIN && argentavis.getLifePoint() <= argentavis.BASE_LIFEPOINT_DINO_MAX )
		{
			condition = true;
		}	
		assertTrue(condition);
			
	}
	
	@Test
	public void testStrenght() 
	{		
		int Strenght_Dino = 25;
		argentavis.setStrenght(Strenght_Dino);
		assertEquals(argentavis.getStrenght(), Strenght_Dino);
	}
	
	@Test
	public void testStrenghtRandom() 
	{
		boolean condition = false;
		argentavis.setStrenghtRandom();
		if (argentavis.getStrenght() >= argentavis.BASE_STRENGHT_POINT_DINO_MIN && argentavis.getStrenght() <= argentavis.BASE_STRENGHT_POINT_DINO_MAX )
		{
			condition = true;
		}	
		assertTrue(condition);
			
	}
	
	@Test
	public void testSpeed() 
	{		
		int Speed_Dino = 25;
		argentavis.setSpeed(Speed_Dino);
		assertEquals(argentavis.getSpeed(), Speed_Dino);
	}
	
	@Test
	public void testSpeedRandom() 
	{
		boolean condition = false;
		argentavis.setSpeedRandom();
		if (argentavis.getSpeed() >= argentavis.BASE_SPEED_POINT_DINO_MIN && argentavis.getSpeed() <= argentavis.BASE_SPEED_POINT_DINO_MAX )
		{
			condition = true;
		}	
		assertTrue(condition);
			
	}
	
	@Test
	public void testDefense() 
	{		
		int Defense_Dino = 25;
		argentavis.setDefense(Defense_Dino);
		assertEquals(argentavis.getDefense(), Defense_Dino);
	}
	
	@Test
	public void testDefenseRandom() 
	{
		boolean condition = false;
		argentavis.setDefenseRandom();
		if (argentavis.getDefense() >= argentavis.BASE_DEFENSE_POINT_DINO_MIN && argentavis.getDefense() <= argentavis.BASE_DEFENSE_POINT_DINO_MAX )
		{
			condition = true;
		}	
		assertTrue(condition);
			
	}
	
	@Test
	public void testxp() 
	{		
		int XP_Dino = 25;
		argentavis.setXp(XP_Dino);
		assertEquals(argentavis.getXp(), XP_Dino);
	}
	
	
	@Test
	public void testType() 
	{		
		TypeDinosaure Type_Dino = TypeDinosaure.Flying;
		argentavis.setType(Type_Dino);
		assertEquals(argentavis.getType(),Type_Dino);
	}
	
	@Test
	public void testFamily() 
	{
		Family Family_Dino = Family.Argentavis;
		argentavis.setFamily(Family_Dino);
		assertEquals(argentavis.getFamily(),Family_Dino);
	}

	@Test
	public void testAttackList()
	{
		ArrayList<Attack> liste = new ArrayList<>();
		argentavis.setAttackList(liste);
		assertEquals(argentavis.AttackList,liste);
	}

    @Test
    public void testAttackListAddAndRemove()
    {
        Attack attack = new Attack("tst", TypeAttack.Attacktype, 5);
        ArrayList<Attack> liste = new ArrayList<>();
        liste.add(attack);
        argentavis.addAttack(attack);
        assertEquals(argentavis.getAttackList(), liste);
        liste.remove(attack);
        argentavis.removeAttack(attack);
        assertEquals(argentavis.getAttackList(), liste);
    }
	
	@Test
	public void testConstructor() 
	{	
		String name = "test";
		int Value = 5;
		TypeDinosaure type = TypeDinosaure.Biped;
		Family family = Family.Velocyraptor;
		ArrayList<Attack> liste = new ArrayList<>();
		Dinosaure dinosaure3 = DinoFactory.construct(name, Value, Value, Value,Value,Value, family, liste);
		assertEquals(dinosaure3.getDefense(),Value);		
		assertEquals(dinosaure3.getLifePoint(),Value);	
		assertEquals(dinosaure3.getName(),name);	
		assertEquals(dinosaure3.getSpeed(),Value);
		assertEquals(dinosaure3.getStrenght(),Value);
		assertEquals(dinosaure3.getXp(),Value);
		assertEquals(dinosaure3.getType(),type);
		assertEquals(dinosaure3.getFamily(),family);
		
	}
	
	
	


}
