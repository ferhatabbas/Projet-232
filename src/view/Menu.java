package view;

import java.util.Scanner;
/**
 * 
 * @author carolenaka, sebastien and vahei
 *
 */
public class Menu {

	public static void main(String[] args) {

		int choix = 0;
		Scanner lecture = new Scanner(System.in);

		System.out.println("***  WELCOME TO DINOGAME ! ***");
		while(choix != 3){
			System.out.println("Enter");
			System.out.println("1 : to start a new game");
			System.out.println("2 : to load a game");
			System.out.println("3 : to quit");
	
			System.out.println("Enter a number to choose");
			choix = lecture.nextInt();
			
			switch(choix){
				case 1 ://TO DO creer un fichier xml
						System.out.println("Enter");
						System.out.println("4 : to create a dinosaur");
						System.out.println("5 : to see a dinosaure");
						System.out.println("6 : to save your game");
						System.out.println("7 : to quit");
						choix = lecture.nextInt();
						break;
				case 2 ://TO DO charger un fichier xml
						System.out.println("Enter");
						System.out.println("4 : to create a dinosaur");
						System.out.println("5 : to see a dinosaure");
						System.out.println("6 : to save your game");
						System.out.println("7 : to quit");
						choix = lecture.nextInt();
						break;
				case 3 :return;
				case 4 : // creer un dinosaure
				case 5 : //voir le dinosaure
				case 6 : //sauvegarder
				case 7 :break;

			}

		}
	lecture.close();
	}

}
