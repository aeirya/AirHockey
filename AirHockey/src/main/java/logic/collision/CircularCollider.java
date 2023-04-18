package logic.collision;

import model.Vector;
import model.gameobject.GameObject;
import model.geometric.Circle;

public class CircularCollider extends Collider {
    private final RectangularCollider rect;

    public CircularCollider(GameObject gameObject) {
        super(gameObject);
        rect = new RectangularCollider(gameObject);
    }

    public int getRadius() {
        if (gameObject instanceof Circle circle) {
            return circle.getRadius();
        }
        /* approximation */
        return (gameObject.getX() + gameObject.getY())/2;
    }

    @Override
    public boolean intersects(Collider other) {
        // firs check with a simpler rectangular collider
        if (!rect.intersects(other)) {
            return false;
        }
        if (other instanceof CircularCollider circle) {
            return circle.intersects(this);
        }
        if (other instanceof RectangularCollider rect) {
            return rect.intersects(this);
        }
        return false;
    }

    private boolean intersects(CircularCollider other) {
        return intersectsCircle(other.getCenter(), other.getRadius());
    }

    public boolean intersectsCircle(Vector center, int radius) {
        int radiiSum  = getRadius() + radius;
        double dist = getCenter().dist2(center);
        return radiiSum*radiiSum > dist;
    }
}
