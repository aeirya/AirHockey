package model.airhockey.wall;

import model.GameObject;
import model.Vector;

public abstract class Wall extends GameObject {
    private Vector startPoint;
    private Vector endPoint;

    public abstract void bounce(GameObject other);

    public Vector getStartPoint() {
        return startPoint;
    }

    public Vector getEndPoint() {
        return endPoint;
    }

    public abstract int dist2(GameObject other);
}
