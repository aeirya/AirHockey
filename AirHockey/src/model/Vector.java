package model;

public class Vector {
    private int x;
    private int y;

    public Vector(int x , int y) {
        this.x = x;
        this.y = y;
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

    public Vector add(int dx, int dy) {
        return new Vector(x + dx, y + dy);
    }

    public Vector multi(int a) {
        return new Vector(x*a, y*a);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Vector ZERO = new Vector(0, 0);
}
