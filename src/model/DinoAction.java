package model;

/**
 * Created by MAD_SCI3NT1ST on 2015-07-23.
 */
public class DinoAction {

    String attackName;
    TypeAction typeAttack;
    int value;

    public DinoAction(String name, TypeAction typeAttack, int value){
        setActionName(name);
        setActionAttack(typeAttack);
        setValue(value);
    }

    public String getActionName() {
        return attackName;
    }

    public TypeAction getActionAttack() {
        return typeAttack;
    }

    public int getValue() {
        return value;
    }

    public void setActionName(String attackName) {
        this.attackName = attackName;
    }

    public void setActionAttack(TypeAction typeAttack) {
        this.typeAttack = typeAttack;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
