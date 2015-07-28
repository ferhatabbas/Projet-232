package model;

import java.util.ArrayList;

/**
 * Created by Patricia Boutin and Pavlo Minko on 2015-07-22.
 */

public class Velocyraptor extends Dinosaure {
	
	public Velocyraptor() {
		super();
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);
		construct();
	}
	
	public Velocyraptor(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<Attack> ListeAttack) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack);
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);
	}
	
	@Override
	public void construct() {
		setSpeed(speed + 1);
		setStrenght(strenght + 2);
		
		featureList.add(Feature.Faster);
		featureList.add(Feature.Learning);
		featureList.add(Feature.Durability);
	}

}
