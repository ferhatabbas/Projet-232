package model;

/**
 * Created by Patricia on 30 juil. 2015.
 */
public class DecoratorDecrease extends DecoratorAction {

    public DecoratorDecrease(DinoAction action) {
        super(action);

    }

    public DinoAction modifyValueAction() {
        // Diminue la valeur de l'action
        action.setValue(action.getValue() - Dinosaure.Random(0, 2));

        return action;
    }
}
