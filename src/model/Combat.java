package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Philippe on 2015-07-23.
 */
public class Combat {

    protected ArrayList<Dinosaure> UserDinolist;
    protected ArrayList<Dinosaure> ComputerDinolist;
    protected ArrayList<Dinosaure> userGraveyard;
    protected ArrayList<Dinosaure> computerGraveyard;

    public Combat(ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){

        Boolean UserTurn;
        Boolean MatchResult; //User side

        initCombat(listeDinoUser, listeDino);
        UserTurn = isUserturn();
        MatchResult = StartCombat(UserTurn);
    }

    public boolean StartCombat(boolean userTurn){

        Boolean isNotfinish = true;
        Boolean userIsWinner;
        while (isNotfinish){
            if (userTurn){
                for(int i = 0; i< UserDinolist.size()- 1; i++){
                    chooseActionUser();
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

    public void initCombat(ArrayList<Dinosaure> listeDinoUser, ArrayList<Dinosaure> listeDino){
        loadUserDino(listeDinoUser);
        loadBotDino(listeDino);
    }

    public void loadUserDino(ArrayList<Dinosaure> listeDino){
        setComputerDinolist(listeDino);
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
        dino.GenerateAction();
    }
    public void chooseActionUser(){

    }


}
