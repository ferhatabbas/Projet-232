package model;

/**
 * Created by Patricia on 31 juil. 2015.
 */
public class DecoratorIncrease extends DecoratorDino {
    public DecoratorIncrease(Dinosaure dino) {
        super(dino);
    }

    @Override
    public DinoAction getAttack(String actionName) {
        if(Dinosaure.Random(0,1) == 0 && super.getAttack(actionName).getTypeAction() != TypeAction.Fleetype)
        {
            return modifyValueAction(super.getAttack(actionName));
        }
        else {
            return super.getAttack(actionName);
        }
    }

    public DinoAction modifyValueAction(DinoAction action) {
        // Augmente la valeur de l'action
        action.setValue(action.getValue() + Dinosaure.Random(0, 2));

        return action;
    }
}
