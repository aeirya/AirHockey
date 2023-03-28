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
//        setVelocity(getVelocity().multi(-1));
        bounce(mallet);
    }

    private void bounce(Mallet mallet) {
        Vector malletToPuck = getPosition().sub(mallet.getPosition());
        Vector projection = mallet.getVelocity().project(malletToPuck);
        Vector normal = mallet.getVelocity().sub(projection);
        mallet.setVelocity(projection.negate().add(normal));
    }
}
