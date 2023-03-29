package model.geometric;

import model.Vector;
import model.gameobject.GameObject;

public class Rectangle extends GameObject {

    public Rectangle(Vector position) {
        super(position);
    }

    public Rectangle(Vector position, Vector size) {
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
}
