package model;

/**
 * Created by MAD_SCI3NT1ST on 2015-07-23.
 */
public class Attack {

    String attackName;
    TypeAttack typeAttack;
    int value;

    public Attack(String name, TypeAttack typeAttack, int value ){
        setAttackName(name);
        setTypeAttack(typeAttack);
        setValue(value);
    }

    public String getAttackName() {
        return attackName;
    }

    public TypeAttack getTypeAttack() {
        return typeAttack;
    }

    public int getValue() {
        return value;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public void setTypeAttack(TypeAttack typeAttack) {
        this.typeAttack = typeAttack;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
