package model;

import java.util.ArrayList;

/**
 * Created by Alexandre on 2015-07-28.
 */
public abstract class Subject {

    ArrayList<Observer> observers;

    public Subject()
    {
        observers = new ArrayList<Observer>();
    }

    protected void Attach(Observer ob){
        observers.add(ob);
        ob.set_subject(this);
    }

    protected void Detach(Observer ob)
    {
        observers.remove(ob);
    }

    protected void Notifiy()
    {
        for(Observer ob : observers) {
            ob.update();
        }
    }
}
