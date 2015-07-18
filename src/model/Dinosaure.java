package model;
import java.util.Random;

public class Dinosaure {
	
	public String name;
	public int lifePoint;
	public int strenght;
	public int speed;
	public int defense;
	public int xp;
	
	final int BASE_LIFEPOINT_DINO_MIN = 10;
	final int BASE_LIFEPOINT_DINO_MAX = 16;
	final int BASE_STRENGHT_POINT_DINO_MAX = 7;
	final int BASE_STRENGHT_POINT_DINO_MIN = 3;
	final int BASE_SPEED_POINT_DINO_MAX = 6;
	final int BASE_SPEED_POINT_DINO_MIN = 2;
	final int BASE_DEFENSE_POINT_DINO_MAX = 8;
	final int BASE_DEFENSE_POINT_DINO_MIN = 4;
	
	
	public Dinosaure()
	{
		setLifePoinRandom();
		setStrenghtRandom();
		setSpeedRandom();
		setDefenseRandom();
	}
	
	public Dinosaure(String name)
	{
		setName(name);
		setLifePoinRandom();
		setStrenghtRandom();
		setSpeedRandom();
		setDefenseRandom();
	}
	
	public Dinosaure(String name, int dinosaureID, int lifePoint, int strenght, int speed, int defense, int xp)
	{
		setName(name);
		setLifePoint(lifePoint);
		setStrenght(strenght);
		setSpeed(speed);
		setDefense(defense);
		setXp(xp);
	}
	
	void setDefenseRandom() 
	{		
		setDefense(Random(BASE_DEFENSE_POINT_DINO_MIN, BASE_DEFENSE_POINT_DINO_MAX));
	}

	void setSpeedRandom() 
	{
		setSpeed(Random(BASE_SPEED_POINT_DINO_MIN, BASE_SPEED_POINT_DINO_MAX));
	}

	void setStrenghtRandom() 
	{
		setStrenght(Random(BASE_STRENGHT_POINT_DINO_MIN, BASE_STRENGHT_POINT_DINO_MAX));
	}

	void setLifePoinRandom() 
	{
		setLifePoint(Random(BASE_LIFEPOINT_DINO_MIN, BASE_LIFEPOINT_DINO_MAX));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	
	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int Random(int Low, int High){
		Random r = new Random();
		int R = r.nextInt((High - Low) + 1) + Low;
		return R;
	}
	
	
	/*
	public boolean equals(Object otherDinosaure)
	{
		if (otherDinosaure instanceof Dinosaure)
		{
			Dinosaure dinosaure = (Dinosaure) otherDinosaure;
			return dinosaureID == dinosaure.getDinosaureID() && 
					AttributesList.equals(dinosaure.getListeAttribute());
		}
		else
		{
			return false;
		}
	}
	*/
}
