package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MAD_SCI3NT1ST on 2015-07-28.
 */
public class AICpu {

    static int typeAlgo;

    final int DEFAULT = 0;
    final int TYPEALGOATTACK = 0;
    final int TYPEALGODEFENSE = 1;
    final int TYPEALGORANDOM = 2;

    public AICpu(TypeAttack typeAttack){
        switch (typeAttack){
            case Fleetype: setTypeAlgo(TYPEALGODEFENSE);
            case Atacktype: setTypeAlgo(TYPEALGOATTACK);
            case Healttype: setTypeAlgo(TYPEALGORANDOM);
            case ImproveDefensetype:  setTypeAlgo(TYPEALGORANDOM);
            case ImproveSpeedtype: setTypeAlgo(TYPEALGORANDOM);
            case ImproveStrenghttype:  setTypeAlgo(TYPEALGORANDOM);
        }
    }

    public static int getTypeAlgo() {
        return typeAlgo;
    }

    public static void setTypeAlgo(int typeAlgo) {
        AICpu.typeAlgo = typeAlgo;
    }

    public Attack GenerateAction(Dinosaure dino){

        switch (typeAlgo){

            case TYPEALGOATTACK: GenerateAction(dino, typeAlgo);
                break;
            case TYPEALGORANDOM: GenerateRANDOMAction( dino );
                break;
        }

        return null;
    }


    public Attack GenerateAction(Dinosaure dino, int typeAlgo){

        TypeAttack typeAttack = getAttackType(typeAlgo);
        ArrayList<Attack> listeAttack = dino.getAttackList();
        for(int i = 0; i < listeAttack.size(); i++){
            if(listeAttack.get(i).getTypeAttack() == typeAttack){
                return listeAttack.get(i);
            }
            else{
                return listeAttack.get(0);
            }

        }
        return null;
    }

    public Attack GenerateRANDOMAction(Dinosaure dino){
        ArrayList<Attack> listeAttack = dino.getAttackList();
        int value = Random(0, listeAttack.size() - 1);
        return listeAttack.get(value);
    }

    public TypeAttack getAttackType(int typeAlgo){

        switch (typeAlgo){
            case TYPEALGOATTACK: return TypeAttack.Atacktype;
            case TYPEALGODEFENSE: return TypeAttack.Fleetype;
        }

        return null;
    }

    public static int Random(int Low, int High){
        Random r = new Random();
        int R = r.nextInt((High - Low) + 1) + Low;
        return R;
    }
}
