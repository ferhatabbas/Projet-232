package model;

import java.util.ArrayList;

public class Velocyraptor extends Dinosaure {
	
	public Velocyraptor() {
		super();
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);

		// Specialisation du Dinosaure
		setSpeed(speed + 1);
		setStrenght(strenght + 2);

		featureList.add(Feature.Regenaration);
		featureList.add(Feature.Learning);
	}
	
	public Velocyraptor(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<DinoAction> ListeAttack, ArrayList<Feature> ListFeature) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack, ListFeature);
		setType(TypeDinosaure.Biped);
		setFamily(Family.Velocyraptor);
	}
}
