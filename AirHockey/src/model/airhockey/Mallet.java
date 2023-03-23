package model.airhockey;

import model.Circle;
import model.Vector;

public class Mallet extends Circle {

    public Mallet(Vector vector, int radius) {
        super(vector, radius);
    }

    public void onColide(Puck puck) {
        System.out.println("hitting a puck with a mallet");
        puck.setVelocity(
                puck.getVelocity().add(this.getVelocity().mult(2))
        );
    }

    @Override
    public void move(double dt) {
        super.move(dt);
    }
}
