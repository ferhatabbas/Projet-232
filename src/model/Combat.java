package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Philippe on 2015-07-23.
 */
public class Combat {

    protected ArrayList<Dinosaure> InitialUserDinolist;
    protected ArrayList<Dinosaure> UserDinolist;
    protected ArrayList<Dinosaure> ComputerDinolist;
    protected ArrayList<Dinosaure> userGraveyard;
    protected ArrayList<Dinosaure> computerGraveyard;

    protected boolean MatchResult; //User side
    protected boolean UserTurn;

    public Combat(ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){

        initCombat(listeDinoUser, listeDino);
        setUserTurn(isUserturn());
        MatchResult = StartCombat(UserTurn);
    }

    public boolean StartCombat(boolean userTurn){

        boolean isNotfinish = true;
        boolean userIsWinner;
        while (isNotfinish){

            if (userTurn){
                for(int i = 0; i< UserDinolist.size()- 1; i++){
                    Dinosaure dino = ComputerDinolist.get(i);
                    chooseActionUser(dino);
                    isNotfinish = checkIfFinished();
                }
                userTurn = false;
            }
            else {
                for(int i = 0; i< ComputerDinolist.size()- 1; i++){
                    Dinosaure dino = ComputerDinolist.get(i);
                    chooseActionCpu(dino);
                    isNotfinish = checkIfFinished();
                }
                userTurn = true;
            }
        }
        userIsWinner = checkIfUserWinner();
        return userIsWinner;
    }

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

    public ArrayList<Dinosaure> getInitialUserDinolist() {
        return InitialUserDinolist;
    }

    public void setInitialUserDinolist(ArrayList<Dinosaure> initialUserDinolist) {
        InitialUserDinolist = initialUserDinolist;
    }

    public ArrayList<Dinosaure> getUserGraveyard() {
        return userGraveyard;
    }

    public void setUserGraveyard(ArrayList<Dinosaure> userGraveyard) {
        this.userGraveyard = userGraveyard;
    }

    public ArrayList<Dinosaure> getComputerGraveyard() {
        return computerGraveyard;
    }

    public void setComputerGraveyard(ArrayList<Dinosaure> computerGraveyard) {
        this.computerGraveyard = computerGraveyard;
    }

    public boolean getMatchResult() {
        return MatchResult;
    }

    public void setMatchResult(boolean matchResult) {
        MatchResult = matchResult;
    }

    public boolean getUserTurn() {
        return UserTurn;
    }

    public void setUserTurn(boolean userTurn) {
        UserTurn = userTurn;
    }

    public void initCombat(ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){
        loadUserDino(listeDinoUser);
        loadBotDino(listeDino);
    }

    public void loadUserDino(ArrayList<Dinosaure> listeDino){
        setComputerDinolist(listeDino);
        setInitialUserDinolist(listeDino);
    }

    public void loadBotDino(ArrayList<Dinosaure> listeDino){
        setComputerDinolist(listeDino);
    }

    public boolean isUserturn() {
        return getRandomBoolean();
    }

    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean checkIfFinished(){
        if(UserDinolist.isEmpty()){
            return true;
        }
        else if(ComputerDinolist.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkIfUserWinner(){
        if(UserDinolist.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    public void chooseActionCpu(Dinosaure dino){
       DinoAction action = dino.GenerateAction();
    }

    public void chooseActionUser(Dinosaure dino){
        boolean userSide = true;
        //DinoAction actionChosen = ChooseActionDino(dino.getActionList());
        //Dinosaure target = ChooseTarget(actionChosen);
        //ApplyAction(actionChosen, target, userSide);
    }

    public void ApplyAction(DinoAction action, Dinosaure target, Boolean userSide){
        TypeAction type = action.getTypeAction();

        switch (type){
            case Atacktype: ApplyAttackAction(action, target, userSide); break;
            case ImproveDefensetype: ApplyDefenseAction(action, target, userSide); break;
            case Fleetype: ApplyFleeAction(action, target, userSide); break;
            case Healttype: ApplyHealthAction(action, target, userSide); break;
            case ImproveSpeedtype: ApplySpeedAction(action, target, userSide); break;
            case ImproveStrenghttype: ApplyStrenghtAction(action, target, userSide); break;
        }
    }

    public void ApplyAttackAction(DinoAction action, Dinosaure target, boolean userSide){
        int valueAplied = target.getDefense() - action.getValue();
        boolean sign = isPositive(valueAplied);
        if (sign) {
            //NOT ENOUGH STRONG
            return;
        }

        target.setLifePoint(target.getLifePoint() + valueAplied);
        boolean isTargetAlive = isPositive(target.getLifePoint());

        if(userSide){
            if (isTargetAlive){
                AdjustDinolist(getComputerDinolist(), target);
                return;
            }
            else {
                AdjustGraveyardlist(getComputerDinolist(), target, userSide);
                return;
            }
        }
        else {
            if (isTargetAlive){
                AdjustDinolist(getUserDinolist(), target);
                return;
            }
            else {
                AdjustGraveyardlist(getUserDinolist(), target, userSide);
                return;
            }
        }
    }

    public void ApplyDefenseAction(DinoAction action, Dinosaure target, boolean userSide){
        target.setDefense(target.getDefense() + action.getValue());
        if (userSide){
            AdjustDinolist(getUserDinolist(), target);
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target);
            return;
        }
    }

    public void ApplyFleeAction(DinoAction action, Dinosaure target, boolean userSide){

        boolean canFlee =getComputerDinolist().size() <= 1;
        boolean tryFlee = getRandomBoolean( 35 );
        if (userSide){
            if(tryFlee){
                //WIN
                setMatchResult(false);
            }
            else {
                //FAILED
                return;
            }
        }
        else {
            if(tryFlee){
                //WIN
                setMatchResult(true);
            }
            else {
                //FAILED
                return;
            }
        }
    }

    public void ApplyHealthAction(DinoAction action, Dinosaure target, boolean userSide){
        target.setLifePoint(target.getSpeed() + action.getValue());
        if (userSide){
            AdjustDinolist(getUserDinolist(), target);
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target);
            return;
        }
    }

    public void ApplySpeedAction(DinoAction action, Dinosaure target, boolean userSide){
        target.setSpeed(target.getSpeed() + action.getValue());
        if (userSide){
            AdjustDinolist(getUserDinolist(), target);
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target);
            return;
        }
    }

    public void ApplyStrenghtAction(DinoAction action, Dinosaure target, boolean userSide){
        target.setStrenght(target.getSpeed() + action.getValue());
        if (userSide){
            AdjustDinolist(getUserDinolist(), target);
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target);
            return;
        }
    }

    public void AdjustDinolist(ArrayList<Dinosaure> targetList, Dinosaure dino){
            int index = getComputerDinolist().indexOf(dino);
            targetList.remove(index);
            targetList.add(index, dino);

    }

    public void AdjustGraveyardlist(ArrayList<Dinosaure> targetList, Dinosaure dino, boolean isUserSide){
        if (isUserSide){
            int index = getComputerDinolist().indexOf(dino);
            targetList.remove(index);
            getComputerGraveyard().add(index, dino);
        }
        else{
            int index = getUserDinolist().indexOf(dino);
            targetList.remove(index);
            getUserGraveyard().add(index, dino);
        }
    }

    public boolean isPositive(int value){
        if (value >= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getRandomBoolean(double trueProp) {
        Random rnd = new Random();
        return rnd.nextDouble() < trueProp;
    }

}
