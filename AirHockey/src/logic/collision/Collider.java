package logic.collision;

import model.Vector;
import model.gameobject.GameObject;
import model.gameobject.MovableGameObject;

public abstract class Collider {
    private final GameObject gameObject;
    private Vector offset;

    public Collider(GameObject gameObject) {
        this.gameObject = gameObject;
        offset = Vector.ZERO;
    }

    public Collider(GameObject gameObject, Vector offset) {
        this.gameObject = gameObject;
        this.offset = offset;
    }

    public abstract void intersects(Collider other);

    public void willCollide(Collider other, double dt) {
        offset = getOffset(dt);
    }

    protected Vector getSize() {
        return gameObject.getSize();
    }

    protected Vector getPosition() {
        return gameObject.getPosition();
    }

    protected Vector getOffset(double dt) {
        if (gameObject instanceof MovableGameObject go) {
            return go.getVelocity().multi(dt);
        }
        return Vector.getZero();
    }
}
