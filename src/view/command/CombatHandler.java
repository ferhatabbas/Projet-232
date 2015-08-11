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

    Combat combat;

    public CombatHandler(Game game, Scanner lecture) {
        super(game, lecture);
    }

    @Override
    public void execute() {
        CombatScriptController controller = new CombatScriptController(get_lecture(), get_game().get_dinos(), combat.getComputerDinolist());
        boolean matchResult = controller.Match();
    }


}
