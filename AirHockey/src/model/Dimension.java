package model;

public class Dimension extends Vector {
    public Dimension(Vector vector) {
        this(vector.getX(), vector.getY());
    }

    public Dimension(int x, int y) {
        super(x, y);
    }

    public int getWidth() {
        return getX();
    }

    public int getHeight() {
        return getY();
    }
}
