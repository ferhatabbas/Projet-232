package model;

/**
 * Created by Patricia on 30 juil. 2015.
 */
public abstract class DecoratorDino extends Dinosaure {
    protected Dinosaure decoratedDino;

    public DecoratorDino(Dinosaure decoratedDino) {
        this.decoratedDino = decoratedDino;
    }

    public abstract DinoAction improveAction(DinoAction action);


}
