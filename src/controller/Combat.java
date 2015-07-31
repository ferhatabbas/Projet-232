package controller;

import model.DinoAction;
import model.Dinosaure;
import model.TypeAction;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Philippe on 2015-07-23.
 */
public class Combat{

    protected ArrayList<Dinosaure> InitialUserDinolist;
    protected ArrayList<Dinosaure> UserDinolist;
    protected ArrayList<Dinosaure> ComputerDinolist;

    protected boolean MatchResult; //User side
    protected boolean UserTurn;

    private CombatState state;

    public void setState(CombatState state){
        this.state = state;
    }

    public CombatState getState(){
        return state;
    }

    public Combat(ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){
        state = null;
        initCombat(listeDinoUser, listeDino);
        view.Menu.startCombat(UserTurn);
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
        boolean userSide = false;
        DinoAction action = dino.GenerateAction();
        if (action == null){return;} //ERROR
        Dinosaure target = GenerateTarget();
        if (target == null){return;} //ERROR
        ApplyAction(action, target, userSide);
    }

    public void chooseActionUser(Dinosaure dino){
        /*
        boolean userSide = true;
        DinoAction actionChosen = ChooseActionDino(dino);
        Dinosaure target = ChooseTarget(actionChosen);
        if (target == null){return;} //ERROR
        ApplyAction(actionChosen, target, userSide);
        view.Menu.ShowDamageInflicted();
        */
    }

    public Dinosaure GenerateTarget(){
        ArrayList<Dinosaure> list = getUserDinolist();
        for(int i = 0; i < getUserDinolist().size() -1 ; i++){
            if(getUserDinolist().get(i) != null){
                return getUserDinolist().get(i);
            }
        }
        return null; //ERROR
    }
    /*
    public DinoAction ChooseAction(Dinosaure dino){
        //DinoAction actionChosen;
        //return  actionChosen = view.Menu.ChooseAction(dino.getActionList());
    }

    public Dinosaure ChooseTarget(){
        //Dinosaure target;
        //return  target = view.Menu.ChooseTarget(getComputerDinolist());
    }
    */
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
        
        int health = target.getLifePoint();
        target.setLifePoint(health - valueAplied);
        boolean isTargetAlive = isPositive(target.getLifePoint());
        
        if(userSide){
            if (isTargetAlive){
                AdjustDinolist(getComputerDinolist(), target, userSide);
                view.Menu.ShowChangeInflicted(target, "Health(Alive)" , health, target.getLifePoint());
                return;
            }
            else {
                target.setLifePoint(0);
                AdjustDinolist(getComputerDinolist(), target, userSide);
                view.Menu.ShowChangeInflicted(target, "Health(Dead)" , health, target.getLifePoint());
                return;
            }
        }
        else {
            if (isTargetAlive){
                AdjustDinolist(getUserDinolist(), target, userSide);
                view.Menu.ShowChangeInflicted(target, "Health(Alive)" , health, target.getLifePoint());
                return;
            }
            else {
                target.setLifePoint(0);
                AdjustDinolist(getUserDinolist(), target, userSide);
                view.Menu.ShowChangeInflicted(target, "Health(Dead)" , health, target.getLifePoint());
                return;
            }
        }
    }

    public void ApplyDefenseAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldDefense = target.getDefense();
        int newDefense = action.getValue();
        
        target.setDefense(oldDefense + newDefense);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Defense" , oldDefense, target.getDefense());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Defense" , oldDefense, target.getDefense());
            return;
        }
    }

    public void ApplyFleeAction(DinoAction action, Dinosaure target, boolean userSide){

        boolean canFlee = getComputerDinolist().size() <= 1;
        boolean tryFlee = getRandomBoolean(1);
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
        //view.Menu.FleeAttempt(tryFlee, target, userSide);
    }

    public void ApplyHealthAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldHealth = target.getLifePoint();
        int newHealth = action.getValue();
        
        target.setLifePoint(oldHealth + newHealth);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Health" , oldHealth, target.getLifePoint());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Health" , oldHealth, target.getLifePoint());
            return;
        }
    }

    public void ApplySpeedAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldSpeed = target.getSpeed();
        int newSpeed = action.getValue();
        
        target.setSpeed(oldSpeed + newSpeed);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Speed" , oldSpeed, target.getSpeed());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Speed" , oldSpeed, target.getSpeed());
            return;
        }
    }

    public void ApplyStrenghtAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldStrength = target.getStrenght();
        int newStrength = action.getValue();

        target.setStrenght(oldStrength + newStrength);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Strength" , oldStrength, target.getStrenght());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            view.Menu.ShowChangeInflicted(target, "Strength" , oldStrength, target.getStrenght());
            return;
        }
    }

    public void AdjustDinolist(ArrayList<Dinosaure> targetList, Dinosaure dino, boolean isuser){

        int index;
        if (isuser){
            index = getUserDinolist().indexOf(dino);

        }else{
            index = getComputerDinolist().indexOf(dino);
        }

        targetList.remove(index);
        targetList.add(index, dino);
    }

    public boolean isPositive(int value){
        if (value >= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getRandomBoolean(int p)
    {
        Random random = new Random();
        return random.nextInt() < p;
    }

    public CombatState GetUserTurnCombatState(){
        return state;
    }

}
