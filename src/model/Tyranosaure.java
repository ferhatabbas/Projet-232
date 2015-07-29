package model;

import java.util.ArrayList;

public class Tyranosaure extends Dinosaure {

	public Tyranosaure() {
		super();
		setType(TypeDinosaure.Biped);
		setFamily(Family.Tyranosaure);
		construct();
	}
	
	public Tyranosaure(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<DinoAction> ListeAttack, ArrayList<Feature> ListFeature) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack, ListFeature);
		setType(TypeDinosaure.Biped);
		setFamily(Family.Tyranosaure);
	}
	
	@Override
	public void construct() {
		setSpeed(speed + 2);
		setStrenght(strenght + 2);
		setDefense(defense + 2);
		
		featureList.add(Feature.Learning);
	}

}
