package controller;

import model.Dinosaure;

/**
 * Created by Philippe on 2015-07-30.
 */
public class CPUTurnCombatState implements CombatState{

    public void doAction(Combat combat){
        combat.setState(this);
        for(int i = 0; i< combat.getComputerDinolist().size()- 1; i++){
            Dinosaure dino = combat.getComputerDinolist().get(i);
            combat.chooseActionCpu(dino);
        }

        if(combat.getUserDinolist().isEmpty()){

        }
    }

}
