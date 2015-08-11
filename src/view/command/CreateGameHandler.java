package view.command;

import controller.Game;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class CreateGameHandler extends Command {

    SecondMenuHandler secondMenuCommand;

    public CreateGameHandler(Game game, Scanner lecture) {
        super(game,lecture);
        secondMenuCommand = new SecondMenuHandler(get_game(), get_lecture());
    }

    @Override
    public void execute() {
        System.out.println("Please enter your username : ");
        _game.initialize(get_lecture().nextLine());
        try
        {
            _game.save();
            secondMenuCommand.execute();
        }catch (Exception e)
        {
            System.out.println("Impossible to create a new game.");
        }
    }
}
