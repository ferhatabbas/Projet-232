package view.command;

import controller.Game;
import view.Affichage;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class SecondMenuHandler extends Command {

    CreateDinoHandler createDinoHandler;
    SeeAllDinosHandler seeAllDinosHandler;
    SeeDinoHandler seeDinoHandler;
    BreedDinoHandler breedDinoHandler;
    CombatHandler combatHandler;

    public SecondMenuHandler(Game game, Scanner lecture) {
        super(game, lecture);
        createDinoHandler = new CreateDinoHandler(get_game(), get_lecture());
        seeAllDinosHandler = new SeeAllDinosHandler(get_game(), get_lecture());
        seeDinoHandler = new SeeDinoHandler(get_game(), get_lecture());
        breedDinoHandler = new BreedDinoHandler(get_game(), get_lecture());
        combatHandler = new CombatHandler(get_game(), get_lecture());
    }

    @Override
    public void execute() {
        int choice;

        do {
            Affichage.affichage2();

            choice = _lecture.nextInt();
            _lecture.nextLine();

            switch(choice){
                case 1 :
                    createDinoHandler.execute();
                    break;
                case 2 :
                    seeAllDinosHandler.execute();
                    break;
                case 3 :
                    seeDinoHandler.execute();
                    break;
                case 4 :
                    breedDinoHandler.execute();
                    break;
                case 5 :
                    combatHandler.execute();
                    break;
            }
        }while (choice != 6);

        try{
            _game.save();
        }catch (Exception e){
            System.out.println("Impossible to save the game");
        }
    }
}
