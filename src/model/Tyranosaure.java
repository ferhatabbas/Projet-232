package model;

import java.util.ArrayList;

/**
 * Created by Patricia Boutin and Pavlo Minko on 2015-07-22.
 */

public class Tyranosaure extends Dinosaure {

	public Tyranosaure() {
		super();
		setType(TypeDinosaure.Biped);
		setFamily(Family.Tyranosaure);
		construct();
	}
	
	public Tyranosaure(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<Attack> ListeAttack) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack);
		setType(TypeDinosaure.Biped);
		setFamily(Family.Tyranosaure);
	}
	
	@Override
	public void construct() {
		setSpeed(speed + 2);
		setStrenght(strenght + 2);
		setDefense(defense + 2);

		featureList.add(Feature.Stronger);
		featureList.add(Feature.Faster);
		featureList.add(Feature.Lovely);
	}

}
