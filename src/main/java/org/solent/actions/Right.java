package org.solent.actions;

import org.solent.Mower;
import org.solent.enums.Instruction;
import org.solent.enums.Orientation;

public class Right implements Action {
    @Override
    public void execute(Mower mower) {
        //On change l'orientation de 90° vers la droite
        if(mower.getOrientation() == Orientation.N){
            mower.setOrientation(Orientation.E);
        }
        else if(mower.getOrientation() == Orientation.S){
            mower.setOrientation(Orientation.W);
        }
        else if(mower.getOrientation() == Orientation.E){
            mower.setOrientation(Orientation.S);
        }
        else if(mower.getOrientation() == Orientation.W){
            mower.setOrientation(Orientation.N);
        }
    }
}
