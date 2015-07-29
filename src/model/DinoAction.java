package model;

/**
 * Created by MAD_SCI3NT1ST on 2015-07-23.
 */
public class DinoAction {

    String attackName;
    TypeAttack typeAttack;
    int value;

    public DinoAction(String name, TypeAttack typeAttack, int value){
        setActionName(name);
        setActionAttack(typeAttack);
        setValue(value);
    }

    public String getActionName() {
        return attackName;
    }

    public TypeAttack getActionAttack() {
        return typeAttack;
    }

    public int getValue() {
        return value;
    }

    public void setActionName(String attackName) {
        this.attackName = attackName;
    }

    public void setActionAttack(TypeAttack typeAttack) {
        this.typeAttack = typeAttack;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
