package model;

import java.util.ArrayList;

/**
 * Created by Patricia on 30 juil. 2015.
 */

public class DinoActionList {
    private static ArrayList<DinoAction> list = new ArrayList<DinoAction>();

    public  static ArrayList<DinoAction> getList() {
        // Health
        list.add(new DinoAction("Break", TypeAction.Healttype, 2));
        list.add(new DinoAction("LongBreak", TypeAction.Healttype, 4));

        // Attack
        list.add(new DinoAction("Punch", TypeAction.Atacktype, 1));
        list.add(new DinoAction("Kick", TypeAction.Atacktype, 2));
        list.add(new DinoAction("Double_Punch", TypeAction.Atacktype, 2));
        list.add(new DinoAction("Double_Kick", TypeAction.Atacktype, 4));

        // Flee
        list.add(new DinoAction("Flee", TypeAction.Fleetype, 0));

        // Improve Defense
        list.add(new DinoAction("Block", TypeAction.ImproveDefensetype, 1));
        list.add(new DinoAction("Shield", TypeAction.ImproveDefensetype, 2));

        // Improve Strenght
        list.add(new DinoAction("PowerStrenght", TypeAction.ImproveStrenghttype, 1));

        // Improve Speed
        list.add(new DinoAction("Accelerator", TypeAction.ImproveSpeedtype, 2));

        return list;
    }
}
