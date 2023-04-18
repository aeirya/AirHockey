package model.airhockey.wall;

import model.Dimension;
import model.airhockey.Mallet;
import model.gameobject.GameObject;
import model.Vector;
import model.gameobject.MovableGameObject;

public class HorizontalWall extends Wall {
    public HorizontalWall(Vector position, int length) {
        super(position, new Dimension(length, Wall.WIDTH));
    }

    @Override
    protected void bounce(MovableGameObject go) {
        Vector v = go.getVelocity();
        go.setVelocity(v.getX(), -v.getY());
    }

    public void pushAway(MovableGameObject go) {
        if (go instanceof Mallet mal) {
            mal.halt();
            int y = getY() + ((mal.getY() < getY()) ? -mal.getRadius()-1 : +mal.getRadius()+1);
            mal.setPosition(mal.getX(), y);
        }
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
