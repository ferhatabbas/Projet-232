package view.command;

import controller.Game;
import model.Dinosaure;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class SeeDinoHandler extends Command {

    public SeeDinoHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        System.out.println("Please enter the name of the dinosaur : ");
        Dinosaure d = _game.getDino(_lecture.nextLine());

        if(d != null){
            ShowDino(d);
        }
        else{
            System.out.println("No dinosaur found");
        }
    }

    private void ShowDino(Dinosaure d) {
        System.out.println("Name : " + d.getName());
        System.out.println("Lifepoint : " + d.getLifePoint());
        System.out.println("Strength : " + d.getStrenght());
        System.out.println("Speed : " + d.getSpeed());
        System.out.println("Defense : " + d.getDefense());
        System.out.println("XP : " + d.getXp());
    }
}
