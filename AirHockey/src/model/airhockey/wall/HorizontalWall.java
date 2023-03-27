package model.airhockey.wall;

import model.airhockey.Puck;
import model.gameobject.GameObject;
import model.Vector;
import model.gameobject.MovableGameObject;

public class HorizontalWall extends Wall {
    public HorizontalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(MovableGameObject go) {
        Vector v = go.getVelocity();
        go.setVelocity(v.getX(), -v.getY());
    }

    @Override
    public long dist(GameObject other) {
        return Math.abs(other.getPosition().getY() - getPosition().getY());
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
