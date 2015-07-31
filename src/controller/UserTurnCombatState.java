package controller;

import model.Dinosaure;

/**
 * Created by Philippe on 2015-07-30.
 */
public class UserTurnCombatState implements CombatState{

    public void doAction(Combat combat){
        //view.Menu.ShowCombatStatus(getUserDinolist(), getComputerDinolist());
        combat.setState(this);
        for(int i = 0; i< combat.getUserDinolist().size()- 1; i++){
            Dinosaure dino = combat.getUserDinolist().get(i);
            combat.chooseActionUser(dino);
        }
    }

    //TEST
}
