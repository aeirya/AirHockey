package model.airhockey;

import model.Circle;
import model.Vector;
import model.airhockey.wall.Wall;

public class Puck extends Circle {
    
    public Puck(Vector vector, Vector velocity, int radius) {
        super(vector, velocity, radius);
    }

    public boolean intersects(Wall wall) {
        return wall.dist2(this) < getRadius2();
    }
}
