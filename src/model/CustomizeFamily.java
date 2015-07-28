package model;

import java.util.ArrayList;

public class CustomizeFamily extends Dinosaure{
	
	public CustomizeFamily() {
		super();
		setType(null);
		setFamily(null);
	}
	
	public CustomizeFamily(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, Family family, TypeDinosaure type, ArrayList<Attack> ListeAttack) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack);
		setType(type);
		setFamily(family);
	}
	
	@Override
	public void construct() {
		// TODO Auto-generated method stub
		
	}

}
