package model.airhockey.wall;

import model.airhockey.Mallet;
import model.airhockey.Puck;
import model.gameobject.GameObject;
import model.Vector;
import model.gameobject.MovableGameObject;

public class VerticalWall extends Wall {
    public VerticalWall(Vector position, int length) {
        super(position, length);
    }

    @Override
    protected void bounce(MovableGameObject puck) {
        Vector v = puck.getVelocity();
        puck.setVelocity(-v.getX(), v.getY());
    }

    public void pushAway(MovableGameObject go) {
        if (go instanceof Mallet mal) {
            mal.halt();
            if (mal.getX() < getX()) {
                mal.setPosition(new Vector(getX() - mal.getRadius(), mal.getY()));
            } else {
                mal.setPosition(new Vector(getX() + mal.getRadius() + 1, mal.getY()));
            }
        }
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

    @Override
    protected void onCollide(Puck puck) {
        super.onCollide(puck);
    }
}
