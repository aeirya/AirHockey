package logic.collision;

import model.gameobject.GameObject;

public class RectangularCollider extends Collider {

    public RectangularCollider(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public boolean intersects(Collider other) {
        if (other instanceof RectangularCollider rect) {
            return rect.intersects(this);
        }
        if (other instanceof CircularCollider circle) {
            return circle.intersects(this);
        }
        return false;
    }

    private boolean intersects(RectangularCollider other) {
        var diff = getCenter().sub(other.getCenter()).abs();
        var sizeSum = getSize().add(other.getSize());
        return diff.multi(2).lt(sizeSum);
    }

    public boolean intersects(CircularCollider other) {
        return other.intersectsCircle(getCenter(), Math.max(getWidth(), getHeight()));
    }
}
