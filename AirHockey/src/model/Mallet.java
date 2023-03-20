package model;

public class Mallet extends GameObject{
    private int radius;
    public Mallet(Vector vector, Vector speed) {
        super(vector, speed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
