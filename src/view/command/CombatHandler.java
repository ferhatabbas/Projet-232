package view.command;

import controller.Combat;
import controller.CombatScriptController;
import controller.Game;
import model.DinoAction;
import model.Dinosaure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandre on 2015-08-11.
 */
public class CombatHandler extends Command {

    public CombatHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        CombatScriptController controller = new CombatScriptController(get_lecture(), get_game().get_dinos(), get_game().get_dinos());
        controller.Match();
    }


}
