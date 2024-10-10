package org.solent.actions;

import org.solent.Mower;
import org.solent.enums.Instruction;
import org.solent.enums.Orientation;

public class Left implements Action{
    @Override
    public void execute(Mower mower) {
        //On change l'orientation de 90° vers la gauche
        if(mower.getOrientation() == Orientation.N){
            mower.setOrientation(Orientation.W);
        }
        else if(mower.getOrientation() == Orientation.S){
            mower.setOrientation(Orientation.E);
        }
        else if(mower.getOrientation() == Orientation.E){
            mower.setOrientation(Orientation.N);
        }
        else if(mower.getOrientation() == Orientation.W){
            mower.setOrientation(Orientation.S);
        }
    }
}
