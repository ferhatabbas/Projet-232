package model;

/**
 * Created by Patricia on 31 juil. 2015.
 */
public class DecoratorDouble extends DecoratorAction {
    public DecoratorDouble(DinoAction action) {
        super(action);

    }

    public DinoAction modifyValueAction() {
        // Double la valeur de l'action
        action.setValue(action.getValue() * 2);

        return action;
    }

}
