package model;

//family += familyDino1.substring(0, dino1.getFamily().toString().length() / 2);
//family += dino2.getFamily().toString().substring(dino2.getFamily().toString().length() / 2);

public class Breeding {
	private Dinosaure dino1;
	private Dinosaure dino2;
	private Dinosaure newDino;
	
	public Breeding(Dinosaure dino1, Dinosaure dino2, String nameNewDino) {
		this.dino1 = dino1;
		this.dino2 = dino2;
		newDino = DinoFactory.construct(choiceFamily());
	}
	
	public Dinosaure breedingDino() {


		return newDino;
	}
	
	public Family choiceFamily() {
		if(Dinosaure.Random(1,2) == 1) {
			return dino1.getFamily();
		}
		else {
			return dino2.getFamily();
		}
	}
	
	
}
