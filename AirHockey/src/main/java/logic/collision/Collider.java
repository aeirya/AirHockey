package logic.collision;

import model.Dimension;
import model.Vector;
import model.gameobject.GameObject;
import model.gameobject.MovableGameObject;

public abstract class Collider {
    protected final GameObject gameObject;

    public Collider(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public abstract boolean intersects(Collider other);

    protected Dimension getSize() {
        return gameObject.getSize();
    }

    protected int getWidth() {
        return getSize().getWidth();
    }

    protected int getHeight() {
        return getSize().getHeight();
    }

    protected Vector getCenter() {
        return gameObject.getPosition();
    }
}
