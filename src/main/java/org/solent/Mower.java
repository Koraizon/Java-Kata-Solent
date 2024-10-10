package org.solent;

import org.solent.actions.Action;
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

    private Action action;


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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    //On execute l'action voulue
    public void executeAction() {
        action.execute(this);
    }

    //On renvoie la position actuelle de la tondeuse
    public String getPosition() {
        return getCoordinate().getX() + " " + getCoordinate().getY() + " " + getOrientation().toString();
    }
}
