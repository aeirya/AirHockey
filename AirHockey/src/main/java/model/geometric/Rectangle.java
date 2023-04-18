package model.geometric;

import model.Dimension;
import model.Vector;
import model.gameobject.GameObject;

public class Rectangle extends GameObject {

    public Rectangle(Vector position) {
        super(position);
    }

    public Rectangle(Vector position, Dimension size) {
        super(position, size);
    }

    public boolean intersects(Circle circle) {
        return new Circle(
                getPosition(),
                (getSize().getWidth()+getSize().getHeight())/2
        ).intersects(circle);
    }

    public boolean isInside(Vector point) {
        return point.getX() > getTopLeft().getX() &&
                point.getX() < getBottomRight().getX() &&
                point.getY() < getBottomRight().getY() &&
                point.getY() > getTopLeft().getY();
    }

    public int getLeftX() {
        return getX() - getSize().getWidth()/2;
    }

    public int getRightX() {
        return getX() + getSize().getWidth()/2;
    }

    public int getTopY() {
        return getY() - getSize().getHeight()/2;
    }

    public int getBottomY() {
        return getY() + getSize().getHeight()/2;
    }
}
