package model;

import java.awt.*;
import java.awt.Dimension;

public class Vector {
    private final float x;
    private final float y;

    public Vector(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    /** Squared euclidean distance of two vectors */
    public int dist2(Vector other) {
        return (int) (Math.pow(x - other.x, 2) + Math.pow(y - other.y,2));
    }

    public Vector add(Vector other) {
        return add(other.getX(), other.getY());
    }

    public Vector sub(Vector other) {
        return add(other.multi(-1));
    }

    public Vector abs() {
        return new Vector(Math.abs(x), Math.abs(y));
    }

    public boolean lt(Vector other) {
        return x < other.x && y < other.y;
    }

    /** sub with absolute values */
    public Vector diff(Vector other) {
        return sub(other).abs();
    }

    public Vector add(int dx, int dy) {
        return new Vector(x + dx, y + dy);
    }

    public Vector multi(int a) {
        return new Vector(x*a, y*a);
    }
    public Vector div(int a) {
        return new Vector(x/a, y/a);
    }

    public Vector multi(double a) {
        return new Vector((int) (x*a), (int) (y*a));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /* returns scale * v.direction */
    public Vector direction(double scale) {
        double size = getSize();
        if (size == 0)
            return getZero();
        return new Vector((int)(x*scale/size), (int)(y*scale/size));
    }

    public double getSize() {
        return Math.sqrt(dist2(ZERO));
    }

    public int dot(Vector v) {
        return (int) (x * v.getX() + y * v.getY());
    }

    /**
     * @return the projection of this onto "other" vector
     */
    public Vector project(Vector other) {
        return other.multi(dot(other)).div(other.dist2(ZERO));
    }

    public Vector negate() {
        return this.multi(-1);
    }

    public static Vector getZero(){
        return new Vector(0 , 0);
    }

    public final static Vector ZERO = new Vector(0, 0);
    public final static Vector ONES = new Vector(1, 1);

}
