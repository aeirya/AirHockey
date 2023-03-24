package model.geometric;

import model.GameObject;
import model.Vector;

/** Circular game object */
public class Circle extends GameObject {
    private final int radius;
    
    protected Circle(Vector position, Vector velocity, int radius) {
        super(position, velocity);
        this.radius = radius;
    }

    public Circle(Vector position, int radius) {
        this(position, new Vector(0, 0), radius);
    }
    
    public int getRadius() {
        return radius;
    }

    public boolean intersects(Circle other) {
        int radiiSum = this.getRadius() + other.getRadius();
        return (radiiSum*radiiSum) < getPosition().dist2(other.getPosition());
    }
}
