package view;

import controller.Combat;
import controller.CombatScriptController;
import controller.Game;
import model.Breeding;
import model.DinoAction;
import model.Dinosaure;
import view.command.CreateGameHandler;
import view.command.LoadGameHandler;

import java.util.ArrayList;
import java.util.Scanner;
/**
 - *
 - * @author carolenaka, sebastien and vahei
 - *
 - */

public class Menu {

	public static Scanner _lecture;
	public static CreateGameHandler createGameHandler;
	public static LoadGameHandler loadGameHandler;

    public static void main(String[] args) {
    	Affichage.welcome();
        int choice;

		_lecture = new Scanner(System.in);
		
		do{
			Affichage.affichage1();
			choice = _lecture.nextInt();
			_lecture.nextLine();

			Game g = new Game();
			createGameHandler = new CreateGameHandler(g,_lecture);
			loadGameHandler = new LoadGameHandler(g, _lecture);

			switch(choice){
				case 1 :
    					createGameHandler.execute();
    					break;
				case 2 :
						loadGameHandler.execute();
    					break;
			}
		}while(choice != 3);
		_lecture.close();
	}
}