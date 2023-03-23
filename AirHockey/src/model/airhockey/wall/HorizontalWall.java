package model.airhockey.wall;

import model.GameObject;
import model.Vector;

public class HorizontalWall extends Wall {
    public HorizontalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(GameObject puck) {
        Vector v = puck.getVelocity();
        puck.setVelocity(v.getX(), -v.getY());
    }

    @Override
    public int dist2(GameObject other) {
        return (other.getPosition().getY() - getPosition().getY())^2;
    }

    @Override
    public Vector getStartPoint() {
        return new Vector(
                getPosition().getX() - getLength()/2, getPosition().getY()
        );
    }

    @Override
    public Vector getEndPoint() {
        return new Vector(
                getPosition().getX() + getLength()/2, getPosition().getY()
        );
    }
}