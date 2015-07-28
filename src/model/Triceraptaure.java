package model;

import java.util.ArrayList;

public class Triceraptaure extends Dinosaure {

	public Triceraptaure() {
		super();
		setType(TypeDinosaure.Quadriped);
		setFamily(Family.Triceraptaure);
		construct();
	}
	
	public Triceraptaure(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<Attack> ListeAttack) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack);
		setType(TypeDinosaure.Quadriped);
		setFamily(Family.Triceraptaure);
	}
	
	@Override
	public void construct() {
		setSpeed(speed - 2);
		setStrenght(strenght + 2);
		setDefense(defense + 1);
		
		featureList.add(Feature.Durability);
		featureList.add(Feature.Regenaration);
	}

}
