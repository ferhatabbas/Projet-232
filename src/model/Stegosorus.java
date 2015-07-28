package model;

import java.util.ArrayList;

/**
 * Created by Patricia Boutin and Pavlo Minko on 2015-07-22.
 */

public class Stegosorus extends Dinosaure {

	public Stegosorus() {
		super();
		setType(TypeDinosaure.Quadriped);
		setFamily(Family.Stegosorus);
		construct();
	}
	
	public Stegosorus(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<Attack> ListeAttack) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack);
		setType(TypeDinosaure.Quadriped);
		setFamily(Family.Stegosorus);
	}
	
	@Override
	public void construct() {
		setSpeed(speed - 4);
		setStrenght(strenght - 1);
		setDefense(defense + 3);
		
		featureList.add(Feature.Stronger);
		featureList.add(Feature.Durability);
		featureList.add(Feature.Regenaration);
	}

}
