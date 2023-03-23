package model.airhockey.wall;

import model.GameObject;
import model.Vector;
import model.airhockey.Puck;

public abstract class Wall extends GameObject {
    private final int length;
    private final int width;

    protected Wall(Vector position, int length) {
        super(position);
        this.length = length;
        width = 18;
    }

    @Override
    public void onColide(GameObject go) {
        if (go instanceof Puck) {
            bounce(go);
        }
    }

    protected abstract void bounce(GameObject other);

    public abstract long dist(GameObject other);

    public int getLength() {
        return length;
    }

    public int getWidth() { return width; }

    public abstract Vector getStartPoint();

    public abstract Vector getEndPoint();

    public boolean intersects(Puck puck) {
        return puck.intersects(this);
    }
}
