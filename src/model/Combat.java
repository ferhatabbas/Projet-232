package model;

import java.util.ArrayList;

/**
 * Created by Philippe on 2015-07-23.
 */
public class Combat {

    protected ArrayList<Dinosaure> UserDinolist;
    protected ArrayList<Dinosaure> ComputerDinolist;
    protected ArrayList<AICpu> computerAIList;

    public ArrayList<Dinosaure> getUserDinolist() {
        return UserDinolist;
    }

    public void setUserDinolist(ArrayList<Dinosaure> userDinolist) {
        UserDinolist = userDinolist;
    }

    public ArrayList<Dinosaure> getComputerDinolist() {
        return ComputerDinolist;
    }

    public void setComputerDinolist(ArrayList<Dinosaure> computerDinolist) {
        ComputerDinolist = computerDinolist;
    }


    public ArrayList<AICpu> getComputerAIList() {
        return computerAIList;
    }

    public void setComputerAIList(ArrayList<AICpu> computerAIList) {
        this.computerAIList = computerAIList;
    }

    public Attack generateAttackForACpuDino(int positionArraylistDino){

        AICpu Ai = computerAIList.get(positionArraylistDino);
        Dinosaure dino = ComputerDinolist.get(positionArraylistDino);
        Attack attack = Ai.GenerateAction(dino);
        return attack;
    }
}
