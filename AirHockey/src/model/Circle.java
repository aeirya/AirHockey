package model;

/** Circular game object */
public class Circle extends GameObject {
    private int radius;
    
    protected Circle(Vector position, Vector velocity) {
        super(position, velocity);
    }

    protected Circle(Vector position) {
        super(position);
    }
    
    public int getRadius() {
        return radius;
    }

    public boolean intersects(Circle other) {
        int radiiSum = this.getRadius() + other.getRadius();
        return (radiiSum*radiiSum) < getPosition().dist2(other.getPosition());
    }
}
