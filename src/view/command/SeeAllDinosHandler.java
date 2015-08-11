package view.command;

import controller.Game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class SeeAllDinosHandler extends Command {

    public SeeAllDinosHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        ArrayList<String> dinos = _game.getListOfDinos();
        for(String d : dinos){
            System.out.println("Dinosaure : " + d);
        }
    }
}
