package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public abstract class Dinosaure extends Observable implements AICpu{
	protected boolean etat;
	protected String name;
	protected int lifePoint;
	protected int strenght;
	protected int speed;
	protected int defense;
	protected int xp;
	protected TypeDinosaure type;
	protected Family family;
	protected ArrayList<DinoAction> AttackList = new ArrayList<DinoAction>();
    protected ArrayList<Feature> featureList = new ArrayList<Feature>();

    /* AI OVER HERE */
    static int typeAlgo = 0;
	
	final int BASE_LIFEPOINT_DINO_MIN = 10;
	final int BASE_LIFEPOINT_DINO_MAX = 16;
	final int BASE_STRENGHT_POINT_DINO_MAX = 7;
	final int BASE_STRENGHT_POINT_DINO_MIN = 3;
	final int BASE_SPEED_POINT_DINO_MAX = 6;
	final int BASE_SPEED_POINT_DINO_MIN = 2;
	final int BASE_DEFENSE_POINT_DINO_MAX = 8;
	final int BASE_DEFENSE_POINT_DINO_MIN = 4;
	
	public Dinosaure()
	{
		setName("DEFAULT: WAS GENERATED");
		setLifePointRandom();
		setStrenghtRandom();
		setSpeedRandom();
		setDefenseRandom();
		setXp(0);
        this.getTypeAlgo();

	}
	
	public Dinosaure(String name, int lifePoint, int strenght, int speed, int defense, 
			int xp, ArrayList<DinoAction> ListAttack, ArrayList<Feature> ListFeature)
	{
        setFeatureList(ListFeature);
        setName(name);
		setLifePoint(lifePoint);
        setStrenght(strenght);
        setSpeed(speed);
        setDefense(defense);
        setXp(xp);
		setAttackList(ListAttack);
	}

	void setDefenseRandom() 
	{
        setDefense(Random(BASE_DEFENSE_POINT_DINO_MIN, BASE_DEFENSE_POINT_DINO_MAX));
	}

	void setSpeedRandom() 
	{
        setSpeed(Random(BASE_SPEED_POINT_DINO_MIN, BASE_SPEED_POINT_DINO_MAX));
	}

	void setStrenghtRandom() 
	{
		setStrenght(Random(BASE_STRENGHT_POINT_DINO_MIN, BASE_STRENGHT_POINT_DINO_MAX));
	}

	void setLifePointRandom() 
	{
		setLifePoint(Random(BASE_LIFEPOINT_DINO_MIN, BASE_LIFEPOINT_DINO_MAX));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;

		if(lifePoint > BASE_LIFEPOINT_DINO_MAX) {
			lifePoint = BASE_LIFEPOINT_DINO_MAX;
		}
		else if(lifePoint < BASE_LIFEPOINT_DINO_MIN) {
			lifePoint = BASE_LIFEPOINT_DINO_MIN;
		}
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
		
		if(strenght > BASE_STRENGHT_POINT_DINO_MAX) {
			strenght = BASE_STRENGHT_POINT_DINO_MAX;
		}
		else if(strenght < BASE_STRENGHT_POINT_DINO_MIN) {
			strenght = BASE_STRENGHT_POINT_DINO_MIN;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		
		if(speed > BASE_SPEED_POINT_DINO_MAX) {
			speed = BASE_SPEED_POINT_DINO_MAX;
		}
		else if(speed < BASE_SPEED_POINT_DINO_MIN) {
			speed = BASE_SPEED_POINT_DINO_MIN;
		}
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		
		if(defense > BASE_DEFENSE_POINT_DINO_MAX) {
			defense = BASE_DEFENSE_POINT_DINO_MAX;
		}
		else if(defense < BASE_DEFENSE_POINT_DINO_MIN) {
			defense = BASE_DEFENSE_POINT_DINO_MIN;
		}
	}

    public boolean isEtat() {
        return etat;
    }
	
	public static int Random(int Low, int High){
		Random r = new Random();
		int R = r.nextInt((High - Low) + 1) + Low;
		return R;
	}
	
	public void setEtat(boolean etat){
		this.etat=etat;
		setChanged();
		notifyObservers(this.etat);
	}
	
	public void setType(TypeDinosaure type) {
		this.type = type;
	}
	
	public TypeDinosaure getType() {
		return type;
	}
	
	public void setFamily(Family family) {
		this.family = family;
	}
	
	public Family getFamily() {
		return family;
	}
	
	public ArrayList<Feature> getFeatureList() {
		
		return featureList;
	}

	public void setFeatureList(ArrayList<Feature> newfeatureList) {
		featureList = newfeatureList;
	}

	public void setAttackList(ArrayList<DinoAction> attackList) {
		AttackList = attackList;
	}

	public ArrayList<DinoAction> getAttackList() {
		return AttackList;
	}

	protected void addAttack(DinoAction attack){
		AttackList.add(attack);
	}

	protected void removeAttack(DinoAction attack){
		AttackList.remove(attack);
	}

	protected void removeAttack(int indexList){
		AttackList.remove(indexList);
	}
	
	public void printFeatureList() {
		
		for(Feature f: featureList){
			switch (f){
			case Regenaration :	System.out.println("Regenaration, ");
				break;
			case Learning :	System.out.println("Learning, ");
				break;
			case Durability :	System.out.println("Durability, ");
				break;	
			}
		}
	}

    /* IMPLEMENTATION DES METHODES DES INTERFACES*/
    /* AICpu */

    public int getTypeAlgo(){
        return typeAlgo;
    }

    public void setTypeAlgo(int type){
        typeAlgo = type;
    }

    public DinoAction GenerateAction() {

        if(typeAlgo == TYPEALGOATTACK || typeAlgo == TYPEALGODEFENSE){
            return GenerateSpecificAction();
        }
        else if (typeAlgo == TYPEALGORANDOM){
            return GenerateRANDOMAction();
        }
        else{
            return null; //ATENTION!!!
        }
    }

    public DinoAction GenerateSpecificAction() {

		TypeAction typeAction = getActionType(getTypeAlgo());
        for(int i = 0; i < AttackList.size(); i++){
            if(AttackList.get(i).getActionAttack() == typeAction){
                return AttackList.get(i);
            }
            else{
                return AttackList.get(0);
            }

        }
        return null; //ATENTION!!!
    }

    public DinoAction GenerateRANDOMAction() {
        int value = Random(0, AttackList.size() - 1);
        return AttackList.get(value);
    }

    public TypeAction getActionType(int typeAlgo) {

        switch (typeAlgo){
            case TYPEALGOATTACK: return TypeAction.Atacktype;
            case TYPEALGODEFENSE: return TypeAction.Fleetype;
        }
        return null;
    }

	public abstract void construct();

    /* FIN AICpu */
	
	/*
	public boolean equals(Object otherDinosaure)
	{
		if (otherDinosaure instanceof Dinosaure)
		{
			Dinosaure dinosaure = (Dinosaure) otherDinosaure;
			return 
					name == dinosaure.getName() &&
					lifePoint == dinosaure.getLifePoint() &&
					strenght == dinosaure.getStrenght() &&
					speed == dinosaure.getSpeed() &&
					defense == dinosaure.getDefense() &&
					xp == dinosaure.getXp() &&
					type == dinosaure.getType() &&
					family == dinosaure.getFamily() &&
					featureList.equals(dinosaure.getFeatureList());
		}	
		else
		{
			return false;
		}
	}
	*/
}
