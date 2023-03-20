package model;

public class Ball extends GameObject{
    private int radius;
    public Ball(Coordinates coordinates, Coordinates speed) {
        super(coordinates, speed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
