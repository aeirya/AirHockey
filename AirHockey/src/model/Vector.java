package model;

import java.awt.*;
import java.awt.Dimension;

public class Vector {
    private int x;
    private int y;

    public Vector(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public Vector direction() {
        int size = getSize();
        return new Vector(x/size, y/size);
    }

    public int getSize() {
        return (int) Math.sqrt(Math.pow(getX(),2) + Math.pow(getY(), 2));
    }

    public int dot(Vector v) {
        return getX() * v.getX() + getY() * v.getY();
    }

    /**
     * @return the projection of this onto "other" vector
     */
    public Vector project(Vector other) {
        return other.direction().multi(dot(other));
    }

    public Vector negate() {
        return this.multi(-1);
    }

    public static Vector ZERO = new Vector(0, 0);
}
