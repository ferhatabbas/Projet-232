package view;

import controller.Game;

import java.util.Scanner;
/**
 * 
 * @author carolenaka, sebastien and vahei
 *
 */
public class Menu {

	public static Scanner _lecture = new Scanner(System.in);
	public static Game _game;

	public static void main(String[] args) {

		int choix;
		_game = new Game();

		System.out.println("***  WELCOME TO DINOGAME ! ***");
		do{
			System.out.println("Enter");
			System.out.println("1 : to start a new game");
			System.out.println("2 : to load a game");
			System.out.println("3 : to quit");
	
			System.out.println("Enter a number to choose");
			choix = _lecture.nextInt();
			
			switch(choix){
				case 1 :
					createNewGame();
					break;
				case 2 :
					loadGame();
					break;
			}
		}while(choix != 3);
		_lecture.close();
	}

	private static void createNewGame() {
		secondMenu();
	}

	private static void loadGame() {
		secondMenu();
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
	}

	private static void createNewDino() {

	}

	private static void seeAllDinos() {
		
	}

	private static void seeDino() {
		
	}
}
