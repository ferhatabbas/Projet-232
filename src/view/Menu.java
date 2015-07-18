package view;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		int choix = 0;
		Scanner lecture = new Scanner(System.in);

		System.out.println("***  BIENVENUE DANS DINOGAME ! ***");
		while(choix != 3){
			System.out.println("Saisir");
			System.out.println("1 : pour creer une nouvelle partie");
			System.out.println("2 : pour charger une  partie");
			System.out.println("3 : pour quitter");
	
			System.out.println("Saisir un chiffre pour la selection");
			choix = lecture.nextInt();
			
			switch(choix){
				case 1 ://TO DO creer un fichier xml
						System.out.println("Saisir");
						System.out.println("4 : pour creer un dinosaure");
						System.out.println("5 : pour voir le dinosaure");
						System.out.println("6 : pour sauvegarder");
						System.out.println("7 : pour quitter");
						choix = lecture.nextInt();
						break;
				case 2 ://TO DO charger un fichier xml
						System.out.println("Saisir");
						System.out.println("4 : pour creer un dinosaure");
						System.out.println("5 : pour voir le dinosaure");
						System.out.println("6 : pour sauvegarder");
						System.out.println("7 : pour quitter");
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
