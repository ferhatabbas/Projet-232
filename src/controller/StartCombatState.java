package controller;

import model.Dinosaure;

import java.util.Random;

/**
 * Created by Philippe on 2015-07-30.
 */
public class StartCombatState implements CombatState{

    public void doAction(Combat combat){
        combat.setState(this);
        combat.setUserTurn(combat.isUserturn());
    }
}

