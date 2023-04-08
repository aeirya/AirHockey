package model.airhockey.wall;

import model.airhockey.Mallet;
import model.gameobject.GameObject;
import model.Vector;
import model.airhockey.Puck;
import model.gameobject.MovableGameObject;
import model.geometric.Circle;

public abstract class Wall extends GameObject {
    private final int length;
    private int width;

    protected Wall(Vector position, int length) {
        super(position);
        this.length = length;
        width = 18;
    }

    @Override
    public void onCollide(GameObject go) {
        if (go instanceof Puck) {
            bounce((MovableGameObject) go);
        }
        if (go instanceof Mallet) {
            System.out.println("just collided a mallet");
            ((Mallet) go).halt();
            pushAway((MovableGameObject) go);
        }
    }

    protected abstract void bounce(MovableGameObject other);

    public abstract void pushAway(MovableGameObject go);

    public abstract long dist(GameObject other);

    public int getLength() {
        return length;
    }

    public int getWidth() { return width; }

    public abstract Vector getStartPoint();

    public abstract Vector getEndPoint();

    @Override
    public boolean intersects(GameObject other) {
        if (other instanceof Circle) {
            return intersects((Circle) other);
        }
        return super.intersects(other);
    }

    public boolean intersects(Circle circle) {
        return circle.intersects(this);
    }

    public Wall setWidth(int width) {
        this.width = width;
        return this;
    }
}
