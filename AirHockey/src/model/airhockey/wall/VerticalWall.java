package model.airhockey.wall;

import model.airhockey.Mallet;
import model.gameobject.GameObject;
import model.Vector;
import model.gameobject.MovableGameObject;
import model.geometric.Circle;

public class VerticalWall extends Wall {
    public VerticalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(MovableGameObject puck) {
        Vector v = puck.getVelocity();
        puck.setVelocity(-v.getX(), v.getY());
//        pushAway(puck);
    }

    public void pushAway(MovableGameObject go) {
        if (!(go instanceof Circle)) return;
        int r = ((Circle) go).getRadius();
        int x = getX() - r - 1;
        if (getX() < go.getX()) {
            x = getX() + r + 1;
        }
        go.setPosition(x, go.getY());
    }

    @Override
    public long dist(GameObject other) {
        return Math.abs(other.getPosition().getX() - getPosition().getX());
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
