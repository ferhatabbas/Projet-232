package model;

/**
 * Created by Patricia on 30 juil. 2015.
 */
public abstract class DecoratorDino extends Dinosaure {
    protected Dinosaure dino;

    public DecoratorDino(Dinosaure dino) {
        this.dino = dino;
    }

    public abstract DinoAction modifyValueAction(DinoAction action);


}
