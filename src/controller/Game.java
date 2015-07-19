package controller;

import model.Dinosaure;
import java.util.ArrayList;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class Game {

    private String _userName;
    private ArrayList<Dinosaure> _dinos;

    public Game(){
        _dinos = new ArrayList<Dinosaure>();
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        this._userName = userName;
    }

    public Dinosaure getDino(String name)
    {
        return _dinos.stream().filter(d -> d.getName() == name).findFirst().get();
    }

    public void addDino(Dinosaure dino) throws Exception {
        if (_dinos.stream().filter(d -> d.getName() == dino.getName()).count() == 0) {
            _dinos.add(dino);
        }else{
            throw new Exception("There is already a dino named \"" + dino.getName() + "\"");
        }
    }
}
