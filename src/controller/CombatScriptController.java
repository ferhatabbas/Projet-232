package controller;

import model.Dinosaure;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Philippe on 2015-07-30.
 */
public class CombatScriptController {
    protected Combat combat;
    protected StartCombatState startCombatState;
    protected CPUTurnCombatState cpuTurnCombatState;
    protected UserTurnCombatState userTurnCombatState;
    protected EndCombatState endCombatState;

    public CombatScriptController(Scanner lecture, ArrayList< Dinosaure > listeDinoUser, ArrayList<Dinosaure> listeDino) {
        combat = new Combat(lecture, listeDinoUser, listeDino);
        startCombatState = new StartCombatState();
        cpuTurnCombatState = new CPUTurnCombatState();
        userTurnCombatState = new UserTurnCombatState();
        endCombatState = new EndCombatState();
    }
    public boolean Match(){
        startCombatState.doAction(combat);
        Boolean UserTurn = combat.getUserTurn();
        while (!combat.checkIfFinished()) {
            if (UserTurn) {
                userTurnCombatState.doAction(combat);
            } else {
                cpuTurnCombatState.doAction(combat);
            }
            UserTurn = switchboolean(UserTurn);
        }
        endCombatState.doAction(combat);
        return combat.getMatchResult();
    }
    public boolean switchboolean(Boolean value){
        if(value){
            return false;
        }
        return true;
    }
}
