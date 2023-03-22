package model.airhockey.wall;

import model.GameObject;
import model.Vector;

public class HorizontalWall extends Wall {
    @Override
    public void bounce(GameObject other) {
        Vector v = other.getVelocity();
        other.setVelocity(v.getX(), -v.getY());
    }

    @Override
    public int dist2(GameObject other) {
//        return other.getPosition().getY() - ;
        return 0;
    }
}
