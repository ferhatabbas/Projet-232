package model;

import java.util.ArrayList;

/**
 * Created by Patricia Boutin on 2015-07-28.
 */

public class Breeding {

	public static Dinosaure newBreeding(Dinosaure dino1, Dinosaure dino2, String nameNewDino) {
		Dinosaure newDino = DinoFactory.construct(choiceFamily(dino1, dino2));
		newDino.setName(nameNewDino);
		newDino.setDefense(choiceDefense(dino1, dino2));
		newDino.setSpeed(choiceSpeed(dino1, dino2));
		newDino.setStrenght(choiceStrenght(dino1, dino2));
		newDino.setLifePoint(choiceLifePoint(dino1, dino2));
		newDino.setFeatureList(choiceFeature(dino1, dino2));

		return newDino;
	}
	
	private static Family choiceFamily(Dinosaure dino1, Dinosaure dino2) {
		if(Dinosaure.Random(1,2) == 1) {
			return dino1.getFamily();
		}
		else {
			return dino2.getFamily();
		}
	}

	private static int choiceDefense(Dinosaure dino1, Dinosaure dino2) {
		if (dino1.getDefense() < dino2.getDefense()) {
			return Dinosaure.Random(dino1.getDefense(), dino2.getDefense());
		} else {
			return Dinosaure.Random(dino2.getDefense(), dino1.getDefense());
		}
	}

	private static int choiceSpeed(Dinosaure dino1, Dinosaure dino2) {
		if (dino1.getSpeed() < dino2.getSpeed()) {
			return Dinosaure.Random(dino1.getSpeed(), dino2.getSpeed());
		} else {
			return Dinosaure.Random(dino2.getSpeed(), dino1.getSpeed());
		}
	}

	private static int choiceStrenght(Dinosaure dino1, Dinosaure dino2) {
		if (dino1.getStrenght() < dino2.getStrenght()) {
			return Dinosaure.Random(dino1.getStrenght(), dino2.getStrenght());
		} else {
			return Dinosaure.Random(dino2.getStrenght(), dino1.getStrenght());
		}
	}

	private static int choiceLifePoint(Dinosaure dino1, Dinosaure dino2) {
		if (dino1.getLifePoint() < dino2.getLifePoint()) {
			return Dinosaure.Random(dino1.getLifePoint(), dino2.getLifePoint());
		} else {
			return Dinosaure.Random(dino2.getLifePoint(), dino1.getLifePoint());
		}
	}

	private static ArrayList<Feature> choiceFeature(Dinosaure dino1, Dinosaure dino2) {
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
