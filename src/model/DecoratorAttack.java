package model;

/**
 * Created by Patricia on 30 juil. 2015.
 */
public class DecoratorAttack extends DecoratorDino {

    public DecoratorAttack(Dinosaure decoratedDino) {
        super(decoratedDino);

    }

    public DinoAction improveAction(DinoAction action) {

        return null;
    }
}
