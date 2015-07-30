package controller;

/**
 * Created by Philippe on 2015-07-30.
 */
public class EndCombatState implements CombatState{

    public void doAction(Combat combat){
        combat.setState(this);
        Boolean userIsWinner = combat.checkIfUserWinner();
        combat.setMatchResult(userIsWinner);
    }

}
