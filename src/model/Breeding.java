package model;

import java.util.ArrayList;

/**
 * Created by Patricia Boutin on 2015-07-28.
 */

public class Breeding {
	private Dinosaure dino1;
	private Dinosaure dino2;
	private Dinosaure newDino;

	public Breeding(Dinosaure dino1, Dinosaure dino2, String nameNewDino) {
		this.dino1 = dino1;
		this.dino2 = dino2;
		newDino = DinoFactory.construct(choiceFamily()); // ajouter le dinoName dans "construct"
		newDino.setName(nameNewDino);
		newDino.setDefense(choiceDefense());
		newDino.setSpeed(choiceSpeed());
		newDino.setStrenght(choiceStrenght());
		newDino.setLifePoint(choiceLifePoint());
		newDino.setFeatureList(choiceFeature());
	}
	
	public Dinosaure getNewDino() {
		return newDino;
	}
	
	private Family choiceFamily() {
		if(Dinosaure.Random(1,2) == 1) {
			return dino1.getFamily();
		}
		else {
			return dino2.getFamily();
		}
	}

	private int choiceDefense() {
		if (dino1.getDefense() < dino2.getDefense()) {
			return Dinosaure.Random(dino1.getDefense(), dino2.getDefense());
		} else {
			return Dinosaure.Random(dino2.getDefense(), dino1.getDefense());
		}
	}

	private int choiceSpeed() {
		if (dino1.getSpeed() < dino2.getSpeed()) {
			return Dinosaure.Random(dino1.getSpeed(), dino2.getSpeed());
		} else {
			return Dinosaure.Random(dino2.getSpeed(), dino1.getSpeed());
		}
	}

	private int choiceStrenght() {
		if (dino1.getStrenght() < dino2.getStrenght()) {
			return Dinosaure.Random(dino1.getStrenght(), dino2.getStrenght());
		} else {
			return Dinosaure.Random(dino2.getStrenght(), dino1.getStrenght());
		}
	}

	private int choiceLifePoint() {
		if (dino1.getLifePoint() < dino2.getLifePoint()) {
			return Dinosaure.Random(dino1.getLifePoint(), dino2.getLifePoint());
		} else {
			return Dinosaure.Random(dino2.getLifePoint(), dino1.getLifePoint());
		}
	}

	private ArrayList<Feature> choiceFeature() {
		ArrayList<Feature> newFeatureList = new ArrayList<Feature>();

		for(int i = 0 ; i < Feature.values().length; i++) {
			if(dino1.getFeatureList().contains(Feature.values()[i]) &&
					dino2.getFeatureList().contains(Feature.values()[i])) {
				newFeatureList.add(Feature.values()[i]);
			}
			else if(dino1.getFeatureList().contains(Feature.values()[i]) ||
					dino2.getFeatureList().contains(Feature.values()[i])){
				if(Dinosaure.Random(0,1) == 0) {
					newFeatureList.add(Feature.values()[i]);
				}
			}
		}
		return newFeatureList;
	}
}
