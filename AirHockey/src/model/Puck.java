package model;

public class Puck extends GameObject{
    private int radius;
    public Puck(Vector vector, Vector speed) {
        super(vector, speed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
