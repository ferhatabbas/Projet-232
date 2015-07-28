package model;

public class Breeding {
	private Dinosaure dino1;
	private Dinosaure dino2;
	private Dinosaure newDino;
	
	public Breeding(Dinosaure dino1, Dinosaure dino2, String nameNewDino) {
		this.dino1 = dino1;
		this.dino2 = dino2;
		newDino = new CustomizeFamily();
	}
	
	public Dinosaure breedingDino() {
		newDino.setFamily(Family.Customize);
		//fgdsfh
		return newDino;
	}
	
	public String createFamily() {
		String family = "";
		String familyDino1 = dino1.getFamily().toString();
		
		family += familyDino1.substring(0, dino1.getFamily().toString().length() / 2);
		family += dino2.getFamily().toString().substring(dino2.getFamily().toString().length() / 2);
		
		return family;
	}
	
	
}
