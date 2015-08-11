package view.command;

import controller.Game;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class CreateDinoHandler extends Command {

    public CreateDinoHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        System.out.println("Please enter the name of the dinosaur : ");
        String name = _lecture.nextLine();
        System.out.println("Please enter the family of the dinosaur : ");
        String family = _lecture.nextLine();
        try{
            _game.createDino(name,family);
            System.out.println("Creation successfull");
        }catch (Exception e){
            System.out.println("Creation failed");
        }
    }
}
