package model;

/**
 * Created by Alexandre on 2015-07-28.
 */
public abstract class Observer {

    private Subject _subject;

    public abstract void update();

    public Subject get_subject() {
        return _subject;
    }

    public void set_subject(Subject _subject) {
        this._subject = _subject;
    }
}
