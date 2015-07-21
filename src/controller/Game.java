package controller;

import model.Dinosaure;
import model.Log;
import java.util.ArrayList;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class Game {

    private String _userName;
    private ArrayList<Dinosaure> _dinos;
    private ArrayList<Log> _logs;

    public Game(){
        _dinos = new ArrayList<Dinosaure>();
        _logs = new ArrayList<Log>();
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        this._userName = userName;
    }

    public Dinosaure getDino(String name)
    {

        for(Dinosaure d : _dinos){
            if (d.getName() == name){
                return d;
            }
        }

        return null;
    }

    public ArrayList<String> getListOfDinos(){
        ArrayList<String> names = new ArrayList<String>();
        for(Dinosaure d : _dinos){
            names.add(d.getName());
        }
        return names;
    }

    public void addDino(Dinosaure dino) throws Exception {

        for(Dinosaure d : _dinos){
            if (d.getName() == dino.getName()){
                throw new Exception("There is already a dino named \"" + dino.getName() + "\"");
            }
        }

        _dinos.add(dino);
    }
}
