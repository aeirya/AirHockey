package model;

public class DoubleVector {
    private double x;
    private double y;

    public DoubleVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DoubleVector(Vector vector) {
        this(vector.getX(), vector.getY());
    }
}
