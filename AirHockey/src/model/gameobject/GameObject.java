package model.gameobject;

import model.Vector;

// TODO: use vector values between zero and one and scale them to screen size
public class GameObject {
    private Vector position; //up left

    protected GameObject(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void onCollide(GameObject other) {}

    public void onExit(GameObject other) {}

    public boolean intersects(GameObject other) {
        return false;
    }
}
