package model.geometric;

import model.Vector;
import model.airhockey.wall.Wall;
import model.gameobject.GameObject;
import model.gameobject.MovableGameObject;
import util.Math;

/** Circular game object */
public class Circle extends MovableGameObject {
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

    @Override
    public boolean intersects(GameObject other) {
        if (other instanceof Circle) {
            return intersects((Circle) other);
        }
        if (other instanceof Wall) {
            return intersects((Wall) other);
        }
        return super.intersects(other);
    }

    public boolean intersects(Circle other) {
        int radiiSum = this.getRadius() + other.getRadius();
        int dist = getPosition().dist2(other.getPosition());
        if (java.lang.Math.pow(radiiSum, 2) > dist) {
        System.out.println("R2 = " + radiiSum);
        System.out.println("dist = " + dist);
        System.out.println();
        }
        return (radiiSum*radiiSum) > dist;
    }

    public boolean intersects(Wall wall) {
        return wall.dist(this) + Math.EPSILON <= this.getRadius();
    }
}
