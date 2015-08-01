package model;

import java.util.ArrayList;

public class DinoFactory {
	public static Dinosaure construct(Family family) {
		Dinosaure newDino = null;
		
		switch (family) {
		case Velocyraptor : newDino = new Velocyraptor();
			break;
		case Tyranosaure : newDino = new Tyranosaure();
			newDino = new DecoratorDouble(newDino); // Possibilite d'action doubler
			break;
		case Stegosorus : newDino = new Stegosorus();
			newDino = new DecoratorDecrease(newDino); // Possibilite d'action diminuer 0 à 2
			break;
		case Triceraptaure : newDino = new Triceraptaure();
			break;
		case Azhdarchidea : newDino = new Azhdarchidea();
			break;
		case Argentavis : newDino = new Argentavis();
			newDino = new DecoratorIncrease(newDino); // Possibilite d'action augmenter de 0 à 2
			break;
			default:;
		}
		
		return newDino;
	}

	public static Dinosaure construct(String name, int lifePoint, int strenght, 
			int speed, int defense, int xp, Family family, ArrayList<DinoAction> ListeAttack,
            ArrayList<Feature> ListFeature) {
		Dinosaure newDino = null;
		
		switch (family) {
		case Velocyraptor : newDino = new Velocyraptor(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			break;
		case Tyranosaure : newDino = new Tyranosaure(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			newDino = new DecoratorDouble(newDino);
			break;
		case Stegosorus : newDino = new Stegosorus(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			newDino = new DecoratorDecrease(newDino);
			break;
		case Triceraptaure : newDino = new Triceraptaure(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			break;
		case Azhdarchidea : newDino = new Azhdarchidea(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			break;
		case Argentavis : newDino = new Argentavis(name, lifePoint, strenght, 
				speed, defense, xp, ListeAttack, ListFeature);
			newDino = new DecoratorIncrease(newDino);
			break;
			default:;
		}
		
		return newDino;
	}

	public static Dinosaure construct()
	{
		Dinosaure newDino = null;
		int result = Dinosaure.Random(0, Family.values().length - 1);
		
		switch (result) {
		case 0 : newDino = construct(Family.Velocyraptor);
			break;
		case 1 : newDino = construct(Family.Tyranosaure);
			break;
		case 2 : newDino = construct(Family.Stegosorus);
			break;
		case 3 : newDino = construct(Family.Triceraptaure);
			break;
		case 4 : newDino = construct(Family.Azhdarchidea);
			break;
		case 5 : newDino = construct(Family.Argentavis);
			break;
		}

		return newDino;
	}	
}
