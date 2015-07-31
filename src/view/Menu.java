package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.DinoAction;
import model.DinoActionList;
import model.Dinosaure;
import controller.Combat;
import controller.Game;
/**
 * 
 * @author carolenaka, sebastien and vahei
 *
 */

public class Menu {
	
	private static String username;
	private static String name;

	public static Scanner _lecture = new Scanner(System.in);
	public static Game _game;
	public static Combat combat;

	public static void main(String[] args) {

		int choice;

		System.out.println("***  WELCOME TO DINOGAME ! ***");
		do{
			System.out.println("Enter");
			System.out.println("1 : to start a new game");
			System.out.println("2 : to load a game");
			System.out.println("3 : to quit");
	
			System.out.println("Enter a number to choose");
			choice = _lecture.nextInt();
			_lecture.nextLine();

			_game = new Game();
			
			switch(choice){
				case 1 :
					createNewGame();
					break;
				case 2 :
					loadGame();
					break;
			}
		}while(choice != 3);
		_lecture.close();
	}

	public static void createNewGame() {
		System.out.println("Please enter your username : ");
		username = _lecture.nextLine();
		_game.initialize(username);
		try
		{
			_game.save();
			secondMenu();
		}catch (Exception e)
		{
			System.out.println("Impossible de créer une nouvelle partie.");
		}
	}
	
	public static void loadGame() {
		System.out.println("Please enter your username : ");
		username = _lecture.nextLine();
		try {
			_game.loadGameFromXml(username);
			secondMenu();
		}catch (Exception e)
		{
			System.out.println("Impossible de charger la partie.");
		}
	}

	public static void secondMenu()
	{
		int choix;
		do {
			System.out.println("Enter");
			System.out.println("1 : to create a dinosaur");
			System.out.println("2 : to see all dinosaurs");
			System.out.println("3 : to see a dinosaur");
			System.out.println("4 : to quit");

			choix = _lecture.nextInt();
			_lecture.nextLine();

			switch(choix){
				case 1 :
					createNewDino();
					break;
				case 2 :
					seeAllDinos();
					break;
				case 3 :
					seeDino();
					break;
			}
		}while (choix != 4);

		try
		{
			_game.save();
		}catch (Exception e)
		{
			System.out.println("Impossible de sauvegarder la partie.");
		}
	}

	public static void createNewDino() {
		System.out.println("Please enter the name of the dinosaur : ");
		String name = _lecture.nextLine();
		System.out.println("Please enter the family of the dinosaur : ");
		String family = _lecture.nextLine();

		if(_game.createDino(name,family))
		{
			System.out.println("Creation successfull");
		}else
		{
			System.out.println("Creation failed");
		}
	}
	
	public static void seeAllDinos() {
		ArrayList<String> dinos = _game.getListOfDinos();
		for(String d : dinos){
			System.out.println("Dinosaure : " + d);
		}
	}

	public static void seeDino() {
		System.out.println("Please enter the name of the dinosaur : ");
		name = _lecture.nextLine();
		Dinosaure d = _game.getDino(name);

		if(d != null){
			ShowDino(d);
		}else{
			System.out.println("No dinosaur found");
		}
	}

	public static void ShowDino(Dinosaure d) {
		System.out.println("Name : " + d.getName());
		System.out.println("Lifepoint : " + d.getLifePoint());
		System.out.println("Strength : " + d.getStrenght());
		System.out.println("Speed : " + d.getSpeed());
		System.out.println("Defense : " + d.getDefense());
		System.out.println("XP : " + d.getXp());
	}

	public static void StartCombat(Boolean userTurn){
		System.out.println("Combat Starting!:");
		WhoHaveTurn(userTurn);

	}

	public static void WhoHaveTurn(Boolean userTurn){
		System.out.println("Determining Who Start First!");
		if(userTurn){
			System.out.println("User Turn! :");
		}
		else {
			System.out.println("Cpu Turn! :");
		}
	}



	public static void ShowCombatStatus(ArrayList<Dinosaure> userDinolist, ArrayList<Dinosaure> computerDinolist){
		
		for(int i=0; i< userDinolist.size();i++){
			System.out.println("Name : " + userDinolist.get(i).getName());
			System.out.println("Strenght : " + userDinolist.get(i).getStrenght());
			System.out.println("Speed : " + userDinolist.get(i).getSpeed());
			System.out.println("Defense : " + userDinolist.get(i).getDefense());
		}
		
		for(int j=0; j< computerDinolist.size();j++){
			System.out.println("Name : " + computerDinolist.get(j).getName());
			System.out.println("Strenght : " + computerDinolist.get(j).getStrenght());
			System.out.println("Speed : " + computerDinolist.get(j).getSpeed());
			System.out.println("Defense : " + computerDinolist.get(j).getDefense());
		}
}
	
	public static void ShowDamageInflicted(){
		ArrayList<Dinosaure> userDinolist = new ArrayList<Dinosaure> ();
		ArrayList<Dinosaure> computerDinolist = new ArrayList<Dinosaure> ();
		if(combat.getUserTurn()){
			for(int i=0; i< computerDinolist.size();i++){
				System.out.println("LifePoint : " + computerDinolist.get(i).getLifePoint());
				System.out.println("Xp : " + computerDinolist.get(i).getXp());
		}
		}
		else {
				for(int i=0; i< userDinolist.size();i++){
					System.out.println("LifePoint : " + userDinolist.get(i).getLifePoint());
					System.out.println("Xp : " + userDinolist.get(i).getXp());
				
			}
				
	}
	}
	public static DinoAction ChooseAction(ArrayList<DinoAction> actionList){
		DinoAction action = null;
		int chooseAttack;
		
		System.out.println("Choose the number of your attack: ");
		for(int i=0; i< actionList.size(); i++){
			System.out.println(i + "- "+ actionList.get(i).getActionName());
			
		}
		chooseAttack = _lecture.nextInt();
		_lecture.nextLine();
		_lecture.close();
	
		action = actionList.get(chooseAttack);
		
		return action;
	}	
	
	public Dinosaure ChooseTarget(ArrayList<Dinosaure> computerDinolist){
		int chooseTarget;
		
		System.out.println("Choose a number for your target: ");
		for(int i=0; i< computerDinolist.size(); i++){
			System.out.println(i + "- "+ computerDinolist.get(i).getName());
			
		}
		chooseTarget = _lecture.nextInt();
		_lecture.nextLine();
		_lecture.close();
		Dinosaure target =  computerDinolist.get(chooseTarget);
		
		return target;
	}
	
	public static void ShowChangeInflicted(Dinosaure target,int previousLifePoint, int actualLifePoint){
		System.out.println("target: "+ target.getName());
		System.out.println("previousLifePoint: "+ previousLifePoint);
		System.out.println("actualLifePoint: "+ actualLifePoint);
		
	}
	
	
}
