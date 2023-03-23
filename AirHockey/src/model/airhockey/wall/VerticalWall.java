package model.airhockey.wall;

import model.GameObject;
import model.Vector;

public class VerticalWall extends Wall {
    public VerticalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(GameObject puck) {
        Vector v = puck.getVelocity();
        puck.setVelocity(-v.getX(), v.getY());
    }

    @Override
    public int dist2(GameObject other) {
        return (other.getPosition().getX() - getPosition().getX())^2;
    }

    @Override
    public Vector getStartPoint() {
        return new Vector(
                getPosition().getX(), getPosition().getY()- getLength()/2
        );
    }

    @Override
    public Vector getEndPoint() {
        return new Vector(
                getPosition().getX(), getPosition().getY() + getLength()/2
        );
    }
}
