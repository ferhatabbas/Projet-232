package model;

import java.util.Date;

/**
 * Created by Alexandre on 2015-07-21.
 */
public class Log {

    private static final int TYPE_CREATION_GAME = 0;
    private static final int TYPE_CREATION_DINOSAURE = 1;

    private Date _date;
    private int _type;
    private String _value;

    public static Log createNewDinoLog(String value){
        return new Log(TYPE_CREATION_DINOSAURE, value);
    }
    public static Log createNewGameLog(String value) {return  new Log(TYPE_CREATION_GAME, value);}
    public static Log createEmptyLog() {return new Log(0, "");}

    private Log (int type, String value)
    {
        set_date(new Date());
        set_type(type);
        set_value(value);
    }

    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }
}
