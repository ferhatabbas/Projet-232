package model;

/**
 * Created by Patricia on 30 juil. 2015.
 */
public abstract class DecoratorAction extends Dinosaure {
    protected DinoAction action;

    public DecoratorAction(DinoAction action) {
        this.action = action;
    }

    public abstract DinoAction modifyValueAction();


}
