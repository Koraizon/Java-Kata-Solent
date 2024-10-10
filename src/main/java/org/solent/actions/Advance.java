package org.solent.actions;

import org.solent.Mower;
import org.solent.enums.Instruction;
import org.solent.enums.Orientation;

public class Advance implements Action{
    @Override
    public void execute(Mower mower) {
        //On avance en suivant l'orientation actuelle
        if(mower.getOrientation() == Orientation.N){
            //Si on dépasse la pelouse en montant sur l'axe Y alors on ne bouge pas
            if(mower.getCoordinate().getY() + 1 != mower.getLawn().getCoordinate().getY()){
                mower.getCoordinate().setY(mower.getCoordinate().getY() + 1);
            }
        }
        else if(mower.getOrientation() == Orientation.S){
            //Si on dépasse la pelouse en descendant sur l'axe Y alors on ne bouge pas
            if(mower.getCoordinate().getY() != 0){
                mower.getCoordinate().setY(mower.getCoordinate().getY() - 1);
            }
        }
        else if(mower.getOrientation() == Orientation.E){
            //Si on dépasse la pelouse en montant sur l'axe X alors on ne bouge pas
            if(mower.getCoordinate().getX() + 1 != mower.getLawn().getCoordinate().getX()){
                mower.getCoordinate().setX(mower.getCoordinate().getX() + 1);
            }
        }
        else if(mower.getOrientation() == Orientation.W){
            //Si on dépasse la pelouse en descendant sur l'axe X alors on ne bouge pas
            if(mower.getCoordinate().getX() != 0){
                mower.getCoordinate().setX(mower.getCoordinate().getX() - 1);
            }
        }
    }
}
