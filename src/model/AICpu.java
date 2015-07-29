package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Philippe on 2015-07-28.
 */
public interface AICpu {

    final int DEFAULT = 0;
    final int TYPEALGOATTACK = 0;
    final int TYPEALGODEFENSE = 1;
    final int TYPEALGORANDOM = 2;

    public int getTypeAlgo();

    public void setTypeAlgo(int typeAlgo);

    public DinoAction GenerateAction();

    public DinoAction GenerateSpecificAction();

    public DinoAction GenerateRANDOMAction();

    public TypeAction getAttackType(int typeAlgo);

}