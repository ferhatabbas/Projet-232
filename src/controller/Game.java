package controller;

import model.*;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alexandre on 2015-07-18.
 */
public class Game extends Subject {

    private String _userName;
    private ArrayList<Dinosaure> _dinos;
    private ArrayList<Log> _logs;
    private Files _gestionnaireFichier;

    public Game() {
        set_dinos(new ArrayList<Dinosaure>());
        set_logs(new ArrayList<Log>());
        _gestionnaireFichier = new Files();
        Attach(_gestionnaireFichier);
    }

    public void initialize(String username)
    {
        set_userName(username);
        get_logs().add(Log.createNewGameLog(username));
    }


    public void loadGameFromXml(String username) throws JDOMException, IOException
    {
        _gestionnaireFichier.readFile(username);
    }

    public void save()
    {
        Notifiy();
    }

    public boolean createDino(String name, String  family){
        Dinosaure d = DinoFactory.construct(Family.valueOf(family));
        d.setName(name);
        try {
            addDino(d);
            get_logs().add(Log.createNewDinoLog(name));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public ArrayList<String> getListOfDinos(){
        ArrayList<String> names = new ArrayList<String>();
        for(Dinosaure d : get_dinos()){
            names.add(d.getName());
        }
        return names;
    }

    public Dinosaure getDino(String name)
    {

        for(Dinosaure d : get_dinos()){
            if (d.getName().equals(name)){
                return d;
            }
        }

        return null;
    }

    private void addDino(Dinosaure dino) throws Exception {

        for(Dinosaure d : get_dinos()){
            if (d.getName() == dino.getName()){
                throw new Exception("There is already a dino named \"" + dino.getName() + "\"");
            }
        }

        get_dinos().add(dino);
    }

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public ArrayList<Dinosaure> get_dinos() {
        return _dinos;
    }

    public void set_dinos(ArrayList<Dinosaure> _dinos) {
        this._dinos = _dinos;
    }

    public ArrayList<Log> get_logs() {
        return _logs;
    }

    public void set_logs(ArrayList<Log> _logs) {
        this._logs = _logs;
    }
}
