package model.airhockey;

import model.gameobject.GameObject;
import model.geometric.Circle;
import model.Vector;

public class Puck extends Circle {

    public Puck(Vector vector, Vector velocity, int radius) {
        super(vector, velocity, radius);
    }

    @Override
    public void onCollide(GameObject other) {
        if (other instanceof Mallet) {
            onCollide((Mallet) other);
        }
        super.onCollide(other);
    }

    private void onCollide(Mallet mallet) {
        setVelocity(getVelocity().multi(-1));
    }
}
