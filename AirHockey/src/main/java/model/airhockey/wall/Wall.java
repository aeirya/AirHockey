package model.airhockey.wall;

import logic.collision.CircularCollider;
import logic.collision.RectangularCollider;
import model.Dimension;
import model.airhockey.Mallet;
import model.gameobject.GameObject;
import model.Vector;
import model.airhockey.Puck;
import model.gameobject.MovableGameObject;
import model.geometric.Circle;

import java.awt.*;

public abstract class Wall extends GameObject {
    protected static final int WIDTH = 18;
    private final int length;
    private int width;

    protected Wall(Vector position, int length) {
        super(position);
        this.length = length;
        width = 8;
        setColor(Color.GRAY);
    }

    protected Wall(Vector center, Dimension dimension) {
        super(center, dimension);
        length = Math.max(dimension.getWidth(), dimension.getHeight());
        width = Math.min(dimension.getWidth(), dimension.getHeight());
        setColor(Color.gray);
    }

    @Override
    public void onCollide(GameObject go) {
        if (go instanceof Puck puck) {
            onCollide(puck);
        }
        if (go instanceof Mallet mal) {
            onCollide(mal);
        }
    }

    protected void onCollide(Mallet mallet) {
        pushAway(mallet);
    }

    protected void onCollide(Puck puck) {
        pushAway(puck);
        bounce(puck);
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
//            return new RectangularCollider(this).intersects(new CircularCollider(other));
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
