package controller;

import model.DinoAction;
import model.Dinosaure;
import model.TypeAction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import view.Menu;


/**
 * Created by Philippe on 2015-07-23.
 */
public class Combat  {

    protected ArrayList<Dinosaure> InitialUserDinolist;
    protected ArrayList<Dinosaure> UserDinolist;
    protected ArrayList<Dinosaure> ComputerDinolist;

    protected boolean MatchResult; //User side
    protected boolean UserTurn;

    private CombatState state;

    private Scanner _lecture;

    public void setState(CombatState state){
        this.state = state;
    }

    public CombatState getState(){
        return state;
    }

    public Combat(Scanner lecture, ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){
        _lecture = lecture;
        state = null;
        initCombat(listeDinoUser, listeDino);
        startCombat(UserTurn);
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
        
        boolean userSide = true;
        DinoAction actionChosen = chooseAction(dino);
        Dinosaure target = chooseTarget(ComputerDinolist);
        if (target == null){return;} //ERROR
        ApplyAction(actionChosen, target, userSide);
        showDamageInflicted();
        
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

    public Dinosaure chooseTarget(){
        Dinosaure target;
        return  target = chooseTarget(getComputerDinolist());
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
        
        int health = target.getLifePoint();
        target.setLifePoint(health - valueAplied);
        boolean isTargetAlive = isPositive(target.getLifePoint());
        
        if(userSide){
            if (isTargetAlive){
                AdjustDinolist(getComputerDinolist(), target, userSide);
                showChangeInflicted(target, "Health(Alive)" , health, target.getLifePoint());
                return;
            }
            else {
                target.setLifePoint(0);
                AdjustDinolist(getComputerDinolist(), target, userSide);
                showChangeInflicted(target, "Health(Dead)" , health, target.getLifePoint());
                return;
            }
        }
        else {
            if (isTargetAlive){
                AdjustDinolist(getUserDinolist(), target, userSide);
                showChangeInflicted(target, "Health(Alive)" , health, target.getLifePoint());
                return;
            }
            else {
                target.setLifePoint(0);
                AdjustDinolist(getUserDinolist(), target, userSide);
                showChangeInflicted(target, "Health(Dead)" , health, target.getLifePoint());
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
            showChangeInflicted(target, "Defense" , oldDefense, target.getDefense());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            showChangeInflicted(target, "Defense" , oldDefense, target.getDefense());
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
        FleeAttempt(tryFlee, target, userSide);
    }

    public void ApplyHealthAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldHealth = target.getLifePoint();
        int newHealth = action.getValue();
        
        target.setLifePoint(oldHealth + newHealth);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            showChangeInflicted(target, "Health" , oldHealth, target.getLifePoint());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            showChangeInflicted(target, "Health" , oldHealth, target.getLifePoint());
            return;
        }
    }

    public void ApplySpeedAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldSpeed = target.getSpeed();
        int newSpeed = action.getValue();
        
        target.setSpeed(oldSpeed + newSpeed);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            showChangeInflicted(target, "Speed" , oldSpeed, target.getSpeed());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            showChangeInflicted(target, "Speed" , oldSpeed, target.getSpeed());
            return;
        }
    }

    public void ApplyStrenghtAction(DinoAction action, Dinosaure target, boolean userSide){
        int oldStrength = target.getStrenght();
        int newStrength = action.getValue();

        target.setStrenght(oldStrength + newStrength);
        
        if (userSide){
            AdjustDinolist(getUserDinolist(), target, userSide);
            showChangeInflicted(target, "Strength" , oldStrength, target.getStrenght());
            return;
        }
        else {
            AdjustDinolist(getComputerDinolist(), target, userSide);
            showChangeInflicted(target, "Strength" , oldStrength, target.getStrenght());
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

    private static void startCombat(Boolean userTurn){
        System.out.println("Combat Starting!:");
        WhoHaveTurn(userTurn);
    }

    private static void WhoHaveTurn(Boolean userTurn){
        System.out.println("Determining Who Start First!");
        if(userTurn){
            System.out.println("User Turn! ");
        }
        else {
            System.out.println("Cpu Turn! ");
        }
    }

    public static void showCombatStatus(ArrayList<Dinosaure> userDinolist, ArrayList<Dinosaure> computerDinolist){

        for(int i=0; i< userDinolist.size();i++){
            System.out.println("Name : " + userDinolist.get(i).getName());
            System.out.println("Strenght : " + userDinolist.get(i).getStrenght());
            System.out.println("Speed : " + userDinolist.get(i).getSpeed());
            System.out.println("Defense : " + userDinolist.get(i).getDefense());
        }

        for(int j=0; j< computerDinolist.size();j++){
            System.out.println("Name : " + computerDinolist.get(j).getName());
            System.out.println("Strenght : " + computerDinolist.get(j).getStrenght());
            System.out.println("Speed : " + computerDinolist.get(j).getSpeed());
            System.out.println("Defense : " + computerDinolist.get(j).getDefense());
        }
    }

    private void showDamageInflicted(){
        if(this.getUserTurn()){
            for(int i=0; i< this.getComputerDinolist().size();i++){
                System.out.println("LifePoint : " + this.getComputerDinolist().get(i).getLifePoint());
                System.out.println("Xp : " + this.getComputerDinolist().get(i).getXp());
            }
        }
        else {
            for(int i=0; i< this.getUserDinolist().size();i++){
                System.out.println("LifePoint : " + this.getUserDinolist().get(i).getLifePoint());
                System.out.println("Xp : " + this.getUserDinolist().get(i).getXp());

            }

        }
    }

    private DinoAction chooseAction(Dinosaure dino){

        int chooseAttack;

        System.out.println("Choose the number of your attack: ");
        for(int i=0; i< dino.getActionList().size(); i++){
            System.out.println(i + "- "+ dino.getActionList().get(i).getActionName());

        }
        chooseAttack = _lecture.nextInt();
        _lecture.nextLine();
        _lecture.close();


        return dino.getActionList().get(chooseAttack);
    }

    private Dinosaure chooseTarget(ArrayList<Dinosaure> computerDinolist){
        int chooseTarget;

        System.out.println("Choose a number for your target: ");
        for(int i=0; i< computerDinolist.size(); i++){
            System.out.println(i + "- "+ computerDinolist.get(i).getName());

        }
        chooseTarget = _lecture.nextInt();
        _lecture.nextLine();
        _lecture.close();

        return computerDinolist.get(chooseTarget);
    }

    private void showChangeInflicted(Dinosaure target, String changedValue, int oldValue, int newValue){
        System.out.println("target: "+ target.getName());
        System.out.println("old"+ changedValue + " = " + oldValue);
        System.out.println("new" + changedValue + " = " + newValue);
    }

    private void FleeAttempt(boolean tryFlee, Dinosaure target, boolean userSide){

        if(tryFlee == true){
            if(userSide == true){
                System.out.println("Your dinosaur flew... ");
            }
            else{
                System.out.println(target.getName() +"flew... ");
            }
        }
        else{
            System.out.println("Flee attempt failed ");
        }

    }

}
