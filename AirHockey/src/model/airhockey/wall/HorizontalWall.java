package model.airhockey.wall;

import model.gameobject.GameObject;
import model.Vector;
import model.gameobject.MovableGameObject;
import model.geometric.Circle;
import util.MathConst;

public class HorizontalWall extends Wall {
    public HorizontalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(MovableGameObject go) {
        Vector v = go.getVelocity();
        go.setVelocity(v.getX(), -v.getY());
        pushAway(go);
    }

    public void pushAway(MovableGameObject go) {
        if (!(go instanceof Circle)) return;
        int r = ((Circle) go).getRadius();
        int y = getY() - r - 1;
        if (getY() < go.getY()) {
            y = getY() + r - 1;
        }
        go.setPosition(go.getX(), y);
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
