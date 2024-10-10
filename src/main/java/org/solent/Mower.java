package org.solent;

import org.solent.enums.Instruction;
import org.solent.enums.Orientation;

public class Mower {

    //On construit une tondeuse en lui donnant ses coordonées et son orientation initiale
    public Mower(Coordinate initialCoordinate, Orientation initialOrientation, Lawn lawn) {
        this.coordinate = initialCoordinate;
        this.orientation = initialOrientation;
        this.lawn = lawn;
    }

    private final Coordinate coordinate;

    private Orientation orientation;

    private final Lawn lawn;


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Lawn getLawn() {
        return lawn;
    }

    //On effectue une action selon l'instruction donnée en entrée
    public void Action(Instruction instruction) {
        if (instruction == Instruction.A){
            switch (getOrientation()){
                //On avance en suivant l'orientation actuelle
                case N :
                    //Si on dépasse la pelouse en montant sur l'axe Y alors on ne bouge pas
                    if(getCoordinate().getY() + 1 != getLawn().getCoordinate().getY()){
                        getCoordinate().setY(getCoordinate().getY() + 1);
                    }
                    break;
                case S:
                    //Si on dépasse la pelouse en descendant sur l'axe Y alors on ne bouge pas
                    if(getCoordinate().getY() != 0){
                        getCoordinate().setY(getCoordinate().getY() - 1);
                    }
                    break;
                case E:
                    //Si on dépasse la pelouse en montant sur l'axe X alors on ne bouge pas
                    if(getCoordinate().getX() + 1 != getLawn().getCoordinate().getX()){
                        getCoordinate().setX(getCoordinate().getX() + 1);
                    }
                    break;
                case W:
                    //Si on dépasse la pelouse en descendant sur l'axe X alors on ne bouge pas
                    if(getCoordinate().getX() != 0){
                        getCoordinate().setX(getCoordinate().getX() - 1);
                    }
                    break;
                default:
                    break;
            }
        } else if (instruction == Instruction.D) {
            //On change l'orientation de 90° vers la droite
            switch (getOrientation()){
                case N :
                    setOrientation(Orientation.E);
                    break;
                case S:
                    setOrientation(Orientation.W);
                    break;
                case E:
                    setOrientation(Orientation.S);
                    break;
                case W:
                    setOrientation(Orientation.N);
                    break;
                default:
                    break;
            }
        } else if (instruction == Instruction.G) {
            //On change l'orientation de 90° vers la gauche
            switch (getOrientation()){
                case N :
                    setOrientation(Orientation.W);
                    break;
                case S:
                    setOrientation(Orientation.E);
                    break;
                case E:
                    setOrientation(Orientation.N);
                    break;
                case W:
                    setOrientation(Orientation.S);
                    break;
                default:
                    break;
            }
        }
    }

    //On renvoie la position actuelle de la tondeuse
    public String getPosition() {
        return getCoordinate().getX() + " " + getCoordinate().getY() + " " + getOrientation().toString();
    }
}
