package model;

import java.util.ArrayList;

public class Azhdarchidea extends Dinosaure {

	public Azhdarchidea() {
		super();
		setType(TypeDinosaure.Flying);
		setFamily(Family.Azhdarchidea);
		construct();
	}
	
	public Azhdarchidea(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, ArrayList<DinoAction> ListeAttack, ArrayList<Feature> ListFeature) {
		super(name, lifePoint, strenght, speed, defense, xp, ListeAttack, ListFeature);
		setType(TypeDinosaure.Flying);
		setFamily(Family.Azhdarchidea);
	}
	
	@Override
	public void construct() {
		setStrenght(strenght + 2);
		setDefense(defense - 1);
		
		featureList.add(Feature.Durability);
		featureList.add(Feature.Learning);
	}

}
