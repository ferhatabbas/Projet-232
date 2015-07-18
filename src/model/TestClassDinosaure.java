package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClassDinosaure {
	
	Dinosaure dinosaure1;
	Dinosaure dinosaure2;

	
	@Before
	public void setUp()
	{
		dinosaure1 = new Dinosaure();
		dinosaure2 = new Dinosaure("Rex");
	}
	
	@After
	public void tearDown() 
	{
		
	}
	
	@Test
	public void testName() 
	{
		assertEquals(dinosaure2.getName(),"Rex");
	}
	
	@Test
	public void testLifePoint()
	{		
		int LifePoint_Dino = 25;
		dinosaure1.setLifePoint(LifePoint_Dino);
		assertEquals(dinosaure1.getLifePoint(),LifePoint_Dino);
	}
	
	@Test
	public void testLifePointRandom()
	{
		boolean condition = false;
		dinosaure1.setLifePoinRandom();
		if (dinosaure1.getLifePoint() >= dinosaure1.BASE_LIFEPOINT_DINO_MIN && dinosaure1.getLifePoint() <= dinosaure1.BASE_LIFEPOINT_DINO_MAX )
		{
			condition = true;
		}	
		assertTrue(condition);
			
	}
	
	@Test
	public void testStrenght() 
	{		
		int Strenght_Dino = 25;
		dinosaure1.setStrenght(Strenght_Dino);
		assertEquals(dinosaure1.getStrenght(),Strenght_Dino);
	}

	@Test
	public void testStrenghtRandom()
	{
		boolean condition = false;
		dinosaure1.setStrenghtRandom();
		if (dinosaure1.getStrenght() >= dinosaure1.BASE_STRENGHT_POINT_DINO_MIN && dinosaure1.getStrenght() <= dinosaure1.BASE_STRENGHT_POINT_DINO_MAX )
		{
			condition = true;
		}
		assertTrue(condition);

	}

	@Test
	public void testSpeed()
	{
		int Speed_Dino = 25;
		dinosaure1.setSpeed(Speed_Dino);
		assertEquals(dinosaure1.getSpeed(),Speed_Dino);
	}

	@Test
	public void testSpeedRandom()
	{
		boolean condition = false;
		dinosaure1.setSpeedRandom();
		if (dinosaure1.getSpeed() >= dinosaure1.BASE_SPEED_POINT_DINO_MIN && dinosaure1.getSpeed() <= dinosaure1.BASE_SPEED_POINT_DINO_MAX )
		{
			condition = true;
		}
		assertTrue(condition);

	}

	@Test
	public void testDefense()
	{
		int Defense_Dino = 25;
		dinosaure1.setDefense(Defense_Dino);
		assertEquals(dinosaure1.getDefense(),Defense_Dino);
	}

	@Test
	public void testDefenseRandom()
	{
		boolean condition = false;
		dinosaure1.setDefenseRandom();
		if (dinosaure1.getDefense() >= dinosaure1.BASE_DEFENSE_POINT_DINO_MIN && dinosaure1.getDefense() <= dinosaure1.BASE_DEFENSE_POINT_DINO_MAX )
		{
			condition = true;
		}
		assertTrue(condition);

	}

	@Test
	public void testxp()
	{
		int XP_Dino = 25;
		dinosaure1.setXp(XP_Dino);
		assertEquals(dinosaure1.getXp(),XP_Dino);
	}

	@Test
	public void testConstructor()
	{
		String name = "test";
		int Value = 5;
		Dinosaure dinosaure3 = new Dinosaure(name, Value, Value, Value, Value, Value, Value);
		assertEquals(dinosaure3.getDefense(),Value);
		assertEquals(dinosaure3.getLifePoint(),Value);
		assertEquals(dinosaure3.getName(),name);
		assertEquals(dinosaure3.getSpeed(),Value);
		assertEquals(dinosaure3.getStrenght(),Value);
		assertEquals(dinosaure3.getXp(),Value);

	}





}
