package dinosaures;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClassDinausaure {
	/*
	@Before
	public void setUp()
	{
		Dinosaure dinosaure1 = new Dinosaure();
		Dinosaure dinosaure2 = new Dinosaure(1);
		
	}
	
	@After
	public void teaarDown() 
	{
		
	}
	*/

	
	@Test
	public void testSetId() {
		
		Dinosaure dinosaure1 = new Dinosaure();
		dinosaure1.setDinosaureID(2);
		assertTrue(dinosaure1.getDinosaureID() == 2);

	}
	
	@Test
	public void test_name() {
		
		String name_Dino = "Rex";		
		Dinosaure dinosaure1 = new Dinosaure();

		dinosaure1.setAttributlist("name", name_Dino);
		String result = (String)dinosaure1.getAttribute("name");
		assertEquals(result,name_Dino);
		
	}
	
	@Test
	public void testCreate() {
		
		Dinosaure dinosaure1 = new Dinosaure();
		Dinosaure dinosaure2 = new Dinosaure(1);
		assertFalse(dinosaure1.equals(dinosaure2));

	}
	
	@Test
	public void testHashMap() {
		
		Dinosaure dinosaure1 = new Dinosaure(0);
		dinosaure1.setAttributlist("name", "Rex");
		
		Dinosaure dinosaure2 = new Dinosaure(1);
		dinosaure1.setAttributlist("name", "Theo");

		assertFalse(dinosaure1.getListeAttribute().equals(dinosaure2.getListeAttribute()));
	}
	

}
