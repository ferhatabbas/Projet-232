package model;

/**
 * Created by Patricia on 31 juil. 2015.
 */
public class DecoratorIncrease extends DecoratorAction {
    public DecoratorIncrease(DinoAction action) {
        super(action);

    }

    public DinoAction modifyValueAction() {
        // Augmente la valeur de l'action
        action.setValue(action.getValue() - Dinosaure.Random(0, 2));

        return action;
    }
}
