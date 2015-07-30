package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Dinosaure;
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

	public static void main(String[] args) {

		int choix;

		System.out.println("***  WELCOME TO DINOGAME ! ***");
		do{
			System.out.println("Enter");
			System.out.println("1 : to start a new game");
			System.out.println("2 : to load a game");
			System.out.println("3 : to quit");
	
			System.out.println("Enter a number to choose");
			choix = _lecture.nextInt();
			_lecture.nextLine();

			_game = new Game();
			
			switch(choix){
				case 1 :
					System.out.println("Please enter your username : ");
					createNewGame(username);
					break;
				case 2 :
					System.out.println("Please enter your username : ");
					loadGame(username);
					break;
			}
		}while(choix != 3);
		_lecture.close();
	}

	public static void createNewGame(String username) {
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
	
	public static void loadGame(String username) {
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
					System.out.println("Please enter the name of the dinosaur : ");
					seeDino(name);
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
	
	private static void seeAllDinos() {
		ArrayList<String> dinos = _game.getListOfDinos();
		for(String d : dinos){
			System.out.println("Dinosaure : " + d);
		}
	}

	public static void seeDino(String name) {
		name = _lecture.nextLine();
		Dinosaure d = _game.getDino(name);

		if(d != null){
			ShowDino(d);
		}else{
			System.out.println("No dinosaur found");
		}
	}

	private static void ShowDino(Dinosaure d) {
		System.out.println("Name : " + d.getName());
		System.out.println("Lifepoint : " + d.getLifePoint());
		System.out.println("Strength : " + d.getStrenght());
		System.out.println("Speed : " + d.getSpeed());
		System.out.println("Defense : " + d.getDefense());
		System.out.println("XP : " + d.getXp());
	}

	private static void StartCombat(Boolean userTurn){
		System.out.println("Combat Starting!:");
		WhoHaveTurn(userTurn);

	}

	private static void WhoHaveTurn(Boolean userTurn){
		System.out.println("Determining Who Start First!");
		if(userTurn){
			System.out.println("User Turn! :");
		}
		else {
			System.out.println("Cpu Turn! :");
		}
	}




}
