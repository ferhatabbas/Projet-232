package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Breeding;
import model.DinoAction;
import model.Dinosaure;
import controller.Combat;
import controller.CombatScriptController;
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
			System.out.println("Impossible to load the game.");
		}
	}

	public static void secondMenu()
	{
		int choice;
		do {
			System.out.println("Enter");
			System.out.println("1 : to create a dinosaur");
			System.out.println("2 : to see all dinosaurs");
			System.out.println("3 : to see a dinosaur");
			System.out.println("4 : to breed dinosaurs");
			System.out.println("5 : to start a combat");
			System.out.println("6 : to quit");

			choice = _lecture.nextInt();
			_lecture.nextLine();

			switch(choice){
				case 1 :
					createNewDino();
					break;
				case 2 :
					seeAllDinos();
					break;
				case 3 :
					seeDino();
					break;
				case 4 :
					breedDino();
					break;
				case 5 :
					combat();
					break;
			}
		}while (choice != 6);

		try
		{
			_game.save();
		}catch (Exception e)
		{
			System.out.println("Impossible to save the game");
		}
	}


	private static void combat() {
		CombatScriptController controller = new CombatScriptController(combat.getUserDinolist(), combat.getComputerDinolist()); 
		boolean matchResult = controller.Match();
	}

	public static void breedDino() {
		String babyDinoName;
		int choice1,choice2;
		
		System.out.println("Choose the numbers for the first and second dinosaur: ");
		for(int i=0; i< combat.getUserDinolist().size(); i++){
			System.out.println(i + "- "+ combat.getUserDinolist().get(i).getName());
			
		}
		choice1 = _lecture.nextInt();
		_lecture.nextLine();
		Dinosaure dino1 = combat.getUserDinolist().get(choice1);
		choice2 = _lecture.nextInt();
		_lecture.nextLine();
		Dinosaure dino2 = combat.getUserDinolist().get(choice2);
		

		System.out.println("Choose a name for the baby dinosaur: ");
	    babyDinoName = _lecture.next();
		_lecture.nextLine();
		_lecture.close();
		
		combat.getUserDinolist().add( Breeding.newBreeding(dino1, dino2, babyDinoName));
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

	public static void startCombat(Boolean userTurn){
		System.out.println("Combat Starting!:");
		WhoHaveTurn(userTurn);

	}

	public static void WhoHaveTurn(Boolean userTurn){
		System.out.println("Determining Who Start First!");
		if(userTurn){
			System.out.println("User Turn! ");
		}
		else {
			System.out.println("Cpu Turn! ");
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
	
		if(combat.getUserTurn()){
			for(int i=0; i< combat.getComputerDinolist().size();i++){
				System.out.println("LifePoint : " + combat.getComputerDinolist().get(i).getLifePoint());
				System.out.println("Xp : " + combat.getComputerDinolist().get(i).getXp());
		}
		}
		else {
				for(int i=0; i< combat.getUserDinolist().size();i++){
					System.out.println("LifePoint : " + combat.getUserDinolist().get(i).getLifePoint());
					System.out.println("Xp : " + combat.getUserDinolist().get(i).getXp());
				
			}
				
	}
	}
	public static DinoAction ChooseAction(ArrayList<DinoAction> actionList){

		int chooseAttack;
		
		System.out.println("Choose the number of your attack: ");
		for(int i=0; i< actionList.size(); i++){
			System.out.println(i + "- "+ actionList.get(i).getActionName());
			
		}
		chooseAttack = _lecture.nextInt();
		_lecture.nextLine();
		_lecture.close();
	
		
		return actionList.get(chooseAttack);
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
		
		return computerDinolist.get(chooseTarget);
	}
	
	public static void ShowChangeInflicted(Dinosaure target, String changedValue, int oldValue, int newValue){
		System.out.println("target: "+ target.getName());
		System.out.println("old"+ changedValue + " = " + oldValue);
		System.out.println("new"+ changedValue + " = " + newValue);
	}
	
	public static void FleeAttempt(boolean tryFlee, Dinosaure target, boolean userSide){
		
		if(tryFlee == true){
			if(userSide == true){
				System.out.println("Your dinosaur flew... ");
			}
			else{
				System.out.println(target.getName() +"flew... ");
			}
		}
		else{
			System.out.println("Flee attempt failed ");
		}
		
	}
	
}
