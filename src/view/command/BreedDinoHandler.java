package view.command;

import controller.Game;
import model.Breeding;
import model.Dinosaure;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class BreedDinoHandler extends Command {

    public BreedDinoHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        String babyDinoName;
        int choice1,choice2;

        System.out.println("Here is the user dino list ");
        int i = 1;
        for(Dinosaure d : _game.get_dinos()){
            System.out.println(i + "- "+ d.getName());
            i += 1;
        }
        System.out.println("Enter the number to choose the first dinosaur : ");
        choice1 = _lecture.nextInt();
        _lecture.nextLine();
        Dinosaure dino1 = _game.get_dinos().get(choice1);
        System.out.println("Enter the number to choose the second dinosaur : ");
        choice2 = _lecture.nextInt();
        _lecture.nextLine();
        Dinosaure dino2 = _game.get_dinos().get(choice2);
        System.out.println("Choose a name for the baby dinosaur: ");
        babyDinoName = _lecture.next();
        _lecture.nextLine();
        _lecture.close();
        _game.get_dinos().add( Breeding.newBreeding(dino1, dino2, babyDinoName));
    }
}
