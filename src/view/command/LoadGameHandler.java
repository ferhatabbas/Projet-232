package view.command;

import controller.Game;

import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class LoadGameHandler extends Command {

    SecondMenuHandler secondMenuCommand;

    public LoadGameHandler(Game game, Scanner lecture) {
        super(game, lecture);
        secondMenuCommand = new SecondMenuHandler(get_game(), get_lecture());
    }

    @Override
    public void execute() {
        System.out.println("Please enter your username : ");
        String username = get_lecture().nextLine();
        try {
            _game.loadGameFromXml(username);
        }catch (Exception e)
        {
            System.out.println("Impossible to load the game. A new game has been created.");
            _game.initialize(username);
            _game.save();
        }
        secondMenuCommand.execute();
    }
}
