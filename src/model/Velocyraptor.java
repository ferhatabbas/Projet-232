package model;

import java.util.ArrayList;

public class Velocyraptor extends Dinosaure {
	
	public Velocyraptor() {
		super();
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);
		construct();
	}
	
	public Velocyraptor(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<DinoAction> ListeAttack, ArrayList<Feature> ListFeature) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack, ListFeature);
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);
	}
	
	@Override
	public void construct() {
		setSpeed(speed + 1);
		setStrenght(strenght + 2);
		
		featureList.add(Feature.Regenaration);
		featureList.add(Feature.Learning);
	}

}
