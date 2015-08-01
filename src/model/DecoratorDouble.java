package model;

/**
 * Created by Patricia on 31 juil. 2015.
 */
public class DecoratorDouble extends DecoratorDino {
    public DecoratorDouble(Dinosaure dino) {
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
        // Double la valeur de l'action
        action.setValue(action.getValue() * 2);

        return action;
    }

}
