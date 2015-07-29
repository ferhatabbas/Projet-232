package model;

import java.util.ArrayList;

public class Argentavis extends Dinosaure {

	public Argentavis() {
		super();
		setType(TypeDinosaure.Sailor);
		setFamily(Family.Argentavis);
		construct();
	}
	
	public Argentavis(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<DinoAction> ListeAttack, ArrayList<Feature> ListFeature) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack, ListFeature);
		setType(TypeDinosaure.Sailor);
		setFamily(Family.Argentavis);
	}
	
	@Override
	public void construct() {
		setSpeed(speed + 1);
		setStrenght(strenght - 2);
		setDefense(defense - 2);
		
		featureList.add(Feature.Regenaration);
		featureList.add(Feature.Learning);
	}

}
